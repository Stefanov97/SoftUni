package gettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class myClass = Reflection.class;

        Method[] declaredMethods = myClass.getDeclaredMethods();

        Arrays.stream(declaredMethods).
                filter(m -> m.getName().
                startsWith("get") && m.getParameterCount() == 0).
                sorted(Comparator.comparing(Method::getName)).
                forEach(getter -> System.out.println(String.format("%s will return class %s",
                getter.getName(), getter.getReturnType().getName())));

        Arrays.stream(declaredMethods).
                filter(m -> m.getName().
                        startsWith("set") && m.getParameterCount() == 1).
                sorted(Comparator.comparing(Method::getName)).
                forEach(setter -> System.out.println(String.format("%s and will set field of class %s",
                        setter.getName(), setter.getParameterTypes()[0].getName())));
    }
}
