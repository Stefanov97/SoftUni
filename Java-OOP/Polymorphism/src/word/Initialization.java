package word;

public class Initialization {
    public static CommandImpl buildCommandInterface(StringBuilder text) {
        return new CommandImpl(text);
    }
}
