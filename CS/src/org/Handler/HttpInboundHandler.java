package org.Handler;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.AcceptHandle.Accept;

/**
 * Created by weicong on 17-8-4.
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter{
    private String jiegu;
    public void channelRead(ChannelHandlerContext ctx,Object msg){

        //读去
        System.out.println(  "++++++++"+ ctx.pipeline().channel());
        System.out.println(ctx);
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        String resultStr = new String(result1);
        System.out.println("Client said:" + resultStr);
        String[] a=resultStr.split("\\|");
        Accept accept =new Accept(a);
        jiegu=accept.LoginRequst();
        //写入
        String response =jiegu ;
        ByteBuf encoded =  ctx.alloc().buffer(response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
//        ByteBuf encoded1 = w.get(1).alloc().buffer(response.length());
//        encoded.writeBytes(response.getBytes());
//        ctx.write(encoded);
//        ctx.flush();
    }
}
