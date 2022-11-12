// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Util;
import java.util.zip.Inflater;
import com.google.android.exoplayer2.util.ParsableBitArray;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class b
{
    public static Projection a(final byte[] array, final int n) {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(array);
        ArrayList<Projection.Mesh> list;
        try {
            if (c(parsableByteArray)) {
                list = f(parsableByteArray);
            }
            else {
                list = e(parsableByteArray);
            }
        }
        catch (final ArrayIndexOutOfBoundsException ex) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        final int size = list.size();
        if (size == 1) {
            return new Projection((Projection.Mesh)list.get(0), n);
        }
        if (size != 2) {
            return null;
        }
        return new Projection((Projection.Mesh)list.get(0), (Projection.Mesh)list.get(1), n);
    }
    
    private static int b(final int n) {
        return -(n & 0x1) ^ n >> 1;
    }
    
    private static boolean c(final ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(4);
        final int n = parsableByteArray.n();
        boolean b = false;
        parsableByteArray.P(0);
        if (n == 1886547818) {
            b = true;
        }
        return b;
    }
    
    private static Projection.Mesh d(final ParsableByteArray parsableByteArray) {
        final int n = parsableByteArray.n();
        if (n > 10000) {
            return null;
        }
        final float[] array = new float[n];
        for (int i = 0; i < n; ++i) {
            array[i] = parsableByteArray.m();
        }
        final int n2 = parsableByteArray.n();
        if (n2 > 32000) {
            return null;
        }
        final double log = Math.log(2.0);
        final int n3 = (int)Math.ceil(Math.log(n * 2.0) / log);
        final ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.d());
        parsableBitArray.p(parsableByteArray.e() * 8);
        final float[] array2 = new float[n2 * 5];
        final int[] array3 = new int[5];
        int j = 0;
        int n4 = 0;
        while (j < n2) {
            for (int k = 0; k < 5; ++k, ++n4) {
                final int n5 = array3[k] + b(parsableBitArray.h(n3));
                if (n5 >= n || n5 < 0) {
                    return null;
                }
                array2[n4] = array[n5];
                array3[k] = n5;
            }
            ++j;
        }
        parsableBitArray.p(parsableBitArray.e() + 7 & 0xFFFFFFF8);
        final int h = parsableBitArray.h(32);
        final Projection.SubMesh[] array4 = new Projection.SubMesh[h];
        for (int l = 0; l < h; ++l) {
            final int h2 = parsableBitArray.h(8);
            final int h3 = parsableBitArray.h(8);
            final int h4 = parsableBitArray.h(32);
            if (h4 > 128000) {
                return null;
            }
            final int n6 = (int)Math.ceil(Math.log(n2 * 2.0) / log);
            final float[] array5 = new float[h4 * 3];
            final float[] array6 = new float[h4 * 2];
            int n7 = 0;
            int n8 = 0;
            while (n7 < h4) {
                n8 += b(parsableBitArray.h(n6));
                if (n8 < 0 || n8 >= n2) {
                    return null;
                }
                final int n9 = n7 * 3;
                final int n10 = n8 * 5;
                array5[n9] = array2[n10];
                array5[n9 + 1] = array2[n10 + 1];
                array5[n9 + 2] = array2[n10 + 2];
                final int n11 = n7 * 2;
                array6[n11] = array2[n10 + 3];
                array6[n11 + 1] = array2[n10 + 4];
                ++n7;
            }
            array4[l] = new Projection.SubMesh(h2, array5, array6, h3);
        }
        return new Projection.Mesh(array4);
    }
    
    private static ArrayList<Projection.Mesh> e(ParsableByteArray o) {
        if (((ParsableByteArray)o).D() != 0) {
            return null;
        }
        ((ParsableByteArray)o).Q(7);
        final int n = ((ParsableByteArray)o).n();
        if (n == 1684433976) {
            final ParsableByteArray parsableByteArray = new ParsableByteArray();
            final Inflater inflater = new Inflater(true);
            try {
                if (!Util.r0((ParsableByteArray)o, parsableByteArray, inflater)) {
                    return null;
                }
                inflater.end();
                o = parsableByteArray;
                return g((ParsableByteArray)o);
            }
            finally {
                inflater.end();
            }
        }
        if (n != 1918990112) {
            return null;
        }
        return g((ParsableByteArray)o);
    }
    
    private static ArrayList<Projection.Mesh> f(final ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(8);
        int n;
        for (int i = parsableByteArray.e(), f = parsableByteArray.f(); i < f; i = n) {
            n = parsableByteArray.n() + i;
            if (n <= i) {
                break;
            }
            if (n > f) {
                break;
            }
            final int n2 = parsableByteArray.n();
            if (n2 == 2037673328 || n2 == 1836279920) {
                parsableByteArray.O(n);
                return e(parsableByteArray);
            }
            parsableByteArray.P(n);
        }
        return null;
    }
    
    private static ArrayList<Projection.Mesh> g(final ParsableByteArray parsableByteArray) {
        final ArrayList list = new ArrayList();
        int n;
        for (int i = parsableByteArray.e(), f = parsableByteArray.f(); i < f; i = n) {
            n = parsableByteArray.n() + i;
            if (n <= i || n > f) {
                return null;
            }
            if (parsableByteArray.n() == 1835365224) {
                final Projection.Mesh d = d(parsableByteArray);
                if (d == null) {
                    return null;
                }
                list.add(d);
            }
            parsableByteArray.P(n);
        }
        return list;
    }
}
