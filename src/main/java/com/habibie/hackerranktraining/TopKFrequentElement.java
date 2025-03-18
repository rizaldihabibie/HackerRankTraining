/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.hackerranktraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author habibie
 */
public class TopKFrequentElement {
    
    public static void main(String[] args) {
        int[] numbers = {3, 1, 2, 2, 4, 3, 3, 5, 1, 2, 2, 4};
        int k = 3;

        int[] result = find(numbers, k);
        System.out.println(Arrays.toString(result));
    }
    
    public static int[] find(int[] numbers, int k) {
        
        Arrays.sort(numbers);
        
        int[] result = new int[k];
        
        List<int[]> theKey = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            int counter = 0;
            
            while(i+1 < numbers.length && numbers[i+1] == currentNumber) {
                counter++;
                i++;
            }
            
            theKey.add(new int[]{currentNumber, counter});
        }
        
        Collections.sort(theKey, (a,b) -> Integer.compare(a[1], b[1]));
        
        for (int i = 0; i<k; i++) {
            result[i] = theKey.get(i)[0];
        }
        
        return result;
        
    }
    
}
