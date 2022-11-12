// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import u1.b;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class i0
{
    private static JsonReader.a a;
    
    static {
        i0.a = JsonReader.a.a("s", "e", "o", "nm", "m", "hd");
    }
    
    static ShapeTrimPath a(final JsonReader jsonReader, final d d) throws IOException {
        boolean j = false;
        String s = null;
        b f;
        Object forId = f = null;
        b f3;
        b f2 = f3 = f;
        while (jsonReader.i()) {
            final int f4 = jsonReader.F(i0.a);
            if (f4 != 0) {
                if (f4 != 1) {
                    if (f4 != 2) {
                        if (f4 != 3) {
                            if (f4 != 4) {
                                if (f4 != 5) {
                                    jsonReader.M();
                                }
                                else {
                                    j = jsonReader.j();
                                }
                            }
                            else {
                                forId = ShapeTrimPath.Type.forId(jsonReader.l());
                            }
                        }
                        else {
                            s = jsonReader.s();
                        }
                    }
                    else {
                        f3 = d.f(jsonReader, d, false);
                    }
                }
                else {
                    f2 = d.f(jsonReader, d, false);
                }
            }
            else {
                f = d.f(jsonReader, d, false);
            }
        }
        return new ShapeTrimPath(s, (ShapeTrimPath.Type)forId, f, f2, f3, j);
    }
}
