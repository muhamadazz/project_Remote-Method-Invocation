import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class TCPEchoServerThread {
    private ServerSocket servSock;
    private static final int PORT = 12345;
    private List<ClientHandler> connectedClients;

    public TCPEchoServerThread() {
        connectedClients = new ArrayList<>();
    }

    public void start() {
        try {
            servSock = new ServerSocket(PORT);
            System.out.println("The server is already running on this computer on port " + PORT);

            while (true) {
                Socket clientSocket = servSock.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, this); // Pass the server reference
                connectedClients.add(clientHandler);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("Close connection....");
                servSock.close();
            } catch (IOException e) {
                System.out.println("Cannot disconnect ");
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : connectedClients) {
            if (client != sender) {
                client.sendMessage("Client " + sender.getConnectionId() + ": " + message);
            }
        }
    }

    public static void main(String[] args) {
        TCPEchoServerThread es = new TCPEchoServerThread();
        es.start();
    }
}


// import java.io.IOException;
// import java.net.ServerSocket;

// public class TCPEchoServerThread {
//     private static ServerSocket servSock;
//     private static final int PORT = 12345;

//     public TCPEchoServerThread() {
//     }

//     public void start() {
//         try {
//             servSock = new ServerSocket(PORT);
//             System.out.println("The server is already running on this computer on the port " + PORT);

//             while (true) {
//                 Thread clientThread = new Thread(new ClientHandler(servSock.accept()));
//                 clientThread.start();
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 System.out.println("Close connection....");
//                 servSock.close();
//             } catch (IOException e) {
//                 System.out.println("Cannot disconnect ");
//                 e.printStackTrace();
//                 System.exit(1);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         TCPEchoServerThread es = new TCPEchoServerThread();
//         es.start();
//     }
// }

