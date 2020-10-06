package com.michaelcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Prime {

    public Prime(){

    }

    public boolean checkPrimeNumber(BigInteger number){

        BigInteger divisor = number.sqrt();

        while(number.mod(divisor).compareTo(BigInteger.ZERO) != 0){
            divisor = divisor.subtract(BigInteger.ONE);
        }

        if(divisor.compareTo(BigInteger.ONE) == 0){
            return true;
        }
        else{
            return false;
        }
    }

}
