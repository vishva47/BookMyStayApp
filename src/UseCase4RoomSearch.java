import java.util.*;
public class UseCase4RoomSearch {
    static class Room {
        int roomNumber;
        String type;
        int pricePerNight;
        boolean isAvailable;
        Room(int roomNumber, String type, int pricePerNight, boolean isAvailable) {
            this.roomNumber = roomNumber;
            this.type = type;
            this.pricePerNight = pricePerNight;
            this.isAvailable = isAvailable;
        }
    }
    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(101, "Standard", 1500, true));
        rooms.add(new Room(102, "Standard", 1500, false));
        rooms.add(new Room(201, "Deluxe", 2000, true));
        rooms.add(new Room(202, "Deluxe", 2000, true));
        rooms.add(new Room(301, "Suite", 3000, false));
        rooms.add(new Room(302, "Suite", 3000, true));
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("  Book My Stay - Room Search");
        System.out.println("========================================");
        System.out.println("1. Standard  2. Deluxe  3. Suite  4. All");
        System.out.print("Choose: ");
        int choice = Integer.parseInt(sc.nextLine().trim());
        String filter;
        switch (choice) {
            case 1: filter = "Standard"; break;
            case 2: filter = "Deluxe"; break;
            case 3: filter = "Suite"; break;
            default: filter = "All"; break;
        }
        System.out.println("\n--- Available Rooms ---");
        System.out.printf("%-10s %-12s %-14s %-10s%n", "Room No", "Type", "Price/Night", "Status");
        System.out.println("----------------------------------------------");
        boolean found = false;
        for (Room r : rooms) {
            if ((filter.equals("All") || r.type.equals(filter)) && r.isAvailable) {
                System.out.printf("%-10d %-12s Rs.%-11d Available%n",
                    r.roomNumber, r.type, r.pricePerNight);
                found = true;
            }
        }
        if (!found) System.out.println("No available rooms found.");
        System.out.println("========================================");
        sc.close();
    }
}
