package com.huyu.netty.protocol;

public class NettyMessage {
    private Header header;
    private Object body;

    public final Header getHeader() {
        return header;
    }

    public final void setHeader(Header header) {
        this.header = header;
    }

    public final void setBody(Object body) {
        this.body = body;
    }

    public final Object getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Header{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
