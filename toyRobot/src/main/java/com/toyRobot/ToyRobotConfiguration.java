package com.toyRobot;

import com.toyRobot.App.GameApp;
import com.toyRobot.Model.Position;
import com.toyRobot.Model.ToyRobot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToyRobotConfiguration {


    @Bean
    public GameApp gameApp(ToyRobot toyRobot, Position position) {
        return new GameApp(toyRobot,position);
    }
    @Bean
    public ToyRobot toyRobot(Position position) {
        return new ToyRobot(position);
    }
    @Bean
    public Position position() {
        return new Position();
    }



}
