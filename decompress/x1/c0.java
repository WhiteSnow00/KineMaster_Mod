// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import com.airbnb.lottie.parser.moshi.JsonReader;
import z1.d;

public class c0 implements j0<d>
{
    public static final c0 a;
    
    static {
        a = new c0();
    }
    
    private c0() {
    }
    
    @Override
    public /* bridge */ Object a(final JsonReader jsonReader, final float n) throws IOException {
        return this.b(jsonReader, n);
    }
    
    public d b(final JsonReader jsonReader, final float n) throws IOException {
        final boolean b = jsonReader.u() == JsonReader.Token.BEGIN_ARRAY;
        if (b) {
            jsonReader.c();
        }
        final float n2 = (float)jsonReader.k();
        final float n3 = (float)jsonReader.k();
        while (jsonReader.i()) {
            jsonReader.M();
        }
        if (b) {
            jsonReader.e();
        }
        return new d(n2 / 100.0f * n, n3 / 100.0f * n);
    }
}
