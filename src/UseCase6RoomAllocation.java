import java.util.*;
public class UseCase6RoomAllocation {
    static class Room {
        int roomNumber;
        String type;
        int pricePerNight;
        boolean isAvailable;
        Room(int roomNumber, String type, int pricePerNight) {
            this.roomNumber = roomNumber;
            this.type = type;
            this.pricePerNight = pricePerNight;
            this.isAvailable = true;
        }
    }
    static class Booking {
        String bookingId, guestName;
        Room allocatedRoom;
        int nights, totalCost;
        Booking(String bookingId, String guestName, Room room, int nights) {
            this.bookingId = bookingId;
            this.guestName = guestName;
            this.allocatedRoom = room;
            this.nights = nights;
            this.totalCost = room.pricePerNight * nights;
        }
    }
    static List<Room> rooms = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static int bookingCounter = 1;
    static {
        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));
        rooms.add(new Room(201, "Deluxe", 2000));
        rooms.add(new Room(202, "Deluxe", 2000));
        rooms.add(new Room(301, "Suite", 3000));
    }
    static String allocateRoom(String guestName, String roomType, int nights) {
        for (Room r : rooms) {
            if (r.type.equalsIgnoreCase(roomType) && r.isAvailable) {
                r.isAvailable = false;
                String bookingId = "BK" + String.format("%03d", bookingCounter++);
                bookings.add(new Booking(bookingId, guestName, r, nights));
                return "[CONFIRMED] Booking ID: " + bookingId + " | Room: " + r.roomNumber +
                       " (" + r.type + ") | Nights: " + nights + " | Total: Rs." + (r.pricePerNight * nights);
            }
        }
        return "[FAILED] No available " + roomType + " rooms for " + guestName;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println(" Book My Stay - Reservation & Allocation");
        System.out.println("========================================");
        System.out.print("Guest Name : "); String name = sc.nextLine().trim();
        System.out.print("Room Type (Standard/Deluxe/Suite): "); String type = sc.nextLine().trim();
        System.out.print("Number of Nights: "); int nights = Integer.parseInt(sc.nextLine().trim());
        System.out.println("\n" + allocateRoom(name, type, nights));
        System.out.println("\n--- Current Room Status ---");
        System.out.printf("%-10s %-12s %-14s %-10s%n", "Room No", "Type", "Price/Night", "Status");
        System.out.println("------------------------------------------------");
        for (Room r : rooms) {
            System.out.printf("%-10d %-12s Rs.%-11d %-10s%n",
                r.roomNumber, r.type, r.pricePerNight, r.isAvailable ? "Available" : "Booked");
        }
        System.out.println("========================================");
        sc.close();
    }
}
