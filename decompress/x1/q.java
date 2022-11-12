// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import com.airbnb.lottie.d;
import androidx.core.view.animation.a;
import y1.g;
import android.graphics.PointF;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.lang.ref.WeakReference;
import androidx.collection.h;
import android.view.animation.Interpolator;

class q
{
    private static final Interpolator a;
    private static h<WeakReference<Interpolator>> b;
    static JsonReader.a c;
    static JsonReader.a d;
    
    static {
        a = (Interpolator)new LinearInterpolator();
        q.c = JsonReader.a.a("t", "s", "e", "o", "i", "h", "to", "ti");
        q.d = JsonReader.a.a("x", "y");
    }
    
    private static WeakReference<Interpolator> a(final int n) {
        synchronized (q.class) {
            return g().g(n);
        }
    }
    
    private static Interpolator b(PointF pointF, final PointF pointF2) {
        pointF.x = g.c(pointF.x, -1.0f, 1.0f);
        pointF.y = g.c(pointF.y, -100.0f, 100.0f);
        pointF2.x = g.c(pointF2.x, -1.0f, 1.0f);
        final float c = g.c(pointF2.y, -100.0f, 100.0f);
        pointF2.y = c;
        final int i = y1.h.i(pointF.x, pointF.y, pointF2.x, c);
        final WeakReference<Interpolator> a = a(i);
        Interpolator interpolator;
        if (a != null) {
            interpolator = a.get();
        }
        else {
            interpolator = null;
        }
        if (a != null) {
            final Object o;
            if ((o = interpolator) != null) {
                return (Interpolator)o;
            }
        }
        try {
            pointF = (PointF)androidx.core.view.animation.a.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
        }
        catch (final IllegalArgumentException ex) {
            if ("The Path cannot loop back on itself.".equals(ex.getMessage())) {
                pointF = (PointF)androidx.core.view.animation.a.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
            }
            else {
                pointF = (PointF)new LinearInterpolator();
            }
        }
        try {
            h(i, new WeakReference<Interpolator>((Interpolator)pointF));
            final Object o = pointF;
            return (Interpolator)o;
        }
        catch (final ArrayIndexOutOfBoundsException ex2) {
            final Object o = pointF;
            return (Interpolator)o;
        }
    }
    
    static <T> z1.a<T> c(final JsonReader jsonReader, final d d, final float n, final j0<T> j0, final boolean b, final boolean b2) throws IOException {
        if (b && b2) {
            return e(d, jsonReader, n, j0);
        }
        if (b) {
            return d(d, jsonReader, n, j0);
        }
        return f(jsonReader, n, j0);
    }
    
    private static <T> z1.a<T> d(final d d, final JsonReader jsonReader, final float n, final j0<T> j0) throws IOException {
        jsonReader.d();
        final PointF pointF = null;
        boolean b = false;
        final Object o = null;
        final PointF pointF2 = null;
        final PointF pointF4;
        final PointF pointF3 = pointF4 = pointF2;
        float n2 = 0.0f;
        PointF e = pointF4;
        PointF e2 = pointF4;
        PointF e3 = pointF3;
        Object a = pointF2;
        Object a2 = o;
        PointF e4 = pointF;
        while (jsonReader.i()) {
            switch (jsonReader.F(q.c)) {
                default: {
                    jsonReader.M();
                    continue;
                }
                case 7: {
                    e2 = p.e(jsonReader, n);
                    continue;
                }
                case 6: {
                    e3 = p.e(jsonReader, n);
                    continue;
                }
                case 5: {
                    b = (jsonReader.l() == 1);
                    continue;
                }
                case 4: {
                    e = p.e(jsonReader, 1.0f);
                    continue;
                }
                case 3: {
                    e4 = p.e(jsonReader, 1.0f);
                    continue;
                }
                case 2: {
                    a2 = j0.a(jsonReader, n);
                    continue;
                }
                case 1: {
                    a = j0.a(jsonReader, n);
                    continue;
                }
                case 0: {
                    n2 = (float)jsonReader.k();
                    continue;
                }
            }
        }
        jsonReader.h();
        Interpolator interpolator;
        if (b) {
            interpolator = q.a;
            a2 = a;
        }
        else if (e4 != null && e != null) {
            interpolator = b(e4, e);
        }
        else {
            interpolator = q.a;
        }
        final z1.a a3 = new z1.a(d, a, a2, interpolator, n2, null);
        a3.o = e3;
        a3.p = e2;
        return (z1.a<T>)a3;
    }
    
