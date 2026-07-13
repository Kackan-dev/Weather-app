# Weather-app
This is a backend application that provides a weather forecast by city name.

It uses two apis:
City coordinates: "https://geocoding-api.open-meteo.com/v1/search"
Weather Forecast "https://api.open-meteo.com/v1/forecast"

To run the application, clone the repository, build the image using the provided Dockerfile and start is as a docker container.
To test the application, I recommend using postman, you can use the following URL http://localhost:8080/api/v1/forecast/{cityname}/week
