package enums;

public enum DeliveryFees {
    $15(25,49), $10(50,74), $5(75, Integer.MAX_VALUE );

    private final int minFee;
    private final int maxFee;

    DeliveryFees(int minFee, int maxFee) {
        this.minFee = minFee;
        this.maxFee = maxFee;
    }


    public static DeliveryFees getFee(int fee) {
        DeliveryFees found = $15;
        for (DeliveryFees w : values())
            if (fee >= w.minFee && fee <= w.maxFee)
                found = w;
        return found;
    }
}
