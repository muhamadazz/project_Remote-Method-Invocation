/*
Moh. Jeli Almuta'ali
20220040244
*/
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;

public class ProductClient {
    public static void main(String[] args) {
        try {
            Product a = (Product) Naming.lookup("//127.0.0.1:1099/Laptop");
            Product b = (Product) Naming.lookup("//127.0.0.1:1099/Display");
            System.out.println("I am an excellent " + a.getDescription() + ". Buy me!");
            System.out.println("I am an excellent " + b.getDescription() + ". Buy me!");

        } catch (NotBoundException e) {
            System.err.println("Object not bound: " + e.getMessage());
        } catch (RemoteException e) {
            System.err.println("Remote exception: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
        }
        
    }
}
