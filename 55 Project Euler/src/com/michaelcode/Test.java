package com.michaelcode;

import java.math.BigInteger;

public class Test {

    public Test(){


    }

    public void testProject(){

        testReverseNumber();

        testIsPalindrome();
    }

    public void testIsPalindrome(){

        BigInteger one = BigInteger.valueOf(7337);

        BigInteger two = BigInteger.valueOf(1482841);

        LychrelNumber testObj = new LychrelNumber();

        boolean onePalindrome = testObj.checksPalindrome(one);

        if(onePalindrome){
            System.out.println("test one checksPalindrome PASSED");
        }
        else{
            System.out.println("test two checksPalindrome FAILED");
        }

        boolean twoPalindrome = testObj.checksPalindrome(two);

        if(twoPalindrome){
            System.out.println("test two checksPalindrome PASSED");
        }
        else{
            System.out.println("test two checksPalindrome FAILED");
        }
    }


    public void testReverseNumber(){

        BigInteger one = BigInteger.valueOf(12345);

        BigInteger oneReversed = BigInteger.valueOf(54321);

        BigInteger two = BigInteger.valueOf(123456);

        BigInteger twoReversed = BigInteger.valueOf(654321);

        LychrelNumber testObj = new LychrelNumber();

        BigInteger testOne = testObj.reverseNumber(one);

        if(testOne.compareTo(oneReversed) == 0){

            System.out.println("test one reversedNumber PASSED");
        }

        else{
            System.out.println("test one reversed number FAILED");
        }

        BigInteger testTwo = testObj.reverseNumber(two);

        if(testTwo.compareTo(twoReversed) == 0){

            System.out.println("test two reversedNumber PASSED");
        }
        else{
            System.out.println("test two reversedNumber FAILED");
        }
    }
}
