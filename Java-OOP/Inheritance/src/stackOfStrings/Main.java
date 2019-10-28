package stackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();
        sos.push("1");
        sos.push("1");
        sos.push("3");
        System.out.println(sos.pop());
    }
}
