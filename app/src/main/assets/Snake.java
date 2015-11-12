package com.filip.mrnom;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;

    public List<SnakePart> parts = new ArrayList<SnakePart>();
    public int direction;

    public Snake() {
        direction = UP;
        parts.add(new SnakePart(5, 6));
        parts.add(new SnakePart(5, 7));
        parts.add(new SnakePart(5, 8));
    }

    public void turnLeft() {
        direction += 1;
        if(direction > RIGHT)
            direction = UP;
    }

    public void turnRight() {
        direction -= 1;
        if(direction < UP)
            direction = RIGHT;
    }

    public void eat() {
        // Get the last part of the snake
        SnakePart end = parts.get(parts.size()-1);
        // Add a new part at the same position as the last part
        parts.add(new SnakePart(end.x, end.y));
    }

    // check to see if the snake has bitten itself
    public boolean checkBitten() {
        int len = parts.size();
        SnakePart head = parts.get(0);
        for(int i = 1; i < len; i++) {
            SnakePart part = parts.get(i);
            // Check to see if the head part has the same
            // coordinates as the body part, if so the snake
            // has bitten itself
            if(part.x == head.x && part.y == head.y)
                return true;
        }
        return false;
    }

    public void advance() {
        SnakePart head = parts.get(0);

        // Move all of the snake parts to the
        // previous part location
        int len = parts.size() - 1;
        for(int i = len; i > 0; i--) {
            SnakePart before = parts.get(i-1);
            SnakePart part = parts.get(i);
            part.x = before.x;
            part.y = before.y;
        }

        // Move the head based on the direction
        if(direction == UP)
            head.y -= 1;
        else if(direction == LEFT)
            head.x -= 1;
        else if(direction == DOWN)
            head.y += 1;
        else if(direction == RIGHT)
            head.x += 1;

        // wrap the snake if it hits an edge of
        // the playing field
        if(head.x < 0)
            head.x = 9;
        else if(head.x > 9)
            head.x = 0;
        if(head.y < 0)
            head.y = 12;
        else if(head.y > 12)
            head.y = 0;
    }
}




