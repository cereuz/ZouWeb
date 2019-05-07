package com.util;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/4/11 13:22.
 * @motto : To be, or not to be.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogY {
    // LoggerFactory.getLogger()方法的参数使用的是当前类的class
//    private static final Logger logger = LoggerFactory.getLogger(getClassName());
    private static final Logger logger = LoggerFactory.getLogger(LogY.class);

/*    private static final String path = "src/main/resources/logback.xml";

    static {
        LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure(path);
        } catch (JoranException e) {
            e.printStackTrace();
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
    }*/

    public static void main(String[] args) {
        logger.info("Hello, this is a line of log message logged by Logback");
    }


    public static void error(String msg) {
        logger.error(msg);
    }

    public static void error(String msg, Object... obj) {
        logger.error(msg, obj);
    }

    public static void warn(String msg) {
        logger.warn(msg);
    }

    public static void warn(String msg, Object... obj) {
        logger.warn(msg, obj);
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void info(String msg, Object... obj) {
        logger.info(msg, obj);
    }

    public static void debug(String msg) {
        logger.debug(msg);
    }

    public static void debug(String msg, Object... obj) {
        logger.debug(msg, obj);
    }

    public static void trace(String msg) {
        logger.trace(msg);
    }

    public static void trace(String msg, Object... obj) {
        logger.trace(msg, obj);
    }

    private static String getClassName() {
        return new SecurityManager() {
            public String getClassName() {
                return getClassContext()[3].getName();
            }
        }.getClassName();
    }
}

