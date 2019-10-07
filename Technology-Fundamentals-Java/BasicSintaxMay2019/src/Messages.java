import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            int numberClicks = command.length();
            String commandForSwitch = command.substring(command.length() - 1);
            switch (commandForSwitch) {
                case "0":
                    System.out.print(" ");
                    break;
                case "2":
                    if (numberClicks == 1) {
                        System.out.print("a");
                    } else if (numberClicks == 2) {
                        System.out.print("b");
                    } else if (numberClicks == 3) {
                        System.out.print("c");
                    }

                    break;
                case "3":
                    if (numberClicks == 1) {
                        System.out.print("d");
                    } else if (numberClicks == 2) {
                        System.out.print("e");
                    } else if (numberClicks == 3) {
                        System.out.print("f");
                    }

                    break;
                case "4":
                    if (numberClicks == 1) {
                        System.out.print("g");
                    } else if (numberClicks == 2) {
                        System.out.print("h");
                    } else if (numberClicks == 3) {
                        System.out.print("i");
                    }

                    break;
                case "5":
                    if (numberClicks == 1) {
                        System.out.print("j");
                    } else if (numberClicks == 2) {
                        System.out.print("k");
                    } else if (numberClicks == 3) {
                        System.out.print("l");
                    }

                    break;
                case "6":
                    if (numberClicks == 1) {
                        System.out.print("m");
                    } else if (numberClicks == 2) {
                        System.out.print("n");
                    } else if (numberClicks == 3) {
                        System.out.print("o");
                    }

                    break;
                case "7":
                    if (numberClicks == 1) {
                        System.out.print("p");
                    } else if (numberClicks == 2) {
                        System.out.print("q");
                    } else if (numberClicks == 3) {
                        System.out.print("r");
                    } else if (numberClicks == 4) {
                        System.out.print("s");
                    }

                    break;
                case "8":
                    if (numberClicks == 1) {
                        System.out.print("t");
                    } else if (numberClicks == 2) {
                        System.out.print("u");
                    } else if (numberClicks == 3) {
                        System.out.print("v");
                    }

                    break;
                case "9":
                    if (numberClicks == 1) {
                        System.out.print("w");
                    } else if (numberClicks == 2) {
                        System.out.print("x");
                    } else if (numberClicks == 3) {
                        System.out.print("y");
                    } else if (numberClicks == 4) {
                        System.out.print("z");
                    }

                    break;
            }
        }
    }
}
