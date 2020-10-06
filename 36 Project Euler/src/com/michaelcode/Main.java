package com.michaelcode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    DoubleBasePalindrome answer = new DoubleBasePalindrome();

	    // loop providing integers to answer object.
	    for(int i = 1; i <= 1000000; i++){

	        // creates an array list of integer i digits for decimal.
	        ArrayList<Integer> decimal = answer.createDecimalArr(i);

	        // creates an array list of integer i digits for binary conversion.
	        ArrayList<Integer> binary = answer.digitConverter(i);

	        // nested loop, if decimal list and binary list == true, number added to counter.
	        if(answer.checkPalindrome(decimal)){
	            if(answer.checkPalindrome(binary)){
	                answer.addNumber(i);
                }
            }
        }

	    System.out.println(answer.getSumNumbers());

    }
}

class DoubleBasePalindrome{

    // sum palindrome numbers.
    long sumNumbers = 0;

    public DoubleBasePalindrome(){

    }

    // if number is palindrome add to variable.
    public void addNumber(int n){
        this.sumNumbers += n;
    }

    // getter.
    public long getSumNumbers(){
        return this.sumNumbers;
    }


    // creates a array list of decimal digits.
    public ArrayList<Integer> createDecimalArr(int n){

        ArrayList<Integer> decimal = new ArrayList<>();

        // adds modulo of number n, then divides end digit.
        while(n > 0){
            int digit = n % 10;
            decimal.add(0, digit);
            n = n / 10;
        }

        // returns list.
        return decimal;
    }

    // checks number is palindrome.
    public boolean checkPalindrome(ArrayList<Integer> arr){

        ArrayList<Integer> reversedList = new ArrayList<>();

        // creates a new list of reversed numbers.
        for(int i = arr.size() - 1; i >= 0; i--){
            int digit = arr.get(i);
            reversedList.add(digit);
        }

        boolean isPalindrome = true;

        // compares each element of list, if not equal changes isPalindrome to false.
        for(int i = 0; i < arr.size(); i++){
            int index1 = arr.get(i);
            int index2 = reversedList.get(i);

            if(index1 != index2) isPalindrome = false;
        }

        return isPalindrome;
    }

    // creates binary number as an array list.
    public ArrayList<Integer> digitConverter(int n){

        ArrayList<Integer> binaryDigit = new ArrayList<>();

        // takes the modulo of n, stores in list, then divides by 2.
        while(n > 0){
            int remainder = n % 2;
            binaryDigit.add(0, remainder);
            n = n / 2;
        }

        // returns binary list.
        return binaryDigit;
    }
}

