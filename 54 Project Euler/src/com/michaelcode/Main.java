package com.michaelcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("C:\\Users\\mikej\\Documents\\code\\p054_poker.txt");

        Scanner input = new Scanner(inputFile);

        int answer = 0;

        while(input.hasNextLine()){

            String s = input.nextLine();

            ArrayBuild obj = new ArrayBuild();

            obj.createArray(s);

            char[] playerOneArray = obj.getPlayerOneArray();

            char[] playerTwoArray = obj.getPlayerTwoArray();

            PokerHands answerObj = new PokerHands(playerOneArray, playerTwoArray);

            answerObj.royalFlush();

            answer = answerObj.getCount();

        }

        System.out.println(answer);

    }
}


class PokerHands{

    char[] playerOneArray;

    char[] playerTwoArray;

    int[] playerOneInteger = new int[5];

    int[] playerTwoInteger = new int[5];

    static int playerOneCount;

    public PokerHands(char[] playerOne, char[] playerTwo){

        this.playerOneArray = playerOne;

        this.playerTwoArray = playerTwo;

        createNumericValue();

    }

    public int getCount(){
        return playerOneCount;
    }

    public void createNumericValue(){

        int index = 0;

        // loop converts characters to a numerical value relevant to poker hands not ASCII.
        for(int i = 0; i < playerOneArray.length; i += 2){

            if(playerOneArray[i] == 'A') playerOneInteger[index] = 14;
            if(playerTwoArray[i] == 'A') playerTwoInteger[index] = 14;

            if(playerOneArray[i] == 'K') playerOneInteger[index] = 13;
            if(playerTwoArray[i] == 'K') playerTwoInteger[index] = 13;

            if(playerOneArray[i] == 'Q') playerOneInteger[index] = 12;
            if(playerTwoArray[i] == 'Q') playerTwoInteger[index] = 12;

            if(playerOneArray[i] == 'J') playerOneInteger[index] = 11;
            if(playerTwoArray[i] == 'J') playerTwoInteger[index] = 11;

            if(playerOneArray[i] == 'T') playerOneInteger[index] = 10;
            if(playerTwoArray[i] == 'T') playerTwoInteger[index] = 10;

            if(Character.getNumericValue(playerOneArray[i]) < 10){
                playerOneInteger[index] = Character.getNumericValue(playerOneArray[i]);
            }

            if(Character.getNumericValue(playerTwoArray[i]) < 10){
                playerTwoInteger[index] = Character.getNumericValue(playerTwoArray[i]);
            }

            index++;
        }

        // sorts arrays in ascending value.
        Arrays.sort(playerOneInteger);

        Arrays.sort(playerTwoInteger);
    }


    public int highestCardOne(){

        int high = 0;

        for(int i = 0; i < playerOneInteger.length; i++){
            if(playerOneInteger[i] > high){
                high = playerOneInteger[i];
            }
        }

        return high;
    }

    public int highestCardTwo(){

        int high = 0;

        for(int i = 0; i < playerTwoInteger.length; i++){
            if(playerTwoInteger[i] > high){
                high = playerTwoInteger[i];
            }
        }

        return high;
    }


    // checks that hand has same suit.
    public boolean sameSuit(char[] arr){

        boolean isSameSuit = true;

        for(int i = 1; i < arr.length; i += 2){
            char a = arr[1];

            if(a != arr[i]) isSameSuit = false;
        }

        return isSameSuit;
    }


