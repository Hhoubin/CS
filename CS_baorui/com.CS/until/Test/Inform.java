package until.Test;

import io.netty.buffer.ByteBuf;

import io.netty.channel.Channel;

public class Inform {

public void writeandflush(Channel [] coomChannel) {
    int a = 0;
    for (int i = 0; i < coomChannel.length; i++) {
        if (null != coomChannel[i])
            a++;
    }
    for (int i = 0; i <= a; i++) {
        String bbb = "xxx进来了！";
        ByteBuf encoded1 = coomChannel[i].alloc().buffer(bbb.length());
        encoded1.writeBytes(bbb.getBytes());
        coomChannel[i].write(encoded1);
        coomChannel[i].flush();
    }
}


}
