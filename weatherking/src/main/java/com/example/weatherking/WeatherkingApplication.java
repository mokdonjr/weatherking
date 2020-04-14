package com.example.weatherking;

import com.example.weatherking.util.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherkingApplication extends StaticBaseBean {

	public static void main(String[] args) {
		LogUtil.runWithStopWatch("어플리케이션 부팅 시간", () -> {
			SpringApplication.run(WeatherkingApplication.class, args);
		});
	}

}
