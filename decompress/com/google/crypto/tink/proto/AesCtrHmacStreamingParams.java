// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class AesCtrHmacStreamingParams extends GeneratedMessageLite<AesCtrHmacStreamingParams, Builder> implements AesCtrHmacStreamingParamsOrBuilder
{
    public static final int CIPHERTEXT_SEGMENT_SIZE_FIELD_NUMBER = 1;
    private static final AesCtrHmacStreamingParams DEFAULT_INSTANCE;
    public static final int DERIVED_KEY_SIZE_FIELD_NUMBER = 2;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 3;
    public static final int HMAC_PARAMS_FIELD_NUMBER = 4;
    private static volatile Parser<AesCtrHmacStreamingParams> PARSER;
    private int ciphertextSegmentSize_;
    private int derivedKeySize_;
    private int hkdfHashType_;
    private HmacParams hmacParams_;
    
    static {
        GeneratedMessageLite.H(AesCtrHmacStreamingParams.class, DEFAULT_INSTANCE = new AesCtrHmacStreamingParams());
    }
    
    private AesCtrHmacStreamingParams() {
    }
    
    static AesCtrHmacStreamingParams J() {
        return AesCtrHmacStreamingParams.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCtrHmacStreamingParams aesCtrHmacStreamingParams, final int n) {
        aesCtrHmacStreamingParams.U(n);
    }
    
    static void L(final AesCtrHmacStreamingParams aesCtrHmacStreamingParams, final int n) {
        aesCtrHmacStreamingParams.V(n);
    }
    
    static void M(final AesCtrHmacStreamingParams aesCtrHmacStreamingParams, final HashType hashType) {
        aesCtrHmacStreamingParams.W(hashType);
    }
    
    static void N(final AesCtrHmacStreamingParams aesCtrHmacStreamingParams, final HmacParams hmacParams) {
        aesCtrHmacStreamingParams.X(hmacParams);
    }
    
    public static AesCtrHmacStreamingParams P() {
        return AesCtrHmacStreamingParams.DEFAULT_INSTANCE;
    }
    
    public static Builder T() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCtrHmacStreamingParams.DEFAULT_INSTANCE).n();
    }
    
    private void U(final int ciphertextSegmentSize_) {
        this.ciphertextSegmentSize_ = ciphertextSegmentSize_;
    }
    
    private void V(final int derivedKeySize_) {
        this.derivedKeySize_ = derivedKeySize_;
    }
    
    private void W(final HashType hashType) {
        this.hkdfHashType_ = hashType.getNumber();
    }
    
    private void X(final HmacParams hmacParams_) {
        hmacParams_.getClass();
        this.hmacParams_ = hmacParams_;
    }
    
    public int O() {
        return this.ciphertextSegmentSize_;
    }
    
    public int Q() {
        return this.derivedKeySize_;
    }
    
    public HashType R() {
        HashType hashType;
        if ((hashType = HashType.forNumber(this.hkdfHashType_)) == null) {
            hashType = HashType.UNRECOGNIZED;
        }
        return hashType;
    }
    
    public HmacParams S() {
        HmacParams hmacParams;
        if ((hmacParams = this.hmacParams_) == null) {
            hmacParams = HmacParams.M();
        }
        return hmacParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCtrHmacStreamingParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCtrHmacStreamingParams> parser;
                if ((parser = AesCtrHmacStreamingParams.PARSER) == null) {
                    synchronized (AesCtrHmacStreamingParams.class) {
                        if (AesCtrHmacStreamingParams.PARSER == null) {
                            AesCtrHmacStreamingParams.PARSER = new DefaultInstanceBasedParser<AesCtrHmacStreamingParams>(AesCtrHmacStreamingParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCtrHmacStreamingParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCtrHmacStreamingParams.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\f\u0004\t", new Object[] { "ciphertextSegmentSize_", "derivedKeySize_", "hkdfHashType_", "hmacParams_" });
            }
            case 2: {
                return new Builder((AesCtrHmacStreamingParams$a)null);
            }
            case 1: {
                return new AesCtrHmacStreamingParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacStreamingParams, Builder> implements AesCtrHmacStreamingParamsOrBuilder
    {
        private Builder() {
            super(AesCtrHmacStreamingParams.J());
        }
        
        Builder(final AesCtrHmacStreamingParams$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacStreamingParams.K((AesCtrHmacStreamingParams)super.b, n);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacStreamingParams.L((AesCtrHmacStreamingParams)super.b, n);
            return this;
        }
        
        public Builder F(final HashType hashType) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacStreamingParams.M((AesCtrHmacStreamingParams)super.b, hashType);
            return this;
        }
        
        public Builder G(final HmacParams hmacParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacStreamingParams.N((AesCtrHmacStreamingParams)super.b, hmacParams);
            return this;
        }
    }
}
