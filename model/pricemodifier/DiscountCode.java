package model.pricemodifier;

/**
 * Contains the viable discount codes for the hotel reservation system.
 * <ul>
 * <li><code>I_WORK_HERE</code>
 * Applies a flat 10% discount to the final price.</li>
 * <li><code>STAY4_GET1</code>
 * First day of the reservation is free if it has 5 days or more.</li>
 * <li><code>PAYDAY</code>
 * Applies a flat 7% discount to the final price if it contains day 15 or 30.</li>
 * </ul>
 */
public enum DiscountCode {
    I_WORK_HERE {
        @Override
        public double applyDiscount(int checkIn, int checkOut, double price, double firstDayPrice) {
            return price * 0.90;
        }
    },

    STAY4_GET1 {
        @Override
        public double applyDiscount(int checkIn, int checkOut, double price, double firstDayPrice) {
            if(checkOut - checkIn >= 5) {
                return price - firstDayPrice;
            }
            return price;
        }
    },

    PAYDAY {
        @Override
        public double applyDiscount(int checkIn, int checkOut, double price, double firstDayPrice) {
            if(checkIn <= 15 && 15 < checkOut || checkIn <= 30 && 30 < checkOut) {
                return price * 0.93;
            }
            return price;
        }
    };

    /**
     * Applies the discount codes to a reservation price.
     * @param checkIn is the check in date of the reservation
     * @param checkOut is the check out date of the reservation
     * @param price is the price of the reservation with date price modifiers
     * @param firstDayPrice is the price of the reservation's first day
     * @return the new price of the reservation with discount applied
     */
    public abstract double applyDiscount(int checkIn, int checkOut, double price, double firstDayPrice);
}
