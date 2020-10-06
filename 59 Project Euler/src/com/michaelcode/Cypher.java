package com.michaelcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cypher {

    private static String[] messageNumbers;

    private static ArrayList<String> englishWords = new ArrayList<>();

    static char[] arrayCh = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    static File message = new File("C:\\Users\\mikej\\Documents\\code\\p059_cipher.txt");

    static File words = new File("C:\\Users\\mikej\\Documents\\code\\words_alpha.txt");

    char[] asciiVal;


    public Cypher(){

    }

    public static void readMessage() throws FileNotFoundException {

        Scanner search = new Scanner(message);

        String token = "";

        while(search.hasNextLine()){
            token = search.nextLine();
        }

        messageNumbers = token.split(",");

    }

    public static char[] getArrayCh() {
        return arrayCh;
    }

    public static void createWordList() throws FileNotFoundException {

        Scanner input = new Scanner(words);

        while(input.hasNextLine()){

            englishWords.add(input.nextLine());
        }
    }

    public void xorDecrypt(String s){

        int keyItr = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < messageNumbers.length; i++){

            int encryptedN = Integer.parseInt(messageNumbers[i]);

            int xor = encryptedN ^ s.charAt(keyItr);

            char c = (char) xor;

            keyItr++;

            if(keyItr > 2) keyItr = 0;

            sb.append(c);
        }

        String plainTextMessage = String.valueOf(sb);

        asciiVal = plainTextMessage.toCharArray();

        System.out.println(plainTextMessage);

        addArray();
    }

    public void addArray(){

        int sum = 0;

        for(int i = 0; i < asciiVal.length; i++){

            sum += asciiVal[i];

        }

        System.out.println(sum);
    }

    public void maxFrequency(){

        int maxCount = 0;

        int count = 0;

        int maxNumber = 0;

        for(int i = 0; i < messageNumbers.length; i++){
            for(int j = i + 1; j < messageNumbers.length; j++){

                if(messageNumbers[i].equals(messageNumbers[j])) count++;
            }

            if(count > maxCount){

                maxCount = count;

                maxNumber = i;
            }
            count = 0;
        }
        System.out.println(maxNumber + " " + maxCount);
    }

}
