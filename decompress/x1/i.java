// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class i implements j0<Float>
{
    public static final i a;
    
    static {
        a = new i();
    }
    
    private i() {
    }
    
    @Override
    public /* bridge */ Object a(final JsonReader jsonReader, final float n) throws IOException {
        return this.b(jsonReader, n);
    }
    
    public Float b(final JsonReader jsonReader, final float n) throws IOException {
        return p.g(jsonReader) * n;
    }
}
