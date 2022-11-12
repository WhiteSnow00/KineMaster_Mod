// 
// Decompiled by Procyon v0.6.0
// 

package t1;

import com.airbnb.lottie.d;
import androidx.collection.e;

public class f
{
    private static final f b;
    private final e<String, d> a;
    
    static {
        b = new f();
    }
    
    f() {
        this.a = new e<String, d>(20);
    }
    
    public static f b() {
        return f.b;
    }
    
    public d a(final String s) {
        if (s == null) {
            return null;
        }
        return this.a.get(s);
    }
    
    public void c(final String s, final d d) {
        if (s == null) {
            return;
        }
        this.a.put(s, d);
    }
}
