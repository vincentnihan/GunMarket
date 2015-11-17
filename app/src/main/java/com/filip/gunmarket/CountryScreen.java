package com.filip.gunmarket;

import android.graphics.Color;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Screen;

/**
 * Created by Erdem on 2015-11-16.
 */
public class CountryScreen extends Screen {
    public CountryScreen(Game game) {
        super(game);
    }

    public  void update(float deltaTime){

    }
    public  void present(float deltaTime){
        Graphics g = game.getGraphics();
        g.drawRect(0, 0, 1280, 720, Color.DKGRAY);

        g.drawText("REGION NAME", 640, 75, Color.YELLOW, 70);
        g.drawText("Connections: 0%", 640, 105, Color.WHITE, 30);

    }
    public  void pause(){

    }
    public  void resume(){

    }
    public  void dispose(){

    }
}
