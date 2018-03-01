package com.toyRobot.Model;

import org.springframework.beans.factory.annotation.Autowired;

public class Position {
    private final int DIMENSION_OF_BOARD = 5;

    private int x;
    private int y;
    private Direction direction;

    @Autowired
    public Position() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isValidPosition(int value) {
        return (value <= DIMENSION_OF_BOARD);
    }
}
