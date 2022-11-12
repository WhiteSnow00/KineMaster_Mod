// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.content.res.TypedArray;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.h;
import android.util.AttributeSet;
import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
import o.j;
import t.c;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;

public class e extends d
{
    private String g;
    private int h;
    private boolean i;
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
    private float u;
    private float v;
    private float w;
    
    public e() {
        this.h = -1;
        this.i = false;
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
        this.u = Float.NaN;
        this.v = Float.NaN;
        this.w = Float.NaN;
        super.d = 1;
        super.e = new HashMap<String, ConstraintAttribute>();
    }
    
    static int A(final e e, final int h) {
        return e.h = h;
    }
    
    static float B(final e e) {
        return e.r;
    }
    
    static float C(final e e, final float r) {
        return e.r = r;
    }
    
    static float D(final e e) {
        return e.m;
    }
    
    static float E(final e e, final float m) {
        return e.m = m;
    }
    
    static float F(final e e) {
        return e.n;
    }
    
    static float G(final e e, final float n) {
        return e.n = n;
    }
    
    static float H(final e e) {
        return e.o;
    }
    
    static float I(final e e, final float o) {
        return e.o = o;
    }
    
    static float J(final e e) {
        return e.p;
    }
    
    static float K(final e e, final float p2) {
        return e.p = p2;
    }
    
    static String L(final e e, final String g) {
        return e.g = g;
    }
    
    static float h(final e e) {
        return e.j;
    }
    
    static float i(final e e, final float j) {
        return e.j = j;
    }
    
    static float j(final e e) {
        return e.k;
    }
    
    static float k(final e e) {
        return e.s;
    }
    
    static float l(final e e, final float s) {
        return e.s = s;
    }
    
    static float m(final e e, final float k) {
        return e.k = k;
    }
    
    static float n(final e e) {
        return e.q;
    }
    
    static float o(final e e, final float q) {
        return e.q = q;
    }
    
    static float p(final e e) {
        return e.t;
    }
    
    static float q(final e e, final float t) {
        return e.t = t;
    }
    
    static float r(final e e) {
        return e.u;
    }
    
    static float s(final e e, final float u) {
        return e.u = u;
    }
    
    static float t(final e e) {
        return e.v;
    }
    
    static float u(final e e, final float v) {
        return e.v = v;
    }
    
    static float v(final e e) {
        return e.w;
    }
    
    static float w(final e e, final float w) {
        return e.w = w;
    }
    
    static float x(final e e) {
        return e.l;
    }
    
    static float y(final e e, final float l) {
        return e.l = l;
    }
    
    static int z(final e e) {
        return e.h;
    }
    
