// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.model.DocumentData;

public class h implements j0<DocumentData>
{
    public static final h a;
    private static final JsonReader.a b;
    
    static {
        a = new h();
        b = JsonReader.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");
    }
    
    private h() {
    }
    
    @Override
    public /* bridge */ Object a(final JsonReader jsonReader, final float n) throws IOException {
        return this.b(jsonReader, n);
    }
    
    public DocumentData b(final JsonReader jsonReader, float n) throws IOException {
        Enum<DocumentData.Justification> enum1 = DocumentData.Justification.CENTER;
        jsonReader.d();
        String s = null;
        String s2 = null;
        int l = 0;
        int d2;
        int d = d2 = 0;
        float n2 = 0.0f;
        float n3 = 0.0f;
        float n4;
        n = (n4 = n3);
        boolean j = true;
        while (jsonReader.i()) {
            switch (jsonReader.F(h.b)) {
                default: {
                    jsonReader.L();
                    jsonReader.M();
                    continue;
                }
                case 10: {
                    j = jsonReader.j();
                    continue;
                }
                case 9: {
                    n4 = (float)jsonReader.k();
                    continue;
                }
                case 8: {
                    d2 = p.d(jsonReader);
                    continue;
                }
                case 7: {
                    d = p.d(jsonReader);
                    continue;
                }
                case 6: {
                    n = (float)jsonReader.k();
                    continue;
                }
                case 5: {
                    n3 = (float)jsonReader.k();
                    continue;
                }
                case 4: {
                    l = jsonReader.l();
                    continue;
                }
                case 3: {
                    final int i = jsonReader.l();
                    final DocumentData.Justification justification = (DocumentData.Justification)(enum1 = DocumentData.Justification.CENTER);
                    if (i > justification.ordinal()) {
                        continue;
                    }
                    if (i < 0) {
                        enum1 = justification;
                        continue;
                    }
                    enum1 = DocumentData.Justification.values()[i];
                    continue;
                }
                case 2: {
                    n2 = (float)jsonReader.k();
                    continue;
                }
                case 1: {
                    s2 = jsonReader.s();
                    continue;
                }
                case 0: {
                    s = jsonReader.s();
                    continue;
                }
            }
        }
        jsonReader.h();
        return new DocumentData(s, s2, n2, (DocumentData.Justification)enum1, l, n3, n, d, d2, n4, j);
    }
}
