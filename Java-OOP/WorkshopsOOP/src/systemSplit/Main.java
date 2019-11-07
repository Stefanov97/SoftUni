package systemSplit;

import systemSplit.core.Engine;
import systemSplit.core.TheDump;
import systemSplit.core.TheSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        TheSystem system = new TheDump();
        Engine engine = new Engine(scanner,system);
        engine.run();
    }
}
