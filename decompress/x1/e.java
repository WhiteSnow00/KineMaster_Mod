// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import android.graphics.PointF;
import u1.m;
import u1.f;
import v1.a;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class e
{
    private static JsonReader.a a;
    
    static {
        e.a = JsonReader.a.a("nm", "p", "s", "hd", "d");
    }
    
    static a a(final JsonReader jsonReader, final d d, int f) throws IOException {
        boolean b = f == 3;
        boolean j = false;
        String s = null;
        f i;
        m<PointF, PointF> b2 = i = null;
        while (jsonReader.i()) {
            f = jsonReader.F(e.a);
            if (f != 0) {
                if (f != 1) {
                    if (f != 2) {
                        if (f != 3) {
                            if (f != 4) {
                                jsonReader.L();
                                jsonReader.M();
                            }
                            else {
                                b = (jsonReader.l() == 3);
                            }
                        }
                        else {
                            j = jsonReader.j();
                        }
                    }
                    else {
                        i = d.i(jsonReader, d);
                    }
                }
                else {
                    b2 = x1.a.b(jsonReader, d);
                }
            }
            else {
                s = jsonReader.s();
            }
        }
        return new a(s, b2, i, b, j);
    }
}
