// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyTemplate;

@Deprecated
public final class StreamingAeadKeyTemplates
{
    public static final KeyTemplate a;
    public static final KeyTemplate b;
    public static final KeyTemplate c;
    public static final KeyTemplate d;
    public static final KeyTemplate e;
    
    static {
        final HashType sha256 = HashType.SHA256;
        a = a(16, sha256, 16, sha256, 32, 4096);
        b = a(32, sha256, 32, sha256, 32, 4096);
        c = b(16, sha256, 16, 4096);
        d = b(32, sha256, 32, 4096);
        e = b(32, sha256, 32, 1048576);
    }
    
    public static KeyTemplate a(final int n, final HashType hashType, final int n2, final HashType hashType2, final int n3, final int n4) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<AesCtrHmacStreamingKeyFormat, BuilderType>)AesCtrHmacStreamingKeyFormat.O().E(((GeneratedMessageLite.Builder<AesCtrHmacStreamingParams, BuilderType>)AesCtrHmacStreamingParams.T().D(n4).E(n2).F(hashType).G(((GeneratedMessageLite.Builder<HmacParams, BuilderType>)HmacParams.P().D(hashType2).E(n3)).p())).p()).D(n)).p().b()).E(new AesCtrHmacStreamingKeyManager().c()).D(OutputPrefixType.RAW)).p();
    }
    
    public static KeyTemplate b(final int n, final HashType hashType, final int n2, final int n3) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<AesGcmHkdfStreamingKeyFormat, BuilderType>)AesGcmHkdfStreamingKeyFormat.O().D(n).E(((GeneratedMessageLite.Builder<AesGcmHkdfStreamingParams, BuilderType>)AesGcmHkdfStreamingParams.R().D(n3).E(n2).F(hashType)).p())).p().b()).E(new AesGcmHkdfStreamingKeyManager().c()).D(OutputPrefixType.RAW)).p();
    }
}
