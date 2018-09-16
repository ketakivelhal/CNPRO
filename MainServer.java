// To be run at server side and will act as a server
// MainServer.java

import java.net.*;
import java.io.*;

public class MainServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4445);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4445.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

       PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(
		new InputStreamReader(
		clientSocket.getInputStream()));
        String inputLine, outputLine;
        MainProtocol kkp = new MainProtocol();

//        outputLine = kkp.processInput(null);
//        out.println(outputLine);

        while ((inputLine = in.readLine()) != null) {
		if (inputLine.equals("bye"))
                break;
             outputLine = kkp.processInput(inputLine);
             out.println(outputLine);
		 outputLine = null;

        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
