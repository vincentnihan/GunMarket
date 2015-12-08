package com.filip.gunmarket;

import android.graphics.Color;
import android.util.Log;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Input;
import com.filip.androidgames.framework.Screen;

import java.util.List;

/**
 * Created by Erdem on 2015-11-13.
 */
public class WorldScreen extends Screen {
    GameManager myManager;
    int[] oppArray = new int[8];

    public WorldScreen(Game game) {
        super(game);
        myManager = game.getManager();
        Assets.Background1.play(1);
    }

public int location;
public int bubbleType;

    public void bgmPlayer(int BGM)
    {
        // if(BGM == 1)
        // Assets.Background1.play(1);
        //else if(BGM == 2)
        //Assets.Background2.play(1);
        //else if(BGM == 3)
        //Assets.Background3.play(1);

    }

    public void openRegionScreen(int regionNum){
        myManager.setCurrentRegion(regionNum);

        switch (myManager.getOpportunityArray()[regionNum-1]){
            case 0:
                    game.setScreen(new RegionScreen(game));
                break;
            case 1:
                myManager.getOpportunityArray()[regionNum-1] = 0;
                if(regionNum < 5)
                    game.setScreen(new BuyScreen(game));
                else
                    game.setScreen(new SellScreen(game));
                break;
            case 2:
                myManager.getOpportunityArray()[regionNum-1]=0;
                game.setScreen(new EventScreen(game, true));
                break;
        }

    }


    @Override
    public void update(float deltaTime) {
        myManager.progressTime(deltaTime);


        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if(event.type == Input.TouchEvent.TOUCH_UP) {
                if (inBounds(event, 80, 163,190 ,100)){
                    //USA TAPPED
                    //game.setScreen(new CountryScreen(game));
                    openRegionScreen(1);
                }
                if(inBounds(event,203,348,167,300)){
                    // SOUTH AMERICA
                    openRegionScreen(5);
                    //game.setScreen(new RegionScreen(game));
                }
                if(inBounds(event,489,72,619-489,217-72 )){
                    // EUROPEAN UNION
                    openRegionScreen(2);
                    //game.setScreen(new CountryScreen(game));
                }
                if(inBounds(event,620, 37, 1048-620,144-37)){
                    //RUSSIA
                    openRegionScreen(3);
                    //game.setScreen(new CountryScreen(game));
                }
                if(inBounds(event,815,162,991-815,259-162)){
                    //CHINA
                    openRegionScreen(4);
                    //game.setScreen(new CountryScreen(game));
                }
                if (inBounds(event,619,193,749-619, 293-193)){
                    //MIDDLE EAST
                    openRegionScreen(7);
                    //game.setScreen(new RegionScreen(game));
                }
                /*
                if(inBounds(event, 640-120, 620,240,100)){
                    // MIddle down button
                    game.setScreen(new BuyScreen(game));
                }
                */
                if(inBounds(event,1080,620,200,100)){
                    // OPEN INVENTORY
                    game.setScreen(new InventoryScreen(game));
                   // game.setScreen(new EventScreen(game, true));
                    
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        //Assets.click.play(1);
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.worldMap, 0, 0);
        // call displayBubble after worldMap
        /*
        for(int i  = 1; i<9; i++)
        {
            displayBubble(i,0);
        }
        */

        //oppArray = myManager.getOpportunityArray();

        for (int i = 0; i < 8; i++){
            if (myManager.getOpportunityArray()[i] == 1){
                displayBubble(i+1,0);
            }else if(myManager.getOpportunityArray()[i] == 2){
                displayBubble(i+1, 1);
            }
        }





            g.drawText("$"+String.valueOf(myManager.getMoney())+"K", 90, 710, Color.GREEN, 50);
        g.drawText("Infl: "+String.valueOf(myManager.getInfluencePoints()), 90,710-50, Color.GREEN, 50);
        g.drawText("DoomsDay: "+String.valueOf((int)(myManager.getDoomsdayCounter()*100))+"%", 640, 710-50, Color.GREEN, 30);
        g.drawText(myManager.getDate(),640,710,Color.GREEN, 50);
        g.drawTextR("Inventory", 1270, 710, Color.GREEN, 50);
    }

    public void displayBubble(int location, int bubbleType)
    {
        Graphics g = game.getGraphics();
        if(bubbleType == 0) {
            switch (location) {
                case 1:
                    g.drawPixmap(Assets.tradeIcon, 125, 185, 0, 0, 50, 50);//USA TAPPED
                    break;
                case 2:
                    g.drawPixmap(Assets.tradeIcon, 500, 150, 0, 0, 50, 50);// EUROPEAN UNION
                    break;
                case 3:
                    g.drawPixmap(Assets.tradeIcon, 780, 85, 0, 0, 50, 50); //RUSSIA
                    break;
                case 4:
                    g.drawPixmap(Assets.tradeIcon, 900, 200, 0, 0, 50, 50); //CHINA
                    break;
                case 5:
                    g.drawPixmap(Assets.tradeIcon, 275, 450, 0, 0, 50, 50); // Latin America
                    break;
                case 6:
                    g.drawPixmap(Assets.tradeIcon, 525, 325, 0, 0, 50, 50); // Africa
                    break;
                case 7:
                    g.drawPixmap(Assets.tradeIcon, 645, 193, 0, 0, 50, 50); //MIDDLE EAST
                    break;
                case 8:
                    g.drawPixmap(Assets.tradeIcon, 825, 275, 0, 0, 50, 50);// SOUTH ASIA
                    break;
            }
        }
        else
        {
            switch (location) {
                case 1:
                    g.drawPixmap(Assets.eventIcon, 125, 185, 0, 0, 50, 50);//USA TAPPED
                    break;
                case 2:
                    g.drawPixmap(Assets.eventIcon, 500, 150, 0, 0, 50, 50);// EUROPEAN UNION
                    break;
                case 3:
                    g.drawPixmap(Assets.eventIcon, 780, 85, 0, 0, 50, 50); //RUSSIA
                    break;
                case 4:
                    g.drawPixmap(Assets.eventIcon, 900, 200, 0, 0, 50, 50); //CHINA
                    break;
                case 5:
                    g.drawPixmap(Assets.eventIcon, 275, 450, 0, 0, 50, 50); // Latin America
                    break;
                case 6:
                    g.drawPixmap(Assets.eventIcon, 525, 325, 0, 0, 50, 50); // Africa
                    break;
                case 7:
                    g.drawPixmap(Assets.eventIcon, 645, 193, 0, 0, 50, 50); //MIDDLE EAST
                    break;
                case 8:
                    g.drawPixmap(Assets.eventIcon, 825, 275, 0, 0, 50, 50);// SOUTH ASIA
                    break;
            }
        }

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
