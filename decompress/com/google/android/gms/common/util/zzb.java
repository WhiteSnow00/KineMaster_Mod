// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import android.os.Looper;

public final class zzb
{
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
