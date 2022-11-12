// 
// Decompiled by Procyon v0.6.0
// 

package y1;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import com.airbnb.lottie.i;

public class c implements i
{
    private static final Set<String> a;
    
    static {
        a = new HashSet<String>();
    }
    
    @Override
    public void a(final String s) {
        this.d(s, null);
    }
    
    @Override
    public void b(final String s, final Throwable t) {
        if (com.airbnb.lottie.c.a) {
            Log.d("LOTTIE", s, t);
        }
    }
    
    @Override
    public void c(final String s) {
        this.e(s, null);
    }
    
    @Override
    public void d(final String s, final Throwable t) {
        final Set<String> a = c.a;
        if (a.contains(s)) {
            return;
        }
        Log.w("LOTTIE", s, t);
        a.add(s);
    }
    
    public void e(final String s, final Throwable t) {
        if (com.airbnb.lottie.c.a) {
            Log.d("LOTTIE", s, t);
        }
    }
}
