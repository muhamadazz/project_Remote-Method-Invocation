
/*
MUHAMAD FAHRAZ FIRDAUS
20220040131
*/
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GreetingImpl extends UnicastRemoteObject implements Greeting {
  private String message;

  public GreetingImpl(String message) throws RemoteException {
    this.message = message;
  }

  @Override
  public String getGreetingMessage() throws RemoteException {
    return message;
  }
}
