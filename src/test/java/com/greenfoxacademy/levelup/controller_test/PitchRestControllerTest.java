package com.greenfoxacademy.levelup.controller_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.greenfoxacademy.levelup.collection.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PitchRestControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void whenAuthorizationIsOk_thenReturnsStatusCode201() throws Exception {

    mockMvc.perform(post("/api/pitch")
            .header("Authorization", "author")
            .contentType(MediaType.APPLICATION_JSON)
            .content(Message.pitchRequiredBody))
            .andExpect(status().isCreated());
  }

  @Test
  public void whenStatusIsUnauthorized_thenReturnsStatusCode401() throws Exception {

    mockMvc.perform(post("/api/pitch")
            .contentType(MediaType.APPLICATION_JSON)
            .content(Message.pitchRequiredBody))
            .andExpect(status().is4xxClientError());
  }

  @Test
  public void whenMissingField_thenReturnsStatusCode404() throws Exception {

    String requiredBody = "{\n"
            + "  \"oldLVL\": 2,\n"
            + "  \"pitchedLVL\": 3,\n"
            + "  \"pitchMessage\": \"Hello World! My English is bloody gorgeous.\",\n"
            + "  \"holders\": [\"balazs.jozsef\", \"benedek.vamosi\", \"balazs.barna\"]\n"
            + "}".replaceAll("\\s", "");

    mockMvc.perform(post("/api/pitch").header("Authorization", "author")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requiredBody))
            .andExpect(status().isNotFound());
  }
}