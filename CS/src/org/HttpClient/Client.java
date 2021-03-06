package org.HttpClient;

import org.Handler.*;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
public class Client {
        public void connect(String host, int port) throws Exception {
            EventLoopGroup workerGroup = new NioEventLoopGroup();

            try {
                Bootstrap b = new Bootstrap();
                b.group(workerGroup);
                b.channel(NioSocketChannel.class);
                b.option(ChannelOption.SO_KEEPALIVE, true);
                b.handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new HttpClientIntHandler());
                    }
                });
                // Start the client.
                ChannelFuture f = b.connect(host, port).sync();
                f.channel().closeFuture().sync();
            } finally {
                workerGroup.shutdownGracefully();
            }
        }

        public static void main(String[] args) throws Exception {
//        for(int i=0;i<30;i++){
            Client client = new Client();
            client.connect("127.0.0.1", 8000);
//    }
        }
}
