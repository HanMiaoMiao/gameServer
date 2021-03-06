// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Message.proto

package com.huyu.protobuf;

public final class MessageProto {
  private MessageProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code MSG}
   */
  public enum MSG
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>Register_Req = 0;</code>
     */
    Register_Req(0),
    /**
     * <code>Login_Req = 1;</code>
     */
    Login_Req(1),
    /**
     * <code>Command_Req = 2;</code>
     */
    Command_Req(2),
    /**
     * <code>Move_Req = 3;</code>
     */
    Move_Req(3),
    /**
     * <code>Aoi_Req = 4;</code>
     */
    Aoi_Req(4),
    /**
     * <code>Attack_Req = 5;</code>
     */
    Attack_Req(5),
    /**
     * <code>Speak_Req = 6;</code>
     */
    Speak_Req(6),
    /**
     * <code>Use_Req = 7;</code>
     */
    Use_Req(7),
    /**
     * <code>View_Req = 8;</code>
     */
    View_Req(8),
    /**
     * <code>Login_Resp = 4097;</code>
     */
    Login_Resp(4097),
    /**
     * <code>Register_Resp = 4098;</code>
     */
    Register_Resp(4098),
    /**
     * <code>Move_Resp = 4099;</code>
     */
    Move_Resp(4099),
    /**
     * <code>Aoi_Resp = 4100;</code>
     */
    Aoi_Resp(4100),
    /**
     * <code>Attack_Resp = 4101;</code>
     */
    Attack_Resp(4101),
    /**
     * <code>Speak_Resp = 4102;</code>
     */
    Speak_Resp(4102),
    /**
     * <code>Use_Resp = 4103;</code>
     */
    Use_Resp(4103),
    /**
     * <code>View_Resp = 4104;</code>
     */
    View_Resp(4104),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>Register_Req = 0;</code>
     */
    public static final int Register_Req_VALUE = 0;
    /**
     * <code>Login_Req = 1;</code>
     */
    public static final int Login_Req_VALUE = 1;
    /**
     * <code>Command_Req = 2;</code>
     */
    public static final int Command_Req_VALUE = 2;
    /**
     * <code>Move_Req = 3;</code>
     */
    public static final int Move_Req_VALUE = 3;
    /**
     * <code>Aoi_Req = 4;</code>
     */
    public static final int Aoi_Req_VALUE = 4;
    /**
     * <code>Attack_Req = 5;</code>
     */
    public static final int Attack_Req_VALUE = 5;
    /**
     * <code>Speak_Req = 6;</code>
     */
    public static final int Speak_Req_VALUE = 6;
    /**
     * <code>Use_Req = 7;</code>
     */
    public static final int Use_Req_VALUE = 7;
    /**
     * <code>View_Req = 8;</code>
     */
    public static final int View_Req_VALUE = 8;
    /**
     * <code>Login_Resp = 4097;</code>
     */
    public static final int Login_Resp_VALUE = 4097;
    /**
     * <code>Register_Resp = 4098;</code>
     */
    public static final int Register_Resp_VALUE = 4098;
    /**
     * <code>Move_Resp = 4099;</code>
     */
    public static final int Move_Resp_VALUE = 4099;
    /**
     * <code>Aoi_Resp = 4100;</code>
     */
    public static final int Aoi_Resp_VALUE = 4100;
    /**
     * <code>Attack_Resp = 4101;</code>
     */
    public static final int Attack_Resp_VALUE = 4101;
    /**
     * <code>Speak_Resp = 4102;</code>
     */
    public static final int Speak_Resp_VALUE = 4102;
    /**
     * <code>Use_Resp = 4103;</code>
     */
    public static final int Use_Resp_VALUE = 4103;
    /**
     * <code>View_Resp = 4104;</code>
     */
    public static final int View_Resp_VALUE = 4104;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @Deprecated
    public static MSG valueOf(int value) {
      return forNumber(value);
    }

    public static MSG forNumber(int value) {
      switch (value) {
        case 0: return Register_Req;
        case 1: return Login_Req;
        case 2: return Command_Req;
        case 3: return Move_Req;
        case 4: return Aoi_Req;
        case 5: return Attack_Req;
        case 6: return Speak_Req;
        case 7: return Use_Req;
        case 8: return View_Req;
        case 4097: return Login_Resp;
        case 4098: return Register_Resp;
        case 4099: return Move_Resp;
        case 4100: return Aoi_Resp;
        case 4101: return Attack_Resp;
        case 4102: return Speak_Resp;
        case 4103: return Use_Resp;
        case 4104: return View_Resp;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<MSG>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        MSG> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<MSG>() {
            public MSG findValueByNumber(int number) {
              return MSG.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return MessageProto.getDescriptor().getEnumTypes().get(0);
    }

    private static final MSG[] VALUES = values();

    public static MSG valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private MSG(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:MSG)
  }

  public interface MessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Message)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.MSG type = 1;</code>
     */
    int getTypeValue();
    /**
     * <code>.MSG type = 1;</code>
     */
    MessageProto.MSG getType();

    /**
     * <code>bytes obj = 2;</code>
     */
    com.google.protobuf.ByteString getObj();

    /**
     * <code>fixed32 seq = 3;</code>
     */
    int getSeq();
  }
  /**
   * Protobuf type {@code Message}
   */
  public  static final class Message extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Message)
      MessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Message.newBuilder() to construct.
    private Message(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Message() {
      type_ = 0;
      obj_ = com.google.protobuf.ByteString.EMPTY;
      seq_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Message(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              int rawValue = input.readEnum();

              type_ = rawValue;
              break;
            }
            case 18: {

              obj_ = input.readBytes();
              break;
            }
            case 29: {

              seq_ = input.readFixed32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MessageProto.internal_static_Message_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MessageProto.internal_static_Message_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MessageProto.Message.class, MessageProto.Message.Builder.class);
    }

    public static final int TYPE_FIELD_NUMBER = 1;
    private int type_;
    /**
     * <code>.MSG type = 1;</code>
     */
    public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.MSG type = 1;</code>
     */
    public MessageProto.MSG getType() {
      MessageProto.MSG result = MessageProto.MSG.valueOf(type_);
      return result == null ? MessageProto.MSG.UNRECOGNIZED : result;
    }

    public static final int OBJ_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString obj_;
    /**
     * <code>bytes obj = 2;</code>
     */
    public com.google.protobuf.ByteString getObj() {
      return obj_;
    }

    public static final int SEQ_FIELD_NUMBER = 3;
    private int seq_;
    /**
     * <code>fixed32 seq = 3;</code>
     */
    public int getSeq() {
      return seq_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (type_ != MessageProto.MSG.Register_Req.getNumber()) {
        output.writeEnum(1, type_);
      }
      if (!obj_.isEmpty()) {
        output.writeBytes(2, obj_);
      }
      if (seq_ != 0) {
        output.writeFixed32(3, seq_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (type_ != MessageProto.MSG.Register_Req.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, type_);
      }
      if (!obj_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, obj_);
      }
      if (seq_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeFixed32Size(3, seq_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof MessageProto.Message)) {
        return super.equals(obj);
      }
      MessageProto.Message other = (MessageProto.Message) obj;

      boolean result = true;
      result = result && type_ == other.type_;
      result = result && getObj()
          .equals(other.getObj());
      result = result && (getSeq()
          == other.getSeq());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
      hash = (37 * hash) + OBJ_FIELD_NUMBER;
      hash = (53 * hash) + getObj().hashCode();
      hash = (37 * hash) + SEQ_FIELD_NUMBER;
      hash = (53 * hash) + getSeq();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static MessageProto.Message parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MessageProto.Message parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MessageProto.Message parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MessageProto.Message parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MessageProto.Message parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MessageProto.Message parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MessageProto.Message parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static MessageProto.Message parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static MessageProto.Message parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static MessageProto.Message parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static MessageProto.Message parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static MessageProto.Message parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(MessageProto.Message prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Message}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Message)
        MessageProto.MessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return MessageProto.internal_static_Message_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return MessageProto.internal_static_Message_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                MessageProto.Message.class, MessageProto.Message.Builder.class);
      }

      // Construct using com.huyu.protobuf.MessageProto.Message.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        type_ = 0;

        obj_ = com.google.protobuf.ByteString.EMPTY;

        seq_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return MessageProto.internal_static_Message_descriptor;
      }

      public MessageProto.Message getDefaultInstanceForType() {
        return MessageProto.Message.getDefaultInstance();
      }

      public MessageProto.Message build() {
        MessageProto.Message result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public MessageProto.Message buildPartial() {
        MessageProto.Message result = new MessageProto.Message(this);
        result.type_ = type_;
        result.obj_ = obj_;
        result.seq_ = seq_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof MessageProto.Message) {
          return mergeFrom((MessageProto.Message)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(MessageProto.Message other) {
        if (other == MessageProto.Message.getDefaultInstance()) return this;
        if (other.type_ != 0) {
          setTypeValue(other.getTypeValue());
        }
        if (other.getObj() != com.google.protobuf.ByteString.EMPTY) {
          setObj(other.getObj());
        }
        if (other.getSeq() != 0) {
          setSeq(other.getSeq());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        MessageProto.Message parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (MessageProto.Message) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int type_ = 0;
      /**
       * <code>.MSG type = 1;</code>
       */
      public int getTypeValue() {
        return type_;
      }
      /**
       * <code>.MSG type = 1;</code>
       */
      public Builder setTypeValue(int value) {
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>.MSG type = 1;</code>
       */
      public MessageProto.MSG getType() {
        MessageProto.MSG result = MessageProto.MSG.valueOf(type_);
        return result == null ? MessageProto.MSG.UNRECOGNIZED : result;
      }
      /**
       * <code>.MSG type = 1;</code>
       */
      public Builder setType(MessageProto.MSG value) {
        if (value == null) {
          throw new NullPointerException();
        }

        type_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>.MSG type = 1;</code>
       */
      public Builder clearType() {

        type_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString obj_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes obj = 2;</code>
       */
      public com.google.protobuf.ByteString getObj() {
        return obj_;
      }
      /**
       * <code>bytes obj = 2;</code>
       */
      public Builder setObj(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }

        obj_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes obj = 2;</code>
       */
      public Builder clearObj() {

        obj_ = getDefaultInstance().getObj();
        onChanged();
        return this;
      }

      private int seq_ ;
      /**
       * <code>fixed32 seq = 3;</code>
       */
      public int getSeq() {
        return seq_;
      }
      /**
       * <code>fixed32 seq = 3;</code>
       */
      public Builder setSeq(int value) {

        seq_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>fixed32 seq = 3;</code>
       */
      public Builder clearSeq() {

        seq_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Message)
    }

    // @@protoc_insertion_point(class_scope:Message)
    private static final MessageProto.Message DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new MessageProto.Message();
    }

    public static MessageProto.Message getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Message>
        PARSER = new com.google.protobuf.AbstractParser<Message>() {
      public Message parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Message(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Message> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Message> getParserForType() {
      return PARSER;
    }

    public MessageProto.Message getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_descriptor;
  private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rMessage.proto\"7\n\007Message\022\022\n\004type\030\001 \001(\016" +
      "2\004.MSG\022\013\n\003obj\030\002 \001(\014\022\013\n\003seq\030\003 \001(\007*\222\002\n\003MSG" +
      "\022\020\n\014Register_Req\020\000\022\r\n\tLogin_Req\020\001\022\017\n\013Com" +
      "mand_Req\020\002\022\014\n\010Move_Req\020\003\022\013\n\007Aoi_Req\020\004\022\016\n" +
      "\nAttack_Req\020\005\022\r\n\tSpeak_Req\020\006\022\013\n\007Use_Req\020" +
      "\007\022\014\n\010View_Req\020\010\022\017\n\nLogin_Resp\020\201 \022\022\n\rRegi" +
      "ster_Resp\020\202 \022\016\n\tMove_Resp\020\203 \022\r\n\010Aoi_Resp" +
      "\020\204 \022\020\n\013Attack_Resp\020\205 \022\017\n\nSpeak_Resp\020\206 \022\r" +
      "\n\010Use_Resp\020\207 \022\016\n\tView_Resp\020\210 B!\n\021com.huy" +
      "u.protobufB\014MessageProtob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_descriptor,
        new String[] { "Type", "Obj", "Seq", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
