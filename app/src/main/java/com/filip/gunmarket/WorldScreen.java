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
    public WorldScreen(Game game) {
        super(game);
    }



    @Override
    public void update(float deltaTime) {
        Log.d("2 SCREEN IS CALLEDD", "update() called with: " + "deltaTime = [" + deltaTime + "]");
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if(event.type == Input.TouchEvent.TOUCH_UP) {
                if (inBounds(event, 80, 163,190 ,100)){
                    //USA TAPPED
                    game.setScreen(new CountryScreen(game));
                    //game.drawMainMenu();
                }
                if(inBounds(event,203,348,167,300)){
                    // SOUTH AMERICA
                    game.setScreen(new RegionScreen(game));
                }
                if(inBounds(event,489,72,619-489,217-72 )){
                    // EUROPEAN UNION
                    game.setScreen(new CountryScreen(game));
                }
                if(inBounds(event,620, 37, 1048-620,144-37)){
                    //RUSSIA
                    game.setScreen(new CountryScreen(game));
                }
                if(inBounds(event,815,162,991-815,259-162)){
                    //CHINA
                    game.setScreen(new CountryScreen(game));
                }
                if (inBounds(event,619,193,749-619, 293-193)){
                    //MIDDLE EAST
                    game.setScreen(new RegionScreen(game));
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Log.d("2 SCREEN IS CALLEDD", "present() called with: " + "deltaTime = [" + deltaTime + "]");
        //Assets.click.play(1);
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.worldMap, 0, 0);
        g.drawText("$1000K",10,710, Color.YELLOW,50);
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
