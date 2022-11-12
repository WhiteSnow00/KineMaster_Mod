// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import android.graphics.Rect;
import com.airbnb.lottie.model.layer.Layer;
import t1.b;
import java.util.Map;
import t1.c;
import t1.g;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import y1.h;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class t
{
    private static final JsonReader.a a;
    static JsonReader.a b;
    private static final JsonReader.a c;
    private static final JsonReader.a d;
    
    static {
        a = JsonReader.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
        t.b = JsonReader.a.a("id", "layers", "w", "h", "p", "u");
        c = JsonReader.a.a("list");
        d = JsonReader.a.a("cm", "tm", "dr");
    }
    
    public static d a(final JsonReader jsonReader) throws IOException {
        final float e = h.e();
        final androidx.collection.d d = new androidx.collection.d();
        final ArrayList list = new ArrayList();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        final HashMap hashMap3 = new HashMap();
        final ArrayList list2 = new ArrayList();
        final androidx.collection.h h = new androidx.collection.h();
        final d d2 = new d();
        jsonReader.d();
        float n = 0.0f;
        float n3;
        float n2 = n3 = 0.0f;
        int l = 0;
        int i = 0;
        while (jsonReader.i()) {
            switch (jsonReader.F(t.a)) {
                default: {
                    jsonReader.L();
                    jsonReader.M();
                    continue;
                }
                case 10: {
                    f(jsonReader, d2, list2);
                    continue;
                }
                case 9: {
                    c(jsonReader, d2, h);
                    continue;
                }
                case 8: {
                    d(jsonReader, hashMap3);
                    continue;
                }
                case 7: {
                    b(jsonReader, d2, hashMap, hashMap2);
                    continue;
                }
                case 6: {
                    e(jsonReader, d2, list, d);
                    continue;
                }
                case 5: {
                    final String[] split = jsonReader.s().split("\\.");
                    if (!y1.h.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        d2.a("Lottie only supports bodymovin >= 4.4.0");
                        continue;
                    }
                    continue;
                }
                case 4: {
                    n3 = (float)jsonReader.k();
                    continue;
                }
                case 3: {
                    n2 = (float)jsonReader.k() - 0.01f;
                    continue;
                }
                case 2: {
                    n = (float)jsonReader.k();
                    continue;
                }
                case 1: {
                    i = jsonReader.l();
                    continue;
                }
                case 0: {
                    l = jsonReader.l();
                    continue;
                }
            }
        }
        d2.r(new Rect(0, 0, (int)(l * e), (int)(i * e)), n, n2, n3, list, d, hashMap, hashMap2, h, hashMap3, list2);
        return d2;
    }
    
    private static void b(final JsonReader jsonReader, final d d, final Map<String, List<Layer>> map, final Map<String, com.airbnb.lottie.g> map2) throws IOException {
        jsonReader.c();
        while (jsonReader.i()) {
            final ArrayList list = new ArrayList();
            final androidx.collection.d<Layer> d2 = new androidx.collection.d<Layer>();
            jsonReader.d();
            int l = 0;
            int i = 0;
            String s = null;
            String s3;
            String s2 = s3 = null;
            while (jsonReader.i()) {
                final int f = jsonReader.F(t.b);
                if (f != 0) {
                    if (f != 1) {
                        if (f != 2) {
                            if (f != 3) {
                                if (f != 4) {
                                    if (f != 5) {
                                        jsonReader.L();
                                        jsonReader.M();
                                    }
                                    else {
                                        s3 = jsonReader.s();
                                    }
                                }
                                else {
                                    s2 = jsonReader.s();
                                }
                            }
                            else {
                                i = jsonReader.l();
                            }
                        }
                        else {
                            l = jsonReader.l();
                        }
                    }
                    else {
                        jsonReader.c();
                        while (jsonReader.i()) {
                            final Layer b = x1.s.b(jsonReader, d);
                            d2.l(b.b(), b);
                            list.add(b);
                        }
                        jsonReader.e();
                    }
                }
                else {
                    s = jsonReader.s();
                }
            }
            jsonReader.h();
            if (s2 != null) {
                final com.airbnb.lottie.g g = new com.airbnb.lottie.g(l, i, s, s2, s3);
                map2.put(g.d(), g);
            }
            else {
                map.put(s, list);
            }
        }
        jsonReader.e();
    }
    
    private static void c(final JsonReader jsonReader, final d d, final androidx.collection.h<c> h) throws IOException {
        jsonReader.c();
        while (jsonReader.i()) {
            final c a = j.a(jsonReader, d);
            h.n(a.hashCode(), a);
        }
        jsonReader.e();
    }
    
    private static void d(final JsonReader jsonReader, final Map<String, b> map) throws IOException {
        jsonReader.d();
        while (jsonReader.i()) {
            if (jsonReader.F(t.c) != 0) {
                jsonReader.L();
                jsonReader.M();
            }
            else {
                jsonReader.c();
                while (jsonReader.i()) {
                    final b a = k.a(jsonReader);
                    map.put(a.b(), a);
                }
                jsonReader.e();
            }
        }
        jsonReader.h();
    }
    
    private static void e(final JsonReader jsonReader, final d d, final List<Layer> list, final androidx.collection.d<Layer> d2) throws IOException {
        jsonReader.c();
        int n = 0;
        while (jsonReader.i()) {
            final Layer b = s.b(jsonReader, d);
            int n2 = n;
            if (b.d() == Layer.LayerType.IMAGE) {
                n2 = n + 1;
            }
            list.add(b);
            d2.l(b.b(), b);
            if ((n = n2) > 4) {
                final StringBuilder sb = new StringBuilder();
                sb.append("You have ");
                sb.append(n2);
                sb.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                y1.d.c(sb.toString());
                n = n2;
            }
        }
        jsonReader.e();
    }
    
    private static void f(final JsonReader jsonReader, final d d, final List<g> list) throws IOException {
        jsonReader.c();
        while (jsonReader.i()) {
            String s = null;
            jsonReader.d();
            float n = 0.0f;
            float n2 = 0.0f;
            while (jsonReader.i()) {
                final int f = jsonReader.F(t.d);
                if (f != 0) {
                    if (f != 1) {
                        if (f != 2) {
                            jsonReader.L();
                            jsonReader.M();
                        }
                        else {
                            n2 = (float)jsonReader.k();
                        }
                    }
                    else {
                        n = (float)jsonReader.k();
                    }
                }
                else {
                    s = jsonReader.s();
                }
            }
            jsonReader.h();
            list.add(new g(s, n, n2));
        }
        jsonReader.e();
    }
}
