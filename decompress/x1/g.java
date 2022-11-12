// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import com.airbnb.lottie.model.content.MergePaths;
import v1.b;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class g
{
    private static JsonReader.a a;
    
    static {
        g.a = JsonReader.a.a("ty", "d");
    }
    
    static b a(final JsonReader jsonReader, final d d) throws IOException {
        jsonReader.d();
        int n = 2;
        int l = 2;
        b b;
        String s;
        while (true) {
            final boolean i = jsonReader.i();
            b = null;
            if (!i) {
                s = null;
                break;
            }
            final int f = jsonReader.F(g.a);
            if (f == 0) {
                s = jsonReader.s();
                break;
            }
            if (f != 1) {
                jsonReader.L();
                jsonReader.M();
            }
            else {
                l = jsonReader.l();
            }
        }
        if (s == null) {
            return null;
        }
        Label_0438: {
            switch (s) {
                case "tr": {
                    n = 12;
                    break Label_0438;
                }
                case "tm": {
                    n = 11;
                    break Label_0438;
                }
                case "st": {
                    n = 10;
                    break Label_0438;
                }
                case "sr": {
                    n = 9;
                    break Label_0438;
                }
                case "sh": {
                    n = 8;
                    break Label_0438;
                }
                case "rp": {
                    n = 7;
                    break Label_0438;
                }
                case "rc": {
                    n = 6;
                    break Label_0438;
                }
                case "mm": {
                    n = 5;
                    break Label_0438;
                }
                case "gs": {
                    n = 4;
                    break Label_0438;
                }
                case "gr": {
                    n = 3;
                    break Label_0438;
                }
                case "gf": {
                    break Label_0438;
                }
                case "fl": {
                    n = 1;
                    break Label_0438;
                }
                case "el": {
                    n = 0;
                    break Label_0438;
                }
                default:
                    break;
            }
            n = -1;
        }
        b b2 = null;
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown shape type ");
                sb.append(s);
                y1.d.c(sb.toString());
                b2 = b;
                break;
            }
            case 12: {
                b2 = c.g(jsonReader, d);
                break;
            }
            case 11: {
                b2 = i0.a(jsonReader, d);
                break;
            }
            case 10: {
                b2 = h0.a(jsonReader, d);
                break;
            }
            case 9: {
                b2 = z.a(jsonReader, d);
                break;
            }
            case 8: {
                b2 = g0.a(jsonReader, d);
                break;
            }
            case 7: {
                b2 = b0.a(jsonReader, d);
                break;
            }
            case 6: {
                b2 = a0.a(jsonReader, d);
                break;
            }
            case 5: {
                final MergePaths a = v.a(jsonReader);
                d.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                b2 = a;
                break;
            }
            case 4: {
                b2 = x1.n.a(jsonReader, d);
                break;
            }
            case 3: {
                b2 = f0.a(jsonReader, d);
                break;
            }
            case 2: {
                b2 = m.a(jsonReader, d);
                break;
            }
            case 1: {
                b2 = e0.a(jsonReader, d);
                break;
            }
            case 0: {
                b2 = e.a(jsonReader, d, l);
                break;
            }
        }
        while (jsonReader.i()) {
            jsonReader.M();
        }
        jsonReader.h();
        return b2;
    }
}
