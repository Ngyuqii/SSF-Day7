package ssf.ws17.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import jakarta.json.JsonObject;

public class SunTimings implements Serializable{
  private String sunrise;
  private String sunset;
  
  // Getters
  public String getSunrise() {
    return sunrise;
  }
  public String getSunset() {
    return sunset;
  }

  //Setters
  public void setSunrise(String sunrise) {
    this.sunrise = sunrise;
  }
  public void setSunset(String sunset) {
    this.sunset = sunset;
  }

  // Convert long to Date
  public static String toLocalDateTime(long suntime){
    LocalDateTime converted = LocalDateTime.ofInstant(Instant.ofEpochMilli(suntime), TimeZone.getDefault().toZoneId());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String convertedDT = converted.format(formatter);
    return convertedDT;
  }

  //Return suntiming object from json
  public static SunTimings createFromJson(JsonObject jsonObj){
    SunTimings st = new SunTimings();
    long sunriseL = jsonObj.getJsonObject("sys").getJsonNumber("sunrise").longValue();
    long sunsetL = jsonObj.getJsonObject("sys").getJsonNumber("sunset").longValue();
    st.sunrise = toLocalDateTime(sunriseL*1000);
    st.sunset = toLocalDateTime(sunsetL*1000);
    return st;
  }
 
}