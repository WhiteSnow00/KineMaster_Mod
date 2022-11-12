// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import r1.h;
import java.io.IOException;
import java.util.ArrayList;
import z1.a;
import java.util.List;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class r
{
    static JsonReader.a a;
    
    static {
        r.a = JsonReader.a.a("k");
    }
    
    static <T> List<a<T>> a(final JsonReader jsonReader, final d d, final float n, final j0<T> j0, final boolean b) throws IOException {
        final ArrayList list = new ArrayList();
        if (jsonReader.u() == JsonReader.Token.STRING) {
            d.a("Lottie doesn't support expressions.");
            return list;
        }
        jsonReader.d();
        while (jsonReader.i()) {
            if (jsonReader.F(r.a) != 0) {
                jsonReader.M();
            }
            else if (jsonReader.u() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.c();
                if (jsonReader.u() == JsonReader.Token.NUMBER) {
                    list.add(q.c(jsonReader, d, n, j0, false, b));
                }
                else {
                    while (jsonReader.i()) {
                        list.add(q.c(jsonReader, d, n, j0, true, b));
                    }
                }
                jsonReader.e();
            }
            else {
                list.add(q.c(jsonReader, d, n, j0, false, b));
            }
        }
        jsonReader.h();
        b((List<? extends a<Object>>)list);
        return list;
    }
    
    public static <T> void b(final List<? extends a<T>> list) {
        final int size = list.size();
        int n = 0;
        int n2;
        while (true) {
            n2 = size - 1;
            if (n >= n2) {
                break;
            }
            final a a = list.get(n);
            final int n3 = n + 1;
            final a a2 = list.get(n3);
            a.h = a2.g;
            n = n3;
            if (a.c != null) {
                continue;
            }
            final T b = a2.b;
            n = n3;
            if (b == null) {
                continue;
            }
            a.c = b;
            n = n3;
            if (!(a instanceof h)) {
                continue;
            }
            ((h)a).i();
            n = n3;
        }
        final a a3 = list.get(n2);
        if ((a3.b == null || a3.c == null) && list.size() > 1) {
            list.remove(a3);
        }
    }
}
