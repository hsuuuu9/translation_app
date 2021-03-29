import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class communication {
    String inputData = "test";
    public void Comms(String address, String port){
        //make socket
        ServerSocket sSocket = null;
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        System.out.println("#### start connection ####");
        System.out.println("ip -> "+ address + "\n" + "Port -> " + port);

        try{
            //wait connection
            sSocket = new ServerSocket();
            sSocket.bind(new InetSocketAddress(address, Integer.parseInt(port)));
            System.out.println("waiting input...");
            socket = sSocket.accept();

            //make buffer to read data from criant
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            //make buffer to send data from server
            writer = new PrintWriter(socket.getOutputStream(), true);
            
            //read data
            //String inputData = null;
            while(true)
            {
                inputData = reader.readLine();
                System.out.println(inputData);
                if(inputData.equals("exit")) break;
            }
        }catch(BindException e){
            System.out.println("faild binding address"); //address dosen't assigned or port is already in use
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(reader != null) reader.close();
                if(writer != null) writer.close();
                if(socket != null) socket.close();
                if(sSocket != null) sSocket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
