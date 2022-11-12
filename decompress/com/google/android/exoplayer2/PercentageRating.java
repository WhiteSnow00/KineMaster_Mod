// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.common.base.Objects;
import android.os.Bundle;
import com.google.android.exoplayer2.util.Assertions;

public final class PercentageRating extends Rating
{
    public static final Creator<PercentageRating> c;
    private final float b;
    
    static {
        c = k1.a;
    }
    
    public PercentageRating() {
        this.b = -1.0f;
    }
    
    public PercentageRating(final float b) {
        Assertions.b(b >= 0.0f && b <= 100.0f, "percent must be in the range of [0, 100]");
        this.b = b;
    }
    
    private static String c(final int n) {
        return Integer.toString(n, 36);
    }
    
    public static PercentageRating d(final Bundle bundle) {
        return e(bundle);
    }
    
    private static PercentageRating e(final Bundle bundle) {
        boolean b = false;
        if (bundle.getInt(c(0), -1) == 1) {
            b = true;
        }
        Assertions.a(b);
        final float float1 = bundle.getFloat(c(1), -1.0f);
        PercentageRating percentageRating;
        if (float1 == -1.0f) {
            percentageRating = new PercentageRating();
        }
        else {
            percentageRating = new PercentageRating(float1);
        }
        return percentageRating;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof PercentageRating;
        boolean b2 = false;
        if (!b) {
            return false;
        }
        if (this.b == ((PercentageRating)o).b) {
            b2 = true;
        }
        return b2;
    }
    
    @Override
    public int hashCode() {
        return Objects.b(new Object[] { this.b });
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putInt(c(0), 1);
        bundle.putFloat(c(1), this.b);
        return bundle;
    }
}
