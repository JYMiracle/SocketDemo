package SocketDemo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception{
        int port = 10011; //设置端口号
        ServerSocket server = new ServerSocket(port);

        //
        System.out.println("服务器可以被访问......");
        Socket socket = server.accept();

        InputStream is = socket.getInputStream();  //输入流read对方传来的消息
        byte[] bytes = new byte[1024];
        int len;
        StringBuffer sb = new StringBuffer();
        while((len = is.read(bytes)) != -1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("客户端说："+sb);
        OutputStream os = socket.getOutputStream();  //输出流write消息 传给对方
        Scanner in = new Scanner(System.in);
        String replyContent = in.nextLine();
        os.write(replyContent.getBytes("UTF-8"));


        is.close();
        os.close();
        socket.close();
        server.close();
    }
}
