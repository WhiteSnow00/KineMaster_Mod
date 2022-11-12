// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.EciesAeadDemParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.proto.EcPointFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.KeyTemplate;

@Deprecated
public final class HybridKeyTemplates
{
    private static final byte[] a;
    public static final KeyTemplate b;
    public static final KeyTemplate c;
    public static final KeyTemplate d;
    
    static {
        final byte[] array = a = new byte[0];
        final EllipticCurveType nist_P256 = EllipticCurveType.NIST_P256;
        final HashType sha256 = HashType.SHA256;
        final EcPointFormat uncompressed = EcPointFormat.UNCOMPRESSED;
        final KeyTemplate a2 = AeadKeyTemplates.a;
        final OutputPrefixType tink = OutputPrefixType.TINK;
        b = a(nist_P256, sha256, uncompressed, a2, tink, array);
        c = a(nist_P256, sha256, EcPointFormat.COMPRESSED, a2, OutputPrefixType.RAW, array);
        d = a(nist_P256, sha256, uncompressed, AeadKeyTemplates.e, tink, array);
    }
    
    public static KeyTemplate a(final EllipticCurveType ellipticCurveType, final HashType hashType, final EcPointFormat ecPointFormat, final KeyTemplate keyTemplate, final OutputPrefixType outputPrefixType, final byte[] array) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().E(new EciesAeadHkdfPrivateKeyManager().c()).D(outputPrefixType).F(((GeneratedMessageLite.Builder<EciesAeadHkdfKeyFormat, BuilderType>)EciesAeadHkdfKeyFormat.M().D(b(ellipticCurveType, hashType, ecPointFormat, keyTemplate, array))).p().b())).p();
    }
    
    public static EciesAeadHkdfParams b(final EllipticCurveType ellipticCurveType, final HashType hashType, final EcPointFormat ecPointFormat, final KeyTemplate keyTemplate, final byte[] array) {
        return ((GeneratedMessageLite.Builder<EciesAeadHkdfParams, BuilderType>)EciesAeadHkdfParams.R().F(((GeneratedMessageLite.Builder<EciesHkdfKemParams, BuilderType>)EciesHkdfKemParams.R().D(ellipticCurveType).E(hashType).F(ByteString.copyFrom(array))).p()).D(((GeneratedMessageLite.Builder<EciesAeadDemParams, BuilderType>)EciesAeadDemParams.N().D(keyTemplate)).p()).E(ecPointFormat)).p();
    }
}
