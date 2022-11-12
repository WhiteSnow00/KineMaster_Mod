// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.Feature;

final class a0
{
    private final ApiKey a;
    private final Feature b;
    
    a0(final ApiKey a, final Feature b, final zabr zabr) {
        this.a = a;
        this.b = b;
    }
    
    static /* bridge */ Feature a(final a0 a0) {
        return a0.b;
    }
    
    static /* bridge */ ApiKey b(final a0 a0) {
        return a0.a;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != null && o instanceof a0) {
            final a0 a0 = (a0)o;
            if (Objects.b(this.a, a0.a) && Objects.b(this.b, a0.b)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        return Objects.c(this.a, this.b);
    }
    
    @Override
    public final String toString() {
        return Objects.d(this).a("key", this.a).a("feature", this.b).toString();
    }
}
