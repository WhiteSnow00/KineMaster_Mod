// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import u1.b;
import java.util.List;
import java.util.Collections;
import z1.a;
import java.util.ArrayList;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class h0
{
    private static JsonReader.a a;
    private static final JsonReader.a b;
    
    static {
        h0.a = JsonReader.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");
        b = JsonReader.a.a("n", "v");
    }
    
    static ShapeStroke a(final JsonReader jsonReader, final d d) throws IOException {
        final ArrayList list = new ArrayList();
        boolean j = false;
        float n = 0.0f;
        String s = null;
        b b = null;
        u1.a c = null;
        b e = null;
        Enum<ShapeStroke.LineCapType> enum1 = null;
        Enum<ShapeStroke.LineJoinType> enum2 = null;
        u1.d h = null;
        while (jsonReader.i()) {
            switch (jsonReader.F(h0.a)) {
                default: {
                    jsonReader.M();
                    continue;
                }
                case 8: {
                    jsonReader.c();
                    b b2 = b;
                    while (jsonReader.i()) {
                        jsonReader.d();
                        String s2 = null;
                        b e2 = null;
                        while (jsonReader.i()) {
                            final int f = jsonReader.F(h0.b);
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
                        s2.hashCode();
                        int n2 = 0;
                        Label_0292: {
                            switch (s2) {
                                case "o": {
                                    n2 = 2;
                                    break Label_0292;
                                }
                                case "g": {
                                    n2 = 1;
                                    break Label_0292;
                                }
                                case "d": {
                                    n2 = 0;
                                    break Label_0292;
                                }
                                default:
                                    break;
                            }
                            n2 = -1;
                        }
                        switch (n2) {
                            default: {
                                continue;
                            }
                            case 2: {
                                b2 = e2;
                                continue;
                            }
                            case 0:
                            case 1: {
                                d.t(true);
                                list.add(e2);
                                continue;
                            }
                        }
                    }
                    jsonReader.e();
                    b = b2;
                    if (list.size() == 1) {
                        list.add(list.get(0));
                        b = b2;
                        continue;
                    }
                    continue;
                }
                case 7: {
                    j = jsonReader.j();
                    continue;
                }
                case 6: {
                    n = (float)jsonReader.k();
                    continue;
                }
                case 5: {
                    enum2 = ShapeStroke.LineJoinType.values()[jsonReader.l() - 1];
                    continue;
                }
                case 4: {
                    enum1 = ShapeStroke.LineCapType.values()[jsonReader.l() - 1];
                    continue;
                }
                case 3: {
                    h = d.h(jsonReader, d);
                    continue;
                }
                case 2: {
                    e = d.e(jsonReader, d);
                    continue;
                }
                case 1: {
                    c = d.c(jsonReader, d);
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
            d2 = new u1.d(Collections.singletonList(new a<Integer>(100)));
        }
        return new ShapeStroke(s, b, list, c, d2, e, (ShapeStroke.LineCapType)enum1, (ShapeStroke.LineJoinType)enum2, n, j);
    }
}
