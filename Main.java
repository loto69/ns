import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message to encrypt:");
        String plaintext = scanner.nextLine();
        System.out.println("Enter the shift key (number of positions):");
        int shift = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Encrypted message: " + encrypt(plaintext, shift));
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                result.append(c); // Fixed the misplaced 'else' block
            }
        }
        return result.toString();
    }
}
