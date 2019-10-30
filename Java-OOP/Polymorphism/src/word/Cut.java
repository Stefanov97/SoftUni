package word;

public class Cut implements TextTransform {
    private String memory;

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.memory = "";
        for (int i = startIndex; i < endIndex; i++) {
            this.memory += text.charAt(i);
        }
        text.replace(startIndex, endIndex, "");

    }

    public String getMemory() {
        return this.memory;
    }
}
