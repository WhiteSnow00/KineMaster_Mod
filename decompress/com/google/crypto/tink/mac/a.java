// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.mac;

import java.util.Iterator;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.util.Arrays;
import com.google.crypto.tink.PrimitiveSet;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Registry;
import java.util.logging.Logger;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.PrimitiveWrapper;

class a implements PrimitiveWrapper<Mac, Mac>
{
    private static final Logger a;
    
    static {
        a = Logger.getLogger(a.class.getName());
    }
    
    static Logger d() {
        return com.google.crypto.tink.mac.a.a;
    }
    
    public static void e() throws GeneralSecurityException {
        Registry.t((PrimitiveWrapper<Object, Object>)new a());
    }
    
    @Override
    public /* bridge */ Object a(final PrimitiveSet set) throws GeneralSecurityException {
        return this.f(set);
    }
    
    @Override
    public Class<Mac> b() {
        return Mac.class;
    }
    
    @Override
    public Class<Mac> c() {
        return Mac.class;
    }
    
    public Mac f(final PrimitiveSet<Mac> set) throws GeneralSecurityException {
        return new b(set, null);
    }
    
    private static class b implements Mac
    {
        private final PrimitiveSet<Mac> a;
        private final byte[] b;
        
        private b(final PrimitiveSet<Mac> a) {
            this.b = new byte[] { 0 };
            this.a = a;
        }
        
        b(final PrimitiveSet set, final a$a object) {
            this(set);
        }
        
        @Override
        public void a(final byte[] array, final byte[] array2) throws GeneralSecurityException {
            Label_0228: {
                if (array.length <= 5) {
                    break Label_0228;
                }
                final byte[] copy = Arrays.copyOf(array, 5);
                final byte[] copyOfRange = Arrays.copyOfRange(array, 5, array.length);
                for (final PrimitiveSet.Entry<Mac> entry : this.a.c(copy)) {
                    try {
                        if (entry.c().equals(OutputPrefixType.LEGACY)) {
                            entry.d().a(copyOfRange, Bytes.a(new byte[][] { array2, this.b }));
                        }
                        else {
                            entry.d().a(copyOfRange, array2);
                        }
                        return;
                    }
                    catch (final GeneralSecurityException ex) {
                        final Logger d = com.google.crypto.tink.mac.a.d();
                        final StringBuilder sb = new StringBuilder();
                        sb.append("tag prefix matches a key, but cannot verify: ");
                        sb.append(ex);
                        d.info(sb.toString());
                        continue;
                    }
                    break;
                }
                final Iterator<PrimitiveSet.Entry<Mac>> iterator2 = this.a.e().iterator();
                while (true) {
                    Label_0218: {
                        if (!iterator2.hasNext()) {
                            break Label_0218;
                        }
                        final PrimitiveSet.Entry<Mac> entry2 = iterator2.next();
                        try {
                            entry2.d().a(array, array2);
                            return;
                            throw new GeneralSecurityException("tag too short");
                            throw new GeneralSecurityException("invalid MAC");
                        }
                        catch (final GeneralSecurityException ex2) {
                            continue;
                        }
                    }
                    break;
                }
            }
        }
        
        @Override
        public byte[] b(final byte[] array) throws GeneralSecurityException {
            if (this.a.b().c().equals(OutputPrefixType.LEGACY)) {
                return Bytes.a(new byte[][] { this.a.b().a(), this.a.b().d().b(Bytes.a(new byte[][] { array, this.b })) });
            }
            return Bytes.a(new byte[][] { this.a.b().a(), this.a.b().d().b(array) });
        }
    }
}
