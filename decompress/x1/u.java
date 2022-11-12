// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import u1.h;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class u
{
    static Mask a(final JsonReader jsonReader, final d d) throws IOException {
        jsonReader.d();
        Mask.MaskMode maskMode = null;
        boolean j = false;
        h k = null;
        u1.d h = null;
        while (jsonReader.i()) {
            final String r = jsonReader.r();
            r.hashCode();
            final int hashCode = r.hashCode();
            final int n = 3;
            int n2 = 0;
            Label_0162: {
                switch (hashCode) {
                    case 3357091: {
                        if (!r.equals("mode")) {
                            break;
                        }
                        n2 = 3;
                        break Label_0162;
                    }
                    case 104433: {
                        if (!r.equals("inv")) {
                            break;
                        }
                        n2 = 2;
                        break Label_0162;
                    }
                    case 3588: {
                        if (!r.equals("pt")) {
                            break;
                        }
                        n2 = 1;
                        break Label_0162;
                    }
                    case 111: {
                        if (!r.equals("o")) {
                            break;
                        }
                        n2 = 0;
                        break Label_0162;
                    }
                }
                n2 = -1;
            }
            switch (n2) {
                default: {
                    jsonReader.M();
                    continue;
                }
                case 3: {
                    final String s = jsonReader.s();
                    s.hashCode();
                    int n3 = 0;
                    Label_0331: {
                        switch (s.hashCode()) {
                            case 115: {
                                n3 = n;
                                if (!s.equals("s")) {
                                    break;
                                }
                                break Label_0331;
                            }
                            case 110: {
                                if (!s.equals("n")) {
                                    break;
                                }
                                n3 = 2;
                                break Label_0331;
                            }
                            case 105: {
                                if (!s.equals("i")) {
                                    break;
                                }
                                n3 = 1;
                                break Label_0331;
                            }
                            case 97: {
                                if (!s.equals("a")) {
                                    break;
                                }
                                n3 = 0;
                                break Label_0331;
                            }
                        }
                        n3 = -1;
                    }
                    switch (n3) {
                        default: {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Unknown mask mode ");
                            sb.append(r);
                            sb.append(". Defaulting to Add.");
                            y1.d.c(sb.toString());
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            continue;
                        }
                        case 3: {
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            continue;
                        }
                        case 2: {
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            continue;
                        }
                        case 1: {
                            d.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            continue;
                        }
                        case 0: {
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            continue;
                        }
                    }
                    break;
                }
                case 2: {
                    j = jsonReader.j();
                    continue;
                }
                case 1: {
                    k = d.k(jsonReader, d);
                    continue;
                }
                case 0: {
                    h = d.h(jsonReader, d);
                    continue;
                }
            }
        }
        jsonReader.h();
        return new Mask(maskMode, k, h, j);
    }
}
