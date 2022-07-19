package RestApiSetup.MapiPojo;

public class SalePrices {
    public String name;
    public Integer count;

    public SalePrices(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }
}
