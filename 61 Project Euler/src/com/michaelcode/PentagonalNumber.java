package com.michaelcode;

import java.util.ArrayList;
import java.util.List;

public class PentagonalNumber implements FigurateNumbers {

    List<ArrayList> pentNum2d = new ArrayList<>();

    public PentagonalNumber(){
        loopToCreateNum();
    }

    // getter.
    @Override
    public List<ArrayList> getList() {
        return this.pentNum2d;
    }

    // formula to create pent number.
    @Override
    public int createNumberFormula(int n) {
        return (n * (3 * n - 1)) / 2;
    }

    // loop to create N for formula.
    @Override
    public void loopToCreateNum() {

        for(int i = 1; i < 85; i++){

            int pentNum = createNumberFormula(i);

            if(pentNum >= 1000 && pentNum < 10000) addNumberToList(pentNum);
        }
    }

    @Override
    public void addNumberToList(int pentNum) {

        // creates string out of int.
        String num = String.valueOf(pentNum);

        // splits string.
        String part1 = num.substring(0, 2);

        String part2 = num.substring(2);

        // creates new list.
        ArrayList<String> pentSubList = new ArrayList<>();

        pentSubList.add(part1);

        pentSubList.add(part2);

        // adds list to 2d list.
        pentNum2d.add(pentSubList);

    }
}
