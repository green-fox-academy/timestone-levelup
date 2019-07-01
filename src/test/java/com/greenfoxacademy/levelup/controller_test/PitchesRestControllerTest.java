package com.greenfoxacademy.levelup.controller_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfoxacademy.levelup.collection.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class PitchesRestControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void whenAuthorizationIsOk_thenReturnsByPitchesApiBody() throws Exception{
    doMockMvcPerform(Message.AUTHORIZATION_OK)
      .andExpect(content().string(Message.BODY));
  }

  @Test
  public void whenAuthorizationIsOk_thenReturnsByStatusCode200() throws Exception {
    doMockMvcPerform(Message.AUTHORIZATION_OK)
      .andExpect(status().isOk());
  }

  @Test
  public void whenResponseStatusIsUnauthorized_thenReturnsByErrorBody() throws Exception {
    doMockMvcPerform(Message.AUTHORIZATION_DENIED)
      .andExpect(content().string(Message.ERROR_BODY));
  }

  @Test
  public void whenResponseStatusIsUnauthorized_thenReturnsByStatusCode401() throws Exception {
    doMockMvcPerform(Message.AUTHORIZATION_DENIED)
      .andExpect(status().isUnauthorized());
  }

  private ResultActions doMockMvcPerform(String authorization) throws Exception {
    return mockMvc.perform(get("/api/pitches")
        .header(Message.AUTHORIZATION, authorization));
  }
}
