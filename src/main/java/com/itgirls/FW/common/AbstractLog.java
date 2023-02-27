package com.itgirls.FW.common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractLog {

    protected static Logger logger;

    public AbstractLog() {
        this.logger = getLogger(this.getClass().getName());
    }

    private static Logger getLogger(String className) {
        return LogManager.getLogger(className);
    }


}
