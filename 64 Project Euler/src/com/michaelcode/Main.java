package com.michaelcode;

import java.math.BigDecimal;
import java.math.MathContext;

public class Main {

    public static void main(String[] args) {

        NonSquareNumbers sqObj = new NonSquareNumbers();

        boolean[] nonSquareArr = sqObj.getNonSquareArr();

        for(int i = 2; i < nonSquareArr.length; i++){

            if(nonSquareArr[i]){

                PeriodSquareRoots obj = new PeriodSquareRoots();

                MathContext mc = new MathContext(300);

                // square root of non square number.
                BigDecimal sqrRoot = BigDecimal.valueOf(i).sqrt(mc);

                // integer value of square number.
                int integerValue = sqrRoot.intValue();

                // fractional part of square root.
                BigDecimal fractionalPart = sqrRoot.subtract(BigDecimal.valueOf(integerValue));

                // call recursive function.
                obj.continuedFraction(fractionalPart, integerValue);

                // get period size of square root.
                int periodSize = obj.getPeriodListSize();

                // if period length odd, increments counter.
                if(periodSize % 2 == 1) PeriodSquareRoots.incrementCounter();
            }
        }
        System.out.println(PeriodSquareRoots.getCount());
    }
}
