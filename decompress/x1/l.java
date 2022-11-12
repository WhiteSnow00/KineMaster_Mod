// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.util.ArrayList;
import java.io.IOException;
import com.airbnb.lottie.parser.moshi.JsonReader;
import y1.g;
import android.graphics.Color;
import java.util.List;
import v1.c;

public class l implements j0<c>
{
    private int a;
    
    public l(final int a) {
        this.a = a;
    }
    
    private void b(final c c, final List<Float> list) {
        int n = this.a * 4;
        if (list.size() <= n) {
            return;
        }
        final int n2 = (list.size() - n) / 2;
        final double[] array = new double[n2];
        final double[] array2 = new double[n2];
        final int n3 = 0;
        int n4 = 0;
        int i;
        while (true) {
            i = n3;
            if (n >= list.size()) {
                break;
            }
            if (n % 2 == 0) {
                array[n4] = list.get(n);
            }
            else {
                array2[n4] = list.get(n);
                ++n4;
            }
            ++n;
        }
        while (i < c.c()) {
            final int n5 = c.a()[i];
            c.a()[i] = Color.argb(this.c(c.b()[i], array, array2), Color.red(n5), Color.green(n5), Color.blue(n5));
            ++i;
        }
    }
    
    private int c(double n, final double[] array, final double[] array2) {
        for (int i = 1; i < array.length; ++i) {
            final int n2 = i - 1;
            final double n3 = array[n2];
            final double n4 = array[i];
            if (array[i] >= n) {
                n = g.b((n - n3) / (n4 - n3), 0.0, 1.0);
                n = g.j(array2[n2], array2[i], n);
                return (int)(n * 255.0);
            }
        }
        n = array2[array2.length - 1];
        return (int)(n * 255.0);
    }
    
    @Override
    public /* bridge */ Object a(final JsonReader jsonReader, final float n) throws IOException {
        return this.d(jsonReader, n);
    }
    
    public c d(final JsonReader jsonReader, final float n) throws IOException {
        final ArrayList list = new ArrayList();
        final JsonReader.Token u = jsonReader.u();
        final JsonReader.Token begin_ARRAY = JsonReader.Token.BEGIN_ARRAY;
        final int n2 = 0;
        final boolean b = u == begin_ARRAY;
        if (b) {
            jsonReader.c();
        }
        while (jsonReader.i()) {
            list.add((float)jsonReader.k());
        }
        if (b) {
            jsonReader.e();
        }
        if (this.a == -1) {
            this.a = list.size() / 4;
        }
        final int a = this.a;
        final float[] array = new float[a];
        final int[] array2 = new int[a];
        final int n3 = 0;
        int n4 = 0;
        int i = n2;
        int n5 = n3;
        while (i < this.a * 4) {
            final int n6 = i / 4;
            final double n7 = (float)list.get(i);
            final int n8 = i % 4;
            if (n8 != 0) {
                if (n8 != 1) {
                    if (n8 != 2) {
                        if (n8 == 3) {
                            array2[n6] = Color.argb(255, n5, n4, (int)(n7 * 255.0));
                        }
                    }
                    else {
                        n4 = (int)(n7 * 255.0);
                    }
                }
                else {
                    n5 = (int)(n7 * 255.0);
                }
            }
            else {
                array[n6] = (float)n7;
            }
            ++i;
        }
        final c c = new c(array, array2);
        this.b(c, list);
        return c;
    }
}
