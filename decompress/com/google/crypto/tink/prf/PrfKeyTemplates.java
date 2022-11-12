// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.prf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.proto.HmacPrfKeyFormat;
import com.google.crypto.tink.proto.HkdfPrfParams;
import com.google.crypto.tink.proto.HkdfPrfKeyFormat;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.AesCmacPrfKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyTemplate;

@Deprecated
public final class PrfKeyTemplates
{
    public static final KeyTemplate a;
    public static final KeyTemplate b;
    public static final KeyTemplate c;
    public static final KeyTemplate d;
    
    static {
        a = b();
        b = c(32, HashType.SHA256);
        c = c(64, HashType.SHA512);
        d = a();
    }
    
    private PrfKeyTemplates() {
    }
    
    private static KeyTemplate a() {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().E(new AesCmacPrfKeyManager().c()).F(((GeneratedMessageLite.Builder<AesCmacPrfKeyFormat, BuilderType>)AesCmacPrfKeyFormat.M().D(32)).p().b()).D(OutputPrefixType.RAW)).p();
    }
    
    private static KeyTemplate b() {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<HkdfPrfKeyFormat, BuilderType>)HkdfPrfKeyFormat.O().D(32).E(HkdfPrfParams.O().D(HashType.SHA256))).p().b()).E(HkdfPrfKeyManager.p()).D(OutputPrefixType.RAW)).p();
    }
    
    private static KeyTemplate c(final int n, final HashType hashType) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().E(new HmacPrfKeyManager().c()).F(((GeneratedMessageLite.Builder<HmacPrfKeyFormat, BuilderType>)HmacPrfKeyFormat.O().E(((GeneratedMessageLite.Builder<HmacPrfParams, BuilderType>)HmacPrfParams.N().D(hashType)).p()).D(n)).p().b()).D(OutputPrefixType.RAW)).p();
    }
}
