package com.michaelcode;

import java.math.BigInteger;

public class Solution {

    int count = 1;

    public Solution(){

    }

    // loop to get base number and exponent.
    public void driverLoop(){

        for(int baseNumber = 2; baseNumber < 100; baseNumber++){
            for(int exponent = 1; exponent < 100; exponent++){

                findPower(baseNumber, exponent);
            }
        }

        System.out.println(count);
    }

    // find power digit, convert to string, compare string length with exp.
    public void findPower(int base, int exp){

        BigInteger number = BigInteger.valueOf(base).pow(exp);

        String s = String.valueOf(number);

        if(s.length() == exp) count++;
    }
}