    @Override
    public void a(final HashMap<String, c> hashMap) {
        for (final String s : hashMap.keySet()) {
            final j j = hashMap.get(s);
            if (j == null) {
                continue;
            }
            final boolean startsWith = s.startsWith("CUSTOM");
            int n = 7;
            if (startsWith) {
                final ConstraintAttribute constraintAttribute = super.e.get(s.substring(7));
                if (constraintAttribute == null) {
                    continue;
                }
                ((c.b)j).h(super.a, constraintAttribute);
            }
            else {
                Label_0496: {
                    switch (s) {
                        case "alpha": {
                            n = 13;
                            break Label_0496;
                        }
                        case "transitionPathRotate": {
                            n = 12;
                            break Label_0496;
                        }
                        case "elevation": {
                            n = 11;
                            break Label_0496;
                        }
                        case "rotation": {
                            n = 10;
                            break Label_0496;
                        }
                        case "transformPivotY": {
                            n = 9;
                            break Label_0496;
                        }
                        case "transformPivotX": {
                            n = 8;
                            break Label_0496;
                        }
                        case "scaleY": {
                            break Label_0496;
                        }
                        case "scaleX": {
                            n = 6;
                            break Label_0496;
                        }
                        case "progress": {
                            n = 5;
                            break Label_0496;
                        }
                        case "translationZ": {
                            n = 4;
                            break Label_0496;
                        }
                        case "translationY": {
                            n = 3;
                            break Label_0496;
                        }
                        case "translationX": {
                            n = 2;
                            break Label_0496;
                        }
                        case "rotationY": {
                            n = 1;
                            break Label_0496;
                        }
                        case "rotationX": {
                            n = 0;
                            break Label_0496;
                        }
                        default:
                            break;
                    }
                    n = -1;
                }
                switch (n) {
                    default: {
                        continue;
                    }
                    case 13: {
                        if (!Float.isNaN(this.j)) {
                            j.b(super.a, this.j);
                            continue;
                        }
                        continue;
                    }
                    case 12: {
                        if (!Float.isNaN(this.q)) {
                            j.b(super.a, this.q);
                            continue;
                        }
                        continue;
                    }
                    case 11: {
                        if (!Float.isNaN(this.k)) {
                            j.b(super.a, this.k);
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        if (!Float.isNaN(this.l)) {
                            j.b(super.a, this.l);
                            continue;
                        }
                        continue;
                    }
                    case 9: {
                        if (!Float.isNaN(this.n)) {
                            j.b(super.a, this.p);
                            continue;
                        }
                        continue;
                    }
                    case 8: {
                        if (!Float.isNaN(this.m)) {
                            j.b(super.a, this.o);
                            continue;
                        }
                        continue;
                    }
                    case 7: {
                        if (!Float.isNaN(this.s)) {
                            j.b(super.a, this.s);
                            continue;
                        }
                        continue;
                    }
                    case 6: {
                        if (!Float.isNaN(this.r)) {
                            j.b(super.a, this.r);
                            continue;
                        }
                        continue;
                    }
                    case 5: {
                        if (!Float.isNaN(this.w)) {
                            j.b(super.a, this.w);
                            continue;
                        }
                        continue;
                    }
                    case 4: {
                        if (!Float.isNaN(this.v)) {
                            j.b(super.a, this.v);
                            continue;
                        }
                        continue;
                    }
                    case 3: {
                        if (!Float.isNaN(this.u)) {
                            j.b(super.a, this.u);
                            continue;
                        }
                        continue;
                    }
                    case 2: {
                        if (!Float.isNaN(this.t)) {
                            j.b(super.a, this.t);
                            continue;
                        }
                        continue;
                    }
                    case 1: {
                        if (!Float.isNaN(this.n)) {
                            j.b(super.a, this.n);
                            continue;
                        }
                        continue;
                    }
                    case 0: {
                        if (!Float.isNaN(this.m)) {
                            j.b(super.a, this.m);
                            continue;
                        }
                        continue;
                    }
                }
            }
        }
    }
    
    @Override
    public d b() {
        return new e().c(this);
    }
    
    @Override
    public d c(final d d) {
        super.c(d);
        final e e = (e)d;
        this.h = e.h;
        this.i = e.i;
        this.j = e.j;
        this.k = e.k;
        this.l = e.l;
        this.m = e.m;
        this.n = e.n;
        this.o = e.o;
        this.p = e.p;
        this.q = e.q;
        this.r = e.r;
        this.s = e.s;
        this.t = e.t;
        this.u = e.u;
        this.v = e.v;
        this.w = e.w;
        return this;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.b();
    }
    
    public void d(final HashSet<String> set) {
        if (!Float.isNaN(this.j)) {
            set.add("alpha");
        }
        if (!Float.isNaN(this.k)) {
            set.add("elevation");
        }
        if (!Float.isNaN(this.l)) {
            set.add("rotation");
        }
        if (!Float.isNaN(this.m)) {
            set.add("rotationX");
        }
        if (!Float.isNaN(this.n)) {
            set.add("rotationY");
        }
        if (!Float.isNaN(this.o)) {
            set.add("transformPivotX");
        }
        if (!Float.isNaN(this.p)) {
            set.add("transformPivotY");
        }
        if (!Float.isNaN(this.t)) {
            set.add("translationX");
        }
        if (!Float.isNaN(this.u)) {
            set.add("translationY");
        }
        if (!Float.isNaN(this.v)) {
            set.add("translationZ");
        }
        if (!Float.isNaN(this.q)) {
            set.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.r)) {
            set.add("scaleX");
        }
        if (!Float.isNaN(this.s)) {
            set.add("scaleY");
        }
        if (!Float.isNaN(this.w)) {
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
        a.a(this, context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.Q4));
    }
    
