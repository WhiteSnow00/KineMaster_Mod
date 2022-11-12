// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.util.ListIterator;
import java.util.Iterator;
import sa.l;
import kotlin.sequences.k;
import java.util.List;
import kotlin.jvm.internal.o;
import android.os.Bundle;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0002\b#B\u0007¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\u000f\u0010\b\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tJ*\u0010\u0011\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J7\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00028\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0015H\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010 R$\u0010'\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010(¨\u0006+" }, d2 = { "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "D", "", "Landroidx/navigation/w;", "state", "Lka/r;", "f", "a", "()Landroidx/navigation/NavDestination;", "", "Landroidx/navigation/NavBackStackEntry;", "entries", "Landroidx/navigation/q;", "navOptions", "Landroidx/navigation/Navigator$a;", "navigatorExtras", "e", "backStackEntry", "g", "destination", "Landroid/os/Bundle;", "args", "d", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/q;Landroidx/navigation/Navigator$a;)Landroidx/navigation/NavDestination;", "popUpTo", "", "savedState", "j", "k", "i", "h", "Landroidx/navigation/w;", "_state", "<set-?>", "b", "Z", "c", "()Z", "isAttached", "()Landroidx/navigation/w;", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public abstract class Navigator<D extends NavDestination>
{
    private w a;
    private boolean b;
    
    public abstract D a();
    
    protected final w b() {
        final w a = this.a;
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }
    
    public final boolean c() {
        return this.b;
    }
    
    public NavDestination d(final D n, final Bundle bundle, final q q, final a a) {
        o.g((Object)n, "destination");
        return n;
    }
    
    public void e(final List<NavBackStackEntry> list, final q q, final a a) {
        o.g((Object)list, "entries");
        final Iterator iterator = k.q(k.x(kotlin.collections.o.Q((Iterable)list), (l)new Navigator$navigate.Navigator$navigate$1(this, q, a))).iterator();
        while (iterator.hasNext()) {
            this.b().h((NavBackStackEntry)iterator.next());
        }
    }
    
    public void f(final w a) {
        o.g((Object)a, "state");
        this.a = a;
        this.b = true;
    }
    
    public void g(final NavBackStackEntry navBackStackEntry) {
        o.g((Object)navBackStackEntry, "backStackEntry");
        NavDestination f = navBackStackEntry.f();
        if (!(f instanceof NavDestination)) {
            f = null;
        }
        if (f == null) {
            return;
        }
        this.d((D)f, null, s.a((l<? super r, ka.r>)Navigator$onLaunchSingleTop.Navigator$onLaunchSingleTop$1.INSTANCE), null);
        this.b().f(navBackStackEntry);
    }
    
    public void h(final Bundle bundle) {
        o.g((Object)bundle, "savedState");
    }
    
    public Bundle i() {
        return null;
    }
    
    public void j(final NavBackStackEntry navBackStackEntry, final boolean b) {
        o.g((Object)navBackStackEntry, "popUpTo");
        final List list = (List)this.b().b().getValue();
        if (list.contains(navBackStackEntry)) {
            final ListIterator listIterator = list.listIterator(list.size());
            NavBackStackEntry navBackStackEntry2 = null;
            while (true) {
                while (this.k()) {
                    final NavBackStackEntry navBackStackEntry3 = navBackStackEntry2 = (NavBackStackEntry)listIterator.previous();
                    if (o.b((Object)navBackStackEntry3, (Object)navBackStackEntry)) {
                        navBackStackEntry2 = navBackStackEntry3;
                        if (navBackStackEntry2 != null) {
                            this.b().g(navBackStackEntry2, b);
                        }
                        return;
                    }
                }
                continue;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("popBackStack was called with ");
        sb.append(navBackStackEntry);
        sb.append(" which does not exist in back stack ");
        sb.append(list);
        throw new IllegalStateException(sb.toString().toString());
    }
    
    public boolean k() {
        return true;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002" }, d2 = { "Landroidx/navigation/Navigator$a;", "", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public interface a
    {
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005" }, d2 = { "Landroidx/navigation/Navigator$b;", "", "", "value", "()Ljava/lang/String;", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public @interface b {
        String value();
    }
}
