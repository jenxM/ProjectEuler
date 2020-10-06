package com.michaelcode;

import java.util.ArrayList;

class Main{

    public static void main(String[] args){

        Prime primeObj = new Prime();

        primeObj.createArray();

        boolean[] primeArray = primeObj.getPrimeArray();

        DigitReplacement answerObj = new DigitReplacement(primeArray);

        answerObj.primeStartingPoint();
    }
}

class DigitReplacement{

    boolean[] primeArray;

    public DigitReplacement(boolean[] arr){
        this.primeArray = arr;
    }

    // gets a prime number as a starting point.
    public void primeStartingPoint(){

        for(int i = 1000; i < 200000; i++){

            if(primeArray[i]){

                ArrayList<Integer> primeList = createList(i);

                increment(primeList);
            }
        }
    }

    // finds prime with 3 '1' digits, then increments and checks if prime, if 7 primes including original,
    // then family of 8 == true.
    public void increment(ArrayList<Integer> number){

        // original number(answer).
        ArrayList<Integer> original = new ArrayList<>(number);

        // array to hold indexes of digits that are 1.
        int[] numberOcc = new int[3];

        int index = 0;

        int count = 0;

        for(int i = 0; i < number.size(); i++){

            int indexI = number.get(i);

            // if digit is 1, saves index to array.
            if(indexI == 1 && index < numberOcc.length){
                numberOcc[index] = i;
                index++;
                count++;
            }
        }

        if(count != 3) return;

        int k = 0;

        int primeCount = 0;

        // loops 9 for 9 possible digits, increments each digit by 1 and checks if prime.
        while(k < 9) {
            for (int i = 0; i < number.size(); i++) {
                for (int j = 0; j < numberOcc.length; j++) {

                    if (i == numberOcc[j]) {
                        int element = number.get(i);

                        number.set(i, element + 1);
                    }
                }

            }

            // if prime increments prime count by 1.
            boolean primeNumber = isPrime(number);
            if(primeNumber){
                primeCount++;
            }
            k++;
        }

        // if 7 and original == family of 8, print answer.
        if(primeCount == 7){
            System.out.println(original);
        }
    }


    // puts list back into a number and checks if prime.
    public boolean isPrime(ArrayList<Integer> primeNumberList){

        StringBuilder temp = new StringBuilder();

        for(int i = 0; i < primeNumberList.size(); i++){

            int digit = primeNumberList.get(i);

            temp.append(digit);
        }

        String number = temp.toString();

        int prime = Integer.parseInt(number);

        if(prime < primeArray.length) return primeArray[prime];

        return false;
    }

    // takes in an integer and creates a list of digits.
    public ArrayList<Integer> createList(int prime){

        ArrayList<Integer> primeNumberList = new ArrayList<>();

        while(prime > 0){

            int digit = prime % 10;

            primeNumberList.add(0, digit);

            prime = prime / 10;
        }

        return primeNumberList;
    }
}

// creates a boolean array of primes using sieve method.
class Prime{

    boolean[] primeArray = new boolean[1000000 + 1];

    public boolean[] getPrimeArray(){
        return this.primeArray;
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