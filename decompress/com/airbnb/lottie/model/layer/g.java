// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.layer;

import r1.p;
import java.util.Arrays;
import v1.i;
import java.util.ArrayList;
import com.airbnb.lottie.r;
import android.graphics.Typeface;
import android.graphics.Path;
import y1.h;
import android.graphics.Canvas;
import com.airbnb.lottie.model.DocumentData;
import u1.b;
import u1.k;
import java.util.HashMap;
import android.graphics.Paint$Style;
import com.airbnb.lottie.f;
import r1.n;
import q1.d;
import java.util.List;
import t1.c;
import java.util.Map;
import android.graphics.Paint;
import android.graphics.Matrix;
import android.graphics.RectF;

public class g extends a
{
    private final RectF A;
    private final Matrix B;
    private final Paint C;
    private final Paint D;
    private final Map<c, List<q1.d>> E;
    private final androidx.collection.d<String> F;
    private final n G;
    private final com.airbnb.lottie.f H;
    private final com.airbnb.lottie.d I;
    private r1.a<Integer, Integer> J;
    private r1.a<Integer, Integer> K;
    private r1.a<Integer, Integer> L;
    private r1.a<Integer, Integer> M;
    private r1.a<Float, Float> N;
    private r1.a<Float, Float> O;
    private r1.a<Float, Float> P;
    private r1.a<Float, Float> Q;
    private r1.a<Float, Float> R;
    private r1.a<Float, Float> S;
    private final StringBuilder z;
    
    g(final com.airbnb.lottie.f h, final Layer layer) {
        super(h, layer);
        this.z = new StringBuilder(2);
        this.A = new RectF();
        this.B = new Matrix();
        this.C = new Paint(1) {
            final g a;
            
            {
                this.setStyle(Paint$Style.FILL);
            }
        };
        this.D = new Paint(1) {
            final g a;
            
            {
                this.setStyle(Paint$Style.STROKE);
            }
        };
        this.E = new HashMap<c, List<q1.d>>();
        this.F = new androidx.collection.d<String>();
        this.H = h;
        this.I = layer.a();
        final n c = layer.q().c();
        (this.G = c).a((b)this);
        this.i(c);
        final k r = layer.r();
        if (r != null) {
            final u1.a a = r.a;
            if (a != null) {
                (this.J = a.a()).a((b)this);
                this.i(this.J);
            }
        }
        if (r != null) {
            final u1.a b = r.b;
            if (b != null) {
                (this.L = b.a()).a((b)this);
                this.i(this.L);
            }
        }
        if (r != null) {
            final u1.b c2 = r.c;
            if (c2 != null) {
                (this.N = c2.a()).a((b)this);
                this.i(this.N);
            }
        }
        if (r != null) {
            final u1.b d = r.d;
            if (d != null) {
                (this.P = d.a()).a((b)this);
                this.i(this.P);
            }
        }
    }
    
    private void K(final DocumentData.Justification justification, final Canvas canvas, final float n) {
        final int n2 = g$c.a[justification.ordinal()];
        if (n2 != 2) {
            if (n2 == 3) {
                canvas.translate(-n / 2.0f, 0.0f);
            }
        }
        else {
            canvas.translate(-n, 0.0f);
        }
    }
    
    private String L(String string, int i) {
        int codePoint;
        int j;
        int codePoint2;
        for (codePoint = string.codePointAt(i), j = Character.charCount(codePoint) + i; j < string.length(); j += Character.charCount(codePoint2), codePoint = codePoint * 31 + codePoint2) {
            codePoint2 = string.codePointAt(j);
            if (!this.X(codePoint2)) {
                break;
            }
        }
        final androidx.collection.d<String> f = this.F;
        final long n = codePoint;
        if (f.d(n)) {
            return this.F.f(n);
        }
        this.z.setLength(0);
        while (i < j) {
            final int codePoint3 = string.codePointAt(i);
            this.z.appendCodePoint(codePoint3);
            i += Character.charCount(codePoint3);
        }
        string = this.z.toString();
        this.F.l(n, string);
        return string;
    }
    
    private void M(final String s, final Paint paint, final Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint$Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(s, 0, s.length(), 0.0f, 0.0f, paint);
    }
    
    private void N(final c c, final Matrix matrix, final float n, final DocumentData documentData, final Canvas canvas) {
        final List<q1.d> u = this.U(c);
        for (int i = 0; i < u.size(); ++i) {
            final Path path = u.get(i).getPath();
            path.computeBounds(this.A, false);
            this.B.set(matrix);
            this.B.preTranslate(0.0f, -documentData.g * y1.h.e());
            this.B.preScale(n, n);
            path.transform(this.B);
            if (documentData.k) {
                this.Q(path, this.C, canvas);
                this.Q(path, this.D, canvas);
            }
            else {
                this.Q(path, this.D, canvas);
                this.Q(path, this.C, canvas);
            }
        }
    }
    
