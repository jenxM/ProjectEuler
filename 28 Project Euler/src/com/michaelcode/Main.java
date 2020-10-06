package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static HashMap<Long, BigInteger> sumOfSquares = new HashMap<>();
    static double biggestSquare = 1001;

    static BigInteger total = BigInteger.ONE;

    public static void main(String[] args) {
        createHash();
        long n = 1001;
        System.out.println(sumOfSquares.get(n));
    }

    public static void createHash(){
        for(long i = 3; i <= (long)biggestSquare; i += 2){

            BigInteger element = findSquareValue(i);

            sumOfSquares.put(i, element);

        }
    }

    public static BigInteger findSquareValue(long input){
        BigInteger squaredStart = BigInteger.valueOf(input);

        squaredStart = squaredStart.multiply(squaredStart);

        BigInteger difference = BigInteger.valueOf(input - 1);

        for(int i = 0; i <= 3; i++){
            total = total.add(squaredStart);

            squaredStart = squaredStart.subtract(difference);

        }

        return total;
    }
}
