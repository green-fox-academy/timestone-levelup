package com.greenfoxacademy.levelup.collection;

public class Message {
  public static final String AUTHORIZATION = "Authorization";
  public static final String AUTHORIZATION_OK = "Ok";
  public static final String AUTHORIZATION_DENIED = "Denied";
  public static final String ERROR_BODY = "{\n"
      + "  \"error\": \"Unauthorizied\"\n"
      + "}".replaceAll("\\s", "");
  public static final String BODY = "{\n"
      + "  \"myPitches\": [\n"
      + "    {\n"
      + "      \"timestamp\": \"2018-11-29 17:10:47\",\n"
      + "      \"username\": \"balazs.barna\",\n"
      + "      \"badgeName\": \"Programming\",\n"
      + "      \"oldLevel\": 2,\n"
      + "      \"pitchedLevel\": 3,\n"
      + "      \"pitchMessage\": \"I improved in React, Redux, basic JS, NodeJS, Express and in LowDB, pls give me more money\",\n"
      + "      \"holders\": [\n"
      + "        {\n"
      + "          \"name\": \"sandor.vass\",\n"
      + "          \"message\": null,\n"
      + "          \"pitchStatus\": false\n"
      + "        },...\n"
      + "      ],\n"
      + "    }\n"
      + "  ],\n"
      + "    \"pitchesToReview\": [\n"
      + "      {\n"
      + "        \"timestamp\": \"2018-11-29 17:10:47\",\n"
      + "        \"username\": \"berei.daniel\",\n"
      + "        \"badgeName\": \"English speaker\",\n"
      + "        \"oldLevel\": 2,\n"
      + "        \"pitchedLevel\": 3,\n"
      + "        \"pitchMessage\": \"I was working abroad for six years, so I can speak english very well. Pls improve my badge level to 3.\",\n"
      + "        \"holders\": [\n"
      + "          {\n"
      + "            \"name\": \"balazs.jozsef\",\n"
      + "            \"message\": \"Yes, you are able to speak english\",\n"
      + "            \"pitchStatus\": true\n"
      + "          },...\n"
      + "        ]\n"
      + "      }".replaceAll("\\s", "");
}