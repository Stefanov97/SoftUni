import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    private static void printArray(int[] firstEven) { //2 4 6 -1
        System.out.print("[");
        for (int i = 0; i < firstEven.length; i++) {
            if (firstEven[i] != -1) {
                if (i == firstEven.length - 1) {
                    System.out.print(firstEven[i]);
                } else if (firstEven[i + 1] == -1) {
                    System.out.print(firstEven[i]);
                } else {
                    System.out.print(firstEven[i] + "," + " ");
                }
            }
        }
        System.out.println("]");
    }

    static void getArray(int[] exchangedArray, int[] initialArray) {
        for (int i = 0; i < exchangedArray.length; i++) {
            initialArray[i] = exchangedArray[i];
        }
    }

    static void exchange(String[] command, int[] initialArray) {
        if (Integer.parseInt(command[1]) < initialArray.length && Integer.parseInt(command[1]) >= 0) {
            int[] exchangedArray = new int[initialArray.length];
            int exchangedIndex = 0;
            for (int i = Integer.parseInt(command[1]) + 1; i < exchangedArray.length; i++) {
                exchangedArray[exchangedIndex] = initialArray[i];
                exchangedIndex++;
            }
            int initialIndex = 0;
            for (int i = exchangedIndex; i < exchangedArray.length; i++) {
                exchangedArray[i] = initialArray[initialIndex];
                initialIndex++;
            }
            getArray(exchangedArray, initialArray);
        } else {
            System.out.println("Invalid index");
        }
    }

    static void getMinOdd(int[] initialArray) {
        int minOddNumber = Integer.MAX_VALUE;
        int minOddIndex = -1;
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] % 2 != 0) {
                if (initialArray[i] <= minOddNumber) {
                    minOddNumber = initialArray[i];
                    minOddIndex = i;
                }
            }
        }
        if (minOddIndex != -1) {
            System.out.println(minOddIndex);
        } else {
            System.out.println("No matches");
        }
    }

    static void getMinEven(int[] initialArray) {
        int minEvenNumber = Integer.MAX_VALUE;
        int minEvenIndex = -1;
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] % 2 == 0) {
                if (initialArray[i] <= minEvenNumber) {
                    minEvenNumber = initialArray[i];
                    minEvenIndex = i;
                }
            }
        }
        if (minEvenIndex != -1) {
            System.out.println(minEvenIndex);
        } else {
            System.out.println("No matches");
        }
    }

    static void getMaxOdd(int[] initialArray) {
        int maxOddNumber = Integer.MIN_VALUE;
        int maxOddIndex = -1;
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] % 2 != 0) {
                if (initialArray[i] >= maxOddNumber) {
                    maxOddNumber = initialArray[i];
                    maxOddIndex = i;
                }
            }
        }
        if (maxOddIndex != -1) {
            System.out.println(maxOddIndex);
        } else {
            System.out.println("No matches");
        }
    }

    static void getMaxEven(int[] initialArray) {
        int maxEvenNumber = Integer.MIN_VALUE;
        int maxEvenIndex = -1;
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] % 2 == 0) {
                if (initialArray[i] >= maxEvenNumber) {
                    maxEvenNumber = initialArray[i];
                    maxEvenIndex = i;
                }
            }
        }
        if (maxEvenIndex != -1) {
            System.out.println(maxEvenIndex);
        } else {
            System.out.println("No matches");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] initialArray = Arrays.stream(scanner.nextLine().split(" +")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "exchange":
                    exchange(command, initialArray);
                    break;
                case "min":
                case "max":
                    if (command[0].equals("min")) {
                        if (command[1].equals("odd")) {
                            getMinOdd(initialArray);
                        } else {
                            getMinEven(initialArray);
                        }
                    } else {
                        if (command[1].equals("odd")) {
                            getMaxOdd(initialArray);
                        } else {
                            getMaxEven(initialArray);
                        }
                    }
                    break;
                case "first":
                case "last":
                    int count = Integer.parseInt(command[1]);
                    if (count <= initialArray.length && count > -1) {
                        if (command[0].equals("first")) {
                            if (command[2].equals("even")) {
                                int[] firstEven = getFirstEven(initialArray, count);
                                printArray(firstEven);
                            } else {
                                int[] firstOdd = getFirstOdd(initialArray, count);
                                printArray(firstOdd);
                            }
                        } else {
                            if (command[2].equals("even")) {
                                int[] lastEven = getLastEven(initialArray, count);
                                printArray(lastEven);
                            } else {
                                int[] lastOdd = getLastOdd(initialArray, count);
                                printArray(lastOdd);
                            }
                        }
                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        printArray(initialArray);
    }

    private static int[] getLastOdd(int[] initialArray, int count) {
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int foundOdd = 0;
        for (int i = initialArray.length - 1; i >= 0; i--) {
            if (initialArray[i] % 2 != 0 && foundOdd < count) {
                result[foundOdd] = initialArray[i];
                foundOdd++;
            }
        }
        int[] realResult = new int[result.length];
        int index = 0;
        for (int i = realResult.length - 1; i >= 0; i--) {
            realResult[index++] = result[i];
        }
        return realResult;
    }

    private static int[] getLastEven(int[] initialArray, int count) {
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int foundEven = 0;
        for (int i = initialArray.length - 1; i >= 0; i--) {
            if (initialArray[i] % 2 == 0 && foundEven < count) {
                result[foundEven] = initialArray[i];
                foundEven++;
            }
        }
        int[] realResult = new int[result.length];
        int index = 0;
        for (int i = realResult.length - 1; i >= 0; i--) {
            realResult[index++] = result[i];
        }
        return realResult;
    }

    private static int[] getFirstOdd(int[] initialArray, int count) {
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int foundEven = 0;
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] % 2 != 0 && foundEven < count) {
                result[foundEven] = initialArray[i];
                foundEven++;
            }
        }
        return result;
    }

    private static int[] getFirstEven(int[] initialArray, int count) {
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int foundEven = 0;
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] % 2 == 0 && foundEven < count) {
                result[foundEven] = initialArray[i];
                foundEven++;
            }
        }
        return result;
    }
}