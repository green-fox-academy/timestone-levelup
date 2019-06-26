package com.greenfoxacademy.levelup.controller_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
  private Mandatory mandatory = new Mandatory();

  @Mock
  PitchRestController pitchRestController;

  @Autowired
  MockMvc mockMvc;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mandatory.setBadgeName("badge");
    mandatory.setNewMessage("message");
    mandatory.setPitcherName("pitcher name");
    mandatory.setNewStatus("status");
  }

  @Test
  public void whenAuthorizationIsOkAndHasNoMissingField_thenReturnsStatusCode201() throws Exception {
    pitchRestController
        .setHeader(IPitchRestController.AUTHORIZATION, IPitchRestController.AUTHORIZATION_VALUES[0]);

    mockMvc.perform(put("/api/pitch")
        .contentType(MediaType.APPLICATION_JSON)
        .content(IPitchRestController.PITCH_REQUIRED_BODY))
        .andExpect(status().isOk());
  }

  @Test
  public void whenAuthorizationIsOkAndHasMissingField_thenReturnsStatusCode404() throws Exception {
    pitchRestController
        .setHeader(IPitchRestController.AUTHORIZATION, IPitchRestController.AUTHORIZATION_VALUES[0]);
    mandatory.setNewStatus(null);

    mockMvc.perform(put("/api/pitch")
        .contentType(MediaType.APPLICATION_JSON)
        .content(IPitchRestController.PITCH_REQUIRED_BODY))
        .andExpect(status().isNotFound());
  }

  @Test
  public void whenAuthorizationIsUnsuccessful_thenReturnsStatusCode401() throws Exception {
    pitchRestController
        .setHeader(IPitchRestController.AUTHORIZATION, IPitchRestController.AUTHORIZATION_VALUES[1]);

    mockMvc.perform(put("/api/pitch")
        .contentType(MediaType.APPLICATION_JSON)
        .content(IPitchRestController.PITCH_REQUIRED_BODY))
        .andExpect(status().is4xxClientError());
  }
}