package com.filip.androidgames.framework.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.filip.androidgames.framework.Audio;
import com.filip.androidgames.framework.FileIO;
import com.filip.androidgames.framework.Game;
import com.filip.androidgames.framework.Graphics;
import com.filip.androidgames.framework.Input;
import com.filip.androidgames.framework.Screen;

public abstract class AndroidGameRound extends Activity implements Game {
    AndroidFastRenderViewRound renderView;
    Graphics graphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Screen screen;
    private View surfaceView;
    private int width,height;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);



        width = wm.getDefaultDisplay().getWidth();

        height = wm.getDefaultDisplay().getHeight();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        int frameBufferWidth = 48;
        int frameBufferHeight = 48;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight, Config.RGB_565);
        
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        
        // determine the scale based on our framebuffer and our display sizes
        float scaleX = (float) frameBufferWidth / size.x;
        float scaleY = (float) frameBufferHeight / size.y;

        renderView = new AndroidFastRenderViewRound(this, frameBuffer);

        graphics = new AndroidGraphics(getAssets(), frameBuffer);
        fileIO = new AndroidFileIO(getAssets());
        audio = new AndroidAudio(this);
        input = new AndroidInput(this, renderView, scaleX, scaleY);
        screen = getStartScreen();
        setContentView(renderView);

    }

    @Override
    public void onResume() {
        super.onResume();
        screen.resume();
        renderView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        renderView.pause();
        screen.pause();

        if (isFinishing())
            screen.dispose();
    }

    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    @Override
    public void setScreen(Screen screen) {
        if (screen == null)
            throw new IllegalArgumentException("Screen is null");

        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.update(0);
        this.screen = screen;
    }
    
    public Screen getCurrentScreen() {
        return screen;
    }

}