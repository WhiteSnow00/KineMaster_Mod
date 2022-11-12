// 
// Decompiled by Procyon v0.6.0
// 

package androidx.collection;

class c
{
    static final int[] a;
    static final long[] b;
    static final Object[] c;
    
    static {
        a = new int[0];
        b = new long[0];
        c = new Object[0];
    }
    
    static int a(final int[] array, int n, final int n2) {
        --n;
        int i = 0;
        while (i <= n) {
            final int n3 = i + n >>> 1;
            final int n4 = array[n3];
            if (n4 < n2) {
                i = n3 + 1;
            }
            else {
                if (n4 <= n2) {
                    return n3;
                }
                n = n3 - 1;
            }
        }
        return ~i;
    }
    
    static int b(final long[] array, int n, final long n2) {
        --n;
        int i = 0;
        while (i <= n) {
            final int n3 = i + n >>> 1;
            final long n4 = lcmp(array[n3], n2);
            if (n4 < 0) {
                i = n3 + 1;
            }
            else {
                if (n4 <= 0) {
                    return n3;
                }
                n = n3 - 1;
            }
        }
        return ~i;
    }
    
    public static boolean c(final Object o, final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    public static int d(final int n) {
        for (int i = 4; i < 32; ++i) {
            final int n2 = (1 << i) - 12;
            if (n <= n2) {
                return n2;
            }
        }
        return n;
    }
    
    public static int e(final int n) {
        return d(n * 4) / 4;
    }
    
    public static int f(final int n) {
        return d(n * 8) / 8;
    }
}
