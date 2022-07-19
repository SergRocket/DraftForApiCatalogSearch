package RestApiSetup.MapiPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryMaps {
    @JsonProperty("VC_10000")
    public String VC1;
    @JsonProperty("1083998")
    public String itemOne;
    @JsonProperty("1084013")
    public String itemTwo;
    @JsonProperty("1084035")
    public String itemThree;
    @JsonProperty("1176213")
    public String itemFour;
    @JsonProperty("1187666")
    public String itemFive;
    @JsonProperty("1363884")
    public String itemSix;
    @JsonProperty("1363886")
    public String itemSeven;

    public CategoryMaps(String VC1, String itemOne, String itemTwo, String itemThree,
                       String itemFour, String itemFive, String itemSix, String itemSeven) {
        this.VC1 = VC1;
        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
        this.itemThree = itemThree;
        this.itemFour = itemFour;
        this.itemFive = itemFive;
        this.itemSix = itemSix;
        this.itemSeven = itemSeven;
    }

    public CategoryMaps() {
        super();
    }


    public String getVC1() {
        return VC1;
    }

    public String getItemOne() {
        return itemOne;
    }

    public String getItemTwo() {
        return itemTwo;
    }

    public String getItemThree() {
        return itemThree;
    }

    public String getItemFour() {
        return itemFour;
    }

    public String getItemFive() {
        return itemFive;
    }

    public String getItemSix() {
        return itemSix;
    }

    public String getItemSeven() {
        return itemSeven;
    }
}
