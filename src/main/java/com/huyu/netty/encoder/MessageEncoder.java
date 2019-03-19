package com.huyu.netty.encoder;

import com.huyu.netty.protocol.MessageProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 消息解码器
 */
public class MessageEncoder extends MessageToByteEncoder<MessageProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol, ByteBuf byteBuf) throws Exception {
        //System.out.println("encode");
        byteBuf.writeInt(messageProtocol.getHead_data());
        byteBuf.writeInt(messageProtocol.getContentLength());
        byteBuf.writeInt(messageProtocol.getSign());
        byteBuf.writeBytes(messageProtocol.getContent());
    }
}
