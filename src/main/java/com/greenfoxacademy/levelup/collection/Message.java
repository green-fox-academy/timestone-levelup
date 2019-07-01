package com.greenfoxacademy.levelup.collection;

public class Message {

  public static String badgeSuccessfulBody  = "{\n"
          + "  \"name\": \"Process improver\",\n"
          + "  \"level\": \"1\",\n"
          + "  \"name\": English speaker\n"
          + "  \"level\": \"1\",\n"
          + "  \"name\": \"Feedback giver\",\n"
          + "  \"level\": \"1\",\n"
          + "}".replaceAll("\\s", "");

  public static String badgeUnsuccessfulBody = "{\n"
          + "  \"error\": \"Unauthorized\"\n"
          + "}".replaceAll("\\s", "");
}
