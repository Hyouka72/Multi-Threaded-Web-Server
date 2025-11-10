import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class MultiServer {

    public Consumer<Socket> getConsumer() throws IOException {
        return (clientSocket) -> {
            try{
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello form the multiServer");
                toClient.close();
                clientSocket.close();
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        };
    }

    public static void main(String[] args) throws IOException {
        int port = 8010;
        MultiServer server = new MultiServer();
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Waiting for client on port " + port);
            while(true){
                Socket acceptedSocket = serverSocket.accept();
                //remotesoucket mean out local ipaddress
                System.out.println("Connection accepted form client"+acceptedSocket.getRemoteSocketAddress());
                Thread thread = new Thread(() ->
                {
                    try {
                        server.getConsumer().accept(acceptedSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                thread.start();

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
