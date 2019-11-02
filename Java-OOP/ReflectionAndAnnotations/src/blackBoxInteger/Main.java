package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> myClass = BlackBoxInt.class;
        BlackBoxInt blackBoxInt = null;
        try {
            Constructor<BlackBoxInt> constructor = myClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            blackBoxInt = constructor.newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        String line = scanner.nextLine();

        while (!"END".equals(line)){
            String[] tokens = line.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method[] methods = myClass.getDeclaredMethods();
            for (Method method : methods) {
                if(method.getName().equals(command)){
                    method.setAccessible(true);
                    try {
                        method.invoke(blackBoxInt,value);
                        Field innerValue = myClass.getDeclaredField("innerValue");
                        innerValue.setAccessible(true);
                        System.out.println(innerValue.getInt(blackBoxInt));
                    } catch (IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
            }


            line = scanner.nextLine();
        }
    }
}
