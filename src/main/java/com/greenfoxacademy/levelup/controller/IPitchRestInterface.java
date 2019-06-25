package com.greenfoxacademy.levelup.controller;

public interface IPitchRestInterface {

  static final String PITCH_SUCCESSFUL_BODY = "{\n"
      + "  \"message\": \"Created\"\n"
      + "}";

  static final String PITCH_UNAUTHORIZED_BODY = "{\n"
      + "  \"error\": \"Unauthorizied\"\n"
      + "}";

  static final String PITCH_UNSUCCESFUL_BODY = "{\n"
      + "  \"error\": \"Please provide all fields\"\n"
      + "}";
}