package org.work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Client extends JFrame {
    public ClientThraed ct;
    private JTextArea jta;
    public static void main(String[] args) {
        Client client=new Client();
        client.Init();
        client.Dialog();

    }
    private void Dialog() {
        final JDialog jd=new JDialog(this, "登录", true);
        jd.setSize(250, 200);
        jd.setLocationRelativeTo(null);
        jd.setLayout(new FlowLayout());
        JLabel jl1=new JLabel("IP 地址");
        JLabel jl2=new JLabel("端口号");
        JLabel jl3=new JLabel("昵称");

        final JTextField jtf1=new JTextField(15);
        final JTextField jtf2=new JTextField(15);
        final JTextField jtf3=new JTextField(15);
        jtf1.setText("127.0.0.1");
        jtf2.setText("8888");
        jtf3.setText("你好");
        JButton jbt=new JButton("链接");
        jbt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int port=Integer.parseInt(jtf2.getText());
                try {
                    ct=new ClientThraed(jtf1.getText(),port,jtf3.getText(),Client.this);
                    ct.start();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(Client.this, "连接失败");

                }
                jd.dispose();
            }
        });

        jd.add(jl1);
        jd.add(jtf1);
        jd.add(jl2);
        jd.add(jtf2);
        jd.add(jl3);
        jd.add(jtf3);
        jd.add(jbt);

        jd.setVisible(true);
    }
    private void Init() {
        setSize(500, 400);
        jta = new JTextArea(16,36);
        JScrollPane jsp=new JScrollPane(jta);
        final JTextField jtf=new JTextField(28);
        JButton jbt=new JButton("发送");
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ct.sendMessage(jtf.getText());
                    jtf.setText("");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        add(jsp);
        add(jtf);
        add(jbt);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void showMessage(String readLine) {
        jta.append(readLine+"\r\n");
    }
}


