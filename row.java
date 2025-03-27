import java.util.Scanner; 
class row { 
public static void main(String[] args) { 
Scanner scanner = new Scanner(System.in); 
System.out.println("Enter the plain text:"); 
String plaintext = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", ""); 
System.out.println("Enter the rows:"); 
int rows = scanner.nextInt(); 
System.out.println("Enter the columns:"); 
int cols = scanner.nextInt(); 
System.out.println(encrypt(plaintext, rows, cols)); 
} 
public static String encrypt(String text, int rows, int cols) { 
char[][] matrix = new char[rows][cols]; 
int index = 0; 
for (int i = 0; i < rows; i++) 
for (int j = 0; j < cols; j++) 
matrix[i][j] = index < text.length() ? text.charAt(index++) : 'X'; 
StringBuilder ciphertext = new StringBuilder(); 
for (int i = 0; i < rows; i++) 
for (int j = cols - 1; j >= 0; j--) 
ciphertext.append(matrix[i][j]); 
return ciphertext.toString(); 
}}