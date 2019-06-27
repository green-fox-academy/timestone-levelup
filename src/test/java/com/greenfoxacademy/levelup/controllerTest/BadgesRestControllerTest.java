package com.greenfoxacademy.levelup.controllerTest;

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

    mockMvc.perform(get("/api/badges").header("authorization","author"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.badges").exists())
            .andExpect(content().string("{\"badges\":[{\"name\":\"Process improver\",\"level\":\"2\"},{\"name\":\"English speaker\",\"level\":\"1\"},{\"name\":\"Feedback giver\",\"level\":\"1\"}]}"))
            .andDo(print())
            .andReturn();
  }

  @Test
  public void statusIsUnauthorized() throws Exception {
    mockMvc.perform(get("/api/badges"))
            .andExpect(status().isUnauthorized())
            .andExpect(jsonPath("$.error").exists())
            .andExpect(jsonPath("$.error").value("Unauthorized"))
            .andDo(print())
            .andReturn();
  }
}