package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static ArrayList<BigInteger> remainders = new ArrayList<BigInteger>();
    static int[] arr = new int[10000];

    public static void main(String[] args) {
        periodArray();
        int biggest = 0;
        int index = 0;
        for(int i = 0; i < 1000; i++){
            int temp = arr[i];
            if(temp > biggest){
                biggest = temp;
                index = i;
            }
        }
        System.out.print(index);
    }
    public static void periodArray(){
        for(int i = 0; i < arr.length; i++){
            if(i < 4){
                arr[i] = 0;
            }
            else if(i % 2 == 0 || i % 5 == 0){
                arr[i] = 0;
            }
            else{
                modArith(i);
                int periodLength = iterateArray();
                arr[i] = periodLength;
                remainders.removeAll(remainders);
            }
        }
    }
    public static int iterateArray(){
        int answer = 0;

        A:  for(int i = 0; i < remainders.size(); i++){
            for(int j = i + 1; j < remainders.size(); j++){
                BigInteger indexI = remainders.get(i);
                BigInteger indexJ = remainders.get(j);
                if(indexI.compareTo(indexJ) == 0){
                    answer = j;
                    break A;
                }
            }
        }
        return answer;
    }
    public static void modArith(int n){
        int factor = n;
        BigInteger numerator = BigInteger.TEN;
        for(int i = 0; i < factor; i++){
            BigInteger remainderAns = numerator.mod(BigInteger.valueOf(n));
            remainders.add(remainderAns);
            numerator = numerator.multiply(BigInteger.TEN);
        }
    }
}
