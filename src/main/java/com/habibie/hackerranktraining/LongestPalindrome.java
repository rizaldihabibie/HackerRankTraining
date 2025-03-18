/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.hackerranktraining;

/**
 *
 * @author habibie
 */
public class LongestPalindrome {
    
    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        System.out.println(longestPalindrome(s));
    }
    
    public static String longestPalindrome(String s) {
        
        int stringLength = s.length();
        
        int startIndex = 0;
        int maxLength = 1;
        
        for(int i=0; i<stringLength; i++) {
            for(int j=0; j<=1; j++) {
                int low = i;
                int high = i+j;
                
                while (low >= 0 && high < stringLength && s.charAt(low) == s.charAt(high)) {
                    int currentLength = high - low + 1;
                    if(currentLength > maxLength) {
                        maxLength = currentLength;
                        startIndex = low;
                    }
                    
                    low--;
                    high++;
                }
            }
        }
        
        return s.substring(startIndex, startIndex+maxLength);
    }
    
}
