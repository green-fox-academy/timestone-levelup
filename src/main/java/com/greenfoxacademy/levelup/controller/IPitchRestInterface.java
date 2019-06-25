package com.greenfoxacademy.levelup.controller;

public interface IPitchRestInterface {

  static final String PITCH_REQUIRED_BODY = "{\n"
      + "  \"badgeName\": \"English speaker\",\n"
      + "  \"oldLVL\": 2,\n"
      + "  \"pitchedLVL\": 3,\n"
      + "  \"pitchMessage\": \"Hello World! My English is bloody gorgeous.\",\n"
      + "  \"holders\": [\"balazs.jozsef\", \"benedek.vamosi\", \"balazs.barna\"]\n"
      + "}".replaceAll("\\s", "");

  static final String PITCH_SUCCESSFUL_BODY = "{\n"
      + "  \"message\": \"Created\"\n"
      + "}".replaceAll("\\s", "");

  static final String PITCH_UNAUTHORIZED_BODY = "{\n"
      + "  \"error\": \"Unauthorizied\"\n"
      + "}".replaceAll("\\s", "");

  static final String PITCH_UNSUCCESFUL_BODY = "{\n"
      + "  \"error\": \"Please provide all fields\"\n"
      + "}".replaceAll("\\s", "");
}