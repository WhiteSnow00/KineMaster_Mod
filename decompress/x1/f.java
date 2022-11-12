// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import android.graphics.Color;
import java.io.IOException;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class f implements j0<Integer>
{
    public static final f a;
    
    static {
        a = new f();
    }
    
    private f() {
    }
    
    @Override
    public /* bridge */ Object a(final JsonReader jsonReader, final float n) throws IOException {
        return this.b(jsonReader, n);
    }
    
    public Integer b(final JsonReader jsonReader, final float n) throws IOException {
        final boolean b = jsonReader.u() == JsonReader.Token.BEGIN_ARRAY;
        if (b) {
            jsonReader.c();
        }
        final double k = jsonReader.k();
        final double i = jsonReader.k();
        final double j = jsonReader.k();
        double l;
        if (jsonReader.u() == JsonReader.Token.NUMBER) {
            l = jsonReader.k();
        }
        else {
            l = 1.0;
        }
        if (b) {
            jsonReader.e();
        }
        double n2 = k;
        double n3 = i;
        double n4 = j;
        double n5 = l;
        if (k <= 1.0) {
            n2 = k;
            n3 = i;
            n4 = j;
            n5 = l;
            if (i <= 1.0) {
                n2 = k;
                n3 = i;
                n4 = j;
                n5 = l;
                if (j <= 1.0) {
                    final double n6 = k * 255.0;
                    final double n7 = i * 255.0;
                    final double n8 = j * 255.0;
                    n2 = n6;
                    n3 = n7;
                    n4 = n8;
                    n5 = l;
                    if (l <= 1.0) {
                        n5 = l * 255.0;
                        n4 = n8;
                        n3 = n7;
                        n2 = n6;
                    }
                }
            }
        }
        return Color.argb((int)n5, (int)n2, (int)n3, (int)n4);
    }
}
