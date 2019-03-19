package com.huyu.netty.protocol;

import java.util.Arrays;

/**
 * 自定义协议
 */
public class MessageProtocol {
    /**
     * 消息头
     */
    private int head_data = ConstantValue.HEAD_DATA;
    /**
     *  消息长度
     */
    private int contentLength;
    /**
     *  handler校验
     */
    private int sign;
    /**
     * 传输的消息
     */
    private byte[] content;

    public MessageProtocol(int contentLength,int sign, byte[] content) {
        this.contentLength = contentLength;
        this.sign = sign;
        this.content = content;
    }

    public int getHead_data() {
        return head_data;
    }

    public void setHead_data(int head_data) {
        this.head_data = head_data;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "MessageProtocol{" +
                "head_data=" + head_data +
                ", contentLength=" + contentLength +
                ", sign=" + sign +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
