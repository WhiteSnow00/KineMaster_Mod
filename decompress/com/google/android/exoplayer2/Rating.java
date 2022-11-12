// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public abstract class Rating implements Bundleable
{
    public static final Creator<Rating> a;
    
    static {
        a = r1.a;
    }
    
    Rating() {
    }
    
    public static Rating a(final Bundle bundle) {
        return b(bundle);
    }
    
    private static Rating b(final Bundle bundle) {
        final int int1 = bundle.getInt(c(0), -1);
        if (int1 == 0) {
            return HeartRating.d.a(bundle);
        }
        if (int1 == 1) {
            return PercentageRating.c.a(bundle);
        }
        if (int1 == 2) {
            return StarRating.d.a(bundle);
        }
        if (int1 == 3) {
            return ThumbRating.d.a(bundle);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unknown RatingType: ");
        sb.append(int1);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private static String c(final int n) {
        return Integer.toString(n, 36);
    }
}
