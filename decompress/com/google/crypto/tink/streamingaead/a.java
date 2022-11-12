// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.streamingaead;

import java.security.GeneralSecurityException;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;

final class a implements StreamingAead
{
    PrimitiveSet<StreamingAead> a;
    
    public a(final PrimitiveSet<StreamingAead> a) throws GeneralSecurityException {
        if (a.b() != null) {
            this.a = a;
            return;
        }
        throw new GeneralSecurityException("Missing primary primitive.");
    }
}
