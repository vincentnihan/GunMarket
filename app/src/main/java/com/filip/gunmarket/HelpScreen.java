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
public class HelpScreen extends Screen {
    public HelpScreen(Game game) {
        super(game);
    }

    int backgroundX = 1280;
    int helpX = 1080;
    boolean back = false;

    @Override
    public void update(float deltaTime) {
        buttonCollider();
    }

    public void drawBackground()
    {
        Graphics g = game.getGraphics();
        if(back == false) {
            if (backgroundX > 0) {
                if(backgroundX - 50 < 0) {
                    backgroundX = 0;
                }
                else
                    backgroundX -= 50;
            }
            if (helpX > 0) {
                if (helpX - 50< 0) {
                    helpX = 0;
                }
                else
                    helpX -= 50;
            }

            g.drawPixmap(Assets.backgroundFrame, backgroundX, 0, 0, 0, 1280, 720);
            g.drawPixmap(Assets.helpBackground, backgroundX+25, 25, 0, 0, 1230, 670);
            g.drawPixmap(Assets.helpTextFrame, backgroundX+340,60, 0, 0 , 600, 400);
            g.drawText("Help Title", backgroundX + 640, 130, Color.GREEN, 50);
            g.drawText("Help info",backgroundX+640, 180, Color.WHITE, 25);
            g.drawText("Help info",backgroundX+640, 230, Color.WHITE, 25);
            g.drawText("Help info", backgroundX + 640, 280, Color.WHITE, 25);
            g.drawText("Help info", backgroundX + 640, 330, Color.WHITE, 25);
            g.drawText("Help info", backgroundX + 640, 380, Color.WHITE, 25);
        }
        else
        {
            if(backgroundX < 1280) {
                if (backgroundX + 50 > 1280) {
                    backgroundX = 1280;
                }
                else
                    backgroundX += 50;
            }
            if (helpX <1280) {
                if(helpX + 50> 1280) {
                    helpX = 1280;
                }
                else
                    helpX += 50;

            }
            else
            {
                game.setScreen(new MainMenuScreen(game));
            }
            g.drawPixmap(Assets.backgroundFrame, backgroundX, 0, 0, 0 , 1280, 720);
            g.drawPixmap(Assets.menuBackground, backgroundX + 25, 25, 0, 0, 1230, 670);
        }
        g.drawPixmap(Assets.buttonBackground, helpX, 520, 0, 0, 200, 100);
        g.drawText("Help", helpX + 100, 520 + 50, Color.GREEN, 50);

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
                if(inBounds(event, helpX, 520, 200, 100))
                {
                    //Log.i("HelpScreen","Help Press");
                    backgroundX = -1280;
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
