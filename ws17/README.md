## Workshop 17
Make HTTP invocations to other REST endpoint from a SpringBoot application.

### Task 1
- Write a service called WeatherService to query the weather of a city with the following endpoint https://api.openweathermap.org/data/2.5/weather?q=<city>&appid=<API key> where <city> is the city and <API key> is your account’s API key.
- OpenWeather API key (Windows) >>
set OPEN_WEATHER_MAP_API_KEY=<your api key>

### Task 2
- Write a landing page (index.html) to allow users to input city. When the submit button is pressed, the HTML form will send the following HTTP request to your Spring controller (GET /weather?q=<city>).
- Use the WeatherService from Task 1 to get the weather details from Openweathermap. The result should be in metric. If no city is specified default to a city of your choice, eg Singapore.

### Task 3
- Display the following information from the returned result
1. One or more details from weather
i. main
ii. description
iii. icon as PNG
2. Temperature from main
3. Sunrise and sunset from sys
4. Time when the weather is recorded from dt

### Task 4
- Deploy to Railway.