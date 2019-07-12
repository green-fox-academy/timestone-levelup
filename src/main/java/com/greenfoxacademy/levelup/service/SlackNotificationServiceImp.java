package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.SlackNotification;
import java.io.IOException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SlackNotificationServiceImp implements ISlackNotificationService {

  private static String slackWebhookUrl;
  private ISlackNotificationService slackNotificationService;


  public SlackNotificationServiceImp(@Value("${WEBHOOK_URL}") String slackWebhookUrl) {
    SlackNotificationServiceImp.slackWebhookUrl = slackWebhookUrl;
  }

  @Override
  public void sendSlackNotification(SlackNotification slackNotification) {
    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(slackWebhookUrl);

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      String json = objectMapper.writeValueAsString(slackNotification);

      StringEntity entity = new StringEntity(json, "UTF-8");
      httpPost.setEntity(entity);
      httpPost.setHeader("Accept", "application/json");
      httpPost.setHeader("Content-type", "application/json");

      client.execute(httpPost);
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
