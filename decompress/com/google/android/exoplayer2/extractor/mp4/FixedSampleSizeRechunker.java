// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Util;

final class FixedSampleSizeRechunker
{
    public static Results a(final int n, final long[] array, final int[] array2, final long n2) {
        final int n3 = 8192 / n;
        final int length = array2.length;
        final int n4 = 0;
        int i = 0;
        int n5 = 0;
        while (i < length) {
            n5 += Util.l(array2[i], n3);
            ++i;
        }
        final long[] array3 = new long[n5];
        final int[] array4 = new int[n5];
        final long[] array5 = new long[n5];
        final int[] array6 = new int[n5];
        final int n6 = 0;
        int max;
        int n7 = max = 0;
        int j = n4;
        int n8 = n6;
        while (j < array2.length) {
            int k = array2[j];
            long n9 = array[j];
            while (k > 0) {
                final int min = Math.min(n3, k);
                array3[n7] = n9;
                array4[n7] = n * min;
                max = Math.max(max, array4[n7]);
                array5[n7] = n8 * n2;
                array6[n7] = 1;
                n9 += array4[n7];
                n8 += min;
                k -= min;
                ++n7;
            }
            ++j;
        }
        return new Results(array3, array4, max, array5, array6, n2 * n8, null);
    }
    
    public static final class Results
    {
        public final long[] a;
        public final int[] b;
        public final int c;
        public final long[] d;
        public final int[] e;
        public final long f;
        
        private Results(final long[] a, final int[] b, final int c, final long[] d, final int[] e, final long f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
        
        Results(final long[] array, final int[] array2, final int n, final long[] array3, final int[] array4, final long n2, final FixedSampleSizeRechunker$a object) {
            this(array, array2, n, array3, array4, n2);
        }
    }
}
