// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.PrimitiveSet;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.PrimitiveWrapper;

class b implements PrimitiveWrapper<HybridEncrypt, HybridEncrypt>
{
    public static void d() throws GeneralSecurityException {
        Registry.t((PrimitiveWrapper<Object, Object>)new b());
    }
    
    @Override
    public /* bridge */ Object a(final PrimitiveSet set) throws GeneralSecurityException {
        return this.e(set);
    }
    
    @Override
    public Class<HybridEncrypt> b() {
        return HybridEncrypt.class;
    }
    
    @Override
    public Class<HybridEncrypt> c() {
        return HybridEncrypt.class;
    }
    
    public HybridEncrypt e(final PrimitiveSet<HybridEncrypt> set) {
        return new a(set);
    }
    
    private static class a implements HybridEncrypt
    {
        final PrimitiveSet<HybridEncrypt> a;
        
        public a(final PrimitiveSet<HybridEncrypt> a) {
            this.a = a;
        }
    }
}
