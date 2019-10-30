package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class MemorySaveOperation implements Operation {
    Deque<Integer> memory;

    public MemorySaveOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    public Deque<Integer> getMemory() {
        return this.memory;
    }
}
