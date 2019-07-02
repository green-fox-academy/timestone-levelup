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
  public void whenPostAuthorizationIsOk_thenReturnsByStatusCode201() throws Exception {
    requestBody = Message.PITCH_REQUIRED_BODY;

    doMockMvcPerformPost(requestBody, Message.AUTHORIZATION_OK)
        .andExpect(status().isCreated());
  }

  @Test
  public void whenPostAuthorizationDenied_thenReturnsByStatusCode401() throws Exception {
    requestBody = Message.PITCH_REQUIRED_BODY;

    doMockMvcPerformPost(requestBody, Message.AUTHORIZATION_DENIED)
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void whenPostAuthorizationOkAndHasMissingField_thenReturnsByStatusCode404() throws Exception {
    requestBody = "{\"oldLVL\": 2,\"pitchMessage\": \"Hello World! My English is bloody gorgeous.\",\"holders\": [\"balazs.jozsef\", \"benedek.vamosi\", \"balazs.barna\"]}";

    doMockMvcPerformPost(requestBody, Message.AUTHORIZATION_OK)
        .andExpect(status().isNotFound());
  }

  @Test
  public void whenPutAuthorizationIsOkAndHasNoMissingField_thenReturnsByStatusCode201() throws Exception {
    requestBody = Message.PITCH_POST_REQUIRED_BODY;

    doMockMvcPerformPut(requestBody, Message.AUTHORIZATION_OK)
        .andExpect(status().isOk());
  }

  @Test
  public void whenPutAuthorizationIsOkAndHasNoMissingField_thenReturnsBySuccessfulBody() throws Exception {
    requestBody = Message.PITCH_POST_REQUIRED_BODY;

    doMockMvcPerformPut(requestBody, Message.AUTHORIZATION_OK)
        .andExpect(content().string(Message.SUCCESSFUL_BODY));
  }

  @Test
  public void whenPutAuthorizationIsOkAndHasMissingField_thenReturnsByStatusCode404() throws Exception {
    requestBody = "{\"badgeName\":\"englishspeaker\",\"newStatus\":\"\",\"newMessage\":\"\"}";

    doMockMvcPerformPut(requestBody, Message.AUTHORIZATION_OK)
        .andExpect(status().isNotFound());
  }

  @Test
  public void whenPutAuthorizationIsOkAndHasMissingField_thenReturns_thenReturnsByUnsuccessfulBody() throws Exception {
    requestBody = "{\"badgeName\":\"englishspeaker\",\"newStatus\":\"\",\"newMessage\":\"\"}";

    doMockMvcPerformPut(requestBody, Message.AUTHORIZATION_OK)
        .andExpect(content().string(Message.UNSUCCESSFUL_BODY));
  }

  @Test
  public void whenPutAuthorizationIsUnsuccessful_thenReturnsByStatusCode401() throws Exception {
    requestBody = Message.PITCH_POST_REQUIRED_BODY;

    doMockMvcPerformPut(requestBody, Message.AUTHORIZATION_DENIED)
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void whenPutAuthorizationIsUnsuccessful_thenReturnsByUnauthorizedBody() throws Exception {
    requestBody = Message.PITCH_POST_REQUIRED_BODY;

    doMockMvcPerformPut(requestBody, Message.AUTHORIZATION_DENIED)
        .andExpect(content().string(Message.UNAUTHORIZED_BODY));
  }

  private ResultActions doMockMvcPerformPut(String content, String authorization) throws Exception {
    return mockMvc.perform(put("/api/pitch")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content)
        .header(Message.HEADER_NAME, authorization));
  }

  private ResultActions doMockMvcPerformPost(String content, String authorization) throws Exception {
    return mockMvc.perform(post("/api/pitch")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content)
        .header(Message.HEADER_NAME, authorization));
  }
}