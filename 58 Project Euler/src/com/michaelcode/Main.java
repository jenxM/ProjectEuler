package com.michaelcode;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Spiral answerObj = new Spiral();

        for(int i = 3; i < 1000000000; i += 2){

            BigInteger n = BigInteger.valueOf(i);

            boolean ans = answerObj.loopSpiral(n);

            if(ans) break;
        }
    }
}
