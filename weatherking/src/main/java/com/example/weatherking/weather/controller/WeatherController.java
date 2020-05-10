package com.example.weatherking.weather.controller;

import com.example.weatherking.BaseBean;
import com.example.weatherking.vfinfo.common.data.response.VFResponseDefault;
import com.example.weatherking.weather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/weather")
@RestController
@Api(tags = "날씨")
public class WeatherController extends BaseBean {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/normal")
    @ApiOperation(value = "동네예보조회")
    public ResponseEntity<VFResponseDefault> weatherNormal(@RequestParam("nx") int nx, @RequestParam("ny") int ny) throws JSONException {
        var response = weatherService.getWeatherNormalByLocation(nx, ny);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/forecast")
    @ApiOperation(value = "초단기예보조회")
    public ResponseEntity<VFResponseDefault> weatherForecast(@RequestParam("nx") int nx, @RequestParam("ny") int ny) throws JSONException {
        var response = weatherService.getWeatherUltraForecastByLocation(nx, ny);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/current")
    @ApiOperation(value = "초단기실황조회")
    public ResponseEntity<VFResponseDefault> weatherCurrent(@RequestParam("nx") int nx, @RequestParam("ny") int ny) throws JSONException {
        var response = weatherService.getWeatherUltraCurrentByLocation(nx, ny);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
