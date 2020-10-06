package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        int n = 100;

        long squareAdd = 0;
        long addSquare = (n * (n + 1)) / 2;

        for(int i = 1; i <= n; i++){
            squareAdd += i * i;
        }

        System.out.println(Math.abs((addSquare * addSquare) - squareAdd));
    }
}
