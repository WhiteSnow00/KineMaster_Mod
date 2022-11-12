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
import o.j;
import t.c;
import android.util.Log;
import java.util.Iterator;
import t.b;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;

public class f extends d
{
    private String g;
    private int h;
    private int i;
    private String j;
    private float k;
    private float l;
    private float m;
    private float n;
    private int o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;
    
    public f() {
        this.g = null;
        this.h = 0;
        this.i = -1;
        this.j = null;
        this.k = Float.NaN;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = Float.NaN;
        this.o = -1;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = Float.NaN;
        this.w = Float.NaN;
        this.x = Float.NaN;
        this.y = Float.NaN;
        this.z = Float.NaN;
        super.d = 4;
        super.e = new HashMap<String, ConstraintAttribute>();
    }
    
    static float A(final f f) {
        return f.n;
    }
    
    static float B(final f f, final float n) {
        return f.n = n;
    }
    
    static int C(final f f) {
        return f.h;
    }
    
    static float D(final f f) {
        return f.m;
    }
    
    static float E(final f f, final float m) {
        return f.m = m;
    }
    
    static int F(final f f, final int h) {
        return f.h = h;
    }
    
    static String G(final f f, final String j) {
        return f.j = j;
    }
    
    static int H(final f f) {
        return f.i;
    }
    
    static int I(final f f, final int i) {
        return f.i = i;
    }
    
    static float J(final f f) {
        return f.k;
    }
    
    static float K(final f f, final float k) {
        return f.k = k;
    }
    
    static float L(final f f) {
        return f.l;
    }
    
    static float M(final f f, final float l) {
        return f.l = l;
    }
    
    static int N(final f f) {
        return f.o;
    }
    
    static int O(final f f, final int o) {
        return f.o = o;
    }
    
    static float P(final f f) {
        return f.p;
    }
    
    static float Q(final f f, final float p2) {
        return f.p = p2;
    }
    
    static float R(final f f) {
        return f.q;
    }
    
    static float S(final f f, final float q) {
        return f.q = q;
    }
    
    static float h(final f f) {
        return f.r;
    }
    
    static float i(final f f, final float r) {
        return f.r = r;
    }
    
    static String j(final f f, final String g) {
        return f.g = g;
    }
    
    static float k(final f f) {
        return f.t;
    }
    
    static float l(final f f, final float t) {
        return f.t = t;
    }
    
    static float m(final f f) {
        return f.u;
    }
    
    static float n(final f f, final float u) {
        return f.u = u;
    }
    
    static float o(final f f) {
        return f.s;
    }
    
    static float p(final f f, final float s) {
        return f.s = s;
    }
    
    static float q(final f f) {
        return f.v;
    }
    
    static float r(final f f, final float v) {
        return f.v = v;
    }
    
    static float s(final f f) {
        return f.w;
    }
    
    static float t(final f f, final float w) {
        return f.w = w;
    }
    
    static float u(final f f) {
        return f.x;
    }
    
    static float v(final f f, final float x) {
        return f.x = x;
    }
    
    static float w(final f f) {
        return f.y;
    }
    
    static float x(final f f, final float y) {
        return f.y = y;
    }
    
    static float y(final f f) {
        return f.z;
    }
    
    static float z(final f f, final float z) {
        return f.z = z;
    }
    
    public void T(final HashMap<String, b> hashMap) {
        for (final String s : hashMap.keySet()) {
            if (s.startsWith("CUSTOM")) {
                final ConstraintAttribute constraintAttribute = super.e.get(s.substring(7));
                if (constraintAttribute == null) {
                    continue;
                }
                if (constraintAttribute.d() != ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                    continue;
                }
                final b b = hashMap.get(s);
                if (b == null) {
                    continue;
                }
                b.d(super.a, this.i, this.j, this.o, this.k, this.l, this.m, constraintAttribute.e(), constraintAttribute);
            }
            else {
                final float u = this.U(s);
                if (Float.isNaN(u)) {
                    continue;
                }
                final b b2 = hashMap.get(s);
                if (b2 == null) {
                    continue;
                }
                b2.c(super.a, this.i, this.j, this.o, this.k, this.l, this.m, u);
            }
        }
    }
    
