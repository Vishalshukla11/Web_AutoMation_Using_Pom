package com.example.Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Log4jUtil {
    //create a logger instance 
    private static final Logger logger=  LogManager.getLogger(Log4jUtil.class);

    //method to get logger
    public static Logger getLogger()
    {
        return logger;
    }

    //Example methods for logging

    
    
}
