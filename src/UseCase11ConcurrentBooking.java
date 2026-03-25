import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
public class UseCase11ConcurrentBooking {
    static final int TOTAL_ROOMS = 5;
    static AtomicInteger availableRooms = new AtomicInteger(TOTAL_ROOMS);
    static List<String> bookingLog = Collections.synchronizedList(new ArrayList<>());
    static class BookingRequest implements Runnable {
        String guestName;
        BookingRequest(String guestName) { this.guestName = guestName; }
        public void run() {
            System.out.println("[REQUEST] " + guestName + " is trying to book...");
            synchronized (UseCase11ConcurrentBooking.class) {
                if (availableRooms.get() > 0) {
                    availableRooms.decrementAndGet();
                    String id = "BK" + String.format("%03d", bookingLog.size() + 1);
                    bookingLog.add(id + " -> " + guestName);
                    System.out.println("[SUCCESS] " + guestName + " booked. ID: " + id + " | Rooms Left: " + availableRooms.get());
                } else {
                    System.out.println("[FAILED ] No rooms available for " + guestName);
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("========================================");
        System.out.println("  Book My Stay - Concurrent Booking");
        System.out.println("  Total Rooms: " + TOTAL_ROOMS);
        System.out.println("========================================\n");
        String[] guests = {"Arjun","Priya","Ravi","Sneha","Kiran","Meera","Vikram","Ananya","Suresh","Divya"};
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (String g : guests) { exec.submit(new BookingRequest(g)); Thread.sleep(100); }
        exec.shutdown(); exec.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("\n========================================");
        System.out.println("          Final Booking Log");
        System.out.println("========================================");
        for (String log : bookingLog) System.out.println(log);
        System.out.println("Total Booked : " + bookingLog.size() + "/" + TOTAL_ROOMS);
        System.out.println("Rooms Left   : " + availableRooms.get());
        System.out.println("========================================");
    }
}
