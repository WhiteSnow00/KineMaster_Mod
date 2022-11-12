// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.common.base.Objects;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Bundle;

public final class HeartRating extends Rating
{
    public static final Creator<HeartRating> d;
    private final boolean b;
    private final boolean c;
    
    static {
        d = y0.a;
    }
    
    public HeartRating() {
        this.b = false;
        this.c = false;
    }
    
    public HeartRating(final boolean c) {
        this.b = true;
        this.c = c;
    }
    
    private static String c(final int n) {
        return Integer.toString(n, 36);
    }
    
    public static HeartRating d(final Bundle bundle) {
        return e(bundle);
    }
    
    private static HeartRating e(final Bundle bundle) {
        Assertions.a(bundle.getInt(c(0), -1) == 0);
        HeartRating heartRating;
        if (bundle.getBoolean(c(1), false)) {
            heartRating = new HeartRating(bundle.getBoolean(c(2), false));
        }
        else {
            heartRating = new HeartRating();
        }
        return heartRating;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof HeartRating;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final HeartRating heartRating = (HeartRating)o;
        boolean b3 = b2;
        if (this.c == heartRating.c) {
            b3 = b2;
            if (this.b == heartRating.b) {
                b3 = true;
            }
        }
        return b3;
    }
    
    @Override
    public int hashCode() {
        return Objects.b(new Object[] { this.b, this.c });
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putInt(c(0), 0);
        bundle.putBoolean(c(1), this.b);
        bundle.putBoolean(c(2), this.c);
        return bundle;
    }
}
