// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

public final class SeekPoint
{
    public static final SeekPoint c;
    public final long a;
    public final long b;
    
    static {
        c = new SeekPoint(0L, 0L);
    }
    
    public SeekPoint(final long a, final long b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && SeekPoint.class == o.getClass()) {
            final SeekPoint seekPoint = (SeekPoint)o;
            if (this.a != seekPoint.a || this.b != seekPoint.b) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (int)this.a * 31 + (int)this.b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[timeUs=");
        sb.append(this.a);
        sb.append(", position=");
        sb.append(this.b);
        sb.append("]");
        return sb.toString();
    }
}
