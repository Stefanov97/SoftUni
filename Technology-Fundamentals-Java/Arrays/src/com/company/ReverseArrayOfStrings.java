package com.company;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] array = scanner.nextLine().split(" +");

        for (int i = 0; i <array.length/2 ; i++) { // a b c d
            String oldFirst = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = oldFirst;
        }
        for (String output:array) {
            System.out.print(output+" ");
        }
    }
}
