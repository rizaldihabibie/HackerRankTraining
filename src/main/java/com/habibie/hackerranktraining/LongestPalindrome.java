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
        if (stringLength == 0) return "";
        
        int start = 0, maxLength = 1;
        
        for (int i=0; i < stringLength; i++) {
            
            for (int j=0; j <= 1; j++) {
                // why 1 ? to check the middle of the palindrome string
                int low = i;
                int high = i + j;
                
                while (low >= 0 && high < stringLength && s.charAt(low) == s.charAt(high)) {
                    int currentPalindromeLength = high - low +1;
                    if (currentPalindromeLength > maxLength) {
                        start = low;
                        maxLength = currentPalindromeLength;
                    }
                    
                    low--;
                    high++;
                }                
            }
        }
        
        return s.substring(start, start + maxLength);

    }
    
}
