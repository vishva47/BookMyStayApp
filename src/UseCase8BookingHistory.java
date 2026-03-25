import java.util.*;
public class UseCase8BookingHistory {
    static class Booking {
        String bookingId, guestName, roomType, date;
        int nights, totalAmount;
        Booking(String bookingId, String guestName, String roomType, int nights, int totalAmount, String date) {
            this.bookingId = bookingId; this.guestName = guestName;
            this.roomType = roomType; this.nights = nights;
            this.totalAmount = totalAmount; this.date = date;
        }
    }
    public static void main(String[] args) {
        List<Booking> history = new ArrayList<>();
        history.add(new Booking("BK001", "Arjun Kumar", "Deluxe", 2, 4000, "2025-01-10"));
        history.add(new Booking("BK002", "Priya Sharma", "Suite", 3, 9000, "2025-02-14"));
        history.add(new Booking("BK003", "Ravi Patel", "Standard", 1, 1500, "2025-03-05"));
        history.add(new Booking("BK004", "Sneha Roy", "Deluxe", 4, 8000, "2025-03-18"));
        history.add(new Booking("BK005", "Kiran Nair", "Suite", 2, 6000, "2025-04-22"));
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("   Book My Stay - Booking History");
        System.out.println("========================================");
        System.out.println("1. View All Bookings");
        System.out.println("2. Search by Guest Name");
        System.out.println("3. View Summary Report");
        System.out.print("Choose an option: ");
        int choice = Integer.parseInt(sc.nextLine().trim());
        switch (choice) {
            case 1: printAll(history); break;
            case 2:
                System.out.print("Enter guest name: ");
                searchByName(history, sc.nextLine().trim()); break;
            case 3: printSummary(history); break;
            default: System.out.println("Invalid option.");
        }
        sc.close();
    }
    static void printAll(List<Booking> list) {
        System.out.println("\n--- All Bookings ---");
        System.out.printf("%-8s %-15s %-10s %-8s %-12s %-12s%n", "ID", "Guest", "Room", "Nights", "Amount", "Date");
        System.out.println("------------------------------------------------------------------");
        for (Booking b : list)
            System.out.printf("%-8s %-15s %-10s %-8d Rs.%-9d %-12s%n",
                b.bookingId, b.guestName, b.roomType, b.nights, b.totalAmount, b.date);
    }
    static void searchByName(List<Booking> list, String name) {
        System.out.println("\n--- Results for: " + name + " ---");
        boolean found = false;
        for (Booking b : list) {
            if (b.guestName.equalsIgnoreCase(name)) {
                System.out.printf("ID: %s | Room: %s | Nights: %d | Amount: Rs.%d | Date: %s%n",
                    b.bookingId, b.roomType, b.nights, b.totalAmount, b.date);
                found = true;
            }
        }
        if (!found) System.out.println("No bookings found for: " + name);
    }
    static void printSummary(List<Booking> list) {
        int total = 0;
        Map<String, Integer> count = new HashMap<>();
        for (Booking b : list) {
            total += b.totalAmount;
            count.put(b.roomType, count.getOrDefault(b.roomType, 0) + 1);
        }
        System.out.println("\n===== Summary Report =====");
        System.out.println("Total Bookings : " + list.size());
        System.out.println("Total Revenue  : Rs. " + total);
        for (Map.Entry<String, Integer> e : count.entrySet())
            System.out.println("  " + e.getKey() + " : " + e.getValue());
    }
}
