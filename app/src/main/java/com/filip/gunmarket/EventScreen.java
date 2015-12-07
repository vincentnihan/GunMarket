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
    GameManager myManager;
    public EventScreen(Game game, boolean Event) {
        super(game);
        myManager = game.getManager();
        IsEvent = Event;

    }

    public boolean IsEvent;
<<<<<<< HEAD
=======

>>>>>>> origin/Revert
    public int eventReply;
    public String eventTopic = "Topic";
    public String eventText = "Event Text";
    public String optionA = "Option A";
    public String optionB = "Option B";

<<<<<<< HEAD
=======

>>>>>>> origin/Revert

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
            g.drawText(eventTopic, 640, 75, Color.GREEN, 70); //Event Topic
            g.drawText(eventText, 100, 220, Color.WHITE, 30); //Event
            //g.drawText(eventText, 140, 220, Color.WHITE, 30); //Event
            //g.drawText(eventText, 180, 220, Color.WHITE, 30); //Event
            g.drawText(optionA, 850, 540, Color.BLACK, 50); // optionA
            g.drawText(optionB, 350, 540, Color.BLACK, 50); // optionB

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