    @Override
    public void f(final HashMap<String, Integer> hashMap) {
        if (this.h == -1) {
            return;
        }
        if (!Float.isNaN(this.j)) {
            hashMap.put("alpha", this.h);
        }
        if (!Float.isNaN(this.k)) {
            hashMap.put("elevation", this.h);
        }
        if (!Float.isNaN(this.l)) {
            hashMap.put("rotation", this.h);
        }
        if (!Float.isNaN(this.m)) {
            hashMap.put("rotationX", this.h);
        }
        if (!Float.isNaN(this.n)) {
            hashMap.put("rotationY", this.h);
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put("transformPivotX", this.h);
        }
        if (!Float.isNaN(this.p)) {
            hashMap.put("transformPivotY", this.h);
        }
        if (!Float.isNaN(this.t)) {
            hashMap.put("translationX", this.h);
        }
        if (!Float.isNaN(this.u)) {
            hashMap.put("translationY", this.h);
        }
        if (!Float.isNaN(this.v)) {
            hashMap.put("translationZ", this.h);
        }
        if (!Float.isNaN(this.q)) {
            hashMap.put("transitionPathRotate", this.h);
        }
        if (!Float.isNaN(this.r)) {
            hashMap.put("scaleX", this.h);
        }
        if (!Float.isNaN(this.s)) {
            hashMap.put("scaleY", this.h);
        }
        if (!Float.isNaN(this.w)) {
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
            (e.a.a = new SparseIntArray()).append(h.R4, 1);
            e.a.a.append(h.c5, 2);
            e.a.a.append(h.Y4, 4);
            e.a.a.append(h.Z4, 5);
            e.a.a.append(h.a5, 6);
            e.a.a.append(h.S4, 19);
            e.a.a.append(h.T4, 20);
            e.a.a.append(h.W4, 7);
            e.a.a.append(h.i5, 8);
            e.a.a.append(h.h5, 9);
            e.a.a.append(h.g5, 10);
            e.a.a.append(h.e5, 12);
            e.a.a.append(h.d5, 13);
            e.a.a.append(h.X4, 14);
            e.a.a.append(h.U4, 15);
            e.a.a.append(h.V4, 16);
            e.a.a.append(h.b5, 17);
            e.a.a.append(h.f5, 18);
        }
        
        public static void a(final e e, final TypedArray typedArray) {
            for (int indexCount = typedArray.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = typedArray.getIndex(i);
                switch (androidx.constraintlayout.motion.widget.e.a.a.get(index)) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(androidx.constraintlayout.motion.widget.e.a.a.get(index));
                        Log.e("KeyAttribute", sb.toString());
                        break;
                    }
                    case 20: {
                        e.K(e, typedArray.getDimension(index, e.J(e)));
                        break;
                    }
                    case 19: {
                        e.I(e, typedArray.getDimension(index, e.H(e)));
                        break;
                    }
                    case 18: {
                        e.w(e, typedArray.getFloat(index, e.v(e)));
                        break;
                    }
                    case 17: {
                        e.u(e, typedArray.getDimension(index, e.t(e)));
                        break;
                    }
                    case 16: {
                        e.s(e, typedArray.getDimension(index, e.r(e)));
                        break;
                    }
                    case 15: {
                        e.q(e, typedArray.getDimension(index, e.p(e)));
                        break;
                    }
                    case 14: {
                        e.l(e, typedArray.getFloat(index, e.k(e)));
                        break;
                    }
                    case 13: {
                        e.A(e, typedArray.getInteger(index, e.z(e)));
                        break;
                    }
                    case 12: {
                        e.a = typedArray.getInt(index, e.a);
                        break;
                    }
                    case 10: {
                        if (MotionLayout.E0) {
                            if ((e.b = typedArray.getResourceId(index, e.b)) == -1) {
                                e.c = typedArray.getString(index);
                                break;
                            }
                            break;
                        }
                        else {
                            if (typedArray.peekValue(index).type == 3) {
                                e.c = typedArray.getString(index);
                                break;
                            }
                            e.b = typedArray.getResourceId(index, e.b);
                            break;
                        }
                        break;
                    }
                    case 9: {
                        e.L(e, typedArray.getString(index));
                        break;
                    }
                    case 8: {
                        e.o(e, typedArray.getFloat(index, e.n(e)));
                        break;
                    }
                    case 7: {
                        e.C(e, typedArray.getFloat(index, e.B(e)));
                        break;
                    }
                    case 6: {
                        e.G(e, typedArray.getFloat(index, e.F(e)));
                        break;
                    }
                    case 5: {
                        e.E(e, typedArray.getFloat(index, e.D(e)));
                        break;
                    }
                    case 4: {
                        e.y(e, typedArray.getFloat(index, e.x(e)));
                        break;
                    }
                    case 2: {
                        e.m(e, typedArray.getDimension(index, e.j(e)));
                        break;
                    }
                    case 1: {
                        e.i(e, typedArray.getFloat(index, e.h(e)));
                        break;
                    }
                }
            }
        }
    }
}
