// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import com.airbnb.lottie.parser.moshi.JsonReader;
import android.graphics.PointF;

public class x implements j0<PointF>
{
    public static final x a;
    
    static {
        a = new x();
    }
    
    private x() {
    }
    
    @Override
    public /* bridge */ Object a(final JsonReader jsonReader, final float n) throws IOException {
        return this.b(jsonReader, n);
    }
    
    public PointF b(final JsonReader jsonReader, final float n) throws IOException {
        return p.e(jsonReader, n);
    }
}
