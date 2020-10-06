package com.michaelcode;

public class NonSquareNumbers {

    boolean[] nonSquareArr = new boolean[10000];

    public NonSquareNumbers() {
        createArr();
    }

    public boolean[] getNonSquareArr() {
        return nonSquareArr;
    }

    // creates a array of non perfect square numbers.
    public void createArr(){

        for(int i = 2; i < nonSquareArr.length; i++){

            nonSquareArr[i] = true;
        }

        for(int i = 2; i < Math.sqrt(nonSquareArr.length); i++){

            int squareNumber = i * i;

            if(squareNumber <= nonSquareArr.length){

                nonSquareArr[squareNumber] = false;
            }
        }
    }
}
