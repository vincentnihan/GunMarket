package com.filip.gunmarket;

import com.filip.androidgames.framework.Screen;
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

/**
 * Created by Administrator on 2015/11/17.
 */
public class CreditScreen extends Screen {
    public CreditScreen(Game game) {
        super(game);
    }

    int backgroundY = -720;
    int titleHeight = 0;
    int speed = 50;
    boolean back = false;
    @Override
    public void update(float deltaTime) {
        buttonCollider();
    }

    public void drawBackground()
    {
        Graphics g = game.getGraphics();
        if(back == false) {
            if (backgroundY < 0) {
                backgroundY += speed;
                if (backgroundY > 0) {
                    backgroundY = 0;
                }
            }
            if (titleHeight < 620)
            {
                titleHeight += 50;
                if (titleHeight > 620)
                {
                    titleHeight = 620;
                }
            }
            g.drawPixmap(Assets.backgroundFrame, 0, backgroundY, 0, 0 , 1280, 720);
            g.drawPixmap(Assets.creditBackground, 25, backgroundY + 25, 0, 0, 1230, 670);

        }
        else
        {
            backgroundY -= speed;
            if(backgroundY <-720)
            {
                backgroundY = -720;
            }
            if (titleHeight > -100) {
                titleHeight -= 50;
                if(titleHeight <-100)
                {
                    titleHeight = -100;
                }
            }
            else
            {
                game.setScreen(new MainMenuScreen(game));
            }
            g.drawPixmap(Assets.backgroundFrame, 0, backgroundY, 0, 0 , 1280, 720);
            g.drawPixmap(Assets.menuBackground, 25, backgroundY + 25, 0, 0, 1230, 670);
        }
        g.drawPixmap(Assets.topicBackground, 440, titleHeight, 0, 0, 400, 100);
        g.drawText("Bringer of Peace", 440 + 200, titleHeight + 50, Color.GREEN, 50);
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
                //Help
                if(inBounds(event, 440, titleHeight, 400, 100))
                {
                    //Log.i("HelpScreen","Help Press");
                    backgroundY = 720;
                    back = true;
                    return;
                }
            }
        }
    }


    @Override
    public void present(float deltaTime) {
        drawBackground();
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
