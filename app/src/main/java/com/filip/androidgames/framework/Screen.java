package com.filip.androidgames.framework;

import android.util.Log;

import com.filip.gunmarket.Assets;

public abstract class Screen {
	
    protected final Game game;

    public Screen(Game game)
    {
        this.game = game;
    }

    public abstract void update(float deltaTime);
    public abstract void present(float deltaTime);
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();

    protected boolean inBounds(Input.TouchEvent event,
                             int x, int y,
                             int width, int height) {
        Log.d("test", "inBounds() returned: " + true);
        Assets.click.play(1);

        if (event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }
}


