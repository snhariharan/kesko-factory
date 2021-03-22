package fi.kesko.factory.model;

public class CheapestCombination {
    private Integer boxCount;
    private Integer packCount;
    private Integer barCount;
    private Float totalPrice;

    public CheapestCombination() {
    }

    public CheapestCombination(Integer boxCount, Integer packCount, Integer barCount, Float totalPrice) {
        this.boxCount = boxCount;
        this.packCount = packCount;
        this.barCount = barCount;
        this.totalPrice = totalPrice;
    }

    public Integer getBoxCount() {
        return boxCount;
    }

    public Integer getPackCount() {
        return packCount;
    }

    public Integer getBarCount() {
        return barCount;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "CheapestCombination{" +
                "boxCount=" + boxCount +
                ", packCount=" + packCount +
                ", barCount=" + barCount +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
