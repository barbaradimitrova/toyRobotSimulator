package com.toyRobot.Model;


public class ToyRobot {
    private Position position;

    public ToyRobot(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        if(position.getDirection() == null){
            return "ROBOT MISSING";
        }
        return position.getX() +
                "," + position.getY() +
                "," + position.getDirection();
    }
}


