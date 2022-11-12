// 
// Decompiled by Procyon v0.6.0
// 

package q0;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.Objects;
import androidx.navigation.w;
import androidx.navigation.NavDestination;
import kotlin.jvm.internal.y;
import java.util.ListIterator;
import java.util.Iterator;
import android.util.Log;
import java.util.List;
import java.util.Collection;
import androidx.lifecycle.q;
import androidx.navigation.NavBackStackEntry;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.i;
import androidx.lifecycle.o;
import java.util.Set;
import androidx.fragment.app.FragmentManager;
import android.content.Context;
import kotlin.Metadata;
import androidx.navigation.Navigator;

@Navigator.b("dialog")
@Metadata(bv = {}, d1 = { "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J*\u0010\u0012\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¨\u0006\u001e" }, d2 = { "Lq0/c;", "Landroidx/navigation/Navigator;", "Lq0/c$b;", "Landroidx/navigation/NavBackStackEntry;", "entry", "Lka/r;", "o", "popUpTo", "", "savedState", "j", "n", "", "entries", "Landroidx/navigation/q;", "navOptions", "Landroidx/navigation/Navigator$a;", "navigatorExtras", "e", "Landroidx/navigation/w;", "state", "f", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V", "a", "b", "navigation-fragment_release" }, k = 1, mv = { 1, 6, 0 })
public final class c extends Navigator<b>
{
    private static final a g;
    private final Context c;
    private final FragmentManager d;
    private final Set<String> e;
    private final o f;
    
    static {
        g = new a(null);
    }
    
    public c(final Context c, final FragmentManager d) {
        kotlin.jvm.internal.o.g((Object)c, "context");
        kotlin.jvm.internal.o.g((Object)d, "fragmentManager");
        this.c = c;
        this.d = d;
        this.e = new LinkedHashSet<String>();
        this.f = (o)new q0.b(this);
    }
    
    public static void l(final c c, final FragmentManager fragmentManager, final Fragment fragment) {
        q(c, fragmentManager, fragment);
    }
    
    public static void m(final c c, final r r, final Lifecycle.Event event) {
        p(c, r, event);
    }
    
    private final void o(final NavBackStackEntry navBackStackEntry) {
        final b b = (b)navBackStackEntry.f();
        String s2;
        final String s = s2 = b.C();
        if (s.charAt(0) == '.') {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.c.getPackageName());
            sb.append(s);
            s2 = sb.toString();
        }
        final Fragment a = this.d.x0().a(this.c.getClassLoader(), s2);
        kotlin.jvm.internal.o.f((Object)a, "fragmentManager.fragment\u2026ader, className\n        )");
        if (androidx.fragment.app.c.class.isAssignableFrom(((androidx.fragment.app.c)a).getClass())) {
            final androidx.fragment.app.c c = (androidx.fragment.app.c)a;
            c.setArguments(navBackStackEntry.d());
            c.getLifecycle().a(this.f);
            c.show(this.d, navBackStackEntry.g());
            this.b().h(navBackStackEntry);
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Dialog destination ");
        sb2.append(b.C());
        sb2.append(" is not an instance of DialogFragment");
        throw new IllegalArgumentException(sb2.toString().toString());
    }
    
    private static final void p(final c c, final r r, final Lifecycle.Event event) {
        kotlin.jvm.internal.o.g((Object)c, "this$0");
        kotlin.jvm.internal.o.g((Object)r, "source");
        kotlin.jvm.internal.o.g((Object)event, "event");
        final Lifecycle.Event on_CREATE = Lifecycle.Event.ON_CREATE;
        final boolean b = false;
        if (event == on_CREATE) {
            final androidx.fragment.app.c c2 = (androidx.fragment.app.c)r;
            final Iterable iterable = (Iterable)c.b().b().getValue();
            int n = 0;
            Label_0121: {
                if (iterable instanceof Collection && ((Collection)iterable).isEmpty()) {
                    n = (b ? 1 : 0);
                }
                else {
                    final Iterator iterator = iterable.iterator();
                    do {
                        n = (b ? 1 : 0);
                        if (iterator.hasNext()) {
                            continue;
                        }
                        break Label_0121;
                    } while (!kotlin.jvm.internal.o.b((Object)((NavBackStackEntry)iterator.next()).g(), (Object)c2.getTag()));
                    n = 1;
                }
            }
            if (n == 0) {
                c2.dismiss();
            }
        }
        else if (event == Lifecycle.Event.ON_STOP) {
            final androidx.fragment.app.c c3 = (androidx.fragment.app.c)r;
            if (!c3.requireDialog().isShowing()) {
                final List list = (List)c.b().b().getValue();
                final ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    while (listIterator.hasPrevious()) {
                        final Object previous = listIterator.previous();
                        if (kotlin.jvm.internal.o.b((Object)((NavBackStackEntry)previous).g(), (Object)c3.getTag())) {
                            if (previous != null) {
                                final NavBackStackEntry navBackStackEntry = (NavBackStackEntry)previous;
                                if (!kotlin.jvm.internal.o.b(kotlin.collections.o.p0(list), (Object)navBackStackEntry)) {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("Dialog ");
                                    sb.append(c3);
                                    sb.append(" was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
                                    Log.i("DialogFragmentNavigator", sb.toString());
                                }
                                c.j(navBackStackEntry, false);
                                return;
                            }
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Dialog ");
                            sb2.append(c3);
                            sb2.append(" has already been popped off of the Navigation back stack");
                            throw new IllegalStateException(sb2.toString().toString());
                        }
                    }
                    final Object previous = null;
                    continue;
                }
            }
        }
    }
    
    private static final void q(final c c, final FragmentManager fragmentManager, final Fragment fragment) {
        kotlin.jvm.internal.o.g((Object)c, "this$0");
        kotlin.jvm.internal.o.g((Object)fragmentManager, "<anonymous parameter 0>");
        kotlin.jvm.internal.o.g((Object)fragment, "childFragment");
        if (y.a((Object)c.e).remove(fragment.getTag())) {
            fragment.getLifecycle().a(c.f);
        }
    }
    
    @Override
    public /* bridge */ NavDestination a() {
        return this.n();
    }
    
    @Override
    public void e(final List<NavBackStackEntry> list, final androidx.navigation.q q, final Navigator.a a) {
        kotlin.jvm.internal.o.g((Object)list, "entries");
        if (this.d.T0()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        final Iterator<NavBackStackEntry> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.o(iterator.next());
        }
    }
    
    @Override
    public void f(final w w) {
        kotlin.jvm.internal.o.g((Object)w, "state");
        super.f(w);
        for (final NavBackStackEntry navBackStackEntry : (List)w.b().getValue()) {
            final androidx.fragment.app.c c = (androidx.fragment.app.c)this.d.k0(navBackStackEntry.g());
            if (c != null) {
                final Lifecycle lifecycle = c.getLifecycle();
                if (lifecycle != null) {
                    lifecycle.a(this.f);
                    continue;
                }
            }
            this.e.add(navBackStackEntry.g());
        }
        this.d.k((androidx.fragment.app.y)new q0.a(this));
    }
    
    @Override
    public void j(final NavBackStackEntry navBackStackEntry, final boolean b) {
        kotlin.jvm.internal.o.g((Object)navBackStackEntry, "popUpTo");
        if (this.d.T0()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        final List list = (List)this.b().b().getValue();
        final Iterator iterator = kotlin.collections.o.z0((Iterable)list.subList(list.indexOf(navBackStackEntry), list.size())).iterator();
        while (iterator.hasNext()) {
            final Fragment k0 = this.d.k0(((NavBackStackEntry)iterator.next()).g());
            if (k0 != null) {
                k0.getLifecycle().c(this.f);
                ((androidx.fragment.app.c)k0).dismiss();
            }
        }
        this.b().g(navBackStackEntry, b);
    }
    
    public b n() {
        return new b(this);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007" }, d2 = { "Lq0/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "navigation-fragment_release" }, k = 1, mv = { 1, 6, 0 })
    private static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0017J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018" }, d2 = { "Lq0/c$b;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lka/r;", "w", "", "className", "D", "", "other", "", "equals", "", "hashCode", "C", "()Ljava/lang/String;", "Landroidx/navigation/Navigator;", "fragmentNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", "navigation-fragment_release" }, k = 1, mv = { 1, 6, 0 })
    public static class b extends NavDestination implements androidx.navigation.c
    {
        private String w;
        
        public b(final Navigator<? extends b> navigator) {
            kotlin.jvm.internal.o.g((Object)navigator, "fragmentNavigator");
            super(navigator);
        }
        
        public final String C() {
            final String w = this.w;
            if (w != null) {
                Objects.requireNonNull(w, "null cannot be cast to non-null type kotlin.String");
                return w;
            }
            throw new IllegalStateException("DialogFragment class was not set".toString());
        }
        
        public final b D(final String w) {
            kotlin.jvm.internal.o.g((Object)w, "className");
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
                        if (kotlin.jvm.internal.o.b((Object)this.w, (Object)((b)o).w)) {
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
        public void w(final Context context, final AttributeSet set) {
            kotlin.jvm.internal.o.g((Object)context, "context");
            kotlin.jvm.internal.o.g((Object)set, "attrs");
            super.w(context, set);
            final TypedArray obtainAttributes = context.getResources().obtainAttributes(set, g.a);
            kotlin.jvm.internal.o.f((Object)obtainAttributes, "context.resources.obtain\u2026ntNavigator\n            )");
            final String string = obtainAttributes.getString(g.b);
            if (string != null) {
                this.D(string);
            }
            obtainAttributes.recycle();
        }
    }
}
