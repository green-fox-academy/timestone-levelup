package com.greenfoxacademy.levelup.collection;

public class Message {

  static final String HEADER_NAME = "Authorization";
  static final String UNAUTHORIZED_BODY = "{\n"
      + "  \"error\": \"Unauthorizied\"\n"
      + "}".replaceAll("\\s", "");
  static final String SUCCESSFUL_BODY = "{\n"
      + "  \"message\": \"Created\"\n"
      + "}".replaceAll("\\s", "");
  static final String UNSUCCESSFUL_BODY = "{\n"
      + "  \"error\": \"Please provide all fields\"\n"
      + "}".replaceAll("\\s", "");
  static final String AUTHORIZED_BODY = "{\n"
      + "  \"message\": \"OK\"\n"
      + "}".replaceAll("\\s", "");
  static final String ADDADMIN_BODY = "{\n" +
      "  \"version\": \"2.3\",\n" +
      "  \"name\": \"Badge inserter\",\n" +
      "  \"tag\": \"general\",\n" +
      "  \"levels\": [1, 2, 3, 4]\n" +
      "}".replaceAll("\\s", "");

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