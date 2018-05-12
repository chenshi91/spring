/*created by chenshi    at 2018-05-12*/
package chap15_Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void  main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String readLine = bufferedReader.readLine();

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.print(readLine+" from server!");
        printWriter.flush();

        socket.close();
    }
}
