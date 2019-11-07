package systemSplit.software;

public class LightSoftware extends Software {
    private static final String TYPE = "Light";

    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, TYPE, capacityConsumption, memoryConsumption);
    }


    @Override
    public long getMemoryConsumption() {

        long baseConsumption = super.getMemoryConsumption();
        baseConsumption /= 2;
        return baseConsumption;
    }

    @Override
    public long getCapacityConsumption() {
        long baseConsumption = super.getCapacityConsumption();
        baseConsumption += baseConsumption / 2;
        return baseConsumption;
    }
}
