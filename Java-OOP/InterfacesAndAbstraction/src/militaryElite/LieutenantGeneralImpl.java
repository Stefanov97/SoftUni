package militaryElite;

import militaryElite.interfaces.LieutenantGeneral;
import militaryElite.interfaces.Private;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>(new Comparator<Private>() {
            @Override
            public int compare(Private f, Private s) {
                return s.getId() - f.getId();
            }
        });
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator()).append("Privates:").append(System.lineSeparator());
        for (Private current : this.privates) {

            sb.append("  ").append(current.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
