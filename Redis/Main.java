import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import Configuration.Configuration;

public class Main {
    public static void main(String[] args) {
        try {
            Configuration config = new Configuration();
            ServerSocket server = new ServerSocket(config.getPort());
            System.out.println("Redis is running on port: "+config.getPort()+"...");
            while (true) {
                Socket newClient = server.accept();
                
                new HandleClient(newClient).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

class HandleClient extends Thread {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public HandleClient(Socket socket) {
        this.client = socket;
        try {
            this.in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
            this.out = new PrintWriter(this.client.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error setting up client IO: " + e.getMessage());
        }
    }

    public void run() {
        try {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                String cmds = line.trim();
                if (cmds.equals("ping")) {
                    out.print("+PONG\r\n");
                    out.flush();
                } else if(cmds.equals("port")){
                    Configuration cfg = new Configuration();
                    cfg.setPort(4000);
                    out.print("+Restart Server to apply changes\r\n");
                    out.flush();
                } else if(cmds.equals("exit")){
                    out.print("+Connections closed\r\n");
                    out.flush();
                    client.close();
                }else {
                    out.print("-ERR unknown command\r\n");
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Client Disconnected: " + client.getInetAddress());
        } finally {
            try {
                this.client.close();
            } catch (IOException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
