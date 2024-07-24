package model.hotel.room;

public enum RoomType {
    
    STANDARD {
        @Override
        public Room constructRoom(String roomName, double baseRate) {
            return new StandardRoom(roomName, baseRate);
        }
    },

    DELUXE {
        @Override
        public Room constructRoom(String roomName, double baseRate) {
            return new DeluxeRoom(roomName, baseRate);
        }
    },

    EXECUTIVE {
        @Override
        public Room constructRoom(String roomName, double baseRate) {
            return new DeluxeRoom(roomName, baseRate);
        }
    };

    public abstract Room constructRoom(String roomName, double baseRate);
}
