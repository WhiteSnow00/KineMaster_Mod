// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import java.util.Locale;
import android.content.res.XmlResourceParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.ViewGroup$LayoutParams;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;
import java.util.Arrays;
import android.view.View;
import android.util.AttributeSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import androidx.constraintlayout.motion.widget.MotionLayout;
import android.util.Log;
import android.content.Context;
import android.content.res.TypedArray;
import java.util.HashMap;
import android.util.SparseIntArray;

public class c
{
    private static final int[] h;
    private static SparseIntArray i;
    private static SparseIntArray j;
    private boolean a;
    public String b;
    public String c;
    public int d;
    private HashMap<String, ConstraintAttribute> e;
    private boolean f;
    private HashMap<Integer, a> g;
    
    static {
        h = new int[] { 0, 4, 8 };
        c.i = new SparseIntArray();
        c.j = new SparseIntArray();
        c.i.append(androidx.constraintlayout.widget.h.A0, 25);
        c.i.append(androidx.constraintlayout.widget.h.B0, 26);
        c.i.append(androidx.constraintlayout.widget.h.D0, 29);
        c.i.append(androidx.constraintlayout.widget.h.E0, 30);
        c.i.append(androidx.constraintlayout.widget.h.K0, 36);
        c.i.append(androidx.constraintlayout.widget.h.J0, 35);
        c.i.append(androidx.constraintlayout.widget.h.h0, 4);
        c.i.append(androidx.constraintlayout.widget.h.g0, 3);
        c.i.append(androidx.constraintlayout.widget.h.c0, 1);
        c.i.append(androidx.constraintlayout.widget.h.e0, 91);
        c.i.append(androidx.constraintlayout.widget.h.d0, 92);
        c.i.append(androidx.constraintlayout.widget.h.T0, 6);
        c.i.append(androidx.constraintlayout.widget.h.U0, 7);
        c.i.append(androidx.constraintlayout.widget.h.o0, 17);
        c.i.append(androidx.constraintlayout.widget.h.p0, 18);
        c.i.append(androidx.constraintlayout.widget.h.q0, 19);
        c.i.append(androidx.constraintlayout.widget.h.Y, 99);
        c.i.append(androidx.constraintlayout.widget.h.u, 27);
        c.i.append(androidx.constraintlayout.widget.h.F0, 32);
        c.i.append(androidx.constraintlayout.widget.h.G0, 33);
        c.i.append(androidx.constraintlayout.widget.h.n0, 10);
        c.i.append(androidx.constraintlayout.widget.h.m0, 9);
        c.i.append(androidx.constraintlayout.widget.h.X0, 13);
        c.i.append(androidx.constraintlayout.widget.h.a1, 16);
        c.i.append(androidx.constraintlayout.widget.h.Y0, 14);
        c.i.append(androidx.constraintlayout.widget.h.V0, 11);
        c.i.append(androidx.constraintlayout.widget.h.Z0, 15);
        c.i.append(androidx.constraintlayout.widget.h.W0, 12);
        c.i.append(androidx.constraintlayout.widget.h.N0, 40);
        c.i.append(androidx.constraintlayout.widget.h.y0, 39);
        c.i.append(androidx.constraintlayout.widget.h.x0, 41);
        c.i.append(androidx.constraintlayout.widget.h.M0, 42);
        c.i.append(androidx.constraintlayout.widget.h.w0, 20);
        c.i.append(androidx.constraintlayout.widget.h.L0, 37);
        c.i.append(androidx.constraintlayout.widget.h.l0, 5);
        c.i.append(androidx.constraintlayout.widget.h.z0, 87);
        c.i.append(androidx.constraintlayout.widget.h.I0, 87);
        c.i.append(androidx.constraintlayout.widget.h.C0, 87);
        c.i.append(androidx.constraintlayout.widget.h.f0, 87);
        c.i.append(androidx.constraintlayout.widget.h.b0, 87);
        c.i.append(androidx.constraintlayout.widget.h.z, 24);
        c.i.append(androidx.constraintlayout.widget.h.B, 28);
        c.i.append(androidx.constraintlayout.widget.h.N, 31);
        c.i.append(androidx.constraintlayout.widget.h.O, 8);
        c.i.append(androidx.constraintlayout.widget.h.A, 34);
        c.i.append(androidx.constraintlayout.widget.h.C, 2);
        c.i.append(androidx.constraintlayout.widget.h.x, 23);
        c.i.append(androidx.constraintlayout.widget.h.y, 21);
        c.i.append(androidx.constraintlayout.widget.h.O0, 95);
        c.i.append(androidx.constraintlayout.widget.h.r0, 96);
        c.i.append(androidx.constraintlayout.widget.h.w, 22);
        c.i.append(androidx.constraintlayout.widget.h.D, 43);
        c.i.append(androidx.constraintlayout.widget.h.Q, 44);
        c.i.append(androidx.constraintlayout.widget.h.L, 45);
        c.i.append(androidx.constraintlayout.widget.h.M, 46);
        c.i.append(androidx.constraintlayout.widget.h.K, 60);
        c.i.append(androidx.constraintlayout.widget.h.I, 47);
        c.i.append(androidx.constraintlayout.widget.h.J, 48);
        c.i.append(androidx.constraintlayout.widget.h.E, 49);
        c.i.append(androidx.constraintlayout.widget.h.F, 50);
        c.i.append(androidx.constraintlayout.widget.h.G, 51);
        c.i.append(androidx.constraintlayout.widget.h.H, 52);
        c.i.append(androidx.constraintlayout.widget.h.P, 53);
        c.i.append(androidx.constraintlayout.widget.h.P0, 54);
        c.i.append(androidx.constraintlayout.widget.h.s0, 55);
        c.i.append(androidx.constraintlayout.widget.h.Q0, 56);
        c.i.append(androidx.constraintlayout.widget.h.t0, 57);
        c.i.append(androidx.constraintlayout.widget.h.R0, 58);
        c.i.append(androidx.constraintlayout.widget.h.u0, 59);
        c.i.append(androidx.constraintlayout.widget.h.i0, 61);
        c.i.append(androidx.constraintlayout.widget.h.k0, 62);
        c.i.append(androidx.constraintlayout.widget.h.j0, 63);
        c.i.append(androidx.constraintlayout.widget.h.R, 64);
        c.i.append(androidx.constraintlayout.widget.h.k1, 65);
        c.i.append(androidx.constraintlayout.widget.h.X, 66);
        c.i.append(androidx.constraintlayout.widget.h.l1, 67);
        c.i.append(androidx.constraintlayout.widget.h.d1, 79);
        c.i.append(androidx.constraintlayout.widget.h.v, 38);
        c.i.append(androidx.constraintlayout.widget.h.c1, 68);
        c.i.append(androidx.constraintlayout.widget.h.S0, 69);
        c.i.append(androidx.constraintlayout.widget.h.v0, 70);
        c.i.append(androidx.constraintlayout.widget.h.b1, 97);
        c.i.append(androidx.constraintlayout.widget.h.V, 71);
        c.i.append(androidx.constraintlayout.widget.h.T, 72);
        c.i.append(androidx.constraintlayout.widget.h.U, 73);
        c.i.append(androidx.constraintlayout.widget.h.W, 74);
        c.i.append(androidx.constraintlayout.widget.h.S, 75);
        c.i.append(androidx.constraintlayout.widget.h.e1, 76);
        c.i.append(androidx.constraintlayout.widget.h.H0, 77);
        c.i.append(androidx.constraintlayout.widget.h.m1, 78);
        c.i.append(androidx.constraintlayout.widget.h.a0, 80);
        c.i.append(androidx.constraintlayout.widget.h.Z, 81);
        c.i.append(androidx.constraintlayout.widget.h.f1, 82);
        c.i.append(androidx.constraintlayout.widget.h.j1, 83);
        c.i.append(androidx.constraintlayout.widget.h.i1, 84);
        c.i.append(androidx.constraintlayout.widget.h.h1, 85);
        c.i.append(androidx.constraintlayout.widget.h.g1, 86);
        final SparseIntArray j = c.j;
        final int r3 = androidx.constraintlayout.widget.h.R3;
        j.append(r3, 6);
        c.j.append(r3, 7);
        c.j.append(androidx.constraintlayout.widget.h.M2, 27);
        c.j.append(androidx.constraintlayout.widget.h.U3, 13);
        c.j.append(androidx.constraintlayout.widget.h.X3, 16);
        c.j.append(androidx.constraintlayout.widget.h.V3, 14);
        c.j.append(androidx.constraintlayout.widget.h.S3, 11);
        c.j.append(androidx.constraintlayout.widget.h.W3, 15);
        c.j.append(androidx.constraintlayout.widget.h.T3, 12);
        c.j.append(androidx.constraintlayout.widget.h.L3, 40);
        c.j.append(androidx.constraintlayout.widget.h.E3, 39);
        c.j.append(androidx.constraintlayout.widget.h.D3, 41);
        c.j.append(androidx.constraintlayout.widget.h.K3, 42);
        c.j.append(androidx.constraintlayout.widget.h.C3, 20);
        c.j.append(androidx.constraintlayout.widget.h.J3, 37);
        c.j.append(androidx.constraintlayout.widget.h.w3, 5);
        c.j.append(androidx.constraintlayout.widget.h.F3, 87);
        c.j.append(androidx.constraintlayout.widget.h.I3, 87);
        c.j.append(androidx.constraintlayout.widget.h.G3, 87);
        c.j.append(androidx.constraintlayout.widget.h.t3, 87);
        c.j.append(androidx.constraintlayout.widget.h.s3, 87);
        c.j.append(androidx.constraintlayout.widget.h.R2, 24);
        c.j.append(androidx.constraintlayout.widget.h.T2, 28);
        c.j.append(androidx.constraintlayout.widget.h.f3, 31);
        c.j.append(androidx.constraintlayout.widget.h.g3, 8);
        c.j.append(androidx.constraintlayout.widget.h.S2, 34);
        c.j.append(androidx.constraintlayout.widget.h.U2, 2);
        c.j.append(androidx.constraintlayout.widget.h.P2, 23);
        c.j.append(androidx.constraintlayout.widget.h.Q2, 21);
        c.j.append(androidx.constraintlayout.widget.h.M3, 95);
        c.j.append(androidx.constraintlayout.widget.h.x3, 96);
        c.j.append(androidx.constraintlayout.widget.h.O2, 22);
        c.j.append(androidx.constraintlayout.widget.h.V2, 43);
        c.j.append(androidx.constraintlayout.widget.h.i3, 44);
        c.j.append(androidx.constraintlayout.widget.h.d3, 45);
        c.j.append(androidx.constraintlayout.widget.h.e3, 46);
        c.j.append(androidx.constraintlayout.widget.h.c3, 60);
        c.j.append(androidx.constraintlayout.widget.h.a3, 47);
        c.j.append(androidx.constraintlayout.widget.h.b3, 48);
        c.j.append(androidx.constraintlayout.widget.h.W2, 49);
        c.j.append(androidx.constraintlayout.widget.h.X2, 50);
        c.j.append(androidx.constraintlayout.widget.h.Y2, 51);
        c.j.append(androidx.constraintlayout.widget.h.Z2, 52);
        c.j.append(androidx.constraintlayout.widget.h.h3, 53);
        c.j.append(androidx.constraintlayout.widget.h.N3, 54);
        c.j.append(androidx.constraintlayout.widget.h.y3, 55);
        c.j.append(androidx.constraintlayout.widget.h.O3, 56);
        c.j.append(androidx.constraintlayout.widget.h.z3, 57);
        c.j.append(androidx.constraintlayout.widget.h.P3, 58);
        c.j.append(androidx.constraintlayout.widget.h.A3, 59);
        c.j.append(androidx.constraintlayout.widget.h.v3, 62);
        c.j.append(androidx.constraintlayout.widget.h.u3, 63);
        c.j.append(androidx.constraintlayout.widget.h.j3, 64);
        c.j.append(androidx.constraintlayout.widget.h.i4, 65);
        c.j.append(androidx.constraintlayout.widget.h.p3, 66);
        c.j.append(androidx.constraintlayout.widget.h.j4, 67);
        c.j.append(androidx.constraintlayout.widget.h.a4, 79);
        c.j.append(androidx.constraintlayout.widget.h.N2, 38);
        c.j.append(androidx.constraintlayout.widget.h.b4, 98);
        c.j.append(androidx.constraintlayout.widget.h.Z3, 68);
        c.j.append(androidx.constraintlayout.widget.h.Q3, 69);
        c.j.append(androidx.constraintlayout.widget.h.B3, 70);
        c.j.append(androidx.constraintlayout.widget.h.n3, 71);
        c.j.append(androidx.constraintlayout.widget.h.l3, 72);
        c.j.append(androidx.constraintlayout.widget.h.m3, 73);
        c.j.append(androidx.constraintlayout.widget.h.o3, 74);
        c.j.append(androidx.constraintlayout.widget.h.k3, 75);
        c.j.append(androidx.constraintlayout.widget.h.c4, 76);
        c.j.append(androidx.constraintlayout.widget.h.H3, 77);
        c.j.append(androidx.constraintlayout.widget.h.k4, 78);
        c.j.append(androidx.constraintlayout.widget.h.r3, 80);
        c.j.append(androidx.constraintlayout.widget.h.q3, 81);
        c.j.append(androidx.constraintlayout.widget.h.d4, 82);
        c.j.append(androidx.constraintlayout.widget.h.h4, 83);
        c.j.append(androidx.constraintlayout.widget.h.g4, 84);
        c.j.append(androidx.constraintlayout.widget.h.f4, 85);
        c.j.append(androidx.constraintlayout.widget.h.e4, 86);
        c.j.append(androidx.constraintlayout.widget.h.Y3, 97);
    }
    
    public c() {
        this.c = "";
        this.d = 0;
        this.e = new HashMap<String, ConstraintAttribute>();
        this.f = true;
        this.g = new HashMap<Integer, a>();
    }
    
