// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads;

@Deprecated
public final class AdSize
{
    public static final AdSize b;
    public static final AdSize c;
    public static final AdSize d;
    public static final AdSize e;
    public static final AdSize f;
    public static final AdSize g;
    private final com.google.android.gms.ads.AdSize a;
    
    static {
        b = new AdSize(-1, -2, "mb");
        c = new AdSize(320, 50, "mb");
        d = new AdSize(300, 250, "as");
        e = new AdSize(468, 60, "as");
        f = new AdSize(728, 90, "as");
        g = new AdSize(160, 600, "as");
    }
    
    private AdSize(final int n, final int n2, final String s) {
        this(new com.google.android.gms.ads.AdSize(n, n2));
    }
    
    public AdSize(final com.google.android.gms.ads.AdSize a) {
        this.a = a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof AdSize && this.a.equals(((AdSize)o).a);
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
}
