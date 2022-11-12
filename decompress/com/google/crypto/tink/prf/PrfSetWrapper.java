// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.prf;

import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.util.HashMap;
import java.util.Map;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.PrimitiveSet;
import com.google.errorprone.annotations.Immutable;
import com.google.crypto.tink.PrimitiveWrapper;

@Immutable
public class PrfSetWrapper implements PrimitiveWrapper<Prf, PrfSet>
{
    @Override
    public /* bridge */ Object a(final PrimitiveSet set) throws GeneralSecurityException {
        return this.d(set);
    }
    
    @Override
    public Class<Prf> b() {
        return Prf.class;
    }
    
    @Override
    public Class<PrfSet> c() {
        return PrfSet.class;
    }
    
    public PrfSet d(final PrimitiveSet<Prf> set) throws GeneralSecurityException {
        return new b(set, null);
    }
    
    private static class b extends PrfSet
    {
        private final Map<Integer, Prf> a;
        private final int b;
        
        private b(final PrimitiveSet<Prf> set) throws GeneralSecurityException {
            if (set.e().isEmpty()) {
                throw new GeneralSecurityException("No primitives provided.");
            }
            if (set.b() != null) {
                this.b = set.b().b();
                final List<PrimitiveSet.Entry<Prf>> e = set.e();
                final HashMap hashMap = new HashMap();
                for (final PrimitiveSet.Entry entry : e) {
                    if (!entry.c().equals(OutputPrefixType.RAW)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Key ");
                        sb.append(entry.b());
                        sb.append(" has non raw prefix type");
                        throw new GeneralSecurityException(sb.toString());
                    }
                    hashMap.put(entry.b(), entry.d());
                }
                this.a = (Map<Integer, Prf>)Collections.unmodifiableMap((Map<?, ?>)hashMap);
                return;
            }
            throw new GeneralSecurityException("Primary key not set.");
        }
        
        b(final PrimitiveSet set, final PrfSetWrapper$a object) throws GeneralSecurityException {
            this(set);
        }
    }
}
