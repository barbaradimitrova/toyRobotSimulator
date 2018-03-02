package com.toyRobot;

import com.toyRobot.app.GameApp;
import com.toyRobot.model.Position;
import com.toyRobot.model.ToyRobot;
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
