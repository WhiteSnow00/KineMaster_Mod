// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import u1.f;
import u1.c;
import u1.b;
import java.util.List;
import java.util.Collections;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.ArrayList;
import com.airbnb.lottie.model.content.a;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class n
{
    private static JsonReader.a a;
    private static final JsonReader.a b;
    private static final JsonReader.a c;
    
    static {
        n.a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");
        b = JsonReader.a.a("p", "k");
        c = JsonReader.a.a("n", "v");
    }
    
    static a a(final JsonReader jsonReader, final d d) throws IOException {
        final ArrayList list = new ArrayList();
        float n = 0.0f;
        String s = null;
        GradientType gradientType = null;
        c c = null;
        f i = null;
        f j = null;
        b e = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        b b = null;
        boolean k = false;
        u1.d h = null;
        while (jsonReader.i()) {
            switch (jsonReader.F(x1.n.a)) {
                default: {
                    jsonReader.L();
                    jsonReader.M();
                    continue;
                }
                case 11: {
                    jsonReader.c();
                    while (jsonReader.i()) {
                        jsonReader.d();
                        String s2 = null;
                        b e2 = null;
                        while (jsonReader.i()) {
                            final int f = jsonReader.F(x1.n.c);
                            if (f != 0) {
                                if (f != 1) {
                                    jsonReader.L();
                                    jsonReader.M();
                                }
                                else {
                                    e2 = d.e(jsonReader, d);
                                }
                            }
                            else {
                                s2 = jsonReader.s();
                            }
                        }
                        jsonReader.h();
                        if (s2.equals("o")) {
                            b = e2;
                        }
                        else {
                            if (!s2.equals("d") && !s2.equals("g")) {
                                continue;
                            }
                            d.t(true);
                            list.add(e2);
                        }
                    }
                    jsonReader.e();
                    if (list.size() != 1) {
                        continue;
                    }
                    list.add(list.get(0));
                    continue;
                }
                case 10: {
                    k = jsonReader.j();
                    continue;
                }
                case 9: {
                    n = (float)jsonReader.k();
                    continue;
                }
                case 8: {
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.l() - 1];
                    continue;
                }
                case 7: {
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.l() - 1];
                    continue;
                }
                case 6: {
                    e = d.e(jsonReader, d);
                    continue;
                }
                case 5: {
                    j = d.i(jsonReader, d);
                    continue;
                }
                case 4: {
                    i = d.i(jsonReader, d);
                    continue;
                }
                case 3: {
                    GradientType gradientType2;
                    if (jsonReader.l() == 1) {
                        gradientType2 = GradientType.LINEAR;
                    }
                    else {
                        gradientType2 = GradientType.RADIAL;
                    }
                    gradientType = gradientType2;
                    continue;
                }
                case 2: {
                    h = d.h(jsonReader, d);
                    continue;
                }
                case 1: {
                    int l = -1;
                    jsonReader.d();
                    c g = c;
                    while (jsonReader.i()) {
                        final int f2 = jsonReader.F(x1.n.b);
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
                    c = g;
                    continue;
                }
                case 0: {
                    s = jsonReader.s();
                    continue;
                }
            }
        }
        u1.d d2;
        if ((d2 = h) == null) {
            d2 = new u1.d(Collections.singletonList(new z1.a<Integer>(100)));
        }
        return new a(s, gradientType, c, d2, i, j, e, lineCapType, lineJoinType, n, list, b, k);
    }
}
