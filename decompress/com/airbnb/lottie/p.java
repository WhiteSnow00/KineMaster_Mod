// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie;

import java.nio.ShortBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;

public final class p
{
    public static final int[] A;
    public static final int[] B;
    public static final int[] C;
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final int H = 4;
    public static final int I = 5;
    public static final int J = 6;
    public static final int K = 7;
    public static final int L = 8;
    public static final int M = 9;
    public static final int N = 10;
    public static final int O = 11;
    public static final int P = 12;
    public static final int Q = 13;
    public static final int R = 14;
    public static final int S = 15;
    public static final int[] T;
    public static final int[] U;
    public static final int[] V;
    public static final int[] W;
    public static final int[] X;
    public static final int[] Y;
    public static final int[] Z;
    public static final int[] a;
    public static final int[] a0;
    public static final int[] b;
    public static final int[] b0;
    public static final int[] c;
    public static final int[] c0;
    public static final int[] d;
    public static final int[] d0;
    public static final int[] e;
    public static final int[] e0;
    public static final int[] f;
    public static final int[] f0;
    public static final int[] g;
    public static final int[] g0;
    public static final int[] h;
    public static final int[] h0;
    public static final int[] i;
    public static final int[] i0;
    public static final int[] j;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public static final int[] n;
    public static final int[] o;
    public static final int[] p;
    public static final int[] q;
    public static final int[] r;
    public static final int[] s;
    public static final int[] t;
    public static final int[] u;
    public static final int[] v;
    public static final int[] w;
    public static final int[] x;
    public static final int[] y;
    public static final int[] z;
    
    static {
        a = new int[] { 2130968752, 2130968759, 2130968760, 2130968979, 2130968980, 2130968981, 2130968982, 2130968983, 2130968984, 2130969023, 2130969058, 2130969059, 2130969101, 2130969220, 2130969227, 2130969237, 2130969238, 2130969243, 2130969265, 2130969290, 2130969430, 2130969575, 2130969642, 2130969665, 2130969666, 2130969864, 2130969869, 2130970007, 2130970021 };
        b = new int[] { 16842931 };
        c = new int[] { 16843071 };
        d = new int[0];
        e = new int[] { 2130968752, 2130968759, 2130968916, 2130969220, 2130969869, 2130970021 };
        f = new int[] { 2130969130, 2130969271 };
        g = new int[] { 16842994, 2130968819, 2130968820, 2130969419, 2130969420, 2130969570, 2130969787, 2130969801 };
        h = new int[] { 16843036, 16843156, 16843157, 16843158, 16843532, 16843533 };
        i = new int[] { 16842960, 16843161 };
        j = new int[] { 16843161, 16843849, 16843850, 16843851 };
        k = new int[] { 16843033, 2130969835, 2130970005, 2130970006 };
        l = new int[] { 16843074, 2130970000, 2130970001, 2130970002 };
        m = new int[] { 16842804, 16843117, 16843118, 16843119, 16843120, 16843666, 16843667 };
        n = new int[] { 16842804, 2130968745, 2130968746, 2130968747, 2130968748, 2130968749, 2130969080, 2130969081, 2130969082, 2130969083, 2130969085, 2130969086, 2130969087, 2130969088, 2130969105, 2130969162, 2130969195, 2130969204, 2130969324, 2130969412, 2130969919, 2130969975 };
        o = $d2j$hex$46828e00$decode_I("57000101ae0001010d00047f0e00047f0f00047f1000047f1100047f1200047f1300047f1400047f1500047f1600047f1700047f1800047f1900047f1b00047f1c00047f1d00047f1e00047f1f00047f2000047f2100047f2200047f2300047f2400047f2500047f2600047f2700047f2800047f2900047f2a00047f2b00047f2c00047f2d00047f3200047f8f00047f9000047f9100047f9200047fa800047fd900047fec00047fed00047fee00047fef00047ff000047ff600047ff700047f1601047f2001047f6101047f6201047f6301047f6501047f6601047f6701047f6801047f7901047f7b01047f8601047fa201047fd801047fdd01047fde01047fe501047fea01047f0402047f0502047f0902047f0a02047f0c02047f9502047faa02047f4703047f4803047f4903047f4a03047f4d03047f4e03047f4f03047f5003047f5103047f5203047f5303047f5403047f5503047f0604047f0704047f0804047f2904047f2b04047f4a04047f4d04047f4e04047f4f04047f9a04047f9f04047fa104047fa204047fdf04047fe004047f1a05047f5605047f5805047f5905047f5a05047f5c05047f5d05047f5e05047f5f05047f6b05047f6c05047fa805047fa905047fb005047fb105047fef05047ffe05047fff05047f0006047f0106047f0206047f0306047f0406047f0506047f0606047f0706047f");
        p = new int[] { 2130968726 };
        q = new int[] { 16843173, 16843551, 16844359, 2130968727, 2130969314 };
        r = new int[] { 16843015, 2130968817, 2130968824, 2130968825 };
        s = new int[] { 2130969313, 2130969851 };
        t = new int[] { 16842931, 2130969331, 2130969332, 2130969333, 2130969382, 2130969393, 2130969394 };
        u = new int[] { 2130968739, 2130968740, 2130968769, 2130968928, 2130969084, 2130969210, 2130969822, 2130969987 };
        v = new int[] { 2130969196, 2130969197, 2130969198, 2130969199, 2130969200, 2130969201, 2130969202 };
        w = new int[] { 16844082, 16844083, 16844095, 16844143, 16844144, 2130969194, 2130969203, 2130969204, 2130969205, 2130970062 };
        x = new int[] { 16843165, 16843166, 16843169, 16843170, 16843171, 16843172, 16843265, 16843275, 16844048, 16844049, 16844050, 16844051 };
        y = new int[] { 16843173, 16844052 };
        z = new int[] { 16842927, 16842948, 16843046, 16843047, 16843048, 2130969059, 2130969064, 2130969508, 2130969781 };
        A = new int[] { 16842931, 16842996, 16842997, 16843137 };
        B = new int[] { 16843436, 16843437 };
        C = new int[] { 2130969436, 2130969437, 2130969438, 2130969439, 2130969440, 2130969441, 2130969442, 2130969443, 2130969444, 2130969445, 2130969446, 2130969447, 2130969448, 2130969449, 2130969450, 2130969451 };
        T = new int[] { 16842766, 16842960, 16843156, 16843230, 16843231, 16843232 };
        U = new int[] { 16842754, 16842766, 16842960, 16843014, 16843156, 16843230, 16843231, 16843233, 16843234, 16843235, 16843236, 16843237, 16843375, 2130968602, 2130968622, 2130968624, 2130968728, 2130968978, 2130969251, 2130969252, 2130969584, 2130969779, 2130970035 };
        V = new int[] { 16842926, 16843052, 16843053, 16843054, 16843055, 16843056, 16843057, 2130969658, 2130969858 };
        W = new int[] { 16843126, 16843465, 2130969595 };
        X = new int[] { 2130969845 };
        Y = new int[] { 2130969597, 2130969604 };
        Z = new int[] { 16842970, 16843039, 16843296, 16843364, 2130968909, 2130968969, 2130969039, 2130969212, 2130969253, 2130969327, 2130969671, 2130969672, 2130969752, 2130969753, 2130969863, 2130969873, 2130970101 };
        a0 = new int[] { 16842930, 16843126, 16843131, 16843362, 2130969642 };
        b0 = new int[] { 16843036, 16843156, 16843157, 16843158, 16843532, 16843533 };
        c0 = new int[] { 16843161 };
        d0 = new int[] { 16843044, 16843045, 16843074, 2130969786, 2130969829, 2130969878, 2130969879, 2130969883, 2130969993, 2130969995, 2130969996, 2130970041, 2130970051, 2130970052 };
        e0 = new int[] { 16842901, 16842902, 16842903, 16842904, 16842906, 16842907, 16843105, 16843106, 16843107, 16843108, 16843692, 16844165, 2130969195, 2130969204, 2130969919, 2130969975 };
        f0 = new int[] { 16842927, 16843072, 2130968818, 2130968917, 2130968918, 2130968979, 2130968980, 2130968981, 2130968982, 2130968983, 2130968984, 2130969129, 2130969430, 2130969432, 2130969433, 2130969498, 2130969509, 2130969572, 2130969573, 2130969642, 2130969864, 2130969866, 2130969867, 2130969868, 2130970007, 2130970011, 2130970012, 2130970013, 2130970014, 2130970015, 2130970016, 2130970017, 2130970019, 2130970020, 2130970022 };
        g0 = new int[] { 16842752, 16842970, 2130969599, 2130969603, 2130969985 };
        h0 = new int[] { 16842964, 2130968761, 2130968762 };
        i0 = new int[] { 16842960, 16842994, 16842995 };
    }
    