    public void royalFlush(){

        // creates set with cards.
        HashSet<Character> cardsRoyalFlush1 = new HashSet<>();

        cardsRoyalFlush1.add('A');
        cardsRoyalFlush1.add('K');
        cardsRoyalFlush1.add('Q');
        cardsRoyalFlush1.add('J');
        cardsRoyalFlush1.add('T');

        // adds cards to set.
        cardsRoyalFlush1.add(playerOneArray[0]);
        cardsRoyalFlush1.add(playerOneArray[2]);
        cardsRoyalFlush1.add(playerOneArray[4]);
        cardsRoyalFlush1.add(playerOneArray[6]);
        cardsRoyalFlush1.add(playerOneArray[8]);

        // if equal player is royal flush.
        boolean isEqualPlayerOne = true;

        // if size 5 then no duplicates.
        if(cardsRoyalFlush1.size() == 5){

            isEqualPlayerOne = sameSuit(playerOneArray);
        }
        else{
            isEqualPlayerOne = false;
        }


        // creates set for player 2.
        HashSet<Character> cardsRoyalFlush2 = new HashSet<>();

        cardsRoyalFlush2.add('A');
        cardsRoyalFlush2.add('K');
        cardsRoyalFlush2.add('Q');
        cardsRoyalFlush2.add('J');
        cardsRoyalFlush2.add('T');

        cardsRoyalFlush2.add(playerTwoArray[0]);
        cardsRoyalFlush2.add(playerTwoArray[2]);
        cardsRoyalFlush2.add(playerTwoArray[4]);
        cardsRoyalFlush2.add(playerTwoArray[6]);
        cardsRoyalFlush2.add(playerTwoArray[8]);


        // is royal flush.
        boolean isEqualPlayerTwo = true;

        // checks for duplicate.
        if(cardsRoyalFlush2.size() == 5){

            isEqualPlayerTwo = sameSuit(playerTwoArray);

        }
        else{
            isEqualPlayerTwo = false;
        }

        if(isEqualPlayerOne && !isEqualPlayerTwo){
            playerOneCount++;
        }

        if(!isEqualPlayerOne && !isEqualPlayerTwo){
            straightFlush();
        }
    }

    // method to compare straight flush.
    public void straightFlush(){

        boolean isStraightPlayerOne = true;

        for(int i = 0; i < playerOneInteger.length - 1; i++){

            // if next number is not 1 more, then cant be a straight.
            int a = playerOneInteger[i];

            int b = playerOneInteger[i + 1];

            if(b != (a + 1)) isStraightPlayerOne = false;
        }

        boolean sameSuitOne = sameSuit(playerOneArray);

        if(!sameSuitOne) isStraightPlayerOne = false;

        boolean isStraightPlayerTwo = true;

        for(int i = 0; i < playerTwoInteger.length - 1; i++){

            // if next number is not 1 more, then cant be a straight.

            int a = playerTwoInteger[i];

            int b = playerTwoInteger[i + 1];

            if(b != (a + 1)) isStraightPlayerTwo = false;
        }

        boolean sameSuitTwo = sameSuit(playerTwoArray);

        if(!sameSuitTwo) isStraightPlayerTwo = false;

        if(isStraightPlayerOne && !isStraightPlayerTwo) playerOneCount++;

        if(isStraightPlayerOne && isStraightPlayerTwo){

            if(playerOneInteger[4] > playerTwoInteger[4]) playerOneCount++;
        }

        if(!isStraightPlayerOne && !isStraightPlayerTwo){
            fourOfAkind();
        }

    }

    public void fourOfAkind(){

        // players card count.
        int oneCounter = 0;
        int twoCounter = 0;

        // boolean if hand is four of a kind.
        boolean isFourOne = false;
        boolean isFourTwo = false;

        // high card in case of draw.
        int playerOneHighest = 0;
        int playerTwoHighest = 0;

        for(int i = 0; i < 3; i += 1){
            for(int j = 0; j < playerOneInteger.length; j += 1){

                if(playerOneInteger[i] == playerOneInteger[j]){
                    oneCounter++;
                    if(oneCounter == 4) playerOneHighest = playerOneInteger[i];
                }
                if(playerTwoInteger[i] == playerTwoInteger[j]){
                    twoCounter++;
                    if(twoCounter == 4) playerTwoHighest = playerTwoInteger[i];
                }
            }

            if(oneCounter == 4){
                isFourOne = true;
            }
            if(twoCounter == 4){
                isFourTwo = true;
            }
            oneCounter = 0;
            twoCounter = 0;
        }

        if(isFourOne && !isFourTwo){
            playerOneCount++;
        }

        if(isFourOne && isFourTwo){
            if(playerOneHighest > playerTwoHighest){
                playerOneCount++;
            }
        }

        if(!isFourOne && !isFourTwo){
            fullHouse();
        }

    }

