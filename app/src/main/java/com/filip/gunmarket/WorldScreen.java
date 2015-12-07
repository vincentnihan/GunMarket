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


    public WorldScreen(Game game) {
        super(game);
        myManager = game.getManager();
    }

public int location;
public int bubbleType;
    @Override
    public void update(float deltaTime) {

        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if(event.type == Input.TouchEvent.TOUCH_UP) {
                if(inBounds(event, 640-120, 620,240,100)){
                    // MIddle down button
                    game.setScreen(new BuyScreen(game));
                }
                if(inBounds(event,1080,620,200,100)){
                    // OPEN INVENTORY
                    game.setScreen(new InventoryScreen(game));
                    
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
        for(int i  = 1; i<8; i++)
        {
            displayBubble(i,0);
        }
        g.drawText("$1000K", 90, 710, Color.GREEN, 50);
        g.drawText("Infl: 0", 90,710-50, Color.GREEN, 50);
        g.drawText("Tap here for Buy Template", 640, 710, Color.GREEN, 30);
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
                    g.drawPixmap(Assets.tradeIcon, 900, 225, 0, 0, 50, 50); //CHINA
                    break;
                case 5:
                    g.drawPixmap(Assets.tradeIcon, 0, 0, 0, 0, 50, 50); // Latin America
                    break;
                case 6:
                    g.drawPixmap(Assets.tradeIcon, 0, 0, 0, 0, 50, 50); // Africa
                    break;
                case 7:
                    g.drawPixmap(Assets.tradeIcon, 645, 193, 0, 0, 50, 50); //MIDDLE EAST
                    break;
                case 8:
                    g.drawPixmap(Assets.tradeIcon, 275, 450, 0, 0, 50, 50);// SOUTH AMERICA
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
                    g.drawPixmap(Assets.eventIcon, 900, 225, 0, 0, 50, 50); //CHINA
                    break;
                case 5:
                    g.drawPixmap(Assets.eventIcon, 0, 0, 0, 0, 50, 50); // Latin America
                    break;
                case 6:
                    g.drawPixmap(Assets.eventIcon, 0, 0, 0, 0, 50, 50); // Africa
                    break;
                case 7:
                    g.drawPixmap(Assets.eventIcon, 645, 193, 0, 0, 50, 50); //MIDDLE EAST
                    break;
                case 8:
                    g.drawPixmap(Assets.eventIcon, 275, 450, 0, 0, 50, 50);// SOUTH AMERICA
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
