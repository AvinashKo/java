package com.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoDimensionalArrayTest {

    @Test
    @DisplayName("check rows and columns, general use-case")
    public void findRowsAndColumns() {
        char[][] matrix = {
                {'0', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1'}
        };
        TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray();
        assertEquals(5, twoDimensionalArray.getRows(matrix));
        assertEquals(5, twoDimensionalArray.getColumns(matrix));
    }

    @Test
    @DisplayName("check rows and columns, when rows and columns are different")
    public void findDifferentRowsAndColumns() {
        char[][] matrix = {
                {'0', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1'}
        };
        TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray();
        assertEquals(6, twoDimensionalArray.getRows(matrix));
        assertEquals(5, twoDimensionalArray.getColumns(matrix));
    }

    @Test
    @DisplayName("should handle invalid input entry")
    public void invalidMatrix(){
      char[][] matrix = null;
      TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray();
      assertEquals(twoDimensionalArray.getRows(matrix), 0);
      assertEquals(twoDimensionalArray.getColumns(matrix), 0);
    }

}
