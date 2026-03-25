import java.util.*;
public class UseCase3InventorySetup {
    static class RoomInventory {
        String roomType;
        int totalRooms;
        int availableRooms;
        int pricePerNight;
        RoomInventory(String roomType, int totalRooms, int pricePerNight) {
            this.roomType = roomType;
            this.totalRooms = totalRooms;
            this.availableRooms = totalRooms;
            this.pricePerNight = pricePerNight;
        }
        void bookRoom() {
            if (availableRooms > 0) availableRooms--;
            else System.out.println("[ERROR] No rooms available for " + roomType);
        }
        void releaseRoom() {
            if (availableRooms < totalRooms) availableRooms++;
            else System.out.println("[INFO] All rooms already available for " + roomType);
        }
        void display() {
            System.out.printf("%-12s Total:%-4d Available:%-4d Booked:%-4d Rs.%d/night%n",
                roomType, totalRooms, availableRooms, (totalRooms - availableRooms), pricePerNight);
        }
    }
    public static void main(String[] args) {
        List<RoomInventory> inventory = new ArrayList<>();
        inventory.add(new RoomInventory("Standard", 5, 1500));
        inventory.add(new RoomInventory("Deluxe", 3, 2000));
        inventory.add(new RoomInventory("Suite", 2, 3000));
        System.out.println("========================================");
        System.out.println("  Book My Stay - Room Inventory");
        System.out.println("========================================");
        for (RoomInventory r : inventory) r.display();
        inventory.get(0).bookRoom();
        inventory.get(1).bookRoom();
        System.out.println("\n--- After Bookings ---");
        for (RoomInventory r : inventory) r.display();
        inventory.get(0).releaseRoom();
        System.out.println("\n--- After Cancellation ---");
        for (RoomInventory r : inventory) r.display();
        System.out.println("========================================");
    }
}
