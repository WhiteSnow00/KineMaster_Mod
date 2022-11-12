// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity.result;

import java.util.Iterator;
import androidx.lifecycle.q;
import android.util.Log;
import androidx.lifecycle.o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import java.io.Serializable;
import java.util.Collection;
import androidx.core.app.c;
import android.os.Parcelable;
import android.content.Intent;
import java.util.HashMap;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry
{
    private Random a;
    private final Map<Integer, String> b;
    final Map<String, Integer> c;
    private final Map<String, d> d;
    ArrayList<String> e;
    final transient Map<String, c<?>> f;
    final Map<String, Object> g;
    final Bundle h;
    
    public ActivityResultRegistry() {
        this.a = new Random();
        this.b = new HashMap<Integer, String>();
        this.c = new HashMap<String, Integer>();
        this.d = new HashMap<String, d>();
        this.e = new ArrayList<String>();
        this.f = new HashMap<String, c<?>>();
        this.g = new HashMap<String, Object>();
        this.h = new Bundle();
    }
    
    private void a(final int n, final String s) {
        this.b.put(n, s);
        this.c.put(s, n);
    }
    
    private <O> void d(final String s, final int n, final Intent intent, final c<O> c) {
        if (c != null && c.a != null && this.e.contains(s)) {
            c.a.a(c.b.parseResult(n, intent));
            this.e.remove(s);
        }
        else {
            this.g.remove(s);
            this.h.putParcelable(s, (Parcelable)new ActivityResult(n, intent));
        }
    }
    
    private int e() {
        int n = this.a.nextInt(2147418112);
        int n2;
        while (true) {
            n2 = n + 65536;
            if (!this.b.containsKey(n2)) {
                break;
            }
            n = this.a.nextInt(2147418112);
        }
        return n2;
    }
    
    private void k(final String s) {
        if (this.c.get(s) != null) {
            return;
        }
        this.a(this.e(), s);
    }
    
    public final boolean b(final int n, final int n2, final Intent intent) {
        final String s = this.b.get(n);
        if (s == null) {
            return false;
        }
        this.d(s, n2, intent, this.f.get(s));
        return true;
    }
    
    public final <O> boolean c(final int n, final O o) {
        final String s = this.b.get(n);
        if (s == null) {
            return false;
        }
        final c c = this.f.get(s);
        if (c != null) {
            final a<O> a = c.a;
            if (a != null) {
                if (this.e.remove(s)) {
                    a.a((O)o);
                    return true;
                }
                return true;
            }
        }
        this.h.remove(s);
        this.g.put(s, o);
        return true;
    }
    
    public abstract <I, O> void f(final int p0, final c.a<I, O> p1, final I p2, final androidx.core.app.c p3);
    
    public final void g(final Bundle bundle) {
        if (bundle == null) {
            return;
        }
        final ArrayList integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        final ArrayList stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList != null) {
            if (integerArrayList != null) {
                this.e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.a = (Random)bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i = 0; i < stringArrayList.size(); ++i) {
                    final String s = stringArrayList.get(i);
                    if (this.c.containsKey(s)) {
                        final Integer n = this.c.remove(s);
                        if (!this.h.containsKey(s)) {
                            this.b.remove(n);
                        }
                    }
                    this.a((int)integerArrayList.get(i), (String)stringArrayList.get(i));
                }
            }
        }
    }
    
    public final void h(final Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList((Collection<? extends E>)this.c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList((Collection<? extends E>)this.c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList((Collection<? extends E>)this.e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle)this.h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", (Serializable)this.a);
    }
    
    public final <I, O> b<I> i(final String s, final r r, final c.a<I, O> a, final a<O> a2) {
        final Lifecycle lifecycle = r.getLifecycle();
        if (!lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            this.k(s);
            d d;
            if ((d = this.d.get(s)) == null) {
                d = new d(lifecycle);
            }
            d.a(new o(this, s, a2, a) {
                final String a;
                final a b;
                final c.a c;
                final ActivityResultRegistry d;
                
                @Override
                public void f(final r r, final Lifecycle.Event event) {
                    if (Lifecycle.Event.ON_START.equals(event)) {
                        this.d.f.put(this.a, new c<Object>(this.b, this.c));
                        if (this.d.g.containsKey(this.a)) {
                            final Object value = this.d.g.get(this.a);
                            this.d.g.remove(this.a);
                            this.b.a(value);
                        }
                        final ActivityResult activityResult = (ActivityResult)this.d.h.getParcelable(this.a);
                        if (activityResult != null) {
                            this.d.h.remove(this.a);
                            this.b.a(this.c.parseResult(activityResult.b(), activityResult.a()));
                        }
                    }
                    else if (Lifecycle.Event.ON_STOP.equals(event)) {
                        this.d.f.remove(this.a);
                    }
                    else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        this.d.l(this.a);
                    }
                }
            });
            this.d.put(s, d);
            return new b<I>(this, s, a) {
                final String a;
                final c.a b;
                final ActivityResultRegistry c;
                
                @Override
                public void b(final I n, final androidx.core.app.c c) {
                    final Integer n2 = this.c.c.get(this.a);
                    if (n2 != null) {
                        this.c.e.add(this.a);
                        try {
                            this.c.f(n2, (c.a<I, Object>)this.b, n, c);
                            return;
                        }
                        catch (final Exception ex) {
                            this.c.e.remove(this.a);
                            throw ex;
                        }
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Attempting to launch an unregistered ActivityResultLauncher with contract ");
                    sb.append(this.b);
                    sb.append(" and input ");
                    sb.append(n);
                    sb.append(". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    throw new IllegalStateException(sb.toString());
                }
                
                @Override
                public void c() {
                    this.c.l(this.a);
                }
            };
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("LifecycleOwner ");
        sb.append(r);
        sb.append(" is attempting to register while current state is ");
        sb.append(lifecycle.b());
        sb.append(". LifecycleOwners must call register before they are STARTED.");
        throw new IllegalStateException(sb.toString());
    }
    
    public final <I, O> b<I> j(final String s, final c.a<I, O> a, final a<O> a2) {
        this.k(s);
        this.f.put(s, new c<Object>((a<Object>)a2, (c.a<?, Object>)a));
        if (this.g.containsKey(s)) {
            final Object value = this.g.get(s);
            this.g.remove(s);
            a2.a((O)value);
        }
        final ActivityResult activityResult = (ActivityResult)this.h.getParcelable(s);
        if (activityResult != null) {
            this.h.remove(s);
            a2.a(a.parseResult(activityResult.b(), activityResult.a()));
        }
        return new b<I>(this, s, a) {
            final String a;
            final c.a b;
            final ActivityResultRegistry c;
            
            @Override
            public void b(final I n, final androidx.core.app.c c) {
                final Integer n2 = this.c.c.get(this.a);
                if (n2 != null) {
                    this.c.e.add(this.a);
                    try {
                        this.c.f(n2, (c.a<I, Object>)this.b, n, c);
                        return;
                    }
                    catch (final Exception ex) {
                        this.c.e.remove(this.a);
                        throw ex;
                    }
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Attempting to launch an unregistered ActivityResultLauncher with contract ");
                sb.append(this.b);
                sb.append(" and input ");
                sb.append(n);
                sb.append(". You must ensure the ActivityResultLauncher is registered before calling launch().");
                throw new IllegalStateException(sb.toString());
            }
            
            @Override
            public void c() {
                this.c.l(this.a);
            }
        };
    }
    
    final void l(final String s) {
        if (!this.e.contains(s)) {
            final Integer n = this.c.remove(s);
            if (n != null) {
                this.b.remove(n);
            }
        }
        this.f.remove(s);
        if (this.g.containsKey(s)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Dropping pending result for request ");
            sb.append(s);
            sb.append(": ");
            sb.append(this.g.get(s));
            Log.w("ActivityResultRegistry", sb.toString());
            this.g.remove(s);
        }
        if (this.h.containsKey(s)) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Dropping pending result for request ");
            sb2.append(s);
            sb2.append(": ");
            sb2.append(this.h.getParcelable(s));
            Log.w("ActivityResultRegistry", sb2.toString());
            this.h.remove(s);
        }
        final d d = this.d.get(s);
        if (d != null) {
            d.b();
            this.d.remove(s);
        }
    }
    
    private static class c<O>
    {
        final a<O> a;
        final c.a<?, O> b;
        
        c(final a<O> a, final c.a<?, O> b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static class d
    {
        final Lifecycle a;
        private final ArrayList<o> b;
        
        d(final Lifecycle a) {
            this.a = a;
            this.b = new ArrayList<o>();
        }
        
        void a(final o o) {
            this.a.a(o);
            this.b.add(o);
        }
        
        void b() {
            final Iterator<o> iterator = this.b.iterator();
            while (iterator.hasNext()) {
                this.a.c(iterator.next());
            }
            this.b.clear();
        }
    }
}
