import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class Receive
{
    void receive(){
        ServerSocket sSocket = null;
        Sokert soket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try{
            sSocket = new ServerSocket();
            sSocket.bind(new InetSocketAddress("", 8200));
            System.out.println("Waiting input...");

            socket = sSocket.accept();
            reader = new BufferedReader(new InputStreamReader(soket.getInputStream));
            
        }
    }
    Socket

}