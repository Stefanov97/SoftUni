package word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandImpl implements CommandInterface {
    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;
    private String memory;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.commandTransforms.put("uppercase", new ToUpperTransform());
        this.commandTransforms.put("cut", new Cut());
        this.commandTransforms.put("paste", new Paste());


        this.text = text;
        this.memory = "";
    }

    class ToUpperTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
    }

    @Override
    public void init() {
        this.commandTransforms.clear();
        for (Command p : this.initCommands()) {
            this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
        }
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);


        if (commandName.equals("cut")) {
            this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
            Cut cut = (Cut) this.commandTransforms.get(commandName);
            this.memory = cut.getMemory();

        } else if (commandName.equals("paste")) {
            Paste paste = (Paste) this.commandTransforms.get(commandName);
            paste.getMemory(this.memory);
            paste.invokeOn(this.text, startInd, endInd);
        } else {
            this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
        }
    }

    public List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut", new Cut()));
        commands.add(new Command("paste", new Paste()));


        return commands;
    }

}
