package com.michaelcode;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger totalResult = BigInteger.ZERO;

        // creates factorial object and passes i from loop.
        // gets back total factorial and compares to i, if the same summed with totalResult.
        for(long i = 3; i <= 100000; i++){
            Factorial answer = new Factorial();
            answer.findFactorial(i);
            BigInteger result = answer.getTotalFactorial();
            if(result.compareTo(BigInteger.valueOf(i)) == 0){
                totalResult = totalResult.add(BigInteger.valueOf(i));
            }
        }

        System.out.println(totalResult);
    }
}

class Factorial {

    BigInteger totalFactorial;

    public Factorial(){

    }

    // getter.
    public BigInteger getTotalFactorial(){
        return this.totalFactorial;
    }

    // input long from main loop, splits the input into separate digits and finds the factorial of each.
    // updates class instance totalFactorial to pass back with getter.
    public void findFactorial(long digit){

        BigInteger totalDigitFactorial = BigInteger.ZERO;

        while(digit > 0){
            BigInteger digitFactorial = BigInteger.ONE;
            long modDigit = digit % 10;

            for(long i = modDigit; i > 0; i--){
                digitFactorial = digitFactorial.multiply(BigInteger.valueOf(i));
            }
            totalDigitFactorial = digitFactorial.add(totalDigitFactorial);

            digit = digit / 10;
        }
        this.totalFactorial = totalDigitFactorial;
    }
}
