package com.greenfoxacademy.levelup.controller_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfoxacademy.levelup.collection.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PitchRestControllerTest {

  private String requestBody;

  @Autowired
  MockMvc mockMvc;

  private ResultActions doMockMvcPerform(String content, String authorization) throws Exception {
    return mockMvc.perform(put("/api/pitch")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content)
        .header(Message.AUTHORIZATION, authorization));
  }

  @Test
  public void whenAuthorizationIsOkAndHasNoMissingField_thenReturnsStatusCode201() throws Exception {
    requestBody = Message.PITCH_REQUIRED_BODY;

    doMockMvcPerform(requestBody, Message.AUTHORIZATION_OK)
      .andExpect(status().isOk());
  }

  @Test
  public void whenAuthorizationIsOkAndHasMissingField_thenReturnsStatusCode404() throws Exception {
    requestBody = "{\n"
      + "\t\"badgeName\": \"english speaker\",\n"
      + "\t\"newStatus\": \"\",\n"
      + "\t\"newMessage\": \"\"\n"
      + "}\n".replaceAll("\\s", "");

    doMockMvcPerform(requestBody, Message.AUTHORIZATION_OK)
      .andExpect(status().isNotFound());
  }

  @Test
  public void whenAuthorizationIsUnsuccessful_thenReturnsStatusCode401() throws Exception {
    requestBody = Message.PITCH_REQUIRED_BODY;

    doMockMvcPerform(requestBody, Message.AUTHORIZATION_DENIED)
      .andExpect(status().is4xxClientError());
  }
}