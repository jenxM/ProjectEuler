package com.michaelcode;

import java.math.BigInteger;

public class FractionArithmatic {

    BigInteger numerator;

    BigInteger denominator;

    public FractionArithmatic(BigInteger numr, BigInteger denom){

        this.numerator = numr;

        this.denominator = denom;
    }

    // getters.
    public BigInteger getNumerator(){
        return this.numerator;
    }

    public BigInteger getDenominator(){
        return this.denominator;
    }


    // adds 2 fractions together.
    public FractionArithmatic add(FractionArithmatic fractionTwo){

        BigInteger numer = numerator.multiply(fractionTwo.getDenominator()).add(fractionTwo.getNumerator().multiply(denominator));

        BigInteger denome = denominator.multiply(fractionTwo.getDenominator());

        return new FractionArithmatic(numer, denome);
    }

    // returns reciprocal of a fraction.
    public FractionArithmatic reciprocal(FractionArithmatic fractionOne){

        BigInteger denominator = fractionOne.getNumerator();

        BigInteger numerator = fractionOne.getDenominator();

        return new FractionArithmatic(numerator, denominator);
    }

    public void printFraction(){

        System.out.println(this.numerator + " / " + this.denominator);
    }

    // recursive function square root of 2.
    public FractionArithmatic recursion(int iStart,int iEnd, FractionArithmatic f1){

        if(iStart == iEnd){
            return f1;
        }
        else{
            return f1.add(f1.reciprocal(recursion(iStart + 1, iEnd, f1)));
        }

    }
}
