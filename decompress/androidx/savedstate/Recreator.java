// 
// Decompiled by Procyon v0.6.0
// 

package androidx.savedstate;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;
import android.os.Bundle;
import androidx.lifecycle.q;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import java.lang.reflect.Constructor;
import u0.c;
import kotlin.jvm.internal.i;
import u0.e;
import kotlin.Metadata;
import androidx.lifecycle.o;

@Metadata(bv = {}, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u000fB\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u0011" }, d2 = { "Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/o;", "", "className", "Lka/r;", "g", "Landroidx/lifecycle/r;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "f", "Lu0/e;", "owner", "<init>", "(Lu0/e;)V", "b", "a", "savedstate_release" }, k = 1, mv = { 1, 6, 0 })
public final class Recreator implements o
{
    public static final a b;
    private final e a;
    
    static {
        b = new a(null);
    }
    
    public Recreator(final e a) {
        kotlin.jvm.internal.o.g((Object)a, "owner");
        this.a = a;
    }
    
    private final void g(String s) {
        try {
            Object o = Class.forName(s, false, Recreator.class.getClassLoader()).asSubclass(c.a.class);
            kotlin.jvm.internal.o.f(o, "{\n                Class.\u2026class.java)\n            }");
            try {
                final Constructor declaredConstructor = ((Class)o).getDeclaredConstructor((Class[])new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    o = declaredConstructor.newInstance(new Object[0]);
                    kotlin.jvm.internal.o.f(o, "{\n                constr\u2026wInstance()\n            }");
                    o = o;
                    ((c.a)o).a(this.a);
                }
                catch (final Exception ex) {
                    o = new StringBuilder();
                    ((StringBuilder)o).append("Failed to instantiate ");
                    ((StringBuilder)o).append(s);
                    throw new RuntimeException(((StringBuilder)o).toString(), ex);
                }
            }
            catch (final NoSuchMethodException ex2) {
                s = (String)new StringBuilder();
                ((StringBuilder)s).append("Class ");
                ((StringBuilder)s).append(((Class)o).getSimpleName());
                ((StringBuilder)s).append(" must have default constructor in order to be automatically recreated");
                throw new IllegalStateException(((StringBuilder)s).toString(), ex2);
            }
        }
        catch (final ClassNotFoundException ex3) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(s);
            sb.append(" wasn't found");
            throw new RuntimeException(sb.toString(), ex3);
        }
    }
    
    @Override
    public void f(final r r, final Lifecycle.Event event) {
        kotlin.jvm.internal.o.g((Object)r, "source");
        kotlin.jvm.internal.o.g((Object)event, "event");
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError((Object)"Next event must be ON_CREATE");
        }
        r.getLifecycle().c(this);
        final Bundle b = this.a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (b == null) {
            return;
        }
        final ArrayList stringArrayList = b.getStringArrayList("classes_to_restore");
        if (stringArrayList != null) {
            final Iterator iterator = stringArrayList.iterator();
            while (iterator.hasNext()) {
                this.g((String)iterator.next());
            }
            return;
        }
        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b" }, d2 = { "Landroidx/savedstate/Recreator$a;", "", "", "CLASSES_KEY", "Ljava/lang/String;", "COMPONENT_KEY", "<init>", "()V", "savedstate_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\u000f" }, d2 = { "Landroidx/savedstate/Recreator$b;", "Lu0/c$c;", "Landroid/os/Bundle;", "saveState", "", "className", "Lka/r;", "a", "", "Ljava/util/Set;", "classes", "Lu0/c;", "registry", "<init>", "(Lu0/c;)V", "savedstate_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class b implements c
    {
        private final Set<String> a;
        
        public b(final u0.c c) {
            kotlin.jvm.internal.o.g((Object)c, "registry");
            this.a = new LinkedHashSet<String>();
            c.h("androidx.savedstate.Restarter", (c)this);
        }
        
        public final void a(final String s) {
            kotlin.jvm.internal.o.g((Object)s, "className");
            this.a.add(s);
        }
        
        @Override
        public Bundle saveState() {
            final Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList((Collection<? extends E>)this.a));
            return bundle;
        }
    }
}
