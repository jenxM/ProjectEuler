package com.michaelcode;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        int n = 1000;
        long group3 = (n - 1) / 3;
        long sum1 = ((group3 * (group3 + 1)) / 2) * 3;
        long group5 = (n - 1) / 5;
        long sum2 = ((group5 * (group5 + 1)) / 2) * 5;
        long group15 = (n - 1) / 15;
        long sum3 = ((group15 * (group15 + 1)) / 2) * 15;
        System.out.println((sum1 + sum2) - (sum3));
    }
}