    private void O(final String s, final DocumentData documentData, final Canvas canvas) {
        if (documentData.k) {
            this.M(s, this.C, canvas);
            this.M(s, this.D, canvas);
        }
        else {
            this.M(s, this.D, canvas);
            this.M(s, this.C, canvas);
        }
    }
    
    private void P(final String s, final DocumentData documentData, final Canvas canvas, final float n) {
        int i = 0;
        while (i < s.length()) {
            final String l = this.L(s, i);
            i += l.length();
            this.O(l, documentData, canvas);
            canvas.translate(this.C.measureText(l) + n, 0.0f);
        }
    }
    
    private void Q(final Path path, final Paint paint, final Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint$Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }
    
    private void R(final String s, final DocumentData documentData, final Matrix matrix, final t1.b b, final Canvas canvas, final float n, final float n2) {
        for (int i = 0; i < s.length(); ++i) {
            final c c = this.I.c().g(t1.c.c(s.charAt(i), b.a(), b.c()));
            if (c != null) {
                this.N(c, matrix, n2, documentData, canvas);
                final float n3 = (float)c.b();
                final float e = y1.h.e();
                final float n4 = documentData.e / 10.0f;
                final r1.a<Float, Float> q = this.Q;
                float n6 = 0.0f;
                Label_0159: {
                    float n5;
                    if (q != null) {
                        n5 = q.h();
                    }
                    else {
                        final r1.a<Float, Float> p7 = this.P;
                        n6 = n4;
                        if (p7 == null) {
                            break Label_0159;
                        }
                        n5 = p7.h();
                    }
                    n6 = n4 + n5;
                }
                canvas.translate(n3 * n2 * e * n + n6 * n, 0.0f);
            }
        }
    }
    
    private void S(final DocumentData documentData, final Matrix matrix, final t1.b b, final Canvas canvas) {
        final r1.a<Float, Float> s = this.S;
        float n;
        if (s != null) {
            n = s.h();
        }
        else {
            final r1.a<Float, Float> r = this.R;
            if (r != null) {
                n = r.h();
            }
            else {
                n = documentData.c;
            }
        }
        final float n2 = n / 100.0f;
        final float g = y1.h.g(matrix);
        final String a = documentData.a;
        final float n3 = documentData.f * y1.h.e();
        final List<String> w = this.W(a);
        for (int size = w.size(), i = 0; i < size; ++i) {
            final String s2 = w.get(i);
            final float v = this.V(s2, b, n2, g);
            canvas.save();
            this.K(documentData.d, canvas, v);
            canvas.translate(0.0f, i * n3 - (size - 1) * n3 / 2.0f);
            this.R(s2, documentData, matrix, b, canvas, g, n2);
            canvas.restore();
        }
    }
    
    private void T(final DocumentData documentData, final t1.b b, final Matrix matrix, final Canvas canvas) {
        y1.h.g(matrix);
        final Typeface g = this.H.G(b.a(), b.c());
        if (g == null) {
            return;
        }
        final String a = documentData.a;
        final r f = this.H.F();
        String b2 = a;
        if (f != null) {
            b2 = f.b(a);
        }
        this.C.setTypeface(g);
        final r1.a<Float, Float> s = this.S;
        float n;
        if (s != null) {
            n = s.h();
        }
        else {
            final r1.a<Float, Float> r = this.R;
            if (r != null) {
                n = r.h();
            }
            else {
                n = documentData.c;
            }
        }
        this.C.setTextSize(y1.h.e() * n);
        this.D.setTypeface(this.C.getTypeface());
        this.D.setTextSize(this.C.getTextSize());
        final float n2 = documentData.f * y1.h.e();
        final float n3 = documentData.e / 10.0f;
        final r1.a<Float, Float> q = this.Q;
        float n5 = 0.0f;
        Label_0242: {
            float n4;
            if (q != null) {
                n4 = q.h();
            }
            else {
                final r1.a<Float, Float> p4 = this.P;
                n5 = n3;
                if (p4 == null) {
                    break Label_0242;
                }
                n4 = p4.h();
            }
            n5 = n3 + n4;
        }
        final float n6 = n5 * y1.h.e() * n / 100.0f;
        final List<String> w = this.W(b2);
        for (int size = w.size(), i = 0; i < size; ++i) {
            final String s2 = w.get(i);
            final float measureText = this.D.measureText(s2);
            final float n7 = (float)(s2.length() - 1);
            canvas.save();
            this.K(documentData.d, canvas, measureText + n7 * n6);
            canvas.translate(0.0f, i * n2 - (size - 1) * n2 / 2.0f);
            this.P(s2, documentData, canvas, n6);
            canvas.restore();
        }
    }
    
