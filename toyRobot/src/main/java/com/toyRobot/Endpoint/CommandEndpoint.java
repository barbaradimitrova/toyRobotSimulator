package com.toyRobot.Endpoint;

import com.toyRobot.App.GameApp;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.toyRobot.Model.Command.valueOf;


@RestController
public class CommandEndpoint {

    private final GameApp gameApp;

    @Autowired
    public CommandEndpoint(GameApp gameApp) {
        this.gameApp = gameApp;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/command")
    public ResponseEntity executeCommand(@RequestBody JSONObject object) {

        String commandString = object.getAsString("command");

        try{
            gameApp.resolveCommand(commandString);
            return ResponseEntity.status((HttpStatus.OK)).build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.status((HttpStatus.BAD_REQUEST)).build();
        }
    }
}


