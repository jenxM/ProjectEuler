package com.michaelcode;

public class Main {

    public static void main(String[] args) {
        int result = 0;
        int maxCount = 0;

        int[] arr = new int[(int) (5 * Math.pow(10, 6) + 1)];

        for (int i = 2; i <= 3732423; i++) {
            int count = steps(i, 0);

            if (count > maxCount) {
                result = i;
                maxCount = count;
            } else if (count == maxCount) {
                result = i;
            }
            arr[i] = result;
        }

        int n = 1000000;

        if (n > 3732423) {
            System.out.println(3732423);
        } else {
            System.out.println(arr[n]);
        }
    }
        public static int steps(long num, int count){

            while(num != 1){

                if(num % 2 == 0){
                    count++;
                    num = num / 2;
                }
                else{
                    count++;
                    num = num * 3 + 1;
                }
            }

            return count++;
        }


}

