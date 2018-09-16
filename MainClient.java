// Client side component. Commands are to fired from here only
// MainClient.java

import java.io.*;
import java.net.*;

public class MainClient {

    public static void main(String[] args) throws IOException {

		Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            kkSocket = new Socket("192.168.31.198", 4445);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new
InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("crazy" + e);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection.");
            System.exit(1);
        }
        System.out.println("connection established");
        BufferedReader stdIn = new BufferedReader(new
InputStreamReader(System.in));
        String fromServer;
		String fromUser;
        fromUser = stdIn.readLine();
        while (fromUser !="bye") {
	    if (fromUser != null) {
//                System.out.println("Client: " + fromUser);
                out.println(fromUser);
		fromServer = in.readLine();
		System.out.println("Server Response: "+ fromServer);
		fromServer = null;
		if (fromUser.equals("bye"))
                break;
	    }
        fromUser=null;
        fromUser = stdIn.readLine();
        }

        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
    }
}