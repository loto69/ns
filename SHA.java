import java.security.MessageDigest;
import java.util.Scanner;

class SHA {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a message: ");
        String message = scanner.nextLine(); // Fixed variable name

        byte[] digest = MessageDigest.getInstance("SHA-1").digest(message.getBytes());
        StringBuilder hexDigest = new StringBuilder();

        for (byte b : digest) {
            hexDigest.append(String.format("%02x", b));
        }

        System.out.println("SHA-1 Digest: " + hexDigest);
        
        scanner.close(); // Closing Scanner
    }
}
