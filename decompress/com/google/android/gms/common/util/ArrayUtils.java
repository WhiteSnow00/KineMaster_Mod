// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.Arrays;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
public final class ArrayUtils
{
    private ArrayUtils() {
    }
    
    @KeepForSdk
    public static <T> T[] a(final T[]... array) {
        if (array.length != 0) {
            int i = 0;
            int n = 0;
            while (i < array.length) {
                n += array[i].length;
                ++i;
            }
            final T[] copy = Arrays.copyOf(array[0], n);
            int length = array[0].length;
            for (int j = 1; j < array.length; ++j) {
                final T[] array2 = array[j];
                final int length2 = array2.length;
                System.arraycopy(array2, 0, copy, length, length2);
                length += length2;
            }
            return copy;
        }
        return (T[])Array.newInstance(array.getClass(), 0);
    }
    
    @KeepForSdk
    public static boolean b(final int[] array, final int n) {
        if (array == null) {
            return false;
        }
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    @KeepForSdk
    public static <T> boolean c(final T[] array, final T t) {
        int length;
        if (array != null) {
            length = array.length;
        }
        else {
            length = 0;
        }
        int i = 0;
        while (i < length) {
            if (Objects.b(array[i], t)) {
                if (i >= 0) {
                    return true;
                }
                break;
            }
            else {
                ++i;
            }
        }
        return false;
    }
    
    @KeepForSdk
    public static void d(final StringBuilder sb, final double[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(array[i]));
        }
    }
    
    @KeepForSdk
    public static void e(final StringBuilder sb, final float[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(array[i]));
        }
    }
    
    @KeepForSdk
    public static void f(final StringBuilder sb, final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(array[i]));
        }
    }
    
    @KeepForSdk
    public static void g(final StringBuilder sb, final long[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(array[i]));
        }
    }
    
    @KeepForSdk
    public static <T> void h(final StringBuilder sb, final T[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(array[i]);
        }
    }
    
    @KeepForSdk
    public static void i(final StringBuilder sb, final boolean[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(array[i]));
        }
    }
    
    @KeepForSdk
    public static void j(final StringBuilder sb, final String[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(array[i]);
            sb.append("\"");
        }
    }
}
