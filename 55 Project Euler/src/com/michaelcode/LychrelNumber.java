package com.michaelcode;

import java.math.BigInteger;

public class LychrelNumber {

    static int lychrelNumberCount = 0;

    public LychrelNumber(){

    }

    public int getLychrelNumberCount(){
        return lychrelNumberCount;
    }

    public void checksLychrel(BigInteger firstNumber, int index){

        BigInteger secondNumber = reverseNumber(firstNumber);

        BigInteger sum = firstNumber.add(secondNumber);

        boolean isPalindrome = checksPalindrome(sum);

        if(!isPalindrome && index <= 50) {

            checksLychrel(sum, index + 1);
        }

        if(index > 50) lychrelNumberCount++;
    }


    // method takes input big integer and checks if palindrome.
    public boolean checksPalindrome(BigInteger input){

        // changes input big integer into a string.
        String number = input.toString();

        // changes string into char array.
        char[] numberArray = number.toCharArray();

        // array indexes.
        int startIndex = 0;

        int endIndex = numberArray.length - 1;

        // loop that swaps first half indexes with end indexes.
        while(startIndex < endIndex){

            char temp = numberArray[startIndex];

            numberArray[startIndex] = numberArray[endIndex];

            numberArray[endIndex] = temp;

            startIndex += 1;

            endIndex -= 1;
        }

        // changes array back into big integer and returns if palindrome.
        String reversedNumber = String.valueOf(numberArray);

        BigInteger output = new BigInteger(reversedNumber);

        return input.compareTo(output) == 0;

    }

    // method takes in a bigInteger number and outputs the big integer in reverse.
    public BigInteger reverseNumber(BigInteger input){

        // changes input big integer into a string.
        String number = input.toString();

        // changes string into char array.
        char[] numberArray = number.toCharArray();

        // array indexes.
        int startIndex = 0;

        int endIndex = numberArray.length - 1;

        // loop that swaps first half indexes with end indexes.
        while(startIndex < endIndex){

            char temp = numberArray[startIndex];

            numberArray[startIndex] = numberArray[endIndex];

            numberArray[endIndex] = temp;

            startIndex += 1;

            endIndex -= 1;
        }

        // changes array back into big integer and returns reversed value.
        String reversedNumber = String.valueOf(numberArray);

        BigInteger output = new BigInteger(reversedNumber);

        return output;
    }

}