    public float U(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1530034690: {
                if (!s.equals("wavePhase")) {
                    break;
                }
                n = 13;
                break;
            }
            case 156108012: {
                if (!s.equals("waveOffset")) {
                    break;
                }
                n = 12;
                break;
            }
            case 92909918: {
                if (!s.equals("alpha")) {
                    break;
                }
                n = 11;
                break;
            }
            case 37232917: {
                if (!s.equals("transitionPathRotate")) {
                    break;
                }
                n = 10;
                break;
            }
            case -4379043: {
                if (!s.equals("elevation")) {
                    break;
                }
                n = 9;
                break;
            }
            case -40300674: {
                if (!s.equals("rotation")) {
                    break;
                }
                n = 8;
                break;
            }
            case -908189617: {
                if (!s.equals("scaleY")) {
                    break;
                }
                n = 7;
                break;
            }
            case -908189618: {
                if (!s.equals("scaleX")) {
                    break;
                }
                n = 6;
                break;
            }
            case -1001078227: {
                if (!s.equals("progress")) {
                    break;
                }
                n = 5;
                break;
            }
            case -1225497655: {
                if (!s.equals("translationZ")) {
                    break;
                }
                n = 4;
                break;
            }
            case -1225497656: {
                if (!s.equals("translationY")) {
                    break;
                }
                n = 3;
                break;
            }
            case -1225497657: {
                if (!s.equals("translationX")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1249320805: {
                if (!s.equals("rotationY")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1249320806: {
                if (!s.equals("rotationX")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                if (!s.startsWith("CUSTOM")) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("  UNKNOWN  ");
                    sb.append(s);
                    Log.v("WARNING! KeyCycle", sb.toString());
                }
                return Float.NaN;
            }
            case 13: {
                return this.m;
            }
            case 12: {
                return this.l;
            }
            case 11: {
                return this.p;
            }
            case 10: {
                return this.s;
            }
            case 9: {
                return this.q;
            }
            case 8: {
                return this.r;
            }
            case 7: {
                return this.w;
            }
            case 6: {
                return this.v;
            }
            case 5: {
                return this.n;
            }
            case 4: {
                return this.z;
            }
            case 3: {
                return this.y;
            }
            case 2: {
                return this.x;
            }
            case 1: {
                return this.u;
            }
            case 0: {
                return this.t;
            }
        }
    }
    
    @Override
    public void a(final HashMap<String, c> hashMap) {
        final StringBuilder sb = new StringBuilder();
        sb.append("add ");
        sb.append(hashMap.size());
        sb.append(" values");
        androidx.constraintlayout.motion.widget.a.f("KeyCycle", sb.toString(), 2);
        for (final String s : hashMap.keySet()) {
            final j j = hashMap.get(s);
            if (j == null) {
                continue;
            }
            s.hashCode();
            int n = -1;
            switch (s) {
                case "wavePhase": {
                    n = 13;
                    break;
                }
                case "waveOffset": {
                    n = 12;
                    break;
                }
                case "alpha": {
                    n = 11;
                    break;
                }
                case "transitionPathRotate": {
                    n = 10;
                    break;
                }
                case "elevation": {
                    n = 9;
                    break;
                }
                case "rotation": {
                    n = 8;
                    break;
                }
                case "scaleY": {
                    n = 7;
                    break;
                }
                case "scaleX": {
                    n = 6;
                    break;
                }
                case "progress": {
                    n = 5;
                    break;
                }
                case "translationZ": {
                    n = 4;
                    break;
                }
                case "translationY": {
                    n = 3;
                    break;
                }
                case "translationX": {
                    n = 2;
                    break;
                }
                case "rotationY": {
                    n = 1;
                    break;
                }
                case "rotationX": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    if (!s.startsWith("CUSTOM")) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("  UNKNOWN  ");
                        sb2.append(s);
                        Log.v("WARNING KeyCycle", sb2.toString());
                        continue;
                    }
                    continue;
                }
                case 13: {
                    j.b(super.a, this.m);
                    continue;
                }
                case 12: {
                    j.b(super.a, this.l);
                    continue;
                }
                case 11: {
                    j.b(super.a, this.p);
                    continue;
                }
                case 10: {
                    j.b(super.a, this.s);
                    continue;
                }
                case 9: {
                    j.b(super.a, this.q);
                    continue;
                }
                case 8: {
                    j.b(super.a, this.r);
                    continue;
                }
                case 7: {
                    j.b(super.a, this.w);
                    continue;
                }
                case 6: {
                    j.b(super.a, this.v);
                    continue;
                }
                case 5: {
                    j.b(super.a, this.n);
                    continue;
                }
                case 4: {
                    j.b(super.a, this.z);
                    continue;
                }
                case 3: {
                    j.b(super.a, this.y);
                    continue;
                }
                case 2: {
                    j.b(super.a, this.x);
                    continue;
                }
                case 1: {
                    j.b(super.a, this.u);
                    continue;
                }
                case 0: {
                    j.b(super.a, this.t);
                    continue;
                }
            }
        }
    }
    
    @Override
    public d b() {
        return new f().c(this);
    }
    
    @Override
    public d c(final d d) {
        super.c(d);
        final f f = (f)d;
        this.g = f.g;
        this.h = f.h;
        this.i = f.i;
        this.j = f.j;
        this.k = f.k;
        this.l = f.l;
        this.m = f.m;
        this.n = f.n;
        this.o = f.o;
        this.p = f.p;
        this.q = f.q;
        this.r = f.r;
        this.s = f.s;
        this.t = f.t;
        this.u = f.u;
        this.v = f.v;
        this.w = f.w;
        this.x = f.x;
        this.y = f.y;
        this.z = f.z;
        return this;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.b();
    }
    
    public void d(final HashSet<String> set) {
        if (!Float.isNaN(this.p)) {
            set.add("alpha");
        }
        if (!Float.isNaN(this.q)) {
            set.add("elevation");
        }
        if (!Float.isNaN(this.r)) {
            set.add("rotation");
        }
        if (!Float.isNaN(this.t)) {
            set.add("rotationX");
        }
        if (!Float.isNaN(this.u)) {
            set.add("rotationY");
        }
        if (!Float.isNaN(this.v)) {
            set.add("scaleX");
        }
        if (!Float.isNaN(this.w)) {
            set.add("scaleY");
        }
        if (!Float.isNaN(this.s)) {
            set.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.x)) {
            set.add("translationX");
        }
        if (!Float.isNaN(this.y)) {
            set.add("translationY");
        }
        if (!Float.isNaN(this.z)) {
            set.add("translationZ");
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
        a.a(this, context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.j5));
    }
    
