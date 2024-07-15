package model.hotel;

import java.util.HashMap;

enum DiscountCode {
    I_WORK_HERE,
    STAY4_GET1,
    PAYDAY
}

public class PriceModifier {
    HashMap<Integer, Double>    datePriceModifier;

    /**
     * Constructor for class PriceModifier
     */
    public PriceModifier() {
        datePriceModifier = new HashMap<Integer, Double>();

        for(int i = 1; i <= 31; i++) {
            datePriceModifier.put(i, 1.0);
        }
    }

    /**
     * Updates the HashMap which contains the price modifiers per day
     * @param date is the date to modify
     * @param modifier is the new price modifier for {@code date}
     */
    public void updateDatePriceModifier(Integer date, Double modifier) {
        datePriceModifier.replace(date, modifier);

        // TODO : Add throw exception for an entry that does not exist
    }

    /**
     * Gets the price modifier associated with {@code date}
     * @param date of the price modifier
     */
    public double getDatePriceModifier(Integer date) {
        return datePriceModifier.get(date);
    }

    /**
     * Gets a valid discount code
     * @return valid discount code
     */
    public double applyDiscountCode() {
        // TODO: Implement getDiscountCode
        double price = 0;
        return price;
    }
}
