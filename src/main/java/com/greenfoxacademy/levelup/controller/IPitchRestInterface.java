package com.greenfoxacademy.levelup.controller;

public class IPitchRestInterface {
  public static String pitchRequiredBody = "{\n"
          + "  \"badgeName\": \"English speaker\",\n"
          + "  \"oldLVL\": 2,\n"
          + "  \"pitchedLVL\": 3,\n"
          + "  \"pitchMessage\": \"Hello World! My English is bloody gorgeous.\",\n"
          + "  \"holders\": [\"balazs.jozsef\", \"benedek.vamosi\", \"balazs.barna\"]\n"
          + "}".replaceAll("\\s", "");

  public static String pitchSuccessfulBody = "{\n"
          + "  \"message\": \"Created\"\n"
          + "}".replaceAll("\\s", "");

  public static String pitchUnauthorizedBody = "{\n"
          + "  \"error\": \"Unauthorizied\"\n"
          + "}".replaceAll("\\s", "");

  public static String pitchUnsuccesfulBody = "{\n"
          + "  \"error\": \"Please provide all fields\"\n"
          + "}".replaceAll("\\s", "");
}