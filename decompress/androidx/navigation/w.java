// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import java.util.Iterator;
import ka.r;
import java.util.ArrayList;
import java.util.Collection;
import android.os.Bundle;
import kotlinx.coroutines.flow.e;
import kotlin.collections.l0;
import kotlinx.coroutines.flow.t;
import kotlin.collections.o;
import kotlinx.coroutines.flow.s;
import java.util.Set;
import java.util.List;
import kotlinx.coroutines.flow.i;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001a0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\"\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R#\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160#8\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b\u0017\u0010%R#\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001a0#8\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b\u001b\u0010%¨\u0006*" }, d2 = { "Landroidx/navigation/w;", "", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "Lka/r;", "h", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "a", "popUpTo", "", "saveState", "g", "f", "entry", "e", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "backStackLock", "Lkotlinx/coroutines/flow/i;", "", "b", "Lkotlinx/coroutines/flow/i;", "_backStack", "", "c", "_transitionsInProgress", "d", "Z", "()Z", "i", "(Z)V", "isNavigating", "Lkotlinx/coroutines/flow/s;", "Lkotlinx/coroutines/flow/s;", "()Lkotlinx/coroutines/flow/s;", "backStack", "transitionsInProgress", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public abstract class w
{
    private final ReentrantLock a;
    private final i<List<NavBackStackEntry>> b;
    private final i<Set<NavBackStackEntry>> c;
    private boolean d;
    private final s<List<NavBackStackEntry>> e;
    private final s<Set<NavBackStackEntry>> f;
    
    public w() {
        this.a = new ReentrantLock(true);
        final i a = t.a((Object)o.j());
        this.b = (i<List<NavBackStackEntry>>)a;
        final i a2 = t.a((Object)l0.d());
        this.c = (i<Set<NavBackStackEntry>>)a2;
        this.e = (s<List<NavBackStackEntry>>)kotlinx.coroutines.flow.e.b(a);
        this.f = (s<Set<NavBackStackEntry>>)kotlinx.coroutines.flow.e.b(a2);
    }
    
    public abstract NavBackStackEntry a(final NavDestination p0, final Bundle p1);
    
    public final s<List<NavBackStackEntry>> b() {
        return this.e;
    }
    
    public final s<Set<NavBackStackEntry>> c() {
        return this.f;
    }
    
    public final boolean d() {
        return this.d;
    }
    
    public void e(final NavBackStackEntry navBackStackEntry) {
        kotlin.jvm.internal.o.g((Object)navBackStackEntry, "entry");
        final i<Set<NavBackStackEntry>> c = this.c;
        c.setValue((Object)l0.i((Set)c.getValue(), (Object)navBackStackEntry));
    }
    
    public void f(final NavBackStackEntry navBackStackEntry) {
        kotlin.jvm.internal.o.g((Object)navBackStackEntry, "backStackEntry");
        final i<List<NavBackStackEntry>> b = this.b;
        b.setValue((Object)o.x0((Collection)o.t0((Iterable)b.getValue(), o.n0((List)this.b.getValue())), (Object)navBackStackEntry));
    }
    
    public void g(final NavBackStackEntry navBackStackEntry, final boolean b) {
        kotlin.jvm.internal.o.g((Object)navBackStackEntry, "popUpTo");
        final ReentrantLock a = this.a;
        a.lock();
        try {
            final i<List<NavBackStackEntry>> b2 = this.b;
            final Iterable iterable = (Iterable)b2.getValue();
            final ArrayList<NavBackStackEntry> value = new ArrayList<NavBackStackEntry>();
            for (final Object next : iterable) {
                if (!(kotlin.jvm.internal.o.b((Object)next, (Object)navBackStackEntry) ^ true)) {
                    break;
                }
                value.add((NavBackStackEntry)next);
            }
            b2.setValue((Object)value);
            final r a2 = r.a;
        }
        finally {
            a.unlock();
        }
    }
    
    public void h(final NavBackStackEntry navBackStackEntry) {
        kotlin.jvm.internal.o.g((Object)navBackStackEntry, "backStackEntry");
        final ReentrantLock a = this.a;
        a.lock();
        try {
            final i<List<NavBackStackEntry>> b = this.b;
            b.setValue((Object)o.x0((Collection)b.getValue(), (Object)navBackStackEntry));
            final r a2 = r.a;
        }
        finally {
            a.unlock();
        }
    }
    
    public final void i(final boolean d) {
        this.d = d;
    }
}
