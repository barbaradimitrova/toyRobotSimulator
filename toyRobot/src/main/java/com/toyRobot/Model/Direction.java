package com.toyRobot.Model;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);


    private int directionIndex;

    Direction(int directionIndex) {
        this.directionIndex = directionIndex;
    }


    private static Map<Integer, Direction> directionMap = new HashMap<>();

    static {
        for (Direction directionEnum : Direction.values()) {
            directionMap.put(directionEnum.directionIndex, directionEnum);
        }
    }

    public Direction turnRight() {
        return turn(1);
    }

    public Direction turnLeft() {
        return turn(-1);
    }

    private Direction turn(int value) {

        int newIndex = (directionIndex + value);
        if (newIndex < 0) {
            newIndex = directionMap.size() - 1;
        } else if (newIndex > directionMap.size() - 1) {
            newIndex = 0;
        }
        return directionMap.get(newIndex);
    }
}
