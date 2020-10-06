package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        int n = 20;
        int originalN = n;

        int num = 1;

        while(n >= 1){
            if(num % n == 0){
                n--;
            }else{
                num++;
                n = originalN;
            }
        }
        System.out.println(num);
    }
}
