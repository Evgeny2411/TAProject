package Application.Entities;

import java.util.Comparator;

public class Medicine implements Comparable<Medicine> {
    private String name;
    private String cost;
    private String index;

    public Medicine(String name, String cost, String index) {
        this.name = name;
        this.cost = cost;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public String getCost() {
        return cost;
    }

    public String getIndex() {
        return index;
    }

    @Override
    public int compareTo(Medicine m) {
        return name.compareTo(m.name);
    }

    public static class MedicineNumberOfDosesComparator implements Comparator<Medicine> {
        @Override
        public int compare(Medicine o1, Medicine o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }

    @Override
    public String toString() {
        return name + ", Цена: " + cost + " грн";
    }
}
