package com.michaelcode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        LetterCount answerObj = new LetterCount();

        answerObj.loopNumbers();

    }
}

class LetterCount{

    String[] digit = {"", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
    String[] tens = {"", "", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};
    String[] power = {"HUNDRED", "THOUSAND"};

    String finalString = "";

    public LetterCount(){

    }

    public void loopNumbers(){

        for(int i = 1; i <= 1000; i++){

            String temp = printNumberString(i);

            finalString = finalString + temp;
        }
        System.out.println(finalString.length());
    }

    public String printNumberString(int n) {

        if(n < 20){
            return digit[n];
        }

        if(n < 100 && n > 19){

            int firstDigit = n % 10;
            int secondDigit = n / 10;

            return tens[secondDigit] + digit[firstDigit];
        }

        if(n < 1000 && n > 99){

            int unit = n % 10;
            int ten = (n / 10) % 10;
            int hundreds = n / 100;

            if(ten == 1){

                return digit[hundreds] + power[0] + "AND" + digit[n % 100];
            }

            if(ten != 0 || unit != 0) {
                return digit[hundreds] + power[0] + "AND" + tens[ten] + digit[unit];
            }

            return digit[hundreds] + power[0]  + tens[ten] + digit[unit];
        }

        if(n > 999){

            return "ONETHOUSAND";
        }

        return "";
    }
}