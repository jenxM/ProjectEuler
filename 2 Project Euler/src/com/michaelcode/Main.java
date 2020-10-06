package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        long n = 4000000L;
        long ef1 = 0;
        long ef2 = 2;
        long sum = ef1 + ef2;
        while (ef2 <= n){
            long ef3 = (4 * ef2) + ef1;
            if(ef3 > n){ break;}
            ef1 = ef2;
            ef2 = ef3;
            sum += ef2;


        }
        System.out.println(sum);
    }
}