    private static long[] $d2j$hex$46828e00$decode_J(final String src) {
        final byte[] d = $d2j$hex$46828e00$decode_B(src);
        final ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        final LongBuffer s = b.asLongBuffer();
        final long[] data = new long[d.length / 8];
        s.get(data);
        return data;
    }
    
    private static int[] $d2j$hex$46828e00$decode_I(final String src) {
        final byte[] d = $d2j$hex$46828e00$decode_B(src);
        final ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        final IntBuffer s = b.asIntBuffer();
        final int[] data = new int[d.length / 4];
        s.get(data);
        return data;
    }
    
    private static short[] $d2j$hex$46828e00$decode_S(final String src) {
        final byte[] d = $d2j$hex$46828e00$decode_B(src);
        final ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        final ShortBuffer s = b.asShortBuffer();
        final short[] data = new short[d.length / 2];
        s.get(data);
        return data;
    }
    
    private static byte[] $d2j$hex$46828e00$decode_B(final String src) {
        final char[] d = src.toCharArray();
        final byte[] ret = new byte[src.length() / 2];
        for (int i = 0; i < ret.length; ++i) {
            final char h = d[2 * i];
            final char l = d[2 * i + 1];
            int hh;
            if (h >= '0' && h <= '9') {
                hh = h - '0';
            }
            else if (h >= 'a' && h <= 'f') {
                hh = h - 'a' + 10;
            }
            else {
                if (h < 'A' || h > 'F') {
                    throw new RuntimeException();
                }
                hh = h - 'A' + 10;
            }
            int ll;
            if (l >= '0' && l <= '9') {
                ll = l - '0';
            }
            else if (l >= 'a' && l <= 'f') {
                ll = l - 'a' + 10;
            }
            else {
                if (l < 'A' || l > 'F') {
                    throw new RuntimeException();
                }
                ll = l - 'A' + 10;
            }
            ret[i] = (byte)(hh << 4 | ll);
        }
        return ret;
    }
}
