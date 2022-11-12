// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.util.List;
import t1.a;
import java.util.ArrayList;
import java.util.Collections;
import android.graphics.PointF;
import java.io.IOException;
import com.airbnb.lottie.parser.moshi.JsonReader;
import v1.g;

public class d0 implements j0<g>
{
    public static final d0 a;
    private static final JsonReader.a b;
    
    static {
        a = new d0();
        b = JsonReader.a.a("c", "v", "i", "o");
    }
    
    private d0() {
    }
    
    @Override
    public /* bridge */ Object a(final JsonReader jsonReader, final float n) throws IOException {
        return this.b(jsonReader, n);
    }
    
    public g b(final JsonReader jsonReader, final float n) throws IOException {
        if (jsonReader.u() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
        }
        jsonReader.d();
        List<PointF> f = null;
        List<PointF> f2 = null;
        List<PointF> f3 = null;
        boolean j = false;
        while (jsonReader.i()) {
            final int f4 = jsonReader.F(d0.b);
            if (f4 != 0) {
                if (f4 != 1) {
                    if (f4 != 2) {
                        if (f4 != 3) {
                            jsonReader.L();
                            jsonReader.M();
                        }
                        else {
                            f3 = p.f(jsonReader, n);
                        }
                    }
                    else {
                        f2 = p.f(jsonReader, n);
                    }
                }
                else {
                    f = p.f(jsonReader, n);
                }
            }
            else {
                j = jsonReader.j();
            }
        }
        jsonReader.h();
        if (jsonReader.u() == JsonReader.Token.END_ARRAY) {
            jsonReader.e();
        }
        if (f == null || f2 == null || f3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (f.isEmpty()) {
            return new g(new PointF(), false, Collections.emptyList());
        }
        final int size = f.size();
        final PointF pointF = f.get(0);
        final ArrayList list = new ArrayList(size);
        for (int i = 1; i < size; ++i) {
            final PointF pointF2 = f.get(i);
            final int n2 = i - 1;
            list.add((Object)new a(y1.g.a(f.get(n2), f3.get(n2)), y1.g.a(pointF2, f2.get(i)), pointF2));
        }
        if (j) {
            final PointF pointF3 = f.get(0);
            final int n3 = size - 1;
            list.add((Object)new a(y1.g.a(f.get(n3), f3.get(n3)), y1.g.a(pointF3, f2.get(0)), pointF3));
        }
        return new g(pointF, j, (List<a>)list);
    }
}
