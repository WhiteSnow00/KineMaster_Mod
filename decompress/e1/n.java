// 
// Decompiled by Procyon v0.6.0
// 

package e1;

import java.util.List;
import java.util.Collections;
import androidx.work.d;
import androidx.work.a;
import f1.i;
import android.content.Context;

public abstract class n
{
    protected n() {
    }
    
    public static n d(final Context context) {
        return i.k(context);
    }
    
    public static void e(final Context context, final a a) {
        i.e(context, a);
    }
    
    public abstract e1.i a(final String p0);
    
    public final e1.i b(final d d) {
        return this.c(Collections.singletonList(d));
    }
    
    public abstract e1.i c(final List<? extends d> p0);
}