    public void fullHouse(){

        int oneHighCard = 0, twoHighCard = 0;

        boolean isFullHouseOne = false;

        boolean isFullHouseTwo = false;

        int counterOne = 0;

        int counterTwo = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < playerOneInteger.length; j++){

                if(playerOneInteger[i] == playerOneInteger[j]) counterOne++;

                if(playerTwoInteger[i] == playerTwoInteger[j]) counterTwo++;

                if(counterOne == 3){
                    oneHighCard = playerOneInteger[i];
                    isFullHouseOne = true;
                }

                if(counterTwo == 3){
                    twoHighCard = playerTwoInteger[i];
                    isFullHouseTwo = true;
                }
            }
            counterOne = 0;
            counterTwo = 0;
        }

        if(isFullHouseOne){

            HashSet<Integer> house = new HashSet<>();
            HashSet<Integer> full = new HashSet<>();

            for (int i: playerOneInteger
                 ) {
                house.add(i);
            }

            if(house.size() != 2){
                isFullHouseOne = false;
            }

            for (int i: playerTwoInteger
                 ) {
                full.add(i);
            }

            if(full.size() != 2){
                isFullHouseTwo = false;
            }

        }

        if(isFullHouseOne && !isFullHouseTwo){
            playerOneCount++;
        }

        if(isFullHouseOne && isFullHouseTwo){
            if(oneHighCard > twoHighCard){
                playerOneCount++;
            }
        }

        if(!isFullHouseOne && !isFullHouseTwo){
            flush();
        }
    }

    public void flush(){

        boolean isFlushOne = sameSuit(playerOneArray);

        boolean isFlushTwo = sameSuit(playerTwoArray);

        if(isFlushOne && !isFlushTwo){
            playerOneCount++;
        }

        if(isFlushOne && isFlushTwo){
            int cardOne = highestCardOne();
            int cardTwo = highestCardTwo();

            if(cardOne > cardTwo){
                playerOneCount++;
            }
        }

        if(!isFlushOne && !isFlushTwo){
            straight();
        }
    }

    public void straight(){

        boolean isStraightPlayerOne = true;

        for(int i = 0; i < playerOneInteger.length - 1; i++){

            // if next number is not 1 more, then cant be a straight.
            int a = playerOneInteger[i];

            int b = playerOneInteger[i + 1];

            if(b != (a + 1)) isStraightPlayerOne = false;
        }

        boolean isStraightPlayerTwo = true;

        for(int i = 0; i < playerTwoInteger.length - 1; i++){

            // if next number is not 1 more, then cant be a straight.
            int a = playerTwoInteger[i];

            int b = playerTwoInteger[i + 1];

            if(b != (a + 1)) isStraightPlayerTwo = false;
        }

        if(isStraightPlayerOne && !isStraightPlayerTwo){
            playerOneCount++;
        }

        if(isStraightPlayerOne && isStraightPlayerTwo){
            int cardOne = highestCardOne();
            int cardTwo = highestCardTwo();

            if(cardOne > cardTwo){
                playerOneCount++;
            }
        }

        if(!isStraightPlayerOne && !isStraightPlayerTwo){
            threeOfAkind();
        }
    }

    public void threeOfAkind(){

        boolean isThreeOne = false;
        boolean isThreeTwo = false;

        int highCardOne = 0, highCardTwo = 0;

        int counterOne = 0, counterTwo = 0;

        for(int i = 0; i < 3; i++){
            for(int j = i; j < playerOneInteger.length; j++){

                if(playerOneInteger[i] == playerOneInteger[j]){
                    counterOne++;
                }
                if(playerTwoInteger[i] == playerTwoInteger[j]){
                    counterTwo++;
                }

                if(counterOne == 3){
                    isThreeOne = true;
                    highCardOne = playerOneInteger[i];
                }

                if(counterTwo == 3){
                    isThreeTwo = true;
                    highCardTwo = playerTwoInteger[i];
                }
            }
            counterOne = 0;
            counterTwo = 0;
        }

        if(isThreeOne && !isThreeTwo){
            playerOneCount++;
        }

        if(isThreeOne && isThreeTwo){
            if(highCardOne > highCardTwo){
                playerOneCount++;
            }
        }

        if(!isThreeOne && !isThreeTwo){
            twoPair();
        }
    }

    public void twoPair(){

        HashSet<Integer> playerOne = new HashSet<>();
        HashSet<Integer> playerTwo = new HashSet<>();

        boolean playerOneIsTwoPair = false;

        boolean playerTwoIsTwoPair = false;

        for(int i = 0; i < playerOneInteger.length; i++){

            playerOne.add(playerOneInteger[i]);
            playerTwo.add(playerTwoInteger[i]);
        }

        if(playerOne.size() == 3){

            playerOneIsTwoPair = true;

            int counter = 0;

            for(int i = 0; i < playerOneInteger.length; i++){
                for(int j = i; j < playerOneInteger.length; j++){

                    if(playerOneInteger[i] == playerOneInteger[j]){
                        counter++;
                    }
                }
                if(counter == 1){

                    int a = playerOneInteger[i];

                    playerOne.remove(a);

                }
            }
        }

        if(playerTwo.size() == 3){

            playerTwoIsTwoPair = true;

            int counter = 0;

            for(int i = 0; i < playerTwoInteger.length; i++){
                for(int j = i; j < playerTwoInteger.length; j++){

                    if(playerTwoInteger[i] == playerTwoInteger[j]){
                        counter++;
                    }
                }
                if(counter == 1){

                    int a = playerTwoInteger[i];

                    playerTwo.remove(a);

                }
            }
        }

        if(playerOneIsTwoPair && !playerTwoIsTwoPair){
            playerOneCount++;
        }

        if(playerOneIsTwoPair && playerTwoIsTwoPair){
            int a = Collections.max(playerOne);
            int b = Collections.max(playerTwo);

            if(a > b) {
                playerOneCount++;
            }
        }

        if(!playerOneIsTwoPair && !playerTwoIsTwoPair){
            onePair();
        }
    }

    public  void onePair(){

        int highCardOne = 0;

        int highCardTwo = 0;

        HashSet<Integer> playerOne = new HashSet<>();
        HashSet<Integer> playerTwo = new HashSet<>();

        boolean isPairOne = false;

        boolean isPairTwo = false;

        for(int i = 0; i < playerOneInteger.length; i++){
            playerOne.add(playerOneInteger[i]);
            playerTwo.add(playerTwoInteger[i]);
        }

        if(playerOne.size() == 4){

            isPairOne = true;

            int counter = 0;

            for(int i = 0; i < playerOneInteger.length; i++){
                for(int j = i; j < playerOneInteger.length; j++){

                 if(playerOneInteger[i] == playerOneInteger[j]){
                     counter++;
                 }
                }

                if(counter == 2) {
                    highCardOne = playerOneInteger[i];
                }

                counter = 0;
            }

        }


        if(playerTwo.size() == 4){

            isPairTwo = true;

            int counter = 0;

            for(int i = 0; i < playerTwoInteger.length; i++){
                for(int j = i; j < playerTwoInteger.length; j++){

                    if(playerTwoInteger[i] == playerTwoInteger[j]){
                        counter++;
                    }
                }

                if(counter == 2) highCardTwo = playerTwoInteger[i];

                counter = 0;
            }

        }

        if(isPairOne && !isPairTwo){
            playerOneCount++;

        }

        if(isPairOne && isPairTwo){
            if(highCardOne > highCardTwo){
                playerOneCount++;
            }
        }

        if(!isPairOne && !isPairTwo){
            highCard();
        }

    }

    public void highCard(){

        int one = highestCardOne();

        int two = highestCardTwo();

        if(one > two) playerOneCount++;
    }
}


class ArrayBuild{

    String[] hands = new String[10];

    String playerOne = "";

    String playerTwo = "";

    char[] playerOneArray;

    char[] playerTwoArray;

    public ArrayBuild(){

    }

    public char[] getPlayerOneArray() {
        return playerOneArray;
    }

    public char[] getPlayerTwoArray() {
        return playerTwoArray;
    }

    public void createArray(String s){

        hands = s.split(" ");

        for(int i = 0; i < 5; i++){

            playerOne = playerOne + hands[i];
        }

        for(int j = 5; j < hands.length; j++){

            playerTwo = playerTwo + hands[j];
        }

        playerOneArray = playerOne.toCharArray();

        playerTwoArray = playerTwo.toCharArray();

    }

}

