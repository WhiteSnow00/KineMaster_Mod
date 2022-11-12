// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class XChaCha20Poly1305Key extends GeneratedMessageLite<XChaCha20Poly1305Key, Builder> implements XChaCha20Poly1305KeyOrBuilder
{
    private static final XChaCha20Poly1305Key DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile Parser<XChaCha20Poly1305Key> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(XChaCha20Poly1305Key.class, DEFAULT_INSTANCE = new XChaCha20Poly1305Key());
    }
    
    private XChaCha20Poly1305Key() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static XChaCha20Poly1305Key J() {
        return XChaCha20Poly1305Key.DEFAULT_INSTANCE;
    }
    
    static void K(final XChaCha20Poly1305Key xChaCha20Poly1305Key, final int n) {
        xChaCha20Poly1305Key.R(n);
    }
    
    static void L(final XChaCha20Poly1305Key xChaCha20Poly1305Key, final ByteString byteString) {
        xChaCha20Poly1305Key.Q(byteString);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)XChaCha20Poly1305Key.DEFAULT_INSTANCE).n();
    }
    
    public static XChaCha20Poly1305Key P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(XChaCha20Poly1305Key.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void R(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString M() {
        return this.keyValue_;
    }
    
    public int N() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (XChaCha20Poly1305Key$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<XChaCha20Poly1305Key> parser;
                if ((parser = XChaCha20Poly1305Key.PARSER) == null) {
                    synchronized (XChaCha20Poly1305Key.class) {
                        if (XChaCha20Poly1305Key.PARSER == null) {
                            XChaCha20Poly1305Key.PARSER = new DefaultInstanceBasedParser<XChaCha20Poly1305Key>(XChaCha20Poly1305Key.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return XChaCha20Poly1305Key.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(XChaCha20Poly1305Key.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[] { "version_", "keyValue_" });
            }
            case 2: {
                return new Builder((XChaCha20Poly1305Key$a)null);
            }
            case 1: {
                return new XChaCha20Poly1305Key();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<XChaCha20Poly1305Key, Builder> implements XChaCha20Poly1305KeyOrBuilder
    {
        private Builder() {
            super(XChaCha20Poly1305Key.J());
        }
        
        Builder(final XChaCha20Poly1305Key$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            XChaCha20Poly1305Key.L((XChaCha20Poly1305Key)super.b, byteString);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            XChaCha20Poly1305Key.K((XChaCha20Poly1305Key)super.b, n);
            return this;
        }
    }
}
