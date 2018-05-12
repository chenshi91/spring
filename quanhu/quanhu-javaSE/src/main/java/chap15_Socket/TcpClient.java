/*created by chenshi    at 2018-05-12*/
package chap15_Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.2.200", 9000);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.print("20180512");
        printWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = bufferedReader.readLine();
        System.out.println(line+" from client!");
        bufferedReader.close();
        socket.close();
    }
}
