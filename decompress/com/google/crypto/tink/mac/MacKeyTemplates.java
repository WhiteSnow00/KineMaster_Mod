// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.mac;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.proto.AesCmacKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyTemplate;

@Deprecated
public final class MacKeyTemplates
{
    public static final KeyTemplate a;
    public static final KeyTemplate b;
    public static final KeyTemplate c;
    public static final KeyTemplate d;
    public static final KeyTemplate e;
    
    static {
        final HashType sha256 = HashType.SHA256;
        a = a(32, 16, sha256);
        b = a(32, 32, sha256);
        final HashType sha257 = HashType.SHA512;
        c = a(64, 32, sha257);
        d = a(64, 64, sha257);
        e = ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<AesCmacKeyFormat, BuilderType>)AesCmacKeyFormat.O().D(32).E(((GeneratedMessageLite.Builder<AesCmacParams, BuilderType>)AesCmacParams.N().D(16)).p())).p().b()).E(new AesCmacKeyManager().c()).D(OutputPrefixType.TINK)).p();
    }
    
    private MacKeyTemplates() {
    }
    
    public static KeyTemplate a(final int n, final int n2, final HashType hashType) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<HmacKeyFormat, BuilderType>)HmacKeyFormat.P().E(((GeneratedMessageLite.Builder<HmacParams, BuilderType>)HmacParams.P().D(hashType).E(n2)).p()).D(n)).p().b()).E(new HmacKeyManager().c()).D(OutputPrefixType.TINK)).p();
    }
}
