// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import android.content.res.Resources$NotFoundException;
import android.content.res.TypedArray;
import ka.r;
import p0.a;
import android.util.AttributeSet;
import android.content.Context;
import android.net.Uri;
import java.util.Collection;
import kotlin.collections.g;
import android.os.Bundle;
import kotlin.collections.e0;
import kotlin.sequences.k;
import java.util.Set;
import java.util.Iterator;
import kotlin.jvm.internal.y;
import kotlin.text.l;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.i;
import androidx.collection.h;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 ]2\u00020\u0001:\u0002^!B\u000f\u0012\u0006\u0010,\u001a\u00020\b¢\u0006\u0004\bY\u0010RB\u0019\b\u0016\u0012\u000e\u0010[\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000Z¢\u0006\u0004\bY\u0010\\J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J\u0014\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0000H\u0007J\b\u0010\u0016\u001a\u00020\u0015H\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0001\u0010\u0018\u001a\u00020\u0017J\u0018\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0019J\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fJ\u0014\u0010$\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0007J\b\u0010%\u001a\u00020\bH\u0016J\u0013\u0010'\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010(\u001a\u00020\u0017H\u0016R\u0017\u0010,\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b!\u0010)\u001a\u0004\b*\u0010+R.\u00104\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010-8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010)R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00190B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010CR\"\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010FR,\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u00178G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR.\u0010N\u001a\u0004\u0018\u00010\b2\b\u0010N\u001a\u0004\u0018\u00010\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010)\u001a\u0004\bP\u0010+\"\u0004\bQ\u0010RR\u001d\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001f0S8F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020\b8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010+¨\u0006_" }, d2 = { "Landroidx/navigation/NavDestination;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lka/r;", "w", "", "uriPattern", "e", "Landroidx/navigation/NavDeepLink;", "navDeepLink", "b", "Landroidx/navigation/l;", "navDeepLinkRequest", "Landroidx/navigation/NavDestination$a;", "v", "previousDestination", "", "g", "", "B", "", "id", "Landroidx/navigation/d;", "m", "actionId", "action", "x", "argumentName", "Landroidx/navigation/h;", "argument", "a", "Landroid/os/Bundle;", "args", "f", "toString", "other", "equals", "hashCode", "Ljava/lang/String;", "q", "()Ljava/lang/String;", "navigatorName", "Landroidx/navigation/NavGraph;", "<set-?>", "Landroidx/navigation/NavGraph;", "s", "()Landroidx/navigation/NavGraph;", "z", "(Landroidx/navigation/NavGraph;)V", "parent", "c", "idName", "", "d", "Ljava/lang/CharSequence;", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "label", "", "Ljava/util/List;", "deepLinks", "Landroidx/collection/h;", "Landroidx/collection/h;", "actions", "", "Ljava/util/Map;", "_arguments", "h", "I", "p", "()I", "y", "(I)V", "route", "i", "t", "A", "(Ljava/lang/String;)V", "", "n", "()Ljava/util/Map;", "arguments", "o", "displayName", "<init>", "Landroidx/navigation/Navigator;", "navigator", "(Landroidx/navigation/Navigator;)V", "j", "Companion", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public class NavDestination
{
    public static final Companion j;
    private static final Map<String, Class<?>> p;
    private final String a;
    private NavGraph b;
    private String c;
    private CharSequence d;
    private final List<NavDeepLink> e;
    private final h<d> f;
    private Map<String, androidx.navigation.h> g;
    private int h;
    private String i;
    
    static {
        j = new Companion(null);
        p = new LinkedHashMap<String, Class<?>>();
    }
    
    public NavDestination(final Navigator<? extends NavDestination> navigator) {
        o.g((Object)navigator, "navigator");
        this(v.b.a(navigator.getClass()));
    }
    
    public NavDestination(final String a) {
        o.g((Object)a, "navigatorName");
        this.a = a;
        this.e = new ArrayList<NavDeepLink>();
        this.f = new h<d>();
        this.g = new LinkedHashMap<String, androidx.navigation.h>();
    }
    
    public static int[] k(final NavDestination navDestination, NavDestination navDestination2, final int n, final Object o) {
        if (o == null) {
            if ((n & 0x1) != 0x0) {
                navDestination2 = null;
            }
            return navDestination.g(navDestination2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
    }
    
    public final void A(final String i) {
        if (i == null) {
            this.y(0);
        }
        else {
            if (!(l.w((CharSequence)i) ^ true)) {
                throw new IllegalArgumentException("Cannot have an empty route".toString());
            }
            final String a = NavDestination.j.a(i);
            this.y(a.hashCode());
            this.e(a);
        }
        final List<NavDeepLink> e = this.e;
        while (true) {
            for (final NavDeepLink next : e) {
                if (o.b((Object)next.k(), (Object)NavDestination.j.a(this.i))) {
                    y.a((Object)e).remove(next);
                    this.i = i;
                    return;
                }
            }
            NavDeepLink next = null;
            continue;
        }
    }
    
    public boolean B() {
        return true;
    }
    
    public final void a(final String s, final androidx.navigation.h h) {
        o.g((Object)s, "argumentName");
        o.g((Object)h, "argument");
        this.g.put(s, h);
    }
    
    public final void b(final NavDeepLink navDeepLink) {
        o.g((Object)navDeepLink, "navDeepLink");
        final Map<String, androidx.navigation.h> n = this.n();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Iterator<Map.Entry<String, androidx.navigation.h>> iterator = n.entrySet().iterator();
        while (true) {
            final boolean hasNext = iterator.hasNext();
            boolean b = true;
            if (!hasNext) {
                break;
            }
            final Map.Entry<K, androidx.navigation.h> entry = iterator.next();
            final androidx.navigation.h h = entry.getValue();
            if (h.c() || h.b()) {
                b = false;
            }
            if (!b) {
                continue;
            }
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        final Set keySet = linkedHashMap.keySet();
        final ArrayList list = new ArrayList();
        for (final Object next : keySet) {
            if (navDeepLink.e().contains(next) ^ true) {
                list.add(next);
            }
        }
        if (list.isEmpty()) {
            this.e.add(navDeepLink);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Deep link ");
        sb.append(navDeepLink.k());
        sb.append(" can't be used to open destination ");
        sb.append(this);
        sb.append(".\nFollowing required arguments are missing: ");
        sb.append(list);
        throw new IllegalArgumentException(sb.toString().toString());
    }
    
    public final void e(final String s) {
        o.g((Object)s, "uriPattern");
        this.b(new NavDeepLink.a().d(s).a());
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o != null) {
            if (!(o instanceof NavDestination)) {
                b2 = b;
            }
            else {
                final List<NavDeepLink> e = this.e;
                final NavDestination navDestination = (NavDestination)o;
                final boolean b3 = kotlin.collections.o.h0((Iterable)e, (Iterable)navDestination.e).size() == this.e.size();
                boolean b6 = false;
                Label_0217: {
                    Label_0215: {
                        if (this.f.q() == navDestination.f.q()) {
                            final Iterator iterator = k.c((Iterator)androidx.collection.i.a(this.f)).iterator();
                            while (true) {
                                while (iterator.hasNext()) {
                                    if (!navDestination.f.e((d)iterator.next())) {
                                        final boolean b4 = false;
                                        if (b4) {
                                            final Iterator iterator2 = k.c((Iterator)androidx.collection.i.a(navDestination.f)).iterator();
                                            while (true) {
                                                while (iterator2.hasNext()) {
                                                    if (!this.f.e((d)iterator2.next())) {
                                                        final boolean b5 = false;
                                                        if (b5) {
                                                            b6 = true;
                                                            break Label_0217;
                                                        }
                                                        break Label_0215;
                                                    }
                                                }
                                                final boolean b5 = true;
                                                continue;
                                            }
                                        }
                                        break Label_0215;
                                    }
                                }
                                final boolean b4 = true;
                                continue;
                            }
                        }
                    }
                    b6 = false;
                }
                boolean b9 = false;
                Label_0471: {
                    Label_0468: {
                        if (this.n().size() == navDestination.n().size()) {
                            while (true) {
                                for (final Map.Entry<Object, V> entry : e0.y((Map)this.n())) {
                                    if (!navDestination.n().containsKey(entry.getKey()) || !o.b((Object)navDestination.n().get(entry.getKey()), (Object)entry.getValue())) {
                                        final boolean b7 = false;
                                        if (b7) {
                                            while (true) {
                                                for (final Map.Entry<Object, V> entry2 : e0.y((Map)navDestination.n())) {
                                                    if (!this.n().containsKey(entry2.getKey()) || !o.b((Object)this.n().get(entry2.getKey()), (Object)entry2.getValue())) {
                                                        final boolean b8 = false;
                                                        if (b8) {
                                                            b9 = true;
                                                            break Label_0471;
                                                        }
                                                        break Label_0468;
                                                    }
                                                }
                                                final boolean b8 = true;
                                                continue;
                                            }
                                        }
                                        break Label_0468;
                                    }
                                }
                                final boolean b7 = true;
                                continue;
                            }
                        }
                    }
                    b9 = false;
                }
                b2 = b;
                if (this.h == navDestination.h) {
                    b2 = b;
                    if (o.b((Object)this.i, (Object)navDestination.i)) {
                        b2 = b;
                        if (b3) {
                            b2 = b;
                            if (b6) {
                                b2 = b;
                                if (b9) {
                                    b2 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    public final Bundle f(final Bundle bundle) {
        if (bundle == null) {
            final Map<String, androidx.navigation.h> g = this.g;
            if (g == null || g.isEmpty()) {
                return null;
            }
        }
        final Bundle bundle2 = new Bundle();
        for (final Map.Entry entry : this.g.entrySet()) {
            ((androidx.navigation.h)entry.getValue()).d((String)entry.getKey(), bundle2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            for (final Map.Entry<String, V> entry2 : this.g.entrySet()) {
                final String s = entry2.getKey();
                final androidx.navigation.h h = (androidx.navigation.h)entry2.getValue();
                if (h.e(s, bundle2)) {
                    continue;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Wrong argument type for '");
                sb.append(s);
                sb.append("' in argument bundle. ");
                sb.append(h.a().b());
                sb.append(" expected.");
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
        return bundle2;
    }
    
    public final int[] g(final NavDestination navDestination) {
        final g g = new g();
        NavDestination navDestination2 = this;
        while (true) {
            o.d((Object)navDestination2);
            final NavGraph b = navDestination2.b;
            NavGraph b2;
            if (navDestination != null) {
                b2 = navDestination.b;
            }
            else {
                b2 = null;
            }
            if (b2 != null) {
                final NavGraph b3 = navDestination.b;
                o.d((Object)b3);
                if (b3.D(navDestination2.h) == navDestination2) {
                    g.addFirst((Object)navDestination2);
                    break;
                }
            }
            if (b == null || b.N() != navDestination2.h) {
                g.addFirst((Object)navDestination2);
            }
            if (o.b((Object)b, (Object)navDestination)) {
                break;
            }
            if (b == null) {
                break;
            }
            navDestination2 = b;
        }
        final List n0 = kotlin.collections.o.N0((Iterable)g);
        final ArrayList list = new ArrayList(kotlin.collections.o.u((Iterable)n0, 10));
        final Iterator iterator = n0.iterator();
        while (iterator.hasNext()) {
            list.add((Object)((NavDestination)iterator.next()).h);
        }
        return kotlin.collections.o.M0((Collection)list);
    }
    
    @Override
    public int hashCode() {
        final int h = this.h;
        final String i = this.i;
        int hashCode;
        if (i != null) {
            hashCode = i.hashCode();
        }
        else {
            hashCode = 0;
        }
        int n = h * 31 + hashCode;
        for (final NavDeepLink navDeepLink : this.e) {
            final String k = navDeepLink.k();
            int hashCode2;
            if (k != null) {
                hashCode2 = k.hashCode();
            }
            else {
                hashCode2 = 0;
            }
            final String d = navDeepLink.d();
            int hashCode3;
            if (d != null) {
                hashCode3 = d.hashCode();
            }
            else {
                hashCode3 = 0;
            }
            final String g = navDeepLink.g();
            int hashCode4;
            if (g != null) {
                hashCode4 = g.hashCode();
            }
            else {
                hashCode4 = 0;
            }
            n = ((n * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4;
        }
        final Iterator<d> a = androidx.collection.i.a(this.f);
        while (a.hasNext()) {
            final d d2 = a.next();
            final int b = d2.b();
            final q c = d2.c();
            int hashCode5;
            if (c != null) {
                hashCode5 = c.hashCode();
            }
            else {
                hashCode5 = 0;
            }
            int n2 = (n * 31 + b) * 31 + hashCode5;
            final Bundle a2 = d2.a();
            n = n2;
            if (a2 != null) {
                final Set keySet = a2.keySet();
                n = n2;
                if (keySet == null) {
                    continue;
                }
                o.f((Object)keySet, "keySet()");
                final Iterator iterator2 = keySet.iterator();
                while (true) {
                    n = n2;
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    final String s = (String)iterator2.next();
                    final Bundle a3 = d2.a();
                    o.d((Object)a3);
                    final Object value = a3.get(s);
                    int hashCode6;
                    if (value != null) {
                        hashCode6 = value.hashCode();
                    }
                    else {
                        hashCode6 = 0;
                    }
                    n2 = n2 * 31 + hashCode6;
                }
            }
        }
        for (final String s2 : this.n().keySet()) {
            final int hashCode7 = s2.hashCode();
            final androidx.navigation.h value2 = this.n().get(s2);
            int hashCode8;
            if (value2 != null) {
                hashCode8 = value2.hashCode();
            }
            else {
                hashCode8 = 0;
            }
            n = (n * 31 + hashCode7) * 31 + hashCode8;
        }
        return n;
    }
    
    public final d m(final int n) {
        final boolean l = this.f.l();
        final d d = null;
        d m;
        if (l) {
            m = null;
        }
        else {
            m = this.f.g(n);
        }
        if (m == null) {
            final NavGraph b = this.b;
            m = d;
            if (b != null) {
                m = b.m(n);
            }
        }
        return m;
    }
    
    public final Map<String, androidx.navigation.h> n() {
        return e0.t((Map)this.g);
    }
    
    public String o() {
        String s;
        if ((s = this.c) == null) {
            s = String.valueOf(this.h);
        }
        return s;
    }
    
    public final int p() {
        return this.h;
    }
    
    public final String q() {
        return this.a;
    }
    
    public final NavGraph s() {
        return this.b;
    }
    
    public final String t() {
        return this.i;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append("(");
        final String c = this.c;
        if (c == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.h));
        }
        else {
            sb.append(c);
        }
        sb.append(")");
        final String i = this.i;
        if (i != null && !l.w((CharSequence)i)) {
            sb.append(" route=");
            sb.append(this.i);
        }
        if (this.d != null) {
            sb.append(" label=");
            sb.append(this.d);
        }
        final String string = sb.toString();
        o.f((Object)string, "sb.toString()");
        return string;
    }
    
    public a v(final androidx.navigation.l l) {
        o.g((Object)l, "navDeepLinkRequest");
        if (this.e.isEmpty()) {
            return null;
        }
        final Iterator<NavDeepLink> iterator = this.e.iterator();
        a a = null;
        while (iterator.hasNext()) {
            final NavDeepLink navDeepLink = iterator.next();
            final Uri c = l.c();
            Bundle f;
            if (c != null) {
                f = navDeepLink.f(c, this.n());
            }
            else {
                f = null;
            }
            final String a2 = l.a();
            final boolean b = a2 != null && o.b((Object)a2, (Object)navDeepLink.d());
            final String b2 = l.b();
            int h;
            if (b2 != null) {
                h = navDeepLink.h(b2);
            }
            else {
                h = -1;
            }
            if (f != null || b || h > -1) {
                final a a3 = new a(this, f, navDeepLink.l(), b, h);
                if (a != null && a3.a(a) <= 0) {
                    continue;
                }
                a = a3;
            }
        }
        return a;
    }
    
    public void w(final Context context, final AttributeSet set) {
        o.g((Object)context, "context");
        o.g((Object)set, "attrs");
        final TypedArray obtainAttributes = context.getResources().obtainAttributes(set, p0.a.x);
        o.f((Object)obtainAttributes, "context.resources.obtain\u2026s, R.styleable.Navigator)");
        this.A(obtainAttributes.getString(p0.a.A));
        final int z = p0.a.z;
        if (obtainAttributes.hasValue(z)) {
            this.y(obtainAttributes.getResourceId(z, 0));
            this.c = NavDestination.j.b(context, this.h);
        }
        this.d = obtainAttributes.getText(p0.a.y);
        final r a = r.a;
        obtainAttributes.recycle();
    }
    
    public final void x(final int n, final d d) {
        o.g((Object)d, "action");
        if (!this.B()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot add action ");
            sb.append(n);
            sb.append(" to ");
            sb.append(this);
            sb.append(" as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
            throw new UnsupportedOperationException(sb.toString());
        }
        if (n != 0) {
            this.f.n(n, d);
            return;
        }
        throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
    }
    
    public final void y(final int h) {
        this.h = h;
        this.c = null;
    }
    
    public final void z(final NavGraph b) {
        this.b = b;
    }
    
    @Metadata(bv = {}, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007R$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000b*\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017" }, d2 = { "Landroidx/navigation/NavDestination$Companion;", "", "Landroid/content/Context;", "context", "", "id", "", "b", "route", "a", "Landroidx/navigation/NavDestination;", "Lkotlin/sequences/h;", "c", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/h;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "hierarchy", "", "Ljava/lang/Class;", "classes", "Ljava/util/Map;", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class Companion
    {
        private Companion() {
        }
        
        public Companion(final i i) {
            this();
        }
        
        public final String a(String string) {
            if (string != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("android-app://androidx.navigation/");
                sb.append(string);
                string = sb.toString();
            }
            else {
                string = "";
            }
            return string;
        }
        
        public final String b(final Context context, final int n) {
            o.g((Object)context, "context");
            String s;
            if (n <= 16777215) {
                s = String.valueOf(n);
            }
            else {
                try {
                    s = context.getResources().getResourceName(n);
                }
                catch (final Resources$NotFoundException ex) {
                    s = String.valueOf(n);
                }
                o.f((Object)s, "try {\n                co\u2026.toString()\n            }");
            }
            return s;
        }
        
        public final kotlin.sequences.h<NavDestination> c(final NavDestination navDestination) {
            o.g((Object)navDestination, "<this>");
            return (kotlin.sequences.h<NavDestination>)k.h((Object)navDestination, (sa.l)NavDestination$Companion$hierarchy.NavDestination$Companion$hierarchy$1.INSTANCE);
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019" }, d2 = { "Landroidx/navigation/NavDestination$a;", "", "other", "", "a", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavDestination;", "c", "()Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "b", "Landroid/os/Bundle;", "d", "()Landroid/os/Bundle;", "matchingArgs", "", "Z", "isExactDeepLink", "hasMatchingAction", "e", "I", "mimeTypeMatchLevel", "<init>", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZZI)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a implements Comparable<a>
    {
        private final NavDestination a;
        private final Bundle b;
        private final boolean c;
        private final boolean d;
        private final int e;
        
        public a(final NavDestination a, final Bundle b, final boolean c, final boolean d, final int e) {
            o.g((Object)a, "destination");
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
        
        public int a(final a a) {
            o.g((Object)a, "other");
            final boolean c = this.c;
            if (c && !a.c) {
                return 1;
            }
            if (!c && a.c) {
                return -1;
            }
            final Bundle b = this.b;
            if (b != null && a.b == null) {
                return 1;
            }
            if (b == null && a.b != null) {
                return -1;
            }
            if (b != null) {
                final int size = b.size();
                final Bundle b2 = a.b;
                o.d((Object)b2);
                final int n = size - b2.size();
                if (n > 0) {
                    return 1;
                }
                if (n < 0) {
                    return -1;
                }
            }
            final boolean d = this.d;
            if (d && !a.d) {
                return 1;
            }
            if (!d && a.d) {
                return -1;
            }
            return this.e - a.e;
        }
        
        public final NavDestination c() {
            return this.a;
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((a)o);
        }
        
        public final Bundle d() {
            return this.b;
        }
    }
}
