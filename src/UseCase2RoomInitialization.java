public class UseCase2RoomInitialization {
    enum RoomType {
        STANDARD("Standard Room", 1500, "Single bed, basic amenities"),
        DELUXE("Deluxe Room", 2000, "Double bed, city view, mini bar"),
        SUITE("Suite", 3000, "King bed, living area, premium view");
        String displayName;
        int pricePerNight;
        String description;
        RoomType(String displayName, int pricePerNight, String description) {
            this.displayName = displayName;
            this.pricePerNight = pricePerNight;
            this.description = description;
        }
    }
    static class Room {
        int roomNumber;
        RoomType type;
        boolean isAvailable;
        Room(int roomNumber, RoomType type) {
            this.roomNumber = roomNumber;
            this.type = type;
            this.isAvailable = true;
        }
    }
    public static void main(String[] args) {
        Room[] rooms = {
            new Room(101, RoomType.STANDARD),
            new Room(102, RoomType.STANDARD),
            new Room(201, RoomType.DELUXE),
            new Room(202, RoomType.DELUXE),
            new Room(301, RoomType.SUITE)
        };
        System.out.println("========================================");
        System.out.println("   Book My Stay - Room Availability");
        System.out.println("========================================");
        System.out.printf("%-10s %-15s %-12s %-10s%n", "Room No", "Type", "Price/Night", "Status");
        System.out.println("----------------------------------------------------------");
        for (Room r : rooms) {
            System.out.printf("%-10d %-15s Rs.%-9d %-10s%n",
                r.roomNumber, r.type.displayName,
                r.type.pricePerNight, r.isAvailable ? "Available" : "Booked");
        }
        System.out.println("========================================");
    }
}
