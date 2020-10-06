package com.michaelcode;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        long counter = 0;

        // loops through each i giving the number of expansions to recursive function.
        // if numerator is larger, increments counter.

        for(int i = 0; i < 999; i++) {
            FractionArithmatic ansObj = new FractionArithmatic(BigInteger.TWO, BigInteger.ONE);

            FractionArithmatic f2 = ansObj.recursion(0, i, ansObj);

            FractionArithmatic f1 = new FractionArithmatic(BigInteger.ONE, BigInteger.ONE);

            f2 = f2.reciprocal(f2);

            f1 = f1.add(f2);

            String numerator = String.valueOf(f1.getNumerator());

            String denominator = String.valueOf(f1.getDenominator());

            if(numerator.length() > denominator.length()) counter++;
        }

        System.out.println(counter);
    }
}
