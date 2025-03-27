import java.security.MessageDigest; 
import java.util.Scanner; 
 
class MD5 { 
public static void main(String[] args) throws Exception { 
Scanner scanner = new Scanner(System.in); 
System.out.print("Enter the message: "); 
String message = scanner.nextLine(); 
 
 
MessageDigest md = MessageDigest.getInstance("MD5"); 
 
 
byte[] digest = md.digest(message.getBytes()); 
 
 
StringBuilder hexString = new StringBuilder(); 
for (byte b : digest) { 
hexString.append(String.format("%02x", b)); 
} 
System.out.println("MD5 Message Digest: " + hexString.toString()); 
} 
}