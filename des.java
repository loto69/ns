import javax.crypto.Cipher; 
import javax.crypto.KeyGenerator; 
import javax.crypto.SecretKey; 
import java.util.Base64; 
import java.util.Scanner; 
class des { 
public static void main(String[] args) throws Exception { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter a message: "); 
String message = sc.nextLine(); 
SecretKey key = KeyGenerator.getInstance("DES").generateKey(); 
Cipher cipher = Cipher.getInstance("DES"); 
cipher.init(Cipher.ENCRYPT_MODE, key); 
String encrypted = 
Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes())); 
System.out.println("Encrypted: " + encrypted); 
cipher.init(Cipher.DECRYPT_MODE, key); 
String decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted))); 
System.out.println("Decrypted: " + decrypted); 
} 
} 
 