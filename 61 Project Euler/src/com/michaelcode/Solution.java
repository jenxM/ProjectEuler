package com.michaelcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    List<ArrayList> triNum;
    List<ArrayList> squareNum;
    List<ArrayList> pentNum;
    List<ArrayList> heptNum;
    List<ArrayList> hexNum;
    List<ArrayList> octNum;
    List<List> figNumList = new ArrayList<>();

    // constructor creates number objects and gets list from each class.
    public Solution(){

        TriangleNumber obj1 = new TriangleNumber();
        this.triNum = obj1.getList();

        SquareNumber obj2 = new SquareNumber();
        this.squareNum = obj2.getList();

        PentagonalNumber obj3 = new PentagonalNumber();
        this.pentNum = obj3.getList();

        HeptagonalNumber obj4 = new HeptagonalNumber();
        this.heptNum = obj4.getList();

        HexagonalNumber obj5 = new HexagonalNumber();
        this.hexNum = obj5.getList();

        OctagonalNumber obj6 = new OctagonalNumber();
        this.octNum = obj6.getList();

        createListOfFigNum();
    }

    public void createListOfFigNum(){

        figNumList.add(triNum);
        figNumList.add(squareNum);
        figNumList.add(pentNum);
        figNumList.add(hexNum);
        figNumList.add(heptNum);
        figNumList.add(octNum);

    }

    /*
        Methods permutate through all lists, using a big list of all fig num lists.
        Passes each value to function for comparison then moves on.
     */

    public void permutationOne() {

        for (int a = 0; a < figNumList.size(); a++) {

            List<ArrayList> listOne = figNumList.get(a);

            HashSet<String> answerSet = new HashSet<>();

            HashSet<Integer> nonDuplicate = new HashSet<>();

            for (int i = 0; i < listOne.size(); i++) {

                String firstPart = (String) listOne.get(i).get(0);

                String secondPart = (String) listOne.get(i).get(1);

                String fullNum = firstPart + secondPart;

                answerSet.add(fullNum);

                nonDuplicate.add(a);

                permutationTwo(answerSet, secondPart, firstPart, nonDuplicate);

                answerSet.remove(fullNum);
                nonDuplicate.remove(a);
            }
        }
    }

    public void permutationTwo(HashSet<String> answerSet, String secondPart1, String loopOneVal, HashSet<Integer> non) {

        for (int a = 0; a < figNumList.size(); a++) {

            if(!non.contains(a)) {

                List<ArrayList> listOne = figNumList.get(a);

                for (int i = 0; i < listOne.size(); i++) {

                    String firstPart = (String) listOne.get(i).get(0);

                    String secondPart = (String) listOne.get(i).get(1);

                    String fullNum = firstPart + secondPart;

                    if (firstPart.compareTo(secondPart1) == 0) {

                        answerSet.add(fullNum);
                        non.add(a);
                        permutationThree(answerSet, secondPart, loopOneVal, non);
                    }

                    answerSet.remove(fullNum);
                    non.remove(a);
                }
            }
        }
    }

    public void permutationThree(HashSet<String> answerSet, String secondPart2, String loopOneVal, HashSet<Integer> non) {

        for (int a = 0; a < figNumList.size(); a++) {

            if(!non.contains(a)) {


                List<ArrayList> listOne = figNumList.get(a);

                for (int i = 0; i < listOne.size(); i++) {

                    String firstPart = (String) listOne.get(i).get(0);

                    String secondPart = (String) listOne.get(i).get(1);

                    String fullNum = firstPart + secondPart;

                    if (firstPart.compareTo(secondPart2) == 0) {

                        answerSet.add(fullNum);
                        non.add(a);

                        permutationFour(answerSet, secondPart, loopOneVal, non);
                    }

                    answerSet.remove(fullNum);
                    non.remove(a);
                }
            }
        }
    }

    public void permutationFour(HashSet<String> answerSet, String secondPart3, String loopOneVal, HashSet<Integer> non) {

        for (int a = 0; a < figNumList.size(); a++) {

            if(!non.contains(a)) {

                List<ArrayList> listOne = figNumList.get(a);

                for (int i = 0; i < listOne.size(); i++) {

                    String firstPart = (String) listOne.get(i).get(0);

                    String secondPart = (String) listOne.get(i).get(1);

                    String fullNum = firstPart + secondPart;

                    if (firstPart.compareTo(secondPart3) == 0) {

                        answerSet.add(fullNum);

                        non.add(a);

                        permutationFive(answerSet, secondPart, loopOneVal, non);
                    }
                    answerSet.remove(fullNum);
                    non.remove(a);
                }

            }
        }
    }

    public void permutationFive(HashSet<String> answerSet, String secondPart4, String loopOneVal, HashSet<Integer> non) {

        for (int a = 0; a < figNumList.size(); a++) {

            if(!non.contains(a)) {

                List<ArrayList> listOne = figNumList.get(a);

                for (int i = 0; i < listOne.size(); i++) {

                    String firstPart = (String) listOne.get(i).get(0);

                    String secondPart = (String) listOne.get(i).get(1);

                    String fullNum = firstPart + secondPart;

                    if (firstPart.compareTo(secondPart4) == 0) {

                        answerSet.add(fullNum);

                        non.add(a);

                        permutationSix(answerSet, secondPart, loopOneVal, non);
                    }

                    answerSet.remove(fullNum);
                    non.remove(a);
                }
            }
        }
    }

    public void permutationSix(HashSet<String> answerSet, String secondPart5, String loopOneVal, HashSet<Integer> non) {

        for (int a = 0; a < figNumList.size(); a++) {

            if(!non.contains(a)) {

                List<ArrayList> listOne = figNumList.get(a);

                for (int i = 0; i < listOne.size(); i++) {

                    String firstPart = (String) listOne.get(i).get(0);

                    String secondPart = (String) listOne.get(i).get(1);

                    String fullNum = firstPart + secondPart;

                    if (firstPart.compareTo(secondPart5) == 0) {

                        if (secondPart.compareTo(loopOneVal) == 0) {

                            answerSet.add(fullNum);
                        }
                    }

                    if (answerSet.size() == 6) sumSet(answerSet);

                    answerSet.remove(fullNum);
                }

            }
        }
    }

    public void sumSet(HashSet<String> ansSet){

        ArrayList<String> list = new ArrayList<>(ansSet);

        int sum = 0;

        for(int i = 0; i < list.size(); i++){

            int temp = Integer.parseInt(list.get(i));

            sum += temp;
        }

        System.out.println(sum);
    }
}
