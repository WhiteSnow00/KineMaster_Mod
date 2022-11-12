// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import javax.annotation.Nullable;
import android.util.Log;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Asserts
{
    private Asserts() {
        throw new AssertionError((Object)"Uninstantiable");
    }
    
    @KeepForSdk
    public static void a(final String s) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        final String value = String.valueOf(Thread.currentThread());
        final String value2 = String.valueOf(Looper.getMainLooper().getThread());
        final StringBuilder sb = new StringBuilder();
        sb.append("checkMainThread: current thread ");
        sb.append(value);
        sb.append(" IS NOT the main thread ");
        sb.append(value2);
        sb.append("!");
        Log.e("Asserts", sb.toString());
        throw new IllegalStateException(s);
    }
    
    @KeepForSdk
    public static void b(final String s) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            return;
        }
        final String value = String.valueOf(Thread.currentThread());
        final String value2 = String.valueOf(Looper.getMainLooper().getThread());
        final StringBuilder sb = new StringBuilder();
        sb.append("checkNotMainThread: current thread ");
        sb.append(value);
        sb.append(" IS the main thread ");
        sb.append(value2);
        sb.append("!");
        Log.e("Asserts", sb.toString());
        throw new IllegalStateException(s);
    }
    
    @KeepForSdk
    public static void c(@Nullable final Object o) {
        if (o != null) {
            return;
        }
        throw new IllegalArgumentException("null reference");
    }
}
