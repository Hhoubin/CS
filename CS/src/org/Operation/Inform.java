package org.Operation;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

import java.util.Observable;

public class Inform {
    public void attach(Observable observable){}
    public void writeandflush(Zoom zoomid) {
        for(String a:zoomid.zoom.keySet()){
            String d= String.valueOf(zoomid.zoom.keySet());
            Channel channel= zoomid.zoom.get(a);
            ByteBuf encoded1 = channel.alloc().buffer(d.length());
            encoded1.writeBytes(d.getBytes());
            channel.write(encoded1);
            channel.flush();
        }
    }
}
