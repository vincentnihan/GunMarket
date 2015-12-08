package com.filip.gunmarket;


import android.graphics.Color;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Input.TouchEvent;
import com.filip.androidgames.framework.Screen;
import java.util.List;
import java.lang.Object;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import java.util.ArrayList;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Pixmap;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
    }
    int buttonStage = 0;
    int titleHeight = -100;
    int startButtonX = -200;
    int helpButtonX = 1280;
    int speed = 50;
    int backgroundX = -1280;
    @Override
    public void update(float deltaTime) {
        buttonCollider();
    }

    @Override
    public void present(float deltaTime) {
        drawBackground();
        drawButton(deltaTime);
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

    public void drawBackground()
    {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.backgroundFrame, 0, 0, 0, 0 , 1280, 720);
        g.drawPixmap(Assets.menuBackground, 25, 25, 0, 0, 1230, 670);
    }
    public void drawButton(float deltaTime)
    {
        if(buttonStage == 0) {
            Graphics g = game.getGraphics();
            if (titleHeight < 0) {
                titleHeight += speed ;
            }
            if (startButtonX < 0) {
                startButtonX += speed ;
            }
            if (helpButtonX > 1080) {
                helpButtonX -= speed ;
            }
            g.drawPixmap(Assets.buttonBackground, startButtonX, 520, 0, 0, 200, 100);
            g.drawText("Start", startButtonX + 100, 520 + 50, Color.GREEN, 50);
            g.drawPixmap(Assets.buttonBackground, helpButtonX, 520, 0, 0, 200, 100);
            g.drawText("Help", helpButtonX + 100, 520 + 50, Color.GREEN, 50);
            g.drawPixmap(Assets.topicBackground, 440, titleHeight, 0, 0, 400, 100);
            g.drawText("Bringer of Peace", 440 + 200, titleHeight + 50, Color.GREEN, 50);
        }
        else if(buttonStage == 1)
        {
            Graphics g = game.getGraphics();
            if (startButtonX < 1280) {
                startButtonX += speed ;
            }
            if(backgroundX< 0)
            {
                if(backgroundX + speed > 0) {
                    backgroundX = 0;
                    // ERDEM - new turn at the start of the game
                    game.getManager().newTurn();
                    game.setScreen(new WorldScreen(game));
                }
                 else
                {
                    backgroundX += speed ;
                }

            }
            g.drawPixmap(Assets.worldMap, backgroundX, 0);
            g.drawPixmap(Assets.buttonBackground, startButtonX, 520, 0, 0, 200, 100);
            g.drawText("Start", startButtonX + 100, 520 + 50, Color.GREEN, 50);

        }
    }
    public void buttonCollider() {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++)
        {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP)
            {
                //Credit
                if(inBounds(event,440, titleHeight, 400, 100))
                {
                   // Log.i("MainMenu","Credit Press");
                    //game.setScreen(new CreditScreen(game));
                    game.setScreen(new WinLoseScreen(game, 2));
                    return;
                }
                //New Game
                if(inBounds(event,startButtonX, 520, 200, 100))
                {
                   // Log.i("MainMenu","Start Press");
                    buttonStage = 1;
                    Assets.menuSlide.play(1);
                    return;
                }
                //Help
                if(inBounds(event, helpButtonX, 520, 200, 100))
                {
                    //Log.i("MainMenu","Help Press");
                    game.setScreen(new HelpScreen(game));
                    return;
                }
            }
        }
    }
}
