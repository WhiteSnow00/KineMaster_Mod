// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.content.res.TypedArray;
import android.util.SparseIntArray;
import android.util.AttributeSet;
import android.content.Context;
import t.c;
import java.util.HashMap;

public class h extends i
{
    String h;
    int i;
    int j;
    float k;
    float l;
    float m;
    float n;
    float o;
    float p;
    int q;
    private float r;
    private float s;
    
    public h() {
        this.h = null;
        this.i = androidx.constraintlayout.motion.widget.d.f;
        this.j = 0;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = 0;
        this.r = Float.NaN;
        this.s = Float.NaN;
        super.d = 2;
    }
    
    @Override
    public void a(final HashMap<String, c> hashMap) {
    }
    
    @Override
    public d b() {
        return new h().c(this);
    }
    
    @Override
    public d c(final d d) {
        super.c(d);
        final h h = (h)d;
        this.h = h.h;
        this.i = h.i;
        this.j = h.j;
        this.k = h.k;
        this.l = Float.NaN;
        this.m = h.m;
        this.n = h.n;
        this.o = h.o;
        this.p = h.p;
        this.r = h.r;
        this.s = h.s;
        return this;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.b();
    }
    
    public void e(final Context context, final AttributeSet set) {
        a.a(this, context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.I5));
    }
    
    private static class a
    {
        private static SparseIntArray a;
        
        static {
            (h.a.a = new SparseIntArray()).append(androidx.constraintlayout.widget.h.N5, 1);
            h.a.a.append(androidx.constraintlayout.widget.h.L5, 2);
            h.a.a.append(androidx.constraintlayout.widget.h.U5, 3);
            h.a.a.append(androidx.constraintlayout.widget.h.J5, 4);
            h.a.a.append(androidx.constraintlayout.widget.h.K5, 5);
            h.a.a.append(androidx.constraintlayout.widget.h.R5, 6);
            h.a.a.append(androidx.constraintlayout.widget.h.S5, 7);
            h.a.a.append(androidx.constraintlayout.widget.h.M5, 9);
            h.a.a.append(androidx.constraintlayout.widget.h.T5, 8);
            h.a.a.append(androidx.constraintlayout.widget.h.Q5, 11);
            h.a.a.append(androidx.constraintlayout.widget.h.P5, 12);
            h.a.a.append(androidx.constraintlayout.widget.h.O5, 10);
        }
        
        static void a(final h h, final TypedArray typedArray) {
            b(h, typedArray);
        }
        
        private static void b(final h h, final TypedArray typedArray) {
            for (int indexCount = typedArray.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = typedArray.getIndex(i);
                switch (androidx.constraintlayout.motion.widget.h.a.a.get(index)) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(androidx.constraintlayout.motion.widget.h.a.a.get(index));
                        Log.e("KeyPosition", sb.toString());
                        break;
                    }
                    case 12: {
                        h.l = typedArray.getFloat(index, h.l);
                        break;
                    }
                    case 11: {
                        h.k = typedArray.getFloat(index, h.k);
                        break;
                    }
                    case 10: {
                        h.i = typedArray.getInt(index, h.i);
                        break;
                    }
                    case 9: {
                        h.q = typedArray.getInt(index, h.q);
                        break;
                    }
                    case 8: {
                        final float float1 = typedArray.getFloat(index, h.l);
                        h.k = float1;
                        h.l = float1;
                        break;
                    }
                    case 7: {
                        h.n = typedArray.getFloat(index, h.n);
                        break;
                    }
                    case 6: {
                        h.m = typedArray.getFloat(index, h.m);
                        break;
                    }
                    case 5: {
                        h.j = typedArray.getInt(index, h.j);
                        break;
                    }
                    case 4: {
                        h.g = typedArray.getInteger(index, h.g);
                        break;
                    }
                    case 3: {
                        if (typedArray.peekValue(index).type == 3) {
                            h.h = typedArray.getString(index);
                            break;
                        }
                        h.h = o.c.c[typedArray.getInteger(index, 0)];
                        break;
                    }
                    case 2: {
                        h.a = typedArray.getInt(index, h.a);
                        break;
                    }
                    case 1: {
                        if (MotionLayout.E0) {
                            if ((h.b = typedArray.getResourceId(index, h.b)) == -1) {
                                h.c = typedArray.getString(index);
                                break;
                            }
                            break;
                        }
                        else {
                            if (typedArray.peekValue(index).type == 3) {
                                h.c = typedArray.getString(index);
                                break;
                            }
                            h.b = typedArray.getResourceId(index, h.b);
                            break;
                        }
                        break;
                    }
                }
            }
            if (h.a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }
}
