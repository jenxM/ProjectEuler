package com.michaelcode;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

            int n = 20;
            int m = 20;

            BigInteger x = factorial(n + m);
            BigInteger y = factorial((n + m) - m).multiply(factorial(m));
            BigInteger z = x.divide(y);


            System.out.println(z);
    }

    public static BigInteger factorial(int N){

        BigInteger f = new BigInteger("1");

        for(int i = 2; i <= N; i++){
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

}
