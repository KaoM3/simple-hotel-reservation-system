package model.pricemodifier;

import java.util.HashMap;

/**
 * Object representation of date price modifier. Contains a hashmap with Integer keys and Double values
 * wherein the keys are the days in the month, and the values are the price modifiers (in percentage).
 */
public class PriceModifier {
    HashMap<Integer, Double>    datePriceModifier;

    /**
     * Constructor for class PriceModifier. Will instantiate the date price modifier to have keys 1 to 31
     * and starting value of 1.0.
     */
    public PriceModifier() {
        datePriceModifier = new HashMap<Integer, Double>();

        for (int i = 1; i <= 31; i++) {
            datePriceModifier.put(i, 1.0);
        }
    }

    /**
     * Gets the date price modifier hashmap
     * @return datePriceModifier
     */
    public HashMap<Integer, Double> getDatePriceModifier() {
        return datePriceModifier;
    }

    /**
     * Gets the price multiplier associated with {@code date}
     * @param date of the price modifier
     */
    public double getMultiplier(Integer date) {
        return this.datePriceModifier.get(date);
    }
}
