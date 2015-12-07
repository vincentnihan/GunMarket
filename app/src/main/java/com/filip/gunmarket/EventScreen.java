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
    public String eventTopic;
    public String eventText;
    public String optionA;
    public String optionB;
    public int eventReply;

    public  void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if(IsEvent == true) {
                    if (inBounds(event, 1280 - 128, 720 - 128, 128, 128)) {
                        eventReply = 1;
                        game.setScreen(new WorldScreen(game));
                    }
                    if (inBounds(event, 1280 - 128, 720 - 128, 128, 128)) {
                        eventReply = 2;
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
        g.drawRect(0, 0, 1280, 720, Color.DKGRAY);
        if(IsEvent == true) {

            g.drawPixmap(Assets.buttonBackground, 200, 60, 0, 0, 500, 500); //frame
            g.drawPixmap(Assets.buttonBackground, 720, 100, 0, 0, 400, 200); //optionA frame
            g.drawPixmap(Assets.buttonBackground, 720, 400, 0, 0, 400, 200); //optionB frame
            g.drawText(eventTopic, 640, 75, Color.BLACK, 50); //Event Topic
            g.drawText(eventText, 500, 310, Color.BLACK, 25); //Event
            g.drawText(optionA, 920, 200, Color.BLACK, 50); // optionA
            g.drawText(optionB, 920, 500, Color.BLACK, 50); // optionB

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
