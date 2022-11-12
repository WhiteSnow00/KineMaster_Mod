// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.h;
import android.util.AttributeSet;
import android.content.Context;
import java.util.HashSet;
import t.c;
import java.util.Iterator;
import java.util.Locale;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintAttribute;
import android.graphics.RectF;
import android.view.View;
import java.lang.reflect.Method;
import java.util.HashMap;

public class k extends d
{
    HashMap<String, Method> A;
    private int g;
    private String h;
    private int i;
    private String j;
    private String k;
    private int l;
    private int m;
    private View n;
    float o;
    private boolean p;
    private boolean q;
    private boolean r;
    private float s;
    private float t;
    private boolean u;
    int v;
    int w;
    int x;
    RectF y;
    RectF z;
    
    public k() {
        this.g = -1;
        this.h = null;
        final int f = androidx.constraintlayout.motion.widget.d.f;
        this.i = f;
        this.j = null;
        this.k = null;
        this.l = f;
        this.m = f;
        this.n = null;
        this.o = 0.1f;
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = Float.NaN;
        this.u = false;
        this.v = f;
        this.w = f;
        this.x = f;
        this.y = new RectF();
        this.z = new RectF();
        this.A = new HashMap<String, Method>();
        super.d = 5;
        super.e = new HashMap<String, ConstraintAttribute>();
    }
    
    static float h(final k k, final float s) {
        return k.s = s;
    }
    
    static String i(final k k, final String j) {
        return k.j = j;
    }
    
    static String j(final k k, final String i) {
        return k.k = i;
    }
    
    static String k(final k k, final String h) {
        return k.h = h;
    }
    
    static int l(final k k) {
        return k.l;
    }
    
    static int m(final k k, final int l) {
        return k.l = l;
    }
    
    static int n(final k k) {
        return k.m;
    }
    
    static int o(final k k, final int m) {
        return k.m = m;
    }
    
    static boolean p(final k k) {
        return k.u;
    }
    
    static boolean q(final k k, final boolean u) {
        return k.u = u;
    }
    
    static int r(final k k) {
        return k.i;
    }
    
    static int s(final k k, final int i) {
        return k.i = i;
    }
    
