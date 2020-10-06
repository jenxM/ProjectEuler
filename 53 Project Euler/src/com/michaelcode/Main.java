package com.michaelcode;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Factorial factObj = new Factorial();

        // creates 2 arrays of factorial numbers.
        factObj.createArray();

        BigInteger[] arrayN = factObj.getArrayN();

        BigInteger[] arrayR = factObj.getArrayR();

        CombinatronicSelection combinatronicObj = new CombinatronicSelection();

        combinatronicObj.setArrayN(arrayN);

        combinatronicObj.setArrayR(arrayR);

        // uses formula to see how many are over a million.
        combinatronicObj.nChooseR();

        System.out.println(combinatronicObj.getCounter());
    }
}

// uses n choose r formula.
class CombinatronicSelection{

    // array of factorials.
    BigInteger[] arrayN;
    BigInteger[] arrayR;

    // value to compare against for answer.
    BigInteger million = BigInteger.valueOf(1000000);

    // count how many are over a million.
    int counter = 0;

    public CombinatronicSelection(){

    }

    public void setArrayN(BigInteger[] arrayN) {
        this.arrayN = arrayN;
    }

    public void setArrayR(BigInteger[] arrayR) {
        this.arrayR = arrayR;
    }

    public int getCounter() {
        return counter;
    }

    // loops through all possible values under million.
    public void nChooseR(){

        for(int i = 0; i < arrayN.length; i++){
            for(int j = 0; j <= i; j++){

                // n and r are factorial numbers.
                BigInteger n = arrayN[i];
                BigInteger r = arrayR[j];

                int formula = i - j;

                // denominator is r! * (i - j)!.
                BigInteger denominator = r.multiply(arrayR[formula]);

                BigInteger answer = n.divide(denominator);

                // increment counter if over million.
                if(answer.compareTo(million) > 0){
                    counter++;
                }
            }
        }
    }
}

// class creates 2 big integer arrays of factorial numbers.
class Factorial{

    BigInteger[] arrayN = new BigInteger[100 + 1];
    BigInteger[] arrayR = new BigInteger[100 + 1];


    public Factorial(){

    }

    public BigInteger[] getArrayN() {
        return arrayN;
    }

    public BigInteger[] getArrayR() {
        return arrayR;
    }

    // method creates 2 big integer arrays using a loop.
    public void createArray(){

        arrayN[0] = BigInteger.ONE;
        arrayR[0] = BigInteger.ONE;

        BigInteger factorial = BigInteger.ONE;


        for (int i = 1; i < arrayN.length; i++){

            factorial = factorial.multiply(BigInteger.valueOf(i));

            arrayN[i] = factorial;

            arrayR[i] = factorial;
        }
    }


}