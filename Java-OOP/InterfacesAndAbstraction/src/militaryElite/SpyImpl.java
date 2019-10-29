package militaryElite;

import militaryElite.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private int codeNumber;

    public SpyImpl(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d", this.getFirstName(), this.getLastName(), this.getId())).append(System.lineSeparator());
        sb.append(String.format("Code Number: %s", this.getCodeNumber()));

        return sb.toString().trim();
    }
}
