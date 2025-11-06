package SingleThreaded;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() throws IOException {
        int port = 0010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000); //10sec timer
        while(true){
            try{
                System.out.println("Server is Listening on port " + port);
                Socket acceptedConnection = socket.accept();
                //remotesoucket mean out local ipaddress
                System.out.println("Connection accepted form client"+acceptedConnection.getRemoteSocketAddress());
               //sending data send from server to client
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader (new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello From the Server");
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Server server = new Server();
        try{
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
