import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String serverIP = "localhost"; // Change to your server's IP address.
        int serverPort = 12345; // Change to the correct port.

        try {
            Socket clientSocket = new Socket(serverIP, serverPort);

            // Create a thread for receiving and displaying broadcast messages
            Thread receiveThread = new Thread(new ReceiveThread(clientSocket));
            receiveThread.start();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                out.println(userInputLine); // Send messages to the server
            }

            // Close the client socket when done
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ReceiveThread implements Runnable {
        private Socket socket;

        public ReceiveThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String serverMessage;
                while ((serverMessage = in.readLine()) != null) {
                    System.out.println("Received from server: " + serverMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
