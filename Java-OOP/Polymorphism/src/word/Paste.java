package word;

public class Paste implements TextTransform {
    private String memory = "";

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            text.insert(startIndex, this.memory);
        } else {
            int index = 0;
            text.replace(startIndex, endIndex, "");
            text.insert(startIndex, this.memory);

        }


    }

    public void getMemory(String memory) {
        this.memory = memory;
    }
}
