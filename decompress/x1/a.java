// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import u1.b;
import u1.i;
import u1.m;
import java.io.IOException;
import android.graphics.PointF;
import y1.h;
import java.util.List;
import java.util.ArrayList;
import u1.e;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class a
{
    private static final JsonReader.a a;
    
    static {
        a = JsonReader.a.a("k", "x", "y");
    }
    
    public static e a(final JsonReader jsonReader, final d d) throws IOException {
        final ArrayList list = new ArrayList();
        if (jsonReader.u() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            while (jsonReader.i()) {
                list.add(w.a(jsonReader, d));
            }
            jsonReader.e();
            r.b((List<? extends z1.a<Object>>)list);
        }
        else {
            list.add(new z1.a(p.e(jsonReader, h.e())));
        }
        return new e(list);
    }
    
    static m<PointF, PointF> b(final JsonReader jsonReader, final d d) throws IOException {
        jsonReader.d();
        m<PointF, PointF> a = null;
        b e = null;
        boolean b = false;
        b e2 = null;
        while (jsonReader.u() != JsonReader.Token.END_OBJECT) {
            final int f = jsonReader.F(x1.a.a);
            if (f != 0) {
                if (f != 1) {
                    if (f != 2) {
                        jsonReader.L();
                        jsonReader.M();
                        continue;
                    }
                    if (jsonReader.u() != JsonReader.Token.STRING) {
                        e = d.e(jsonReader, d);
                        continue;
                    }
                    jsonReader.M();
                }
                else {
                    if (jsonReader.u() != JsonReader.Token.STRING) {
                        e2 = d.e(jsonReader, d);
                        continue;
                    }
                    jsonReader.M();
                }
                b = true;
            }
            else {
                a = a(jsonReader, d);
            }
        }
        jsonReader.h();
        if (b) {
            d.a("Lottie doesn't support expressions.");
        }
        if (a != null) {
            return a;
        }
        return new i(e2, e);
    }
}
