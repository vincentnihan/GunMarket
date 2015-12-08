package com.filip.gunmarket;

import android.graphics.Color;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Input;
import com.filip.androidgames.framework.Screen;

import java.util.List;
import java.util.Random;

/**
 * Created by Erdem on 2015-12-06.
 */
public class SellScreen extends Screen {

    GameManager myManager;

    int handGunDemand = 0;
    int longGunDemand = 0;
    int explosiveDemand = 0;

    int regionNum = 1;
    float connections = 0;

    Random rand = new Random();

    public SellScreen(Game game) {
        super(game);
        myManager = game.getManager();

        regionNum = myManager.getCurrentRegion();
        connections = myManager.getConnectionByNum(regionNum);

        handGunDemand = (int)(connections * rand.nextInt(10)+5);
        if (connections>0.2)
            longGunDemand = (int)((connections-0.2) * rand.nextInt(10)+2);

        if (connections>0.4)
            explosiveDemand = (int)((connections-0.4)*rand.nextInt(10)+1);
    }


    int rowLeft = 100;

    int rowUp = 200;

    int rowP =105;

    void sellHandGun(){
        if(handGunDemand>0 && myManager.getHandGuns()>0){
            myManager.sellHandGun();
            handGunDemand--;
        }
    }
    void sellLongGun(){
        if (longGunDemand>0 && myManager.getLongGuns()>0){
            myManager.sellLongGun();
            longGunDemand--;
        }
    }
    void sellExplosives(){
        if (explosiveDemand>0 && myManager.getExplosives()>0){
            myManager.sellExplosives();
            explosiveDemand--;
        }
    }

    public void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if (inBounds(event, 1280 - 128, 720 - 128, 128, 128)) {
                    game.setScreen(new WorldScreen(game));
                }
                if (inBounds(event,rowLeft+950, rowUp+(rowP-40),200, 80)){
                    sellHandGun();
                }
                if (inBounds(event,rowLeft+950, rowUp+(rowP*2)-40,200, 80)){
                    sellLongGun();
                }
                if (inBounds(event,rowLeft+950, rowUp+(rowP*3)-40,200, 80)){
                    sellExplosives();
                }
            }
        }

    }

    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawRect(0, 0, 1280, 720, Color.DKGRAY);

        g.drawText(myManager.currentRegionName(), 640, 75, Color.GREEN, 70);
        g.drawText("Connections: "+String.valueOf((int)(myManager.getConnectionByNum(regionNum)*100))+"%", 640, 105, Color.WHITE, 30);


        g.drawText("TRADE TYPE", rowLeft, rowUp, Color.GREEN, 35);
        g.drawText("Handgun", rowLeft, rowUp + rowP, Color.WHITE, 30);
        g.drawText("Long gun", rowLeft, rowUp + rowP*2, Color.WHITE, 30);
        g.drawText("Explosives", rowLeft, rowUp+rowP*3, Color.WHITE, 30);

        g.drawText("Demand", rowLeft+250, rowUp, Color.GREEN, 35);
        g.drawText(String.valueOf(handGunDemand), rowLeft+250, rowUp + rowP, Color.WHITE, 30);
        g.drawText(String.valueOf(longGunDemand), rowLeft+250, rowUp + rowP*2, Color.WHITE, 30);
        g.drawText(String.valueOf(explosiveDemand), rowLeft+250, rowUp+rowP*3, Color.WHITE, 30);

        g.drawText("Inventory", rowLeft+500, rowUp, Color.GREEN, 35);
        g.drawText(String.valueOf(myManager.getHandGuns()), rowLeft+500, rowUp + rowP, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getLongGuns()), rowLeft+500, rowUp + rowP*2, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getExplosives()), rowLeft+500, rowUp+rowP*3, Color.WHITE, 30);

        g.drawText("Price", rowLeft + 750, rowUp, Color.GREEN, 35);
        g.drawText(String.valueOf(myManager.getHandGunPrice(false)), rowLeft+750, rowUp + rowP, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getLongGunPrice(false)), rowLeft+750, rowUp + rowP*2, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getExplosivePrice(false)), rowLeft+750, rowUp+rowP*3, Color.WHITE, 30);

        g.drawText("SELL", rowLeft+1050, rowUp + rowP, Color.YELLOW, 30);
        g.drawText("SELL", rowLeft+1050, rowUp + rowP*2, Color.YELLOW, 30);
        g.drawText("SELL", rowLeft+1050, rowUp+rowP*3, Color.YELLOW, 30);


        g.drawPixmap(Assets.backButton, 1280 - 128, 720 - 128);
    }





    public  void pause(){

    }
    public  void resume(){

    }
    public  void dispose(){

    }


}
