package com.michaelcode;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        int n = 1000;

        BigInteger result = Power(n);

        System.out.println(result);

    }

    public static BigInteger Power(int p){

        BigInteger f = new BigInteger("1");

        for(int i = 1; i <= p; i++){

            f = f.multiply(BigInteger.valueOf(2));
        }

        BigInteger g = new BigInteger("0");
        BigInteger k = new BigInteger("0");

        while(f != BigInteger.ZERO){

            g = f.mod(BigInteger.TEN);
            k = k.add(g);
            f = f.divide(BigInteger.TEN);

        }

        return k;
    }
}
