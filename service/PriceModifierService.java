package service;

import model.pricemodifier.*;

/**
 * Contains all the business logic for editing the data inside a {@code PriceModifier}
 * object.
 */
public class PriceModifierService {
    private PriceModifier priceModifier;

    /**
     * Constructor for class PriceModifierService
     * @param priceModifier is the PriceModifier object to be updated
     */
    public PriceModifierService(PriceModifier priceModifier) {
        this.priceModifier = priceModifier;
    }

    /**
     * Updates the HashMap which contains the price modifiers per day
     * @param date is the date to modify
     * @param modifier is the new price modifier for {@code date}
     * @return {@code true} if date can be updated, {@code false} otherwise
     */
    public boolean updateDatePriceModifier(Integer date, Double modifier) {
        
        if(modifier == null) {
            return false;
        }

        if(this.priceModifier.getDatePriceModifier().containsKey(date)) {
            this.priceModifier.getDatePriceModifier().replace(date, modifier);
            return true;
        }
        return false;
    }

    /**
     * Returns an enum object in DiscountCode if it matches the input code
     * @param inputCode is the input code
     * @return DiscountCode object if match can be found, null otherwise
     */
    public DiscountCode getDiscountCode(String inputCode) {
        if(inputCode == null) {
            return null;
        }

        // Check if discount code matches with enum
        for(DiscountCode discountCode : DiscountCode.values()) {
            if(discountCode.name().contentEquals(inputCode)) {
                return discountCode;
            }
        }
        return null;
    }

}
