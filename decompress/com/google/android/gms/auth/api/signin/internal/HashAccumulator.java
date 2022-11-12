// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class HashAccumulator
{
    @VisibleForTesting
    static int b = 31;
    private int a;
    
    public HashAccumulator() {
        this.a = 1;
    }
    
    @KeepForSdk
    @CanIgnoreReturnValue
    public HashAccumulator a(final Object o) {
        final int b = HashAccumulator.b;
        final int a = this.a;
        int hashCode;
        if (o == null) {
            hashCode = 0;
        }
        else {
            hashCode = o.hashCode();
        }
        this.a = b * a + hashCode;
        return this;
    }
    
    @KeepForSdk
    public int b() {
        return this.a;
    }
    
    @CanIgnoreReturnValue
    public final HashAccumulator c(final boolean b) {
        this.a = HashAccumulator.b * this.a + (b ? 1 : 0);
        return this;
    }
}
