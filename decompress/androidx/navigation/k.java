// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import android.os.Parcelable;
import androidx.core.app.v;
import kotlin.collections.g;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import android.app.Activity;
import kotlin.jvm.internal.o;
import android.os.Bundle;
import java.util.List;
import android.content.Intent;
import android.content.Context;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u001f\u0010 B\u0011\b\u0010\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b\u001f\u0010#J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001e\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u001e\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001d¨\u0006$" }, d2 = { "Landroidx/navigation/k;", "", "", "destId", "Landroidx/navigation/NavDestination;", "d", "Lka/r;", "h", "c", "Landroid/os/Bundle;", "args", "f", "a", "e", "Landroidx/core/app/v;", "b", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "Landroid/content/Intent;", "intent", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavGraph;", "graph", "", "Landroidx/navigation/k$a;", "Ljava/util/List;", "destinations", "Landroid/os/Bundle;", "globalArgs", "<init>", "(Landroid/content/Context;)V", "Landroidx/navigation/NavController;", "navController", "(Landroidx/navigation/NavController;)V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
public final class k
{
    private final Context a;
    private final Intent b;
    private NavGraph c;
    private final List<a> d;
    private Bundle e;
    
    public k(final Context a) {
        o.g((Object)a, "context");
        this.a = a;
        Intent launchIntentForPackage;
        if (a instanceof Activity) {
            launchIntentForPackage = new Intent(a, (Class)a.getClass());
        }
        else if ((launchIntentForPackage = a.getPackageManager().getLaunchIntentForPackage(a.getPackageName())) == null) {
            launchIntentForPackage = new Intent();
        }
        launchIntentForPackage.addFlags(268468224);
        this.b = launchIntentForPackage;
        this.d = new ArrayList<a>();
    }
    
    public k(final NavController navController) {
        o.g((Object)navController, "navController");
        this(navController.y());
        this.c = navController.C();
    }
    
    private final void c() {
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final Iterator<a> iterator = this.d.iterator();
        NavDestination navDestination = null;
        while (iterator.hasNext()) {
            final a a = iterator.next();
            final int b = a.b();
            final Bundle a2 = a.a();
            final NavDestination d = this.d(b);
            if (d == null) {
                final String b2 = NavDestination.j.b(this.a, b);
                final StringBuilder sb = new StringBuilder();
                sb.append("Navigation destination ");
                sb.append(b2);
                sb.append(" cannot be found in the navigation graph ");
                sb.append(this.c);
                throw new IllegalArgumentException(sb.toString());
            }
            final int[] g = d.g(navDestination);
            for (int i = 0; i < g.length; ++i) {
                list.add(g[i]);
                list2.add(a2);
            }
            navDestination = d;
        }
        this.b.putExtra("android-support-nav:controller:deepLinkIds", kotlin.collections.o.M0((Collection)list));
        this.b.putParcelableArrayListExtra("android-support-nav:controller:deepLinkArgs", list2);
    }
    
    private final NavDestination d(final int n) {
        final g g = new g();
        final NavGraph c = this.c;
        o.d((Object)c);
        g.add((Object)c);
        while (!g.isEmpty()) {
            final NavDestination navDestination = (NavDestination)g.removeFirst();
            if (navDestination.p() == n) {
                return navDestination;
            }
            if (!(navDestination instanceof NavGraph)) {
                continue;
            }
            final Iterator<NavDestination> iterator = ((NavGraph)navDestination).iterator();
            while (iterator.hasNext()) {
                g.add((Object)iterator.next());
            }
        }
        return null;
    }
    
    public static k g(final k k, final int n, Bundle bundle, final int n2, final Object o) {
        if ((n2 & 0x2) != 0x0) {
            bundle = null;
        }
        return k.f(n, bundle);
    }
    
    private final void h() {
        final Iterator<a> iterator = this.d.iterator();
        while (iterator.hasNext()) {
            final int b = iterator.next().b();
            if (this.d(b) != null) {
                continue;
            }
            final String b2 = NavDestination.j.b(this.a, b);
            final StringBuilder sb = new StringBuilder();
            sb.append("Navigation destination ");
            sb.append(b2);
            sb.append(" cannot be found in the navigation graph ");
            sb.append(this.c);
            throw new IllegalArgumentException(sb.toString());
        }
    }
    
    public final k a(final int n, final Bundle bundle) {
        this.d.add(new a(n, bundle));
        if (this.c != null) {
            this.h();
        }
        return this;
    }
    
    public final v b() {
        if (this.c == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link".toString());
        }
        if (this.d.isEmpty() ^ true) {
            this.c();
            final v b = v.g(this.a).b(new Intent(this.b));
            o.f((Object)b, "create(context)\n        \u2026rentStack(Intent(intent))");
            for (int i = 0; i < b.m(); ++i) {
                final Intent k = b.k(i);
                if (k != null) {
                    k.putExtra("android-support-nav:controller:deepLinkIntent", (Parcelable)this.b);
                }
            }
            return b;
        }
        throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link".toString());
    }
    
    public final k e(final Bundle e) {
        this.e = e;
        this.b.putExtra("android-support-nav:controller:deepLinkExtras", e);
        return this;
    }
    
    public final k f(final int n, final Bundle bundle) {
        this.d.clear();
        this.d.add(new a(n, bundle));
        if (this.c != null) {
            this.h();
        }
        return this;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n¨\u0006\u000e" }, d2 = { "Landroidx/navigation/k$a;", "", "", "a", "I", "b", "()I", "destinationId", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "arguments", "<init>", "(ILandroid/os/Bundle;)V", "navigation-runtime_release" }, k = 1, mv = { 1, 6, 0 })
    private static final class a
    {
        private final int a;
        private final Bundle b;
        
        public a(final int a, final Bundle b) {
            this.a = a;
            this.b = b;
        }
        
        public final Bundle a() {
            return this.b;
        }
        
        public final int b() {
            return this.a;
        }
    }
}
