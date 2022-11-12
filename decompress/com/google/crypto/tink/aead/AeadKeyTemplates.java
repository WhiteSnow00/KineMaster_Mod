// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.aead;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyTemplate;

@Deprecated
public final class AeadKeyTemplates
{
    public static final KeyTemplate a;
    public static final KeyTemplate b;
    public static final KeyTemplate c;
    public static final KeyTemplate d;
    public static final KeyTemplate e;
    public static final KeyTemplate f;
    public static final KeyTemplate g;
    public static final KeyTemplate h;
    
    static {
        a = c(16);
        b = c(32);
        c = b(16, 16);
        d = b(32, 16);
        final HashType sha256 = HashType.SHA256;
        e = a(16, 16, 32, 16, sha256);
        f = a(32, 16, 32, 32, sha256);
        final KeyTemplate.Builder e2 = KeyTemplate.R().E(new ChaCha20Poly1305KeyManager().c());
        final OutputPrefixType tink = OutputPrefixType.TINK;
        g = e2.D(tink).p();
        h = KeyTemplate.R().E(new XChaCha20Poly1305KeyManager().c()).D(tink).p();
    }
    
    public static KeyTemplate a(final int n, final int n2, final int n3, final int n4, final HashType hashType) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<AesCtrHmacAeadKeyFormat, BuilderType>)AesCtrHmacAeadKeyFormat.O().D(((GeneratedMessageLite.Builder<AesCtrKeyFormat, BuilderType>)AesCtrKeyFormat.P().E(((GeneratedMessageLite.Builder<AesCtrParams, BuilderType>)AesCtrParams.N().D(n2)).p()).D(n)).p()).E(((GeneratedMessageLite.Builder<HmacKeyFormat, BuilderType>)HmacKeyFormat.P().E(((GeneratedMessageLite.Builder<HmacParams, BuilderType>)HmacParams.P().D(hashType).E(n4)).p()).D(n3)).p())).p().b()).E(new AesCtrHmacAeadKeyManager().c()).D(OutputPrefixType.TINK)).p();
    }
    
    public static KeyTemplate b(final int n, final int n2) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<AesEaxKeyFormat, BuilderType>)AesEaxKeyFormat.O().D(n).E(((GeneratedMessageLite.Builder<AesEaxParams, BuilderType>)AesEaxParams.N().D(n2)).p())).p().b()).E(new AesEaxKeyManager().c()).D(OutputPrefixType.TINK)).p();
    }
    
    public static KeyTemplate c(final int n) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<AesGcmKeyFormat, BuilderType>)AesGcmKeyFormat.M().D(n)).p().b()).E(new AesGcmKeyManager().c()).D(OutputPrefixType.TINK)).p();
    }
}
