// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

public final class UtcTimingElement
{
    public final String a;
    public final String b;
    
    public UtcTimingElement(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        return sb.toString();
    }
}
