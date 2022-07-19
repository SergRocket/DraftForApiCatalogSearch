package RestApiSetup.MapiPojo;

public class Brand {
    public String name;
    public String count;

    public Brand(String name, String count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getCount() {
        return count;
    }
}
