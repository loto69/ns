 
import java.security.*; 
import java.util.Base64; 
import java.util.Scanner; 
class digital { 
public static void main(String[] args) throws Exception { 
Scanner scanner = new Scanner(System.in); 
System.out.print("Enter the message: "); 
String message = scanner.nextLine(); 
KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA"); 
keyPairGenerator.initialize(1024); 
KeyPair keyPair = keyPairGenerator.generateKeyPair(); 
Signature signature = Signature.getInstance("SHA256withDSA"); 
signature.initSign(keyPair.getPrivate()); 
signature.update(message.getBytes()); 
byte[] signedMessage = signature.sign(); 
String signatureBase64 = Base64.getEncoder().encodeToString(signedMessage); 
System.out.println("Digital Signature: " + signatureBase64); 
Signature verifier = Signature.getInstance("SHA256withDSA"); 
verifier.initVerify(keyPair.getPublic()); 
verifier.update(message.getBytes()); 
boolean isVerified = verifier.verify(signedMessage); 
System.out.println("Signature verification result: " + isVerified); 
} 
} 