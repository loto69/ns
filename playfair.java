import java.util.*;

class playfair {
    private static char[][] matrix = new char[5][5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key:");
        String key = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        System.out.println("Enter the plaintext:");
        String plaintext = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");

        generateMatrix(key);
        System.out.println("Encrypted message: " + encrypt(plaintext));
    }

    private static void generateMatrix(String key) {
        StringBuilder k = new StringBuilder(key);
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J' && k.indexOf(String.valueOf(c)) == -1)
                k.append(c);
        }
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = k.charAt(idx++);
            }
        }
    }

    private static String encrypt(String text) {
        StringBuilder p = new StringBuilder(), r = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            p.append(text.charAt(i));
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                p.append('X');
            }
        }

        if (p.length() % 2 != 0) p.append('X');

        for (int i = 0; i < p.length(); i += 2) {
            char a = p.charAt(i), b = p.charAt(i + 1);
            int[] p1 = findPos(a), p2 = findPos(b);

            if (p1[0] == p2[0]) {
                r.append(matrix[p1[0]][(p1[1] + 1) % 5]).append(matrix[p2[0]][(p2[1] + 1) % 5]);
            } else if (p1[1] == p2[1]) {
                r.append(matrix[(p1[0] + 1) % 5][p1[1]]).append(matrix[(p2[0] + 1) % 5][p2[1]]);
            } else {
                r.append(matrix[p1[0]][p2[1]]).append(matrix[p2[0]][p1[1]]);
            }
        }

        return r.toString();
    }

    private static int[] findPos(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
