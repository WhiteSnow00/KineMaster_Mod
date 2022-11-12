// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class AesGcmHkdfStreamingParams extends GeneratedMessageLite<AesGcmHkdfStreamingParams, Builder> implements AesGcmHkdfStreamingParamsOrBuilder
{
    public static final int CIPHERTEXT_SEGMENT_SIZE_FIELD_NUMBER = 1;
    private static final AesGcmHkdfStreamingParams DEFAULT_INSTANCE;
    public static final int DERIVED_KEY_SIZE_FIELD_NUMBER = 2;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<AesGcmHkdfStreamingParams> PARSER;
    private int ciphertextSegmentSize_;
    private int derivedKeySize_;
    private int hkdfHashType_;
    
    static {
        GeneratedMessageLite.H(AesGcmHkdfStreamingParams.class, DEFAULT_INSTANCE = new AesGcmHkdfStreamingParams());
    }
    
    private AesGcmHkdfStreamingParams() {
    }
    
    static AesGcmHkdfStreamingParams J() {
        return AesGcmHkdfStreamingParams.DEFAULT_INSTANCE;
    }
    
    static void K(final AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams, final int n) {
        aesGcmHkdfStreamingParams.S(n);
    }
    
    static void L(final AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams, final int n) {
        aesGcmHkdfStreamingParams.T(n);
    }
    
    static void M(final AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams, final HashType hashType) {
        aesGcmHkdfStreamingParams.U(hashType);
    }
    
    public static AesGcmHkdfStreamingParams O() {
        return AesGcmHkdfStreamingParams.DEFAULT_INSTANCE;
    }
    
    public static Builder R() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesGcmHkdfStreamingParams.DEFAULT_INSTANCE).n();
    }
    
    private void S(final int ciphertextSegmentSize_) {
        this.ciphertextSegmentSize_ = ciphertextSegmentSize_;
    }
    
    private void T(final int derivedKeySize_) {
        this.derivedKeySize_ = derivedKeySize_;
    }
    
    private void U(final HashType hashType) {
        this.hkdfHashType_ = hashType.getNumber();
    }
    
    public int N() {
        return this.ciphertextSegmentSize_;
    }
    
    public int P() {
        return this.derivedKeySize_;
    }
    
    public HashType Q() {
        HashType hashType;
        if ((hashType = HashType.forNumber(this.hkdfHashType_)) == null) {
            hashType = HashType.UNRECOGNIZED;
        }
        return hashType;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesGcmHkdfStreamingParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesGcmHkdfStreamingParams> parser;
                if ((parser = AesGcmHkdfStreamingParams.PARSER) == null) {
                    synchronized (AesGcmHkdfStreamingParams.class) {
                        if (AesGcmHkdfStreamingParams.PARSER == null) {
                            AesGcmHkdfStreamingParams.PARSER = new DefaultInstanceBasedParser<AesGcmHkdfStreamingParams>(AesGcmHkdfStreamingParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesGcmHkdfStreamingParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesGcmHkdfStreamingParams.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\f", new Object[] { "ciphertextSegmentSize_", "derivedKeySize_", "hkdfHashType_" });
            }
            case 2: {
                return new Builder((AesGcmHkdfStreamingParams$a)null);
            }
            case 1: {
                return new AesGcmHkdfStreamingParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmHkdfStreamingParams, Builder> implements AesGcmHkdfStreamingParamsOrBuilder
    {
        private Builder() {
            super(AesGcmHkdfStreamingParams.J());
        }
        
        Builder(final AesGcmHkdfStreamingParams$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmHkdfStreamingParams.K((AesGcmHkdfStreamingParams)super.b, n);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmHkdfStreamingParams.L((AesGcmHkdfStreamingParams)super.b, n);
            return this;
        }
        
        public Builder F(final HashType hashType) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmHkdfStreamingParams.M((AesGcmHkdfStreamingParams)super.b, hashType);
            return this;
        }
    }
}
