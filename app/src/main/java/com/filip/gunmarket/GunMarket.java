package com.filip.gunmarket;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Pixmap;
import com.filip.androidgames.framework.Screen;
        import com.filip.androidgames.framework.impl.AndroidGame;

import java.io.IOException;


public class GunMarket extends AndroidGame{

    public ImageView myWorld;
    Drawable myDraw;
    private Drawable [] drawables = null;
    // create a Drawables array that stores location of different images

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Graphics g = this.getGraphics();
       // g.drawPixmap(Assets.worldMap, 0, 0);

        setContentView(R.layout.activity_world);
    myWorld = (ImageView)findViewById(R.id.imageView);


        try {
        myDraw = Drawable.createFromStream(getAssets().open("world/worldmap.png"), null);
    }catch (IOException e){

        }

        myWorld.setImageDrawable(myDraw);


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


}
