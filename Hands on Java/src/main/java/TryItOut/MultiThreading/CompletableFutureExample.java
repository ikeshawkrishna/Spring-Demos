package TryItOut.MultiThreading;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
        String pan = "ABCDE1234F";


        // 1. PAN to CIF
        CompletableFuture<String> cifFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return panToCif(pan);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, executor);

        // 2. GST List by PAN
        CompletableFuture<List<String>> gstListFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return getGstListByPan(pan);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, executor);

        // 3. CIF Enquiry (after getting CIF)
        CompletableFuture<String> cifDetailsFuture = cifFuture.thenApplyAsync(cif -> {
            try {
                return getCifDetails(cif);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, executor);

        // 4. All Account Enquiry (after getting CIF)
        CompletableFuture<List<String>> allAccountsFuture = cifFuture.thenApplyAsync(cif -> {
            try {
                return getAllAccounts(cif);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }, executor);

        // 5. Short Account Enquiry (after getting CIF)
        CompletableFuture<List<String>> shortAccountsFuture = cifFuture.thenApplyAsync(cif -> {
            try {
                return getShortAccountSummary(cif);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }, executor);

        // Wait for all to complete
        CompletableFuture.allOf(gstListFuture, cifDetailsFuture, allAccountsFuture, shortAccountsFuture).join();

        // Combine and print results
        System.out.println("CIF: " + cifFuture.get());
        System.out.println("GST List: " + gstListFuture.get());
        System.out.println("CIF Details: " + cifDetailsFuture.get());
        System.out.println("All Accounts: " + allAccountsFuture.get());
        System.out.println("Short Accounts: " + shortAccountsFuture.get());

        executor.shutdown();
    }

    // Dummy API methods — replace these with actual HTTP or DB calls

    public static String panToCif(String pan) throws Exception{
        sleep(500); // Simulate API delay
        return "CIF12345";
    }

    public static List<String> getGstListByPan(String pan) throws Exception{
        sleep(400);
        return List.of("GSTIN001", "GSTIN002");
    }

    public static String getCifDetails(String cif) throws Exception{
        sleep(300);
        return "CustomerName: John Doe, DOB: 1990-01-01";
    }

    public static List<String> getAllAccounts(String cif) throws Exception{
        sleep(600);
        return List.of("SB123", "FD456", "RD789");
    }

    public static List<String> getShortAccountSummary(String cif) throws Exception{
        sleep(200);
        return List.of("SB123 - ₹10,000", "FD456 - ₹50,000");
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
