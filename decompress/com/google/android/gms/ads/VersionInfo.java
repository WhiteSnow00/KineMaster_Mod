// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import java.util.Locale;

public class VersionInfo
{
    protected int a;
    protected int b;
    protected int c;
    
    public VersionInfo(final int a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int a() {
        return this.a;
    }
    
    public int b() {
        return this.c;
    }
    
    public int c() {
        return this.b;
    }
    
    @Override
    public String toString() {
        return String.format(Locale.US, "%d.%d.%d", this.a, this.b, this.c);
    }
}
