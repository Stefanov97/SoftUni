package systemSplit.core;

import systemSplit.hardware.Hardware;

import java.util.LinkedHashMap;
import java.util.Map;

public class TheDump extends TheSystem {
    private Map<String, Hardware> theDump;

    public TheDump() {
        super();
        this.theDump = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Hardware> getHardwareComponents() {
        return super.getHardwareComponents();
    }

    public Map<String, Hardware> getTheDump() {
        return this.theDump;
    }
}
