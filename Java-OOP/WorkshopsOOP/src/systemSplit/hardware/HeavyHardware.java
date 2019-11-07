package systemSplit.hardware;

import systemSplit.software.Software;

public class HeavyHardware extends Hardware {
    private static final String TYPE = "Heavy";
    private int totalUsedCapacity;
    private int totalUsedMemory;

    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, TYPE, maximumCapacity, maximumMemory);
        this.totalUsedCapacity = 0;
        this.totalUsedMemory = 0;
    }

    @Override
    public long getMaximumCapacity() {
        long baseCapacity = super.getMaximumCapacity();
        baseCapacity *= 2;
        return baseCapacity - this.totalUsedCapacity;
    }

    @Override
    public long getMaximumMemory() {
        long baseCapacity = super.getMaximumMemory();
        baseCapacity -= baseCapacity / 4;
        return baseCapacity - this.totalUsedMemory;
    }

    public void reduceMemoryAndCapacity(Software software) {
        long memoryConsumption = software.getMemoryConsumption();
        long capacityConsumption = software.getCapacityConsumption();
        this.totalUsedMemory += memoryConsumption;
        this.totalUsedCapacity += capacityConsumption;
    }

    public void releaseMemoryAndCapacity(Software software) {
        long memoryConsumption = software.getMemoryConsumption();
        long capacityConsumption = software.getCapacityConsumption();
        this.totalUsedMemory -= memoryConsumption;
        this.totalUsedCapacity -= capacityConsumption;


    }
}
