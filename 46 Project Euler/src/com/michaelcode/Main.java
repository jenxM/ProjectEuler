package com.michaelcode;

public class Main {

    public static void main(String[] args) {

        Sieve primeObj = new Sieve();

        // creates a prime array using sieve method.
        primeObj.createPrimeArray();

        // array of prime numbers.
        boolean[] primeArray = primeObj.getPrimeArray();

        GoldbachConjecture answerObj = new GoldbachConjecture(primeArray);

        // starts loop of composite numbers from prime array, if array[i} = false number is composite.
        answerObj.compositeNumberLoop();

        // gets final answer.
        int finalAnswer = answerObj.getSmallestOddComposite();

        System.out.println(finalAnswer);
    }
}

class GoldbachConjecture{

    // array of primes.
    private boolean[] primeArray;

    // smallest odd composite (answer).
    private int smallestOddComposite;

    public GoldbachConjecture(boolean[] primeArr){
        this.primeArray = primeArr;
    }

    // setter.
    public void setSmallestOddComposite(int n){
        this.smallestOddComposite = n;
    }

    // getter.
    public int getSmallestOddComposite(){
        return this.smallestOddComposite;
    }

    // loops through array for odd composite numbers, passes number to a prime number loop.
    public void compositeNumberLoop(){

        for(int i = 2; i < primeArray.length; i++){

            if(!primeArray[i] && i % 2 == 1){
                boolean smallestComposite = primeLoop(i);

                // if value passed back is false, composite number i must be smallest.
                if(!smallestComposite) {
                    setSmallestOddComposite(i);
                    break;
                }
            }
        }
    }

    // input is a composite number, loops through prime number and passes to square number for final equation.
    public boolean primeLoop(int compositeNumber){

        boolean smallestComposite = false;

        for(int i = 2; i < primeArray.length; i++){

            if(primeArray[i]){
                smallestComposite = squareLoop(compositeNumber, i);
                if(smallestComposite) break;
            }
        }

        // returns boolean if number can be made using conjecture.
        return smallestComposite;
    }

    // input composite and prime, then loops through square numbers for final equation.
    public boolean squareLoop(int compositeNumber, int primeNumber){

        for(int i = 1; i < Math.sqrt(compositeNumber); i++){

            int tempValue = 2 * (i * i);

            tempValue += primeNumber;

            // if composite can be made returns true.
            if(compositeNumber == tempValue) return true;

        }

        // if composite cant be made returns false and answer.
        return false;
    }


}

// class creates a prime array using sieve method.
class Sieve{

    private boolean[] primeArray = new boolean[1000000 + 1];

    public Sieve(){

    }

    // getter.
    public boolean[] getPrimeArray(){
        return  this.primeArray;
    }

    // method to create array.
    public void createPrimeArray(){

        // sets all elements true;
        for(int i = 2; i < primeArray.length; i++){
            primeArray[i] = true;
        }

        // sieve method, all multiples of prime must be composite, true elements must be prime after completion of array.
        for(int p = 2; p < primeArray.length; p++){

            if(primeArray[p]){

                for(int i = p * 2; i < primeArray.length; i += p){

                    primeArray[i] = false;
                }
            }
        }
    }
}