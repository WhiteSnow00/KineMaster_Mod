// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import u1.l;
import u1.b;
import v1.f;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class b0
{
    private static JsonReader.a a;
    
    static {
        b0.a = JsonReader.a.a("nm", "c", "o", "tr", "hd");
    }
    
    static f a(final JsonReader jsonReader, final d d) throws IOException {
        boolean j = false;
        String s = null;
        Object f = null;
        Object g;
        b f2 = (b)(g = f);
        while (jsonReader.i()) {
            final int f3 = jsonReader.F(b0.a);
            if (f3 != 0) {
                if (f3 != 1) {
                    if (f3 != 2) {
                        if (f3 != 3) {
                            if (f3 != 4) {
                                jsonReader.M();
                            }
                            else {
                                j = jsonReader.j();
                            }
                        }
                        else {
                            g = c.g(jsonReader, d);
                        }
                    }
                    else {
                        f2 = d.f(jsonReader, d, false);
                    }
                }
                else {
                    f = d.f(jsonReader, d, false);
                }
            }
            else {
                s = jsonReader.s();
            }
        }
        return new f(s, (b)f, f2, (l)g, j);
    }
}
