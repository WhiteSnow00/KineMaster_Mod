// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.Objects;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import androidx.core.os.d;
import ka.l;
import kotlin.Pair;
import kotlin.collections.e0;
import kotlin.jvm.internal.o;
import java.util.LinkedHashMap;
import android.util.SizeF;
import android.util.Size;
import android.util.SparseArray;
import java.io.Serializable;
import android.os.Parcelable;
import java.util.ArrayList;
import android.os.Bundle;
import android.os.Binder;
import kotlinx.coroutines.flow.i;
import u0.c;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0010B\u001f\b\u0016\u0012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\t\b\u0016¢\u0006\u0004\b\u001b\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0087\u0002J \u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\b\t\u0010\nJ(\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0087\u0002¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R(\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00160\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011¨\u0006\u001e" }, d2 = { "Landroidx/lifecycle/g0;", "", "Lu0/c$c;", "f", "", "key", "", "c", "T", "e", "(Ljava/lang/String;)Ljava/lang/Object;", "value", "Lka/r;", "h", "(Ljava/lang/String;Ljava/lang/Object;)V", "", "a", "Ljava/util/Map;", "regular", "b", "savedStateProviders", "liveDatas", "Lkotlinx/coroutines/flow/i;", "d", "flows", "", "initialState", "<init>", "(Ljava/util/Map;)V", "()V", "lifecycle-viewmodel-savedstate_release" }, k = 1, mv = { 1, 6, 0 })
public final class g0
{
    public static final a f;
    private static final Class<?>[] g;
    private final Map<String, Object> a;
    private final Map<String, c.c> b;
    private final Map<String, Object> c;
    private final Map<String, i<Object>> d;
    private final c.c e;
    
    static {
        f = new a(null);
        g = new Class[] { Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class };
    }
    
    public g0() {
        this.a = new LinkedHashMap<String, Object>();
        this.b = new LinkedHashMap<String, c.c>();
        this.c = new LinkedHashMap<String, Object>();
        this.d = new LinkedHashMap<String, i<Object>>();
        this.e = new f0(this);
    }
    
    public g0(final Map<String, ?> map) {
        o.g((Object)map, "initialState");
        final LinkedHashMap a = new LinkedHashMap();
        this.a = a;
        this.b = new LinkedHashMap<String, c.c>();
        this.c = new LinkedHashMap<String, Object>();
        this.d = new LinkedHashMap<String, i<Object>>();
        this.e = new f0(this);
        a.putAll(map);
    }
    
    public static Bundle a(final g0 g0) {
        return g(g0);
    }
    
    public static final Class[] b() {
        return g0.g;
    }
    
    public static final g0 d(final Bundle bundle, final Bundle bundle2) {
        return g0.f.a(bundle, bundle2);
    }
    
    private static final Bundle g(final g0 g0) {
        o.g((Object)g0, "this$0");
        for (final Map.Entry<String, V> entry : e0.t((Map)g0.b).entrySet()) {
            g0.h(entry.getKey(), ((c.c)entry.getValue()).saveState());
        }
        final Set<String> keySet = g0.a.keySet();
        final ArrayList list = new ArrayList(keySet.size());
        final ArrayList list2 = new ArrayList<Object>(list.size());
        for (final String s : keySet) {
            list.add((Object)s);
            list2.add(g0.a.get(s));
        }
        return d.a(l.a((Object)"keys", (Object)list), l.a((Object)"values", (Object)list2));
    }
    
    public final boolean c(final String s) {
        o.g((Object)s, "key");
        return this.a.containsKey(s);
    }
    
    public final <T> T e(final String s) {
        o.g((Object)s, "key");
        return (T)this.a.get(s);
    }
    
    public final c.c f() {
        return this.e;
    }
    
    public final <T> void h(final String s, final T t) {
        o.g((Object)s, "key");
        if (g0.f.b(t)) {
            final z value = this.c.get(s);
            z z;
            if (value instanceof z) {
                z = value;
            }
            else {
                z = null;
            }
            if (z != null) {
                z.setValue(t);
            }
            else {
                this.a.put(s, t);
            }
            final i i = this.d.get(s);
            if (i != null) {
                i.setValue((Object)t);
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Can't put value with type ");
        o.d((Object)t);
        sb.append(t.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString());
    }
    
    @Metadata(bv = {}, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0007R$\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0014" }, d2 = { "Landroidx/lifecycle/g0$a;", "", "Landroid/os/Bundle;", "restoredState", "defaultState", "Landroidx/lifecycle/g0;", "a", "value", "", "b", "", "Ljava/lang/Class;", "ACCEPTABLE_CLASSES", "[Ljava/lang/Class;", "", "KEYS", "Ljava/lang/String;", "VALUES", "<init>", "()V", "lifecycle-viewmodel-savedstate_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final kotlin.jvm.internal.i i) {
            this();
        }
        
        public final g0 a(final Bundle bundle, final Bundle bundle2) {
            if (bundle == null) {
                g0 g0;
                if (bundle2 == null) {
                    g0 = new g0();
                }
                else {
                    final HashMap hashMap = new HashMap();
                    for (final String s : bundle2.keySet()) {
                        o.f((Object)s, "key");
                        hashMap.put(s, bundle2.get(s));
                    }
                    g0 = new g0(hashMap);
                }
                return g0;
            }
            final ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            final ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            final int n = 0;
            if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (int size = parcelableArrayList.size(), i = n; i < size; ++i) {
                    final Object value = parcelableArrayList.get(i);
                    Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.String");
                    linkedHashMap.put(value, parcelableArrayList2.get(i));
                }
                return new g0(linkedHashMap);
            }
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        }
        
        public final boolean b(final Object o) {
            if (o == null) {
                return true;
            }
            for (final Class clazz : g0.b()) {
                o.d((Object)clazz);
                if (clazz.isInstance(o)) {
                    return true;
                }
            }
            return false;
        }
    }
}
