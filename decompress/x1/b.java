// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import u1.a;
import u1.k;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class b
{
    private static JsonReader.a a;
    private static JsonReader.a b;
    
    static {
        x1.b.a = JsonReader.a.a("a");
        x1.b.b = JsonReader.a.a("fc", "sc", "sw", "t");
    }
    
    public static k a(final JsonReader jsonReader, final d d) throws IOException {
        jsonReader.d();
        k b = null;
        while (jsonReader.i()) {
            if (jsonReader.F(x1.b.a) != 0) {
                jsonReader.L();
                jsonReader.M();
            }
            else {
                b = b(jsonReader, d);
            }
        }
        jsonReader.h();
        if (b == null) {
            return new k(null, null, null, null);
        }
        return b;
    }
    
    private static k b(final JsonReader jsonReader, final d d) throws IOException {
        jsonReader.d();
        a c = null;
        a c2 = null;
        u1.b e2;
        u1.b e = e2 = null;
        while (jsonReader.i()) {
            final int f = jsonReader.F(x1.b.b);
            if (f != 0) {
                if (f != 1) {
                    if (f != 2) {
                        if (f != 3) {
                            jsonReader.L();
                            jsonReader.M();
                        }
                        else {
                            e2 = d.e(jsonReader, d);
                        }
                    }
                    else {
                        e = d.e(jsonReader, d);
                    }
                }
                else {
                    c2 = d.c(jsonReader, d);
                }
            }
            else {
                c = d.c(jsonReader, d);
            }
        }
        jsonReader.h();
        return new k(c, c2, e, e2);
    }
}
