package com.greenfoxacademy.levelup.controller_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfoxacademy.levelup.controller.IPitchRestInterface;
import com.greenfoxacademy.levelup.controller.PitchRestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PitchRestControllerTest {
  @Mock
  PitchRestController pitchRestController;

  @Autowired
  MockMvc mockMvc;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void whenAuthorizationIsOk_thenReturnsStatusCode201() throws Exception {
    mockMvc.perform(post("/api/pitch")
      .contentType(MediaType.APPLICATION_JSON)
      .content(IPitchRestInterface.PITCH_REQUIRED_BODY))
      .andExpect(status().isCreated());
  }

  @Test
  public void whenStatusIsUnauthorized_thenReturnsStatusCode401() throws Exception {
    pitchRestController.setAuthorization(false);

    mockMvc.perform(post("/api/pitch")
      .contentType(MediaType.APPLICATION_JSON)
      .content(IPitchRestInterface.PITCH_REQUIRED_BODY))
      .andExpect(status().is4xxClientError());
  }

  @Test
  public void whenMissingField_thenReturnsStatusCode404() throws Exception {
    pitchRestController.setAuthorization(false);
    pitchRestController.setMissingFields(true);

    mockMvc.perform(post("/api/pitch")
        .contentType(MediaType.APPLICATION_JSON)
        .content(IPitchRestInterface.PITCH_REQUIRED_BODY))
        .andExpect(status().isNotFound());
  }
}