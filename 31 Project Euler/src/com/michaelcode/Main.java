package com.michaelcode;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        coinCombinations();
    }

    public static void coinCombinations(){
        int counter = 0;
        for(int a = 200; a >= 0; a-=200){
            for(int b = a; b >= 0; b-=100){
                for(int c = b; c >= 0; c-=50){
                    for(int d = c; d >= 0; d-=20){
                        for(int e = d; e >= 0; e-=10){
                            for(int f = e; f >= 0; f-=5){
                                for(int g = f; g >= 0; g-=2){
                                        counter++;

                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
