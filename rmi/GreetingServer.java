/*
MUHAMAD FAHRAZ FIRDAUS
20220040131
*/

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GreetingServer {
  public static void main(String[] args) {
    try {
      System.out.println("Starting server...");
      System.out.println("Creating remote objects...");
      GreetingImpl p = new GreetingImpl("James");
      GreetingImpl q = new GreetingImpl("Thomas");

      // Create and start the RMI registry on port 1099
      Registry registry = LocateRegistry.createRegistry(1099);

      System.out.println("Binding remote objects to registry...");
      registry.rebind("James", p);
      registry.rebind("Thomas", q);

      System.out.println("Server is ready.");
    } catch (RemoteException e) {
      System.err.println("Remote exception: " + e.getMessage());
    } catch (Exception e) {
      System.err.println("Server error: " + e.getMessage());
    }
  }
}
