package com.michaelcode;

public class Test {

    public Test(){

    }

    public void royalFlushTest(){

        char[] arr = {'A', 'H', 'K', 'H', 'J', 'H', 'Q', 'H', 'T', 'H'};

        char[] arr2 = {'T', 'S', 'A', 'S', 'J', 'S', '2', 'S', '5', 'S'};

        PokerHands obj = new PokerHands(arr, arr2);

        obj.royalFlush();

        int counter = obj.getCount();

        System.out.println(counter);

    }
}
