public class Exercise3 {
    private static final double[] DISCOUNTS = {0, 0.1, 0.3, 0.5};

    public double calculate(double amount, int type, int years) {
        double loyaltyDiscount = Math.min(years, 5) / 100.0;
        double customerDiscount = DISCOUNTS[type - 1];
        return amount * (1 - customerDiscount) * (1 - loyaltyDiscount);
    }
}