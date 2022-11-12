// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.h;
import android.util.AttributeSet;
import android.content.Context;
import java.util.HashSet;
import t.c;
import java.util.Iterator;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;

public class j extends d
{
    private String g;
    private int h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private int u;
    private String v;
    private float w;
    private float x;
    
    public j() {
        this.h = -1;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = 0;
        this.v = null;
        this.w = Float.NaN;
        this.x = 0.0f;
        super.d = 3;
        super.e = new HashMap<String, ConstraintAttribute>();
    }
    
    static float A(final j j) {
        return j.k;
    }
    
    static float B(final j j, final float k) {
        return j.k = k;
    }
    
    static int C(final j j) {
        return j.h;
    }
    
    static int D(final j j, final int h) {
        return j.h = h;
    }
    
    static String E(final j j, final String v) {
        return j.v = v;
    }
    
    static int F(final j j) {
        return j.u;
    }
    
    static int G(final j j, final int u) {
        return j.u = u;
    }
    
    static float H(final j j) {
        return j.w;
    }
    
    static float I(final j j, final float w) {
        return j.w = w;
    }
    
    static float J(final j j) {
        return j.x;
    }
    
    static float K(final j j, final float x) {
        return j.x = x;
    }
    
    static float L(final j j) {
        return j.o;
    }
    
    static float M(final j j, final float o) {
        return j.o = o;
    }
    
    static float N(final j j) {
        return j.l;
    }
    
    static float O(final j j, final float l) {
        return j.l = l;
    }
    
    static float h(final j j) {
        return j.i;
    }
    
    static float i(final j j, final float i) {
        return j.i = i;
    }
    
    static float j(final j j) {
        return j.j;
    }
    
    static float k(final j j) {
        return j.m;
    }
    
    static float l(final j j, final float m) {
        return j.m = m;
    }
    
    static float m(final j j, final float i) {
        return j.j = i;
    }
    
    static String n(final j j, final String g) {
        return j.g = g;
    }
    
    static float o(final j j) {
        return j.p;
    }
    
    static float p(final j j, final float p2) {
        return j.p = p2;
    }
    
    static float q(final j j) {
        return j.n;
    }
    
    static float r(final j j, final float n) {
        return j.n = n;
    }
    
    static float s(final j j) {
        return j.q;
    }
    
    static float t(final j j, final float q) {
        return j.q = q;
    }
    
    static float u(final j j) {
        return j.r;
    }
    
    static float v(final j j, final float r) {
        return j.r = r;
    }
    
    static float w(final j j) {
        return j.s;
    }
    
    static float x(final j j, final float s) {
        return j.s = s;
    }
    
    static float y(final j j) {
        return j.t;
    }
    
    static float z(final j j, final float t) {
        return j.t = t;
    }
    
