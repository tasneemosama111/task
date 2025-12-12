package com.swaglabs.Utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {
    //we're doing function to get

    public static final String ALLURE_RESULTS_PATH ="test-outputs/allure-results";

    private AllureUtils(){

        super();
    }
    public static void attachLogzToAllureReport(){
        // bnddah 3al latest file function ely mawgoda fl fileUtils

        try {

            File logFile = FilesUtils.getLatestFiles(LogsUtil.LOGS_PATH);
            if (!logFile.exists()){
                LogsUtil.warn("Log file does not exist : " +LogsUtil.LOGS_PATH);
                return;
            }
            // haygeb el string ely gwa el logs w y3melo attach ll report
            Allure.addAttachment("Logs.log" , Files.readString(Path.of(logFile.getPath())));
            LogsUtil.info("logs attached to Allure report");
         }
        catch (Exception e){
            LogsUtil.error("failed to attach logs to allure report: " + e.getMessage());
        }
    }



}
