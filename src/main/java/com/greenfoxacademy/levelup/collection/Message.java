package com.greenfoxacademy.levelup.collection;

public class Message {

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
