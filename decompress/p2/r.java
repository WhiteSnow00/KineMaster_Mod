// 
// Decompiled by Procyon v0.6.0
// 

package p2;

import android.util.Log;
import java.util.Iterator;
import java.util.Collection;
import v2.l;
import java.util.HashSet;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import com.bumptech.glide.request.e;
import java.util.Set;

public class r
{
    private final Set<e> a;
    private final Set<e> b;
    private boolean c;
    
    public r() {
        this.a = Collections.newSetFromMap(new WeakHashMap<e, Boolean>());
        this.b = new HashSet<e>();
    }
    
    public boolean a(final e e) {
        final boolean b = true;
        if (e == null) {
            return true;
        }
        final boolean remove = this.a.remove(e);
        boolean b2 = b;
        if (!this.b.remove(e)) {
            b2 = (remove && b);
        }
        if (b2) {
            e.clear();
        }
        return b2;
    }
    
    public void b() {
        final Iterator<e> iterator = l.j(this.a).iterator();
        while (iterator.hasNext()) {
            this.a(iterator.next());
        }
        this.b.clear();
    }
    
    public void c() {
        this.c = true;
        for (final e e : l.j(this.a)) {
            if (e.isRunning() || e.g()) {
                e.clear();
                this.b.add(e);
            }
        }
    }
    
    public void d() {
        this.c = true;
        for (final e e : l.j(this.a)) {
            if (e.isRunning()) {
                e.pause();
                this.b.add(e);
            }
        }
    }
    
    public void e() {
        for (final e e : l.j(this.a)) {
            if (!e.g() && !e.e()) {
                e.clear();
                if (!this.c) {
                    e.i();
                }
                else {
                    this.b.add(e);
                }
            }
        }
    }
    
    public void f() {
        this.c = false;
        for (final e e : l.j(this.a)) {
            if (!e.g() && !e.isRunning()) {
                e.i();
            }
        }
        this.b.clear();
    }
    
    public void g(final e e) {
        this.a.add(e);
        if (!this.c) {
            e.i();
        }
        else {
            e.clear();
            if (Log.isLoggable("RequestTracker", 2)) {
                Log.v("RequestTracker", "Paused, delaying request");
            }
            this.b.add(e);
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{numRequests=");
        sb.append(this.a.size());
        sb.append(", isPaused=");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
}
