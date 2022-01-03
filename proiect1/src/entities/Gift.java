package entities;

public class Gift {
    private String productName;
    private Double price;
    private String category;

    public static class GiftBuilder {
        private String productName;
        private Double price;
        private String category;

        public GiftBuilder(final String productName, final Double price,
                           final String category) {
            this.productName = productName;
            this.price = price;
            this.category = category;
        }

        public Gift build() {
            return new Gift(this);
        }
    }
    private Gift (GiftBuilder giftBuilder) {
        this.productName = giftBuilder.productName;
        this.price = giftBuilder.price;
        this.category = giftBuilder.category;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
