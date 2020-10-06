package com.michaelcode;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Series answerObj = new Series();

        answerObj.seriesLoop();

        System.out.println(answerObj.getAnswer());
    }
}

class Series{

    BigInteger total = BigInteger.ZERO;

    public Series(){

    }

    public BigInteger getAnswer(){

        long modulo = (long) Math.pow(10, 10);

        return total.mod(BigInteger.valueOf(modulo));
    }

    public void seriesLoop(){


        for(int i = 1; i <= 1000; i++){


            BigInteger index = BigInteger.valueOf(i);

            index = index.pow(i);

            total = total.add(index);

        }
    }
}