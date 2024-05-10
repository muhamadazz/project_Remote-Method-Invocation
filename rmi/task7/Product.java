/*
Moh. Jeli Almuta'ali
20220040244
*/
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Product extends Remote {
    String getDescription() throws RemoteException;
}
