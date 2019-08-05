package com.greenfoxacademy.levelup.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.repository.IBadgeRepository;
import com.greenfoxacademy.levelup.service.BadgeServiceImp;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BadgesRestController.class, secure = false)
public class BadgesRestControllerTest {

  private Badge badge;

  @Autowired
  private MockMvc mockMvc;

  @InjectMocks
  private BadgeServiceImp badgeService;

  @MockBean
  private IBadgeRepository badgeRepository;

  /*@Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    badge = new Badge("2.3", "Process improver/initator", "general");
  }*/

  @Test
  public void isAuthorized() throws Exception {
    mockMvc.perform(get("/api/badges").header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andExpect(status().isOk())
        .andExpect(content().string(Message.BADGE_SUCCESFUL_BODY))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void statusIsUnauthorized() throws Exception {
    mockMvc.perform(get("/api/badges")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_DENIED))
        .andExpect(status().isUnauthorized())
        .andExpect(content().string(Message.UNAUTHORIZED_BODY))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testIfAuthorizationOK_thenReturnsStatusCreated() throws Exception {
    String requestContent = "{\"version\": \"2.3\",\"name\": \"Badge inserter\",\"tag\": \"general\",\"levels\": [1, 2, 3, 4]}";

    mockMvc.perform(post("/api/badges")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestContent)
        .characterEncoding("utf-8")
        .header(Message.HEADER_NAME, Message.AUTHORIZATION_OK))
        .andDo(print())
        .andExpect(status().isCreated());
  }






  @TestConfiguration
  static class BadgeServiceImpTestContextConfiguration {

    @Bean
    public BadgeServiceImp badgeService() {
      return new BadgeServiceImp();
    }
  }


}
