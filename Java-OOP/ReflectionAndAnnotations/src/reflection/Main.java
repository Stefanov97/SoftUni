package reflection;

import java.lang.reflect.InvocationTargetException;
import java.sql.Ref;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class myClass = Reflection.class;
        System.out.println(myClass);
        System.out.println(myClass.getSuperclass());
        for (Class anInterface : myClass.getInterfaces()) {
            System.out.println(anInterface);
        }

        Reflection reflection =(Reflection) myClass.getConstructor().newInstance();
        System.out.println(reflection);

    }
}
