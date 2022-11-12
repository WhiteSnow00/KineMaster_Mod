// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import java.util.ArrayList;
import com.airbnb.lottie.model.content.Mask;
import android.graphics.Path;
import java.util.List;

public class g
{
    private final List<a<v1.g, Path>> a;
    private final List<a<Integer, Integer>> b;
    private final List<Mask> c;
    
    public g(final List<Mask> c) {
        this.c = c;
        this.a = new ArrayList<a<v1.g, Path>>(c.size());
        this.b = new ArrayList<a<Integer, Integer>>(c.size());
        for (int i = 0; i < c.size(); ++i) {
            this.a.add(((Mask)c.get(i)).b().a());
            this.b.add(((Mask)c.get(i)).c().a());
        }
    }
    
    public List<a<v1.g, Path>> a() {
        return this.a;
    }
    
    public List<Mask> b() {
        return this.c;
    }
    
    public List<a<Integer, Integer>> c() {
        return this.b;
    }
}
