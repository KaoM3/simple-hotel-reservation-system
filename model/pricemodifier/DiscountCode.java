package model.pricemodifier;


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
            return price - firstDayPrice;
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
