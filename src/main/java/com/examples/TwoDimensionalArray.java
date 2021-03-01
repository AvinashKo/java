package com.examples;

import org.springframework.util.ObjectUtils;

public class TwoDimensionalArray {
    public int getRows(char[][] inputArray) {
        return ObjectUtils.isEmpty(inputArray) ? 0 : inputArray.length;
    };

    public int getColumns(char[][] inputArray) {
        return ObjectUtils.isEmpty(inputArray) ? 0 :
                inputArray.length > 0 ? inputArray[0].length : 0;
    };
}
