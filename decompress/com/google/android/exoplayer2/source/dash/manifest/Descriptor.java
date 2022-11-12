// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;

public final class Descriptor
{
    public final String a;
    public final String b;
    public final String c;
    
    public Descriptor(final String a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && Descriptor.class == o.getClass()) {
            final Descriptor descriptor = (Descriptor)o;
            if (!Util.c(this.a, descriptor.a) || !Util.c(this.b, descriptor.b) || !Util.c(this.c, descriptor.c)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final String b = this.b;
        int hashCode2 = 0;
        int hashCode3;
        if (b != null) {
            hashCode3 = b.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String c = this.c;
        if (c != null) {
            hashCode2 = c.hashCode();
        }
        return (hashCode * 31 + hashCode3) * 31 + hashCode2;
    }
}
