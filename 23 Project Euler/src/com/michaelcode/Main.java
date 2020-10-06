package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static ArrayList<Integer> numList = new ArrayList<Integer>();
    static ArrayList<Integer> sumList = new ArrayList<Integer>();
    static long sumTotal = 0;
    public static void main(String[] args) {
        createList();
        createSumList();
        nonAbNum();
        System.out.print(sumTotal);
    }
    public static void nonAbNum(){
        boolean x;
        for(int i = 1; i < 22000; i++){
            x = false;
            for(int j = 0; j < sumList.size(); j++){
                int indexJ = sumList.get(j);
                if(indexJ == i){
                    x = true;
                    break;
                }
            }
            if(x == false){
                sumTotal += i;
                //System.out.println(i + " " + sumTotal);
            }
        }

    }


    public static void createSumList(){
        for(int i = 0; i < numList.size(); i++){
            for(int j = i; j < numList.size(); j++) {
                int num = numList.get(i) + numList.get(j);
                if (num < 28123) {
                    sumList.add(num);
                }
            }
        }
    }


    public static void createList(){
        for(int i = 1; i <= 28123; i++){
            int query = abNum(i);
            if(query > 0){
                numList.add(i);
            }
        }
    }
    public static int abNum(int n){
        int sum = 0;
        for(int i = (n-1); i > 0; i--){
            if(n % i == 0){
                sum += i;
            }
            if(sum > n){
                return n;
            }
        }
        return 0;
    }
}
