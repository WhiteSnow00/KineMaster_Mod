// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class o implements j0<Integer>
{
    public static final o a;
    
    static {
        a = new o();
    }
    
    private o() {
    }
    
    @Override
    public /* bridge */ Object a(final JsonReader jsonReader, final float n) throws IOException {
        return this.b(jsonReader, n);
    }
    
    public Integer b(final JsonReader jsonReader, final float n) throws IOException {
        return Math.round(p.g(jsonReader) * n);
    }
}
