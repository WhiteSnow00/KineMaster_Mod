// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import android.content.Context;
import com.google.android.exoplayer2.scheduler.Requirements;

public final class DownloadManager
{
    public static final Requirements l;
    private final Context a;
    private final RequirementsWatcher.Listener b;
    private final CopyOnWriteArraySet<Listener> c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private int h;
    private boolean i;
    private List<Download> j;
    private RequirementsWatcher k;
    
    static {
        l = new Requirements(1);
    }
    
    private void i() {
        final Iterator<Listener> iterator = this.c.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(this, this.i);
        }
    }
    
    private void j(final RequirementsWatcher requirementsWatcher, final int h) {
        final Requirements f = requirementsWatcher.f();
        if (this.h == h) {
            final boolean r = this.r();
            final Iterator<Listener> iterator = this.c.iterator();
            while (iterator.hasNext()) {
                iterator.next().b(this, f, h);
            }
            if (r) {
                this.i();
            }
            return;
        }
        this.h = h;
        ++this.d;
        throw null;
    }
    
    private void o(final boolean g) {
        if (this.g == g) {
            return;
        }
        this.g = g;
        ++this.d;
        throw null;
    }
    
    private boolean r() {
        final boolean g = this.g;
        boolean b = true;
        boolean j = false;
        Label_0065: {
            if (!g && this.h != 0) {
                for (int i = 0; i < this.j.size(); ++i) {
                    if (this.j.get(i).a == 0) {
                        j = true;
                        break Label_0065;
                    }
                }
            }
            j = false;
        }
        if (this.i == j) {
            b = false;
        }
        this.i = j;
        return b;
    }
    
    public void a(final DownloadRequest downloadRequest, final int n) {
        ++this.d;
        throw null;
    }
    
    public void b(final Listener listener) {
        Assertions.e(listener);
        this.c.add(listener);
    }
    
    public List<Download> c() {
        return this.j;
    }
    
    public boolean d() {
        return this.g;
    }
    
    public Requirements e() {
        return this.k.f();
    }
    
    public boolean f() {
        return this.e == 0 && this.d == 0;
    }
    
    public boolean g() {
        return this.f;
    }
    
    public boolean h() {
        return this.i;
    }
    
    public void k() {
        this.o(true);
    }
    
    public void l() {
        ++this.d;
        throw null;
    }
    
    public void m(final String s) {
        ++this.d;
        throw null;
    }
    
    public void n() {
        this.o(false);
    }
    
    public void p(final Requirements requirements) {
        if (requirements.equals(this.k.f())) {
            return;
        }
        this.k.j();
        final RequirementsWatcher k = new RequirementsWatcher(this.a, this.b, requirements);
        this.j(this.k = k, k.i());
    }
    
    public void q(final String s, final int n) {
        ++this.d;
        throw null;
    }
    
    public interface Listener
    {
        default void a(final DownloadManager downloadManager, final boolean b) {
        }
        
        default void b(final DownloadManager downloadManager, final Requirements requirements, final int n) {
        }
    }
}
