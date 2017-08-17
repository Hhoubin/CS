package org.work;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class SeverThread extends Thread{

    BufferedWriter bw;
    BufferedReader br;
    Server sever;
    List<SeverThread> sts;
    String name;

    public SeverThread(Socket socket, Server sever, List<SeverThread> sts) throws IOException {
        bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.sever=sever;
        this.sts=sts;
        name=br.readLine();


        Vector<String> vector=new Vector<String>();
        vector.add(socket.getInetAddress().toString());
        vector.add(name);

        String format = "hh:mm:ss";
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        String format2 = sdf.format(new Date(System.currentTimeMillis()));
        vector.add(format2);
        sever.addUser(vector);
        sendMessageToAll("系统消息：用户" + name + "已经进入聊天室！");
        sever.ShowMessage("系统消息：用户" + name + "已经进入聊天室！");
    }


    private void sendMessageToAll(String string) {

        for (SeverThread severThread : sts) {
            severThread.sendMessage(string);
        }
    }

    private void sendMessage(String string) {

        try {
            bw.write(string);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    @Override
    public void run() {
        while(true)
        {
            String readLine;
            try {
                readLine = br.readLine();
                String format = "hh:mm:ss";
                SimpleDateFormat sdf=new SimpleDateFormat(format);
                String format2 = sdf.format(new Date(System.currentTimeMillis()));

                sendMessageToAll(name +"("+format2+")");
                sendMessageToAll(readLine);
                sever.ShowMessage(name +"("+format2+")"+readLine);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
