package com.michaelcode;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        // loop gets a numerator = j and a denominator = i, creates object from FractionSolution.
        for(int i = 99; i > 1; i--){
            for(int j = i - 1; j > 0; j--){

                FractionSolution fraction = new FractionSolution(j, i);

                fraction.findDivisors();

                ArrayList<Integer> list = fraction.getList();

  // if statement checks the list is not empty eg if no common divisors are there list will be empty.
                if(list.size() > 0){
                    fraction.lowestTerm();


                    int lowestNumerator = fraction.getLowestNumerator();
                    int lowestDenominator = fraction.getLowestDenominator();

   // if statement ensures lowest numerator and lowest denominator is under 10 because only one digit is needed.
                    if(lowestNumerator < 10 && lowestDenominator < 10){
                        fraction.splitDigit();
                    }
                }

            }
        }

    }



}

class FractionSolution {
    int numerator;
    int denominator;

    int lowestNumerator;
    int lowestDenominator;

    ArrayList<Integer> divisorList = new ArrayList<>();

    // constructor creating object with numerator and denominator
    public FractionSolution(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // find common divisors for both numerator and denominator
    public void findDivisors(){
        for(int i = 2; i <= denominator; i++){
            if(numerator % i == 0 && denominator % i == 0){
                divisorList.add(i);
            }
        }
    }

    // gets divisor from list and divides, last in list or biggest number when divided should be smallest term.
    public void lowestTerm(){

        for (int divisor : divisorList) {
            this.lowestNumerator = numerator / divisor;
            this.lowestDenominator = denominator / divisor;
        }

    }

    //getters.
    public int getLowestNumerator(){
        return this.lowestNumerator;
    }

    public int getLowestDenominator(){
        return this.lowestDenominator;
    }

    public ArrayList<Integer> getList(){
        return this.divisorList;
    }

    // splits the fraction into two numerator digits and two denominator digits, then matches it with lowest common term.
    // loop is needed to display lowest term differently eg 1/2 displayed as 2/4, 4/8.
    // nested if statements in loop compare digits and also stop double numerator and denominator e.g 66/88 etc.
    public void splitDigit(){
        int numerator1 = this.numerator % 10;
        int numerator2 = this.numerator / 10;

        int denominator1 = this.denominator % 10;
        int denominator2 = this.denominator / 10;

        for(int i = 1; i < 10; i *= lowestDenominator){
            int tempNumerator = this.lowestNumerator * i;
            int tempDenominator = this.lowestDenominator * i;


            if(numerator1 == tempNumerator && numerator1 != numerator2){
                if(denominator2 == tempDenominator && denominator2 != denominator1){
                    if(numerator2 == denominator1) {
                        System.out.print(this.numerator + " / " + this.denominator);
                    }
                }
            }

            if(numerator2 == tempNumerator && numerator2 != numerator1){
                if(denominator1 == tempDenominator && denominator1 != denominator2){
                    if(numerator1 == denominator2) {
                        System.out.println(this.numerator + " / " + this.denominator);
                    }
                }
            }
        }
    }
}

