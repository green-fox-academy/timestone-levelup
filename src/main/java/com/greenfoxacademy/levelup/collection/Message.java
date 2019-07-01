package com.greenfoxacademy.levelup.collection;

public class Message {

  public static final String HEADER_NAME = "Authorization";
  public static final String AUTHORIZATION_OK = "Ok";
  public static final String UNAUTHORIZED_BODY = "Denied";
  public static final String ERROR_BODY = "{\"error\":\"Unauthorizied\"}";
  public static final String BODY = "{\"myPitches\":[{\"timestamp\":\"2018-11-2917:10:47\",\"username\":\"balazs.barna\",\"badgeName\":\"Programming\",\"oldLevel\":2,\"pitchedLevel\":3,\"pitchMessage\":\"IimprovedinReact,Redux,basicJS,NodeJS,ExpressandinLowDB,plsgivememoremoney\",\"holders\":[{\"name\":\"sandor.vass\",\"message\":null,\"pitchStatus\":false},...],}],\"pitchesToReview\":[{\"timestamp\":\"2018-11-2917:10:47\",\"username\":\"berei.daniel\",\"badgeName\":\"Englishspeaker\",\"oldLevel\":2,\"pitchedLevel\":3,\"pitchMessage\":\"Iwasworkingabroadforsixyears,soIcanspeakenglishverywell.Plsimprovemybadgelevelto3.\",\"holders\":[{\"name\":\"balazs.jozsef\",\"message\":\"Yes,youareabletospeakenglish\",\"pitchStatus\":true}]}";
  public static final String SUCCESSFUL_BODY = "{\"message\": \"Created\"}";
  public static final String UNSUCCESSFUL_BODY = "{\"error\": \"Please provide all fields\"}";
  public static final String ADDADMIN_BODY = "{\"version\": \"2.3\",\"name\": \"Badge inserter\",\"tag\": \"general\",\"levels\": [1, 2, 3, 4]}";
}
