// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import com.airbnb.lottie.model.content.Mask;
import java.util.List;
import android.view.animation.Interpolator;
import z1.a;
import android.graphics.Color;
import y1.h;
import java.util.ArrayList;
import android.graphics.Rect;
import u1.b;
import u1.k;
import u1.j;
import u1.l;
import java.util.Collections;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class s
{
    private static final JsonReader.a a;
    private static final JsonReader.a b;
    private static final JsonReader.a c;
    
    static {
        a = JsonReader.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");
        b = JsonReader.a.a("d", "a");
        c = JsonReader.a.a("nm");
    }
    
    public static Layer a(final d d) {
        final Rect b = d.b();
        return new Layer(Collections.emptyList(), d, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new l(), 0, 0, 0, 0.0f, 0.0f, b.width(), b.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
    }
    
    public static Layer b(final JsonReader jsonReader, final d d) throws IOException {
        Enum<Layer.MatteType> none = Layer.MatteType.NONE;
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        jsonReader.d();
        final Float value = 1.0f;
        final Float value2 = 0.0f;
        float n = 1.0f;
        int n2 = 0;
        int n3 = 0;
        int n4;
        int color = n4 = n3;
        int j;
        int n5 = j = n4;
        final Layer.LayerType layerType = null;
        final b b = null;
        final b b3;
        final b b2 = b3 = b;
        b f;
        final b b4 = f = b3;
        float n6 = 0.0f;
        float n8;
        float n7 = n8 = 0.0f;
        long n9 = -1L;
        long n10 = 0L;
        Object s = f;
        final String s2 = "UNSET";
        Object a = b4;
        Object d2 = b3;
        Object g = b2;
        Object s3 = b;
        Enum<Layer.LayerType> unknown = layerType;
        String s4 = s2;
        while (jsonReader.i()) {
            switch (jsonReader.F(x1.s.a)) {
                default: {
                    jsonReader.L();
                    jsonReader.M();
                    continue;
                }
                case 22: {
                    j = (jsonReader.j() ? 1 : 0);
                    continue;
                }
                case 21: {
                    s = jsonReader.s();
                    continue;
                }
                case 20: {
                    f = d.f(jsonReader, d, false);
                    continue;
                }
                case 19: {
                    n7 = (float)jsonReader.k();
                    continue;
                }
                case 18: {
                    n6 = (float)jsonReader.k();
                    continue;
                }
                case 17: {
                    n5 = (int)(jsonReader.l() * h.e());
                    continue;
                }
                case 16: {
                    n4 = (int)(jsonReader.l() * h.e());
                    continue;
                }
                case 15: {
                    n8 = (float)jsonReader.k();
                    continue;
                }
                case 14: {
                    n = (float)jsonReader.k();
                    continue;
                }
                case 13: {
                    jsonReader.c();
                    final ArrayList list3 = new ArrayList();
                    while (jsonReader.i()) {
                        jsonReader.d();
                        while (jsonReader.i()) {
                            if (jsonReader.F(x1.s.c) != 0) {
                                jsonReader.L();
                                jsonReader.M();
                            }
                            else {
                                list3.add(jsonReader.s());
                            }
                        }
                        jsonReader.h();
                    }
                    jsonReader.e();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ");
                    sb.append(list3);
                    d.a(sb.toString());
                    continue;
                }
                case 12: {
                    jsonReader.d();
                    while (jsonReader.i()) {
                        final int f2 = jsonReader.F(x1.s.b);
                        if (f2 != 0) {
                            if (f2 != 1) {
                                jsonReader.L();
                                jsonReader.M();
                            }
                            else {
                                jsonReader.c();
                                if (jsonReader.i()) {
                                    a = x1.b.a(jsonReader, d);
                                }
                                while (jsonReader.i()) {
                                    jsonReader.M();
                                }
                                jsonReader.e();
                            }
                        }
                        else {
                            d2 = d.d(jsonReader, d);
                        }
                    }
                    jsonReader.h();
                    continue;
                }
                case 11: {
                    jsonReader.c();
                    while (jsonReader.i()) {
                        final v1.b a2 = x1.g.a(jsonReader, d);
                        if (a2 != null) {
                            list2.add(a2);
                        }
                    }
                    jsonReader.e();
                    continue;
                }
                case 10: {
                    jsonReader.c();
                    while (jsonReader.i()) {
                        list.add(u.a(jsonReader, d));
                    }
                    d.q(list.size());
                    jsonReader.e();
                    continue;
                }
                case 9: {
                    final int l = jsonReader.l();
                    if (l >= Layer.MatteType.values().length) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unsupported matte type: ");
                        sb2.append(l);
                        d.a(sb2.toString());
                        continue;
                    }
                    none = Layer.MatteType.values()[l];
                    final int n11 = s$a.a[none.ordinal()];
                    if (n11 != 1) {
                        if (n11 == 2) {
                            d.a("Unsupported matte type: Luma Inverted");
                        }
                    }
                    else {
                        d.a("Unsupported matte type: Luma");
                    }
                    d.q(1);
                    continue;
                }
                case 8: {
                    g = x1.c.g(jsonReader, d);
                    continue;
                }
                case 7: {
                    color = Color.parseColor(jsonReader.s());
                    continue;
                }
                case 6: {
                    n3 = (int)(jsonReader.l() * h.e());
                    continue;
                }
                case 5: {
                    n2 = (int)(jsonReader.l() * h.e());
                    continue;
                }
                case 4: {
                    n9 = jsonReader.l();
                    continue;
                }
                case 3: {
                    final int i = jsonReader.l();
                    if (i < (unknown = Layer.LayerType.UNKNOWN).ordinal()) {
                        unknown = Layer.LayerType.values()[i];
                        continue;
                    }
                    continue;
                }
                case 2: {
                    s3 = jsonReader.s();
                    continue;
                }
                case 1: {
                    n10 = jsonReader.l();
                    continue;
                }
                case 0: {
                    s4 = jsonReader.s();
                    continue;
                }
            }
        }
        jsonReader.h();
        final float n12 = n6 / n;
        float f3 = n7 / n;
        final ArrayList list4 = new ArrayList();
        if (n12 > 0.0f) {
            list4.add(new a(d, value2, value2, null, 0.0f, n12));
        }
        if (f3 <= 0.0f) {
            f3 = d.f();
        }
        list4.add(new a(d, value, value, null, n12, f3));
        list4.add(new a(d, value2, value2, null, f3, Float.MAX_VALUE));
        if (s4.endsWith(".ai") || "ai".equals(s)) {
            d.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(list2, d, s4, n10, (Layer.LayerType)unknown, n9, (String)s3, list, (l)g, n2, n3, color, n, n8, n4, n5, (j)d2, (k)a, list4, (Layer.MatteType)none, f, (boolean)(j != 0));
    }
}
