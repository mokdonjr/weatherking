package com.example.weatherking;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "API 조회")
public class HomeController extends BaseBean {

//    @GetMapping("/")
//    public String home() {
//        return "redirect:/swagger-ui.html";
//    }

    @GetMapping("/")
    public @ResponseBody String home() {
        return "<h3>프로토콜 변경 작업중. 임시 폐쇄</h3><p>https://github.com/mokdonjr/weatherking-server/commits/master</p> ";
    }
}
