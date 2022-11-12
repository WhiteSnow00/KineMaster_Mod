// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.common.base.Objects;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Bundle;

public final class ThumbRating extends Rating
{
    public static final Creator<ThumbRating> d;
    private final boolean b;
    private final boolean c;
    
    static {
        d = u1.a;
    }
    
    public ThumbRating() {
        this.b = false;
        this.c = false;
    }
    
    public ThumbRating(final boolean c) {
        this.b = true;
        this.c = c;
    }
    
    private static String c(final int n) {
        return Integer.toString(n, 36);
    }
    
    public static ThumbRating d(final Bundle bundle) {
        return e(bundle);
    }
    
    private static ThumbRating e(final Bundle bundle) {
        Assertions.a(bundle.getInt(c(0), -1) == 3);
        ThumbRating thumbRating;
        if (bundle.getBoolean(c(1), false)) {
            thumbRating = new ThumbRating(bundle.getBoolean(c(2), false));
        }
        else {
            thumbRating = new ThumbRating();
        }
        return thumbRating;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof ThumbRating;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final ThumbRating thumbRating = (ThumbRating)o;
        boolean b3 = b2;
        if (this.c == thumbRating.c) {
            b3 = b2;
            if (this.b == thumbRating.b) {
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
        bundle.putInt(c(0), 3);
        bundle.putBoolean(c(1), this.b);
        bundle.putBoolean(c(2), this.c);
        return bundle;
    }
}
