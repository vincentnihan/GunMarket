package com.filip.gunmarket;

import com.filip.androidgames.framework.Screen;
import com.filip.androidgames.framework.impl.AndroidGame;

public class GunMarket extends AndroidGame{
   public GameManager myManager = new GameManager();



    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }


    public GameManager getManager(){
        return myManager;
    }

}
