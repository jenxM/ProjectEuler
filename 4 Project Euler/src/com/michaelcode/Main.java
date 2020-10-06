package com.michaelcode;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        int prod = 0, a = 0;
        int n = 10000000;
        for(int i = 100; i <= 999; i++){
            for(int j = 100; j <= 999; j++){
                prod = i * j;
                int num = prod;
                int reverseNum = 0;

                while(num != 0){
                    reverseNum = reverseNum * 10;
                    reverseNum = reverseNum + num % 10;
                    num = num / 10;
                }
                if(prod == reverseNum && prod < n){
                    if(prod > a){
                        a = prod;
                    }
                }
            }
        }
        System.out.println(a);
    }
}
