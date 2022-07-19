package RestApiSetup.MapiPojo;

public class Colors {
    public String name;
    public Integer count;

    public Colors(String name, Integer count) {
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
