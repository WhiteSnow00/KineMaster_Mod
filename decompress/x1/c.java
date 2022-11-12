// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import android.view.animation.Interpolator;
import u1.l;
import z1.d;
import u1.g;
import u1.b;
import u1.i;
import u1.m;
import z1.a;
import android.graphics.PointF;
import u1.e;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class c
{
    private static final JsonReader.a a;
    private static final JsonReader.a b;
    
    static {
        a = JsonReader.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
        b = JsonReader.a.a("k");
    }
    
    private static boolean a(final e e) {
        final boolean b = false;
        if (e != null) {
            boolean b2 = b;
            if (!e.f()) {
                return b2;
            }
            b2 = b;
            if (!((PointF)e.b().get(0).b).equals(0.0f, 0.0f)) {
                return b2;
            }
        }
        return true;
    }
    
    private static boolean b(final m<PointF, PointF> m) {
        final boolean b = false;
        if (m != null) {
            boolean b2 = b;
            if (m instanceof i) {
                return b2;
            }
            b2 = b;
            if (!m.f()) {
                return b2;
            }
            b2 = b;
            if (!((PointF)((a)m.b().get(0)).b).equals(0.0f, 0.0f)) {
                return b2;
            }
        }
        return true;
    }
    
    private static boolean c(final b b) {
        final boolean b2 = false;
        if (b != null) {
            boolean b3 = b2;
            if (!b.f()) {
                return b3;
            }
            b3 = b2;
            if ((float)b.b().get(0).b != 0.0f) {
                return b3;
            }
        }
        return true;
    }
    
    private static boolean d(final g g) {
        final boolean b = false;
        if (g != null) {
            boolean b2 = b;
            if (!g.f()) {
                return b2;
            }
            b2 = b;
            if (!((d)g.b().get(0).b).a(1.0f, 1.0f)) {
                return b2;
            }
        }
        return true;
    }
    
    private static boolean e(final b b) {
        final boolean b2 = false;
        if (b != null) {
            boolean b3 = b2;
            if (!b.f()) {
                return b3;
            }
            b3 = b2;
            if ((float)b.b().get(0).b != 0.0f) {
                return b3;
            }
        }
        return true;
    }
    
    private static boolean f(final b b) {
        final boolean b2 = false;
        if (b != null) {
            boolean b3 = b2;
            if (!b.f()) {
                return b3;
            }
            b3 = b2;
            if ((float)b.b().get(0).b != 0.0f) {
                return b3;
            }
        }
        return true;
    }
    
    public static l g(final JsonReader jsonReader, final com.airbnb.lottie.d d) throws IOException {
        final JsonReader.Token u = jsonReader.u();
        final JsonReader.Token begin_OBJECT = JsonReader.Token.BEGIN_OBJECT;
        boolean b = false;
        final boolean b2 = u == begin_OBJECT;
        if (b2) {
            jsonReader.d();
        }
        b f = null;
        e a = null;
        m<PointF, PointF> b3 = null;
        g j = null;
        b f2 = null;
        b f3 = null;
        u1.d h = null;
        b f4 = null;
        b f5 = null;
        while (jsonReader.i()) {
            switch (jsonReader.F(c.a)) {
                default: {
                    jsonReader.L();
                    jsonReader.M();
                    continue;
                }
                case 9: {
                    f3 = d.f(jsonReader, d, b);
                    continue;
                }
                case 8: {
                    f2 = d.f(jsonReader, d, b);
                    continue;
                }
                case 7: {
                    f5 = d.f(jsonReader, d, b);
                    continue;
                }
                case 6: {
                    f4 = d.f(jsonReader, d, b);
                    continue;
                }
                case 5: {
                    h = d.h(jsonReader, d);
                    continue;
                }
                case 3: {
                    d.a("Lottie doesn't support 3D layers.");
                }
                case 4: {
                    f = d.f(jsonReader, d, b);
                    if (f.b().isEmpty()) {
                        f.b().add(new a(d, 0.0f, 0.0f, null, 0.0f, d.f()));
                    }
                    else if (((a)f.b().get(0)).b == null) {
                        f.b().set(0, new a(d, 0.0f, 0.0f, null, 0.0f, d.f()));
                    }
                    b = false;
                    continue;
                }
                case 2: {
                    j = d.j(jsonReader, d);
                    continue;
                }
                case 1: {
                    b3 = x1.a.b(jsonReader, d);
                    continue;
                }
                case 0: {
                    jsonReader.d();
                    while (jsonReader.i()) {
                        if (jsonReader.F(c.b) != 0) {
                            jsonReader.L();
                            jsonReader.M();
                        }
                        else {
                            a = x1.a.a(jsonReader, d);
                        }
                    }
                    jsonReader.h();
                    continue;
                }
            }
        }
        if (b2) {
            jsonReader.h();
        }
        e e;
        if (a(a)) {
            e = null;
        }
        else {
            e = a;
        }
        m<PointF, PointF> m;
        if (b(b3)) {
            m = null;
        }
        else {
            m = b3;
        }
        b b4;
        if (c(f)) {
            b4 = null;
        }
        else {
            b4 = f;
        }
        g g = j;
        if (d(j)) {
            g = null;
        }
        if (f(f2)) {
            f2 = null;
        }
        if (e(f3)) {
            f3 = null;
        }
        return new l(e, m, g, b4, h, f4, f5, f2, f3);
    }
}
