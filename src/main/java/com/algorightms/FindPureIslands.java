package com.algorightms;

public class FindPureIslands {
    public int findNumberOfIslands(char[][] inputArr) {
        if (inputArr == null) return 0;

        int numOfRows = inputArr.length;
        int numOfCols = inputArr.length > 0 ? inputArr[0].length : 0;

        int totalIslands = 0;

        for(int i = 0; i < numOfRows; i++) {
          for(int j = 0; j < numOfCols; j++) {

              if (inputArr[i][j] != '1') continue;
              if (i != 0 && inputArr[i-1][j] == '1') continue;
              if (i != numOfRows-1 && inputArr[i+1][j] == '1') continue;

              if (j != 0) {
                  if (inputArr[i][j-1] == '1') continue;
                  if (i != 0 && inputArr[i-1][j-1] == '1') continue;
                  if (i != numOfRows-1 && inputArr[i+1][j-1] == '1') continue;
              }

              if (j != numOfCols - 1) {
                  if (inputArr[i][j+1] == '1') continue;
                  if (i != 0 && inputArr[i-1][j+1] == '1') continue;
                  if (i != numOfRows-1 && inputArr[i+1][j+1] == '1') continue;
              }

              totalIslands++;
          }
        }

        return totalIslands;
    }
}
