package com.michaelcode;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class PeriodSquareRoots {

    // static count for number of odd periods.
    static int count = 0;

    // object list for period integers.
    ArrayList<Integer> periodList = new ArrayList<>();

    public PeriodSquareRoots() {
    }

    // get count of odd period lists.
    public static int getCount() {
        return count;
    }

    // increment counter.
    public static void incrementCounter(){
        count++;
    }

    // get period list size.
    public int getPeriodListSize(){
        return periodList.size();
    }

    // recursive continued fraction method.
    public void continuedFraction(BigDecimal inputNumber, int originalInt){

        MathContext mc = new MathContext(300);

        // multiplicative inverse of fractional part of number.
        BigDecimal inverse = BigDecimal.ONE.divide(inputNumber, mc);

        // takes integer value of reciprocal to add to period list.
        int integerValue = inverse.intValue();

        // add integer to period list.
        periodList.add(integerValue);

        // subtract integer value leaving only fractional part.
        BigDecimal fraction = inverse.subtract(BigDecimal.valueOf(integerValue));

        // if not double original number, period has not finished.
        // method called with fractional part as input.
        if(integerValue != originalInt * 2) continuedFraction(fraction, originalInt);
    }
}
