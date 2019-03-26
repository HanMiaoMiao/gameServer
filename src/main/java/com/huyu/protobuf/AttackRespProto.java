// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AttackResp.proto

package com.huyu.protobuf;

public final class AttackRespProto {
  private AttackRespProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AttackRespOrBuilder extends
      // @@protoc_insertion_point(interface_extends:AttackResp)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.PlayerResp player = 1;</code>
     */
    boolean hasPlayer();
    /**
     * <code>.PlayerResp player = 1;</code>
     */
    PlayerRespProto.PlayerResp getPlayer();
    /**
     * <code>.PlayerResp player = 1;</code>
     */
    PlayerRespProto.PlayerRespOrBuilder getPlayerOrBuilder();

    /**
     * <code>.MonsterResp monster = 2;</code>
     */
    boolean hasMonster();
    /**
     * <code>.MonsterResp monster = 2;</code>
     */
    MonsterRespProto.MonsterResp getMonster();
    /**
     * <code>.MonsterResp monster = 2;</code>
     */
    MonsterRespProto.MonsterRespOrBuilder getMonsterOrBuilder();
  }
  /**
   * Protobuf type {@code AttackResp}
   */
  public  static final class AttackResp extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:AttackResp)
      AttackRespOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use AttackResp.newBuilder() to construct.
    private AttackResp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AttackResp() {
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private AttackResp(
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
            case 10: {
              PlayerRespProto.PlayerResp.Builder subBuilder = null;
              if (player_ != null) {
                subBuilder = player_.toBuilder();
              }
              player_ = input.readMessage(PlayerRespProto.PlayerResp.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(player_);
                player_ = subBuilder.buildPartial();
              }

              break;
            }
            case 18: {
              MonsterRespProto.MonsterResp.Builder subBuilder = null;
              if (monster_ != null) {
                subBuilder = monster_.toBuilder();
              }
              monster_ = input.readMessage(MonsterRespProto.MonsterResp.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(monster_);
                monster_ = subBuilder.buildPartial();
              }

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
      return AttackRespProto.internal_static_AttackResp_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AttackRespProto.internal_static_AttackResp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AttackRespProto.AttackResp.class, AttackRespProto.AttackResp.Builder.class);
    }

    public static final int PLAYER_FIELD_NUMBER = 1;
    private PlayerRespProto.PlayerResp player_;
    /**
     * <code>.PlayerResp player = 1;</code>
     */
    public boolean hasPlayer() {
      return player_ != null;
    }
    /**
     * <code>.PlayerResp player = 1;</code>
     */
    public PlayerRespProto.PlayerResp getPlayer() {
      return player_ == null ? PlayerRespProto.PlayerResp.getDefaultInstance() : player_;
    }
    /**
     * <code>.PlayerResp player = 1;</code>
     */
    public PlayerRespProto.PlayerRespOrBuilder getPlayerOrBuilder() {
      return getPlayer();
    }

    public static final int MONSTER_FIELD_NUMBER = 2;
    private MonsterRespProto.MonsterResp monster_;
    /**
     * <code>.MonsterResp monster = 2;</code>
     */
    public boolean hasMonster() {
      return monster_ != null;
    }
    /**
     * <code>.MonsterResp monster = 2;</code>
     */
    public MonsterRespProto.MonsterResp getMonster() {
      return monster_ == null ? MonsterRespProto.MonsterResp.getDefaultInstance() : monster_;
    }
    /**
     * <code>.MonsterResp monster = 2;</code>
     */
    public MonsterRespProto.MonsterRespOrBuilder getMonsterOrBuilder() {
      return getMonster();
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
      if (player_ != null) {
        output.writeMessage(1, getPlayer());
      }
      if (monster_ != null) {
        output.writeMessage(2, getMonster());
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (player_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getPlayer());
      }
      if (monster_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getMonster());
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
      if (!(obj instanceof AttackRespProto.AttackResp)) {
        return super.equals(obj);
      }
      AttackRespProto.AttackResp other = (AttackRespProto.AttackResp) obj;

      boolean result = true;
      result = result && (hasPlayer() == other.hasPlayer());
      if (hasPlayer()) {
        result = result && getPlayer()
            .equals(other.getPlayer());
      }
      result = result && (hasMonster() == other.hasMonster());
      if (hasMonster()) {
        result = result && getMonster()
            .equals(other.getMonster());
      }
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
      if (hasPlayer()) {
        hash = (37 * hash) + PLAYER_FIELD_NUMBER;
        hash = (53 * hash) + getPlayer().hashCode();
      }
      if (hasMonster()) {
        hash = (37 * hash) + MONSTER_FIELD_NUMBER;
        hash = (53 * hash) + getMonster().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static AttackRespProto.AttackResp parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AttackRespProto.AttackResp parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AttackRespProto.AttackResp parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AttackRespProto.AttackResp parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AttackRespProto.AttackResp parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AttackRespProto.AttackResp parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AttackRespProto.AttackResp parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AttackRespProto.AttackResp parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static AttackRespProto.AttackResp parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static AttackRespProto.AttackResp parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static AttackRespProto.AttackResp parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AttackRespProto.AttackResp parseFrom(
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
    public static Builder newBuilder(AttackRespProto.AttackResp prototype) {
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
     * Protobuf type {@code AttackResp}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:AttackResp)
        AttackRespProto.AttackRespOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return AttackRespProto.internal_static_AttackResp_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return AttackRespProto.internal_static_AttackResp_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                AttackRespProto.AttackResp.class, AttackRespProto.AttackResp.Builder.class);
      }

      // Construct using com.huyu.protobuf.AttackRespProto.AttackResp.newBuilder()
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
        if (playerBuilder_ == null) {
          player_ = null;
        } else {
          player_ = null;
          playerBuilder_ = null;
        }
        if (monsterBuilder_ == null) {
          monster_ = null;
        } else {
          monster_ = null;
          monsterBuilder_ = null;
        }
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return AttackRespProto.internal_static_AttackResp_descriptor;
      }

      public AttackRespProto.AttackResp getDefaultInstanceForType() {
        return AttackRespProto.AttackResp.getDefaultInstance();
      }

      public AttackRespProto.AttackResp build() {
        AttackRespProto.AttackResp result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public AttackRespProto.AttackResp buildPartial() {
        AttackRespProto.AttackResp result = new AttackRespProto.AttackResp(this);
        if (playerBuilder_ == null) {
          result.player_ = player_;
        } else {
          result.player_ = playerBuilder_.build();
        }
        if (monsterBuilder_ == null) {
          result.monster_ = monster_;
        } else {
          result.monster_ = monsterBuilder_.build();
        }
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
        if (other instanceof AttackRespProto.AttackResp) {
          return mergeFrom((AttackRespProto.AttackResp)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(AttackRespProto.AttackResp other) {
        if (other == AttackRespProto.AttackResp.getDefaultInstance()) return this;
        if (other.hasPlayer()) {
          mergePlayer(other.getPlayer());
        }
        if (other.hasMonster()) {
          mergeMonster(other.getMonster());
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
        AttackRespProto.AttackResp parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (AttackRespProto.AttackResp) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private PlayerRespProto.PlayerResp player_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          PlayerRespProto.PlayerResp, PlayerRespProto.PlayerResp.Builder, PlayerRespProto.PlayerRespOrBuilder> playerBuilder_;
      /**
       * <code>.PlayerResp player = 1;</code>
       */
      public boolean hasPlayer() {
        return playerBuilder_ != null || player_ != null;
      }
      /**
       * <code>.PlayerResp player = 1;</code>
       */
      public PlayerRespProto.PlayerResp getPlayer() {
        if (playerBuilder_ == null) {
          return player_ == null ? PlayerRespProto.PlayerResp.getDefaultInstance() : player_;
        } else {
          return playerBuilder_.getMessage();
        }
      }
      /**
       * <code>.PlayerResp player = 1;</code>
       */
      public Builder setPlayer(PlayerRespProto.PlayerResp value) {
        if (playerBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          player_ = value;
          onChanged();
        } else {
          playerBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.PlayerResp player = 1;</code>
       */
      public Builder setPlayer(
          PlayerRespProto.PlayerResp.Builder builderForValue) {
        if (playerBuilder_ == null) {
          player_ = builderForValue.build();
          onChanged();
        } else {
          playerBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.PlayerResp player = 1;</code>
       */
      public Builder mergePlayer(PlayerRespProto.PlayerResp value) {
        if (playerBuilder_ == null) {
          if (player_ != null) {
            player_ =
              PlayerRespProto.PlayerResp.newBuilder(player_).mergeFrom(value).buildPartial();
          } else {
            player_ = value;
          }
          onChanged();
        } else {
          playerBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.PlayerResp player = 1;</code>
       */
      public Builder clearPlayer() {
        if (playerBuilder_ == null) {
          player_ = null;
          onChanged();
        } else {
          player_ = null;
          playerBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.PlayerResp player = 1;</code>
       */
      public PlayerRespProto.PlayerResp.Builder getPlayerBuilder() {

        onChanged();
        return getPlayerFieldBuilder().getBuilder();
      }
      /**
       * <code>.PlayerResp player = 1;</code>
       */
      public PlayerRespProto.PlayerRespOrBuilder getPlayerOrBuilder() {
        if (playerBuilder_ != null) {
          return playerBuilder_.getMessageOrBuilder();
        } else {
          return player_ == null ?
              PlayerRespProto.PlayerResp.getDefaultInstance() : player_;
        }
      }
      /**
       * <code>.PlayerResp player = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          PlayerRespProto.PlayerResp, PlayerRespProto.PlayerResp.Builder, PlayerRespProto.PlayerRespOrBuilder>
          getPlayerFieldBuilder() {
        if (playerBuilder_ == null) {
          playerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              PlayerRespProto.PlayerResp, PlayerRespProto.PlayerResp.Builder, PlayerRespProto.PlayerRespOrBuilder>(
                  getPlayer(),
                  getParentForChildren(),
                  isClean());
          player_ = null;
        }
        return playerBuilder_;
      }

      private MonsterRespProto.MonsterResp monster_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          MonsterRespProto.MonsterResp, MonsterRespProto.MonsterResp.Builder, MonsterRespProto.MonsterRespOrBuilder> monsterBuilder_;
      /**
       * <code>.MonsterResp monster = 2;</code>
       */
      public boolean hasMonster() {
        return monsterBuilder_ != null || monster_ != null;
      }
      /**
       * <code>.MonsterResp monster = 2;</code>
       */
      public MonsterRespProto.MonsterResp getMonster() {
        if (monsterBuilder_ == null) {
          return monster_ == null ? MonsterRespProto.MonsterResp.getDefaultInstance() : monster_;
        } else {
          return monsterBuilder_.getMessage();
        }
      }
      /**
       * <code>.MonsterResp monster = 2;</code>
       */
      public Builder setMonster(MonsterRespProto.MonsterResp value) {
        if (monsterBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          monster_ = value;
          onChanged();
        } else {
          monsterBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.MonsterResp monster = 2;</code>
       */
      public Builder setMonster(
          MonsterRespProto.MonsterResp.Builder builderForValue) {
        if (monsterBuilder_ == null) {
          monster_ = builderForValue.build();
          onChanged();
        } else {
          monsterBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.MonsterResp monster = 2;</code>
       */
      public Builder mergeMonster(MonsterRespProto.MonsterResp value) {
        if (monsterBuilder_ == null) {
          if (monster_ != null) {
            monster_ =
              MonsterRespProto.MonsterResp.newBuilder(monster_).mergeFrom(value).buildPartial();
          } else {
            monster_ = value;
          }
          onChanged();
        } else {
          monsterBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.MonsterResp monster = 2;</code>
       */
      public Builder clearMonster() {
        if (monsterBuilder_ == null) {
          monster_ = null;
          onChanged();
        } else {
          monster_ = null;
          monsterBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.MonsterResp monster = 2;</code>
       */
      public MonsterRespProto.MonsterResp.Builder getMonsterBuilder() {

        onChanged();
        return getMonsterFieldBuilder().getBuilder();
      }
      /**
       * <code>.MonsterResp monster = 2;</code>
       */
      public MonsterRespProto.MonsterRespOrBuilder getMonsterOrBuilder() {
        if (monsterBuilder_ != null) {
          return monsterBuilder_.getMessageOrBuilder();
        } else {
          return monster_ == null ?
              MonsterRespProto.MonsterResp.getDefaultInstance() : monster_;
        }
      }
      /**
       * <code>.MonsterResp monster = 2;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          MonsterRespProto.MonsterResp, MonsterRespProto.MonsterResp.Builder, MonsterRespProto.MonsterRespOrBuilder>
          getMonsterFieldBuilder() {
        if (monsterBuilder_ == null) {
          monsterBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              MonsterRespProto.MonsterResp, MonsterRespProto.MonsterResp.Builder, MonsterRespProto.MonsterRespOrBuilder>(
                  getMonster(),
                  getParentForChildren(),
                  isClean());
          monster_ = null;
        }
        return monsterBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:AttackResp)
    }

    // @@protoc_insertion_point(class_scope:AttackResp)
    private static final AttackRespProto.AttackResp DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new AttackRespProto.AttackResp();
    }

    public static AttackRespProto.AttackResp getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AttackResp>
        PARSER = new com.google.protobuf.AbstractParser<AttackResp>() {
      public AttackResp parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AttackResp(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AttackResp> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<AttackResp> getParserForType() {
      return PARSER;
    }

    public AttackRespProto.AttackResp getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AttackResp_descriptor;
  private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AttackResp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\020AttackResp.proto\032\020PlayerResp.proto\032\021Mo" +
      "nsterResp.proto\"H\n\nAttackResp\022\033\n\006player\030" +
      "\001 \001(\0132\013.PlayerResp\022\035\n\007monster\030\002 \001(\0132\014.Mo" +
      "nsterRespB$\n\021com.huyu.protobufB\017AttackRe" +
      "spProtob\006proto3"
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
          PlayerRespProto.getDescriptor(),
          MonsterRespProto.getDescriptor(),
        }, assigner);
    internal_static_AttackResp_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_AttackResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AttackResp_descriptor,
        new String[] { "Player", "Monster", });
    PlayerRespProto.getDescriptor();
    MonsterRespProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
