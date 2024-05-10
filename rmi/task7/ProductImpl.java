/*
Moh. Jeli Almuta'ali
20220040244
*/
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProductImpl extends UnicastRemoteObject implements Product {
    private String description;

    public ProductImpl(String description) throws RemoteException {
        this.description = description;
    }

    @Override
    public String getDescription() throws RemoteException {
        return description;
    }
}
