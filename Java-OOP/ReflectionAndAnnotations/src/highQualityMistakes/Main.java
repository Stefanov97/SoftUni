package highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class myClass = Reflection.class;

        Arrays.stream(myClass.getDeclaredFields()).
                filter(field -> !Modifier.isPrivate(field.getModifiers())).
                sorted(Comparator.comparing(Field::getName)).
                forEach(field -> System.out.println(String.format("%s must be private!",field.getName())));

        Method[] declaredMethods = myClass.getDeclaredMethods();

        Arrays.stream(declaredMethods).
                filter(m -> m.getName().
                        startsWith("get") && m.getParameterCount() == 0 && !Modifier.isPublic(m.getModifiers())).
                sorted(Comparator.comparing(Method::getName)).
                forEach(getter -> System.out.println(String.format("%s have to be public!",
                        getter.getName())));

        Arrays.stream(declaredMethods).
                filter(m -> m.getName().
                        startsWith("set") && m.getParameterCount() == 1 && !Modifier.isPrivate(m.getModifiers())).
                sorted(Comparator.comparing(Method::getName)).
                forEach(setter -> System.out.println(String.format("%s have to be private!",
                        setter.getName())));
    }
}
