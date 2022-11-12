// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import v1.b;
import java.util.List;
import java.util.ArrayList;
import v1.i;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class f0
{
    private static JsonReader.a a;
    
    static {
        f0.a = JsonReader.a.a("nm", "hd", "it");
    }
    
    static i a(final JsonReader jsonReader, final d d) throws IOException {
        final ArrayList list = new ArrayList();
        String s = null;
        boolean j = false;
        while (jsonReader.i()) {
            final int f = jsonReader.F(f0.a);
            if (f != 0) {
                if (f != 1) {
                    if (f != 2) {
                        jsonReader.M();
                    }
                    else {
                        jsonReader.c();
                        while (jsonReader.i()) {
                            final b a = g.a(jsonReader, d);
                            if (a != null) {
                                list.add(a);
                            }
                        }
                        jsonReader.e();
                    }
                }
                else {
                    j = jsonReader.j();
                }
            }
            else {
                s = jsonReader.s();
            }
        }
        return new i(s, list, j);
    }
}
