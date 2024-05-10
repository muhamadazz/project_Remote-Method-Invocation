
/*
MUHAMAD FAHRAZ FIRDAUS
20220040131
*/
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Greeting extends Remote {
  String getGreetingMessage() throws RemoteException;
}
