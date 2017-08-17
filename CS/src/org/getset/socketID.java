package org.getset;

import java.nio.channels.Channel;

public class socketID {
    private static Channel[] socket;
    private static int i=0;
    private Channel ctx;

    public Channel getCtx() {
        return ctx;
    }

    public void setCtx(Channel ctx) {
        this.ctx = ctx;

    }
    public static Channel[] getSocket() {
        return socket;
    }

    public static void setSocket(Channel[] socket) {
        socketID.socket = socket;
    }



}
