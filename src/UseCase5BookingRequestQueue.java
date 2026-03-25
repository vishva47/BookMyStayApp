import java.util.*;
public class UseCase5BookingRequestQueue {
    static class BookingRequest {
        String requestId, guestName, roomType;
        int nights;
        BookingRequest(String requestId, String guestName, String roomType, int nights) {
            this.requestId = requestId;
            this.guestName = guestName;
            this.roomType = roomType;
            this.nights = nights;
        }
    }
    static Map<String, Integer> inventory = new LinkedHashMap<>();
    static Map<String, Integer> roomPrices = new HashMap<>();
    static Queue<BookingRequest> requestQueue = new LinkedList<>();
    static List<String> confirmedBookings = new ArrayList<>();
    static {
        inventory.put("Standard", 2);
        inventory.put("Deluxe", 1);
        inventory.put("Suite", 1);
        roomPrices.put("Standard", 1500);
        roomPrices.put("Deluxe", 2000);
        roomPrices.put("Suite", 3000);
    }
    public static void main(String[] args) {
        requestQueue.add(new BookingRequest("RQ001", "Arjun Kumar", "Deluxe", 2));
        requestQueue.add(new BookingRequest("RQ002", "Priya Sharma", "Standard", 3));
        requestQueue.add(new BookingRequest("RQ003", "Ravi Patel", "Suite", 1));
        requestQueue.add(new BookingRequest("RQ004", "Sneha Roy", "Standard", 2));
        requestQueue.add(new BookingRequest("RQ005", "Kiran Nair", "Deluxe", 4));
        System.out.println("========================================");
        System.out.println(" Book My Stay - Booking Request Queue");
        System.out.println("========================================");
        int counter = 1;
        while (!requestQueue.isEmpty()) {
            BookingRequest req = requestQueue.poll();
            System.out.println("Processing: " + req.requestId + " | " + req.guestName + " | " + req.roomType);
            if (inventory.getOrDefault(req.roomType, 0) > 0) {
                inventory.put(req.roomType, inventory.get(req.roomType) - 1);
                int cost = roomPrices.get(req.roomType) * req.nights;
                String bookingId = "BK" + String.format("%03d", counter++);
                confirmedBookings.add(bookingId + " -> " + req.guestName + " | " + req.roomType + " | Rs." + cost);
                System.out.println("  [CONFIRMED] " + bookingId + " | Total: Rs." + cost);
            } else {
                System.out.println("  [REJECTED] No " + req.roomType + " rooms available.");
            }
        }
        System.out.println("\n===== Confirmed Bookings =====");
        for (String b : confirmedBookings) System.out.println(b);
        System.out.println("\nFinal Inventory:");
        for (Map.Entry<String, Integer> e : inventory.entrySet())
            System.out.println("  " + e.getKey() + " : " + e.getValue() + " remaining");
        System.out.println("========================================");
    }
}
