import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ClientHandler implements Runnable {
    private static int numConnections;
    private int connectionId = 0;
    private Socket link;
    private PrintWriter out;
    private BufferedReader in;
    private TCPEchoServerThread server; // Reference to the server

    public ClientHandler(Socket s, TCPEchoServerThread server) {
        connectionId = numConnections++;
        System.out.println("Melayani koneksi ke-" + connectionId);
        link = s;
        this.server = server; // Store the reference to the server
    }

    public void run() {
        try {
            out = new PrintWriter(link.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(link.getInputStream()));
            String message = in.readLine();

            while (message != null && !message.equalsIgnoreCase("close")) {
                String formattedMessage = "Client " + connectionId + " [" + new Date() + "]: " + message;
                System.out.println("Message received: " + formattedMessage);
                server.broadcastMessage(message, this);
                message = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public int getConnectionId() {
        return connectionId;
    }

    public void closeConnection() {
        try {
            out.close();
            in.close();
            link.close();
            System.out.println("Connection closed for client #" + connectionId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.PrintWriter;
// import java.net.*;

// class ClientHandler implements Runnable {
//     private static int numConnections;
//     private int connectionId = 0;
//     private Socket link;

//     public ClientHandler(Socket s) {
//         connectionId = numConnections++;
//         System.out.println("Melayani koneksi ke-" + connectionId);
//         link = s;
//     }

//     public void run() {
//         PrintWriter out = null;
//         BufferedReader in = null;
//         int numMessages = 0;

//         try {
//             out = new PrintWriter(link.getOutputStream(), true);
//             in = new BufferedReader(new InputStreamReader(link.getInputStream()));
//             String message = in.readLine();
//             while (!message.equals("close")) {
//                 System.out.println("Message received: [" + message + "] dari client " + connectionId + " dalam " + message.length() + " bytes");
//                 numMessages++;
//                 out.println("Isi Pesan " + numMessages + ": " + message);
//                 message = in.readLine();
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             out.close();
//             try {
//                 in.close();
//                 link.close();
//                 System.out.println("Close connection, #" + connectionId);
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }



