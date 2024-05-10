/*
Moh. Jeli Almuta'ali
20220040244
*/
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ProductServer {
    public static void main(String[] args) {
        try {
            

            System.out.println("Starting server...");
            System.out.println("Creating remote objects...");
            ProductImpl p = new ProductImpl("Laptop");
            ProductImpl q = new ProductImpl("Display");
            System.out.println("Binding remote objects to registry...");
            Naming.rebind("//127.0.0.1:1099/Laptop", p);
            Naming.rebind("//127.0.0.1:1099/Display", q);
            System.out.println("Waiting for client call...");
        } catch (RemoteException e) {
            System.err.println("Remote exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
