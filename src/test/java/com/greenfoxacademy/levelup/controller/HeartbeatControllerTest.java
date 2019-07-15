package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HeartbeatControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void whenAuthorizationIsOk_thenReturnsStatusCode200() throws Exception {
    doMockMvcPerformGet(Message.AUTHORIZATION_OK)
        .andExpect(status().isOk());
  }

  @Test
  public void whenGetAuthorizationDenied_thenReturnsByStatusCode401() throws Exception {
    doMockMvcPerformGet(Message.UNAUTHORIZED_BODY)
        .andExpect(status().isUnauthorized());
  }

  private ResultActions doMockMvcPerformGet(String authorization) throws Exception {
    return mockMvc.perform(get("/heartbeat")
        .header(Message.HEADER_NAME, authorization));
  }
}