    static void A(final Object o, final TypedArray typedArray, int n, final int n2) {
        if (o == null) {
            return;
        }
        final int type = typedArray.peekValue(n).type;
        if (type != 3) {
            final int n3 = -2;
            boolean b = false;
            if (type != 5) {
                n = typedArray.getInt(n, 0);
                if (n != -4) {
                    if (n == -3 || (n != -2 && n != -1)) {
                        n = 0;
                    }
                }
                else {
                    b = true;
                    n = n3;
                }
            }
            else {
                n = typedArray.getDimensionPixelSize(n, 0);
            }
            if (o instanceof ConstraintLayout.b) {
                final ConstraintLayout.b b2 = (ConstraintLayout.b)o;
                if (n2 == 0) {
                    b2.width = n;
                    b2.a0 = b;
                }
                else {
                    b2.height = n;
                    b2.b0 = b;
                }
            }
            else if (o instanceof b) {
                final b b3 = (b)o;
                if (n2 == 0) {
                    b3.d = n;
                    b3.n0 = b;
                }
                else {
                    b3.e = n;
                    b3.o0 = b;
                }
            }
            else if (o instanceof a.a) {
                final a.a a = (a.a)o;
                if (n2 == 0) {
                    a.b(23, n);
                    a.d(80, b);
                }
                else {
                    a.b(21, n);
                    a.d(81, b);
                }
            }
            return;
        }
        B(o, typedArray.getString(n), n2);
    }
    
