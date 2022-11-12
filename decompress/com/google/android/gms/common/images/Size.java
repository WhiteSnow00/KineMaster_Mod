// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.images;

public final class Size
{
    private final int a;
    private final int b;
    
    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o instanceof Size) {
            final Size size = (Size)o;
            if (this.a == size.a && this.b == size.b) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int b = this.b;
        final int a = this.a;
        return b ^ (a >>> 16 | a << 16);
    }
    
    @Override
    public String toString() {
        final int a = this.a;
        final int b = this.b;
        final StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("x");
        sb.append(b);
        return sb.toString();
    }
}
