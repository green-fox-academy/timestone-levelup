package com.greenfoxacademy.levelup.controller;

public class IPitchRestInterface {
  public static String PITCH_REQUIRED_BODY = "{\n"
          + "  \"badgeName\": \"English speaker\",\n"
          + "  \"oldLVL\": 2,\n"
          + "  \"pitchedLVL\": 3,\n"
          + "  \"pitchMessage\": \"Hello World! My English is bloody gorgeous.\",\n"
          + "  \"holders\": [\"balazs.jozsef\", \"benedek.vamosi\", \"balazs.barna\"]\n"
          + "}".replaceAll("\\s", "");

  public static String PITCH_SUCCESSFUL_BODY = "{\n"
          + "  \"message\": \"Created\"\n"
          + "}".replaceAll("\\s", "");

  public static String PITCH_UNAUTHORIZED_BODY = "{\n"
          + "  \"error\": \"Unauthorizied\"\n"
          + "}".replaceAll("\\s", "");

  public static String PITCH_UNSUCCESFUL_BODY = "{\n"
          + "  \"error\": \"Please provide all fields\"\n"
          + "}".replaceAll("\\s", "");
}