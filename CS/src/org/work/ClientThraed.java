package org.work;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientThraed extends Thread{
    BufferedReader br;
    BufferedWriter bw;
    Client client;
    public ClientThraed(String ip, int port, String name, Client client) throws UnknownHostException, IOException {
        Socket socket=new Socket(ip,port);
        bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.client=client;
    }
    public void sendMessage(String text) throws IOException {
        bw.write(text);
        bw.newLine();
        bw.flush();
    }
    @Override
    public void run() {
        while(true)
        {
            try {
                client.showMessage(br.readLine()+"\r\n");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