    private static class a
    {
        private static SparseIntArray a;
        
        static {
            (f.a.a = new SparseIntArray()).append(h.x5, 1);
            f.a.a.append(h.v5, 2);
            f.a.a.append(h.y5, 3);
            f.a.a.append(h.u5, 4);
            f.a.a.append(h.D5, 5);
            f.a.a.append(h.B5, 6);
            f.a.a.append(h.A5, 7);
            f.a.a.append(h.E5, 8);
            f.a.a.append(h.k5, 9);
            f.a.a.append(h.t5, 10);
            f.a.a.append(h.p5, 11);
            f.a.a.append(h.q5, 12);
            f.a.a.append(h.r5, 13);
            f.a.a.append(h.z5, 14);
            f.a.a.append(h.n5, 15);
            f.a.a.append(h.o5, 16);
            f.a.a.append(h.l5, 17);
            f.a.a.append(h.m5, 18);
            f.a.a.append(h.s5, 19);
            f.a.a.append(h.w5, 20);
            f.a.a.append(h.C5, 21);
        }
        
        static void a(final f f, final TypedArray typedArray) {
            b(f, typedArray);
        }
        
        private static void b(final f f, final TypedArray typedArray) {
            for (int indexCount = typedArray.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = typedArray.getIndex(i);
                switch (androidx.constraintlayout.motion.widget.f.a.a.get(index)) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(androidx.constraintlayout.motion.widget.f.a.a.get(index));
                        Log.e("KeyCycle", sb.toString());
                        break;
                    }
                    case 21: {
                        f.E(f, typedArray.getFloat(index, f.D(f)) / 360.0f);
                        break;
                    }
                    case 20: {
                        f.B(f, typedArray.getFloat(index, f.A(f)));
                        break;
                    }
                    case 19: {
                        f.z(f, typedArray.getDimension(index, f.y(f)));
                        break;
                    }
                    case 18: {
                        f.x(f, typedArray.getDimension(index, f.w(f)));
                        break;
                    }
                    case 17: {
                        f.v(f, typedArray.getDimension(index, f.u(f)));
                        break;
                    }
                    case 16: {
                        f.t(f, typedArray.getFloat(index, f.s(f)));
                        break;
                    }
                    case 15: {
                        f.r(f, typedArray.getFloat(index, f.q(f)));
                        break;
                    }
                    case 14: {
                        f.p(f, typedArray.getFloat(index, f.o(f)));
                        break;
                    }
                    case 13: {
                        f.n(f, typedArray.getFloat(index, f.m(f)));
                        break;
                    }
                    case 12: {
                        f.l(f, typedArray.getFloat(index, f.k(f)));
                        break;
                    }
                    case 11: {
                        f.i(f, typedArray.getFloat(index, f.h(f)));
                        break;
                    }
                    case 10: {
                        f.S(f, typedArray.getDimension(index, f.R(f)));
                        break;
                    }
                    case 9: {
                        f.Q(f, typedArray.getFloat(index, f.P(f)));
                        break;
                    }
                    case 8: {
                        f.O(f, typedArray.getInt(index, f.N(f)));
                        break;
                    }
                    case 7: {
                        if (typedArray.peekValue(index).type == 5) {
                            f.M(f, typedArray.getDimension(index, f.L(f)));
                            break;
                        }
                        f.M(f, typedArray.getFloat(index, f.L(f)));
                        break;
                    }
                    case 6: {
                        f.K(f, typedArray.getFloat(index, f.J(f)));
                        break;
                    }
                    case 5: {
                        if (typedArray.peekValue(index).type == 3) {
                            f.G(f, typedArray.getString(index));
                            f.I(f, 7);
                            break;
                        }
                        f.I(f, typedArray.getInt(index, f.H(f)));
                        break;
                    }
                    case 4: {
                        f.F(f, typedArray.getInteger(index, f.C(f)));
                        break;
                    }
                    case 3: {
                        f.j(f, typedArray.getString(index));
                        break;
                    }
                    case 2: {
                        f.a = typedArray.getInt(index, f.a);
                        break;
                    }
                    case 1: {
                        if (MotionLayout.E0) {
                            if ((f.b = typedArray.getResourceId(index, f.b)) == -1) {
                                f.c = typedArray.getString(index);
                                break;
                            }
                            break;
                        }
                        else {
                            if (typedArray.peekValue(index).type == 3) {
                                f.c = typedArray.getString(index);
                                break;
                            }
                            f.b = typedArray.getResourceId(index, f.b);
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }
}
