package com.filip.gunmarket;

import android.graphics.Color;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Input;
import com.filip.androidgames.framework.Screen;

import java.util.List;

/**
 * Created by Tech on 11/17/2015.
 */
public class Inventory extends Screen {
    public Inventory(Game game) {
        super(game);
    }
    int backgroundX = 1280;
    boolean back = false;

    @Override
    public void update(float deltaTime)
    {
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

            g.drawPixmap(Assets.backgroundFrame, backgroundX, 0, 0, 0, 1280, 720);
            g.drawPixmap(Assets.helpBackground, backgroundX+25, 25, 0, 0, 1230, 670);
            g.drawPixmap(Assets.helpTextFrame, backgroundX+340,60, 0, 0 , 600, 400);
            g.drawText("Inventory", backgroundX + 640, 130, Color.GREEN, 50);
            g.drawText("Invertory item1 info", backgroundX + 640, 180, Color.WHITE, 25);
            g.drawText("Invertory item2 info",backgroundX+640, 230, Color.WHITE, 25);
            g.drawText("Invertory item3 info", backgroundX + 640, 280, Color.WHITE, 25);
            g.drawText("Invertory item4 info", backgroundX + 640, 330, Color.WHITE, 25);
            g.drawText("Invertory item5 info", backgroundX + 640, 380, Color.WHITE, 25);
            g.drawPixmap(Assets.buttonBackground, 1080, 620, 0, 0, 200, 60);
            g.drawText("Return", 1180, 650, Color.GREEN, 50);
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
            else
            {
                game.setScreen(new WorldScreen(game));
            }
            g.drawPixmap(Assets.worldMap, backgroundX, 0, 0, 0 , 1280, 720);
            //g.drawPixmap(Assets.menuBackground, backgroundX + 25, 25, 0, 0, 1230, 670);
        }



    }

    public void buttonCollider() {
        Graphics g = game.getGraphics();
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++)
        {
            Input.TouchEvent event = touchEvents.get(i);
            if(event.type == Input.TouchEvent.TOUCH_UP)
            {
                //Help
                if(inBounds(event, 1080, 620,200, 60))
                {
                    //Log.i("InvScreen","Inv Press");
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
