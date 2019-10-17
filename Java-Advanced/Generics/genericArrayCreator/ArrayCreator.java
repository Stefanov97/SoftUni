import java.lang.reflect.Array;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        Object[] obj = new Object[length];
        for (int i = 0; i < obj.length; i++) {
            obj[i] = item;
        }
        return (T[]) obj;
    }

    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] o = (T[]) Array.newInstance(tClass, length);

        for (int i = 0; i < o.length; i++) {
            o[i] = item;
        }
        return o;
    }
}
