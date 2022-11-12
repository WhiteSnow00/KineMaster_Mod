// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import com.google.crypto.tink.PrimitiveSet;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PrimitiveWrapper;

public class PublicKeySignWrapper implements PrimitiveWrapper<PublicKeySign, PublicKeySign>
{
    PublicKeySignWrapper() {
    }
    
    public static void d() throws GeneralSecurityException {
        Registry.t((PrimitiveWrapper<Object, Object>)new PublicKeySignWrapper());
    }
    
    @Override
    public /* bridge */ Object a(final PrimitiveSet set) throws GeneralSecurityException {
        return this.e(set);
    }
    
    @Override
    public Class<PublicKeySign> b() {
        return PublicKeySign.class;
    }
    
    @Override
    public Class<PublicKeySign> c() {
        return PublicKeySign.class;
    }
    
    public PublicKeySign e(final PrimitiveSet<PublicKeySign> set) {
        return new a(set);
    }
    
    private static class a implements PublicKeySign
    {
        private final PrimitiveSet<PublicKeySign> a;
        
        public a(final PrimitiveSet<PublicKeySign> a) {
            this.a = a;
        }
    }
}
