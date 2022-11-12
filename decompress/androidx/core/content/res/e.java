// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.res;

import java.lang.reflect.Array;

final class e
{
    public static int[] a(final int[] array, final int n, final int n2) {
        int[] array2 = array;
        if (n + 1 > array.length) {
            array2 = new int[c(n)];
            System.arraycopy(array, 0, array2, 0, n);
        }
        array2[n] = n2;
        return array2;
    }
    
    public static <T> T[] b(final T[] array, final int n, final T t) {
        Object[] array2 = array;
        if (n + 1 > array.length) {
            array2 = (Object[])Array.newInstance(array.getClass().getComponentType(), c(n));
            System.arraycopy(array, 0, array2, 0, n);
        }
        array2[n] = t;
        return (T[])array2;
    }
    
    public static int c(int n) {
        if (n <= 4) {
            n = 8;
        }
        else {
            n *= 2;
        }
        return n;
    }
}
