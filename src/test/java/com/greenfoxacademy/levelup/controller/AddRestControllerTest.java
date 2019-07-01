package com.greenfoxacademy.levelup.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfoxacademy.levelup.collection.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AddRestControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void whenAuthorizationIsOkAndHasNoMissingField_thenReturnsStatusCode201()
      throws Exception {
    String requestContent = "{\"version\": \"2.3\",\"name\": \"Badge inserter\",\"tag\": \"general\",\"levels\": [1, 2, 3, 4]}";

    mockMvc.perform(post("/api/admin/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestContent)
        .characterEncoding("utf-8")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andDo(print())
        .andExpect(status().isCreated());
  }

  @Test
  public void whenAuthorizationIsDenied_thenReturnsStatusCode401()
      throws Exception {
    String requestContent = Message.ADDADMIN_BODY;

    mockMvc.perform(post("/api/admin/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestContent)
        .characterEncoding("utf-8")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andDo(print())
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void whenIsAuthorizedAndMissingField_thenReturnsStatusCode404() throws Exception {
    String requestContent = "{\"version\": \"2.3\",\"name\": \"Badge inserter\",\"levels\": [1, 2, 3, 4]}";

    mockMvc.perform(post("/api/admin/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestContent)
        .characterEncoding("utf-8")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andDo(print())
        .andExpect(status().isNotFound());
  }
}
