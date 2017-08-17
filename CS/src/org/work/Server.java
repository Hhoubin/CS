package org.work;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Server extends JFrame {
    public static void main(String[] args) {
        Server sever=new Server();
        sever.Init();
    }
    private JButton jbt;
    private JTextField jtf;
    private JTextArea jta;
    private JTable jt;
    private Vector<Vector<String>> vectorData;
    List<SeverThread> sts=new ArrayList<SeverThread>();
    private void add() {
        JLabel jl1=new JLabel("端口号");
        JLabel jl2=new JLabel("在线用户");
        jtf=new JTextField(10);
        jtf.setText("8888");
        jbt=new JButton("服务端");
        //表头
        Vector<String> vector=new Vector<String>();
        vector.add("IP地址");
        vector.add("昵称");
        vector.add("登录时间");
        //数据
        vectorData=new Vector< Vector<String>>();
        jt=new JTable(vectorData, vector);
        JScrollPane jsp=new JScrollPane(jt);
        //聊天面版
        jta=new JTextArea(10,10);
        JScrollPane jsp1=new JScrollPane(jta);
        jl2.setBounds(20,10,60,30);
        add(jl2);
        jl1.setBounds(230,10,60,30);
        add(jl1);
        jtf.setBounds(280, 14,100,20);
        add(jtf);
        jbt.setBounds(400, 14,80,20);
        add(jbt);
        jsp.setBounds(20,50,200, 300);
        add(jsp);
        jsp1.setBounds(250, 50, 200, 300);
        add(jsp1);
    }
    private void addListener() {
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread()
                {
                    public void run() {
                        try {
                            ServerSocket ss=new ServerSocket(Integer.parseInt(jtf.getText()));
                            jbt.setText("关闭服务");
                            while(true)
                            {
                                Socket socket=ss.accept();
                                SeverThread st=new SeverThread(socket, Server.this,sts);
                                sts.add(st);
                                st.start();

                            }
                        } catch (NumberFormatException | IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
    public void addUser(Vector<String> vector) {
        vectorData.add(vector);
        jt.updateUI();
    }
    private void Init() {
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add();
        addListener();
        setVisible(true);
    }
    public void ShowMessage(String string) {
        jta.append(string+"\r\n");
    }
}

