// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.lang.reflect.InvocationTargetException;
import android.os.IBinder;
import android.os.Bundle;
import java.lang.reflect.Method;

public final class BundleUtil
{
    private static Method a;
    private static Method b;
    
    private BundleUtil() {
    }
    
    public static IBinder a(final Bundle bundle, final String s) {
        if (Util.a >= 18) {
            return bundle.getBinder(s);
        }
        return b(bundle, s);
    }
    
    private static IBinder b(Bundle ex, final String s) {
        Method method;
        if ((method = BundleUtil.a) == null) {
            try {
                (BundleUtil.a = Bundle.class.getMethod("getIBinder", String.class)).setAccessible(true);
                method = BundleUtil.a;
            }
            catch (final NoSuchMethodException ex2) {
                Log.g("BundleUtil", "Failed to retrieve getIBinder method", ex2);
                return null;
            }
        }
        try {
            ex = (IllegalArgumentException)method.invoke(ex, s);
            return (IBinder)ex;
        }
        catch (final IllegalArgumentException ex) {}
        catch (final IllegalAccessException ex) {}
        catch (final InvocationTargetException ex3) {}
        Log.g("BundleUtil", "Failed to invoke getIBinder via reflection", ex);
        return null;
    }
    
    public static void c(final Bundle bundle, final String s, final IBinder binder) {
        if (Util.a >= 18) {
            bundle.putBinder(s, binder);
        }
        else {
            d(bundle, s, binder);
        }
    }
    
    private static void d(final Bundle ex, final String s, final IBinder binder) {
        Method method;
        if ((method = BundleUtil.b) == null) {
            try {
                (BundleUtil.b = Bundle.class.getMethod("putIBinder", String.class, IBinder.class)).setAccessible(true);
                method = BundleUtil.b;
            }
            catch (final NoSuchMethodException ex2) {
                Log.g("BundleUtil", "Failed to retrieve putIBinder method", ex2);
                return;
            }
        }
        try {
            method.invoke(ex, s, binder);
            return;
        }
        catch (final IllegalArgumentException ex) {}
        catch (final IllegalAccessException ex) {}
        catch (final InvocationTargetException ex3) {}
        Log.g("BundleUtil", "Failed to invoke putIBinder via reflection", ex);
    }
}
