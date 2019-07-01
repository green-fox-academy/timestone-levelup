package com.greenfoxacademy.levelup.collection;

public class Message {

  static final String HEADER_NAME = "Authorization";
  static final String UNAUTHORIZED_BODY = "{"
      + "  \"error\": \"Unauthorizied\""
      + "}";
  static final String SUCCESSFUL_BODY = "{"
      + "  \"message\": \"Created\""
      + "}";
  static final String UNSUCCESSFUL_BODY = "{"
      + "  \"error\": \"Please provide all fields\""
      + "}";
  static final String AUTHORIZED_BODY = "{"
      + "  \"message\": \"OK\""
      + "}";
  static final String ADDADMIN_BODY = "{" +
      "  \"version\": \"2.3\"," +
      "  \"name\": \"Badge inserter\"," +
      "  \"tag\": \"general\"," +
      "  \"levels\": [1, 2, 3, 4]" +
      "}";

  public static String getHeaderName() {
    return HEADER_NAME;
  }

  public static String getUnauthorizedBody() {
    return UNAUTHORIZED_BODY;
  }

  public static String getSuccessfulBody() {
    return SUCCESSFUL_BODY;
  }

  public static String getUnsuccessfulBody() {
    return UNSUCCESSFUL_BODY;
  }

  public static String getAuthorizedBody() {
    return AUTHORIZED_BODY;
  }

  public static String getAddadminBody() {
    return ADDADMIN_BODY;
  }
}