    private List<q1.d> U(final c c) {
        if (this.E.containsKey(c)) {
            return this.E.get(c);
        }
        final List<i> a = c.a();
        final int size = a.size();
        final ArrayList list = new ArrayList(size);
        for (int i = 0; i < size; ++i) {
            list.add((Object)new q1.d(this.H, this, (i)a.get(i)));
        }
        this.E.put(c, (ArrayList)list);
        return (List<q1.d>)list;
    }
    
    private float V(final String s, final t1.b b, final float n, final float n2) {
        float n3 = 0.0f;
        for (int i = 0; i < s.length(); ++i) {
            final c c = this.I.c().g(t1.c.c(s.charAt(i), b.a(), b.c()));
            if (c != null) {
                n3 += (float)(c.b() * n * y1.h.e() * n2);
            }
        }
        return n3;
    }
    
    private List<String> W(final String s) {
        return Arrays.asList(s.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }
    
    private boolean X(final int n) {
        return Character.getType(n) == 16 || Character.getType(n) == 27 || Character.getType(n) == 6 || Character.getType(n) == 28 || Character.getType(n) == 19;
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        super.c(t, c);
        if (t == com.airbnb.lottie.k.a) {
            final r1.a<Integer, Integer> k = this.K;
            if (k != null) {
                this.C(k);
            }
            if (c == null) {
                this.K = null;
            }
            else {
                (this.K = new p<Integer, Integer>((z1.c<Integer>)c)).a((b)this);
                this.i(this.K);
            }
        }
        else if (t == com.airbnb.lottie.k.b) {
            final r1.a<Integer, Integer> m = this.M;
            if (m != null) {
                this.C(m);
            }
            if (c == null) {
                this.M = null;
            }
            else {
                (this.M = new p<Integer, Integer>((z1.c<Integer>)c)).a((b)this);
                this.i(this.M);
            }
        }
        else if (t == com.airbnb.lottie.k.q) {
            final r1.a<Float, Float> o = this.O;
            if (o != null) {
                this.C(o);
            }
            if (c == null) {
                this.O = null;
            }
            else {
                (this.O = new p<Float, Float>((z1.c<Float>)c)).a((b)this);
                this.i(this.O);
            }
        }
        else if (t == com.airbnb.lottie.k.r) {
            final r1.a<Float, Float> q = this.Q;
            if (q != null) {
                this.C(q);
            }
            if (c == null) {
                this.Q = null;
            }
            else {
                (this.Q = new p<Float, Float>((z1.c<Float>)c)).a((b)this);
                this.i(this.Q);
            }
        }
        else if (t == com.airbnb.lottie.k.D) {
            final r1.a<Float, Float> s = this.S;
            if (s != null) {
                this.C(s);
            }
            if (c == null) {
                this.S = null;
            }
            else {
                (this.S = new p<Float, Float>((z1.c<Float>)c)).a((b)this);
                this.i(this.S);
            }
        }
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        super.e(rectF, matrix, b);
        rectF.set(0.0f, 0.0f, (float)this.I.b().width(), (float)this.I.b().height());
    }
    
    @Override
    void t(final Canvas canvas, final Matrix matrix, int intValue) {
        canvas.save();
        if (!this.H.l0()) {
            canvas.concat(matrix);
        }
        final DocumentData documentData = ((r1.a<K, DocumentData>)this.G).h();
        final t1.b b = this.I.g().get(documentData.b);
        if (b == null) {
            canvas.restore();
            return;
        }
        final r1.a<Integer, Integer> k = this.K;
        if (k != null) {
            this.C.setColor((int)k.h());
        }
        else {
            final r1.a<Integer, Integer> j = this.J;
            if (j != null) {
                this.C.setColor((int)j.h());
            }
            else {
                this.C.setColor(documentData.h);
            }
        }
        final r1.a<Integer, Integer> m = this.M;
        if (m != null) {
            this.D.setColor((int)m.h());
        }
        else {
            final r1.a<Integer, Integer> l = this.L;
            if (l != null) {
                this.D.setColor((int)l.h());
            }
            else {
                this.D.setColor(documentData.i);
            }
        }
        if (super.v.h() == null) {
            intValue = 100;
        }
        else {
            intValue = super.v.h().h();
        }
        intValue = intValue * 255 / 100;
        this.C.setAlpha(intValue);
        this.D.setAlpha(intValue);
        final r1.a<Float, Float> o = this.O;
        if (o != null) {
            this.D.setStrokeWidth((float)o.h());
        }
        else {
            final r1.a<Float, Float> n = this.N;
            if (n != null) {
                this.D.setStrokeWidth((float)n.h());
            }
            else {
                this.D.setStrokeWidth(documentData.j * y1.h.e() * y1.h.g(matrix));
            }
        }
        if (this.H.l0()) {
            this.S(documentData, matrix, b, canvas);
        }
        else {
            this.T(documentData, b, matrix, canvas);
        }
        canvas.restore();
    }
}
