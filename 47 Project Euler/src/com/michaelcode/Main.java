package com.michaelcode;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Sieve primeObject = new Sieve();

        // creates a boolean array of prime numbers.
        primeObject.createPrimeArray();

        // gets a boolean array of prime numbers.
        boolean[] primeArray = primeObject.getPrimeArray();

        PrimeFactors factorObject = new PrimeFactors(primeArray);

        // driver loop of composite numbers.
        factorObject.compositeLoop();
    }
}

// class takes a prime array, uses a composite numbers from array as a driver loop, then iterates through prime numbers.
// adds prime numbers to a hash set, if set size is 4, checks next 3 prime numbers for answer.
class PrimeFactors{

    boolean[] primeArray;

    public PrimeFactors(boolean[] array){
        this.primeArray = array;
    }

    // driver loop using composite numbers.
    public void compositeLoop(){

        for(int i = 2; i < primeArray.length; i++){

            if(!primeArray[i]){

                // checks if i has 4 distinct prime factors.
                boolean firstFourFactor = createPrimeFactors(i);

                // if has 4 primes, checks next 3 consecutive integers.
                if(firstFourFactor){
                    boolean isAnswer = consecutiveIntegers(i);

                    if(isAnswer){
                        System.out.print(i);
                        break;
                    }
                }
            }
        }
    }

    // checks consecutive integers for 4 primes, using nested loop logic.
    public boolean consecutiveIntegers(int i){

        boolean has4PrimeFactors = createPrimeFactors(i);

        if(has4PrimeFactors){
            has4PrimeFactors = createPrimeFactors(i + 1);
            if(has4PrimeFactors){
                has4PrimeFactors = createPrimeFactors(i + 2);
                if(has4PrimeFactors){
                    has4PrimeFactors = createPrimeFactors(i + 3);
                }
            }
        }

        return has4PrimeFactors;
    }

    // creates prime factors and adds them to a hash set.
    public boolean createPrimeFactors(int n){

        HashSet<Integer> factors = new HashSet<>();

        int i = 2;

        while(n != 1){

            // if index not prime, add 1 to index.
            if(!primeArray[i] && i < primeArray.length - 1) i++;

            // if index is prime, checks if prime factor and divides n by prime factor.
            if(primeArray[i]){

                if(n % i == 0){

                    factors.add(i);

                    n = n / i;
                }
            }

            // if index is prime but not a prime factor, index adds 1.
            if(n % i != 0 && i < primeArray.length - 1) i++;

        }

        // returns true if n has 4 distinct primes.
        return factors.size() == 4;
    }
}

// standard sieve method of creating a array of primes and composites.
class Sieve{

    boolean[] primeArray = new boolean[1000000 + 1];

    public Sieve(){

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