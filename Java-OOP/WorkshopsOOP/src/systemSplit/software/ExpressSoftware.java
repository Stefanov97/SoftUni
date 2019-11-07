package systemSplit.software;

public class ExpressSoftware extends Software {
    private static final String TYPE = "Express";

    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, TYPE, capacityConsumption, memoryConsumption);
    }


    @Override
    public long getMemoryConsumption() {
        return super.getMemoryConsumption() * 2;
    }
}
