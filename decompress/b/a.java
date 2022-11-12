// 
// Decompiled by Procyon v0.6.0
// 

package b;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import android.content.Context;
import java.util.Set;

public final class a
{
    private final Set<b> a;
    private volatile Context b;
    
    public a() {
        this.a = new CopyOnWriteArraySet<b>();
    }
    
    public void a(final b b) {
        if (this.b != null) {
            b.onContextAvailable(this.b);
        }
        this.a.add(b);
    }
    
    public void b() {
        this.b = null;
    }
    
    public void c(final Context b) {
        this.b = b;
        final Iterator<b> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().onContextAvailable(b);
        }
    }
    
    public Context d() {
        return this.b;
    }
    
    public void e(final b b) {
        this.a.remove(b);
    }
}
