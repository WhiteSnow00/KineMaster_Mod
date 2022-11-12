// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class CrashUtils
{
    private static final String[] a;
    
    static {
        a = new String[] { "android.", "com.android.", "dalvik.", "java.", "javax." };
    }
    
    @KeepForSdk
    public static boolean a(final Context context, final Throwable t) {
        try {
            Preconditions.k(context);
            Preconditions.k(t);
        }
        catch (final Exception ex) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", (Throwable)ex);
        }
        return false;
    }
}
