package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Main {
    static boolean[] primeArray = new boolean[1000000];

    public static void main(String[] args) {
        sieve();
        int counter  = 0;
        for(int i = 2; i < primeArray.length; i++){
            if(primeArray[i] == true){
                counter++;
                if(counter == 10001){
                    System.out.println(i);
                }
            }
        }
    }

    public static void sieve(){
        for(int i = 0; i < primeArray.length; i++){
            primeArray[i] = true;
        }

        for(int p = 2; p * p < primeArray.length; p++){
            if(primeArray[p] == true){
                for(int i = p * 2; i < primeArray.length; i += p){
                    primeArray[i] = false;
                }
            }
        }
    }
}
