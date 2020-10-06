package com.michaelcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Main {

    public static void main(String[] args) {

        int smallestD = 0;

        BigInteger largestX = BigInteger.ZERO;

        for(int n = 0; n <= 1000; n++){

            BigInteger sqrt = BigInteger.valueOf((int) Math.sqrt(n));

            if(sqrt.pow(2).compareTo(BigInteger.valueOf(n)) != 0){

                BigInteger m = BigInteger.ZERO;

                BigInteger d = BigInteger.ONE;

                BigInteger a = sqrt;

                BigInteger x = a, x0 = BigInteger.ONE, tempx = x0;

                BigInteger y = BigInteger.ONE, y0 = BigInteger.ZERO, tempy = y0;

                    while(x.pow(2).subtract(y.pow(2).multiply(BigInteger.valueOf(n))).compareTo(BigInteger.ONE) != 0){

                        m = d.multiply(a).subtract(m);

                        d = BigInteger.valueOf(n).subtract(m.pow(2)).divide(d);

                        a = sqrt.add(m).divide(d);

                        tempx = x0;

                        tempy = y0;

                        x0 = x;

                        y0 = y;

                        x = x.multiply(a).add(tempx);

                        y = y.multiply(a).add(tempy);
                    }

                    if(x.compareTo(largestX) > 0){

                        largestX = x;

                        smallestD = n;
                    }
            }
        }
        System.out.println(smallestD);
    }
}
