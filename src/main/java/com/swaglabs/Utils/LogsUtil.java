package com.swaglabs.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogsUtil {
    public static final String LOGS_PATH ="test-outputs/Logs" ;

    private LogsUtil(){
        super();

    }

    //// Returns a logger for the class that calls this method (auto-detects caller class)
    public static Logger logger (){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }
    public static void  trace(String...message){
        logger().trace(String.join("",message));
    }
    public static void  debug(String...message){
        logger().trace(String.join("",message));
    }
    public static void  info(String...message){
        logger().trace(String.join("",message));
    }
    public static void  warn(String...message){
        logger().trace(String.join("",message));
    } public static void  error(String...message){
        logger().trace(String.join("",message));
    }
    public static void  fatal(String...message){
        logger().trace(String.join("",message));
    }






}
