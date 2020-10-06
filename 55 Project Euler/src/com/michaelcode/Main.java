package com.michaelcode;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        LychrelNumber answerObj = new LychrelNumber();

        for(int i = 10; i < 10000; i++){

            BigInteger number = BigInteger.valueOf(i);

            answerObj.checksLychrel(number, 0);
        }

        System.out.println(answerObj.getLychrelNumberCount());
    }
}
