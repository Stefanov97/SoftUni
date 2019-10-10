package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CondenceArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int []condenced = new int[numbers.length-1];
        while (numbers.length>1) {
            for (int i = 0; i < numbers.length-1; i++) {

                    condenced[i] = numbers[i] + numbers[i + 1];


            }
            numbers=condenced;
            condenced=new int[numbers.length-1];
        }
        System.out.println(numbers[0]);
    }
}
