// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import u1.h;
import v1.j;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class g0
{
    static JsonReader.a a;
    
    static {
        g0.a = JsonReader.a.a("nm", "ind", "ks", "hd");
    }
    
    static j a(final JsonReader jsonReader, final d d) throws IOException {
        int l = 0;
        String s = null;
        h k = null;
        boolean j = false;
        while (jsonReader.i()) {
            final int f = jsonReader.F(g0.a);
            if (f != 0) {
                if (f != 1) {
                    if (f != 2) {
                        if (f != 3) {
                            jsonReader.M();
                        }
                        else {
                            j = jsonReader.j();
                        }
                    }
                    else {
                        k = d.k(jsonReader, d);
                    }
                }
                else {
                    l = jsonReader.l();
                }
            }
            else {
                s = jsonReader.s();
            }
        }
        return new j(s, l, k, j);
    }
}
