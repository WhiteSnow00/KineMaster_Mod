// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import android.graphics.PointF;
import r1.h;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;

class w
{
    static h a(final JsonReader jsonReader, final d d) throws IOException {
        return new h(d, q.c(jsonReader, d, y1.h.e(), (j0<PointF>)x.a, jsonReader.u() == JsonReader.Token.BEGIN_OBJECT, false));
    }
}
