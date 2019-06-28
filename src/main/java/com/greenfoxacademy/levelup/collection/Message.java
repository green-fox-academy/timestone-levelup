package com.greenfoxacademy.levelup.collection;

public class Message {
  public static final String AUTHORIZATION = "Authorization";
  public static final String AUTHORIZATION_OK = "Ok";
  public static final String AUTHORIZATION_DENIED = "Denied";



  public static final String PITCH_SUCCESSFUL_BODY = "{\n"
      + "  \"message\": \"Success\"\n"
      + "}".replaceAll("\\s", "");

  public static final String PITCH_UNAUTHORIZED_BODY = "{\n"
      + "  \"error\": \"Unauthorizied\"\n"
      + "}".replaceAll("\\s", "");

  public static final String PITCH_UNSUCCESFUL_BODY = "{\n"
      + "  \"error\": \"Please provide all fields\"\n"
      + "}".replaceAll("\\s", "");

  public static final String PITCH_REQUIRED_BODY = "{"
      + "    \t\"pitcherName\": \"\",\n"
      + "    \t\"badgeName\": \"english speaker\",\n"
      + "    \t\"newStatus\": \"\",\n"
      + "    \t\"newMessage\": \"\"\n"
      + "    }";
}
