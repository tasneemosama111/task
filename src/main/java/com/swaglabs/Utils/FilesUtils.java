package com.swaglabs.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {
    private FilesUtils(){
        super();
    }

    public static File getLatestFiles(String folderpath){
        File folder = new File(folderpath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            LogsUtil.warn("No files found in directory :" + folderpath);
            return null;
        }
        File latestFile = files[0];
        for (File file : files){
            if (file.lastModified()> latestFile.lastModified()){
                 latestFile = file;
            }
        }
        return latestFile;
    }

    public static void deleteFiles(File dirPath){
        if (dirPath == null || !dirPath.exists()){
            LogsUtil.warn("directory doesn't exist : " + dirPath);
            return;
        }
        File[] filesList = dirPath.listFiles();
        if (filesList == null){
            LogsUtil.warn("failed to list files in : "+ dirPath);
            return;

        }
        for (File file : filesList){
            if (file.isDirectory()){
                deleteFiles(file);
            } else {
                try {
                    Files.delete(file.toPath());

                } catch (IOException e){
                    LogsUtil.error("failed to delete file : " + file);
                }
            }
        }
    }










}
