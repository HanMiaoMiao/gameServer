package com.huyu.netty.util;

import io.netty.buffer.ByteBuf;

import java.io.*;

public class ConvertFunction {

    public static byte[] toByte( Object obj) {

//    输出流ByteArrayOutputStream是跟字节进行交互的
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//    输出流ObjectOutputStream是跟对象进行交互的，可以把对象转换为ByteArrayOutputStream输出流
//    ObjectOutputStream objectOutputStream ;
        byte[] bytes = null;

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
//      System.out.println("序列化后的字节数组是：" + bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * @Description     fromByte() Descripition {反序列化对象}
     * @Author:        0262000099 Hengtai Nie
     * @CreateDate     2018/9/6 11:29
     * @Params         序列化后的字节数组bytes
     * @Return         返回对象model
     */
    public static Object fromByte(byte[] bytes) throws ClassNotFoundException {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Object obj = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            objectInputStream.close();
            obj = (Object) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static byte[] bufToByte(ByteBuf byteBuf){
        byte[] msg = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(msg);
        return msg;
    }
/*
    // 主函数测试序列化和反序列化
    public static void main (String[] args) throws ClassNotFoundException {
        Modle model = new Modle();
        model.setName("那个她");
        model.setAge(18);
        System.out.println("序列化前的对象：" + model);
        ConvertFunctionTest test = new ConvertFunctionTest();
        byte[] bytes = test.toByte(model);
        System.out.println("序列化后的字节数组是：" + bytes);

        Modle modelDe = test.fromByte(bytes);
        System.out.println("反序列化后的对象：" + "\n" + "name:" + modelDe.getName() + "\n" + "age:" + modelDe.getAge());
    }
*/
}

