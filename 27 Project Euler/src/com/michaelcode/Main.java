package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static boolean[] primes = new boolean[10000];
    static int maxCount = 0;
    static int maxIndex = 0;
    static int maxPrime = 0;

    public static void main(String[] args) {
	    setArray();
	    sieveArray();
	    loopArray();
	    //System.out.println(maxIndex * maxPrime);
    }

    public static void loopArray(){
        for(int i = 0; i < primes.length; i++){
            if(primes[i]){
                loopQuadratic(i);
            }

        }
    }

    public static void loopQuadratic(int prime){
        for(int i = -1000; i <= 1000; i++){
            int n = 0;
            boolean isPrime = true;
            while(isPrime) {
                isPrime = quadratic(n, i, prime);
                if (isPrime) {
                    n++;
                }

                if (n > maxCount) {
                    maxCount = n;
                    maxIndex = i;
                    maxPrime = prime;
                    System.out.println(maxCount + " " + maxIndex + " " + maxPrime);
                }
            }
        }
    }

    public static boolean checkAnswer(int answer){
        if(answer <= 1){
            return false;
        }
        if(answer == 2){
            return true;
        }
        for(int i = 2; i < answer; i++){
            if(answer % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean quadratic(int n, int index, int primeNum){
        int equation = n * n + index * n + primeNum;
        boolean answerIsPrime;
        answerIsPrime = checkAnswer(equation);
        return answerIsPrime;
    }
    public static void sieveArray(){
        for(int p = 2; p * p < primes.length; p++){
            if(primes[p] == true){
                for(int i = p * p; i < primes.length; i += p){
                    primes[i] = false;
                }
            }
        }
    }
    public static void setArray(){
        for(int i = 0; i < primes.length; i++){
            primes[i] = true;
        }
    }
}
