package com.filip.gunmarket;


import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Graphics.PixmapFormat;
import com.filip.androidgames.framework.Screen;

import java.util.List;

public class LoadingScreen extends Screen
{
    GameManager myManager;
    public LoadingScreen(Game game) {
        super(game);
        myManager = game.getManager();
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();

        Assets.Background1  = game.getAudio().newSound("Background1.ogg");
        //Assets.Background2 = game.getAudio().newSound("Background2.mp3");
        //Assets.Background3 = game.getAudio().newSound("Background3.mp3");
        Assets.menuSlide = game.getAudio().newSound("Menu.ogg");
        Assets.bubblePop = game.getAudio().newSound("BubblePop.ogg");
        Assets.bubbleForm = game.getAudio().newSound("BubbleForming.ogg");


        Assets.menuBackground = g.newPixmap("darkWorldmap.jpg", PixmapFormat.ARGB4444);
        //Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.buttonBackground = g.newPixmap("ButtonBackground.jpg", PixmapFormat.ARGB4444);
        Assets.topicBackground = g.newPixmap("TopicBackground.jpg", PixmapFormat.ARGB4444);
        //Assets.buttonBackground = g.newPixmap("headleft.png", PixmapFormat.ARGB4444);
        Assets.nuclearPic= g.newPixmap("nuclearBlast.jpg", PixmapFormat.ARGB4444);
        Assets.tradeIcon = g.newPixmap("trade.png", PixmapFormat.ARGB4444);
        Assets.eventIcon = g.newPixmap("exclamation.png", PixmapFormat.ARGB4444);
        Assets.worldMap = g.newPixmap("WorldMap.png", PixmapFormat.ARGB4444);
        Assets.helpBackground = g.newPixmap("helpBackground.jpg", PixmapFormat.ARGB4444);
        Assets.backgroundFrame = g.newPixmap("BackgroundFrame.jpg", PixmapFormat.ARGB4444);
        Assets.creditBackground = g.newPixmap("creditBackground.jpg", PixmapFormat.ARGB4444);
        Assets.helpTextFrame = g.newPixmap("HelpTextFrame.jpg" , PixmapFormat.ARGB4444);
        Assets.creditTextFrame = g.newPixmap("CreditTextFrame.jpg" , PixmapFormat.ARGB4444);
        //Assets.frame = g.newPixmap("frame.jpg", PixmapFormat.ARGB4444);
        Assets.backButton = g.newPixmap("back.png", PixmapFormat.ARGB4444);
        //Assets.plusButton = g.newPixmap("plus.jpg", PixmapFormat.ARGB4444);
        //Assets.minusButton = g.newPixmap("minus.jpg", PixmapFormat.ARGB4444);
        //Assets.facism = g.newPixmap("facism.jpg", PixmapFormat.ARGB4444);
        //Assets.hammer = g.newPixmap("hammer and sickle.jpg", PixmapFormat.ARGB4444);
        //Assets.torch = g.newPixmap("torch.jpg", PixmapFormat.ARGB4444);
        //Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }
    @Override
    public void present(float deltaTime) {

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


