// 
// Decompiled by Procyon v0.6.0
// 

package f1;

import android.text.TextUtils;
import n1.b;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import e1.h;
import androidx.work.d;
import java.util.List;
import androidx.work.ExistingWorkPolicy;
import e1.m;

public class g extends m
{
    private static final String j;
    private final i a;
    private final String b;
    private final ExistingWorkPolicy c;
    private final List<? extends d> d;
    private final List<String> e;
    private final List<String> f;
    private final List<g> g;
    private boolean h;
    private e1.i i;
    
    static {
        j = h.f("WorkContinuationImpl");
    }
    
    public g(final i a, final String b, final ExistingWorkPolicy c, final List<? extends d> d, final List<g> g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.g = g;
        this.e = new ArrayList<String>(d.size());
        this.f = new ArrayList<String>();
        if (g != null) {
            final Iterator<g> iterator = g.iterator();
            while (iterator.hasNext()) {
                this.f.addAll(iterator.next().f);
            }
        }
        for (int i = 0; i < d.size(); ++i) {
            final String a2 = d.get(i).a();
            this.e.add(a2);
            this.f.add(a2);
        }
    }
    
    public g(final i i, final List<? extends d> list) {
        this(i, null, ExistingWorkPolicy.KEEP, list, null);
    }
    
    private static boolean i(final g g, final Set<String> set) {
        set.addAll(g.c());
        final Set<String> l = l(g);
        final Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            if (l.contains(iterator.next())) {
                return true;
            }
        }
        final List<g> e = g.e();
        if (e != null && !e.isEmpty()) {
            final Iterator iterator2 = e.iterator();
            while (iterator2.hasNext()) {
                if (i((g)iterator2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(g.c());
        return false;
    }
    
    public static Set<String> l(final g g) {
        final HashSet set = new HashSet();
        final List<g> e = g.e();
        if (e != null && !e.isEmpty()) {
            final Iterator iterator = e.iterator();
            while (iterator.hasNext()) {
                set.addAll(((g)iterator.next()).c());
            }
        }
        return set;
    }
    
    public e1.i a() {
        if (!this.h) {
            final b b = new b(this);
            this.a.p().b(b);
            this.i = b.d();
        }
        else {
            e1.h.c().h(f1.g.j, String.format("Already enqueued work ids (%s)", TextUtils.join((CharSequence)", ", (Iterable)this.e)), new Throwable[0]);
        }
        return this.i;
    }
    
    public ExistingWorkPolicy b() {
        return this.c;
    }
    
    public List<String> c() {
        return this.e;
    }
    
    public String d() {
        return this.b;
    }
    
    public List<g> e() {
        return this.g;
    }
    
    public List<? extends d> f() {
        return this.d;
    }
    
    public i g() {
        return this.a;
    }
    
    public boolean h() {
        return i(this, new HashSet<String>());
    }
    
    public boolean j() {
        return this.h;
    }
    
    public void k() {
        this.h = true;
    }
}
