public class MarketGood {
    private String name; // 상품의 이름
    private int retailPrice; // 상품의 출시 가격
    private int discountRate; // 상품의 할인율(단위 : %)

    public MarketGood(String name, int retailPrice, int discountRate){
        this.name = name;
        this.retailPrice = retailPrice;
        if (discountRate < 0 || discountRate > 100)
            this.discountRate = 0;
        else
            this.discountRate = discountRate;
    }
    public MarketGood(String name, int retailPrice){
        this(name, retailPrice, 0);
    }

    // name, retailPrice, discountRate의 getter 메소드
    public String getName(){
        return name;
    }
    public int getRetailPrice(){
        return retailPrice;
    }
    public int getDiscountRate(){
        return discountRate;
    }
    // discountRate는 변할 수 있으므로 setter 메소드도 만듦
    void setDiscountRate(int discountRate){
        this.discountRate = discountRate;
    }
    public int getDiscountedPrice(){
        return retailPrice * (100 - discountRate) / 100;
    }
}

