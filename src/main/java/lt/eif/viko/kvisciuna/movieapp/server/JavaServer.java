package lt.eif.viko.kvisciuna.movieapp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Represents a simple Java server capable of sending files to clients over a network connection.
 * This class provides functionality to start the server on a specified port, accept client connections,
 * and send files to connected clients. It includes methods to handle the server's lifecycle, including
 * starting and stopping the server, as well as sending files to clients. The server utilizes Java's standard
 * I/O classes for communication with clients, such as ServerSocket, Socket, and OutputStream.
 */
public class JavaServer {

        private ServerSocket serverSocket;
        private Socket clientSocket;
        private OutputStream out;
    /**
     * Starts the server on the specified port and sends the specified file to connected clients.
     * This method initializes a ServerSocket on the specified port and waits for client connections.
     * Once a client connects, the specified file is sent to the client. The method then closes the
     * connections and stops the server.
     * @param port The port number to start the server on.
     * @param file The path of the file to send to clients.
     */

        public void start(int port, String file) {
            try {
                serverSocket = new ServerSocket(port);
                clientSocket = serverSocket.accept();


                out = clientSocket.getOutputStream();
                sendFile(file);

                System.out.println("File sent");
            } catch (IOException e) {
                System.out.println("Exception occurred: " + e.getMessage());
            } finally {
                stop();
            }
        }
    /**
     * Sends the specified file to the connected client.
     * This method reads the specified file from the file system and sends its contents to the connected
     * client through the OutputStream. If the file does not exist, an error message is printed.
     * @param filePath The path of the file to send.
     * @throws IOException If an I/O error occurs.
     */
        private void sendFile(String filePath) throws IOException {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                return;
            }

            byte[] bytes = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(bytes, 0, bytes.length);

            out.write(bytes, 0, bytes.length);
            out.flush();
            bis.close();
        }
    /**
     * Stops the server by closing the connections.
     * This method closes the OutputStream, clientSocket, and serverSocket connections.
     * Any exceptions that occur during the closing process are caught and printed to the console.
     */
        public void stop() {
            try {
                out.close();
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }

    }

