// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.PrimitiveSet;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Registry;
import java.util.logging.Logger;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.PrimitiveWrapper;

public class HybridDecryptWrapper implements PrimitiveWrapper<HybridDecrypt, HybridDecrypt>
{
    private static final Logger a;
    
    static {
        a = Logger.getLogger(HybridDecryptWrapper.class.getName());
    }
    
    HybridDecryptWrapper() {
    }
    
    public static void d() throws GeneralSecurityException {
        Registry.t((PrimitiveWrapper<Object, Object>)new HybridDecryptWrapper());
    }
    
    @Override
    public /* bridge */ Object a(final PrimitiveSet set) throws GeneralSecurityException {
        return this.e(set);
    }
    
    @Override
    public Class<HybridDecrypt> b() {
        return HybridDecrypt.class;
    }
    
    @Override
    public Class<HybridDecrypt> c() {
        return HybridDecrypt.class;
    }
    
    public HybridDecrypt e(final PrimitiveSet<HybridDecrypt> set) {
        return new a(set);
    }
    
    private static class a implements HybridDecrypt
    {
        private final PrimitiveSet<HybridDecrypt> a;
        
        public a(final PrimitiveSet<HybridDecrypt> a) {
            this.a = a;
        }
    }
}
