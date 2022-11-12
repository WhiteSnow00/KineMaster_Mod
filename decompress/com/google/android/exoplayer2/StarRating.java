// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.common.base.Objects;
import android.os.Bundle;
import com.google.android.exoplayer2.util.Assertions;

public final class StarRating extends Rating
{
    public static final Creator<StarRating> d;
    private final int b;
    private final float c;
    
    static {
        d = s1.a;
    }
    
    public StarRating(final int b) {
        Assertions.b(b > 0, "maxStars must be a positive integer");
        this.b = b;
        this.c = -1.0f;
    }
    
    public StarRating(final int b, final float c) {
        final boolean b2 = true;
        Assertions.b(b > 0, "maxStars must be a positive integer");
        Assertions.b(c >= 0.0f && c <= b && b2, "starRating is out of range [0, maxStars]");
        this.b = b;
        this.c = c;
    }
    
    private static String c(final int n) {
        return Integer.toString(n, 36);
    }
    
    public static StarRating d(final Bundle bundle) {
        return e(bundle);
    }
    
    private static StarRating e(final Bundle bundle) {
        boolean b = false;
        if (bundle.getInt(c(0), -1) == 2) {
            b = true;
        }
        Assertions.a(b);
        final int int1 = bundle.getInt(c(1), 5);
        final float float1 = bundle.getFloat(c(2), -1.0f);
        StarRating starRating;
        if (float1 == -1.0f) {
            starRating = new StarRating(int1);
        }
        else {
            starRating = new StarRating(int1, float1);
        }
        return starRating;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof StarRating;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final StarRating starRating = (StarRating)o;
        boolean b3 = b2;
        if (this.b == starRating.b) {
            b3 = b2;
            if (this.c == starRating.c) {
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
        bundle.putInt(c(0), 2);
        bundle.putInt(c(1), this.b);
        bundle.putFloat(c(2), this.c);
        return bundle;
    }
}