    static void B(final Object o, String a, final int n) {
        if (a == null) {
            return;
        }
        final int index = a.indexOf(61);
        final int length = a.length();
        if (index <= 0 || index >= length - 1) {
            return;
        }
        final String substring = a.substring(0, index);
        a = a.substring(index + 1);
        if (a.length() <= 0) {
            return;
        }
        final String trim = substring.trim();
        a = a.trim();
        Label_0305: {
            if ("ratio".equalsIgnoreCase(trim)) {
                if (o instanceof ConstraintLayout.b) {
                    final ConstraintLayout.b b = (ConstraintLayout.b)o;
                    if (n == 0) {
                        b.width = 0;
                    }
                    else {
                        b.height = 0;
                    }
                    C(b, a);
                    return;
                }
                if (o instanceof b) {
                    ((b)o).A = a;
                    return;
                }
                if (o instanceof a.a) {
                    ((a.a)o).c(5, a);
                }
                return;
            }
            else if (!"weight".equalsIgnoreCase(trim)) {
                break Label_0305;
            }
            try {
                final float float1 = Float.parseFloat(a);
                if (o instanceof ConstraintLayout.b) {
                    final ConstraintLayout.b b2 = (ConstraintLayout.b)o;
                    if (n == 0) {
                        b2.width = 0;
                        b2.L = float1;
                    }
                    else {
                        b2.height = 0;
                        b2.M = float1;
                    }
                }
                else if (o instanceof b) {
                    final b b3 = (b)o;
                    if (n == 0) {
                        b3.d = 0;
                        b3.W = float1;
                    }
                    else {
                        b3.e = 0;
                        b3.V = float1;
                    }
                }
                else if (o instanceof a.a) {
                    final a.a a2 = (a.a)o;
                    if (n == 0) {
                        a2.b(23, 0);
                        a2.a(39, float1);
                    }
                    else {
                        a2.b(21, 0);
                        a2.a(40, float1);
                    }
                }
                Label_0480: {
                    return;
                }
                ConstraintLayout.b b4 = null;
                Label_0363:
                b4.height = 0;
                float max = 0.0f;
                b4.W = max;
                b4.Q = 2;
                return;
                while (true) {
                    Block_23: {
                        while (true) {
                        Block_20_Outer:
                            while (true) {
                                final b b5;
                                b5.d = 0;
                                b5.f0 = max;
                                b5.Z = 2;
                                return;
                                while (true) {
                                    b4.width = 0;
                                    b4.V = max;
                                    b4.P = 2;
                                    return;
                                    Label_0433:
                                    iftrue(Label_0480:)(!(o instanceof a.a));
                                    break Block_23;
                                    max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(a)));
                                    iftrue(Label_0381:)(!(o instanceof ConstraintLayout.b));
                                    b4 = (ConstraintLayout.b)o;
                                    iftrue(Label_0363:)(n != 0);
                                    continue;
                                }
                                Label_0415:
                                b5.e = 0;
                                b5.g0 = max;
                                b5.a0 = 2;
                                return;
                                final a.a a3;
                                Label_0466:
                                a3.b(21, 0);
                                a3.b(55, 2);
                                return;
                                b5 = (b)o;
                                iftrue(Label_0415:)(n != 0);
                                continue Block_20_Outer;
                            }
                            iftrue(Label_0480:)(!"parent".equalsIgnoreCase(trim));
                            continue;
                        }
                    }
                    final a.a a3 = (a.a)o;
                    iftrue(Label_0466:)(n != 0);
                    a3.b(23, 0);
                    a3.b(54, 2);
                    return;
                    Label_0381:
                    iftrue(Label_0433:)(!(o instanceof b));
                    continue;
                }
            }
            catch (final NumberFormatException ex) {}
        }
    }
    
    static void C(final ConstraintLayout.b b, final String i) {
        final float n = Float.NaN;
        final int n2 = -1;
        float j = n;
        int k = n2;
        while (true) {
            if (i == null) {
                break Label_0294;
            }
            final int length = i.length();
            final int index = i.indexOf(44);
            final int n3 = 0;
            int n4 = n2;
            int n5 = n3;
            if (index > 0) {
                n4 = n2;
                n5 = n3;
                if (index < length - 1) {
                    final String substring = i.substring(0, index);
                    if (substring.equalsIgnoreCase("W")) {
                        n4 = 0;
                    }
                    else {
                        n4 = n2;
                        if (substring.equalsIgnoreCase("H")) {
                            n4 = 1;
                        }
                    }
                    n5 = index + 1;
                }
            }
            final int index2 = i.indexOf(58);
            Label_0262: {
                if (index2 < 0 || index2 >= length - 1) {
                    break Label_0262;
                }
                final String substring2 = i.substring(n5, index2);
                final String substring3 = i.substring(index2 + 1);
                j = n;
                k = n4;
                if (substring2.length() <= 0) {
                    break Label_0294;
                }
                j = n;
                k = n4;
                if (substring3.length() <= 0) {
                    break Label_0294;
                }
                try {
                    final float float1 = Float.parseFloat(substring2);
                    final float float2 = Float.parseFloat(substring3);
                    j = n;
                    k = n4;
                    if (float1 > 0.0f) {
                        j = n;
                        k = n4;
                        if (float2 > 0.0f) {
                            if (n4 == 1) {
                                j = Math.abs(float2 / float1);
                                k = n4;
                            }
                            else {
                                j = Math.abs(float1 / float2);
                                k = n4;
                            }
                        }
                    }
                    b.I = i;
                    b.J = j;
                    b.K = k;
                    return;
                    final String substring4 = i.substring(n5);
                    j = n;
                    k = n4;
                    iftrue(Label_0294:)(substring4.length() <= 0);
                    j = Float.parseFloat(substring4);
                    k = n4;
                    continue;
                }
                catch (final NumberFormatException ex) {
                    j = n;
                    k = n4;
                    continue;
                }
            }
            break;
        }
    }
    
    private void D(final Context context, final a a, final TypedArray typedArray, final boolean b) {
        if (b) {
            E(context, a, typedArray);
            return;
        }
        for (int indexCount = typedArray.getIndexCount(), i = 0; i < indexCount; ++i) {
            final int index = typedArray.getIndex(i);
            if (index != androidx.constraintlayout.widget.h.v && androidx.constraintlayout.widget.h.N != index && androidx.constraintlayout.widget.h.O != index) {
                a.d.a = true;
                a.e.b = true;
                a.c.a = true;
                a.f.a = true;
            }
            switch (androidx.constraintlayout.widget.c.i.get(index)) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown attribute 0x");
                    sb.append(Integer.toHexString(index));
                    sb.append("   ");
                    sb.append(androidx.constraintlayout.widget.c.i.get(index));
                    Log.w("ConstraintSet", sb.toString());
                    break;
                }
                case 97: {
                    final b e = a.e;
                    e.q0 = typedArray.getInt(index, e.q0);
                    break;
                }
                case 96: {
                    A(a.e, typedArray, index, 1);
                    break;
                }
                case 95: {
                    A(a.e, typedArray, index, 0);
                    break;
                }
                case 94: {
                    final b e2 = a.e;
                    e2.U = typedArray.getDimensionPixelSize(index, e2.U);
                    break;
                }
                case 93: {
                    final b e3 = a.e;
                    e3.N = typedArray.getDimensionPixelSize(index, e3.N);
                    break;
                }
                case 92: {
                    final b e4 = a.e;
                    e4.t = z(typedArray, index, e4.t);
                    break;
                }
                case 91: {
                    final b e5 = a.e;
                    e5.s = z(typedArray, index, e5.s);
                    break;
                }
                case 87: {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("unused attribute 0x");
                    sb2.append(Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(androidx.constraintlayout.widget.c.i.get(index));
                    Log.w("ConstraintSet", sb2.toString());
                    break;
                }
                case 86: {
                    final int type = typedArray.peekValue(index).type;
                    if (type == 1) {
                        a.d.n = typedArray.getResourceId(index, -1);
                        final c d = a.d;
                        if (d.n != -1) {
                            d.m = -2;
                            break;
                        }
                        break;
                    }
                    else {
                        if (type != 3) {
                            final c d2 = a.d;
                            d2.m = typedArray.getInteger(index, d2.n);
                            break;
                        }
                        a.d.l = typedArray.getString(index);
                        if (a.d.l.indexOf("/") > 0) {
                            a.d.n = typedArray.getResourceId(index, -1);
                            a.d.m = -2;
                            break;
                        }
                        a.d.m = -1;
                        break;
                    }
                    break;
                }
                case 85: {
                    final c d3 = a.d;
                    d3.j = typedArray.getFloat(index, d3.j);
                    break;
                }
                case 84: {
                    final c d4 = a.d;
                    d4.k = typedArray.getInteger(index, d4.k);
                    break;
                }
                case 83: {
                    final e f = a.f;
                    f.i = z(typedArray, index, f.i);
                    break;
                }
                case 82: {
                    final c d5 = a.d;
                    d5.c = typedArray.getInteger(index, d5.c);
                    break;
                }
                case 81: {
                    final b e6 = a.e;
                    e6.o0 = typedArray.getBoolean(index, e6.o0);
                    break;
                }
                case 80: {
                    final b e7 = a.e;
                    e7.n0 = typedArray.getBoolean(index, e7.n0);
                    break;
                }
                case 79: {
                    final c d6 = a.d;
                    d6.g = typedArray.getFloat(index, d6.g);
                    break;
                }
                case 78: {
                    final d c = a.c;
                    c.c = typedArray.getInt(index, c.c);
                    break;
                }
                case 77: {
                    a.e.m0 = typedArray.getString(index);
                    break;
                }
                case 76: {
                    final c d7 = a.d;
                    d7.e = typedArray.getInt(index, d7.e);
                    break;
                }
                case 75: {
                    final b e8 = a.e;
                    e8.p0 = typedArray.getBoolean(index, e8.p0);
                    break;
                }
                case 74: {
                    a.e.l0 = typedArray.getString(index);
                    break;
                }
                case 73: {
                    final b e9 = a.e;
                    e9.i0 = typedArray.getDimensionPixelSize(index, e9.i0);
                    break;
                }
                case 72: {
                    final b e10 = a.e;
                    e10.h0 = typedArray.getInt(index, e10.h0);
                    break;
                }
                case 71: {
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                }
                case 70: {
                    a.e.g0 = typedArray.getFloat(index, 1.0f);
                    break;
                }
                case 69: {
                    a.e.f0 = typedArray.getFloat(index, 1.0f);
                    break;
                }
                case 68: {
                    final d c2 = a.c;
                    c2.e = typedArray.getFloat(index, c2.e);
                    break;
                }
                case 67: {
                    final c d8 = a.d;
                    d8.i = typedArray.getFloat(index, d8.i);
                    break;
                }
                case 66: {
                    a.d.f = typedArray.getInt(index, 0);
                    break;
                }
                case 65: {
                    if (typedArray.peekValue(index).type == 3) {
                        a.d.d = typedArray.getString(index);
                        break;
                    }
                    a.d.d = o.c.c[typedArray.getInteger(index, 0)];
                    break;
                }
                case 64: {
                    final c d9 = a.d;
                    d9.b = z(typedArray, index, d9.b);
                    break;
                }
                case 63: {
                    final b e11 = a.e;
                    e11.D = typedArray.getFloat(index, e11.D);
                    break;
                }
                case 62: {
                    final b e12 = a.e;
                    e12.C = typedArray.getDimensionPixelSize(index, e12.C);
                    break;
                }
                case 61: {
                    final b e13 = a.e;
                    e13.B = z(typedArray, index, e13.B);
                    break;
                }
                case 60: {
                    final e f2 = a.f;
                    f2.b = typedArray.getFloat(index, f2.b);
                    break;
                }
                case 59: {
                    final b e14 = a.e;
                    e14.e0 = typedArray.getDimensionPixelSize(index, e14.e0);
                    break;
                }
                case 58: {
                    final b e15 = a.e;
                    e15.d0 = typedArray.getDimensionPixelSize(index, e15.d0);
                    break;
                }
                case 57: {
                    final b e16 = a.e;
                    e16.c0 = typedArray.getDimensionPixelSize(index, e16.c0);
                    break;
                }
                case 56: {
                    final b e17 = a.e;
                    e17.b0 = typedArray.getDimensionPixelSize(index, e17.b0);
                    break;
                }
                case 55: {
                    final b e18 = a.e;
                    e18.a0 = typedArray.getInt(index, e18.a0);
                    break;
                }
                case 54: {
                    final b e19 = a.e;
                    e19.Z = typedArray.getInt(index, e19.Z);
                    break;
                }
                case 53: {
                    final e f3 = a.f;
                    f3.l = typedArray.getDimension(index, f3.l);
                    break;
                }
                case 52: {
                    final e f4 = a.f;
                    f4.k = typedArray.getDimension(index, f4.k);
                    break;
                }
                case 51: {
                    final e f5 = a.f;
                    f5.j = typedArray.getDimension(index, f5.j);
                    break;
                }
                case 50: {
                    final e f6 = a.f;
                    f6.h = typedArray.getDimension(index, f6.h);
                    break;
                }
                case 49: {
                    final e f7 = a.f;
                    f7.g = typedArray.getDimension(index, f7.g);
                    break;
                }
                case 48: {
                    final e f8 = a.f;
                    f8.f = typedArray.getFloat(index, f8.f);
                    break;
                }
                case 47: {
                    final e f9 = a.f;
                    f9.e = typedArray.getFloat(index, f9.e);
                    break;
                }
                case 46: {
                    final e f10 = a.f;
                    f10.d = typedArray.getFloat(index, f10.d);
                    break;
                }
                case 45: {
                    final e f11 = a.f;
                    f11.c = typedArray.getFloat(index, f11.c);
                    break;
                }
                case 44: {
                    final e f12 = a.f;
                    f12.m = true;
                    f12.n = typedArray.getDimension(index, f12.n);
                    break;
                }
                case 43: {
                    final d c3 = a.c;
                    c3.d = typedArray.getFloat(index, c3.d);
                    break;
                }
                case 42: {
                    final b e20 = a.e;
                    e20.Y = typedArray.getInt(index, e20.Y);
                    break;
                }
                case 41: {
                    final b e21 = a.e;
                    e21.X = typedArray.getInt(index, e21.X);
                    break;
                }
                case 40: {
                    final b e22 = a.e;
                    e22.V = typedArray.getFloat(index, e22.V);
                    break;
                }
                case 39: {
                    final b e23 = a.e;
                    e23.W = typedArray.getFloat(index, e23.W);
                    break;
                }
                case 38: {
                    a.a = typedArray.getResourceId(index, a.a);
                    break;
                }
                case 37: {
                    final b e24 = a.e;
                    e24.z = typedArray.getFloat(index, e24.z);
                    break;
                }
                case 36: {
                    final b e25 = a.e;
                    e25.n = z(typedArray, index, e25.n);
                    break;
                }
                case 35: {
                    final b e26 = a.e;
                    e26.o = z(typedArray, index, e26.o);
                    break;
                }
                case 34: {
                    final b e27 = a.e;
                    e27.J = typedArray.getDimensionPixelSize(index, e27.J);
                    break;
                }
                case 33: {
                    final b e28 = a.e;
                    e28.v = z(typedArray, index, e28.v);
                    break;
                }
                case 32: {
                    final b e29 = a.e;
                    e29.u = z(typedArray, index, e29.u);
                    break;
                }
                case 31: {
                    final b e30 = a.e;
                    e30.M = typedArray.getDimensionPixelSize(index, e30.M);
                    break;
                }
                case 30: {
                    final b e31 = a.e;
                    e31.m = z(typedArray, index, e31.m);
                    break;
                }
                case 29: {
                    final b e32 = a.e;
                    e32.l = z(typedArray, index, e32.l);
                    break;
                }
                case 28: {
                    final b e33 = a.e;
                    e33.I = typedArray.getDimensionPixelSize(index, e33.I);
                    break;
                }
                case 27: {
                    final b e34 = a.e;
                    e34.G = typedArray.getInt(index, e34.G);
                    break;
                }
                case 26: {
                    final b e35 = a.e;
                    e35.k = z(typedArray, index, e35.k);
                    break;
                }
                case 25: {
                    final b e36 = a.e;
                    e36.j = z(typedArray, index, e36.j);
                    break;
                }
                case 24: {
                    final b e37 = a.e;
                    e37.H = typedArray.getDimensionPixelSize(index, e37.H);
                    break;
                }
                case 23: {
                    final b e38 = a.e;
                    e38.d = typedArray.getLayoutDimension(index, e38.d);
                    break;
                }
                case 22: {
                    final d c4 = a.c;
                    c4.b = typedArray.getInt(index, c4.b);
                    final d c5 = a.c;
                    c5.b = androidx.constraintlayout.widget.c.h[c5.b];
                    break;
                }
                case 21: {
                    final b e39 = a.e;
                    e39.e = typedArray.getLayoutDimension(index, e39.e);
                    break;
                }
                case 20: {
                    final b e40 = a.e;
                    e40.y = typedArray.getFloat(index, e40.y);
                    break;
                }
                case 19: {
                    final b e41 = a.e;
                    e41.h = typedArray.getFloat(index, e41.h);
                    break;
                }
                case 18: {
                    final b e42 = a.e;
                    e42.g = typedArray.getDimensionPixelOffset(index, e42.g);
                    break;
                }
                case 17: {
                    final b e43 = a.e;
                    e43.f = typedArray.getDimensionPixelOffset(index, e43.f);
                    break;
                }
                case 16: {
                    final b e44 = a.e;
                    e44.P = typedArray.getDimensionPixelSize(index, e44.P);
                    break;
                }
                case 15: {
                    final b e45 = a.e;
                    e45.T = typedArray.getDimensionPixelSize(index, e45.T);
                    break;
                }
                case 14: {
                    final b e46 = a.e;
                    e46.Q = typedArray.getDimensionPixelSize(index, e46.Q);
                    break;
                }
                case 13: {
                    final b e47 = a.e;
                    e47.O = typedArray.getDimensionPixelSize(index, e47.O);
                    break;
                }
                case 12: {
                    final b e48 = a.e;
                    e48.S = typedArray.getDimensionPixelSize(index, e48.S);
                    break;
                }
                case 11: {
                    final b e49 = a.e;
                    e49.R = typedArray.getDimensionPixelSize(index, e49.R);
                    break;
                }
                case 10: {
                    final b e50 = a.e;
                    e50.w = z(typedArray, index, e50.w);
                    break;
                }
                case 9: {
                    final b e51 = a.e;
                    e51.x = z(typedArray, index, e51.x);
                    break;
                }
                case 8: {
                    final b e52 = a.e;
                    e52.L = typedArray.getDimensionPixelSize(index, e52.L);
                    break;
                }
                case 7: {
                    final b e53 = a.e;
                    e53.F = typedArray.getDimensionPixelOffset(index, e53.F);
                    break;
                }
                case 6: {
                    final b e54 = a.e;
                    e54.E = typedArray.getDimensionPixelOffset(index, e54.E);
                    break;
                }
                case 5: {
                    a.e.A = typedArray.getString(index);
                    break;
                }
                case 4: {
                    final b e55 = a.e;
                    e55.p = z(typedArray, index, e55.p);
                    break;
                }
                case 3: {
                    final b e56 = a.e;
                    e56.q = z(typedArray, index, e56.q);
                    break;
                }
                case 2: {
                    final b e57 = a.e;
                    e57.K = typedArray.getDimensionPixelSize(index, e57.K);
                    break;
                }
                case 1: {
                    final b e58 = a.e;
                    e58.r = z(typedArray, index, e58.r);
                    break;
                }
            }
        }
        final b e59 = a.e;
        if (e59.l0 != null) {
            e59.k0 = null;
        }
    }
    
    private static void E(final Context context, final a a, final TypedArray typedArray) {
        final int indexCount = typedArray.getIndexCount();
        final a.a h = new a.a();
        a.h = h;
        a.d.a = false;
        a.e.b = false;
        a.c.a = false;
        a.f.a = false;
        for (int i = 0; i < indexCount; ++i) {
            final int index = typedArray.getIndex(i);
            switch (c.j.get(index)) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown attribute 0x");
                    sb.append(Integer.toHexString(index));
                    sb.append("   ");
                    sb.append(c.i.get(index));
                    Log.w("ConstraintSet", sb.toString());
                    break;
                }
                case 99: {
                    h.d(99, typedArray.getBoolean(index, a.e.i));
                    break;
                }
                case 98: {
                    if (MotionLayout.E0) {
                        if ((a.a = typedArray.getResourceId(index, a.a)) == -1) {
                            a.b = typedArray.getString(index);
                            break;
                        }
                        break;
                    }
                    else {
                        if (typedArray.peekValue(index).type == 3) {
                            a.b = typedArray.getString(index);
                            break;
                        }
                        a.a = typedArray.getResourceId(index, a.a);
                        break;
                    }
                    break;
                }
                case 97: {
                    h.b(97, typedArray.getInt(index, a.e.q0));
                    break;
                }
                case 96: {
                    A(h, typedArray, index, 1);
                    break;
                }
                case 95: {
                    A(h, typedArray, index, 0);
                    break;
                }
                case 94: {
                    h.b(94, typedArray.getDimensionPixelSize(index, a.e.U));
                    break;
                }
                case 93: {
                    h.b(93, typedArray.getDimensionPixelSize(index, a.e.N));
                    break;
                }
                case 87: {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("unused attribute 0x");
                    sb2.append(Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(c.i.get(index));
                    Log.w("ConstraintSet", sb2.toString());
                    break;
                }
                case 86: {
                    final int type = typedArray.peekValue(index).type;
                    if (type == 1) {
                        h.b(89, a.d.n = typedArray.getResourceId(index, -1));
                        final c d = a.d;
                        if (d.n != -1) {
                            h.b(88, d.m = -2);
                            break;
                        }
                        break;
                    }
                    else {
                        if (type != 3) {
                            final c d2 = a.d;
                            d2.m = typedArray.getInteger(index, d2.n);
                            h.b(88, a.d.m);
                            break;
                        }
                        h.c(90, a.d.l = typedArray.getString(index));
                        if (a.d.l.indexOf("/") > 0) {
                            h.b(89, a.d.n = typedArray.getResourceId(index, -1));
                            h.b(88, a.d.m = -2);
                            break;
                        }
                        h.b(88, a.d.m = -1);
                        break;
                    }
                    break;
                }
                case 85: {
                    h.a(85, typedArray.getFloat(index, a.d.j));
                    break;
                }
                case 84: {
                    h.b(84, typedArray.getInteger(index, a.d.k));
                    break;
                }
                case 83: {
                    h.b(83, z(typedArray, index, a.f.i));
                    break;
                }
                case 82: {
                    h.b(82, typedArray.getInteger(index, a.d.c));
                    break;
                }
                case 81: {
                    h.d(81, typedArray.getBoolean(index, a.e.o0));
                    break;
                }
                case 80: {
                    h.d(80, typedArray.getBoolean(index, a.e.n0));
                    break;
                }
                case 79: {
                    h.a(79, typedArray.getFloat(index, a.d.g));
                    break;
                }
                case 78: {
                    h.b(78, typedArray.getInt(index, a.c.c));
                    break;
                }
                case 77: {
                    h.c(77, typedArray.getString(index));
                    break;
                }
                case 76: {
                    h.b(76, typedArray.getInt(index, a.d.e));
                    break;
                }
                case 75: {
                    h.d(75, typedArray.getBoolean(index, a.e.p0));
                    break;
                }
                case 74: {
                    h.c(74, typedArray.getString(index));
                    break;
                }
                case 73: {
                    h.b(73, typedArray.getDimensionPixelSize(index, a.e.i0));
                    break;
                }
                case 72: {
                    h.b(72, typedArray.getInt(index, a.e.h0));
                    break;
                }
                case 71: {
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                }
                case 70: {
                    h.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                }
                case 69: {
                    h.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                }
                case 68: {
                    h.a(68, typedArray.getFloat(index, a.c.e));
                    break;
                }
                case 67: {
                    h.a(67, typedArray.getFloat(index, a.d.i));
                    break;
                }
                case 66: {
                    h.b(66, typedArray.getInt(index, 0));
                    break;
                }
                case 65: {
                    if (typedArray.peekValue(index).type == 3) {
                        h.c(65, typedArray.getString(index));
                        break;
                    }
                    h.c(65, c.c[typedArray.getInteger(index, 0)]);
                    break;
                }
                case 64: {
                    h.b(64, z(typedArray, index, a.d.b));
                    break;
                }
                case 63: {
                    h.a(63, typedArray.getFloat(index, a.e.D));
                    break;
                }
                case 62: {
                    h.b(62, typedArray.getDimensionPixelSize(index, a.e.C));
                    break;
                }
                case 60: {
                    h.a(60, typedArray.getFloat(index, a.f.b));
                    break;
                }
                case 59: {
                    h.b(59, typedArray.getDimensionPixelSize(index, a.e.e0));
                    break;
                }
                case 58: {
                    h.b(58, typedArray.getDimensionPixelSize(index, a.e.d0));
                    break;
                }
                case 57: {
                    h.b(57, typedArray.getDimensionPixelSize(index, a.e.c0));
                    break;
                }
                case 56: {
                    h.b(56, typedArray.getDimensionPixelSize(index, a.e.b0));
                    break;
                }
                case 55: {
                    h.b(55, typedArray.getInt(index, a.e.a0));
                    break;
                }
                case 54: {
                    h.b(54, typedArray.getInt(index, a.e.Z));
                    break;
                }
                case 53: {
                    h.a(53, typedArray.getDimension(index, a.f.l));
                    break;
                }
                case 52: {
                    h.a(52, typedArray.getDimension(index, a.f.k));
                    break;
                }
                case 51: {
                    h.a(51, typedArray.getDimension(index, a.f.j));
                    break;
                }
                case 50: {
                    h.a(50, typedArray.getDimension(index, a.f.h));
                    break;
                }
                case 49: {
                    h.a(49, typedArray.getDimension(index, a.f.g));
                    break;
                }
                case 48: {
                    h.a(48, typedArray.getFloat(index, a.f.f));
                    break;
                }
                case 47: {
                    h.a(47, typedArray.getFloat(index, a.f.e));
                    break;
                }
                case 46: {
                    h.a(46, typedArray.getFloat(index, a.f.d));
                    break;
                }
                case 45: {
                    h.a(45, typedArray.getFloat(index, a.f.c));
                    break;
                }
                case 44: {
                    h.d(44, true);
                    h.a(44, typedArray.getDimension(index, a.f.n));
                    break;
                }
                case 43: {
                    h.a(43, typedArray.getFloat(index, a.c.d));
                    break;
                }
                case 42: {
                    h.b(42, typedArray.getInt(index, a.e.Y));
                    break;
                }
                case 41: {
                    h.b(41, typedArray.getInt(index, a.e.X));
                    break;
                }
                case 40: {
                    h.a(40, typedArray.getFloat(index, a.e.V));
                    break;
                }
                case 39: {
                    h.a(39, typedArray.getFloat(index, a.e.W));
                    break;
                }
                case 38: {
                    h.b(38, a.a = typedArray.getResourceId(index, a.a));
                    break;
                }
                case 37: {
                    h.a(37, typedArray.getFloat(index, a.e.z));
                    break;
                }
                case 34: {
                    h.b(34, typedArray.getDimensionPixelSize(index, a.e.J));
                    break;
                }
                case 31: {
                    h.b(31, typedArray.getDimensionPixelSize(index, a.e.M));
                    break;
                }
                case 28: {
                    h.b(28, typedArray.getDimensionPixelSize(index, a.e.I));
                    break;
                }
                case 27: {
                    h.b(27, typedArray.getInt(index, a.e.G));
                    break;
                }
                case 24: {
                    h.b(24, typedArray.getDimensionPixelSize(index, a.e.H));
                    break;
                }
                case 23: {
                    h.b(23, typedArray.getLayoutDimension(index, a.e.d));
                    break;
                }
                case 22: {
                    h.b(22, c.h[typedArray.getInt(index, a.c.b)]);
                    break;
                }
                case 21: {
                    h.b(21, typedArray.getLayoutDimension(index, a.e.e));
                    break;
                }
                case 20: {
                    h.a(20, typedArray.getFloat(index, a.e.y));
                    break;
                }
                case 19: {
                    h.a(19, typedArray.getFloat(index, a.e.h));
                    break;
                }
                case 18: {
                    h.b(18, typedArray.getDimensionPixelOffset(index, a.e.g));
                    break;
                }
                case 17: {
                    h.b(17, typedArray.getDimensionPixelOffset(index, a.e.f));
                    break;
                }
                case 16: {
                    h.b(16, typedArray.getDimensionPixelSize(index, a.e.P));
                    break;
                }
                case 15: {
                    h.b(15, typedArray.getDimensionPixelSize(index, a.e.T));
                    break;
                }
                case 14: {
                    h.b(14, typedArray.getDimensionPixelSize(index, a.e.Q));
                    break;
                }
                case 13: {
                    h.b(13, typedArray.getDimensionPixelSize(index, a.e.O));
                    break;
                }
                case 12: {
                    h.b(12, typedArray.getDimensionPixelSize(index, a.e.S));
                    break;
                }
                case 11: {
                    h.b(11, typedArray.getDimensionPixelSize(index, a.e.R));
                    break;
                }
                case 8: {
                    h.b(8, typedArray.getDimensionPixelSize(index, a.e.L));
                    break;
                }
                case 7: {
                    h.b(7, typedArray.getDimensionPixelOffset(index, a.e.F));
                    break;
                }
                case 6: {
                    h.b(6, typedArray.getDimensionPixelOffset(index, a.e.E));
                    break;
                }
                case 5: {
                    h.c(5, typedArray.getString(index));
                    break;
                }
                case 2: {
                    h.b(2, typedArray.getDimensionPixelSize(index, a.e.K));
                    break;
                }
            }
        }
    }
    
    private static void H(final a a, final int n, final float n2) {
        Label_0433: {
            if (n != 19) {
                if (n != 20) {
                    if (n != 37) {
                        if (n != 60) {
                            if (n != 63) {
                                if (n != 79) {
                                    if (n != 85) {
                                        if (n != 87) {
                                            if (n != 39) {
                                                if (n != 40) {
                                                    switch (n) {
                                                        default: {
                                                            switch (n) {
                                                                default: {
                                                                    Log.w("ConstraintSet", "Unknown attribute 0x");
                                                                    break Label_0433;
                                                                }
                                                                case 70: {
                                                                    a.e.g0 = n2;
                                                                    break Label_0433;
                                                                }
                                                                case 69: {
                                                                    a.e.f0 = n2;
                                                                    break Label_0433;
                                                                }
                                                                case 68: {
                                                                    a.c.e = n2;
                                                                    break Label_0433;
                                                                }
                                                                case 67: {
                                                                    a.d.i = n2;
                                                                    break Label_0433;
                                                                }
                                                            }
                                                            break;
                                                        }
                                                        case 53: {
                                                            a.f.l = n2;
                                                            break;
                                                        }
                                                        case 52: {
                                                            a.f.k = n2;
                                                            break;
                                                        }
                                                        case 51: {
                                                            a.f.j = n2;
                                                            break;
                                                        }
                                                        case 50: {
                                                            a.f.h = n2;
                                                            break;
                                                        }
                                                        case 49: {
                                                            a.f.g = n2;
                                                            break;
                                                        }
                                                        case 48: {
                                                            a.f.f = n2;
                                                            break;
                                                        }
                                                        case 47: {
                                                            a.f.e = n2;
                                                            break;
                                                        }
                                                        case 46: {
                                                            a.f.d = n2;
                                                            break;
                                                        }
                                                        case 45: {
                                                            a.f.c = n2;
                                                            break;
                                                        }
                                                        case 44: {
                                                            final e f = a.f;
                                                            f.n = n2;
                                                            f.m = true;
                                                            break;
                                                        }
                                                        case 43: {
                                                            a.c.d = n2;
                                                            break;
                                                        }
                                                    }
                                                }
                                                else {
                                                    a.e.V = n2;
                                                }
                                            }
                                            else {
                                                a.e.W = n2;
                                            }
                                        }
                                    }
                                    else {
                                        a.d.j = n2;
                                    }
                                }
                                else {
                                    a.d.g = n2;
                                }
                            }
                            else {
                                a.e.D = n2;
                            }
                        }
                        else {
                            a.f.b = n2;
                        }
                    }
                    else {
                        a.e.z = n2;
                    }
                }
                else {
                    a.e.y = n2;
                }
            }
            else {
                a.e.h = n2;
            }
        }
    }
    
    private static void I(final a a, final int n, final int e) {
        Label_0858: {
            if (n != 6) {
                if (n != 7) {
                    if (n != 8) {
                        if (n != 27) {
                            if (n != 28) {
                                if (n != 41) {
                                    if (n != 42) {
                                        if (n != 61) {
                                            if (n != 62) {
                                                if (n != 72) {
                                                    if (n != 73) {
                                                        switch (n) {
                                                            default: {
                                                                switch (n) {
                                                                    default: {
                                                                        switch (n) {
                                                                            default: {
                                                                                switch (n) {
                                                                                    default: {
                                                                                        switch (n) {
                                                                                            default: {
                                                                                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                                                                                break Label_0858;
                                                                                            }
                                                                                            case 87: {
                                                                                                break Label_0858;
                                                                                            }
                                                                                            case 89: {
                                                                                                a.d.n = e;
                                                                                                break Label_0858;
                                                                                            }
                                                                                            case 88: {
                                                                                                a.d.m = e;
                                                                                                break Label_0858;
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                    case 84: {
                                                                                        a.d.k = e;
                                                                                        break Label_0858;
                                                                                    }
                                                                                    case 83: {
                                                                                        a.f.i = e;
                                                                                        break Label_0858;
                                                                                    }
                                                                                    case 82: {
                                                                                        a.d.c = e;
                                                                                        break Label_0858;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                            case 59: {
                                                                                a.e.e0 = e;
                                                                                break Label_0858;
                                                                            }
                                                                            case 58: {
                                                                                a.e.d0 = e;
                                                                                break Label_0858;
                                                                            }
                                                                            case 57: {
                                                                                a.e.c0 = e;
                                                                                break Label_0858;
                                                                            }
                                                                            case 56: {
                                                                                a.e.b0 = e;
                                                                                break Label_0858;
                                                                            }
                                                                            case 55: {
                                                                                a.e.a0 = e;
                                                                                break Label_0858;
                                                                            }
                                                                            case 54: {
                                                                                a.e.Z = e;
                                                                                break Label_0858;
                                                                            }
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 24: {
                                                                        a.e.H = e;
                                                                        break Label_0858;
                                                                    }
                                                                    case 23: {
                                                                        a.e.d = e;
                                                                        break Label_0858;
                                                                    }
                                                                    case 22: {
                                                                        a.c.b = e;
                                                                        break Label_0858;
                                                                    }
                                                                    case 21: {
                                                                        a.e.e = e;
                                                                        break Label_0858;
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                            case 97: {
                                                                a.e.q0 = e;
                                                                break;
                                                            }
                                                            case 94: {
                                                                a.e.U = e;
                                                                break;
                                                            }
                                                            case 93: {
                                                                a.e.N = e;
                                                                break;
                                                            }
                                                            case 78: {
                                                                a.c.c = e;
                                                                break;
                                                            }
                                                            case 76: {
                                                                a.d.e = e;
                                                                break;
                                                            }
                                                            case 66: {
                                                                a.d.f = e;
                                                                break;
                                                            }
                                                            case 64: {
                                                                a.d.b = e;
                                                                break;
                                                            }
                                                            case 38: {
                                                                a.a = e;
                                                                break;
                                                            }
                                                            case 34: {
                                                                a.e.J = e;
                                                                break;
                                                            }
                                                            case 31: {
                                                                a.e.M = e;
                                                                break;
                                                            }
                                                            case 18: {
                                                                a.e.g = e;
                                                                break;
                                                            }
                                                            case 17: {
                                                                a.e.f = e;
                                                                break;
                                                            }
                                                            case 16: {
                                                                a.e.P = e;
                                                                break;
                                                            }
                                                            case 15: {
                                                                a.e.T = e;
                                                                break;
                                                            }
                                                            case 14: {
                                                                a.e.Q = e;
                                                                break;
                                                            }
                                                            case 13: {
                                                                a.e.O = e;
                                                                break;
                                                            }
                                                            case 12: {
                                                                a.e.S = e;
                                                                break;
                                                            }
                                                            case 11: {
                                                                a.e.R = e;
                                                                break;
                                                            }
                                                            case 2: {
                                                                a.e.K = e;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    else {
                                                        a.e.i0 = e;
                                                    }
                                                }
                                                else {
                                                    a.e.h0 = e;
                                                }
                                            }
                                            else {
                                                a.e.C = e;
                                            }
                                        }
                                        else {
                                            a.e.B = e;
                                        }
                                    }
                                    else {
                                        a.e.Y = e;
                                    }
                                }
                                else {
                                    a.e.X = e;
                                }
                            }
                            else {
                                a.e.I = e;
                            }
                        }
                        else {
                            a.e.G = e;
                        }
                    }
                    else {
                        a.e.L = e;
                    }
                }
                else {
                    a.e.F = e;
                }
            }
            else {
                a.e.E = e;
            }
        }
    }
    
    private static void J(final a a, final int n, final String a2) {
        if (n != 5) {
            if (n != 65) {
                if (n != 74) {
                    if (n != 77) {
                        if (n != 87) {
                            if (n != 90) {
                                Log.w("ConstraintSet", "Unknown attribute 0x");
                            }
                            else {
                                a.d.l = a2;
                            }
                        }
                    }
                    else {
                        a.e.m0 = a2;
                    }
                }
                else {
                    final b e = a.e;
                    e.l0 = a2;
                    e.k0 = null;
                }
            }
            else {
                a.d.d = a2;
            }
        }
        else {
            a.e.A = a2;
        }
    }
    
    private static void K(final a a, final int n, final boolean b) {
        if (n != 44) {
            if (n != 75) {
                if (n != 87) {
                    if (n != 80) {
                        if (n != 81) {
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                        }
                        else {
                            a.e.o0 = b;
                        }
                    }
                    else {
                        a.e.n0 = b;
                    }
                }
            }
            else {
                a.e.p0 = b;
            }
        }
        else {
            a.f.m = b;
        }
    }
    
    private String R(final int n) {
        switch (n) {
            default: {
                return "undefined";
            }
            case 7: {
                return "end";
            }
            case 6: {
                return "start";
            }
            case 5: {
                return "baseline";
            }
            case 4: {
                return "bottom";
            }
            case 3: {
                return "top";
            }
            case 2: {
                return "right";
            }
            case 1: {
                return "left";
            }
        }
    }
    
    static int a(final TypedArray typedArray, final int n, final int n2) {
        return z(typedArray, n, n2);
    }
    
    static int[] b() {
        return c.h;
    }
    
    static void c(final a a, final int n, final int n2) {
        I(a, n, n2);
    }
    
    static void d(final a a, final int n, final float n2) {
        H(a, n, n2);
    }
    
    static void e(final a a, final int n, final String s) {
        J(a, n, s);
    }
    
    static void f(final a a, final int n, final boolean b) {
        K(a, n, b);
    }
    
    public static a k(final Context context, final XmlPullParser xmlPullParser) {
        final AttributeSet attributeSet = Xml.asAttributeSet(xmlPullParser);
        final a a = new a();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.h.L2);
        E(context, a, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return a;
    }
    
    private int[] t(final View view, String s) {
        final String[] split = s.split(",");
        final Context context = view.getContext();
        s = (String)(Object)new int[split.length];
        int i;
        int n;
        for (i = 0, n = 0; i < split.length; ++i, ++n) {
            final String trim = split[i].trim();
            int int1;
            try {
                int1 = g.class.getField(trim).getInt(null);
            }
            catch (final Exception ex) {
                int1 = 0;
            }
            int identifier = int1;
            if (int1 == 0) {
                identifier = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            int intValue;
            if ((intValue = identifier) == 0) {
                intValue = identifier;
                if (view.isInEditMode()) {
                    intValue = identifier;
                    if (view.getParent() instanceof ConstraintLayout) {
                        final Object designInformation = ((ConstraintLayout)view.getParent()).getDesignInformation(0, trim);
                        intValue = identifier;
                        if (designInformation != null) {
                            intValue = identifier;
                            if (designInformation instanceof Integer) {
                                intValue = (int)designInformation;
                            }
                        }
                    }
                }
            }
            s[n] = intValue;
        }
        Object copy = s;
        if (n != split.length) {
            copy = Arrays.copyOf((int[])(Object)s, n);
        }
        return (int[])copy;
    }
    
    private a u(final Context context, final AttributeSet set, final boolean b) {
        final a a = new a();
        int[] array;
        if (b) {
            array = androidx.constraintlayout.widget.h.L2;
        }
        else {
            array = androidx.constraintlayout.widget.h.t;
        }
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, array);
        this.D(context, a, obtainStyledAttributes, b);
        obtainStyledAttributes.recycle();
        return a;
    }
    
    private a v(final int n) {
        if (!this.g.containsKey(n)) {
            this.g.put(n, new a());
        }
        return this.g.get(n);
    }
    
    private static int z(final TypedArray typedArray, final int n, int n2) {
        if ((n2 = typedArray.getResourceId(n, n2)) == -1) {
            n2 = typedArray.getInt(n, -1);
        }
        return n2;
    }
    
    public void F(final ConstraintLayout constraintLayout) {
        for (int childCount = constraintLayout.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = constraintLayout.getChildAt(i);
            final ConstraintLayout.b b = (ConstraintLayout.b)child.getLayoutParams();
            final int id = child.getId();
            if (this.f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.g.containsKey(id)) {
                this.g.put(id, new a());
            }
            final a a = this.g.get(id);
            if (a != null) {
                if (!a.e.b) {
                    androidx.constraintlayout.widget.c.a.a(a, id, b);
                    if (child instanceof androidx.constraintlayout.widget.a) {
                        a.e.k0 = ((androidx.constraintlayout.widget.a)child).getReferencedIds();
                        if (child instanceof Barrier) {
                            final Barrier barrier = (Barrier)child;
                            a.e.p0 = barrier.getAllowsGoneWidget();
                            a.e.h0 = barrier.getType();
                            a.e.i0 = barrier.getMargin();
                        }
                    }
                    a.e.b = true;
                }
                final d c = a.c;
                if (!c.a) {
                    c.b = child.getVisibility();
                    a.c.d = child.getAlpha();
                    a.c.a = true;
                }
                final e f = a.f;
                if (!f.a) {
                    f.a = true;
                    f.b = child.getRotation();
                    a.f.c = child.getRotationX();
                    a.f.d = child.getRotationY();
                    a.f.e = child.getScaleX();
                    a.f.f = child.getScaleY();
                    final float pivotX = child.getPivotX();
                    final float pivotY = child.getPivotY();
                    if (pivotX != 0.0 || pivotY != 0.0) {
                        final e f2 = a.f;
                        f2.g = pivotX;
                        f2.h = pivotY;
                    }
                    a.f.j = child.getTranslationX();
                    a.f.k = child.getTranslationY();
                    a.f.l = child.getTranslationZ();
                    final e f3 = a.f;
                    if (f3.m) {
                        f3.n = child.getElevation();
                    }
                }
            }
        }
    }
    
    public void G(final c c) {
        for (final Integer n : c.g.keySet()) {
            final int intValue = n;
            final a a = c.g.get(n);
            if (!this.g.containsKey(intValue)) {
                this.g.put(intValue, new a());
            }
            final a a2 = this.g.get(intValue);
            if (a2 == null) {
                continue;
            }
            final b e = a2.e;
            if (!e.b) {
                e.a(a.e);
            }
            final d c2 = a2.c;
            if (!c2.a) {
                c2.a(a.c);
            }
            final e f = a2.f;
            if (!f.a) {
                f.a(a.f);
            }
            final c d = a2.d;
            if (!d.a) {
                d.a(a.d);
            }
            for (final String s : a.g.keySet()) {
                if (!a2.g.containsKey(s)) {
                    a2.g.put(s, a.g.get(s));
                }
            }
        }
    }
    
    public void L(final int n, final String a) {
        this.v(n).e.A = a;
    }
    
    public void M(final boolean f) {
        this.f = f;
    }
    
    public void N(final int n, final float y) {
        this.v(n).e.y = y;
    }
    
    public void O(final int n, final int n2, final int h) {
        final a v = this.v(n);
        switch (n2) {
            default: {
                throw new IllegalArgumentException("unknown constraint");
            }
            case 7: {
                v.e.L = h;
                break;
            }
            case 6: {
                v.e.M = h;
                break;
            }
            case 5: {
                v.e.N = h;
                break;
            }
            case 4: {
                v.e.K = h;
                break;
            }
            case 3: {
                v.e.J = h;
                break;
            }
            case 2: {
                v.e.I = h;
                break;
            }
            case 1: {
                v.e.H = h;
                break;
            }
        }
    }
    
    public void P(final boolean a) {
        this.a = a;
    }
    
    public void Q(final int n, final float z) {
        this.v(n).e.z = z;
    }
    
    public void g(final ConstraintLayout constraintLayout) {
        for (int childCount = constraintLayout.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = constraintLayout.getChildAt(i);
            final int id = child.getId();
            if (!this.g.containsKey(id)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("id unknown ");
                sb.append(androidx.constraintlayout.motion.widget.a.c(child));
                Log.w("ConstraintSet", sb.toString());
            }
            else {
                if (this.f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.g.containsKey(id)) {
                    final a a = this.g.get(id);
                    if (a != null) {
                        ConstraintAttribute.i(child, a.g);
                    }
                }
            }
        }
    }
    
    public void h(final c c) {
        for (final a a : c.g.values()) {
            if (a.h != null) {
                if (a.b != null) {
                    final Iterator<Integer> iterator2 = this.g.keySet().iterator();
                    while (iterator2.hasNext()) {
                        final a w = this.w(iterator2.next());
                        final String m0 = w.e.m0;
                        if (m0 != null && a.b.matches(m0)) {
                            a.h.e(w);
                            w.g.putAll((Map<? extends String, ? extends ConstraintAttribute>)a.g.clone());
                        }
                    }
                }
                else {
                    a.h.e(this.w(a.a));
                }
            }
        }
    }
    
    public void i(final ConstraintLayout constraintLayout) {
        this.j(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }
    
    void j(final ConstraintLayout constraintLayout, final boolean b) {
        final int childCount = constraintLayout.getChildCount();
        final HashSet set = new HashSet((Collection<? extends E>)this.g.keySet());
        final int n = 0;
        for (int i = 0; i < childCount; ++i) {
            final View child = constraintLayout.getChildAt(i);
            final int id = child.getId();
            if (!this.g.containsKey(id)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("id unknown ");
                sb.append(androidx.constraintlayout.motion.widget.a.c(child));
                Log.w("ConstraintSet", sb.toString());
            }
            else {
                if (this.f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.g.containsKey(id)) {
                        set.remove(id);
                        final a a = this.g.get(id);
                        if (a != null) {
                            if (child instanceof Barrier) {
                                a.e.j0 = 1;
                                final Barrier barrier = (Barrier)child;
                                barrier.setId(id);
                                barrier.setType(a.e.h0);
                                barrier.setMargin(a.e.i0);
                                barrier.setAllowsGoneWidget(a.e.p0);
                                final b e = a.e;
                                final int[] k0 = e.k0;
                                if (k0 != null) {
                                    barrier.setReferencedIds(k0);
                                }
                                else {
                                    final String l0 = e.l0;
                                    if (l0 != null) {
                                        e.k0 = this.t(barrier, l0);
                                        barrier.setReferencedIds(a.e.k0);
                                    }
                                }
                            }
                            final ConstraintLayout.b layoutParams = (ConstraintLayout.b)child.getLayoutParams();
                            layoutParams.b();
                            a.e(layoutParams);
                            if (b) {
                                ConstraintAttribute.i(child, a.g);
                            }
                            child.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                            final d c = a.c;
                            if (c.c == 0) {
                                child.setVisibility(c.b);
                            }
                            child.setAlpha(a.c.d);
                            child.setRotation(a.f.b);
                            child.setRotationX(a.f.c);
                            child.setRotationY(a.f.d);
                            child.setScaleX(a.f.e);
                            child.setScaleY(a.f.f);
                            final e f = a.f;
                            if (f.i != -1) {
                                final View viewById = ((View)child.getParent()).findViewById(a.f.i);
                                if (viewById != null) {
                                    final float n2 = (viewById.getTop() + viewById.getBottom()) / 2.0f;
                                    final float n3 = (viewById.getLeft() + viewById.getRight()) / 2.0f;
                                    if (child.getRight() - child.getLeft() > 0 && child.getBottom() - child.getTop() > 0) {
                                        final float n4 = (float)child.getLeft();
                                        final float n5 = (float)child.getTop();
                                        child.setPivotX(n3 - n4);
                                        child.setPivotY(n2 - n5);
                                    }
                                }
                            }
                            else {
                                if (!Float.isNaN(f.g)) {
                                    child.setPivotX(a.f.g);
                                }
                                if (!Float.isNaN(a.f.h)) {
                                    child.setPivotY(a.f.h);
                                }
                            }
                            child.setTranslationX(a.f.j);
                            child.setTranslationY(a.f.k);
                            child.setTranslationZ(a.f.l);
                            final e f2 = a.f;
                            if (f2.m) {
                                child.setElevation(f2.n);
                            }
                        }
                    }
                    else {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("WARNING NO CONSTRAINTS for view ");
                        sb2.append(id);
                        Log.v("ConstraintSet", sb2.toString());
                    }
                }
            }
        }
        final Iterator iterator = set.iterator();
        int j;
        while (true) {
            j = n;
            if (!iterator.hasNext()) {
                break;
            }
            final Integer n6 = (Integer)iterator.next();
            final a a2 = this.g.get(n6);
            if (a2 == null) {
                continue;
            }
            if (a2.e.j0 == 1) {
                final Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId((int)n6);
                final b e2 = a2.e;
                final int[] k2 = e2.k0;
                if (k2 != null) {
                    barrier2.setReferencedIds(k2);
                }
                else {
                    final String l2 = e2.l0;
                    if (l2 != null) {
                        e2.k0 = this.t(barrier2, l2);
                        barrier2.setReferencedIds(a2.e.k0);
                    }
                }
                barrier2.setType(a2.e.h0);
                barrier2.setMargin(a2.e.i0);
                final ConstraintLayout.b generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.validateParams();
                a2.e(generateDefaultLayoutParams);
                constraintLayout.addView((View)barrier2, (ViewGroup$LayoutParams)generateDefaultLayoutParams);
            }
            if (!a2.e.a) {
                continue;
            }
            final Guideline guideline = new Guideline(constraintLayout.getContext());
            guideline.setId((int)n6);
            final ConstraintLayout.b generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
            a2.e(generateDefaultLayoutParams2);
            constraintLayout.addView((View)guideline, (ViewGroup$LayoutParams)generateDefaultLayoutParams2);
        }
        while (j < childCount) {
            final View child2 = constraintLayout.getChildAt(j);
            if (child2 instanceof androidx.constraintlayout.widget.a) {
                ((androidx.constraintlayout.widget.a)child2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
            ++j;
        }
    }
    
    public void l(final int n, final int n2) {
        if (this.g.containsKey(n)) {
            final a a = this.g.get(n);
            if (a == null) {
                return;
            }
            switch (n2) {
                default: {
                    throw new IllegalArgumentException("unknown constraint");
                }
                case 8: {
                    final b e = a.e;
                    e.D = -1.0f;
                    e.C = -1;
                    e.B = -1;
                    break;
                }
                case 7: {
                    final b e2 = a.e;
                    e2.w = -1;
                    e2.x = -1;
                    e2.L = 0;
                    e2.S = Integer.MIN_VALUE;
                    break;
                }
                case 6: {
                    final b e3 = a.e;
                    e3.u = -1;
                    e3.v = -1;
                    e3.M = 0;
                    e3.T = Integer.MIN_VALUE;
                    break;
                }
                case 5: {
                    final b e4 = a.e;
                    e4.r = -1;
                    e4.s = -1;
                    e4.t = -1;
                    e4.N = 0;
                    e4.U = Integer.MIN_VALUE;
                    break;
                }
                case 4: {
                    final b e5 = a.e;
                    e5.p = -1;
                    e5.q = -1;
                    e5.K = 0;
                    e5.R = Integer.MIN_VALUE;
                    break;
                }
                case 3: {
                    final b e6 = a.e;
                    e6.o = -1;
                    e6.n = -1;
                    e6.J = 0;
                    e6.P = Integer.MIN_VALUE;
                    break;
                }
                case 2: {
                    final b e7 = a.e;
                    e7.m = -1;
                    e7.l = -1;
                    e7.I = -1;
                    e7.Q = Integer.MIN_VALUE;
                    break;
                }
                case 1: {
                    final b e8 = a.e;
                    e8.k = -1;
                    e8.j = -1;
                    e8.H = -1;
                    e8.O = Integer.MIN_VALUE;
                    break;
                }
            }
        }
    }
    
    public void m(final Context context, final int n) {
        this.n((ConstraintLayout)LayoutInflater.from(context).inflate(n, (ViewGroup)null));
    }
    
    public void n(final ConstraintLayout constraintLayout) {
        final int childCount = constraintLayout.getChildCount();
        this.g.clear();
        for (int i = 0; i < childCount; ++i) {
            final View child = constraintLayout.getChildAt(i);
            final ConstraintLayout.b b = (ConstraintLayout.b)child.getLayoutParams();
            final int id = child.getId();
            if (this.f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.g.containsKey(id)) {
                this.g.put(id, new a());
            }
            final a a = this.g.get(id);
            if (a != null) {
                a.g = ConstraintAttribute.b(this.e, child);
                androidx.constraintlayout.widget.c.a.a(a, id, b);
                a.c.b = child.getVisibility();
                a.c.d = child.getAlpha();
                a.f.b = child.getRotation();
                a.f.c = child.getRotationX();
                a.f.d = child.getRotationY();
                a.f.e = child.getScaleX();
                a.f.f = child.getScaleY();
                final float pivotX = child.getPivotX();
                final float pivotY = child.getPivotY();
                if (pivotX != 0.0 || pivotY != 0.0) {
                    final e f = a.f;
                    f.g = pivotX;
                    f.h = pivotY;
                }
                a.f.j = child.getTranslationX();
                a.f.k = child.getTranslationY();
                a.f.l = child.getTranslationZ();
                final e f2 = a.f;
                if (f2.m) {
                    f2.n = child.getElevation();
                }
                if (child instanceof Barrier) {
                    final Barrier barrier = (Barrier)child;
                    a.e.p0 = barrier.getAllowsGoneWidget();
                    a.e.k0 = barrier.getReferencedIds();
                    a.e.h0 = barrier.getType();
                    a.e.i0 = barrier.getMargin();
                }
            }
        }
    }
    
    public void o(final c c) {
        this.g.clear();
        for (final Integer n : c.g.keySet()) {
            final a a = c.g.get(n);
            if (a == null) {
                continue;
            }
            this.g.put(n, a.f());
        }
    }
    
    public void p(final androidx.constraintlayout.widget.d d) {
        final int childCount = d.getChildCount();
        this.g.clear();
        for (int i = 0; i < childCount; ++i) {
            final View child = d.getChildAt(i);
            final androidx.constraintlayout.widget.d.a a = (androidx.constraintlayout.widget.d.a)child.getLayoutParams();
            final int id = child.getId();
            if (this.f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.g.containsKey(id)) {
                this.g.put(id, new a());
            }
            final a a2 = this.g.get(id);
            if (a2 != null) {
                if (child instanceof androidx.constraintlayout.widget.a) {
                    androidx.constraintlayout.widget.c.a.b(a2, (androidx.constraintlayout.widget.a)child, id, a);
                }
                androidx.constraintlayout.widget.c.a.c(a2, id, a);
            }
        }
    }
    
    public void q(final int n, final int n2, final int k, final int n3) {
        if (!this.g.containsKey(n)) {
            this.g.put(n, new a());
        }
        final a a = this.g.get(n);
        if (a == null) {
            return;
        }
        switch (n2) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append(this.R(n2));
                sb.append(" to ");
                sb.append(this.R(n3));
                sb.append(" unknown");
                throw new IllegalArgumentException(sb.toString());
            }
            case 7: {
                if (n3 == 7) {
                    final b e = a.e;
                    e.x = k;
                    e.w = -1;
                    break;
                }
                if (n3 == 6) {
                    final b e2 = a.e;
                    e2.w = k;
                    e2.x = -1;
                    break;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("right to ");
                sb2.append(this.R(n3));
                sb2.append(" undefined");
                throw new IllegalArgumentException(sb2.toString());
            }
            case 6: {
                if (n3 == 6) {
                    final b e3 = a.e;
                    e3.v = k;
                    e3.u = -1;
                    break;
                }
                if (n3 == 7) {
                    final b e4 = a.e;
                    e4.u = k;
                    e4.v = -1;
                    break;
                }
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("right to ");
                sb3.append(this.R(n3));
                sb3.append(" undefined");
                throw new IllegalArgumentException(sb3.toString());
            }
            case 5: {
                if (n3 == 5) {
                    final b e5 = a.e;
                    e5.r = k;
                    e5.q = -1;
                    e5.p = -1;
                    e5.n = -1;
                    e5.o = -1;
                    break;
                }
                if (n3 == 3) {
                    final b e6 = a.e;
                    e6.s = k;
                    e6.q = -1;
                    e6.p = -1;
                    e6.n = -1;
                    e6.o = -1;
                    break;
                }
                if (n3 == 4) {
                    final b e7 = a.e;
                    e7.t = k;
                    e7.q = -1;
                    e7.p = -1;
                    e7.n = -1;
                    e7.o = -1;
                    break;
                }
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("right to ");
                sb4.append(this.R(n3));
                sb4.append(" undefined");
                throw new IllegalArgumentException(sb4.toString());
            }
            case 4: {
                if (n3 == 4) {
                    final b e8 = a.e;
                    e8.q = k;
                    e8.p = -1;
                    e8.r = -1;
                    e8.s = -1;
                    e8.t = -1;
                    break;
                }
                if (n3 == 3) {
                    final b e9 = a.e;
                    e9.p = k;
                    e9.q = -1;
                    e9.r = -1;
                    e9.s = -1;
                    e9.t = -1;
                    break;
                }
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("right to ");
                sb5.append(this.R(n3));
                sb5.append(" undefined");
                throw new IllegalArgumentException(sb5.toString());
            }
            case 3: {
                if (n3 == 3) {
                    final b e10 = a.e;
                    e10.n = k;
                    e10.o = -1;
                    e10.r = -1;
                    e10.s = -1;
                    e10.t = -1;
                    break;
                }
                if (n3 == 4) {
                    final b e11 = a.e;
                    e11.o = k;
                    e11.n = -1;
                    e11.r = -1;
                    e11.s = -1;
                    e11.t = -1;
                    break;
                }
                final StringBuilder sb6 = new StringBuilder();
                sb6.append("right to ");
                sb6.append(this.R(n3));
                sb6.append(" undefined");
                throw new IllegalArgumentException(sb6.toString());
            }
            case 2: {
                if (n3 == 1) {
                    final b e12 = a.e;
                    e12.l = k;
                    e12.m = -1;
                    break;
                }
                if (n3 == 2) {
                    final b e13 = a.e;
                    e13.m = k;
                    e13.l = -1;
                    break;
                }
                final StringBuilder sb7 = new StringBuilder();
                sb7.append("right to ");
                sb7.append(this.R(n3));
                sb7.append(" undefined");
                throw new IllegalArgumentException(sb7.toString());
            }
            case 1: {
                if (n3 == 1) {
                    final b e14 = a.e;
                    e14.j = k;
                    e14.k = -1;
                    break;
                }
                if (n3 == 2) {
                    final b e15 = a.e;
                    e15.k = k;
                    e15.j = -1;
                    break;
                }
                final StringBuilder sb8 = new StringBuilder();
                sb8.append("left to ");
                sb8.append(this.R(n3));
                sb8.append(" undefined");
                throw new IllegalArgumentException(sb8.toString());
            }
        }
    }
    
    public void r(final int n, final int b, final int c, final float d) {
        final b e = this.v(n).e;
        e.B = b;
        e.C = c;
        e.D = d;
    }
    
    public void s(final int n, final int d) {
        this.v(n).e.d = d;
    }
    
    public a w(final int n) {
        if (this.g.containsKey(n)) {
            return this.g.get(n);
        }
        return null;
    }
    
    public void x(final Context context, int i) {
        final XmlResourceParser xml = context.getResources().getXml(i);
        try {
            String name;
            a u;
            for (i = ((XmlPullParser)xml).getEventType(); i != 1; i = ((XmlPullParser)xml).next()) {
                if (i != 0) {
                    if (i == 2) {
                        name = ((XmlPullParser)xml).getName();
                        u = this.u(context, Xml.asAttributeSet((XmlPullParser)xml), false);
                        if (name.equalsIgnoreCase("Guideline")) {
                            u.e.a = true;
                        }
                        this.g.put(u.a, u);
                    }
                }
                else {
                    ((XmlPullParser)xml).getName();
                }
            }
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        catch (final XmlPullParserException ex2) {
            ex2.printStackTrace();
        }
    }
    
    public void y(final Context context, final XmlPullParser xmlPullParser) {
        try {
            int i = xmlPullParser.getEventType();
            a a = null;
            Label_0865: {
                Label_0800: {
                    Label_0733: {
                        Label_0666: {
                            Label_0601: {
                                while (i != 1) {
                                    if (i != 0) {
                                        final int n = -1;
                                        if (i != 2) {
                                            if (i == 3) {
                                                final String lowerCase = xmlPullParser.getName().toLowerCase(Locale.ROOT);
                                                int n2 = 0;
                                                switch (lowerCase.hashCode()) {
                                                    default: {
                                                        n2 = n;
                                                        break;
                                                    }
                                                    case 2146106725: {
                                                        n2 = n;
                                                        if (lowerCase.equals("constraintset")) {
                                                            n2 = 0;
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                    case 426575017: {
                                                        n2 = n;
                                                        if (lowerCase.equals("constraintoverride")) {
                                                            n2 = 2;
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                    case -190376483: {
                                                        n2 = n;
                                                        if (lowerCase.equals("constraint")) {
                                                            n2 = 1;
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                    case -2075718416: {
                                                        n2 = n;
                                                        if (lowerCase.equals("guideline")) {
                                                            n2 = 3;
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                }
                                                if (n2 == 0) {
                                                    return;
                                                }
                                                if (n2 == 1 || n2 == 2 || n2 == 3) {
                                                    this.g.put(a.a, a);
                                                    a = null;
                                                }
                                            }
                                        }
                                        else {
                                            final String name = xmlPullParser.getName();
                                            int n3 = 0;
                                            switch (name.hashCode()) {
                                                default: {
                                                    n3 = n;
                                                    break;
                                                }
                                                case 1803088381: {
                                                    n3 = n;
                                                    if (name.equals("Constraint")) {
                                                        n3 = 0;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case 1791837707: {
                                                    n3 = n;
                                                    if (name.equals("CustomAttribute")) {
                                                        n3 = 8;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case 1331510167: {
                                                    n3 = n;
                                                    if (name.equals("Barrier")) {
                                                        n3 = 3;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case 366511058: {
                                                    n3 = n;
                                                    if (name.equals("CustomMethod")) {
                                                        n3 = 9;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case -71750448: {
                                                    n3 = n;
                                                    if (name.equals("Guideline")) {
                                                        n3 = 2;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case -1238332596: {
                                                    n3 = n;
                                                    if (name.equals("Transform")) {
                                                        n3 = 5;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case -1269513683: {
                                                    n3 = n;
                                                    if (name.equals("PropertySet")) {
                                                        n3 = 4;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case -1962203927: {
                                                    n3 = n;
                                                    if (name.equals("ConstraintOverride")) {
                                                        n3 = 1;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case -1984451626: {
                                                    n3 = n;
                                                    if (name.equals("Motion")) {
                                                        n3 = 7;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case -2025855158: {
                                                    final boolean equals = name.equals("Layout");
                                                    n3 = n;
                                                    if (equals) {
                                                        n3 = 6;
                                                        break;
                                                    }
                                                    break;
                                                }
                                            }
                                            switch (n3) {
                                                case 8:
                                                case 9: {
                                                    if (a != null) {
                                                        ConstraintAttribute.h(context, xmlPullParser, a.g);
                                                        break;
                                                    }
                                                    break Label_0601;
                                                }
                                                case 7: {
                                                    if (a != null) {
                                                        a.d.b(context, Xml.asAttributeSet(xmlPullParser));
                                                        break;
                                                    }
                                                    break Label_0666;
                                                }
                                                case 6: {
                                                    if (a != null) {
                                                        a.e.b(context, Xml.asAttributeSet(xmlPullParser));
                                                        break;
                                                    }
                                                    break Label_0733;
                                                }
                                                case 5: {
                                                    if (a != null) {
                                                        a.f.b(context, Xml.asAttributeSet(xmlPullParser));
                                                        break;
                                                    }
                                                    break Label_0800;
                                                }
                                                case 4: {
                                                    if (a != null) {
                                                        a.c.b(context, Xml.asAttributeSet(xmlPullParser));
                                                        break;
                                                    }
                                                    break Label_0865;
                                                }
                                                case 3: {
                                                    a = this.u(context, Xml.asAttributeSet(xmlPullParser), false);
                                                    a.e.j0 = 1;
                                                    break;
                                                }
                                                case 2: {
                                                    a = this.u(context, Xml.asAttributeSet(xmlPullParser), false);
                                                    final b e = a.e;
                                                    e.a = true;
                                                    e.b = true;
                                                    break;
                                                }
                                                case 1: {
                                                    a = this.u(context, Xml.asAttributeSet(xmlPullParser), true);
                                                    break;
                                                }
                                                case 0: {
                                                    a = this.u(context, Xml.asAttributeSet(xmlPullParser), false);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        xmlPullParser.getName();
                                    }
                                    i = xmlPullParser.next();
                                }
                                return;
                            }
                            final StringBuilder sb = new StringBuilder();
                            sb.append("XML parser error must be within a Constraint ");
                            sb.append(xmlPullParser.getLineNumber());
                            throw new RuntimeException(sb.toString());
                        }
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("XML parser error must be within a Constraint ");
                        sb2.append(xmlPullParser.getLineNumber());
                        throw new RuntimeException(sb2.toString());
                    }
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("XML parser error must be within a Constraint ");
                    sb3.append(xmlPullParser.getLineNumber());
                    throw new RuntimeException(sb3.toString());
                }
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("XML parser error must be within a Constraint ");
                sb4.append(xmlPullParser.getLineNumber());
                throw new RuntimeException(sb4.toString());
            }
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("XML parser error must be within a Constraint ");
            sb5.append(xmlPullParser.getLineNumber());
            throw new RuntimeException(sb5.toString());
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        catch (final XmlPullParserException ex2) {
            ex2.printStackTrace();
        }
    }
    
    public static class a
    {
        int a;
        String b;
        public final d c;
        public final c d;
        public final b e;
        public final e f;
        public HashMap<String, ConstraintAttribute> g;
        a h;
        
        public a() {
            this.c = new d();
            this.d = new c();
            this.e = new b();
            this.f = new e();
            this.g = new HashMap<String, ConstraintAttribute>();
        }
        
        static void a(final a a, final int n, final ConstraintLayout.b b) {
            a.g(n, b);
        }
        
        static void b(final a a, final a a2, final int n, final androidx.constraintlayout.widget.d.a a3) {
            a.i(a2, n, a3);
        }
        
        static void c(final a a, final int n, final androidx.constraintlayout.widget.d.a a2) {
            a.h(n, a2);
        }
        
        private void g(final int a, final ConstraintLayout.b b) {
            this.a = a;
            final b e = this.e;
            e.j = b.e;
            e.k = b.f;
            e.l = b.g;
            e.m = b.h;
            e.n = b.i;
            e.o = b.j;
            e.p = b.k;
            e.q = b.l;
            e.r = b.m;
            e.s = b.n;
            e.t = b.o;
            e.u = b.s;
            e.v = b.t;
            e.w = b.u;
            e.x = b.v;
            e.y = b.G;
            e.z = b.H;
            e.A = b.I;
            e.B = b.p;
            e.C = b.q;
            e.D = b.r;
            e.E = b.X;
            e.F = b.Y;
            e.G = b.Z;
            e.h = b.c;
            e.f = b.a;
            e.g = b.b;
            e.d = b.width;
            e.e = b.height;
            e.H = b.leftMargin;
            e.I = b.rightMargin;
            e.J = b.topMargin;
            e.K = b.bottomMargin;
            e.N = b.D;
            e.V = b.M;
            e.W = b.L;
            e.Y = b.O;
            e.X = b.N;
            e.n0 = b.a0;
            e.o0 = b.b0;
            e.Z = b.P;
            e.a0 = b.Q;
            e.b0 = b.T;
            e.c0 = b.U;
            e.d0 = b.R;
            e.e0 = b.S;
            e.f0 = b.V;
            e.g0 = b.W;
            e.m0 = b.c0;
            e.P = b.x;
            e.R = b.z;
            e.O = b.w;
            e.Q = b.y;
            e.T = b.A;
            e.S = b.B;
            e.U = b.C;
            e.q0 = b.d0;
            e.L = b.getMarginEnd();
            this.e.M = b.getMarginStart();
        }
        
        private void h(final int n, final androidx.constraintlayout.widget.d.a a) {
            this.g(n, a);
            this.c.d = a.x0;
            final e f = this.f;
            f.b = a.A0;
            f.c = a.B0;
            f.d = a.C0;
            f.e = a.D0;
            f.f = a.E0;
            f.g = a.F0;
            f.h = a.G0;
            f.j = a.H0;
            f.k = a.I0;
            f.l = a.J0;
            f.n = a.z0;
            f.m = a.y0;
        }
        
        private void i(final a a, final int n, final androidx.constraintlayout.widget.d.a a2) {
            this.h(n, a2);
            if (a instanceof Barrier) {
                final b e = this.e;
                e.j0 = 1;
                final Barrier barrier = (Barrier)a;
                e.h0 = barrier.getType();
                this.e.k0 = barrier.getReferencedIds();
                this.e.i0 = barrier.getMargin();
            }
        }
        
        public /* bridge */ Object clone() throws CloneNotSupportedException {
            return this.f();
        }
        
        public void d(final a a) {
            final a h = this.h;
            if (h != null) {
                h.e(a);
            }
        }
        
        public void e(final ConstraintLayout.b b) {
            final b e = this.e;
            b.e = e.j;
            b.f = e.k;
            b.g = e.l;
            b.h = e.m;
            b.i = e.n;
            b.j = e.o;
            b.k = e.p;
            b.l = e.q;
            b.m = e.r;
            b.n = e.s;
            b.o = e.t;
            b.s = e.u;
            b.t = e.v;
            b.u = e.w;
            b.v = e.x;
            b.leftMargin = e.H;
            b.rightMargin = e.I;
            b.topMargin = e.J;
            b.bottomMargin = e.K;
            b.A = e.T;
            b.B = e.S;
            b.x = e.P;
            b.z = e.R;
            b.G = e.y;
            b.H = e.z;
            b.p = e.B;
            b.q = e.C;
            b.r = e.D;
            b.I = e.A;
            b.X = e.E;
            b.Y = e.F;
            b.M = e.V;
            b.L = e.W;
            b.O = e.Y;
            b.N = e.X;
            b.a0 = e.n0;
            b.b0 = e.o0;
            b.P = e.Z;
            b.Q = e.a0;
            b.T = e.b0;
            b.U = e.c0;
            b.R = e.d0;
            b.S = e.e0;
            b.V = e.f0;
            b.W = e.g0;
            b.Z = e.G;
            b.c = e.h;
            b.a = e.f;
            b.b = e.g;
            b.width = e.d;
            b.height = e.e;
            final String m0 = e.m0;
            if (m0 != null) {
                b.c0 = m0;
            }
            b.d0 = e.q0;
            b.setMarginStart(e.M);
            b.setMarginEnd(this.e.L);
            b.b();
        }
        
        public a f() {
            final a a = new a();
            a.e.a(this.e);
            a.d.a(this.d);
            a.c.a(this.c);
            a.f.a(this.f);
            a.a = this.a;
            a.h = this.h;
            return a;
        }
        
        static class a
        {
            int[] a;
            int[] b;
            int c;
            int[] d;
            float[] e;
            int f;
            int[] g;
            String[] h;
            int i;
            int[] j;
            boolean[] k;
            int l;
            
            a() {
                this.a = new int[10];
                this.b = new int[10];
                this.c = 0;
                this.d = new int[10];
                this.e = new float[10];
                this.f = 0;
                this.g = new int[5];
                this.h = new String[5];
                this.i = 0;
                this.j = new int[4];
                this.k = new boolean[4];
                this.l = 0;
            }
            
            void a(final int n, final float n2) {
                final int f = this.f;
                final int[] d = this.d;
                if (f >= d.length) {
                    this.d = Arrays.copyOf(d, d.length * 2);
                    final float[] e = this.e;
                    this.e = Arrays.copyOf(e, e.length * 2);
                }
                final int[] d2 = this.d;
                final int f2 = this.f;
                d2[f2] = n;
                final float[] e2 = this.e;
                this.f = f2 + 1;
                e2[f2] = n2;
            }
            
            void b(final int n, final int n2) {
                final int c = this.c;
                final int[] a = this.a;
                if (c >= a.length) {
                    this.a = Arrays.copyOf(a, a.length * 2);
                    final int[] b = this.b;
                    this.b = Arrays.copyOf(b, b.length * 2);
                }
                final int[] a2 = this.a;
                final int c2 = this.c;
                a2[c2] = n;
                final int[] b2 = this.b;
                this.c = c2 + 1;
                b2[c2] = n2;
            }
            
            void c(final int n, final String s) {
                final int i = this.i;
                final int[] g = this.g;
                if (i >= g.length) {
                    this.g = Arrays.copyOf(g, g.length * 2);
                    final String[] h = this.h;
                    this.h = Arrays.copyOf(h, h.length * 2);
                }
                final int[] g2 = this.g;
                final int j = this.i;
                g2[j] = n;
                final String[] h2 = this.h;
                this.i = j + 1;
                h2[j] = s;
            }
            
            void d(final int n, final boolean b) {
                final int l = this.l;
                final int[] j = this.j;
                if (l >= j.length) {
                    this.j = Arrays.copyOf(j, j.length * 2);
                    final boolean[] k = this.k;
                    this.k = Arrays.copyOf(k, k.length * 2);
                }
                final int[] i = this.j;
                final int m = this.l;
                i[m] = n;
                final boolean[] k2 = this.k;
                this.l = m + 1;
                k2[m] = b;
            }
            
            void e(final androidx.constraintlayout.widget.c.a a) {
                final int n = 0;
                for (int i = 0; i < this.c; ++i) {
                    androidx.constraintlayout.widget.c.c(a, this.a[i], this.b[i]);
                }
                for (int j = 0; j < this.f; ++j) {
                    androidx.constraintlayout.widget.c.d(a, this.d[j], this.e[j]);
                }
                int n2 = 0;
                int k;
                while (true) {
                    k = n;
                    if (n2 >= this.i) {
                        break;
                    }
                    androidx.constraintlayout.widget.c.e(a, this.g[n2], this.h[n2]);
                    ++n2;
                }
                while (k < this.l) {
                    androidx.constraintlayout.widget.c.f(a, this.j[k], this.k[k]);
                    ++k;
                }
            }
        }
    }
    
    public static class b
    {
        private static SparseIntArray r0;
        public String A;
        public int B;
        public int C;
        public float D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;
        public boolean a;
        public int a0;
        public boolean b;
        public int b0;
        public boolean c;
        public int c0;
        public int d;
        public int d0;
        public int e;
        public int e0;
        public int f;
        public float f0;
        public int g;
        public float g0;
        public float h;
        public int h0;
        public boolean i;
        public int i0;
        public int j;
        public int j0;
        public int k;
        public int[] k0;
        public int l;
        public String l0;
        public int m;
        public String m0;
        public int n;
        public boolean n0;
        public int o;
        public boolean o0;
        public int p;
        public boolean p0;
        public int q;
        public int q0;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public float y;
        public float z;
        
        static {
            (b.r0 = new SparseIntArray()).append(androidx.constraintlayout.widget.h.p7, 24);
            b.r0.append(androidx.constraintlayout.widget.h.q7, 25);
            b.r0.append(androidx.constraintlayout.widget.h.s7, 28);
            b.r0.append(androidx.constraintlayout.widget.h.t7, 29);
            b.r0.append(androidx.constraintlayout.widget.h.y7, 35);
            b.r0.append(androidx.constraintlayout.widget.h.x7, 34);
            b.r0.append(androidx.constraintlayout.widget.h.Z6, 4);
            b.r0.append(androidx.constraintlayout.widget.h.Y6, 3);
            b.r0.append(androidx.constraintlayout.widget.h.W6, 1);
            b.r0.append(androidx.constraintlayout.widget.h.E7, 6);
            b.r0.append(androidx.constraintlayout.widget.h.F7, 7);
            b.r0.append(androidx.constraintlayout.widget.h.g7, 17);
            b.r0.append(androidx.constraintlayout.widget.h.h7, 18);
            b.r0.append(androidx.constraintlayout.widget.h.i7, 19);
            b.r0.append(androidx.constraintlayout.widget.h.S6, 90);
            b.r0.append(androidx.constraintlayout.widget.h.E6, 26);
            b.r0.append(androidx.constraintlayout.widget.h.u7, 31);
            b.r0.append(androidx.constraintlayout.widget.h.v7, 32);
            b.r0.append(androidx.constraintlayout.widget.h.f7, 10);
            b.r0.append(androidx.constraintlayout.widget.h.e7, 9);
            b.r0.append(androidx.constraintlayout.widget.h.I7, 13);
            b.r0.append(androidx.constraintlayout.widget.h.L7, 16);
            b.r0.append(androidx.constraintlayout.widget.h.J7, 14);
            b.r0.append(androidx.constraintlayout.widget.h.G7, 11);
            b.r0.append(androidx.constraintlayout.widget.h.K7, 15);
            b.r0.append(androidx.constraintlayout.widget.h.H7, 12);
            b.r0.append(androidx.constraintlayout.widget.h.B7, 38);
            b.r0.append(androidx.constraintlayout.widget.h.n7, 37);
            b.r0.append(androidx.constraintlayout.widget.h.m7, 39);
            b.r0.append(androidx.constraintlayout.widget.h.A7, 40);
            b.r0.append(androidx.constraintlayout.widget.h.l7, 20);
            b.r0.append(androidx.constraintlayout.widget.h.z7, 36);
            b.r0.append(androidx.constraintlayout.widget.h.d7, 5);
            b.r0.append(androidx.constraintlayout.widget.h.o7, 91);
            b.r0.append(androidx.constraintlayout.widget.h.w7, 91);
            b.r0.append(androidx.constraintlayout.widget.h.r7, 91);
            b.r0.append(androidx.constraintlayout.widget.h.X6, 91);
            b.r0.append(androidx.constraintlayout.widget.h.V6, 91);
            b.r0.append(androidx.constraintlayout.widget.h.H6, 23);
            b.r0.append(androidx.constraintlayout.widget.h.J6, 27);
            b.r0.append(androidx.constraintlayout.widget.h.L6, 30);
            b.r0.append(androidx.constraintlayout.widget.h.M6, 8);
            b.r0.append(androidx.constraintlayout.widget.h.I6, 33);
            b.r0.append(androidx.constraintlayout.widget.h.K6, 2);
            b.r0.append(androidx.constraintlayout.widget.h.F6, 22);
            b.r0.append(androidx.constraintlayout.widget.h.G6, 21);
            b.r0.append(androidx.constraintlayout.widget.h.C7, 41);
            b.r0.append(androidx.constraintlayout.widget.h.j7, 42);
            b.r0.append(androidx.constraintlayout.widget.h.U6, 41);
            b.r0.append(androidx.constraintlayout.widget.h.T6, 42);
            b.r0.append(androidx.constraintlayout.widget.h.M7, 76);
            b.r0.append(androidx.constraintlayout.widget.h.a7, 61);
            b.r0.append(androidx.constraintlayout.widget.h.c7, 62);
            b.r0.append(androidx.constraintlayout.widget.h.b7, 63);
            b.r0.append(androidx.constraintlayout.widget.h.D7, 69);
            b.r0.append(androidx.constraintlayout.widget.h.k7, 70);
            b.r0.append(androidx.constraintlayout.widget.h.Q6, 71);
            b.r0.append(androidx.constraintlayout.widget.h.O6, 72);
            b.r0.append(androidx.constraintlayout.widget.h.P6, 73);
            b.r0.append(androidx.constraintlayout.widget.h.R6, 74);
            b.r0.append(androidx.constraintlayout.widget.h.N6, 75);
        }
        
        public b() {
            this.a = false;
            this.b = false;
            this.c = false;
            this.f = -1;
            this.g = -1;
            this.h = -1.0f;
            this.i = true;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = 0.5f;
            this.z = 0.5f;
            this.A = null;
            this.B = -1;
            this.C = 0;
            this.D = 0.0f;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = Integer.MIN_VALUE;
            this.P = Integer.MIN_VALUE;
            this.Q = Integer.MIN_VALUE;
            this.R = Integer.MIN_VALUE;
            this.S = Integer.MIN_VALUE;
            this.T = Integer.MIN_VALUE;
            this.U = Integer.MIN_VALUE;
            this.V = -1.0f;
            this.W = -1.0f;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.a0 = 0;
            this.b0 = 0;
            this.c0 = 0;
            this.d0 = 0;
            this.e0 = 0;
            this.f0 = 1.0f;
            this.g0 = 1.0f;
            this.h0 = -1;
            this.i0 = 0;
            this.j0 = -1;
            this.n0 = false;
            this.o0 = false;
            this.p0 = true;
            this.q0 = 0;
        }
        
        public void a(final b b) {
            this.a = b.a;
            this.d = b.d;
            this.b = b.b;
            this.e = b.e;
            this.f = b.f;
            this.g = b.g;
            this.h = b.h;
            this.i = b.i;
            this.j = b.j;
            this.k = b.k;
            this.l = b.l;
            this.m = b.m;
            this.n = b.n;
            this.o = b.o;
            this.p = b.p;
            this.q = b.q;
            this.r = b.r;
            this.s = b.s;
            this.t = b.t;
            this.u = b.u;
            this.v = b.v;
            this.w = b.w;
            this.x = b.x;
            this.y = b.y;
            this.z = b.z;
            this.A = b.A;
            this.B = b.B;
            this.C = b.C;
            this.D = b.D;
            this.E = b.E;
            this.F = b.F;
            this.G = b.G;
            this.H = b.H;
            this.I = b.I;
            this.J = b.J;
            this.K = b.K;
            this.L = b.L;
            this.M = b.M;
            this.N = b.N;
            this.O = b.O;
            this.P = b.P;
            this.Q = b.Q;
            this.R = b.R;
            this.S = b.S;
            this.T = b.T;
            this.U = b.U;
            this.V = b.V;
            this.W = b.W;
            this.X = b.X;
            this.Y = b.Y;
            this.Z = b.Z;
            this.a0 = b.a0;
            this.b0 = b.b0;
            this.c0 = b.c0;
            this.d0 = b.d0;
            this.e0 = b.e0;
            this.f0 = b.f0;
            this.g0 = b.g0;
            this.h0 = b.h0;
            this.i0 = b.i0;
            this.j0 = b.j0;
            this.m0 = b.m0;
            final int[] k0 = b.k0;
            if (k0 != null && b.l0 == null) {
                this.k0 = Arrays.copyOf(k0, k0.length);
            }
            else {
                this.k0 = null;
            }
            this.l0 = b.l0;
            this.n0 = b.n0;
            this.o0 = b.o0;
            this.p0 = b.p0;
            this.q0 = b.q0;
        }
        
        void b(final Context context, final AttributeSet set) {
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.D6);
            this.b = true;
            for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                final int value = androidx.constraintlayout.widget.c.b.r0.get(index);
                switch (value) {
                    default: {
                        switch (value) {
                            default: {
                                switch (value) {
                                    default: {
                                        final StringBuilder sb = new StringBuilder();
                                        sb.append("Unknown attribute 0x");
                                        sb.append(Integer.toHexString(index));
                                        sb.append("   ");
                                        sb.append(androidx.constraintlayout.widget.c.b.r0.get(index));
                                        Log.w("ConstraintSet", sb.toString());
                                        continue;
                                    }
                                    case 91: {
                                        final StringBuilder sb2 = new StringBuilder();
                                        sb2.append("unused attribute 0x");
                                        sb2.append(Integer.toHexString(index));
                                        sb2.append("   ");
                                        sb2.append(androidx.constraintlayout.widget.c.b.r0.get(index));
                                        Log.w("ConstraintSet", sb2.toString());
                                        continue;
                                    }
                                    case 90: {
                                        this.i = obtainStyledAttributes.getBoolean(index, this.i);
                                        continue;
                                    }
                                    case 89: {
                                        this.m0 = obtainStyledAttributes.getString(index);
                                        continue;
                                    }
                                    case 88: {
                                        this.o0 = obtainStyledAttributes.getBoolean(index, this.o0);
                                        continue;
                                    }
                                    case 87: {
                                        this.n0 = obtainStyledAttributes.getBoolean(index, this.n0);
                                        continue;
                                    }
                                    case 86: {
                                        this.d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.d0);
                                        continue;
                                    }
                                    case 85: {
                                        this.e0 = obtainStyledAttributes.getDimensionPixelSize(index, this.e0);
                                        continue;
                                    }
                                    case 84: {
                                        this.b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.b0);
                                        continue;
                                    }
                                    case 83: {
                                        this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                        continue;
                                    }
                                    case 82: {
                                        this.a0 = obtainStyledAttributes.getInt(index, this.a0);
                                        continue;
                                    }
                                    case 81: {
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        continue;
                                    }
                                    case 80: {
                                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        continue;
                                    }
                                    case 79: {
                                        this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        continue;
                                    }
                                    case 78: {
                                        this.t = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.t);
                                        continue;
                                    }
                                    case 77: {
                                        this.s = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.s);
                                        continue;
                                    }
                                    case 76: {
                                        this.q0 = obtainStyledAttributes.getInt(index, this.q0);
                                        continue;
                                    }
                                    case 75: {
                                        this.p0 = obtainStyledAttributes.getBoolean(index, this.p0);
                                        continue;
                                    }
                                    case 74: {
                                        this.l0 = obtainStyledAttributes.getString(index);
                                        continue;
                                    }
                                    case 73: {
                                        this.i0 = obtainStyledAttributes.getDimensionPixelSize(index, this.i0);
                                        continue;
                                    }
                                    case 72: {
                                        this.h0 = obtainStyledAttributes.getInt(index, this.h0);
                                        continue;
                                    }
                                    case 71: {
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        continue;
                                    }
                                    case 70: {
                                        this.g0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    }
                                    case 69: {
                                        this.f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    }
                                }
                                break;
                            }
                            case 63: {
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                continue;
                            }
                            case 62: {
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                continue;
                            }
                            case 61: {
                                this.B = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.B);
                                continue;
                            }
                        }
                        break;
                    }
                    case 42: {
                        androidx.constraintlayout.widget.c.A(this, obtainStyledAttributes, index, 1);
                        break;
                    }
                    case 41: {
                        androidx.constraintlayout.widget.c.A(this, obtainStyledAttributes, index, 0);
                        break;
                    }
                    case 40: {
                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                        break;
                    }
                    case 39: {
                        this.X = obtainStyledAttributes.getInt(index, this.X);
                        break;
                    }
                    case 38: {
                        this.V = obtainStyledAttributes.getFloat(index, this.V);
                        break;
                    }
                    case 37: {
                        this.W = obtainStyledAttributes.getFloat(index, this.W);
                        break;
                    }
                    case 36: {
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    }
                    case 35: {
                        this.n = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.n);
                        break;
                    }
                    case 34: {
                        this.o = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.o);
                        break;
                    }
                    case 33: {
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    }
                    case 32: {
                        this.v = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.v);
                        break;
                    }
                    case 31: {
                        this.u = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.u);
                        break;
                    }
                    case 30: {
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    }
                    case 29: {
                        this.m = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.m);
                        break;
                    }
                    case 28: {
                        this.l = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.l);
                        break;
                    }
                    case 27: {
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    }
                    case 26: {
                        this.G = obtainStyledAttributes.getInt(index, this.G);
                        break;
                    }
                    case 25: {
                        this.k = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.k);
                        break;
                    }
                    case 24: {
                        this.j = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.j);
                        break;
                    }
                    case 23: {
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    }
                    case 22: {
                        this.d = obtainStyledAttributes.getLayoutDimension(index, this.d);
                        break;
                    }
                    case 21: {
                        this.e = obtainStyledAttributes.getLayoutDimension(index, this.e);
                        break;
                    }
                    case 20: {
                        this.y = obtainStyledAttributes.getFloat(index, this.y);
                        break;
                    }
                    case 19: {
                        this.h = obtainStyledAttributes.getFloat(index, this.h);
                        break;
                    }
                    case 18: {
                        this.g = obtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                        break;
                    }
                    case 17: {
                        this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                        break;
                    }
                    case 16: {
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    }
                    case 15: {
                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    }
                    case 14: {
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    }
                    case 13: {
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    }
                    case 12: {
                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    }
                    case 11: {
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    }
                    case 10: {
                        this.w = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.w);
                        break;
                    }
                    case 9: {
                        this.x = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.x);
                        break;
                    }
                    case 8: {
                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    }
                    case 7: {
                        this.F = obtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    }
                    case 6: {
                        this.E = obtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    }
                    case 5: {
                        this.A = obtainStyledAttributes.getString(index);
                        break;
                    }
                    case 4: {
                        this.p = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.p);
                        break;
                    }
                    case 3: {
                        this.q = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.q);
                        break;
                    }
                    case 2: {
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    }
                    case 1: {
                        this.r = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.r);
                        break;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
    
    public static class c
    {
        private static SparseIntArray o;
        public boolean a;
        public int b;
        public int c;
        public String d;
        public int e;
        public int f;
        public float g;
        public int h;
        public float i;
        public float j;
        public int k;
        public String l;
        public int m;
        public int n;
        
        static {
            (c.o = new SparseIntArray()).append(androidx.constraintlayout.widget.h.Y7, 1);
            c.o.append(androidx.constraintlayout.widget.h.a8, 2);
            c.o.append(androidx.constraintlayout.widget.h.e8, 3);
            c.o.append(androidx.constraintlayout.widget.h.X7, 4);
            c.o.append(androidx.constraintlayout.widget.h.W7, 5);
            c.o.append(androidx.constraintlayout.widget.h.V7, 6);
            c.o.append(androidx.constraintlayout.widget.h.Z7, 7);
            c.o.append(androidx.constraintlayout.widget.h.d8, 8);
            c.o.append(androidx.constraintlayout.widget.h.c8, 9);
            c.o.append(androidx.constraintlayout.widget.h.b8, 10);
        }
        
        public c() {
            this.a = false;
            this.b = -1;
            this.c = 0;
            this.d = null;
            this.e = -1;
            this.f = 0;
            this.g = Float.NaN;
            this.h = -1;
            this.i = Float.NaN;
            this.j = Float.NaN;
            this.k = -1;
            this.l = null;
            this.m = -3;
            this.n = -1;
        }
        
        public void a(final c c) {
            this.a = c.a;
            this.b = c.b;
            this.d = c.d;
            this.e = c.e;
            this.f = c.f;
            this.i = c.i;
            this.g = c.g;
            this.h = c.h;
        }
        
        void b(final Context context, final AttributeSet set) {
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.U7);
            this.a = true;
            for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                switch (androidx.constraintlayout.widget.c.c.o.get(index)) {
                    case 10: {
                        final int type = obtainStyledAttributes.peekValue(index).type;
                        if (type == 1) {
                            if ((this.n = obtainStyledAttributes.getResourceId(index, -1)) != -1) {
                                this.m = -2;
                                break;
                            }
                            break;
                        }
                        else {
                            if (type != 3) {
                                this.m = obtainStyledAttributes.getInteger(index, this.n);
                                break;
                            }
                            final String string = obtainStyledAttributes.getString(index);
                            this.l = string;
                            if (string.indexOf("/") > 0) {
                                this.n = obtainStyledAttributes.getResourceId(index, -1);
                                this.m = -2;
                                break;
                            }
                            this.m = -1;
                            break;
                        }
                        break;
                    }
                    case 9: {
                        this.j = obtainStyledAttributes.getFloat(index, this.j);
                        break;
                    }
                    case 8: {
                        this.k = obtainStyledAttributes.getInteger(index, this.k);
                        break;
                    }
                    case 7: {
                        this.g = obtainStyledAttributes.getFloat(index, this.g);
                        break;
                    }
                    case 6: {
                        this.c = obtainStyledAttributes.getInteger(index, this.c);
                        break;
                    }
                    case 5: {
                        this.b = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.b);
                        break;
                    }
                    case 4: {
                        this.f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    }
                    case 3: {
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.d = obtainStyledAttributes.getString(index);
                            break;
                        }
                        this.d = o.c.c[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                    case 2: {
                        this.e = obtainStyledAttributes.getInt(index, this.e);
                        break;
                    }
                    case 1: {
                        this.i = obtainStyledAttributes.getFloat(index, this.i);
                        break;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
    
    public static class d
    {
        public boolean a;
        public int b;
        public int c;
        public float d;
        public float e;
        
        public d() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.d = 1.0f;
            this.e = Float.NaN;
        }
        
        public void a(final d d) {
            this.a = d.a;
            this.b = d.b;
            this.d = d.d;
            this.e = d.e;
            this.c = d.c;
        }
        
        void b(final Context context, final AttributeSet set) {
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.O8);
            this.a = true;
            for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                if (index == androidx.constraintlayout.widget.h.Q8) {
                    this.d = obtainStyledAttributes.getFloat(index, this.d);
                }
                else if (index == androidx.constraintlayout.widget.h.P8) {
                    this.b = obtainStyledAttributes.getInt(index, this.b);
                    this.b = androidx.constraintlayout.widget.c.b()[this.b];
                }
                else if (index == androidx.constraintlayout.widget.h.S8) {
                    this.c = obtainStyledAttributes.getInt(index, this.c);
                }
                else if (index == androidx.constraintlayout.widget.h.R8) {
                    this.e = obtainStyledAttributes.getFloat(index, this.e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
    
    public static class e
    {
        private static SparseIntArray o;
        public boolean a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public int i;
        public float j;
        public float k;
        public float l;
        public boolean m;
        public float n;
        
        static {
            (e.o = new SparseIntArray()).append(androidx.constraintlayout.widget.h.o9, 1);
            e.o.append(androidx.constraintlayout.widget.h.p9, 2);
            e.o.append(androidx.constraintlayout.widget.h.q9, 3);
            e.o.append(androidx.constraintlayout.widget.h.m9, 4);
            e.o.append(androidx.constraintlayout.widget.h.n9, 5);
            e.o.append(androidx.constraintlayout.widget.h.i9, 6);
            e.o.append(androidx.constraintlayout.widget.h.j9, 7);
            e.o.append(androidx.constraintlayout.widget.h.k9, 8);
            e.o.append(androidx.constraintlayout.widget.h.l9, 9);
            e.o.append(androidx.constraintlayout.widget.h.r9, 10);
            e.o.append(androidx.constraintlayout.widget.h.s9, 11);
            e.o.append(androidx.constraintlayout.widget.h.t9, 12);
        }
        
        public e() {
            this.a = false;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 1.0f;
            this.f = 1.0f;
            this.g = Float.NaN;
            this.h = Float.NaN;
            this.i = -1;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = false;
            this.n = 0.0f;
        }
        
        public void a(final e e) {
            this.a = e.a;
            this.b = e.b;
            this.c = e.c;
            this.d = e.d;
            this.e = e.e;
            this.f = e.f;
            this.g = e.g;
            this.h = e.h;
            this.i = e.i;
            this.j = e.j;
            this.k = e.k;
            this.l = e.l;
            this.m = e.m;
            this.n = e.n;
        }
        
        void b(final Context context, final AttributeSet set) {
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.h9);
            this.a = true;
            for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                switch (androidx.constraintlayout.widget.c.e.o.get(index)) {
                    case 12: {
                        this.i = androidx.constraintlayout.widget.c.a(obtainStyledAttributes, index, this.i);
                        break;
                    }
                    case 11: {
                        this.m = true;
                        this.n = obtainStyledAttributes.getDimension(index, this.n);
                        break;
                    }
                    case 10: {
                        this.l = obtainStyledAttributes.getDimension(index, this.l);
                        break;
                    }
                    case 9: {
                        this.k = obtainStyledAttributes.getDimension(index, this.k);
                        break;
                    }
                    case 8: {
                        this.j = obtainStyledAttributes.getDimension(index, this.j);
                        break;
                    }
                    case 7: {
                        this.h = obtainStyledAttributes.getDimension(index, this.h);
                        break;
                    }
                    case 6: {
                        this.g = obtainStyledAttributes.getDimension(index, this.g);
                        break;
                    }
                    case 5: {
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                    }
                    case 4: {
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    }
                    case 3: {
                        this.d = obtainStyledAttributes.getFloat(index, this.d);
                        break;
                    }
                    case 2: {
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    }
                    case 1: {
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
