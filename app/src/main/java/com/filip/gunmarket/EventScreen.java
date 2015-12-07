package com.filip.gunmarket;

import android.graphics.Color;

import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Input;
import com.filip.androidgames.framework.Screen;

import java.util.List;

/**
 * Created by Erdem on 2015-11-17.
 */
public class EventScreen extends Screen {
    public EventScreen(Game game, boolean Event) {
        super(game);
        IsEvent = Event;
    }

    public boolean IsEvent;
    public String eventText;
    public String optionA;
    public String optionB;


    public  void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if(IsEvent == true) {
                    if (inBounds(event, 1280 - 128, 720 - 128, 128, 128)) {
                    game.setScreen(new WorldScreen(game));
                    }
                }
                else
                {

                }
            }
        }
    }

    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        if(IsEvent == true) {
            g.drawRect(0, 0, 1280, 720, Color.DKGRAY);
            g.drawPixmap(Assets.buttonBackground, 0, 520, 0, 0, 200, 100);
            g.drawPixmap(Assets.buttonBackground, 0, 520, 0, 0, 200, 100);
            g.drawPixmap(Assets.buttonBackground, 0, 520, 0, 0, 200, 100);
            g.drawText(eventText, 500, 500, Color.BLACK, 50);
            g.drawText(optionA, 500, 500, Color.BLACK, 50);
            g.drawText(optionB, 500, 500, Color.BLACK, 50);

        }
        else
        {

        }



        g.drawPixmap(Assets.backButton, 1280 - 128, 720 - 128);
    }

    public  void pause(){

    }
    public  void resume(){

    }
    public  void dispose(){

    }
}
