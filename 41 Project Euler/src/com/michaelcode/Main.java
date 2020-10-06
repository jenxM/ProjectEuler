package com.michaelcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        PandigitalPrime answer = new PandigitalPrime();

        // create array of primes.
        answer.sieve();

        // get array of primes.
        boolean[] array = answer.getPrimes();

        // variable for max pandigital prime.
        int maxPrime = 0;

        // loop through prime numbers, pass them to method to check if pandigital and if larger than previous.
        for(int i = 0; i < array.length; i++){

            if(array[i]){

                if(i >= 1000 && i < 10000){
                    boolean isPandigital = answer.checkPandigital(i, 4);
                    if(isPandigital && i > maxPrime) maxPrime = i;
                }

                if(i >= 10000 && i < 100000){
                    boolean isPandigital = answer.checkPandigital(i, 5);
                    if(isPandigital && i > maxPrime) maxPrime = i;
                }

                if(i >= 100000 && i < 1000000){
                    boolean isPandigital = answer.checkPandigital(i, 6);
                    if(isPandigital && i > maxPrime) maxPrime = i;
                }

                if(i >= 1000000 && i < 10000000){
                    boolean isPandigital = answer.checkPandigital(i, 7);
                    if(isPandigital && i > maxPrime) maxPrime = i;
                }
            }
        }

        System.out.println(maxPrime);
    }
}

class PandigitalPrime{

    // array of prime.
    boolean[] primes = new boolean[10000000 + 1];

    public PandigitalPrime(){

    }

    // getter.
    public boolean[] getPrimes(){
        return this.primes;
    }

    // puts separate digits into list, removes 1 to n once, if list is empty number is pandigital.
    public boolean checkPandigital(int prime, int numDigits){

        ArrayList<Integer> primeNum = new ArrayList<>();

        // creates list using digits from prime.
        while(prime > 0){

            int temp = prime % 10;

            primeNum.add(temp);

            prime = prime / 10;
        }

        if(primeNum.size() != numDigits) return false;

        // removes digits once.
        for(int i = 1; i <= numDigits; i++){
            for(int j = 0; j < primeNum.size(); j++){

                int digit = primeNum.get(j);

                if(i == digit){
                    primeNum.remove(j);
                    break;
                }
            }
        }

        // if list empty number is pandigital.
        return primeNum.isEmpty();
    }

    // standard prime sieve method array.
    public void sieve(){

        Arrays.fill(primes, true);

        for(int p = 2; p < primes.length; p++){

            if(primes[p]){

                for(int i = p * 2; i < primes.length; i += p){
                    primes[i] = false;
                }
            }
        }
    }
}