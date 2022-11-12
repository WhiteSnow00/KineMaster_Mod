// 
// Decompiled by Procyon v0.6.0
// 

package d;

import java.nio.ShortBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;

public final class j
{
    public static final int A = 2;
    public static final int A0 = 1;
    public static final int A1 = 4;
    public static final int A2 = 2;
    public static final int A3 = 26;
    public static final int B = 3;
    public static final int B0 = 86;
    public static final int B1 = 5;
    public static final int B2 = 3;
    public static final int B3 = 27;
    public static final int C = 4;
    public static final int C0 = 116;
    public static final int C1 = 6;
    public static final int C2 = 4;
    public static final int C3 = 28;
    public static final int D = 5;
    public static final int D0 = 117;
    public static final int D1 = 7;
    public static final int[] D2;
    public static final int D3 = 29;
    public static final int[] E;
    public static final int E0 = 118;
    public static final int E1 = 8;
    public static final int E2 = 0;
    public static final int E3 = 30;
    public static final int[] F;
    public static final int F0 = 119;
    public static final int F1 = 9;
    public static final int F2 = 1;
    public static final int F3 = 32;
    public static final int G = 0;
    public static final int G0 = 120;
    public static final int G1 = 10;
    public static final int G2 = 2;
    public static final int G3 = 33;
    public static final int H = 1;
    public static final int H0 = 121;
    public static final int H1 = 11;
    public static final int H2 = 3;
    public static final int[] H3;
    public static final int I = 2;
    public static final int I0 = 122;
    public static final int I1 = 12;
    public static final int I2 = 4;
    public static final int I3 = 0;
    public static final int J = 3;
    public static final int J0 = 123;
    public static final int J1 = 13;
    public static final int J2 = 5;
    public static final int J3 = 4;
    public static final int K = 4;
    public static final int K0 = 124;
    public static final int K1 = 14;
    public static final int K2 = 6;
    public static final int[] K3;
    public static final int L = 5;
    public static final int L0 = 125;
    public static final int L1 = 15;
    public static final int L2 = 7;
    public static final int L3 = 0;
    public static final int M = 6;
    public static final int M0 = 126;
    public static final int M1 = 16;
    public static final int M2 = 8;
    public static final int M3 = 1;
    public static final int N = 7;
    public static final int[] N0;
    public static final int N1 = 17;
    public static final int N2 = 9;
    public static final int N3 = 2;
    public static final int[] O;
    public static final int O0 = 0;
    public static final int O1 = 18;
    public static final int O2 = 10;
    public static final int[] O3;
    public static final int[] P;
    public static final int[] P0;
    public static final int P1 = 19;
    public static final int P2 = 11;
    public static final int P3 = 0;
    public static final int Q = 1;
    public static final int Q0 = 0;
    public static final int Q1 = 20;
    public static final int Q2 = 12;
    public static final int Q3 = 1;
    public static final int R = 2;
    public static final int R0 = 1;
    public static final int R1 = 21;
    public static final int R2 = 13;
    public static final int R3 = 2;
    public static final int S = 3;
    public static final int S0 = 2;
    public static final int S1 = 22;
    public static final int[] S2;
    public static final int[] T;
    public static final int T0 = 3;
    public static final int[] T1;
    public static final int T2 = 0;
    public static final int U = 0;
    public static final int[] U0;
    public static final int U1 = 1;
    public static final int U2 = 1;
    public static final int V = 1;
    public static final int V0 = 0;
    public static final int V1 = 5;
    public static final int V2 = 2;
    public static final int W = 2;
    public static final int W0 = 1;
    public static final int W1 = 7;
    public static final int W2 = 3;
    public static final int X = 3;
    public static final int X0 = 2;
    public static final int X1 = 8;
    public static final int X2 = 10;
    public static final int[] Y;
    public static final int Y0 = 3;
    public static final int[] Y1;
    public static final int Y2 = 11;
    public static final int Z = 0;
    public static final int[] Z0;
    public static final int Z1 = 0;
    public static final int Z2 = 12;
    public static final int[] a;
    public static final int a0 = 1;
    public static final int[] a1;
    public static final int a2 = 2;
    public static final int a3 = 13;
    public static final int b = 0;
    public static final int b0 = 2;
    public static final int b1 = 0;
    public static final int[] b2;
    public static final int b3 = 14;
    public static final int c = 1;
    public static final int c0 = 3;
    public static final int c1 = 1;
    public static final int[] c2;
    public static final int c3 = 15;
    public static final int d = 2;
    public static final int d0 = 4;
    public static final int d1 = 2;
    public static final int d2 = 0;
    public static final int[] d3;
    public static final int e = 3;
    public static final int e0 = 5;
    public static final int e1 = 3;
    public static final int e2 = 1;
    public static final int e3 = 0;
    public static final int f = 7;
    public static final int f0 = 6;
    public static final int f1 = 4;
    public static final int[] f2;
    public static final int f3 = 2;
    public static final int g = 9;
    public static final int[] g0;
    public static final int g1 = 5;
    public static final int g2 = 0;
    public static final int g3 = 3;
    public static final int h = 10;
    public static final int h0 = 1;
    public static final int h1 = 6;
    public static final int h2 = 1;
    public static final int h3 = 4;
    public static final int i = 12;
    public static final int i0 = 2;
    public static final int i1 = 7;
    public static final int i2 = 2;
    public static final int i3 = 5;
    public static final int j = 13;
    public static final int j0 = 3;
    public static final int j1 = 8;
    public static final int j2 = 3;
    public static final int j3 = 6;
    public static final int k = 14;
    public static final int k0 = 4;
    public static final int[] k1;
    public static final int k2 = 4;
    public static final int k3 = 7;
    public static final int l = 15;
    public static final int l0 = 5;
    public static final int[] l1;
    public static final int l2 = 5;
    public static final int l3 = 8;
    public static final int m = 17;
    public static final int m0 = 6;
    public static final int m1 = 0;
    public static final int m2 = 6;
    public static final int m3 = 9;
    public static final int n = 20;
    public static final int n0 = 7;
    public static final int n1 = 1;
    public static final int n2 = 7;
    public static final int n3 = 10;
    public static final int o = 22;
    public static final int o0 = 8;
    public static final int[] o1;
    public static final int o2 = 8;
    public static final int o3 = 12;
    public static final int p = 25;
    public static final int p0 = 9;
    public static final int p1 = 0;
    public static final int p2 = 9;
    public static final int p3 = 13;
    public static final int q = 26;
    public static final int q0 = 10;
    public static final int q1 = 1;
    public static final int q2 = 10;
    public static final int q3 = 15;
    public static final int r = 27;
    public static final int r0 = 11;
    public static final int r1 = 2;
    public static final int r2 = 11;
    public static final int r3 = 16;
    public static final int s = 28;
    public static final int s0 = 12;
    public static final int s1 = 3;
    public static final int s2 = 12;
    public static final int s3 = 17;
    public static final int[] t;
    public static final int t0 = 13;
    public static final int t1 = 4;
    public static final int t2 = 13;
    public static final int t3 = 18;
    public static final int u = 0;
    public static final int u0 = 14;
    public static final int u1 = 5;
    public static final int u2 = 14;
    public static final int u3 = 19;
    public static final int[] v;
    public static final int v0 = 15;
    public static final int[] v1;
    public static final int v2 = 15;
    public static final int v3 = 20;
    public static final int w = 0;
    public static final int w0 = 18;
    public static final int w1 = 0;
    public static final int w2 = 16;
    public static final int w3 = 22;
    public static final int[] x;
    public static final int x0 = 19;
    public static final int x1 = 1;
    public static final int[] x2;
    public static final int x3 = 23;
    public static final int[] y;
    public static final int[] y0;
    public static final int y1 = 2;
    public static final int y2 = 0;
    public static final int y3 = 24;
    public static final int z = 0;
    public static final int z0 = 0;
    public static final int z1 = 3;
    public static final int z2 = 1;
    public static final int z3 = 25;
    
