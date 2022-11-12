// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import u1.b;
import android.graphics.PointF;
import u1.m;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class z
{
    private static final JsonReader.a a;
    
    static {
        a = JsonReader.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");
    }
    
    static PolystarShape a(final JsonReader jsonReader, final d d) throws IOException {
        boolean j = false;
        String s = null;
        b f;
        Object forValue = f = null;
        b f2;
        Object b = f2 = f;
        b e2;
        b e = e2 = f2;
        b f4;
        b f3 = f4 = e2;
        while (jsonReader.i()) {
            switch (jsonReader.F(z.a)) {
                default: {
                    jsonReader.L();
                    jsonReader.M();
                    continue;
                }
                case 9: {
                    j = jsonReader.j();
                    continue;
                }
                case 8: {
                    f3 = d.f(jsonReader, d, false);
                    continue;
                }
                case 7: {
                    e = d.e(jsonReader, d);
                    continue;
                }
                case 6: {
                    f4 = d.f(jsonReader, d, false);
                    continue;
                }
                case 5: {
                    e2 = d.e(jsonReader, d);
                    continue;
                }
                case 4: {
                    f2 = d.f(jsonReader, d, false);
                    continue;
                }
                case 3: {
                    b = x1.a.b(jsonReader, d);
                    continue;
                }
                case 2: {
                    f = d.f(jsonReader, d, false);
                    continue;
                }
                case 1: {
                    forValue = PolystarShape.Type.forValue(jsonReader.l());
                    continue;
                }
                case 0: {
                    s = jsonReader.s();
                    continue;
                }
            }
        }
        return new PolystarShape(s, (PolystarShape.Type)forValue, f, (m<PointF, PointF>)b, f2, e, e2, f3, f4, j);
    }
}
