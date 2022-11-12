// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import v1.i;
import java.util.List;
import v1.b;
import java.util.ArrayList;
import t1.c;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class j
{
    private static final JsonReader.a a;
    private static final JsonReader.a b;
    
    static {
        a = JsonReader.a.a("ch", "size", "w", "style", "fFamily", "data");
        b = JsonReader.a.a("shapes");
    }
    
    static c a(final JsonReader jsonReader, final d d) throws IOException {
        final ArrayList list = new ArrayList();
        jsonReader.d();
        String s = null;
        String s2 = null;
        double k = 0.0;
        double i = 0.0;
        char char1 = '\0';
        while (jsonReader.i()) {
            final int f = jsonReader.F(j.a);
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
                                    jsonReader.d();
                                    while (jsonReader.i()) {
                                        if (jsonReader.F(j.b) != 0) {
                                            jsonReader.L();
                                            jsonReader.M();
                                        }
                                        else {
                                            jsonReader.c();
                                            while (jsonReader.i()) {
                                                list.add(g.a(jsonReader, d));
                                            }
                                            jsonReader.e();
                                        }
                                    }
                                    jsonReader.h();
                                }
                            }
                            else {
                                s2 = jsonReader.s();
                            }
                        }
                        else {
                            s = jsonReader.s();
                        }
                    }
                    else {
                        i = jsonReader.k();
                    }
                }
                else {
                    k = jsonReader.k();
                }
            }
            else {
                char1 = jsonReader.s().charAt(0);
            }
        }
        jsonReader.h();
        return new c(list, char1, k, i, s, s2);
    }
}