    public void P(final HashMap<String, t.d> hashMap) {
        for (final String s : hashMap.keySet()) {
            final t.d d = hashMap.get(s);
            if (d == null) {
                continue;
            }
            final boolean startsWith = s.startsWith("CUSTOM");
            int n = 7;
            if (startsWith) {
                final ConstraintAttribute constraintAttribute = super.e.get(s.substring(7));
                if (constraintAttribute == null) {
                    continue;
                }
                ((t.d.b)d).j(super.a, constraintAttribute, this.w, this.u, this.x);
            }
            else {
                Label_0454: {
                    switch (s) {
                        case "alpha": {
                            n = 11;
                            break Label_0454;
                        }
                        case "transitionPathRotate": {
                            n = 10;
                            break Label_0454;
                        }
                        case "elevation": {
                            n = 9;
                            break Label_0454;
                        }
                        case "rotation": {
                            n = 8;
                            break Label_0454;
                        }
                        case "scaleY": {
                            break Label_0454;
                        }
                        case "scaleX": {
                            n = 6;
                            break Label_0454;
                        }
                        case "progress": {
                            n = 5;
                            break Label_0454;
                        }
                        case "translationZ": {
                            n = 4;
                            break Label_0454;
                        }
                        case "translationY": {
                            n = 3;
                            break Label_0454;
                        }
                        case "translationX": {
                            n = 2;
                            break Label_0454;
                        }
                        case "rotationY": {
                            n = 1;
                            break Label_0454;
                        }
                        case "rotationX": {
                            n = 0;
                            break Label_0454;
                        }
                        default:
                            break;
                    }
                    n = -1;
                }
                switch (n) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("UNKNOWN addValues \"");
                        sb.append(s);
                        sb.append("\"");
                        Log.e("KeyTimeCycles", sb.toString());
                        continue;
                    }
                    case 11: {
                        if (!Float.isNaN(this.i)) {
                            d.b(super.a, this.i, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        if (!Float.isNaN(this.n)) {
                            d.b(super.a, this.n, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 9: {
                        if (!Float.isNaN(this.j)) {
                            d.b(super.a, this.j, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 8: {
                        if (!Float.isNaN(this.k)) {
                            d.b(super.a, this.k, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 7: {
                        if (!Float.isNaN(this.p)) {
                            d.b(super.a, this.p, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 6: {
                        if (!Float.isNaN(this.o)) {
                            d.b(super.a, this.o, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 5: {
                        if (!Float.isNaN(this.t)) {
                            d.b(super.a, this.t, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 4: {
                        if (!Float.isNaN(this.s)) {
                            d.b(super.a, this.s, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 3: {
                        if (!Float.isNaN(this.r)) {
                            d.b(super.a, this.r, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 2: {
                        if (!Float.isNaN(this.q)) {
                            d.b(super.a, this.q, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 1: {
                        if (!Float.isNaN(this.m)) {
                            d.b(super.a, this.m, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                    case 0: {
                        if (!Float.isNaN(this.l)) {
                            d.b(super.a, this.l, this.w, this.u, this.x);
                            continue;
                        }
                        continue;
                    }
                }
            }
        }
    }
    
    @Override
    public void a(final HashMap<String, c> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }
    
    @Override
    public d b() {
        return new j().c(this);
    }
    
    @Override
    public d c(final d d) {
        super.c(d);
        final j j = (j)d;
        this.g = j.g;
        this.h = j.h;
        this.u = j.u;
        this.w = j.w;
        this.x = j.x;
        this.t = j.t;
        this.i = j.i;
        this.j = j.j;
        this.k = j.k;
        this.n = j.n;
        this.l = j.l;
        this.m = j.m;
        this.o = j.o;
        this.p = j.p;
        this.q = j.q;
        this.r = j.r;
        this.s = j.s;
        return this;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.b();
    }
    
    public void d(final HashSet<String> set) {
        if (!Float.isNaN(this.i)) {
            set.add("alpha");
        }
        if (!Float.isNaN(this.j)) {
            set.add("elevation");
        }
        if (!Float.isNaN(this.k)) {
            set.add("rotation");
        }
        if (!Float.isNaN(this.l)) {
            set.add("rotationX");
        }
        if (!Float.isNaN(this.m)) {
            set.add("rotationY");
        }
        if (!Float.isNaN(this.q)) {
            set.add("translationX");
        }
        if (!Float.isNaN(this.r)) {
            set.add("translationY");
        }
        if (!Float.isNaN(this.s)) {
            set.add("translationZ");
        }
        if (!Float.isNaN(this.n)) {
            set.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.o)) {
            set.add("scaleX");
        }
        if (!Float.isNaN(this.p)) {
            set.add("scaleY");
        }
        if (!Float.isNaN(this.t)) {
            set.add("progress");
        }
        if (super.e.size() > 0) {
            for (final String s : super.e.keySet()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("CUSTOM,");
                sb.append(s);
                set.add(sb.toString());
            }
        }
    }
    
    public void e(final Context context, final AttributeSet set) {
        a.a(this, context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.V5));
    }
    
    @Override
    public void f(final HashMap<String, Integer> hashMap) {
        if (this.h == -1) {
            return;
        }
        if (!Float.isNaN(this.i)) {
            hashMap.put("alpha", this.h);
        }
        if (!Float.isNaN(this.j)) {
            hashMap.put("elevation", this.h);
        }
        if (!Float.isNaN(this.k)) {
            hashMap.put("rotation", this.h);
        }
        if (!Float.isNaN(this.l)) {
            hashMap.put("rotationX", this.h);
        }
        if (!Float.isNaN(this.m)) {
            hashMap.put("rotationY", this.h);
        }
        if (!Float.isNaN(this.q)) {
            hashMap.put("translationX", this.h);
        }
        if (!Float.isNaN(this.r)) {
            hashMap.put("translationY", this.h);
        }
        if (!Float.isNaN(this.s)) {
            hashMap.put("translationZ", this.h);
        }
        if (!Float.isNaN(this.n)) {
            hashMap.put("transitionPathRotate", this.h);
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put("scaleX", this.h);
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put("scaleY", this.h);
        }
        if (!Float.isNaN(this.t)) {
            hashMap.put("progress", this.h);
        }
        if (super.e.size() > 0) {
            for (final String s : super.e.keySet()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("CUSTOM,");
                sb.append(s);
                hashMap.put(sb.toString(), this.h);
            }
        }
    }
    
    private static class a
    {
        private static SparseIntArray a;
        
        static {
            (j.a.a = new SparseIntArray()).append(h.W5, 1);
            j.a.a.append(h.f6, 2);
            j.a.a.append(h.b6, 4);
            j.a.a.append(h.c6, 5);
            j.a.a.append(h.d6, 6);
            j.a.a.append(h.Z5, 7);
            j.a.a.append(h.l6, 8);
            j.a.a.append(h.k6, 9);
            j.a.a.append(h.j6, 10);
            j.a.a.append(h.h6, 12);
            j.a.a.append(h.g6, 13);
            j.a.a.append(h.a6, 14);
            j.a.a.append(h.X5, 15);
            j.a.a.append(h.Y5, 16);
            j.a.a.append(h.e6, 17);
            j.a.a.append(h.i6, 18);
            j.a.a.append(h.n6, 20);
            j.a.a.append(h.m6, 21);
            j.a.a.append(h.o6, 19);
        }
        
        public static void a(final j j, final TypedArray typedArray) {
            for (int indexCount = typedArray.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = typedArray.getIndex(i);
                switch (androidx.constraintlayout.motion.widget.j.a.a.get(index)) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(androidx.constraintlayout.motion.widget.j.a.a.get(index));
                        Log.e("KeyTimeCycle", sb.toString());
                        break;
                    }
                    case 21: {
                        if (typedArray.peekValue(index).type == 5) {
                            j.K(j, typedArray.getDimension(index, j.J(j)));
                            break;
                        }
                        j.K(j, typedArray.getFloat(index, j.J(j)));
                        break;
                    }
                    case 20: {
                        j.I(j, typedArray.getFloat(index, j.H(j)));
                        break;
                    }
                    case 19: {
                        if (typedArray.peekValue(index).type == 3) {
                            j.E(j, typedArray.getString(index));
                            j.G(j, 7);
                            break;
                        }
                        j.G(j, typedArray.getInt(index, j.F(j)));
                        break;
                    }
                    case 18: {
                        j.z(j, typedArray.getFloat(index, j.y(j)));
                        break;
                    }
                    case 17: {
                        j.x(j, typedArray.getDimension(index, j.w(j)));
                        break;
                    }
                    case 16: {
                        j.v(j, typedArray.getDimension(index, j.u(j)));
                        break;
                    }
                    case 15: {
                        j.t(j, typedArray.getDimension(index, j.s(j)));
                        break;
                    }
                    case 14: {
                        j.p(j, typedArray.getFloat(index, j.o(j)));
                        break;
                    }
                    case 13: {
                        j.D(j, typedArray.getInteger(index, j.C(j)));
                        break;
                    }
                    case 12: {
                        j.a = typedArray.getInt(index, j.a);
                        break;
                    }
                    case 10: {
                        if (MotionLayout.E0) {
                            if ((j.b = typedArray.getResourceId(index, j.b)) == -1) {
                                j.c = typedArray.getString(index);
                                break;
                            }
                            break;
                        }
                        else {
                            if (typedArray.peekValue(index).type == 3) {
                                j.c = typedArray.getString(index);
                                break;
                            }
                            j.b = typedArray.getResourceId(index, j.b);
                            break;
                        }
                        break;
                    }
                    case 9: {
                        j.n(j, typedArray.getString(index));
                        break;
                    }
                    case 8: {
                        j.r(j, typedArray.getFloat(index, j.q(j)));
                        break;
                    }
                    case 7: {
                        j.M(j, typedArray.getFloat(index, j.L(j)));
                        break;
                    }
                    case 6: {
                        j.l(j, typedArray.getFloat(index, j.k(j)));
                        break;
                    }
                    case 5: {
                        j.O(j, typedArray.getFloat(index, j.N(j)));
                        break;
                    }
                    case 4: {
                        j.B(j, typedArray.getFloat(index, j.A(j)));
                        break;
                    }
                    case 2: {
                        j.m(j, typedArray.getDimension(index, j.j(j)));
                        break;
                    }
                    case 1: {
                        j.i(j, typedArray.getFloat(index, j.h(j)));
                        break;
                    }
                }
            }
        }
    }
}
