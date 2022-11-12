// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import java.util.Iterator;
import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

public final class KmsClients
{
    private static final CopyOnWriteArrayList<KmsClient> a;
    
    static {
        a = new CopyOnWriteArrayList<KmsClient>();
    }
    
    public static KmsClient a(final String s) throws GeneralSecurityException {
        for (final KmsClient kmsClient : KmsClients.a) {
            if (kmsClient.a(s)) {
                return kmsClient;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("No KMS client does support: ");
        sb.append(s);
        throw new GeneralSecurityException(sb.toString());
    }
}
