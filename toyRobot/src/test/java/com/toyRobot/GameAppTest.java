package com.toyRobot;

import com.toyRobot.app.GameApp;
import com.toyRobot.model.Position;
import com.toyRobot.model.ToyRobot;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameAppTest {

    @Test
    public void resolveCommandTestCase1() {
        Position position = new Position();
        ToyRobot toyRobot = new ToyRobot(position);
        GameApp gameApp = new GameApp(toyRobot, position);

        gameApp.resolveCommand("PLACE 0,0,NORTH");
        gameApp.resolveCommand("MOVE");
        gameApp.resolveCommand("REPORT");

        String expected = "0,1,NORTH";
        assertEquals(expected,toyRobot.toString());
    }
    @Test
    public void resolveCommandTestCase2() {
        Position position = new Position();
        ToyRobot toyRobot = new ToyRobot(position);
        GameApp gameApp = new GameApp(toyRobot, position);

        gameApp.resolveCommand("PLACE 0,0,NORTH");
        gameApp.resolveCommand("LEFT");
        gameApp.resolveCommand("REPORT");
        String expected = "0,0,WEST";
        assertEquals(expected,toyRobot.toString());
    }

    @Test
    public void resolveCommandTestCase3() {
        Position position = new Position();
        ToyRobot toyRobot = new ToyRobot(position);
        GameApp gameApp = new GameApp(toyRobot, position);

        gameApp.resolveCommand("MOVE");
        gameApp.resolveCommand("REPORT");
        String expected = "ROBOT MISSING";
        assertEquals(expected,toyRobot.toString());
    }
    @Test
    public void placingRobotOutOfBoard() {
        Position position = new Position();
        ToyRobot toyRobot = new ToyRobot(position);
        GameApp gameApp = new GameApp(toyRobot, position);

        gameApp.resolveCommand("PLACE -1,6,EAST");
        gameApp.resolveCommand("MOVE");
        gameApp.resolveCommand("RIGHT");
        gameApp.resolveCommand("MOVE");
        gameApp.resolveCommand("MOVE");
        gameApp.resolveCommand("REPORT");
        String expected = "ROBOT MISSING";
        assertEquals(expected,toyRobot.toString());
    }

    @Test
    public void directionChangeMoreThan4Times() {
        Position position = new Position();
        ToyRobot toyRobot = new ToyRobot(position);
        GameApp gameApp = new GameApp(toyRobot, position);

        gameApp.resolveCommand("PLACE 0,0,EAST");
        gameApp.resolveCommand("RIGHT");
        gameApp.resolveCommand("RIGHT");
        gameApp.resolveCommand("RIGHT");
        gameApp.resolveCommand("RIGHT");
        gameApp.resolveCommand("RIGHT");
        gameApp.resolveCommand("MOVE");
        gameApp.resolveCommand("MOVE");
        gameApp.resolveCommand("REPORT");
        String expected = "0,0,SOUTH";
        assertEquals(expected,toyRobot.toString());
    }

    @Test
    public void rightMovementFirst() {
        Position position = new Position();
        ToyRobot toyRobot = new ToyRobot(position);
        GameApp gameApp = new GameApp(toyRobot, position);

        gameApp.resolveCommand("RIGHT");
        gameApp.resolveCommand("MOVE");
        gameApp.resolveCommand("PLACE 0,0,EAST");
        gameApp.resolveCommand("MOVE");
        gameApp.resolveCommand("REPORT");
        String expected = "1,0,EAST";
        assertEquals(expected,toyRobot.toString());
    }
}