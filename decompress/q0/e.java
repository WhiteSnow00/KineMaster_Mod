// 
// Decompiled by Procyon v0.6.0
// 

package q0;

import kotlin.collections.e0;
import java.util.LinkedHashMap;
import android.content.res.TypedArray;
import ka.r;
import android.util.AttributeSet;
import java.util.Objects;
import androidx.core.os.d;
import ka.l;
import kotlin.Pair;
import java.util.ArrayList;
import java.util.Collection;
import android.util.Log;
import androidx.navigation.NavDestination;
import java.util.Iterator;
import androidx.fragment.app.c0;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;
import java.util.Map;
import java.util.List;
import androidx.navigation.q;
import androidx.navigation.NavBackStackEntry;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import java.util.Set;
import androidx.fragment.app.FragmentManager;
import android.content.Context;
import kotlin.Metadata;
import androidx.navigation.Navigator;

@Navigator.b("fragment")
@Metadata(bv = {}, d1 = { "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001e\u001f B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J*\u0010\u0012\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0013H\u0016¨\u0006!" }, d2 = { "Lq0/e;", "Landroidx/navigation/Navigator;", "Lq0/e$b;", "Landroidx/navigation/NavBackStackEntry;", "entry", "Landroidx/navigation/q;", "navOptions", "Landroidx/navigation/Navigator$a;", "navigatorExtras", "Lka/r;", "m", "popUpTo", "", "savedState", "j", "l", "", "entries", "e", "Landroid/os/Bundle;", "i", "h", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "containerId", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;I)V", "a", "b", "c", "navigation-fragment_release" }, k = 1, mv = { 1, 6, 0 })
public class e extends Navigator<b>
{
    private static final a g;
    private final Context c;
    private final FragmentManager d;
    private final int e;
    private final Set<String> f;
    
    static {
        g = new a(null);
    }
    
    public e(final Context c, final FragmentManager d, final int e) {
        o.g((Object)c, "context");
        o.g((Object)d, "fragmentManager");
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = new LinkedHashSet<String>();
    }
    
    private final void m(final NavBackStackEntry navBackStackEntry, final q q, final Navigator.a a) {
        final List list = (List)this.b().b().getValue();
        final boolean empty = list.isEmpty();
        final boolean b = false;
        if (q != null && !empty && q.i() && this.f.remove(navBackStackEntry.g())) {
            this.d.w1(navBackStackEntry.g());
            this.b().h(navBackStackEntry);
            return;
        }
        final b b2 = (b)navBackStackEntry.f();
        final Bundle d = navBackStackEntry.d();
        String s2;
        final String s = s2 = b2.C();
        if (s.charAt(0) == '.') {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.c.getPackageName());
            sb.append(s);
            s2 = sb.toString();
        }
        final Fragment a2 = this.d.x0().a(this.c.getClassLoader(), s2);
        o.f((Object)a2, "fragmentManager.fragment\u2026t.classLoader, className)");
        a2.setArguments(d);
        final c0 q2 = this.d.q();
        o.f((Object)q2, "fragmentManager.beginTransaction()");
        int a3;
        if (q != null) {
            a3 = q.a();
        }
        else {
            a3 = -1;
        }
        int b3;
        if (q != null) {
            b3 = q.b();
        }
        else {
            b3 = -1;
        }
        int c;
        if (q != null) {
            c = q.c();
        }
        else {
            c = -1;
        }
        int d2;
        if (q != null) {
            d2 = q.d();
        }
        else {
            d2 = -1;
        }
        if (a3 != -1 || b3 != -1 || c != -1 || d2 != -1) {
            if (a3 == -1) {
                a3 = 0;
            }
            if (b3 == -1) {
                b3 = 0;
            }
            if (c == -1) {
                c = 0;
            }
            if (d2 == -1) {
                d2 = 0;
            }
            q2.t(a3, b3, c, d2);
        }
        q2.q(this.e, a2);
        q2.v(a2);
        final int p3 = b2.p();
        final boolean b4 = q != null && !empty && q.g() && ((NavBackStackEntry)kotlin.collections.o.n0(list)).f().p() == p3;
        int n = 0;
        Label_0514: {
            if (!empty) {
                if (b4) {
                    n = (b ? 1 : 0);
                    if (list.size() > 1) {
                        this.d.i1(navBackStackEntry.g(), 1);
                        q2.h(navBackStackEntry.g());
                        n = (b ? 1 : 0);
                    }
                    break Label_0514;
                }
                else {
                    q2.h(navBackStackEntry.g());
                }
            }
            n = 1;
        }
        if (a instanceof c) {
            for (final Map.Entry entry : ((c)a).a().entrySet()) {
                q2.g((View)entry.getKey(), (String)entry.getValue());
            }
        }
        q2.w(true);
        q2.i();
        if (n != 0) {
            this.b().h(navBackStackEntry);
        }
    }
    
    @Override
    public /* bridge */ NavDestination a() {
        return this.l();
    }
    
    @Override
    public void e(final List<NavBackStackEntry> list, final q q, final Navigator.a a) {
        o.g((Object)list, "entries");
        if (this.d.T0()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        final Iterator<NavBackStackEntry> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.m(iterator.next(), q, a);
        }
    }
    
    @Override
    public void h(final Bundle bundle) {
        o.g((Object)bundle, "savedState");
        final ArrayList stringArrayList = bundle.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (stringArrayList != null) {
            this.f.clear();
            kotlin.collections.o.z((Collection)this.f, (Iterable)stringArrayList);
        }
    }
    
    @Override
    public Bundle i() {
        if (this.f.isEmpty()) {
            return null;
        }
        return androidx.core.os.d.a(l.a((Object)"androidx-nav-fragment:navigator:savedIds", (Object)new ArrayList(this.f)));
    }
    
    @Override
    public void j(final NavBackStackEntry navBackStackEntry, final boolean b) {
        o.g((Object)navBackStackEntry, "popUpTo");
        if (this.d.T0()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        if (b) {
            final List list = (List)this.b().b().getValue();
            final NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry)kotlin.collections.o.b0(list);
            for (final NavBackStackEntry navBackStackEntry3 : kotlin.collections.o.z0((Iterable)list.subList(list.indexOf(navBackStackEntry), list.size()))) {
                if (o.b((Object)navBackStackEntry3, (Object)navBackStackEntry2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("FragmentManager cannot save the state of the initial destination ");
                    sb.append(navBackStackEntry3);
                    Log.i("FragmentNavigator", sb.toString());
                }
                else {
                    this.d.B1(navBackStackEntry3.g());
                    this.f.add(navBackStackEntry3.g());
                }
            }
        }
        else {
            this.d.i1(navBackStackEntry.g(), 1);
        }
        this.b().g(navBackStackEntry, b);
    }
    
    public b l() {
        return new b(this);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b" }, d2 = { "Lq0/e$a;", "", "", "KEY_SAVED_IDS", "Ljava/lang/String;", "TAG", "<init>", "()V", "navigation-fragment_release" }, k = 1, mv = { 1, 6, 0 })
    private static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\bH\u0016J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018" }, d2 = { "Lq0/e$b;", "Landroidx/navigation/NavDestination;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lka/r;", "w", "", "className", "D", "toString", "", "other", "", "equals", "", "hashCode", "C", "()Ljava/lang/String;", "Landroidx/navigation/Navigator;", "fragmentNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", "navigation-fragment_release" }, k = 1, mv = { 1, 6, 0 })
    public static class b extends NavDestination
    {
        private String w;
        
        public b(final Navigator<? extends b> navigator) {
            o.g((Object)navigator, "fragmentNavigator");
            super(navigator);
        }
        
        public final String C() {
            final String w = this.w;
            if (w != null) {
                Objects.requireNonNull(w, "null cannot be cast to non-null type kotlin.String");
                return w;
            }
            throw new IllegalStateException("Fragment class was not set".toString());
        }
        
        public final b D(final String w) {
            o.g((Object)w, "className");
            this.w = w;
            return this;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o != null) {
                if (!(o instanceof b)) {
                    b2 = b;
                }
                else {
                    b2 = b;
                    if (super.equals(o)) {
                        b2 = b;
                        if (o.b((Object)this.w, (Object)((b)o).w)) {
                            b2 = true;
                        }
                    }
                }
            }
            return b2;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = super.hashCode();
            final String w = this.w;
            int hashCode2;
            if (w != null) {
                hashCode2 = w.hashCode();
            }
            else {
                hashCode2 = 0;
            }
            return hashCode * 31 + hashCode2;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            final String w = this.w;
            if (w == null) {
                sb.append("null");
            }
            else {
                sb.append(w);
            }
            final String string = sb.toString();
            o.f((Object)string, "sb.toString()");
            return string;
        }
        
        @Override
        public void w(final Context context, final AttributeSet set) {
            o.g((Object)context, "context");
            o.g((Object)set, "attrs");
            super.w(context, set);
            final TypedArray obtainAttributes = context.getResources().obtainAttributes(set, g.c);
            o.f((Object)obtainAttributes, "context.resources.obtain\u2026leable.FragmentNavigator)");
            final String string = obtainAttributes.getString(g.d);
            if (string != null) {
                this.D(string);
            }
            final r a = r.a;
            obtainAttributes.recycle();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b" }, d2 = { "Lq0/e$c;", "Landroidx/navigation/Navigator$a;", "", "Landroid/view/View;", "", "a", "()Ljava/util/Map;", "sharedElements", "navigation-fragment_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class c implements Navigator.a
    {
        private final LinkedHashMap<View, String> a;
        
        public final Map<View, String> a() {
            return e0.t((Map)this.a);
        }
    }
}
