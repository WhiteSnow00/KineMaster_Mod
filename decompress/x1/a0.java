// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import u1.b;
import android.graphics.PointF;
import u1.m;
import v1.e;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class a0
{
    private static JsonReader.a a;
    
    static {
        a0.a = JsonReader.a.a("nm", "p", "s", "r", "hd");
    }
    
    static e a(final JsonReader jsonReader, final d d) throws IOException {
        String s = null;
        Object b = null;
        Object e;
        m<PointF, PointF> i = (m<PointF, PointF>)(e = b);
        boolean j = false;
        while (jsonReader.i()) {
            final int f = jsonReader.F(a0.a);
            if (f != 0) {
                if (f != 1) {
                    if (f != 2) {
                        if (f != 3) {
                            if (f != 4) {
                                jsonReader.M();
                            }
                            else {
                                j = jsonReader.j();
                            }
                        }
                        else {
                            e = d.e(jsonReader, d);
                        }
                    }
                    else {
                        i = d.i(jsonReader, d);
                    }
                }
                else {
                    b = x1.a.b(jsonReader, d);
                }
            }
            else {
                s = jsonReader.s();
            }
        }
        return new e(s, (m<PointF, PointF>)b, i, (b)e, j);
    }
}
