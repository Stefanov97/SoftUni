package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first= Arrays.stream(scanner.nextLine().split(" +")).mapToInt(Integer::parseInt).toArray();
        int [] second = Arrays.stream(scanner.nextLine().split(" +")).mapToInt(Integer::parseInt).toArray();
        int index = 0;
        boolean areEqual = true;
        int sum=0;
        for (int i = 0; i <first.length ; i++) {
            if(first[i]!=second[i]){
                areEqual=false;
                break;
            }else {
                sum+=first[i];
            }

            index++;
        }
        if(areEqual){
            System.out.printf("Arrays are identical. Sum: %d",sum);
        }else {
            System.out.printf("Arrays are not identical. Found difference at %d index.",index);
        }
    }
}
