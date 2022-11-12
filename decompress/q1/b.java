// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import y1.h;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

public class b
{
    private List<s> a;
    
    public b() {
        this.a = new ArrayList<s>();
    }
    
    void a(final s s) {
        this.a.add(s);
    }
    
    public void b(final Path path) {
        for (int i = this.a.size() - 1; i >= 0; --i) {
            h.b(path, this.a.get(i));
        }
    }
}