    private static <T> z1.a<T> e(final d d, final JsonReader jsonReader, final float n, final j0<T> j0) throws IOException {
        jsonReader.d();
        PointF e = null;
        boolean b = false;
        PointF e2 = null;
        PointF e3 = null;
        PointF pointF = null;
        Object a = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        float n2 = 0.0f;
        PointF e4 = null;
        Object a2 = null;
        while (jsonReader.i()) {
            switch (jsonReader.F(q.c)) {
                default: {
                    jsonReader.M();
                    continue;
                }
                case 7: {
                    e = p.e(jsonReader, n);
                    continue;
                }
                case 6: {
                    e4 = p.e(jsonReader, n);
                    continue;
                }
                case 5: {
                    b = (jsonReader.l() == 1);
                    continue;
                }
                case 4: {
                    if (jsonReader.u() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.d();
                        float n3 = 0.0f;
                        float n4 = 0.0f;
                        float n5 = 0.0f;
                        float n6 = 0.0f;
                    Label_0204_Outer:
                        while (jsonReader.i()) {
                            final int f = jsonReader.F(q.d);
                            if (f != 0) {
                                if (f != 1) {
                                    jsonReader.M();
                                }
                                else if (jsonReader.u() == JsonReader.Token.NUMBER) {
                                    n6 = (n4 = (float)jsonReader.k());
                                }
                                else {
                                    jsonReader.c();
                                    n4 = (float)jsonReader.k();
                                    n6 = (float)jsonReader.k();
                                    jsonReader.e();
                                }
                            }
                            else if (jsonReader.u() == JsonReader.Token.NUMBER) {
                                n5 = (n3 = (float)jsonReader.k());
                            }
                            else {
                                jsonReader.c();
                                n3 = (float)jsonReader.k();
                                n5 = (float)jsonReader.k();
                                jsonReader.e();
                            }
                            while (true) {
                                continue Label_0204_Outer;
                                continue;
                            }
                        }
                        pointF3 = new PointF(n3, n4);
                        pointF4 = new PointF(n5, n6);
                        jsonReader.h();
                        continue;
                    }
                    e3 = p.e(jsonReader, n);
                    continue;
                }
                case 3: {
                    if (jsonReader.u() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.d();
                        float n7 = 0.0f;
                        float n8 = 0.0f;
                        float n9 = 0.0f;
                        float n10 = 0.0f;
                        while (jsonReader.i()) {
                            final int f2 = jsonReader.F(q.d);
                            if (f2 != 0) {
                                if (f2 != 1) {
                                    jsonReader.M();
                                }
                                else if (jsonReader.u() == JsonReader.Token.NUMBER) {
                                    n10 = (n8 = (float)jsonReader.k());
                                }
                                else {
                                    jsonReader.c();
                                    n8 = (float)jsonReader.k();
                                    n10 = (float)jsonReader.k();
                                    jsonReader.e();
                                }
                            }
                            else if (jsonReader.u() == JsonReader.Token.NUMBER) {
                                n9 = (n7 = (float)jsonReader.k());
                            }
                            else {
                                jsonReader.c();
                                n7 = (float)jsonReader.k();
                                n9 = (float)jsonReader.k();
                                jsonReader.e();
                            }
                        }
                        pointF = new PointF(n7, n8);
                        pointF2 = new PointF(n9, n10);
                        jsonReader.h();
                        continue;
                    }
                    e2 = p.e(jsonReader, n);
                    continue;
                }
                case 2: {
                    a2 = j0.a(jsonReader, n);
                    continue;
                }
                case 1: {
                    a = j0.a(jsonReader, n);
                    continue;
                }
                case 0: {
                    n2 = (float)jsonReader.k();
                    continue;
                }
            }
        }
        jsonReader.h();
        Interpolator interpolator = null;
        Interpolator interpolator2 = null;
        Interpolator interpolator3 = null;
        Label_0693: {
            Object o;
            if (b) {
                interpolator = q.a;
                o = a;
            }
            else {
                if (e2 != null && e3 != null) {
                    interpolator = b(e2, e3);
                }
                else {
                    if (pointF != null && pointF2 != null && pointF3 != null && pointF4 != null) {
                        final Interpolator b2 = b(pointF, pointF3);
                        final Interpolator b3 = b(pointF2, pointF4);
                        interpolator2 = b2;
                        interpolator3 = b3;
                        interpolator = null;
                        break Label_0693;
                    }
                    interpolator = q.a;
                }
                o = a2;
            }
            interpolator2 = null;
            final Interpolator interpolator4 = null;
            a2 = o;
            interpolator3 = interpolator4;
        }
        z1.a a3;
        if (interpolator2 != null && interpolator3 != null) {
            a3 = new z1.a(d, a, a2, interpolator2, interpolator3, n2, null);
        }
        else {
            a3 = new z1.a(d, a, a2, interpolator, n2, null);
        }
        a3.o = e4;
        a3.p = e;
        return (z1.a<T>)a3;
    }
    
    private static <T> z1.a<T> f(final JsonReader jsonReader, final float n, final j0<T> j0) throws IOException {
        return new z1.a<T>(j0.a(jsonReader, n));
    }
    
    private static h<WeakReference<Interpolator>> g() {
        if (q.b == null) {
            q.b = new h<WeakReference<Interpolator>>();
        }
        return q.b;
    }
    
    private static void h(final int n, final WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            q.b.n(n, weakReference);
        }
    }
}
