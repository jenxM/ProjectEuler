package com.michaelcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        CircularPrime solution = new CircularPrime();

        // creates a boolean array of sieved prime numbers up to 1 * 10^^6;
        solution.sieveArray();

        // gets sieved array from CircularPrime class to use in for loop.
        boolean[] arr = solution.getSieve();

        // uses array of primes to test with rotation.
        for(int i = 2; i < arr.length; i++){

            if(arr[i]) solution.rotateNumber(i);
        }

        // gets answer from CircularPrimes.
        int answer = solution.getCounter();

        System.out.println(answer);
    }
}

class CircularPrime{
    // array of sieved primes.
    boolean[] sieve = new boolean[1000000 + 1];

    // incremental counter to sum how many primes under a million.
    int counter = 0;

    public CircularPrime(){

    }

    // getters.
    public boolean[] getSieve(){
        return this.sieve;
    }

    public int getCounter(){
        return counter;
    }

    // takes prime number and rotates it a digit at a time, if true at all rotations counter gets incremented.
    public boolean rotateNumber(int n){
        // finds how many rotations are needed depending on the number size.
        int maxIndex = findRotation(n);

        // number that separated digit needs to be raised too.
        int power = maxIndex - 1;


        boolean isPrime = true;

        while(maxIndex > 0 && isPrime){

            // checks the prime number is in the sieved array.
            isPrime = checkArray(n);

            // value of last digit.
            int digit = n % 10;

            // separates last digit.
            n = n / 10;

            // takes last digit and raises to power to be put into the front.
            digit = digit *  (int) Math.pow(10, power);

            // adds number to front.
            n += digit;


            maxIndex--;
        }

        // increments counter for end answer.
        if(isPrime) this.counter++;

        return isPrime;

    }

    // finds how many rotations are needed.
    public int findRotation(int n){
        int rotateIndex = 0;

        if(n > 0 && n < 10){
            rotateIndex = 1;
            return rotateIndex;
        }
        else if(n >= 10 && n < 100){
            rotateIndex = 2;
            return  rotateIndex;
        }
        else if(n >= 100 && n < 1000){
            rotateIndex = 3;
            return rotateIndex;
        }
        else if(n >= 1000 && n < 10000){
            rotateIndex = 4;
            return rotateIndex;
        }
        else if(n >= 10000 && n < 100000){
            rotateIndex = 5;
            return rotateIndex;
        }
        else if(n >= 100000 && n < 1000000){
            rotateIndex = 6;
            return rotateIndex;
        }

        return rotateIndex;
    }

    // checks if number is prime.
    public boolean checkArray(int n){
        return sieve[n];
    }

    // creates array of prime numbers.
    public void sieveArray(){

        Arrays.fill(sieve, true);

        for(int p = 2; p < sieve.length; p++){
            if(sieve[p]){
                for(int i = p * 2; i < sieve.length; i += p){
                    sieve[i] = false;
                }
            }
        }
    }

}