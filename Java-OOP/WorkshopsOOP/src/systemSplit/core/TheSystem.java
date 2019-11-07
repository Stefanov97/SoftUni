package systemSplit.core;

import systemSplit.hardware.Hardware;

import java.util.LinkedHashMap;
import java.util.Map;

public class TheSystem {
    private Map<String, Hardware> hardwareComponents;

    public TheSystem() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public Map<String, Hardware> getHardwareComponents() {
        return this.hardwareComponents;
    }
}
