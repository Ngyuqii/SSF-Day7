package ssf.ws17.model;

import java.io.Serializable;

import jakarta.json.JsonArray;

public class Conditions implements Serializable{
  private String main;
  private String description;
  private String icon;

  // Getters
  public String getMain() {
    return main;
  }
  public String getDescription() {
    return description;
  }
  public String getIcon() {
    return icon;
  }

  //Setters
  public void setMain(String main) {
    this.main = main;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public void setIcon(String icon) {
    this.icon = icon;
  }
  
  //Return condition object from json array
  public static Conditions createFromJson(JsonArray jsonArr){
    Conditions condition = new Conditions();
    condition.main = jsonArr.get(0).asJsonObject().getString("main");
    condition.description = jsonArr.get(0).asJsonObject().getString("description");
    String iconUrl = "http://openweathermap.org/img/wn/";
    condition.icon = iconUrl+jsonArr.get(0).asJsonObject().getString("icon")+"@4x.png";
    return condition;
  }

  
}

