package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        long n = 600851475143L;
        long factor = 2;
        long result = 0;
        while (Math.sqrt(n) >= factor) {

            if (n % factor == 0) {
                result = n / factor;
                n = result;
            } else {

                factor++;
            }
            System.out.println(n);

        }
    }
}