// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.util.common;

import android.os.Looper;
import androidx.annotation.Keep;

@Keep
public final class Preconditions
{
    public static void checkIsOnMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new RuntimeException("Must be called from the UiThread");
    }
    
    public static void checkIsTrue(final boolean b, final String s) {
        if (b) {
            return;
        }
        throw new IllegalArgumentException(s);
    }
    
    public static <T> T checkNotNull(final T t, final String s) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(s);
    }
}
