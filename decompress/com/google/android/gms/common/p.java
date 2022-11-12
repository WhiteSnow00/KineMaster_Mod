// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import java.util.AbstractCollection;
import java.util.Collection;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.android.gms.internal.common.zzag;

final class p
{
    private String a;
    private long b;
    private zzag c;
    private zzag d;
    
    p() {
        this.a = null;
        this.b = -1L;
        this.c = zzag.zzl();
        this.d = zzag.zzl();
    }
    
    @CanIgnoreReturnValue
    final p a(final long b) {
        this.b = b;
        return this;
    }
    
    @CanIgnoreReturnValue
    final p b(final List list) {
        Preconditions.k(list);
        this.d = zzag.zzk((Collection)list);
        return this;
    }
    
    @CanIgnoreReturnValue
    final p c(final List list) {
        Preconditions.k(list);
        this.c = zzag.zzk((Collection)list);
        return this;
    }
    
    @CanIgnoreReturnValue
    final p d(final String a) {
        this.a = a;
        return this;
    }
    
    final b e() {
        if (this.a == null) {
            throw new IllegalStateException("packageName must be defined");
        }
        if (this.b < 0L) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        if (((AbstractCollection)this.c).isEmpty() && ((AbstractCollection)this.d).isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        return new b(this.a, this.b, this.c, this.d, null);
    }
}
