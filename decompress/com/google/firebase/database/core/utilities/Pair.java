// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

public final class Pair<T, U>
{
    private final T a;
    private final U b;
    
    public Pair(final T a, final U b) {
        this.a = a;
        this.b = b;
    }
    
    public T a() {
        return this.a;
    }
    
    public U b() {
        return this.b;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && Pair.class == o.getClass()) {
            final Pair pair = (Pair)o;
            o = this.a;
            Label_0060: {
                if (o != null) {
                    if (o.equals(pair.a)) {
                        break Label_0060;
                    }
                }
                else if (pair.a == null) {
                    break Label_0060;
                }
                return false;
            }
            o = this.b;
            final U b = pair.b;
            if (o != null) {
                if (o.equals(b)) {
                    return true;
                }
            }
            else if (b == null) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final T a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a != null) {
            hashCode2 = a.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final U b = this.b;
        if (b != null) {
            hashCode = b.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Pair(");
        sb.append(this.a);
        sb.append(",");
        sb.append(this.b);
        sb.append(")");
        return sb.toString();
    }
}
