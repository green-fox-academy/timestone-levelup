package com.greenfoxacademy.levelup.controller_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfoxacademy.levelup.controller.IPitchRestController;
import com.greenfoxacademy.levelup.controller.PitchRestController;
import com.greenfoxacademy.levelup.model.Mandatory;
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
  @Autowired
  MockMvc mockMvc;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void whenAuthorizationIsOkAndHasNoMissingField_thenReturnsStatusCode201() throws Exception {

    mockMvc.perform(put("/api/pitch")
      .contentType(MediaType.APPLICATION_JSON)
      .content(IPitchRestController.PITCH_REQUIRED_BODY)
      .header("Authorization", "Full"))
      .andExpect(jsonPath("$.pitcherName").value(""))
      .andExpect(status().isOk());
  }

  @Test
  public void whenAuthorizationIsOkAndHasMissingField_thenReturnsStatusCode404() throws Exception {
    mockMvc.perform(put("/api/pitch")
      .contentType(MediaType.APPLICATION_JSON)
      .content(IPitchRestController.PITCH_REQUIRED_BODY)
      .header("Authorization", "Full"))
      .andExpect(status().isNotFound());
  }

  @Test
  public void whenAuthorizationIsUnsuccessful_thenReturnsStatusCode401() throws Exception {
    mockMvc.perform(put("/api/pitch")
      .contentType(MediaType.APPLICATION_JSON)
      .content(IPitchRestController.PITCH_REQUIRED_BODY)
      .header("Authorization", "Deny"))
      .andExpect(status().is4xxClientError());
  }
}