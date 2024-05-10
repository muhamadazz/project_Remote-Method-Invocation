import java.net.*;
import java.util.*;

/**
 * IPFinder
 * 
 * @author Muhamad Fahraz Firdaus
 */
public class IPFinder {
  public static void main(String[] args) {
    String host;
    Scanner input = new Scanner(System.in);
    System.out.print("\n\n Enter hostname: ");
    host = input.next();
    try {
      InetAddress address = InetAddress.getByName(host);
      System.out.println("IP address : " + address.toString());
    } catch (UnknownHostException uhEx) {
      System.out.println("Could not find " + host);
    }
    input.close();
  }
}
