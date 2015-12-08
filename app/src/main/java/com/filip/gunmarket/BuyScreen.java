package com.filip.gunmarket;

import android.graphics.Color;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Input;
import com.filip.androidgames.framework.Screen;

import java.util.List;
import java.util.Random;

/**
 * Created by Erdem on 2015-11-17.
 */
public class BuyScreen extends Screen {
    GameManager myManager;
    int handGunOffer = 0;
    int longGunOffer = 0;
    int explosiveOffer = 0;

    int regionNum = 1;
    float connections = 0;

    Random rand = new Random();

    public BuyScreen(Game game) {
        super(game);
        myManager = game.getManager();
        Assets.bubblePop.play(1);
        regionNum = myManager.getCurrentRegion();
        connections = myManager.getConnectionByNum(regionNum);

        handGunOffer = (int)(connections * rand.nextInt(10)+5);
        if (connections>0.3)
        longGunOffer = (int)((connections-0.3) * rand.nextInt(10)+5);

        if (connections>0.5)
            explosiveOffer = (int)((connections-0.5)*rand.nextInt(10)+5);



    }


    void buyHandGun(){
        if (handGunOffer>0 && myManager.getMoney() >= myManager.getHandGunPrice(true)){
            myManager.buyHandGun();
            handGunOffer--;
        }
    }
    void buyLongGun(){
        if (longGunOffer>0 && myManager.getMoney() >= myManager.getLongGunPrice(true)){
            myManager.buyLongGun();
            longGunOffer--;
        }
    }
    void buyExplosives(){
        if (explosiveOffer>0 && myManager.getMoney() >= myManager.getExplosivePrice(true)){
            myManager.buyExplosives();;
            explosiveOffer--;
        }
    }

    int rowLeft = 100;
    int rowP = 105;
    int rowUp = 200;

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
                    buyHandGun();
                }
                if (inBounds(event,rowLeft+950, rowUp+(rowP*2)-40,200, 80)){
                    buyLongGun();
                }
                if (inBounds(event,rowLeft+950, rowUp+(rowP*3)-40,200, 80)){
                    buyExplosives();
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

        g.drawText("Offered Amnt", rowLeft+250, rowUp, Color.GREEN, 35);
        g.drawText(String.valueOf(handGunOffer), rowLeft+250, rowUp + rowP, Color.WHITE, 30);
        g.drawText(String.valueOf(longGunOffer), rowLeft+250, rowUp + rowP*2, Color.WHITE, 30);
        g.drawText(String.valueOf(explosiveOffer), rowLeft+250, rowUp+rowP*3, Color.WHITE, 30);

        g.drawText("Inventory", rowLeft+500, rowUp, Color.GREEN, 35);
        g.drawText(String.valueOf(myManager.getHandGuns()), rowLeft+500, rowUp + rowP, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getLongGuns()), rowLeft+500, rowUp + rowP*2, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getExplosives()), rowLeft+500, rowUp+rowP*3, Color.WHITE, 30);

        g.drawText("Price", rowLeft + 750, rowUp, Color.GREEN, 35);
        g.drawText(String.valueOf(myManager.getHandGunPrice(true)), rowLeft+750, rowUp + rowP, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getLongGunPrice(true)), rowLeft+750, rowUp + rowP*2, Color.WHITE, 30);
        g.drawText(String.valueOf(myManager.getExplosivePrice(true)), rowLeft+750, rowUp+rowP*3, Color.WHITE, 30);

        g.drawText("BUY", rowLeft+1050, rowUp + rowP, Color.YELLOW, 30);
        g.drawText("BUY", rowLeft+1050, rowUp + rowP*2, Color.YELLOW, 30);
        g.drawText("BUY", rowLeft+1050, rowUp+rowP*3, Color.YELLOW, 30);


        g.drawPixmap(Assets.backButton, 1280 - 128, 720 - 128);
    }





    public  void pause(){

    }
    public  void resume(){

    }
    public  void dispose(){

    }
}
