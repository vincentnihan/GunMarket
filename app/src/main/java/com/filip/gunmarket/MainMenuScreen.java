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
    int titleHeight = 720;
    int startButtonX = -200;
    int helpButtonX = 1280;
    int speed = 10;
    @Override
    public void update(float deltaTime) {
        buttonCollider();
        drawButton(deltaTime);
    }

    @Override
    public void present(float deltaTime) {
        //drawBackground();
        //drawButton();
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
        g.drawRect(0, 0, 720, 1280,Color.GREEN);
    }
    public void drawButton(float deltaTime)
    {
        Graphics g = game.getGraphics();
        if(buttonStage == 0)
        {
            if(titleHeight > 600) {
                titleHeight -= speed* deltaTime;
            }
            if(startButtonX < 0) {
                startButtonX+= speed* deltaTime;
            }
            if(helpButtonX > 1080) {
                helpButtonX-= speed * deltaTime;
            }
            g.drawRect(200, startButtonX, 100, 200, Color.RED);
            g.drawRect(200, helpButtonX, 100, 200, Color.YELLOW);
            g.drawRect(titleHeight, 440, 100, 400, Color.BLACK);
        }
        else if(buttonStage == 1)
        {

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
                if(inBounds(event,600, 440, 100, 400))
                {
                   // Log.i("MainMenu","Credit Press");
                    buttonStage = 3;
                    return;
                }
                //New Game
                if(inBounds(event, 200, 0, 100, 200))
                {
                   // Log.i("MainMenu","Start Press");
                    buttonStage = 1;
                    return;
                }
                //Help
                if(inBounds(event, 200, 1080, 100, 200))
                {
                    //Log.i("MainMenu","Help Press");
                    buttonStage = 2;
                    return;
                }
            }
        }
    }
}
