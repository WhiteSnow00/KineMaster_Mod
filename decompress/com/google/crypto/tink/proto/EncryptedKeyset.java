// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.io.InputStream;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class EncryptedKeyset extends GeneratedMessageLite<EncryptedKeyset, Builder> implements EncryptedKeysetOrBuilder
{
    private static final EncryptedKeyset DEFAULT_INSTANCE;
    public static final int ENCRYPTED_KEYSET_FIELD_NUMBER = 2;
    public static final int KEYSET_INFO_FIELD_NUMBER = 3;
    private static volatile Parser<EncryptedKeyset> PARSER;
    private ByteString encryptedKeyset_;
    private KeysetInfo keysetInfo_;
    
    static {
        GeneratedMessageLite.H(EncryptedKeyset.class, DEFAULT_INSTANCE = new EncryptedKeyset());
    }
    
    private EncryptedKeyset() {
        this.encryptedKeyset_ = ByteString.EMPTY;
    }
    
    static EncryptedKeyset J() {
        return EncryptedKeyset.DEFAULT_INSTANCE;
    }
    
    static void K(final EncryptedKeyset encryptedKeyset, final ByteString byteString) {
        encryptedKeyset.R(byteString);
    }
    
    static void L(final EncryptedKeyset encryptedKeyset, final KeysetInfo keysetInfo) {
        encryptedKeyset.S(keysetInfo);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EncryptedKeyset.DEFAULT_INSTANCE).n();
    }
    
    public static EncryptedKeyset P(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.C(EncryptedKeyset.DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }
    
    public static EncryptedKeyset Q(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.D(EncryptedKeyset.DEFAULT_INSTANCE, array, extensionRegistryLite);
    }
    
    private void R(final ByteString encryptedKeyset_) {
        encryptedKeyset_.getClass();
        this.encryptedKeyset_ = encryptedKeyset_;
    }
    
    private void S(final KeysetInfo keysetInfo_) {
        keysetInfo_.getClass();
        this.keysetInfo_ = keysetInfo_;
    }
    
    public ByteString M() {
        return this.encryptedKeyset_;
    }
    
    public KeysetInfo N() {
        KeysetInfo keysetInfo;
        if ((keysetInfo = this.keysetInfo_) == null) {
            keysetInfo = KeysetInfo.O();
        }
        return keysetInfo;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (EncryptedKeyset$a.a[methodToInvoke.ordinal()]) {
            default: {
                throw new UnsupportedOperationException();
            }
            case 7: {
                return null;
            }
            case 6: {
                return 1;
            }
            case 5: {
                final Parser<EncryptedKeyset> parser;
                if ((parser = EncryptedKeyset.PARSER) == null) {
                    synchronized (EncryptedKeyset.class) {
                        if (EncryptedKeyset.PARSER == null) {
                            EncryptedKeyset.PARSER = new DefaultInstanceBasedParser<EncryptedKeyset>(EncryptedKeyset.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EncryptedKeyset.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EncryptedKeyset.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[] { "encryptedKeyset_", "keysetInfo_" });
            }
            case 2: {
                return new Builder((EncryptedKeyset$a)null);
            }
            case 1: {
                return new EncryptedKeyset();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EncryptedKeyset, Builder> implements EncryptedKeysetOrBuilder
    {
        private Builder() {
            super(EncryptedKeyset.J());
        }
        
        Builder(final EncryptedKeyset$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            EncryptedKeyset.K((EncryptedKeyset)super.b, byteString);
            return this;
        }
        
        public Builder E(final KeysetInfo keysetInfo) {
            ((GeneratedMessageLite.Builder)this).u();
            EncryptedKeyset.L((EncryptedKeyset)super.b, keysetInfo);
            return this;
        }
    }
}
