package com.filip.gunmarket;

import android.graphics.Color;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Input;
import com.filip.androidgames.framework.Screen;

import java.util.List;

/**
 * Created by Erdem on 2015-12-06.
 */
public class SellScreen extends Screen {

    GameManager myManager;

    public SellScreen(Game game) {
        super(game);
        myManager = game.getManager();
    }


    int rowLeft = 100;

    int rowUp = 220;

    public void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if (inBounds(event, 1280 - 128, 720 - 128, 128, 128)) {
                    game.setScreen(new WorldScreen(game));
                }
                if (inBounds(event, rowLeft+950, rowUp+80, 100, 50)){
                    
                }
            }
        }

    }

    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawRect(0, 0, 1280, 720, Color.DKGRAY);

        g.drawText(myManager.currentRegionName(), 640, 75, Color.GREEN, 70);
        g.drawText("Connections: 0%", 640, 105, Color.WHITE, 30);

        g.drawText("TRADE TYPE", rowLeft, rowUp, Color.GREEN, 35);
        g.drawText("Handgun", rowLeft, rowUp + 80, Color.WHITE, 30);
        g.drawText("Long gun", rowLeft, rowUp + 160, Color.WHITE, 30);
        g.drawText("Explosives", rowLeft, rowUp+240, Color.WHITE, 30);

        g.drawText("Wanted Amnt", rowLeft+250, rowUp, Color.GREEN, 35);
        g.drawText("0", rowLeft+250, rowUp + 80, Color.WHITE, 30);
        g.drawText("0", rowLeft+250, rowUp + 160, Color.WHITE, 30);
        g.drawText("0", rowLeft+250, rowUp+240, Color.WHITE, 30);

        g.drawText("Inventory", rowLeft+500, rowUp, Color.GREEN, 35);
        g.drawText(String.valueOf(myManager.getHandGuns()), rowLeft+500, rowUp + 80, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getLongGuns()), rowLeft+500, rowUp + 160, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getExplosives()), rowLeft+500, rowUp+240, Color.WHITE, 30);

        g.drawText("Price", rowLeft + 750, rowUp, Color.GREEN, 35);
        g.drawText(String.valueOf(myManager.getHandGunBuyPrice(false)), rowLeft+750, rowUp + 80, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getLongGunPrice(false)), rowLeft+750, rowUp + 160, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getExplosivePrice(false)), rowLeft+750, rowUp+240, Color.WHITE, 30);

        g.drawText("SELL", rowLeft+1050, rowUp + 80, Color.YELLOW, 30);
        g.drawText("SELL", rowLeft+1050, rowUp + 160, Color.YELLOW, 30);
        g.drawText("SELL", rowLeft+1050, rowUp+240, Color.YELLOW, 30);


        g.drawPixmap(Assets.backButton, 1280 - 128, 720 - 128);
    }





    public  void pause(){

    }
    public  void resume(){

    }
    public  void dispose(){

    }


}
