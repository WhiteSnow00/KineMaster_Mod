// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesGcmKey;
import com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper;

class d implements EciesAeadHkdfDemHelper
{
    private final String a;
    private final int b;
    private AesGcmKey c;
    private AesCtrHmacAeadKey d;
    private int e;
    
    d(final KeyTemplate keyTemplate) throws GeneralSecurityException {
        final String p = keyTemplate.P();
        this.a = p;
        if (p.equals(AeadConfig.b)) {
            try {
                final AesGcmKeyFormat n = AesGcmKeyFormat.N(keyTemplate.Q(), ExtensionRegistryLite.b());
                this.c = (AesGcmKey)Registry.p(keyTemplate);
                this.b = n.L();
                return;
            }
            catch (final InvalidProtocolBufferException ex) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", ex);
            }
        }
        Label_0143: {
            if (!p.equals(AeadConfig.a)) {
                break Label_0143;
            }
            try {
                final AesCtrHmacAeadKeyFormat p2 = AesCtrHmacAeadKeyFormat.P(keyTemplate.Q(), ExtensionRegistryLite.b());
                this.d = (AesCtrHmacAeadKey)Registry.p(keyTemplate);
                this.e = p2.M().N();
                this.b = this.e + p2.N().N();
                return;
            }
            catch (final InvalidProtocolBufferException ex2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", ex2);
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unsupported AEAD DEM key type: ");
        sb.append(p);
        throw new GeneralSecurityException(sb.toString());
    }
}
