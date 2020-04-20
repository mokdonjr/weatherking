package com.example.weatherking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class StaticBaseBeanTest {
    protected static Logger loggerStatic = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
}
