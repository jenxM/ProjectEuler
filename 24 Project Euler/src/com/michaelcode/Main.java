package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static ArrayList<Long> digit = new ArrayList<Long>();
    static ArrayList<Character> queryChar = new ArrayList<Character>();

    public static void main(String[] args) {
        createCharList();
        getFactoradic(999999);
        permutation();
    }
    public static void permutation(){
        for(int i = 0; i < digit.size(); i++){
            long digitResult = digit.get(i);
            int j = (int)digitResult;
            System.out.print(queryChar.get(j));
            queryChar.remove(j);

        }
    }
    public static void createCharList(){
        queryChar.add('0');
        queryChar.add('1');
        queryChar.add('2');
        queryChar.add('3');
        queryChar.add('4');
        queryChar.add('5');
        queryChar.add('6');
        queryChar.add('7');
        queryChar.add('8');
        queryChar.add('9');
    }
    public static void getFactoradic(long n){
        int i = 1;
        while(n != 0){
            long remainder = n % i;
            n = n / i;
            digit.add(0, remainder);
            i++;
        }
    }
}
