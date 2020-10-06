package com.michaelcode;

import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // creates prime array using sieve method.
        Prime primeObj = new Prime();

        primeObj.createPrimeArray();

        boolean[] primeArray = primeObj.getPrimeArray();

        SumPrime sumObj = new SumPrime(primeArray);

        sumObj.startingLoop();

        System.out.println(sumObj.getMaxPrime());
    }
}

class SumPrime{
    // prime array.
    boolean[] primeArray;

    // max terms variable.
    long maxTerms = 0;

    // max prime variable (answer).
    long maxPrime = 2;

    // constructor.
    public SumPrime(boolean[] arr){
        this.primeArray = arr;
    }

    // getter.
    public long getMaxPrime(){
        return this.maxPrime;
    }

    // loop to find starting position.
    public void startingLoop(){

        for(int i = 2; i < primeArray.length; i++){
            if(primeArray[i]){
                sumLoop(i);
            }
        }
    }

    // second loop to sum terms, after each summation counter gets incremented, if answer is prime maxPrime and maxterms gets updated.
    public void sumLoop(int n){

        long tempPrime = 0;
        long tempTerms = 0;

        for(; n < primeArray.length; n++){
            if(primeArray[n]){

                tempPrime += n;
                tempTerms++;

                if(tempPrime < 1000000){

                    if(primeArray[(int)tempPrime]){

                        if(tempTerms > maxTerms){
                            maxTerms = tempTerms;
                            maxPrime = tempPrime;
                        }
                    }
                }
            }
        }
    }

}

// class creates a boolean array of primes using sieve method.
class Prime{

    boolean[] primeArray = new boolean[1000000 + 1];

    public Prime(){

    }

    public boolean[] getPrimeArray(){
        return this.primeArray;
    }

    public void createPrimeArray(){
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