package ssf.ws17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.ws17.model.Weather;
import ssf.ws17.service.WeatherService;

@Controller
public class WeatherController {

  @Autowired
  WeatherService weatherSvc;
  
  @GetMapping("/weather")
  public String getWeather(@RequestParam(value="city", required=true) String city, 
  @RequestParam(required=false) String units, Model model){

    //Set metrics units as default
    if(units == null) {
      units = "metric";
    }

    // Call WeatherService
    Weather weather = weatherSvc.getFromWeatherAPI(city).get();
    model.addAttribute("weather", weather);
    return "weather";
  }
}
