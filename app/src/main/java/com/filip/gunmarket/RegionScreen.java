package com.filip.gunmarket;

import android.graphics.Color;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Screen;

/**
 * Created by Erdem on 2015-11-16.
 */
public class RegionScreen extends Screen {
    public RegionScreen(Game game) {
        super(game);
    }

    int rowLeft = 100;

    int rowUp = 220;
    public  void update(float deltaTime){

    }
    public  void present(float deltaTime){
        Graphics g = game.getGraphics();
        g.drawRect(0, 0, 1280, 720, Color.DKGRAY);

        g.drawText("REGION NAME", 640, 75, Color.YELLOW, 70);
        //g.drawText("Connections: 0%", 640, 105, Color.WHITE, 30);

        g.drawText("COUNTRY", rowLeft, rowUp, Color.WHITE, 35);
        g.drawText("Country1", rowLeft, rowUp+80, Color.WHITE, 30);
        g.drawText("Country2", rowLeft, rowUp + 160, Color.WHITE, 30);
        g.drawText("Country3", rowLeft, rowUp+240, Color.WHITE, 30);

        g.drawText("CONNECTIONS", rowLeft+350, rowUp, Color.WHITE, 35);
        g.drawText("0%", rowLeft+350, rowUp+80, Color.WHITE, 30);
        g.drawText("0%", rowLeft+350, rowUp+160, Color.WHITE, 30);
        g.drawText("0%", rowLeft+350, rowUp+240, Color.WHITE, 30);

        g.drawText("GOVERNMENT", rowLeft+700, rowUp, Color.WHITE, 35);
        g.drawText("Type1", rowLeft+700, rowUp+80, Color.WHITE, 30);
        g.drawText("Type2", rowLeft+700, rowUp+160, Color.WHITE, 30);
        g.drawText("Type3", rowLeft+700, rowUp+240, Color.WHITE, 30);

    }
    public  void pause(){

    }
    public  void resume(){

    }
    public  void dispose(){

    }




}
