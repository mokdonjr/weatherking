package com.example.weatherking.weather.controller;

import com.example.weatherking.BaseBean;
import com.example.weatherking.util.JsonUtil;
import com.example.weatherking.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController extends BaseBean {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/normal")
    public String weatherNormal(@RequestParam("nx") int nx, @RequestParam("ny") int ny) throws JSONException {
        return JsonUtil.prettyIndentJson(weatherService.getWeatherNormalByLocation(nx, ny));
    }

    @GetMapping("/forecast")
    public String weatherForecast(@RequestParam("nx") int nx, @RequestParam("ny") int ny) throws JSONException {
        return JsonUtil.prettyIndentJson(weatherService.getWeatherUltraForecastByLocation(nx, ny));
    }

    @GetMapping("/current")
    public String weatherCurrent(@RequestParam("nx") int nx, @RequestParam("ny") int ny) throws JSONException {
        return JsonUtil.prettyIndentJson(weatherService.getWeatherUltraCurrentByLocation(nx, ny));
    }
}
