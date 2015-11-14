package com.filip.gunmarket;


import android.graphics.Color;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Input.TouchEvent;
import com.filip.androidgames.framework.Screen;
import java.util.List;
import java.lang.Object;

public class MainMenuScreen extends Screen{
    public MainMenuScreen(Game game) {
        super(game);
    }
    int color;

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.backButton, 0, 0);
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
