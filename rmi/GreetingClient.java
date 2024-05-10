
/*
MUHAMAD FAHRAZ FIRDAUS
20220040131
*/
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;

public class GreetingClient {
  public static void main(String[] args) {
    try {
      Greeting a = (Greeting) Naming.lookup("//127.0.0.1:1099/James");
      Greeting b = (Greeting) Naming.lookup("//127.0.0.1:1099/Thomas");
      System.out.println("Well hello, " + a.getGreetingMessage() + "!");
      System.out.println("Hello there, " + b.getGreetingMessage() + "!");

    } catch (NotBoundException e) {
      System.err.println("Object not bound: " + e.getMessage());
    } catch (RemoteException e) {
      System.err.println("Remote exception: " + e.getMessage());
    } catch (MalformedURLException e) {
      System.err.println("Malformed URL: " + e.getMessage());
    }

  }
}
