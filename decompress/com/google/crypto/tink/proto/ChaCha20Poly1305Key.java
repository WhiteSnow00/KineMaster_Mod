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

public final class ChaCha20Poly1305Key extends GeneratedMessageLite<ChaCha20Poly1305Key, Builder> implements ChaCha20Poly1305KeyOrBuilder
{
    private static final ChaCha20Poly1305Key DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<ChaCha20Poly1305Key> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(ChaCha20Poly1305Key.class, DEFAULT_INSTANCE = new ChaCha20Poly1305Key());
    }
    
    private ChaCha20Poly1305Key() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static ChaCha20Poly1305Key J() {
        return ChaCha20Poly1305Key.DEFAULT_INSTANCE;
    }
    
    static void K(final ChaCha20Poly1305Key chaCha20Poly1305Key, final int n) {
        chaCha20Poly1305Key.R(n);
    }
    
    static void L(final ChaCha20Poly1305Key chaCha20Poly1305Key, final ByteString byteString) {
        chaCha20Poly1305Key.Q(byteString);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)ChaCha20Poly1305Key.DEFAULT_INSTANCE).n();
    }
    
    public static ChaCha20Poly1305Key P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(ChaCha20Poly1305Key.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
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
        switch (ChaCha20Poly1305Key$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<ChaCha20Poly1305Key> parser;
                if ((parser = ChaCha20Poly1305Key.PARSER) == null) {
                    synchronized (ChaCha20Poly1305Key.class) {
                        if (ChaCha20Poly1305Key.PARSER == null) {
                            ChaCha20Poly1305Key.PARSER = new DefaultInstanceBasedParser<ChaCha20Poly1305Key>(ChaCha20Poly1305Key.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return ChaCha20Poly1305Key.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(ChaCha20Poly1305Key.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[] { "version_", "keyValue_" });
            }
            case 2: {
                return new Builder((ChaCha20Poly1305Key$a)null);
            }
            case 1: {
                return new ChaCha20Poly1305Key();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ChaCha20Poly1305Key, Builder> implements ChaCha20Poly1305KeyOrBuilder
    {
        private Builder() {
            super(ChaCha20Poly1305Key.J());
        }
        
        Builder(final ChaCha20Poly1305Key$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            ChaCha20Poly1305Key.L((ChaCha20Poly1305Key)super.b, byteString);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            ChaCha20Poly1305Key.K((ChaCha20Poly1305Key)super.b, n);
            return this;
        }
    }
}
