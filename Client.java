package SocketDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        //声明服务端的ip和端口
        String host ="127.0.0.1";
        int port = 10011;

        //建立连接
        Socket socket = new Socket(host,port);
        //获得输出流
        OutputStream os = socket.getOutputStream();
        Scanner in = new Scanner(System.in);
        String inContent = in.nextLine();
        os.write(inContent.getBytes("UTF-8"));
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        byte[] rec = new byte[1024];
        int len;
        StringBuffer sb = new StringBuffer();
        while((len = is.read(rec)) != -1){
            sb.append(new String(rec,0,len,"UTF-8"));
        }
        System.out.println("服务端说："+sb);
        os.close();
        in.close();
        socket.close();
    }
}
