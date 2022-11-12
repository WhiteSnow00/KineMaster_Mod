// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

public class BooleanResult implements Result
{
    private final Status a;
    private final boolean b;
    
    @Override
    public final boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof BooleanResult)) {
            return false;
        }
        final BooleanResult booleanResult = (BooleanResult)o;
        return this.a.equals(booleanResult.a) && this.b == booleanResult.b;
    }
    
    @Override
    public Status getStatus() {
        return this.a;
    }
    
    @Override
    public final int hashCode() {
        return (this.a.hashCode() + 527) * 31 + (this.b ? 1 : 0);
    }
}
