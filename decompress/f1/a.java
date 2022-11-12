// 
// Decompiled by Procyon v0.6.0
// 

package f1;

import androidx.core.os.h;
import android.os.Looper;
import android.os.Handler;
import e1.l;

public class a implements l
{
    private final Handler a;
    
    public a() {
        this.a = h.a(Looper.getMainLooper());
    }
    
    @Override
    public void a(final Runnable runnable) {
        this.a.removeCallbacks(runnable);
    }
    
    @Override
    public void b(final long n, final Runnable runnable) {
        this.a.postDelayed(runnable, n);
    }
}
