// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import android.util.Log;
import androidx.lifecycle.q0;
import java.util.HashMap;
import androidx.lifecycle.o0;
import androidx.lifecycle.l0;

final class x extends l0
{
    private static final o0.b h;
    private final HashMap<String, Fragment> a;
    private final HashMap<String, x> b;
    private final HashMap<String, q0> c;
    private final boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    
    static {
        h = new o0.b() {
            @Override
            public <T extends l0> T a(final Class<T> clazz) {
                return (T)new x(true);
            }
        };
    }
    
    x(final boolean d) {
        this.a = new HashMap<String, Fragment>();
        this.b = new HashMap<String, x>();
        this.c = new HashMap<String, q0>();
        this.e = false;
        this.f = false;
        this.g = false;
        this.d = d;
    }
    
    private void l(final String s) {
        final x x = this.b.get(s);
        if (x != null) {
            x.onCleared();
            this.b.remove(s);
        }
        final q0 q0 = this.c.get(s);
        if (q0 != null) {
            q0.a();
            this.c.remove(s);
        }
    }
    
    static x o(final q0 q0) {
        return new o0(q0, x.h).a(x.class);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && x.class == o.getClass()) {
            final x x = (x)o;
            if (!this.a.equals(x.a) || !this.b.equals(x.b) || !this.c.equals(x.c)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    void h(final Fragment fragment) {
        if (this.g) {
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
            return;
        }
        if (this.a.containsKey(fragment.mWho)) {
            return;
        }
        this.a.put(fragment.mWho, fragment);
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Updating retained Fragments: Added ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
    }
    
    @Override
    public int hashCode() {
        return (this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
    }
    
    void j(final Fragment fragment) {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Clearing non-config state for ");
            sb.append(fragment);
            Log.d("FragmentManager", sb.toString());
        }
        this.l(fragment.mWho);
    }
    
    void k(final String s) {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Clearing non-config state for saved state of Fragment ");
            sb.append(s);
            Log.d("FragmentManager", sb.toString());
        }
        this.l(s);
    }
    
    Fragment m(final String s) {
        return this.a.get(s);
    }
    
    x n(final Fragment fragment) {
        x x;
        if ((x = this.b.get(fragment.mWho)) == null) {
            x = new x(this.d);
            this.b.put(fragment.mWho, x);
        }
        return x;
    }
    
    @Override
    protected void onCleared() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("onCleared called for ");
            sb.append(this);
            Log.d("FragmentManager", sb.toString());
        }
        this.e = true;
    }
    
    Collection<Fragment> p() {
        return new ArrayList<Fragment>(this.a.values());
    }
    
    q0 q(final Fragment fragment) {
        q0 q0;
        if ((q0 = this.c.get(fragment.mWho)) == null) {
            q0 = new q0();
            this.c.put(fragment.mWho, q0);
        }
        return q0;
    }
    
    boolean r() {
        return this.e;
    }
    
    void s(final Fragment fragment) {
        if (this.g) {
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
            return;
        }
        if (this.a.remove(fragment.mWho) != null && FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Updating retained Fragments: Removed ");
            sb.append(fragment);
            Log.v("FragmentManager", sb.toString());
        }
    }
    
    void t(final boolean g) {
        this.g = g;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        final Iterator<Fragment> iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        final Iterator<String> iterator2 = this.b.keySet().iterator();
        while (iterator2.hasNext()) {
            sb.append(iterator2.next());
            if (iterator2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        final Iterator<String> iterator3 = this.c.keySet().iterator();
        while (iterator3.hasNext()) {
            sb.append(iterator3.next());
            if (iterator3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
    
    boolean u(final Fragment fragment) {
        if (!this.a.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.d) {
            return this.e;
        }
        return this.f ^ true;
    }
}
