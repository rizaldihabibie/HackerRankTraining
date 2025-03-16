/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.hackerranktraining;

import java.util.Arrays;

/**
 *
 * @author habibie
 */
public class IsAnagram {
    
    public static void main(String[] args) {
        
    }
    
    public static boolean isAnagram(String a, String b) {
        char[] charArrayA = a.toCharArray();
        char[] charArrayB = b.toCharArray();
        
        Arrays.sort(charArrayA);
        Arrays.sort(charArrayB);
        
        return charArrayA.equals(charArrayB);
        
    }
}
