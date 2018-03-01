package com.toyRobot;

import com.toyRobot.App.GameApp;
import com.toyRobot.Endpoint.CommandEndpoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CommandEndpoint.class)
public class CommandEndpointIntegrationTest {

    @MockBean
    GameApp gameApp;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void executeCommandOk() throws Exception {
        mockMvc.perform(post("/command")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"command\":\"PLACE 1,1,NORTH\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void executeCommandContentWithWrongSyntax() throws Exception {

        Mockito.doThrow(new IllegalArgumentException()).when(gameApp).resolveCommand(any());
        mockMvc.perform(post("/command")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"command\":\"PLACEX 1,1,NORfhjTH\"}"))
                .andExpect(status().isBadRequest());
    }
}
