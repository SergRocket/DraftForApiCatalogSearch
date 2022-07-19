package RestApiSetup.MapiPojo;

public class ProductTypes {

    public String name;
    public Integer count;

    public ProductTypes(String name, Integer count) {
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
