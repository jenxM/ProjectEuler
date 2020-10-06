package com.michaelcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        CodedTriangle answer = new CodedTriangle();

        answer.createNumberArray();

        answer.createStringArray();

        answer.produceCharArray();

        System.out.println(answer.getCounter());
    }
}

class CodedTriangle{

    // array of triangle numbers.
    int[] triArray = new int[10000 + 1];

    // array containing words from txt file.
    String[] wordArray;

    // file object from Project Euler website.
    File words = new File("C:\\Users\\mikej\\Documents\\code\\p042_words.txt");

    // word count.
    int counter = 0;

    public CodedTriangle(){

    }

    public int getCounter(){
        return this.counter;
    }

    // takes word as a char array, puts a numerical value and sums.
    public void charToNumber(char[] letters){

        int total = 0;

        for(int i = 0; i < letters.length; i++){

            int temp = letters[i] - 64;

            total += temp;
        }

        isTriNumber(total);
    }

    public void produceCharArray(){

        // uses word from word array and splits them into a char array.
        for(int i = 0; i < wordArray.length; i++){

            String temp = wordArray[i];

            char[] letters = temp.toCharArray();

            charToNumber(letters);
        }
    }

    // gets value of word and checks against tri numbers, if contains counter++.
    public void isTriNumber(int n){

        for(int i = 0; i < triArray.length; i++){

            int number = triArray[i];

            if(number == n){
                counter++;
                break;
            }
        }
    }

    // creates array from text file, removes all regex.
    public void createStringArray() throws FileNotFoundException {

        Scanner input = new Scanner(words);


        while(input.hasNext()){

            String temp = input.next();

            wordArray = temp.split(",");
        }

        for(int i = 0; i < wordArray.length; i++){
            wordArray[i] = wordArray[i].replaceAll("\"", "");
        }

        input.close();

    }

    // create array of tri numbers.
    public void createNumberArray(){

        for(int i = 0; i < triArray.length; i++){

            triArray[i] = triNumber(i);
        }
    }

    public int triNumber(int n){

        return (int) (n * 0.5 * (n + 1));
    }
}