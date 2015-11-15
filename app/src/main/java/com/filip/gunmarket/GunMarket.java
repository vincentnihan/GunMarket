package com.filip.gunmarket;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Pixmap;
import com.filip.androidgames.framework.Screen;
        import com.filip.androidgames.framework.impl.AndroidGame;

import java.io.IOException;


public class GunMarket extends AndroidGame{

    public ImageView myWorld;
    public Button USAbutton;
    Drawable myDraw;
    private Drawable [] drawables = null;
    // create a Drawables array that stores location of different images

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Graphics g = this.getGraphics();
        com.filip.gunmarket.Assets.click = this.getAudio().newSound("click.ogg");
       // g.drawPixmap(Assets.worldMap, 0, 0);

        //Assets.click.play(1);


        drawWorld();
        Log.d("screen gonna be called", "onCreate() called with: " + "savedInstanceState = [" + savedInstanceState + "]");
        setScreen(new WorldScreen(this));


       // g.drawPixmap(Assets.worldMap, 0, 0);
        //ImageView myWorld = (ImageView) findViewById(R.id.imageView);
/*
        String location = "C:\\Users\\Erdem\\Desktop\\GunMarket\\app\\src\\main\\assets\\worldmap";
        int imageResource = getResources().getIdentifier(location, null, getPackageName());

       ImageView myWorld = (ImageView)findViewById(R.id.imageView);
        Drawable res = getResources().getDrawable(imageResource);
        myWorld.setImageDrawable(res);
*/
    }

    public Screen getStartScreen() {return new LoadingScreen(this);}


    public void buttonOnClick(View v){
        drawMainMenu();
    }

    public void buttonOnClick2(View v){
        drawMainMenu();
    }
    @Override
    public void drawWorld(){

        setContentView(R.layout.activity_world);
        myWorld = (ImageView)findViewById(R.id.imageView);


        try {
            myDraw = Drawable.createFromStream(getAssets().open("world/worldmap.png"), null);
        }catch (IOException e){

        }

        myWorld.setImageDrawable(myDraw);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenW = displaymetrics.widthPixels;
        int screenH = displaymetrics.heightPixels;

        USAbutton = (Button)findViewById(R.id.button);
        //USAbutton.layout((80 * 1280)/screenW, (163*720)/screenH, (190+80)*1280/screenW ,(100+163)*720/screenH);



    }

    @Override
    public void drawMainMenu(){
        setContentView(R.layout.mainmenu);

    }

}
