package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.SlackNotification;

public interface ISlackNotificationService {

  void sendSlackNotification(SlackNotification slackNotification);
}
