package RestApiSetup.MapiPojo.MapeSearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListOfResources {
    public String sale_price;
    public String price;
    public String title;
    public String pid;

    public String getSale_price() {
        return sale_price;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getPid() {
        return pid;
    }
}
