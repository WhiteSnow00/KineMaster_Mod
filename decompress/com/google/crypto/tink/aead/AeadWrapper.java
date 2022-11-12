// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.aead;

import java.util.Iterator;
import java.util.Arrays;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.PrimitiveSet;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Registry;
import java.util.logging.Logger;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.PrimitiveWrapper;

public class AeadWrapper implements PrimitiveWrapper<Aead, Aead>
{
    private static final Logger a;
    
    static {
        a = Logger.getLogger(AeadWrapper.class.getName());
    }
    
    AeadWrapper() {
    }
    
    static Logger d() {
        return AeadWrapper.a;
    }
    
    public static void e() throws GeneralSecurityException {
        Registry.t((PrimitiveWrapper<Object, Object>)new AeadWrapper());
    }
    
    @Override
    public /* bridge */ Object a(final PrimitiveSet set) throws GeneralSecurityException {
        return this.f(set);
    }
    
    @Override
    public Class<Aead> b() {
        return Aead.class;
    }
    
    @Override
    public Class<Aead> c() {
        return Aead.class;
    }
    
    public Aead f(final PrimitiveSet<Aead> set) throws GeneralSecurityException {
        return new b(set, null);
    }
    
    private static class b implements Aead
    {
        private final PrimitiveSet<Aead> a;
        
        private b(final PrimitiveSet<Aead> a) {
            this.a = a;
        }
        
        b(final PrimitiveSet set, final AeadWrapper$a object) {
            this(set);
        }
        
        @Override
        public byte[] a(final byte[] array, final byte[] array2) throws GeneralSecurityException {
            return Bytes.a(new byte[][] { this.a.b().a(), this.a.b().d().a(array, array2) });
        }
        
        @Override
        public byte[] b(final byte[] array, final byte[] array2) throws GeneralSecurityException {
            if (array.length > 5) {
                final byte[] copyOfRange = Arrays.copyOfRange(array, 0, 5);
                final byte[] copyOfRange2 = Arrays.copyOfRange(array, 5, array.length);
                for (final PrimitiveSet.Entry<Aead> entry : this.a.c(copyOfRange)) {
                    try {
                        return entry.d().b(copyOfRange2, array2);
                    }
                    catch (final GeneralSecurityException ex) {
                        final Logger d = AeadWrapper.d();
                        final StringBuilder sb = new StringBuilder();
                        sb.append("ciphertext prefix matches a key, but cannot decrypt: ");
                        sb.append(ex.toString());
                        d.info(sb.toString());
                        continue;
                    }
                    break;
                }
            }
            final Iterator<PrimitiveSet.Entry<Aead>> iterator2 = this.a.e().iterator();
            while (true) {
                Label_0181: {
                    if (!iterator2.hasNext()) {
                        break Label_0181;
                    }
                    final PrimitiveSet.Entry<Aead> entry2 = iterator2.next();
                    try {
                        return entry2.d().b(array, array2);
                        throw new GeneralSecurityException("decryption failed");
                    }
                    catch (final GeneralSecurityException ex2) {}
                }
            }
        }
    }
}
