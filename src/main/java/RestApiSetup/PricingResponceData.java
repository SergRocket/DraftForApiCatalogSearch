package RestApiSetup;

import java.util.ArrayList;

public class PricingResponceData {
    public static class PricingItem{
        public String sku;
        public Integer quantity;
        public Double origUnitPrice;
        public Double saleUnitPrice;
        public Double origTotalPrice;
        public Double saleTotalPrice;

        public PricingItem(String sku, Integer quantity,
                           Double origUnitPrice, Double saleUnitPrice, Double origTotalPrice, Double saleTotalPrice) {
            this.sku = sku;
            this.quantity = quantity;
            this.origUnitPrice = origUnitPrice;
            this.saleUnitPrice = saleUnitPrice;
            this.origTotalPrice = origTotalPrice;
            this.saleTotalPrice = saleTotalPrice;
        }

        public PricingItem()
        {
            super();
        }

        public String getSku() {
            return sku;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public Double getOrigUnitPrice() {
            return origUnitPrice;
        }

        public Double getSaleUnitPrice() {
            return saleUnitPrice;
        }

        public Double getOrigTotalPrice() {
            return origTotalPrice;
        }

        public Double getSaleTotalPrice() {
            return saleTotalPrice;
        }
    }

    public class Root{
        public ArrayList<PricingItem> pricingItem;
        public Double origTotalPrice;
        public Double saleTotalPrice;

        public Root(ArrayList<PricingItem> pricingItem, Double origTotalPrice, Double saleTotalPrice) {
            this.pricingItem = pricingItem;
            this.origTotalPrice = origTotalPrice;
            this.saleTotalPrice = saleTotalPrice;
        }
        public Root()
        {
            super();
        }

        public ArrayList<PricingItem> getPricingItem() {
            return pricingItem;
        }

        public Double getOrigTotalPrice() {
            return origTotalPrice;
        }

        public Double getSaleTotalPrice() {
            return saleTotalPrice;
        }
    }

}
