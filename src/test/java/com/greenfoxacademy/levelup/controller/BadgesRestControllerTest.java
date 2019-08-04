package com.greenfoxacademy.levelup.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.repository.IBadgeRepository;
import com.greenfoxacademy.levelup.service.BadgeServiceImp;
import com.greenfoxacademy.levelup.service.IBadgeService;
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

@RunWith(SpringRunner.class)
@WebMvcTest
public class BadgesRestControllerTest {

  private Badge badge;

  @Autowired
  private MockMvc mockMvc;

  @InjectMocks
  private IBadgeService badgeServiceImp;

  @MockBean
  private IBadgeRepository badgeRepository;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    badge = new Badge("2.3", "Process improver/initator", "general");
  }

  @Test
  public void testIfAuthorizationOK_thenReturnsStatusOk() throws Exception {
    mockMvc.perform(get("/api/badge/1")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(status().isOk())
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testWhenStatusIsUnauthorized_thenReturnsStatusUnauthorized() throws Exception {
    mockMvc.perform(get("/api/badges")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andExpect(status().isUnauthorized())
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testWhenStatusIsUnauthorized_thenReturnsUnauthorizedErrorBodyd() throws Exception {
    mockMvc.perform(get("/api/badges")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andExpect(content().string(Message.UNAUTHORIZED_BODY))
        .andDo(print())
        .andReturn();
  }

  @TestConfiguration
  static class BadgeServiceImpTestContextConfiguration {
    @Bean
    public BadgeServiceImp badgeService() {
      return new BadgeServiceImp();
    }
  }
}
