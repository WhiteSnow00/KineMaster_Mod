// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import u1.g;
import android.graphics.PointF;
import u1.c;
import u1.b;
import com.airbnb.lottie.model.DocumentData;
import u1.j;
import java.io.IOException;
import z1.a;
import java.util.List;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class d
{
    private static <T> List<a<T>> a(final JsonReader jsonReader, final float n, final com.airbnb.lottie.d d, final j0<T> j0) throws IOException {
        return r.a(jsonReader, d, n, j0, false);
    }
    
    private static <T> List<a<T>> b(final JsonReader jsonReader, final com.airbnb.lottie.d d, final j0<T> j0) throws IOException {
        return r.a(jsonReader, d, 1.0f, j0, false);
    }
    
    static u1.a c(final JsonReader jsonReader, final com.airbnb.lottie.d d) throws IOException {
        return new u1.a(b(jsonReader, d, (j0<Integer>)f.a));
    }
    
    static j d(final JsonReader jsonReader, final com.airbnb.lottie.d d) throws IOException {
        return new j(b(jsonReader, d, (j0<DocumentData>)h.a));
    }
    
    public static b e(final JsonReader jsonReader, final com.airbnb.lottie.d d) throws IOException {
        return f(jsonReader, d, true);
    }
    
    public static b f(final JsonReader jsonReader, final com.airbnb.lottie.d d, final boolean b) throws IOException {
        float e;
        if (b) {
            e = y1.h.e();
        }
        else {
            e = 1.0f;
        }
        return new b(a(jsonReader, e, d, (j0<Float>)i.a));
    }
    
    static c g(final JsonReader jsonReader, final com.airbnb.lottie.d d, final int n) throws IOException {
        return new c(b(jsonReader, d, (j0<v1.c>)new l(n)));
    }
    
    static u1.d h(final JsonReader jsonReader, final com.airbnb.lottie.d d) throws IOException {
        return new u1.d(b(jsonReader, d, (j0<Integer>)o.a));
    }
    
    static u1.f i(final JsonReader jsonReader, final com.airbnb.lottie.d d) throws IOException {
        return new u1.f(r.a(jsonReader, d, y1.h.e(), (j0<PointF>)y.a, true));
    }
    
    static g j(final JsonReader jsonReader, final com.airbnb.lottie.d d) throws IOException {
        return new g(b(jsonReader, d, (j0<z1.d>)c0.a));
    }
    
    static u1.h k(final JsonReader jsonReader, final com.airbnb.lottie.d d) throws IOException {
        return new u1.h(a(jsonReader, y1.h.e(), d, (j0<v1.g>)d0.a));
    }
}
