package com.example.weatherking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticBaseBean {
    protected static Logger loggerStatic = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
}
