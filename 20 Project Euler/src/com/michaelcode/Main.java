package com.michaelcode;

import java.math.BigInteger;

public class Main {
    public static BigInteger factorial(BigInteger n){
        BigInteger h = n;

        if(h.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }
        else{
            return h.multiply(factorial(h.subtract(BigInteger.ONE)));
        }
    }

    public static BigInteger sum(BigInteger f){
        BigInteger modResult = new BigInteger("0");
        BigInteger total = new BigInteger("0");

        while(f.compareTo(BigInteger.ZERO) > 0){
            modResult = f.mod(BigInteger.TEN);
            total = total.add(modResult);
            f = f.divide(BigInteger.TEN);
        }

        return total;
    }


    public static void main(String[] args) {

        int startingNumber = 100;

        BigInteger fact = factorial(BigInteger.valueOf(startingNumber));

        BigInteger answer = sum(fact);

        System.out.println(answer);
    }
}
