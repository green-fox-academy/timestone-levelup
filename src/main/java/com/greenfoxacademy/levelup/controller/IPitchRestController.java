package com.greenfoxacademy.levelup.controller;

public interface IPitchRestController {

  static final String AUTHORIZATION = "Authorization";
  static final String AUTH_OK = "Ok";
  static final String AUTH_UNAUTHORIZED = "Unauthorized";
  static final String PITCH_SUCCESSFUL_BODY = "{\n"
      + "  \"message\": \"Created\"\n"
      + "}".replaceAll("\\s", "");

  static final String PITCH_UNAUTHORIZED_BODY = "{\n"
      + "  \"error\": \"Unauthorizied\"\n"
      + "}".replaceAll("\\s", "");

  static final String PITCH_UNSUCCESFUL_BODY = "{\n"
      + "  \"error\": \"Please provide all fields\"\n"
      + "}".replaceAll("\\s", "");

  static final String PITCH_REQUIRED_BODY = "{\n"
      + "    \"mandatory fields\":\n"
      + "    {\n"
      + "    \t\"pitcherName\": \"\",\n"
      + "    \t\"badgeName\": \"english speaker\",\n"
      + "    \t\"newStatus\": \"\",\n"
      + "    \t\"newMessage\": \"\"\n"
      + "    }\n"
      + "}";
}