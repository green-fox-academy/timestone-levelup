package com.greenfoxacademy.levelup.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfoxacademy.levelup.collection.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PitchRestControllerTest {

  @Autowired
  MockMvc mockMvc;
  private String requestBody;

  @Test
  public void whenAuthorizationIsOk_thenReturnsStatusCode201() throws Exception {

    mockMvc.perform(post("/api/pitch")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK)
        .contentType(MediaType.APPLICATION_JSON)
        .content(Message.PITCH_REQUIRED_BODY))
        .andExpect(status().isCreated());
  }

  @Test
  public void whenStatusIsUnauthorized_thenReturnsStatusCode401() throws Exception {

    mockMvc.perform(post("/api/pitch")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED)
        .contentType(MediaType.APPLICATION_JSON)
        .content(Message.PITCH_REQUIRED_BODY))
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void whenMissingField_thenReturnsStatusCode404() throws Exception {

    requestBody = "{\"oldLVL\": 2,\"pitchMessage\": \"Hello World! My English is bloody gorgeous.\",\"holders\": [\"balazs.jozsef\", \"benedek.vamosi\", \"balazs.barna\"]}";
    String requiredBody = "{\"oldLVL\": 2,\"pitchedLVL\": 3, pitchMessage\": \"Hello World! My English is bloody gorgeous.\",\"holders\": [\"balazs.jozsef\", \"benedek.vamosi\", \"balazs.barna\"]}";

    mockMvc.perform(post("/api/pitch")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK)
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestBody))
        .andExpect(status().isNotFound());
  }

  @Test
  public void whenAuthorizationIsOkAndHasNoMissingField_thenReturnsByStatusCode201()
      throws Exception {
    requestBody = Message.PITCH_POST_REQUIRED_BODY;

    doMockMvcPerform(requestBody, Message.AUTHORIZATION_OK)
        .andExpect(status().isOk());
  }

  @Test
  public void whenAuthorizationIsOkAndHasNoMissingField_thenReturnsBySuccessfulBody()
      throws Exception {
    requestBody = Message.PITCH_POST_REQUIRED_BODY;

    doMockMvcPerform(requestBody, Message.AUTHORIZATION_OK)
        .andExpect(content().string(Message.SUCCESSFUL_BODY));
  }

  @Test
  public void whenAuthorizationIsOkAndHasMissingField_thenReturnsByStatusCode404()
      throws Exception {
    requestBody = "{\"badgeName\":\"englishspeaker\",\"newStatus\":\"\",\"newMessage\":\"\"}";

    doMockMvcPerform(requestBody, Message.AUTHORIZATION_OK)
        .andExpect(status().isNotFound());
  }

  @Test
  public void whenAuthorizationIsOkAndHasMissingField_thenReturns_thenReturnsByUnsuccessfulBody()
      throws Exception {
    requestBody = "{\"badgeName\":\"englishspeaker\",\"newStatus\":\"\",\"newMessage\":\"\"}";

    doMockMvcPerform(requestBody, Message.AUTHORIZATION_OK)
        .andExpect(content().string(Message.UNSUCCESSFUL_BODY));
  }

  @Test
  public void whenAuthorizationIsUnsuccessful_thenReturnsByStatusCode401() throws Exception {
    requestBody = Message.PITCH_POST_REQUIRED_BODY;

    doMockMvcPerform(requestBody, Message.AUTHORIZATION_DENIED)
        .andExpect(status().is4xxClientError());
  }

  @Test
  public void whenAuthorizationIsUnsuccessful_thenReturnsByUnauthorizedBody() throws Exception {
    requestBody = Message.PITCH_POST_REQUIRED_BODY;

    doMockMvcPerform(requestBody, Message.AUTHORIZATION_DENIED)
        .andExpect(content().string(Message.UNAUTHORIZED_BODY));
  }

  private ResultActions doMockMvcPerform(String content, String authorization) throws Exception {
    return mockMvc.perform(put("/api/pitch")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content)
        .header(Message.HEADER_NAME, authorization));
  }
}