    private void u(final String s, final View view) {
        if (s == null) {
            return;
        }
        if (s.startsWith(".")) {
            this.v(s, view);
            return;
        }
        Method method;
        if (this.A.containsKey(s)) {
            if ((method = this.A.get(s)) == null) {
                return;
            }
        }
        else {
            method = null;
        }
        Method method2;
        if ((method2 = method) == null) {
            try {
                method2 = view.getClass().getMethod(s, (Class<?>[])new Class[0]);
                this.A.put(s, method2);
            }
            catch (final NoSuchMethodException ex) {
                this.A.put(s, null);
                final StringBuilder sb = new StringBuilder();
                sb.append("Could not find method \"");
                sb.append(s);
                sb.append("\"on class ");
                sb.append(view.getClass().getSimpleName());
                sb.append(" ");
                sb.append(androidx.constraintlayout.motion.widget.a.c(view));
                Log.e("KeyTrigger", sb.toString());
                return;
            }
        }
        try {
            method2.invoke(view, new Object[0]);
        }
        catch (final Exception ex2) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Exception in call \"");
            sb2.append(this.h);
            sb2.append("\"on class ");
            sb2.append(view.getClass().getSimpleName());
            sb2.append(" ");
            sb2.append(androidx.constraintlayout.motion.widget.a.c(view));
            Log.e("KeyTrigger", sb2.toString());
        }
    }
    
    private void v(final String s, final View view) {
        final boolean b = s.length() == 1;
        String lowerCase = s;
        if (!b) {
            lowerCase = s.substring(1).toLowerCase(Locale.ROOT);
        }
        for (final String s2 : super.e.keySet()) {
            final String lowerCase2 = s2.toLowerCase(Locale.ROOT);
            if (b || lowerCase2.matches(lowerCase)) {
                final ConstraintAttribute constraintAttribute = super.e.get(s2);
                if (constraintAttribute == null) {
                    continue;
                }
                constraintAttribute.a(view);
            }
        }
    }
    
    private void w(final RectF rectF, final View view, final boolean b) {
        rectF.top = (float)view.getTop();
        rectF.bottom = (float)view.getBottom();
        rectF.left = (float)view.getLeft();
        rectF.right = (float)view.getRight();
        if (b) {
            view.getMatrix().mapRect(rectF);
        }
    }
    
    @Override
    public void a(final HashMap<String, c> hashMap) {
    }
    
    @Override
    public d b() {
        return new k().c(this);
    }
    
    @Override
    public d c(final d d) {
        super.c(d);
        final k k = (k)d;
        this.g = k.g;
        this.h = k.h;
        this.i = k.i;
        this.j = k.j;
        this.k = k.k;
        this.l = k.l;
        this.m = k.m;
        this.n = k.n;
        this.o = k.o;
        this.p = k.p;
        this.q = k.q;
        this.r = k.r;
        this.s = k.s;
        this.t = k.t;
        this.u = k.u;
        this.y = k.y;
        this.z = k.z;
        this.A = k.A;
        return this;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.b();
    }
    
    public void d(final HashSet<String> set) {
    }
    
    public void e(final Context context, final AttributeSet set) {
        a.a(this, context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.p6), context);
    }
    
    public void t(final float t, final View view) {
        boolean b = false;
        boolean b2 = false;
        boolean b3 = false;
        Label_0398: {
            if (this.m != androidx.constraintlayout.motion.widget.d.f) {
                if (this.n == null) {
                    this.n = ((ViewGroup)view.getParent()).findViewById(this.m);
                }
                this.w(this.y, this.n, this.u);
                this.w(this.z, view, this.u);
                if (this.y.intersect(this.z)) {
                    if (this.p) {
                        this.p = false;
                        b = true;
                    }
                    else {
                        b = false;
                    }
                    if (this.r) {
                        this.r = false;
                        b2 = true;
                    }
                    else {
                        b2 = false;
                    }
                    this.q = true;
                    b3 = false;
                    break Label_0398;
                }
                if (!this.p) {
                    this.p = true;
                    b = true;
                }
                else {
                    b = false;
                }
                if (this.q) {
                    this.q = false;
                    b3 = true;
                }
                else {
                    b3 = false;
                }
                this.r = true;
            }
            else {
                Label_0244: {
                    if (this.p) {
                        final float s = this.s;
                        if ((t - s) * (this.t - s) < 0.0f) {
                            this.p = false;
                            b = true;
                            break Label_0244;
                        }
                    }
                    else if (Math.abs(t - this.s) > this.o) {
                        this.p = true;
                    }
                    b = false;
                }
                Label_0318: {
                    if (this.q) {
                        final float s2 = this.s;
                        final float n = t - s2;
                        if ((this.t - s2) * n < 0.0f && n < 0.0f) {
                            this.q = false;
                            b3 = true;
                            break Label_0318;
                        }
                    }
                    else if (Math.abs(t - this.s) > this.o) {
                        this.q = true;
                    }
                    b3 = false;
                }
                if (this.r) {
                    final float s3 = this.s;
                    final float n2 = t - s3;
                    if ((this.t - s3) * n2 < 0.0f && n2 > 0.0f) {
                        this.r = false;
                        b2 = true;
                    }
                    else {
                        b2 = false;
                    }
                    break Label_0398;
                }
                if (Math.abs(t - this.s) > this.o) {
                    this.r = true;
                }
            }
            b2 = false;
        }
        this.t = t;
        if (b3 || b || b2) {
            ((MotionLayout)view.getParent()).r(this.l, b2, t);
        }
        View viewById;
        if (this.i == androidx.constraintlayout.motion.widget.d.f) {
            viewById = view;
        }
        else {
            viewById = ((MotionLayout)view.getParent()).findViewById(this.i);
        }
        if (b3) {
            final String j = this.j;
            if (j != null) {
                this.u(j, viewById);
            }
            if (this.v != androidx.constraintlayout.motion.widget.d.f) {
                ((MotionLayout)view.getParent()).N(this.v, viewById);
            }
        }
        if (b2) {
            final String k = this.k;
            if (k != null) {
                this.u(k, viewById);
            }
            if (this.w != androidx.constraintlayout.motion.widget.d.f) {
                ((MotionLayout)view.getParent()).N(this.w, viewById);
            }
        }
        if (b) {
            final String h = this.h;
            if (h != null) {
                this.u(h, viewById);
            }
            if (this.x != androidx.constraintlayout.motion.widget.d.f) {
                ((MotionLayout)view.getParent()).N(this.x, viewById);
            }
        }
    }
    
    private static class a
    {
        private static SparseIntArray a;
        
        static {
            (k.a.a = new SparseIntArray()).append(h.q6, 8);
            k.a.a.append(h.u6, 4);
            k.a.a.append(h.v6, 1);
            k.a.a.append(h.w6, 2);
            k.a.a.append(h.r6, 7);
            k.a.a.append(h.x6, 6);
            k.a.a.append(h.z6, 5);
            k.a.a.append(h.t6, 9);
            k.a.a.append(h.s6, 10);
            k.a.a.append(h.y6, 11);
            k.a.a.append(h.A6, 12);
            k.a.a.append(h.B6, 13);
            k.a.a.append(h.C6, 14);
        }
        
        public static void a(final k k, final TypedArray typedArray, final Context context) {
            for (int indexCount = typedArray.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = typedArray.getIndex(i);
                switch (androidx.constraintlayout.motion.widget.k.a.a.get(index)) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(androidx.constraintlayout.motion.widget.k.a.a.get(index));
                        Log.e("KeyTrigger", sb.toString());
                        break;
                    }
                    case 14: {
                        k.w = typedArray.getResourceId(index, k.w);
                        break;
                    }
                    case 13: {
                        k.v = typedArray.getResourceId(index, k.v);
                        break;
                    }
                    case 12: {
                        k.x = typedArray.getResourceId(index, k.x);
                        break;
                    }
                    case 11: {
                        k.s(k, typedArray.getResourceId(index, k.r(k)));
                        break;
                    }
                    case 10: {
                        k.q(k, typedArray.getBoolean(index, k.p(k)));
                        break;
                    }
                    case 9: {
                        k.o(k, typedArray.getResourceId(index, k.n(k)));
                        break;
                    }
                    case 8: {
                        final int integer = typedArray.getInteger(index, k.a);
                        k.a = integer;
                        k.h(k, (integer + 0.5f) / 100.0f);
                        break;
                    }
                    case 7: {
                        if (MotionLayout.E0) {
                            if ((k.b = typedArray.getResourceId(index, k.b)) == -1) {
                                k.c = typedArray.getString(index);
                                break;
                            }
                            break;
                        }
                        else {
                            if (typedArray.peekValue(index).type == 3) {
                                k.c = typedArray.getString(index);
                                break;
                            }
                            k.b = typedArray.getResourceId(index, k.b);
                            break;
                        }
                        break;
                    }
                    case 6: {
                        k.m(k, typedArray.getResourceId(index, k.l(k)));
                        break;
                    }
                    case 5: {
                        k.o = typedArray.getFloat(index, k.o);
                        break;
                    }
                    case 4: {
                        k.k(k, typedArray.getString(index));
                        break;
                    }
                    case 2: {
                        k.j(k, typedArray.getString(index));
                        break;
                    }
                    case 1: {
                        k.i(k, typedArray.getString(index));
                        break;
                    }
                }
            }
        }
    }
}
