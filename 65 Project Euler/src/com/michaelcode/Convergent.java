package com.michaelcode;


import java.math.BigInteger;


public class Convergent {

    public Convergent() {

    }

    public void createArray(){

        BigInteger previousN = BigInteger.TWO;

        BigInteger currentN = BigInteger.valueOf(3);

        BigInteger nextN;

        BigInteger multiple = BigInteger.TWO;

        for(int i = 3; i <= 100; i++){

            if(i == 3){

                nextN = currentN.multiply(BigInteger.TWO).add(previousN);

                previousN = currentN;

                currentN = nextN;

            }

            if(i % 3 == 0 && i != 3){

                multiple = multiple.add(BigInteger.TWO);

                nextN = currentN.multiply(multiple).add(previousN);

                previousN = currentN;

                currentN = nextN;

            }

            if(i % 3 != 0){

                nextN = currentN.multiply(BigInteger.ONE).add(previousN);

                previousN = currentN;

                currentN = nextN;

            }

            if(i == 100) addDigits(currentN);
        }
    }

    public void addDigits(BigInteger n){

        String s = String.valueOf(n);

        char[] arr = s.toCharArray();

        int sum = 0;

        for (char c: arr
             ) {

            int x = c - '0';

            sum += x;
        }

        System.out.println(sum);
    }
}
