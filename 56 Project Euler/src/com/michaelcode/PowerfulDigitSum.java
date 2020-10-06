package com.michaelcode;

import java.math.BigInteger;
import java.util.ArrayList;

public class PowerfulDigitSum {

    static BigInteger maxSum = new BigInteger("0");

    public PowerfulDigitSum(){

    }

    public BigInteger getMaxSum(){
        return maxSum;
    }

    // goes through all possible digits and exponents.
    public void driverLoop(){

        for(int i = 1; i < 100; i++){
            for(int j = 1; j < 100; j++){

                BigInteger digit = BigInteger.valueOf(i);

                BigInteger number = digit.pow(j);

                createList(number);
            }
        }
    }

    // takes last digit and adds to a temp sum, if bigger than max sum, temp sum becomes max sum.
    public void createList(BigInteger n){

        BigInteger sum = new BigInteger("0");

        while(n.compareTo(BigInteger.ZERO) != 0){

            BigInteger temp = n.mod(BigInteger.TEN);

            sum = sum.add(temp);

            n = n.divide(BigInteger.TEN);
        }

        if(sum.compareTo(maxSum) > 0) maxSum = sum;
    }

}
