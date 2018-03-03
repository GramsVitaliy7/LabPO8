/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labpo8;

import java.util.Arrays;

/**
 *
 * @author VITGR
 */
public class Array {

    private int[][] value;
    private int newHeight;

    Array(int[][] value) {
        this.value = value;
    }

    public int[][] addStringsWithSum() {
        int height = value.length;
        int width = value[0].length;
        int sum = 0;
        int counter = 0;
        boolean negativeExist = false;
        int[][] transformedArray = new int [height*2][width];
            
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (value[i][j] > 0) {
                    sum += value[i][j];
                }
                if (value[i][j] < 0 && !(negativeExist)) {
                    negativeExist = true;
                    counter++;
                }
            }
            for (int k = 0; k < width; k++) {
                 transformedArray[i + counter][k] = value[i][k];
                if (negativeExist) {
                    transformedArray[i + counter - 1][k] = value[i][k];
                    transformedArray[i + counter][k] = sum;
                }
            }
            negativeExist = false;
            sum = 0;
        }
        newHeight = height + counter;
        return transformedArray;
    }
    
    public int getNewHeight() {
        return newHeight;
    }
}
