package ssf.ws17.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Weather implements Serializable{
  private Conditions conditions;
  private float temp;
  private SunTimings suntimings;
  private String city;

  // Getters
  public Conditions getConditions() {
    return conditions;
  }
  public float getTemp() {
    return temp;
  }
  public SunTimings getSuntimings() {
    return suntimings;
  }
  public String getCity() {
    return city;
  }

  //Setters
  public void setConditions(Conditions conditions) {
    this.conditions = conditions;
  }
  public void setTemp(float temp) {
    this.temp = temp;
  }
  public void setSuntimings(SunTimings suntimings) {
    this.suntimings = suntimings;
  }
  public void setCity(String city) {
    this.city = city;
  }

  //Take in json string from weather api and convert to main object - weather
  //Unmarshalling from string / deserialization
  public static Weather create(String json){
    Weather weather = new Weather();

    try(InputStream is = new ByteArrayInputStream(json.getBytes())) {
      JsonReader jsonreader = Json.createReader(is);
      JsonObject jsonObj = jsonreader.readObject();

      float temperature = Float.parseFloat(jsonObj.getJsonObject("main").getJsonNumber("temp").toString());
      weather.setTemp(temperature);
      weather.setCity(jsonObj.getString("name"));

      Conditions condition = Conditions.createFromJson(jsonObj.getJsonArray("weather"));
      weather.setConditions(condition);

      SunTimings suntimings = SunTimings.createFromJson(jsonObj);
      weather.setSuntimings(suntimings);

    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
    return weather;
  }
  
}