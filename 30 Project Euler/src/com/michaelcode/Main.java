package com.michaelcode;


import java.math.BigInteger;

public class Main {

    // variable number as a max start position for loopNumber()

    static long maxNumber = 10000000L;
    static BigInteger maxTotal = BigInteger.ZERO;

    public static void main(String[] args) {
        loopNumber();
        System.out.println(maxTotal);
    }

    // takes in every digit 5th power and sums them into a maxTotal

    public static void totalDigitPowers(long total){
        maxTotal = maxTotal.add(BigInteger.valueOf(total));
    }


    // takes in number from loop and splits each digit, raise to 5th power and adds to a total

    public static void splitNumber(long input){
        long n = input;
        long total = 0;
        long digit = 0;
        while(n > 0){
            digit = n % 10;
            digit = (long) Math.pow(digit, 5);
            total += digit;
            n = n / 10;
        }
        if(total == input) totalDigitPowers(total);
    }

    // loops through maxNumber to zero and passes each number to splitNumber

    public static void loopNumber(){
        for(long i = 2; i <= maxNumber; i++){
            splitNumber(i);
        }
    }
}
