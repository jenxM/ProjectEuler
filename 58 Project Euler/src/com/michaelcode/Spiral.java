package com.michaelcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Spiral {

    BigDecimal numerator = new BigDecimal("0.0");

    BigDecimal denominator = new BigDecimal("1.0");

    Prime objPrime = new Prime();

    public Spiral(){

    }

    public boolean loopSpiral(BigInteger oddN){

        BigInteger square = oddN.multiply(oddN);

        BigInteger diagonal = oddN.subtract(BigInteger.ONE);

        for(int i = 0; i < 3; i++){

            square = square.subtract(diagonal);

            boolean isPrimeNumber = objPrime.checkPrimeNumber(square);

            if(isPrimeNumber) numerator = numerator.add(BigDecimal.ONE);
        }

        denominator = denominator.add(BigDecimal.valueOf(4));

        MathContext m = new MathContext(4);

        BigDecimal percentage = numerator.divide(denominator, m).multiply(BigDecimal.valueOf(100));

        percentage = percentage.round(m);

        if(percentage.compareTo(BigDecimal.TEN) < 0){
            System.out.println(oddN);
            return true;
        }
        else{
            return false;
        }

    }
}
