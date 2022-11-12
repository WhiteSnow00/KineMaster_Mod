// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import kotlin.collections.e0;
import kotlin.jvm.internal.o;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.i;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\b\u0017\u0018\u0000 \n2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0006\u001a\u00028\u0000\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00022\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0002J*\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0002H\u0017R(\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR%\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016" }, d2 = { "Landroidx/navigation/v;", "", "Landroidx/navigation/Navigator;", "T", "", "name", "d", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigator", "b", "c", "", "a", "Ljava/util/Map;", "_navigators", "", "e", "()Ljava/util/Map;", "navigators", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public class v
{
    public static final a b;
    private static final Map<Class<?>, String> c;
    private final Map<String, Navigator<? extends NavDestination>> a;
    
    static {
        b = new a(null);
        c = new LinkedHashMap<Class<?>, String>();
    }
    
    public v() {
        this.a = new LinkedHashMap<String, Navigator<? extends NavDestination>>();
    }
    
    public static final Map a() {
        return v.c;
    }
    
    public final Navigator<? extends NavDestination> b(final Navigator<? extends NavDestination> navigator) {
        o.g((Object)navigator, "navigator");
        return this.c(v.b.a(navigator.getClass()), navigator);
    }
    
    public Navigator<? extends NavDestination> c(final String s, final Navigator<? extends NavDestination> navigator) {
        o.g((Object)s, "name");
        o.g((Object)navigator, "navigator");
        if (!v.b.b(s)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
        final Navigator navigator2 = this.a.get(s);
        if (o.b((Object)navigator2, (Object)navigator)) {
            return navigator;
        }
        int n = 0;
        if (navigator2 != null) {
            n = n;
            if (navigator2.c()) {
                n = 1;
            }
        }
        if ((n ^ 0x1) == 0x0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Navigator ");
            sb.append(navigator);
            sb.append(" is replacing an already attached ");
            sb.append(navigator2);
            throw new IllegalStateException(sb.toString().toString());
        }
        if (navigator.c() ^ true) {
            return this.a.put(s, navigator);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Navigator ");
        sb2.append(navigator);
        sb2.append(" is already attached to another NavController");
        throw new IllegalStateException(sb2.toString().toString());
    }
    
    public <T extends Navigator<?>> T d(final String s) {
        o.g((Object)s, "name");
        if (!v.b.b(s)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
        final Navigator navigator = this.a.get(s);
        if (navigator != null) {
            return (T)navigator;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Could not find Navigator with name \"");
        sb.append(s);
        sb.append("\". You must call NavController.addNavigator() for each navigation type.");
        throw new IllegalStateException(sb.toString());
    }
    
    public final Map<String, Navigator<? extends NavDestination>> e() {
        return e0.t((Map)this.a);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bR&\u0010\r\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011" }, d2 = { "Landroidx/navigation/v$a;", "", "", "name", "", "b", "(Ljava/lang/String;)Z", "Ljava/lang/Class;", "Landroidx/navigation/Navigator;", "navigatorClass", "a", "(Ljava/lang/Class;)Ljava/lang/String;", "", "annotationNames", "Ljava/util/Map;", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
        
        public final String a(final Class<? extends Navigator<?>> clazz) {
            o.g((Object)clazz, "navigatorClass");
            String value;
            if ((value = v.a().get(clazz)) == null) {
                final Navigator.b b = clazz.getAnnotation(Navigator.b.class);
                if (b != null) {
                    value = b.value();
                }
                else {
                    value = null;
                }
                if (!this.b(value)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("No @Navigator.Name annotation found for ");
                    sb.append(clazz.getSimpleName());
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                v.a().put(clazz, value);
            }
            o.d((Object)value);
            return value;
        }
        
        public final boolean b(final String s) {
            boolean b = true;
            if (s == null || s.length() <= 0) {
                b = false;
            }
            return b;
        }
    }
}
