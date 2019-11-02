package codingTracker;

        import java.lang.annotation.Annotation;
        import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        for (Method method : Tracker.class.getDeclaredMethods()) {
            if (method.getAnnotation(Author.class) != null) {
                System.out.println(String.format("%s - %s", method.getAnnotation(Author.class).name(), method.getName()));
            }
        }
    }
}
