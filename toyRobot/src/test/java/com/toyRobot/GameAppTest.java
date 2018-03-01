package com.toyRobot;

import com.toyRobot.App.GameApp;
import com.toyRobot.Model.Position;
import com.toyRobot.Model.ToyRobot;
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


}