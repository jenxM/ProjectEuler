package com.michaelcode;

public class Main {

    public static void main(String[] args) {

        PentagonNumber pentagonalObj = new PentagonNumber();

        // creates array of pentagon numbers.
        pentagonalObj.createPentagonNumber();

        int[] pentagonArray = pentagonalObj.getPentagonArray();

        SumAndDifferenceNumber obj = new SumAndDifferenceNumber(pentagonArray);

        // initiates driver loop of p numbers.
        obj.driverLoop();

        System.out.println(obj.getSmallestDifference());

    }
}

// sum and find difference pentagon number.
class SumAndDifferenceNumber{

    int[] pentagonalArray;

    int smallestDifference = 100000000;

    // sets array of p numbers.
    public SumAndDifferenceNumber(int[] arr){
        this.pentagonalArray = arr;
    }

    // getter.
    public int getSmallestDifference(){
        return this.smallestDifference;
    }

    // if n is smallest difference sets smallest difference.
    public void isSmallestDifference(int n){

        if(n < this.smallestDifference){
            this.smallestDifference = n;
        }
    }

    // driver loop to get 2 p numbers to sum and find difference.
    public void driverLoop(){

        for(int i = 1; i < pentagonalArray.length - 1; i++){
            for(int j = i + 1; j < pentagonalArray.length; j++){

                int sum = pentagonalArray[i] + pentagonalArray[j];

                boolean isSumPentagonal = isPentagonal(sum);

                if(isSumPentagonal){

                    int difference = pentagonalArray[j] - pentagonalArray[i];

                    boolean isDiffPentagonal = isPentagonal(difference);

                    // if sum and difference a p number, passes to function to check if difference is smallest.
                    if(isDiffPentagonal) isSmallestDifference(difference);
                }

            }
        }
    }

    // checks if digit is a p number using p number array.
    public boolean isPentagonal(int n){
        for (int value : pentagonalArray) {

            if (value == n) return true;
        }

        return false;
    }
}

// class creates pentagon number and stores in an array.
class PentagonNumber{

    private int[] pentagonArray = new int[10000 + 1];

    public PentagonNumber(){

    }

    // getter.
    public int[] getPentagonArray(){

        return this.pentagonArray;
    }

    // pentagon number equation.
    public void createPentagonNumber(){

        for(int i = 0; i < pentagonArray.length; i++){

            double p = (3 * i - 1);

            p = p / 2;

            p = i * p;

            int pentagonal = (int) p;

            pentagonArray[i] = pentagonal;
        }
    }

}