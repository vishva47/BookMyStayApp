import java.util.Scanner;
public class UseCase1HotelBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("     Welcome to Book My Stay App");
        System.out.println("========================================");
        System.out.println("Your one-stop solution for hotel bookings");
        System.out.println("----------------------------------------");
        System.out.print("Enter your name: ");
        String name = sc.nextLine().trim();
        System.out.println("\nHello, " + name + "! We are glad to have you.");
        System.out.println("Let us find the perfect room for your stay.");
        System.out.println("========================================");
        sc.close();
    }
}
