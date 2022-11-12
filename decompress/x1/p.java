// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.util.ArrayList;
import java.util.List;
import android.graphics.Color;
import java.io.IOException;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;

class p
{
    private static final JsonReader.a a;
    
    static {
        a = JsonReader.a.a("x", "y");
    }
    
    private static PointF a(final JsonReader jsonReader, final float n) throws IOException {
        jsonReader.c();
        final float n2 = (float)jsonReader.k();
        final float n3 = (float)jsonReader.k();
        while (jsonReader.u() != JsonReader.Token.END_ARRAY) {
            jsonReader.M();
        }
        jsonReader.e();
        return new PointF(n2 * n, n3 * n);
    }
    
    private static PointF b(final JsonReader jsonReader, final float n) throws IOException {
        final float n2 = (float)jsonReader.k();
        final float n3 = (float)jsonReader.k();
        while (jsonReader.i()) {
            jsonReader.M();
        }
        return new PointF(n2 * n, n3 * n);
    }
    
    private static PointF c(final JsonReader jsonReader, final float n) throws IOException {
        jsonReader.d();
        float g = 0.0f;
        float g2 = 0.0f;
        while (jsonReader.i()) {
            final int f = jsonReader.F(p.a);
            if (f != 0) {
                if (f != 1) {
                    jsonReader.L();
                    jsonReader.M();
                }
                else {
                    g2 = g(jsonReader);
                }
            }
            else {
                g = g(jsonReader);
            }
        }
        jsonReader.h();
        return new PointF(g * n, g2 * n);
    }
    
    static int d(final JsonReader jsonReader) throws IOException {
        jsonReader.c();
        final int n = (int)(jsonReader.k() * 255.0);
        final int n2 = (int)(jsonReader.k() * 255.0);
        final int n3 = (int)(jsonReader.k() * 255.0);
        while (jsonReader.i()) {
            jsonReader.M();
        }
        jsonReader.e();
        return Color.argb(255, n, n2, n3);
    }
    
    static PointF e(final JsonReader jsonReader, final float n) throws IOException {
        final int n2 = p$a.a[jsonReader.u().ordinal()];
        if (n2 == 1) {
            return b(jsonReader, n);
        }
        if (n2 == 2) {
            return a(jsonReader, n);
        }
        if (n2 == 3) {
            return c(jsonReader, n);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unknown point starts with ");
        sb.append(jsonReader.u());
        throw new IllegalArgumentException(sb.toString());
    }
    
    static List<PointF> f(final JsonReader jsonReader, final float n) throws IOException {
        final ArrayList list = new ArrayList();
        jsonReader.c();
        while (jsonReader.u() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            list.add(e(jsonReader, n));
            jsonReader.e();
        }
        jsonReader.e();
        return list;
    }
    
    static float g(final JsonReader jsonReader) throws IOException {
        final JsonReader.Token u = jsonReader.u();
        final int n = p$a.a[u.ordinal()];
        if (n == 1) {
            return (float)jsonReader.k();
        }
        if (n == 2) {
            jsonReader.c();
            final float n2 = (float)jsonReader.k();
            while (jsonReader.i()) {
                jsonReader.M();
            }
            jsonReader.e();
            return n2;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unknown value for token of type ");
        sb.append(u);
        throw new IllegalArgumentException(sb.toString());
    }
}
