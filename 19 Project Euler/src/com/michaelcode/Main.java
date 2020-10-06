package com.michaelcode;

import java.math.BigInteger;

public class Main {
    public static int zeller (long year, int month){
        if(month < 3){
            month += 12;
            year--;
        }
        BigInteger h;
        h = BigInteger.ONE;
        h = h.add(BigInteger.valueOf(13).multiply(BigInteger.valueOf(month + 1)).divide(BigInteger.valueOf(5)));
        h = h.add(BigInteger.valueOf(year));
        h = h.add(BigInteger.valueOf(year).divide(BigInteger.valueOf(4)));
        h = h.subtract(BigInteger.valueOf(year).divide(BigInteger.valueOf(100)));
        h = h.add(BigInteger.valueOf(year).divide(BigInteger.valueOf(400)));
        h = h.mod(BigInteger.valueOf(7));

        int result = h.intValue();

        return result;
    }


    public static void main(String[] args) {
        long year1 = 1901;
        int month1 = 1;
        int day1 = 1;

        long year2 = 2000;
        int month2 = 12;
        int day2 = 31;

        long difference = year2 - year1;

        if(day1 > 1 && month1 != 12){
            month1 += 1;
        }

        if(day1 > 1 && month1 == 12){
            month1 += 1;
            year1 += 1;
        }


        int endMonth = 12;
        int counter = 0;

        for(int i = 0; i <= difference; i++){
            for(int j = month1; j <= endMonth; j++){

                int sunday = zeller(year1, j);

                if(sunday == 1){
                    counter++;
                }

                if(i == difference){
                    endMonth = month2;
                }
            }
            month1 = 1;
            year1++;
        }

        System.out.println(counter);
    }
}
