package com.example.weatherking;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(tags = "API 조회")
public class HomeController extends BaseBean {

    @GetMapping("/")
    public String home() {
        return "redirect:/swagger-ui.html";
    }
}
