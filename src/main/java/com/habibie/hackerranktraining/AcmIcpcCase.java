/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.hackerranktraining;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author habibie
 */
public class AcmIcpcCase {
    
    /*
    https://www.hackerrank.com/challenges/acm-icpc-team/problem?isFullScreen=true
    There are a number of people who will be attending ACM-ICPC World Finals. 
    Each of them may be well versed in a number of topics. 
    Given a list of topics known by each attendee, presented as binary strings, determine the maximum number of topics a 2-person team can know. 
    Each subject has a column in the binary string, and a '1' means the subject is known while '0' means it is not. 
    Also determine the number of teams that know the maximum number of topics. Return an integer array with two elements. 
    The first is the maximum number of topics known, and the second is the number of teams that know that number of topics.

    Example


    The attendee data is aligned for clarity below:

    10101
    11110
    00010
    
    result : [5,1]

    */
    public static List<Integer> acmTeam(List<String> topic) {
        Integer maxVersedTopics = 0;
        Integer totalTeams = 0;
        for(int i=0; i<topic.size(); i++) {
            for(int j=i+1; j<topic.size(); j++) {
                BigInteger number1 = new BigInteger(topic.get(i), 2);
                BigInteger number2 = new BigInteger(topic.get(j), 2);
                
                BigInteger result = number1.or(number2);
                int countOnes = result.bitCount();
                if(countOnes > maxVersedTopics) {
                    totalTeams = 1;
                    maxVersedTopics = countOnes;
                } else if (maxVersedTopics == countOnes) {
                    totalTeams++;
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(maxVersedTopics);
        result.add(totalTeams);
        return result;

    }
}
