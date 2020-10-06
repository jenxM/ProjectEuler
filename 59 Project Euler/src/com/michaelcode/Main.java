package com.michaelcode;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Cypher.readMessage();

        Cypher.createWordList();

        /*
            After no luck with brute force, I found most frequent number and suspected it to be a space.
            That gave me a 2 letter word at the start, so by process of elimination i tried all 2 letter words that fit.
            key = exp.
            I expect my brute force did not work because the file i downloaded to check was only for english words.
            As output includes latin words and numbers, this doesn't work.
         */

        Cypher obj = new Cypher();

        char[] arr = Cypher.getArrayCh();

        String s = "exp";

        obj.xorDecrypt(s);

    }
}
