import java.util.*;
public class UseCase9ErrorHandling {
    static final Map<String, Integer> roomPrices = new HashMap<>();
    static {
        roomPrices.put("Standard", 1500);
        roomPrices.put("Deluxe", 2000);
        roomPrices.put("Suite", 3000);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("     Book My Stay - Booking Form");
        System.out.println("========================================");
        String name = getValidName(sc);
        String room = getValidRoomType(sc);
        int nights = getValidNights(sc);
        String checkIn = getValidDate(sc, "Check-in date  (YYYY-MM-DD)");
        String checkOut = getValidDate(sc, "Check-out date (YYYY-MM-DD)");
        System.out.println("\n========================================");
        System.out.println("          Booking Summary");
        System.out.println("========================================");
        System.out.println("Guest Name  : " + name);
        System.out.println("Room Type   : " + room);
        System.out.println("Nights      : " + nights);
        System.out.println("Check-In    : " + checkIn);
        System.out.println("Check-Out   : " + checkOut);
        System.out.println("Total Cost  : Rs. " + (roomPrices.get(room) * nights));
        System.out.println("========================================");
        sc.close();
    }
    static String getValidName(Scanner sc) {
        while (true) {
            System.out.print("Enter guest name: ");
            String n = sc.nextLine().trim();
            if (n.isEmpty()) System.out.println("[ERROR] Name cannot be empty.");
            else if (!n.matches("[a-zA-Z ]+")) System.out.println("[ERROR] Letters and spaces only.");
            else return n;
        }
    }
    static String getValidRoomType(Scanner sc) {
        while (true) {
            System.out.print("Enter room type (Standard/Deluxe/Suite): ");
            String t = sc.nextLine().trim();
            if (roomPrices.containsKey(t)) return t;
            System.out.println("[ERROR] Invalid room type. Choose: Standard, Deluxe, Suite.");
        }
    }
    static int getValidNights(Scanner sc) {
        while (true) {
            System.out.print("Enter number of nights (1-30): ");
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n >= 1 && n <= 30) return n;
                System.out.println("[ERROR] Nights must be between 1 and 30.");
            } catch (NumberFormatException e) { System.out.println("[ERROR] Enter a valid number."); }
        }
    }
    static String getValidDate(Scanner sc, String label) {
        while (true) {
            System.out.print("Enter " + label + ": ");
            String d = sc.nextLine().trim();
            if (d.matches("\\d{4}-\\d{2}-\\d{2}")) return d;
            System.out.println("[ERROR] Use format YYYY-MM-DD.");
        }
    }
}
