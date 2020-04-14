package com.example.weatherking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseBean extends StaticBaseBean {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
