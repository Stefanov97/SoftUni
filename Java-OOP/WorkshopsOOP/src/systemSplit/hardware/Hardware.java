package systemSplit.hardware;

import systemSplit.software.Software;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Hardware {
    private String name;
    private String type;
    private long maximumCapacity;
    private long maximumMemory;
    List<Software> softwares;
    private int totalUsedCapacity;
    private int totalUsedMemory;

    protected Hardware(String name, String type, int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.type = type;
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
        this.softwares = new ArrayList<>();
    }

    public long getMaximumCapacity() {
        return this.maximumCapacity;
    }

    public long getMaximumMemory() {
        return this.maximumMemory;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return this.name;
    }

    public List<Software> getSoftwares() {
        return Collections.unmodifiableList(this.softwares);
    }


    public void addSoftwareToGivenComponent(Software software) {
        this.softwares.add(software);
        long memoryConsumption = software.getMemoryConsumption();
        long capacityConsumption = software.getCapacityConsumption();
        this.totalUsedMemory += memoryConsumption;
        this.totalUsedCapacity += capacityConsumption;
    }

    public void releaseSoftware(Software software) {

        this.softwares.remove(software);
        releaseMemoryAndCapacity(software);

    }

    public int getTotalUsedCapacity() {
        return this.totalUsedCapacity;
    }

    public int getTotalUsedMemory() {
        return this.totalUsedMemory;
    }

    private void releaseMemoryAndCapacity(Software software) {
        long memoryConsumption = software.getMemoryConsumption();
        long capacityConsumption = software.getCapacityConsumption();
        this.totalUsedMemory -= memoryConsumption;
        this.totalUsedCapacity -= capacityConsumption;


    }

}
