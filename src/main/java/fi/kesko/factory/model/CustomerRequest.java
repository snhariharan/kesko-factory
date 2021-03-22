package fi.kesko.factory.model;

public class CustomerRequest {
    private Integer count;
    private Float barPrice;
    private Float packPrice;
    private Float boxPrice;
    private Integer packSize;
    private Integer boxSize;

    public CustomerRequest() {
    }

    public CustomerRequest(Integer count, Float barPrice, Float packPrice, Float boxPrice, Integer packSize, Integer boxSize) {
        super();
        this.count = count;
        this.barPrice = barPrice;
        this.packPrice = packPrice;
        this.boxPrice = boxPrice;
        this.packSize = packSize;
        this.boxSize = boxSize;
    }

    public Integer getCount() {
        return count;
    }

    public Float getBarPrice() {
        return barPrice;
    }

    public Float getPackPrice() {
        return packPrice;
    }

    public Float getBoxPrice() {
        return boxPrice;
    }

    public Integer getPackSize() {
        return packSize;
    }

    public Integer getBoxSize() {
        return boxSize;
    }
}
