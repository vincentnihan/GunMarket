package com.filip.gunmarket;

import android.graphics.Color;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Input;
import com.filip.androidgames.framework.Screen;

import java.util.List;

/**
 * Created by Erdem on 2015-11-16.
 */
public class RegionScreen extends Screen {
    GameManager myManager;
    int regionNum = 1;
    public RegionScreen(Game game) {
        super(game);
        myManager = game.getManager();
        regionNum = myManager.getCurrentRegion();
    }

    int rowLeft = 100;
    int rowP = 65;
    int rowUp = 200;


    public  void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if (inBounds(event, 1280-128, 720-128, 128, 128)) {
                    game.setScreen(new WorldScreen(game));
                }
                if (inBounds(event,rowLeft+950, rowUp+(rowP-50),200, 100)) {
                    myManager.investHawk();
                }
                if (inBounds(event,rowLeft+950, rowUp+(rowP*3)-50,200, 100)){
                    myManager.investDove();
                }
            }
        }
    }
    public  void present(float deltaTime){
        Graphics g = game.getGraphics();

        g.drawRect(0, 0, 1280, 720, Color.DKGRAY);


        g.drawText(myManager.currentRegionName(), 640, 75, Color.GREEN, 70);
        g.drawText("Connections: " + String.valueOf((int) (myManager.getConnectionByNum(regionNum) * 100)) + "%", 640, 105, Color.WHITE, 30);

        g.drawText("HAWK Politics", rowLeft, rowUp + rowP, Color.GREEN, 30);
        g.drawText("DOVE Politics", rowLeft, rowUp + rowP*3, Color.GREEN, 30);



        g.drawText("$10K and 3 Influence pt for 15% connection", rowLeft + 500, rowUp + rowP, Color.WHITE, 30);
        g.drawText("$10K and 3 Influence pt for -3% Doomsday counter", rowLeft+500, rowUp + rowP*3, Color.WHITE, 30);


        g.drawText("INVEST", rowLeft+1050, rowUp + rowP, Color.YELLOW, 30);
        g.drawText("INVEST", rowLeft+1050, rowUp + rowP*3, Color.YELLOW, 30);


        g.drawTextL("Influence: "+String.valueOf(myManager.getInfluencePoints()), 5,710, Color.WHITE, 50);
        g.drawText("DoomsDay: "+String.valueOf((int)(myManager.getDoomsdayCounter()*100))+"%", 640, 710, Color.WHITE, 50);
        g.drawPixmap(Assets.backButton, 1280 - 128, 720 - 128);

    }
    public  void pause(){

    }
    public  void resume(){

    }
    public  void dispose(){

    }




}
