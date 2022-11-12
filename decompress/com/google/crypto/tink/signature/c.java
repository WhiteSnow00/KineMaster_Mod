// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import com.google.crypto.tink.PrimitiveSet;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Registry;
import java.util.logging.Logger;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.PrimitiveWrapper;

class c implements PrimitiveWrapper<PublicKeyVerify, PublicKeyVerify>
{
    private static final Logger a;
    
    static {
        a = Logger.getLogger(c.class.getName());
    }
    
    public static void d() throws GeneralSecurityException {
        Registry.t((PrimitiveWrapper<Object, Object>)new c());
    }
    
    @Override
    public /* bridge */ Object a(final PrimitiveSet set) throws GeneralSecurityException {
        return this.e(set);
    }
    
    @Override
    public Class<PublicKeyVerify> b() {
        return PublicKeyVerify.class;
    }
    
    @Override
    public Class<PublicKeyVerify> c() {
        return PublicKeyVerify.class;
    }
    
    public PublicKeyVerify e(final PrimitiveSet<PublicKeyVerify> set) {
        return new a(set);
    }
    
    private static class a implements PublicKeyVerify
    {
        private final PrimitiveSet<PublicKeyVerify> a;
        
        public a(final PrimitiveSet<PublicKeyVerify> a) {
            this.a = a;
        }
    }
}
