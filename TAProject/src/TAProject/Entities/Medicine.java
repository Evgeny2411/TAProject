package TAProject.Entities;

public class Medicine {
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
}
