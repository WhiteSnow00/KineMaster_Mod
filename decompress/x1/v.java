// 
// Decompiled by Procyon v0.6.0
// 

package x1;

import java.io.IOException;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;

class v
{
    private static final JsonReader.a a;
    
    static {
        a = JsonReader.a.a("nm", "mm", "hd");
    }
    
    static MergePaths a(final JsonReader jsonReader) throws IOException {
        String s = null;
        boolean j = false;
        MergePaths.MergePathsMode forId = null;
        while (jsonReader.i()) {
            final int f = jsonReader.F(v.a);
            if (f != 0) {
                if (f != 1) {
                    if (f != 2) {
                        jsonReader.L();
                        jsonReader.M();
                    }
                    else {
                        j = jsonReader.j();
                    }
                }
                else {
                    forId = MergePaths.MergePathsMode.forId(jsonReader.l());
                }
            }
            else {
                s = jsonReader.s();
            }
        }
        return new MergePaths(s, forId, j);
    }
}
