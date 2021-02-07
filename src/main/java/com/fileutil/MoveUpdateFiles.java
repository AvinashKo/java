package com.fileutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class MoveUpdateFiles {
  public static void main(String[] args) throws IOException {

    String WORKING_DIR = "/Users/a0k00hu/Desktop/program/test_env/test_data";
    String TO_COPY_DIR = "/Users/a0k00hu/Desktop/program/test_env/test_data/PERF";
    String FILE_SEPERATOR = "/";

    File file = new File(WORKING_DIR);

    String[] directories =
        file.list(
            (current, name) -> new File(current, name).isDirectory() && name.startsWith("S", 0));

    if (directories != null && directories.length > 0) {
      moveDir(WORKING_DIR, TO_COPY_DIR, directories, FILE_SEPERATOR, 0);
    }
  }

  public static int getRandomNumber(int maxNum) {
    int min = 0;
    int range = maxNum - min + 1;
    return (int) (Math.random() * range) + min;
  }

  public static void moveDir(
      String workingDir, String toCopyDir, String[] dirList, String FILE_SEPERATOR, int iterCount) {

    int MAX_RETRY = 5;

    int randomNum = getRandomNumber(dirList.length - 1);
    String sourceDirName = workingDir + FILE_SEPERATOR + dirList[randomNum];
    String destinationDirName = toCopyDir + FILE_SEPERATOR + dirList[randomNum];
    File srcDir = new File(sourceDirName);

    File destDir = new File(destinationDirName);

    try {
      FileUtils.moveDirectory(srcDir, destDir);
      File destinationDir = new File(destinationDirName);
      String[] filesList =
          destinationDir.list(
              (current, name) -> name.endsWith(".xml"));
      if (filesList != null && filesList.length > 0) {
        updateFileWithTestData(
            destinationDirName + FILE_SEPERATOR + filesList[0],
            destinationDirName + FILE_SEPERATOR + "temp_272457243.xml");
      }
    } catch (Exception e) {
      if (iterCount < MAX_RETRY)
        moveDir(workingDir, toCopyDir, dirList, FILE_SEPERATOR, ++iterCount);
      else e.printStackTrace();
    }
  }

  private static void updateFileWithTestData(String filePath, String tempFile) throws Exception {

    String FILE_SEPERATOR = "/";
    String replaceBatchHeaderValue = "BATCH_HEADER_VALUE";
    String replaceRetentionBinValue = "RETENTION_BIN";
    String replaceUriValue = "URI_NEW_PATH";

    // Open reader and writer
    FileWriter writer = new FileWriter(tempFile);
    FileReader fileReader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    String line = "";
    while ((line = bufferedReader.readLine()) != null) {
      if (line.matches(".*Type=.BatchHeaderID.*") || line.matches(".*Type=.RetentionBin.*")) {
        String[] lineArray = line.split(" ");
        if (lineArray.length > 0) {
          for (int i = 0; i < lineArray.length; i++) {
            if (lineArray[i].startsWith("Value=")) {
              String[] valueArray = lineArray[i].split("\"", -1);
              if (valueArray.length >= 1) {
                if (line.matches(".*Type=.BatchHeaderID.*"))
                  valueArray[1] = replaceBatchHeaderValue;
                else if (line.matches(".*Type=.RetentionBin.*"))
                  valueArray[1] = replaceRetentionBinValue;
              }
              lineArray[i] = String.join("\"", valueArray);
            }
          }
        }
        line = String.join(" ", lineArray);
      } else if (line.matches(".*<File.*URI=.*")) {
        String[] lineArray = line.split(" ");
        if (lineArray.length > 0) {
          for (int i = 0; i < lineArray.length; i++) {
            if (lineArray[i].startsWith("URI=")) {
              String[] valueArray = lineArray[i].split("\"", -1);
              if (valueArray.length >= 1) {
                String oldPath = valueArray[1];
                String[] pathArray = oldPath.split(FILE_SEPERATOR);
                String newPath = "";
                if (pathArray.length >= 2) {
                  newPath =
                      replaceUriValue
                          + FILE_SEPERATOR
                          + pathArray[pathArray.length - 2]
                          + FILE_SEPERATOR
                          + pathArray[pathArray.length - 1];
                }
                valueArray[1] = newPath;
              }
              lineArray[i] = String.join("\"", valueArray);
            }
          }
        }
        line = String.join(" ", lineArray);
      }
      writer.write(line + "\r\n");
    }

    // Close reader and writer
    bufferedReader.close();
    writer.close();

    // Delete old file and rename new file to old
    File oldFile = new File(filePath);
    File newFile = new File(tempFile);

    oldFile.delete();
    newFile.renameTo(oldFile);
  }
}
