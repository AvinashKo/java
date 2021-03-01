package com.algorightms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindPureIslandsTest {
    
    @Test
    @DisplayName("should have zero islands")
    public void zeroIslands(){
        char[][] matrix = {
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        FindPureIslands findIslands = new FindPureIslands();
        assertEquals(0, findIslands.findNumberOfIslands(matrix));
    }

    @Test
    @DisplayName("should have one island")
    public void oneIslands(){
        char[][] matrix = {
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        FindPureIslands findIslands = new FindPureIslands();
        assertEquals(1, findIslands.findNumberOfIslands(matrix));
    }

    @Test
    @DisplayName("should have two islands")
    public void twoIslands(){
        char[][] matrix = {
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        FindPureIslands findIslands = new FindPureIslands();
        assertEquals(2, findIslands.findNumberOfIslands(matrix));
    }

    @Test
    @DisplayName("should have lands but no islands")
    public void noIslands(){
        char[][] matrix = {
                {'1', '0', '1', '0', '1'},
                {'0', '1', '0', '1', '0'},
                {'0', '0', '1', '0', '0'},
                {'1', '0', '0', '1', '0'},
                {'0', '1', '0', '0', '1'},
                {'1', '0', '1', '0', '0'}
        };

        FindPureIslands findIslands = new FindPureIslands();
        assertEquals(0, findIslands.findNumberOfIslands(matrix));
    }

    @Test
    @DisplayName("should have lands and one islands")
    public void moreLandsOneIsland(){
        char[][] matrix = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };

        FindPureIslands findIslands = new FindPureIslands();
        assertEquals(0, findIslands.findNumberOfIslands(matrix));
    }
}
