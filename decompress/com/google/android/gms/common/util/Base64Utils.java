// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Base64Utils
{
    @KeepForSdk
    public static byte[] a(final String s) {
        if (s == null) {
            return null;
        }
        return Base64.decode(s, 10);
    }
    
    @KeepForSdk
    public static byte[] b(final String s) {
        if (s == null) {
            return null;
        }
        return Base64.decode(s, 11);
    }
    
    @KeepForSdk
    public static String c(final byte[] array) {
        if (array == null) {
            return null;
        }
        return Base64.encodeToString(array, 0);
    }
    
    @KeepForSdk
    public static String d(final byte[] array) {
        if (array == null) {
            return null;
        }
        return Base64.encodeToString(array, 10);
    }
    
    @KeepForSdk
    public static String e(final byte[] array) {
        if (array == null) {
            return null;
        }
        return Base64.encodeToString(array, 11);
    }
}
