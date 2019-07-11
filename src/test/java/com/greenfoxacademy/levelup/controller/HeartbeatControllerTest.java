package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HeartbeatControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void whenAuthorizationIsOk_thenReturnsByHeartbeatBody() throws Exception {
    mockMvc.perform(get("/heartbeat").header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(status().isOk())
        .andExpect(content().string(Message.AUTHORIZATION_OK))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void whenAuthorizationIsOk_thenReturnsByStatusCode200() throws Exception {
    mockMvc.perform(get("/heartbeat").header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(status().isOk());
  }

  @Test
  public void whenAuthorizationDenied_thenReturnsByErrorBody() throws Exception {
    mockMvc.perform(get("/heartbeat")
        .header(Message.HEADER_NAME, Message.UNAUTHORIZED_BODY))
        .andExpect(status().isUnauthorized())
        .andExpect(content().string(Message.UNAUTHORIZED_BODY))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void whenGetAuthorizationDenied_thenReturnsByStatusCode401() throws Exception {
    mockMvc.perform(get("/heartbeat").header(Message.HEADER_NAME, Message.UNAUTHORIZED_BODY))
        .andExpect(status().isUnauthorized());
  }
}
