package com.toyRobot.app;

import com.toyRobot.model.Command;
import com.toyRobot.model.Direction;
import com.toyRobot.model.Position;
import com.toyRobot.model.ToyRobot;
import org.springframework.beans.factory.annotation.Autowired;

import static com.toyRobot.model.Direction.valueOf;

public class GameApp {


    private ToyRobot toyRobot;
    private Position position;

    @Autowired
    public GameApp(ToyRobot toyRobot, Position position) {
        this.toyRobot = toyRobot;
        this.position = position;
    }

    public void resolveCommand(String commandString) throws IllegalArgumentException {

        String[] commandArgs = commandString.split(" ");

        Command command = Command.valueOf(commandArgs[0]);
        switch (command) {
            case MOVE:
                if (position.getDirection()!= null) {
                    move();
                }
                break;
            case LEFT:
                if (position.getDirection()!= null) {
                    left();
                }
                break;
            case RIGHT:
                if (position.getDirection()!= null) {
                    right();
                }
                break;
            case PLACE:
                place(commandArgs[1]);
                break;
            case REPORT:
                report();
                break;
        }

    }

    private void move() {

        Direction direction = position.getDirection();
        int x = position.getX();
        int y = position.getY();

        switch (direction) {
            case NORTH:
                moveNorthSouth(y, 1);
                break;
            case SOUTH:
                moveNorthSouth(y, -1);
                break;
            case EAST:
                moveEastWest(x, 1);
                break;
            case WEST:
                moveEastWest(x, -1);
        }
    }

    private void moveNorthSouth(int y, int i) {
        int newY = y + i;
        if (position.isValidPosition(newY)) {
            position.setY(newY);
        }
    }

    private void moveEastWest(int x, int i) {
        int newX = x + i;
        if (position.isValidPosition(newX)) {
            position.setX(newX);
        }
    }

    private void left() {
        Direction direction = position.getDirection();
        position.setDirection(direction.turnLeft());
    }


    private void right() {
        Direction direction = position.getDirection();
        position.setDirection(direction.turnRight());
    }

    private void report() {
        System.out.println(toyRobot.toString());
    }

    private void place(String placeArgs) throws IllegalArgumentException {

        String[] args = placeArgs.split(",");
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        Direction direction = valueOf(args[2]);
        if (position.isValidPosition(x) && position.isValidPosition(y)) {
            position.setX(x);
            position.setY(y);
            position.setDirection(direction);
            toyRobot = new ToyRobot(position);
        }
    }
}

