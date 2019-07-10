package com.greenfoxacademy.levelup.utility;

import com.greenfoxacademy.levelup.model.SlackNotification;
import java.io.IOException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;

public class SlackNotificationUtil {


  @Value("#{environment.WEBHOOK_URL}")
  private static String slackWebhookUrl;

  public static void sendMessage(SlackNotification message) {
    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(slackWebhookUrl);

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      String json = objectMapper.writeValueAsString(message);

      StringEntity entity = new StringEntity(json);
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
