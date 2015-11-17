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
        g.drawRect(0, 0, 1280, 720,Color.GREEN);
    }
    public void drawButton(float deltaTime)
    {
        Graphics g = game.getGraphics();
        if(buttonStage == 0)
        {
            if(titleHeight < 0) {
                titleHeight += speed;
            }
            if(startButtonX < 0) {
                startButtonX+= speed;
            }
            if(helpButtonX > 1080) {
                helpButtonX-= speed;
            }
            g.drawRect(startButtonX, 520, 200, 100, Color.RED);
            g.drawRect(helpButtonX, 520, 200, 100, Color.YELLOW);
            g.drawRect(440, titleHeight, 400, 100, Color.BLACK);
        }
        else if(buttonStage == 1)
        {
            game.setScreen(new WorldScreen(game));
        }
        else if(buttonStage == 2) {
            game.setScreen(new HelpScreen(game));
        }
        else if(buttonStage == 3)
        {
            game.setScreen(new CreditScreen(game));

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
                    buttonStage = 3;
                    return;
                }
                //New Game
                if(inBounds(event,startButtonX, 520, 200, 100))
                {
                   // Log.i("MainMenu","Start Press");
                    buttonStage = 1;
                    return;
                }
                //Help
                if(inBounds(event, helpButtonX, 520, 200, 100))
                {
                    //Log.i("MainMenu","Help Press");
                    buttonStage = 2;
                    return;
                }
            }
        }
    }
}
