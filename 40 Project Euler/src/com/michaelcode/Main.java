package com.michaelcode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        double startTime = System.nanoTime();

        ChampernownesConst answer = new ChampernownesConst();

        boolean listSize = true;

        int index = 1;

        // while list size is under 10 ** 6, passes natural numbers for concatenating.
        while(listSize){

            listSize = answer.createList(index);

            index++;
        }

        System.out.println(answer.multiplyDigits());

        double endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) / 1000000000 + " s");
    }
}

class ChampernownesConst{

    ArrayList<Integer> irrationalNumbers = new ArrayList<>();

    public ChampernownesConst(){

    }

    // creates list of concatenating numbers.
    public boolean createList(int n){

        ArrayList<Integer> temp = new ArrayList<>();

        while(n > 0){

            int digit = n % 10;

            temp.add((digit));

            n = n / 10;

        }

        for(int i = temp.size() - 1; i >= 0; i--){
            int digit = temp.get(i);
            irrationalNumbers.add(digit);
        }

        return irrationalNumbers.size() <= 1000000 + 1;

    }

    // finds product of numbers at certain positions.
    public long multiplyDigits(){

        long product = 1;

        for(int i = 1; i <= 1000000; i *= 10){
            product *= irrationalNumbers.get(i - 1);
        }

        return product;
    }

}