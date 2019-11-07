package systemSplit.software;

public abstract class Software {
    private String name;
    private String type;
    private long capacityConsumption;
    private long memoryConsumption;

    protected Software(String name, String type, int capacityConsumption, int memoryConsumption) {
        this.name = name;
        this.type = type;
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public long getCapacityConsumption() {
        return capacityConsumption;
    }

    public long getMemoryConsumption() {
        return memoryConsumption;
    }
}