    static {
        a = new int[] { 2130968752, 2130968759, 2130968760, 2130968979, 2130968980, 2130968981, 2130968982, 2130968983, 2130968984, 2130969023, 2130969058, 2130969059, 2130969101, 2130969220, 2130969227, 2130969237, 2130969238, 2130969243, 2130969265, 2130969290, 2130969430, 2130969575, 2130969642, 2130969665, 2130969666, 2130969864, 2130969869, 2130970007, 2130970021 };
        t = new int[] { 16842931 };
        v = new int[] { 16843071 };
        x = new int[0];
        y = new int[] { 2130968752, 2130968759, 2130968916, 2130969220, 2130969869, 2130970021 };
        E = new int[] { 2130969130, 2130969271 };
        F = new int[] { 16842994, 2130968819, 2130968820, 2130969419, 2130969420, 2130969570, 2130969787, 2130969801 };
        O = new int[0];
        P = new int[] { 16843033, 2130969835, 2130970005, 2130970006 };
        T = new int[] { 16843074, 2130970000, 2130970001, 2130970002 };
        Y = new int[] { 16842804, 16843117, 16843118, 16843119, 16843120, 16843666, 16843667 };
        g0 = new int[] { 16842804, 2130968745, 2130968746, 2130968747, 2130968748, 2130968749, 2130969080, 2130969081, 2130969082, 2130969083, 2130969085, 2130969086, 2130969087, 2130969088, 2130969105, 2130969162, 2130969195, 2130969204, 2130969324, 2130969412, 2130969919, 2130969975 };
        y0 = $d2j$hex$ca1d819c$decode_I("57000101ae0001010d00047f0e00047f0f00047f1000047f1100047f1200047f1300047f1400047f1500047f1600047f1700047f1800047f1900047f1b00047f1c00047f1d00047f1e00047f1f00047f2000047f2100047f2200047f2300047f2400047f2500047f2600047f2700047f2800047f2900047f2a00047f2b00047f2c00047f2d00047f3200047f8f00047f9000047f9100047f9200047fa800047fd900047fec00047fed00047fee00047fef00047ff000047ff600047ff700047f1601047f2001047f6101047f6201047f6301047f6501047f6601047f6701047f6801047f7901047f7b01047f8601047fa201047fd801047fdd01047fde01047fe501047fea01047f0402047f0502047f0902047f0a02047f0c02047f9502047faa02047f4703047f4803047f4903047f4a03047f4d03047f4e03047f4f03047f5003047f5103047f5203047f5303047f5403047f5503047f0604047f0704047f0804047f2904047f2b04047f4a04047f4d04047f4e04047f4f04047f9a04047f9f04047fa104047fa204047fdf04047fe004047f1a05047f5605047f5805047f5905047f5a05047f5c05047f5d05047f5e05047f5f05047f6b05047f6c05047fa805047fa905047fb005047fb105047fef05047ffe05047fff05047f0006047f0106047f0206047f0306047f0406047f0506047f0606047f0706047f");
        N0 = new int[] { 2130968726 };
        P0 = new int[] { 16843016, 2130968851, 2130968852, 2130968853 };
        U0 = new int[] { 16843015, 2130968817, 2130968824, 2130968825 };
        Z0 = new int[] { 2130968739, 2130968740, 2130968769, 2130968928, 2130969084, 2130969210, 2130969822, 2130969987 };
        a1 = new int[] { 16842927, 16842948, 16843046, 16843047, 16843048, 2130969059, 2130969064, 2130969508, 2130969781 };
        k1 = new int[] { 16842931, 16842996, 16842997, 16843137 };
        l1 = new int[] { 16843436, 16843437 };
        o1 = new int[] { 16842766, 16842960, 16843156, 16843230, 16843231, 16843232 };
        v1 = new int[] { 16842754, 16842766, 16842960, 16843014, 16843156, 16843230, 16843231, 16843233, 16843234, 16843235, 16843236, 16843237, 16843375, 2130968602, 2130968622, 2130968624, 2130968728, 2130968978, 2130969251, 2130969252, 2130969584, 2130969779, 2130970035 };
        T1 = new int[] { 16842926, 16843052, 16843053, 16843054, 16843055, 16843056, 16843057, 2130969658, 2130969858 };
        Y1 = new int[] { 16843126, 16843465, 2130969595 };
        b2 = new int[] { 2130969845 };
        c2 = new int[] { 2130969597, 2130969604 };
        f2 = new int[] { 16842970, 16843039, 16843296, 16843364, 2130968909, 2130968969, 2130969039, 2130969212, 2130969253, 2130969327, 2130969671, 2130969672, 2130969752, 2130969753, 2130969863, 2130969873, 2130970101 };
        x2 = new int[] { 16842930, 16843126, 16843131, 16843362, 2130969642 };
        D2 = new int[] { 16843044, 16843045, 16843074, 2130969786, 2130969829, 2130969878, 2130969879, 2130969883, 2130969993, 2130969995, 2130969996, 2130970041, 2130970051, 2130970052 };
        S2 = new int[] { 16842901, 16842902, 16842903, 16842904, 16842906, 16842907, 16843105, 16843106, 16843107, 16843108, 16843692, 16844165, 2130969195, 2130969204, 2130969919, 2130969975 };
        d3 = new int[] { 16842927, 16843072, 2130968818, 2130968917, 2130968918, 2130968979, 2130968980, 2130968981, 2130968982, 2130968983, 2130968984, 2130969129, 2130969430, 2130969432, 2130969433, 2130969498, 2130969509, 2130969572, 2130969573, 2130969642, 2130969864, 2130969866, 2130969867, 2130969868, 2130970007, 2130970011, 2130970012, 2130970013, 2130970014, 2130970015, 2130970016, 2130970017, 2130970019, 2130970020, 2130970022 };
        H3 = new int[] { 16842752, 16842970, 2130969599, 2130969603, 2130969985 };
        K3 = new int[] { 16842964, 2130968761, 2130968762 };
        O3 = new int[] { 16842960, 16842994, 16842995 };
    }
    
    private static long[] $d2j$hex$ca1d819c$decode_J(final String src) {
        final byte[] d = $d2j$hex$ca1d819c$decode_B(src);
        final ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        final LongBuffer s = b.asLongBuffer();
        final long[] data = new long[d.length / 8];
        s.get(data);
        return data;
    }
    
    private static int[] $d2j$hex$ca1d819c$decode_I(final String src) {
        final byte[] d = $d2j$hex$ca1d819c$decode_B(src);
        final ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        final IntBuffer s = b.asIntBuffer();
        final int[] data = new int[d.length / 4];
        s.get(data);
        return data;
    }
    
    private static short[] $d2j$hex$ca1d819c$decode_S(final String src) {
        final byte[] d = $d2j$hex$ca1d819c$decode_B(src);
        final ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        final ShortBuffer s = b.asShortBuffer();
        final short[] data = new short[d.length / 2];
        s.get(data);
        return data;
    }
    
    private static byte[] $d2j$hex$ca1d819c$decode_B(final String src) {
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
