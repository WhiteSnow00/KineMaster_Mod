// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import android.content.res.TypedArray;
import ka.r;
import android.util.AttributeSet;
import android.content.Context;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Iterator;
import kotlin.sequences.k;
import kotlin.text.l;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import androidx.collection.h;
import kotlin.Metadata;
import ta.a;

@Metadata(bv = {}, d1 = { "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ?2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001@B\u0017\u0012\u000e\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000;¢\u0006\u0004\b=\u0010>J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0017J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0001J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\u0010\u001a\u00020\u000fJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019H\u0086\u0002J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000fJ\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0013\u0010 \u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010!\u001a\u00020\u000fH\u0016R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\"8G¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010\u001b\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0018R\u0018\u0010*\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R.\u00101\u001a\u0004\u0018\u00010\u00122\b\u0010+\u001a\u0004\u0018\u00010\u00128\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010)\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00106\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f8G@BX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00128WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010.R\u0011\u0010:\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b9\u0010.¨\u0006A" }, d2 = { "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lka/r;", "w", "Landroidx/navigation/l;", "navDeepLinkRequest", "Landroidx/navigation/NavDestination$a;", "v", "node", "C", "", "resId", "D", "", "route", "H", "", "searchParents", "G", "I", "", "iterator", "startDestId", "P", "toString", "", "other", "equals", "hashCode", "Landroidx/collection/h;", "Landroidx/collection/h;", "J", "()Landroidx/collection/h;", "nodes", "x", "y", "Ljava/lang/String;", "startDestIdName", "startDestRoute", "z", "O", "()Ljava/lang/String;", "R", "(Ljava/lang/String;)V", "startDestinationRoute", "N", "()I", "Q", "(I)V", "startDestinationId", "o", "displayName", "K", "startDestDisplayName", "Landroidx/navigation/Navigator;", "navGraphNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", "A", "Companion", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public class NavGraph extends NavDestination implements Iterable<NavDestination>, ta.a
{
    public static final Companion A;
    private final h<NavDestination> w;
    private int x;
    private String y;
    private String z;
    
    static {
        A = new Companion(null);
    }
    
    public NavGraph(final Navigator<? extends NavGraph> navigator) {
        o.g((Object)navigator, "navGraphNavigator");
        super(navigator);
        this.w = new h<NavDestination>();
    }
    
    private final void Q(final int x) {
        if (x != this.p()) {
            if (this.z != null) {
                this.R(null);
            }
            this.x = x;
            this.y = null;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Start destination ");
        sb.append(x);
        sb.append(" cannot use the same id as the graph ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString().toString());
    }
    
    private final void R(final String z) {
        int hashCode;
        if (z == null) {
            hashCode = 0;
        }
        else {
            if (!(o.b((Object)z, (Object)this.t()) ^ true)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Start destination ");
                sb.append(z);
                sb.append(" cannot use the same route as the graph ");
                sb.append(this);
                throw new IllegalArgumentException(sb.toString().toString());
            }
            if (!(l.w((CharSequence)z) ^ true)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
            }
            hashCode = NavDestination.j.a(z).hashCode();
        }
        this.x = hashCode;
        this.z = z;
    }
    
    public final void C(final NavDestination navDestination) {
        o.g((Object)navDestination, "node");
        final int p = navDestination.p();
        final String t = navDestination.t();
        final int n = 0;
        if (p == 0 && t == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
        }
        if (this.t() != null && !(o.b((Object)t, (Object)this.t()) ^ true)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Destination ");
            sb.append(navDestination);
            sb.append(" cannot have the same route as graph ");
            sb.append(this);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        if (p == this.p()) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Destination ");
            sb2.append(navDestination);
            sb2.append(" cannot have the same id as graph ");
            sb2.append(this);
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        final NavDestination navDestination2 = this.w.g(p);
        if (navDestination2 == navDestination) {
            return;
        }
        int n2 = n;
        if (navDestination.s() == null) {
            n2 = 1;
        }
        if (n2 != 0) {
            if (navDestination2 != null) {
                navDestination2.z(null);
            }
            navDestination.z(this);
            this.w.n(navDestination.p(), navDestination);
            return;
        }
        throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
    }
    
    public final NavDestination D(final int n) {
        return this.G(n, true);
    }
    
    public final NavDestination G(final int n, final boolean b) {
        NavDestination d;
        if ((d = this.w.g(n)) == null) {
            if (b && this.s() != null) {
                final NavGraph s = this.s();
                o.d((Object)s);
                d = s.D(n);
            }
            else {
                d = null;
            }
        }
        return d;
    }
    
    public final NavDestination H(final String s) {
        NavDestination i;
        if (s != null && !l.w((CharSequence)s)) {
            i = this.I(s, true);
        }
        else {
            i = null;
        }
        return i;
    }
    
    public final NavDestination I(final String s, final boolean b) {
        o.g((Object)s, "route");
        NavDestination h;
        if ((h = this.w.g(NavDestination.j.a(s).hashCode())) == null) {
            if (b && this.s() != null) {
                final NavGraph s2 = this.s();
                o.d((Object)s2);
                h = s2.H(s);
            }
            else {
                h = null;
            }
        }
        return h;
    }
    
    public final h<NavDestination> J() {
        return this.w;
    }
    
    public final String K() {
        if (this.y == null) {
            String y;
            if ((y = this.z) == null) {
                y = String.valueOf(this.x);
            }
            this.y = y;
        }
        final String y2 = this.y;
        o.d((Object)y2);
        return y2;
    }
    
    public final int N() {
        return this.x;
    }
    
    public final String O() {
        return this.z;
    }
    
    public final void P(final int n) {
        this.Q(n);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o != null) {
            if (!(o instanceof NavGraph)) {
                b2 = b;
            }
            else {
                final List e = k.E(k.c((Iterator)androidx.collection.i.a(this.w)));
                final NavGraph navGraph = (NavGraph)o;
                final Iterator<NavDestination> a = androidx.collection.i.a(navGraph.w);
                while (a.hasNext()) {
                    e.remove(a.next());
                }
                b2 = b;
                if (super.equals(o)) {
                    b2 = b;
                    if (this.w.q() == navGraph.w.q()) {
                        b2 = b;
                        if (this.N() == navGraph.N()) {
                            b2 = b;
                            if (e.isEmpty()) {
                                b2 = true;
                            }
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    @Override
    public int hashCode() {
        int n = this.N();
        final h<NavDestination> w = this.w;
        for (int q = w.q(), i = 0; i < q; ++i) {
            n = (n * 31 + w.m(i)) * 31 + ((NavDestination)w.r(i)).hashCode();
        }
        return n;
    }
    
    @Override
    public final Iterator<NavDestination> iterator() {
        return new Iterator<NavDestination>(this) {
            private int a = -1;
            private boolean b;
            final NavGraph c;
            
            public NavDestination b() {
                if (this.hasNext()) {
                    this.b = true;
                    final h<NavDestination> j = this.c.J();
                    final int a = this.a + 1;
                    this.a = a;
                    final NavDestination r = j.r(a);
                    o.f((Object)r, "nodes.valueAt(++index)");
                    return r;
                }
                throw new NoSuchElementException();
            }
            
            @Override
            public boolean hasNext() {
                final int a = this.a;
                boolean b = true;
                if (a + 1 >= this.c.J().q()) {
                    b = false;
                }
                return b;
            }
            
            @Override
            public /* bridge */ Object next() {
                return this.b();
            }
            
            @Override
            public void remove() {
                if (this.b) {
                    final h<NavDestination> j = this.c.J();
                    j.r(this.a).z(null);
                    j.o(this.a);
                    --this.a;
                    this.b = false;
                    return;
                }
                throw new IllegalStateException("You must call next() before you can remove an element".toString());
            }
        };
    }
    
    @Override
    public String o() {
        String o;
        if (this.p() != 0) {
            o = super.o();
        }
        else {
            o = "the root navigation";
        }
        return o;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination navDestination;
        if ((navDestination = this.H(this.z)) == null) {
            navDestination = this.D(this.N());
        }
        sb.append(" startDestination=");
        if (navDestination == null) {
            final String z = this.z;
            if (z != null) {
                sb.append(z);
            }
            else {
                final String y = this.y;
                if (y != null) {
                    sb.append(y);
                }
                else {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("0x");
                    sb2.append(Integer.toHexString(this.x));
                    sb.append(sb2.toString());
                }
            }
        }
        else {
            sb.append("{");
            sb.append(navDestination.toString());
            sb.append("}");
        }
        final String string = sb.toString();
        o.f((Object)string, "sb.toString()");
        return string;
    }
    
    @Override
    public a v(final androidx.navigation.l l) {
        o.g((Object)l, "navDeepLinkRequest");
        final a v = super.v(l);
        final ArrayList list = new ArrayList();
        final Iterator<NavDestination> iterator = this.iterator();
        while (iterator.hasNext()) {
            final a v2 = iterator.next().v(l);
            if (v2 != null) {
                list.add(v2);
            }
        }
        return (a)kotlin.collections.o.r0((Iterable)kotlin.collections.o.o((Object[])new a[] { v, (a)kotlin.collections.o.r0((Iterable)list) }));
    }
    
    @Override
    public void w(final Context context, final AttributeSet set) {
        o.g((Object)context, "context");
        o.g((Object)set, "attrs");
        super.w(context, set);
        final TypedArray obtainAttributes = context.getResources().obtainAttributes(set, p0.a.v);
        o.f((Object)obtainAttributes, "context.resources.obtain\u2026vGraphNavigator\n        )");
        this.Q(obtainAttributes.getResourceId(p0.a.w, 0));
        this.y = NavDestination.j.b(context, this.x);
        final r a = r.a;
        obtainAttributes.recycle();
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007¨\u0006\u0007" }, d2 = { "Landroidx/navigation/NavGraph$Companion;", "", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "a", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class Companion
    {
        private Companion() {
        }
        
        public Companion(final i i) {
            this();
        }
        
        public final NavDestination a(final NavGraph navGraph) {
            o.g((Object)navGraph, "<this>");
            return (NavDestination)k.w(k.h((Object)navGraph.D(navGraph.N()), (sa.l)NavGraph$Companion$findStartDestination.NavGraph$Companion$findStartDestination$1.INSTANCE));
        }
    }
}
