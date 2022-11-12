// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import java.util.Iterator;
import java.util.List;
import android.os.Bundle;
import kotlin.jvm.internal.o;
import kotlin.Metadata;

@b("navigation")
@Metadata(bv = {}, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0016J*\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015" }, d2 = { "Landroidx/navigation/n;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavBackStackEntry;", "entry", "Landroidx/navigation/q;", "navOptions", "Landroidx/navigation/Navigator$a;", "navigatorExtras", "Lka/r;", "m", "l", "", "entries", "e", "Landroidx/navigation/v;", "c", "Landroidx/navigation/v;", "navigatorProvider", "<init>", "(Landroidx/navigation/v;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public class n extends Navigator<NavGraph>
{
    private final v c;
    
    public n(final v c) {
        o.g((Object)c, "navigatorProvider");
        this.c = c;
    }
    
    private final void m(final NavBackStackEntry navBackStackEntry, final q q, final a a) {
        final NavGraph navGraph = (NavGraph)navBackStackEntry.f();
        final Bundle d = navBackStackEntry.d();
        final int n = navGraph.N();
        final String o = navGraph.O();
        if (n == 0 && o == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("no start destination defined via app:startDestination for ");
            sb.append(navGraph.o());
            throw new IllegalStateException(sb.toString().toString());
        }
        NavDestination navDestination;
        if (o != null) {
            navDestination = navGraph.I(o, false);
        }
        else {
            navDestination = navGraph.G(n, false);
        }
        if (navDestination != null) {
            this.c.d(navDestination.q()).e(kotlin.collections.o.e((Object)this.b().a(navDestination, navDestination.f(d))), q, a);
            return;
        }
        final String k = navGraph.K();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("navigation destination ");
        sb2.append(k);
        sb2.append(" is not a direct child of this NavGraph");
        throw new IllegalArgumentException(sb2.toString());
    }
    
    @Override
    public /* bridge */ NavDestination a() {
        return this.l();
    }
    
    @Override
    public void e(final List<NavBackStackEntry> list, final q q, final a a) {
        o.g((Object)list, "entries");
        final Iterator<NavBackStackEntry> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.m(iterator.next(), q, a);
        }
    }
    
    public NavGraph l() {
        return new NavGraph(this);
    }
}
