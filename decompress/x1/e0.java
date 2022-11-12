// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import android.graphics.Path$FillType;
import java.util.Collections;
import z1.a;
import v1.h;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class e0
{
    private static final JsonReader.a a;
    
    static {
        a = JsonReader.a.a("nm", "c", "o", "fillEnabled", "r", "hd");
    }
    
    static h a(final JsonReader jsonReader, final d d) throws IOException {
        u1.d h = null;
        boolean j = false;
        boolean i = false;
        int l = 1;
        String s = null;
        u1.a c = null;
        while (jsonReader.i()) {
            final int f = jsonReader.F(e0.a);
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
                                    i = jsonReader.j();
                                }
                            }
                            else {
                                l = jsonReader.l();
                            }
                        }
                        else {
                            j = jsonReader.j();
                        }
                    }
                    else {
                        h = d.h(jsonReader, d);
                    }
                }
                else {
                    c = d.c(jsonReader, d);
                }
            }
            else {
                s = jsonReader.s();
            }
        }
        u1.d d2;
        if (h == null) {
            d2 = new u1.d(Collections.singletonList(new a<Integer>(100)));
        }
        else {
            d2 = h;
        }
        Path$FillType path$FillType;
        if (l == 1) {
            path$FillType = Path$FillType.WINDING;
        }
        else {
            path$FillType = Path$FillType.EVEN_ODD;
        }
        return new h(s, j, path$FillType, c, d2, i);
    }
}
