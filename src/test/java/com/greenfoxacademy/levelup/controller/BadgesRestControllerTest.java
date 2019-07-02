package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest
public class BadgesRestControllerTest {

  @Autowired
  private MockMvc mockMvc;
  
  @Test
  public void isAuthorized() throws Exception {
    String requiredBody = "{\n"
            + "  \"name\": \"Process improver\",\n"
            + "  \"level\": \"1\",\n"
            + "  \"name\": English speaker\n"
            + "  \"level\": \"1\",\n"
            + "  \"name\": \"Feedback giver\",\n"
            + "  \"level\": \"1\",\n"
            + "}".replaceAll("\\s", "");

    mockMvc.perform(get("/api/badges").header("authorization","author"))
            .andExpect(status().isOk())
            .andExpect(content().string(requiredBody))
            .andDo(print())
            .andReturn();
  }

  @Test
  public void statusIsUnauthorized() throws Exception {
    mockMvc.perform(get("/api/badges"))
            .andExpect(status().isUnauthorized())
            .andExpect(content().string(Message.badgeUnsuccessfulBody))
            .andDo(print())
            .andReturn();
  }
}