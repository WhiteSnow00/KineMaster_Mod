// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import u1.f;
import u1.b;
import u1.c;
import java.util.Collections;
import z1.a;
import com.airbnb.lottie.model.content.GradientType;
import android.graphics.Path$FillType;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class m
{
    private static final JsonReader.a a;
    private static final JsonReader.a b;
    
    static {
        a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", "r", "hd");
        b = JsonReader.a.a("p", "k");
    }
    
    static v1.d a(final JsonReader jsonReader, final d d) throws IOException {
        Path$FillType winding = Path$FillType.WINDING;
        final u1.d d2 = null;
        String s = null;
        final f f;
        Object o = f = null;
        f i = f;
        boolean j = false;
        f k = i;
        Object g = f;
        u1.d h = d2;
        while (jsonReader.i()) {
            switch (jsonReader.F(m.a)) {
                default: {
                    jsonReader.L();
                    jsonReader.M();
                    continue;
                }
                case 7: {
                    j = jsonReader.j();
                    continue;
                }
                case 6: {
                    Path$FillType path$FillType;
                    if (jsonReader.l() == 1) {
                        path$FillType = Path$FillType.WINDING;
                    }
                    else {
                        path$FillType = Path$FillType.EVEN_ODD;
                    }
                    winding = path$FillType;
                    continue;
                }
                case 5: {
                    i = d.i(jsonReader, d);
                    continue;
                }
                case 4: {
                    k = d.i(jsonReader, d);
                    continue;
                }
                case 3: {
                    GradientType gradientType;
                    if (jsonReader.l() == 1) {
                        gradientType = GradientType.LINEAR;
                    }
                    else {
                        gradientType = GradientType.RADIAL;
                    }
                    o = gradientType;
                    continue;
                }
                case 2: {
                    h = d.h(jsonReader, d);
                    continue;
                }
                case 1: {
                    int l = -1;
                    jsonReader.d();
                    while (jsonReader.i()) {
                        final int f2 = jsonReader.F(m.b);
                        if (f2 != 0) {
                            if (f2 != 1) {
                                jsonReader.L();
                                jsonReader.M();
                            }
                            else {
                                g = d.g(jsonReader, d, l);
                            }
                        }
                        else {
                            l = jsonReader.l();
                        }
                    }
                    jsonReader.h();
                    continue;
                }
                case 0: {
                    s = jsonReader.s();
                    continue;
                }
            }
        }
        if (h == null) {
            h = new u1.d(Collections.singletonList(new a<Integer>(100)));
        }
        return new v1.d(s, (GradientType)o, winding, (c)g, h, k, i, null, null, j);
    }
}
