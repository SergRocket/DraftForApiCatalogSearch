package RestApiSetup.MapiPojo;

public class Styles {

    public String name;
    public Integer count;

    public Styles(String name, Integer count) {
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
