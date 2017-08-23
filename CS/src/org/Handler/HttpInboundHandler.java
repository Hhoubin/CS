package org.Handler;


import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.AcceptHandle.Accept;

/**
 * Created by weicong on 17-8-4.
 */
public class HttpInboundHandler extends SimpleChannelInboundHandler<String> {

    private String Result;
    public void channelRead(ChannelHandlerContext ctx,Object msg){

        //读去
//        System.out.println(  "++++++++"+ ctx.pipeline().channel());
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        String resultStr = new String(result1);
//        System.out.println("Client said:" + resultStr);
        String[] a=resultStr.split("\\|");



        Channel ct= ctx.pipeline().channel();



        Accept accept =new Accept(a, ct);
        Result=accept.loginRequst();




        //写入
        String response =Result ;
        ByteBuf encoded =  ctx.alloc().buffer(response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
//        String response1 =Result ;
//        ByteBuf encoded1 =  ctx.alloc().buffer(response.length());
//        encoded.writeBytes(response.getBytes());
//        ctx.write(encoded);
//        ctx.flush();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, String s) throws Exception {

    }
}
