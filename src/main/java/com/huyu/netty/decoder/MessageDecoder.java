package com.huyu.netty.decoder;

import com.huyu.netty.protocol.ConstantValue;
import com.huyu.netty.protocol.MessageProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {
    public  final int BASE_LENGTH = 4 + 4;
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        //System.out.println("decode");
        //可读长度大于基本长度
        //readableBytes()  返回可以读的字节长度
        if(byteBuf.readableBytes() >= BASE_LENGTH){
            //防止客户端传过来的数据过大
            if(byteBuf.readableBytes()>2048){
                byteBuf.skipBytes(byteBuf.readableBytes());
            }
            int beginReader;
            while(true){
                //获取包头开始index
                //readerIndex() 将读（写）索引设置到指定位置
                beginReader = byteBuf.readerIndex();
                //记录包头开始index
                //markReaderIndex() 标记读（写）索引
                byteBuf.markReaderIndex();
                //readInt()　返回当前索引的(无符号) 整型，读索引加4
                if(byteBuf.readInt() == ConstantValue.HEAD_DATA){
                    break;
                }
                //未读到包头，略过一个字节
                //每次略过一个字节去读取，包头信息开始的标志
                //读（写）索引回到mark标记的索引值
                byteBuf.resetReaderIndex();
                //readByte()返回当前索引的(无符号)字节，读索引加一
                byteBuf.readByte();
                //略过后，数据包的长度不满足，等待后面的数据到达
                if(byteBuf.readableBytes()<BASE_LENGTH){
                    return;
                }
            }
            //消息的长度
            int length = byteBuf.readInt();
            int sign = byteBuf.readInt();
            if(byteBuf.readableBytes()<length){
                //还原读指针
                byteBuf.readerIndex(beginReader);
                return;
            }
            byte[] data = new byte[length];
            byteBuf.readBytes(data);
            MessageProtocol messageProtocol = new MessageProtocol(data.length,sign,data);
            list.add(messageProtocol);
        }

    }
}
