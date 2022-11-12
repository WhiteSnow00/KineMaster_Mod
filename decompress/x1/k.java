// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import t1.b;
import com.airbnb.lottie.parser.moshi.JsonReader;

class k
{
    private static final JsonReader.a a;
    
    static {
        a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");
    }
    
    static b a(final JsonReader jsonReader) throws IOException {
        jsonReader.d();
        String s = null;
        String s2 = null;
        float n = 0.0f;
        String s3 = null;
        while (jsonReader.i()) {
            final int f = jsonReader.F(k.a);
            if (f != 0) {
                if (f != 1) {
                    if (f != 2) {
                        if (f != 3) {
                            jsonReader.L();
                            jsonReader.M();
                        }
                        else {
                            n = (float)jsonReader.k();
                        }
                    }
                    else {
                        s2 = jsonReader.s();
                    }
                }
                else {
                    s3 = jsonReader.s();
                }
            }
            else {
                s = jsonReader.s();
            }
        }
        jsonReader.h();
        return new b(s, s3, s2, n);
    }
}
