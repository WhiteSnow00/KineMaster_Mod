// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import com.airbnb.lottie.parser.moshi.JsonReader;
import android.graphics.PointF;

public class y implements j0<PointF>
{
    public static final y a;
    
    static {
        a = new y();
    }
    
    private y() {
    }
    
    @Override
    public /* bridge */ Object a(final JsonReader jsonReader, final float n) throws IOException {
        return this.b(jsonReader, n);
    }
    
    public PointF b(final JsonReader jsonReader, final float n) throws IOException {
        final JsonReader.Token u = jsonReader.u();
        if (u == JsonReader.Token.BEGIN_ARRAY) {
            return p.e(jsonReader, n);
        }
        if (u == JsonReader.Token.BEGIN_OBJECT) {
            return p.e(jsonReader, n);
        }
        if (u == JsonReader.Token.NUMBER) {
            final PointF pointF = new PointF((float)jsonReader.k() * n, (float)jsonReader.k() * n);
            while (jsonReader.i()) {
                jsonReader.M();
            }
            return pointF;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot convert json to point. Next token is ");
        sb.append(u);
        throw new IllegalArgumentException(sb.toString());
    }
}
