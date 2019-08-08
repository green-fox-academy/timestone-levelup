package com.greenfoxacademy.levelup.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Pitch;
import com.greenfoxacademy.levelup.repository.IPitchRepository;
import com.greenfoxacademy.levelup.service.PitchServiceImp;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PitchesRestController.class, secure = false)
public class PitchesRestControllerTest {

  Pitch pitch = new Pitch();
  List<Pitch> pitchList = new ArrayList<>();

  @Autowired
  MockMvc mockMvc;

  @InjectMocks
  PitchServiceImp pitchService;

  @MockBean
  IPitchRepository pitchRepository;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    pitch = new Pitch(2, "message");
    pitchList = new ArrayList<>();
    pitchList.add(pitch);
  }

  @Test
  public void whenAuthorizationIsOk_thenReturnsByPitchesApiBody() throws Exception {
    when(pitchRepository.findAll()).thenReturn(pitchList);

    doMockMvcPerformGet(Message.AUTHORIZATION_OK)
        .andExpect(content().string(new Gson().toJson(pitch)))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void whenAuthorizationIsOk_thenReturnsByStatusCode200() throws Exception {
    doMockMvcPerformGet(Message.AUTHORIZATION_OK)
        .andExpect(status().isOk())
        .andDo(print())
        .andReturn();
  }

  @Test
  public void whenAuthorizationDenied_thenReturnsByErrorBody() throws Exception {
    doMockMvcPerformGet(Message.AUTHORIZATION_DENIED)
        .andExpect(content().string(Message.UNAUTHORIZED_BODY))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void whenGetAuthorizationDenied_thenReturnsByStatusCode401() throws Exception {
    doMockMvcPerformGet(Message.AUTHORIZATION_DENIED)
        .andExpect(status().isUnauthorized())
        .andDo(print())
        .andReturn();
  }

  private ResultActions doMockMvcPerformGet(String authorization) throws Exception {
    return mockMvc.perform(get("/api/pitches")
        .header(Message.HEADER_NAME, authorization));
  }

  @TestConfiguration
  static class PitchServiceImpTestContextConfiguration {

    @Bean
    public PitchServiceImp pitchService() {
      return new PitchServiceImp();
    }
  }
}
