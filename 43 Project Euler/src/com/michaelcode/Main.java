package com.michaelcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    SubStringDivisibility permutationObject = new SubStringDivisibility(); // create object for permutation.

	    String[] array = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; // 9 digit pandigital.

	    permutationObject.heapPermutation(array, array.length, array.length); // create list using heaps algorithm.

	    ArrayList<String> permutationList = permutationObject.getPermutationList(); // sets this list of permutations.

	    Primes primeObject = new Primes(); // creates new prime object.

	    primeObject.sieve(); // creates prime list using sieve method.

	    primeObject.setPrimeList(); // creates a list of back to primes with no composite gaps.

	    ArrayList<Integer> primeList = primeObject.getPrimeList(); // gets list of primes with no composites.

        DivideByPrimes answerObject = new DivideByPrimes(permutationList, primeList);

        answerObject.startingElement();

        System.out.println(answerObject.getAnswerTotal());
    }
}

// class that divides substrings by primes.
class DivideByPrimes {

    ArrayList<String> permutations;
    ArrayList<Integer> primes;
    long answerTotal = 0;

    public DivideByPrimes(ArrayList<String> permutations, ArrayList<Integer> primes) {
        this.permutations = permutations;
        this.primes = primes;
    }

    // getter.
    public long getAnswerTotal(){
        return this.answerTotal;
    }

    // iterate through list of permutations.
    public void startingElement() {

        for (int i = 0; i < permutations.size(); i++) {

            String element = permutations.get(i);

            String[] numberArray = element.split("");

            checkPrime(numberArray);
        }


    }

    // checks if first 3 indexes are divisible by first prime number, if true sends to recursive function to check rest of number.
    public void checkPrime(String[] numberArray){

        String firstNumber = numberArray[1] + numberArray[2] + numberArray[3];

        int dividend1 = Integer.parseInt(firstNumber);



            int primeNumber = primes.get(0);

            if(dividend1 % primeNumber == 0){
                boolean isAnswer = recursivePrimeCheck(numberArray, 0, 1);

                if(isAnswer){

                    sumAnswer(numberArray);
                }
            }

    }

    // checks all the number against primes recursively.
    public boolean recursivePrimeCheck(String[] numberArray, int primeIndex, int charIndex){

        if(charIndex == 8) return true;

        int prime = primes.get(primeIndex);

        String a = numberArray[charIndex] + numberArray[charIndex + 1] + numberArray[charIndex + 2];

        int dividend = Integer.parseInt(a);

        if(dividend % prime == 0){

            return recursivePrimeCheck(numberArray, primeIndex + 1, charIndex + 1);
        }

        return false;


    }

    // sums numbers that are sub string divisible.
    public void sumAnswer(String[] numberArray){

        String s = "";

        for (String i: numberArray
             ) {
            s += i;
        }

        long answer = Long.parseLong(s);

        this.answerTotal += answer;
    }
}

// class creates list of permutation using heaps algorithm.
class SubStringDivisibility{

    ArrayList<String> permutationList = new ArrayList<>();

    public SubStringDivisibility(){

    }

    // getter.
    public ArrayList<String> getPermutationList(){
        return this.permutationList;
    }

    // creates a permutation using heaps algorithm.
    public void heapPermutation(String[] arr, int size, int n){

        // if size becomes 1 then adds permutation to list.
        if(size == 1) addPermutationList(arr, n);

        for(int i = 0; i < size; i++){

            heapPermutation(arr, size - 1, n);

            // if size is odd, swap first and last element.

            if(size % 2 == 1){

                String temp = arr[0];
                arr[0] = arr[size - 1];
                arr[size - 1] = temp;

            }

            // if size is even, swap ith and last element.

            else{

                String temp = arr[i];
                arr[i] = arr[size - 1];
                arr[size - 1] = temp;
            }
        }
    }

    // adds each permutation to array list.
    public void addPermutationList(String[] arr, int n){

        String element  = "";
        for(int i = 0; i < n; i++){

            String index = arr[i];

            element = element + index;


        }

        permutationList.add(element);
    }

}


// class that creates an array and list of prime numbers.
class Primes {

    boolean[] primeArray = new boolean[1000 + 1];

    ArrayList<Integer> primeList = new ArrayList<>();

    public Primes(){

    }

    //getter.
    public ArrayList<Integer> getPrimeList(){
        return this.primeList;
    }

    // sieve array to create prime numbers.
    public void sieve(){

        // set all elements to true.
        for(int i = 2; i < primeArray.length; i++){

            primeArray[i] = true;
        }

        // sieve array.
        for(int p = 2; p < primeArray.length; p++){

            if(primeArray[p]){

                for(int i = p * 2; i < primeArray.length; i += p){

                    primeArray[i] = false;
                }
            }
        }
    }


    // creates a list of back to back primes from boolean array with no false(composite) in between.
    public void setPrimeList(){

        /*for(int i = 0; i < primeArray.length; i++){

            if(primeArray[i]){

                primeList.add(i);
            }
        }*/

        primeList.add(2);
        primeList.add(3);
        primeList.add(5);
        primeList.add(7);
        primeList.add(11);
        primeList.add(13);
        primeList.add(17);
    }

}