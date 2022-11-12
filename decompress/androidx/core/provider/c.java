// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.provider;

import java.util.Comparator;

public final class c implements Comparator
{
    public static final c a;
    
    static {
        a = new c();
    }
    
    private c() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return d.a((byte[])o, (byte[])o2);
    }
}
