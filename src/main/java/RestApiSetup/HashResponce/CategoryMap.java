package RestApiSetup.HashResponce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryMap {
    public String VC_10000;
    @JsonProperty("1083998")
    public String itemOne;
    @JsonProperty("1084013")
    public String itemOTwo;
    @JsonProperty("1084035")
    public String item3;
    @JsonProperty("1176213")
    public String item4;
    @JsonProperty("1187666")
    public String item5;
    @JsonProperty("1363884")
    public String item6;
    @JsonProperty("1363886")
    public String item7;
    @JsonProperty("1359091")
    public String item8;
    @JsonProperty("1287511")
    public String item9;
    @JsonProperty("1296056")
    public String item10;
    @JsonProperty("1296062")
    public String item11;
    @JsonProperty("1296063")
    public String item12;

    public CategoryMap(String VC_10000, String itemOne, String itemOTwo, String item3, String item4, String item5, String item6, String item7,
                       String item8, String item9, String item10, String item11, String item12) {
        this.VC_10000 = VC_10000;
        this.itemOne = itemOne;
        this.itemOTwo = itemOTwo;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
        this.item7 = item7;
        this.item8 = item8;
        this.item9 = item9;
        this.item10 = item10;
        this.item11 = item11;
        this.item12 = item12;
    }

    public CategoryMap() {
        super();
    }


    public String getVC_10000() {
        return VC_10000;
    }

    public String getItemOne() {
        return itemOne;
    }

    public String getItemOTwo() {
        return itemOTwo;
    }

    public String getItem3() {
        return item3;
    }

    public String getItem4() {
        return item4;
    }

    public String getItem5() {
        return item5;
    }

    public String getItem6() {
        return item6;
    }

    public String getItem7() {
        return item7;
    }

    public String getItem8() {
        return item8;
    }

    public String getItem9() {
        return item9;
    }

    public String getItem10() {
        return item10;
    }

    public String getItem11() {
        return item11;
    }

    public String getItem12() {
        return item12;
    }
}
