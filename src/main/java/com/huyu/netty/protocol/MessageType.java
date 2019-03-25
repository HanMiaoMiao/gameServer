package com.huyu.netty.protocol;

/**
 * handler处理顺序
 */
public class MessageType {
   public static final int Register_Req = 0x00000000;
   public static final int Login_Req = 0x00000001;
   public static final int Command_Req = 0x00000002;
   public static final int Move_Req = 0x00000003;
   public static final int Aoi_Req = 0x00000004;
   public static final int Attack_Req = 0x00000005;
   public static final int Speak_Req = 0x00000006;
   public static final int Use_Req = 0x00000007;
   public static final int View_Req = 0x00000008;

   public static final int Login_Resp = 0x00001001;
   public static final int Register_Resp = 0x00010002;
   public static final int Move_Resp = 0x00001003;
   public static final int Aoi_Resp = 0x00001004;
   public static final int Attack_Resp = 0x00001005;
   public static final int Speak_Resp = 0x00001006;
   public static final int Use_Resp = 0x00001007;
   public static final int View_Resp = 0x00001008;
}
