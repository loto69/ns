import java.util.Scanner; 
class hellman { 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter prime number (p): "); 
int p = sc.nextInt(); 
System.out.print("Enter primitive root (g): "); 
int g = sc.nextInt(); 
System.out.print("Enter Alice's private key: "); 
int a = sc.nextInt(); 
System.out.print("Enter Bob's private key: "); 
int b = sc.nextInt(); 
int A = (int) Math.pow(g, a) % p; // Alice's public key 
int B = (int) Math.pow(g, b) % p; // Bob's public key 
int sharedKey = (int) Math.pow(B, a) % p; // Shared key calculated by Alice (or Bob) 
System.out.println("Alice's Public Key: " + A); 
System.out.println("Bob's Public Key: " + B); 
System.out.println("Shared Secret Key: " + sharedKey); 
} 
}