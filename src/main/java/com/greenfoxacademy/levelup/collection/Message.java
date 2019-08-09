package com.greenfoxacademy.levelup.collection;

public class Message {

  public static final String AUTHORIZATION_DENIED = "Denied";
  public static final String SUCCESSFUL_BODY = "{{\"message\":\"Success\"}";
  public static final String PITCH_POST_REQUIRED_BODY = "{\"pitcherName\":\"\",\"badgeName\":\"englishspeaker\",\"newStatus\":\"\",\"newMessage\":\"\"}";
  public static final String PITCH_REQUIRED_BODY = "{\"badgeName\": \"English speaker\",\"oldLVL\": 2,\"pitchMessage\": \"Hello World! My English is bloody gorgeous.\",\"holders\": [\"balazs.jozsef\", \"benedek.vamosi\", \"balazs.barna\"]}";
  public static final String HEADER_NAME = "Authorization";
  public static final String AUTHORIZATION_OK = "Ok";
  public static final String UNAUTHORIZED_BODY = "{\"error\":\"Unauthorized\"}";
  public static final String BODY = "{\"myPitches\":[{\"timestamp\":\"2018-11-2917:10:47\",\"username\":\"balazs.barna\",\"badgeName\":\"Programming\",\"oldLevel\":2,\"pitchedLevel\":3,\"pitchMessage\":\"Iimproved in React, Redux, basicJS, NodeJS, Express and in LowDB, pls give me more money\",\"holders\":[{\"name\":\"sandor.vass\",\"message\":null,\"pitchStatus\":false},],}],\"pitchesToReview\":[{\"timestamp\":\"2018-11-2917:10:47\",\"username\":\"berei.daniel\",\"badgeName\":\"Englishspeaker\",\"oldLevel\":2,\"pitchedLevel\":3,\"pitchMessage\":\"I was working abroad for six years, so I can speak english very well. Pls improve my badgelevelt o 3.\",\"holders\":[{\"name\":\"balazs.jozsef\",\"message\":\"Yes, you are able to speak english\",\"pitchStatus\":true}]}";
  public static final String CREATED_BODY = "{\"message\": \"Created\"}";
  public static final String UNSUCCESSFUL_BODY = "{\"error\": \"Please provide all fields\"}";
  public static final String ADDADMIN_BODY = "{\"version\": \"2.3\",\"name\": \"Badge inserter\",\"tag\": \"general\",\"levels\": [1, 2, 3, 4]}";
  public static final String BADGE_SUCCESFUL_BODY = "{\"name\": \"Process improver\",\"level\": \"1\",\"name\": English speaker\"level\": \"1\", \"name\": \"Feedback giver\",\"level\": \"1\",}";
  public static final String UPDATED_STATUS = "{\"message\": \"Updated\"}";
  public static final String BADGE_FULL_BODY = "{\"version\":\"2.3\",\n" +
      "   \"name\":\"Process improver/initator\",\n" +
      "   \"tag\":\"general\",\n" +
      "   \"levels\":[  \n" +
      "      {  \n" +
      "         \"level\":1,\n" +
      "         \"weight\":2,\n" +
      "         \"description\":\"I can see through processes and propose relevant and doable ideas for improvement. I can create improved definition / accountibility / documentation and communicate it to the team\"\n" +
      "      }\n" +
      "   ]}";
}
