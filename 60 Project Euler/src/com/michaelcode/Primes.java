package com.michaelcode;

import java.math.BigInteger;

public class Primes {

    public static boolean[] primeArray = new boolean[1000000000];

    public Primes() {
    }

    public boolean[] getPrimeArray() {
        return primeArray;
    }

    public static boolean checkPrime(String n){

        return primeArray[Integer.parseInt(n)];

    }

    public void createArray(){

        for(int i = 2; i < primeArray.length; i++){

            primeArray[i] = true;
        }

        for(int p = 2; p < primeArray.length; p++){

            if(primeArray[p]){

                for(int i = p * 2; i < primeArray.length; i += p){

                    primeArray[i] = false;
                }
            }
        }
    }
}
