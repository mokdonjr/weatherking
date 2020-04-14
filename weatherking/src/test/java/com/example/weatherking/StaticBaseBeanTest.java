package com.example.weatherking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StaticBaseBeanTest {
    protected static Logger loggerStatic = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
}
