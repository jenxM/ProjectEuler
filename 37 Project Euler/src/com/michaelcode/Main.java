package com.michaelcode;

public class Main {

    public static void main(String[] args) {

        TruncatePrimes answer = new TruncatePrimes();

        // object creates a prime array.
        answer.sieve();

        // gets an array of prime numbers to iterate.
        boolean[] primeArr = answer.getList();

        // loops array of primes, nested loop checks left to right and right to left, if true adds prime to sum.
        for(int i = 11; i < primeArr.length; i++){

            if(primeArr[i]){
                if(answer.leftToRight(i)){
                    if(answer.rightToLeft(i)){
                        answer.setSumPrimesPrimes(i);
                    }
                }
            }
        }

        System.out.println(answer.getSumPrimes());

    }
}

class TruncatePrimes {
    // array of primes.
    public boolean[] primes = new boolean[1000000 + 1];

    // variable holding sum of primes.
    long sumPrimes = 0;

    public TruncatePrimes(){

    }

    // getters and setters.
    public boolean[] getList(){
        return this.primes;
    }

    public void setSumPrimesPrimes(int n){
        this.sumPrimes += n;
    }

    public long getSumPrimes(){
        return this.sumPrimes;
    }

    // checks digit left to right using modulo to power of 10.
    public boolean leftToRight(int n){

        boolean isPrime = true;

        int moduloDigit = 10;

        int digit;

        while(isPrime && moduloDigit < n){

            digit = n % moduloDigit;

            isPrime = checkNumber(digit);

            moduloDigit *= 10;
        }

        return isPrime;
    }

    // checks number right to left by dividing number by 10 after checking modulo 10.
    public boolean rightToLeft(int n){

        boolean isPrime = true;

        while(n > 0 && isPrime){

            isPrime = checkNumber(n);

            n = n / 10;
        }

        return isPrime;
    }

    // checks number is prime.
    public boolean checkNumber(int n){
        boolean isPrime = false;

        if(primes[n]) isPrime = true;

        return isPrime;
    }

    // creates an array of primes using sieve.
    public void sieve(){
        for(int i = 2; i < primes.length; i++){
            this.primes[i] = true;
        }

        for(int p = 2; p < primes.length; p++){
            if(primes[p]){
                for(int i = p * 2; i < primes.length; i += p){
                    primes[i] = false;
                }
            }
        }
    }


}
