// 
// Decompiled by Procyon v0.6.0
// 

package p2;

import android.util.Log;
import java.util.Iterator;
import java.util.Collections;
import android.content.Context;
import com.bumptech.glide.c;
import android.app.Activity;
import java.util.HashSet;
import com.bumptech.glide.i;
import java.util.Set;
import android.app.Fragment;

@Deprecated
public class o extends Fragment
{
    private final p2.a a;
    private final q b;
    private final Set<o> c;
    private i d;
    private o e;
    private Fragment f;
    
    public o() {
        this(new p2.a());
    }
    
    o(final p2.a a) {
        this.b = new a();
        this.c = new HashSet<o>();
        this.a = a;
    }
    
    private void a(final o o) {
        this.c.add(o);
    }
    
    private Fragment d() {
        Fragment fragment = this.getParentFragment();
        if (fragment == null) {
            fragment = this.f;
        }
        return fragment;
    }
    
    private boolean g(Fragment parentFragment) {
        final Fragment parentFragment2 = this.getParentFragment();
        while (true) {
            final Fragment parentFragment3 = parentFragment.getParentFragment();
            if (parentFragment3 == null) {
                return false;
            }
            if (parentFragment3.equals((Object)parentFragment2)) {
                return true;
            }
            parentFragment = parentFragment.getParentFragment();
        }
    }
    
    private void h(final Activity activity) {
        this.l();
        final o j = com.bumptech.glide.c.c((Context)activity).k().j(activity);
        this.e = j;
        if (!this.equals((Object)j)) {
            this.e.a(this);
        }
    }
    
    private void i(final o o) {
        this.c.remove(o);
    }
    
    private void l() {
        final o e = this.e;
        if (e != null) {
            e.i(this);
            this.e = null;
        }
    }
    
    Set<o> b() {
        if (this.equals((Object)this.e)) {
            return Collections.unmodifiableSet((Set<? extends o>)this.c);
        }
        if (this.e != null) {
            final HashSet set = new HashSet();
            for (final o o : this.e.b()) {
                if (this.g(o.getParentFragment())) {
                    set.add(o);
                }
            }
            return (Set<o>)Collections.unmodifiableSet((Set<?>)set);
        }
        return Collections.emptySet();
    }
    
    p2.a c() {
        return this.a;
    }
    
    public i e() {
        return this.d;
    }
    
    public q f() {
        return this.b;
    }
    
    void j(final Fragment f) {
        this.f = f;
        if (f != null && f.getActivity() != null) {
            this.h(f.getActivity());
        }
    }
    
    public void k(final i d) {
        this.d = d;
    }
    
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        try {
            this.h(activity);
        }
        catch (final IllegalStateException ex) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", (Throwable)ex);
            }
        }
    }
    
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        this.l();
    }
    
    public void onDetach() {
        super.onDetach();
        this.l();
    }
    
    public void onStart() {
        super.onStart();
        this.a.d();
    }
    
    public void onStop() {
        super.onStop();
        this.a.e();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        sb.append(this.d());
        sb.append("}");
        return sb.toString();
    }
    
    private class a implements q
    {
        final o a;
        
        a(final o a) {
            this.a = a;
        }
        
        @Override
        public Set<i> a() {
            final Set<o> b = this.a.b();
            final HashSet set = new HashSet(b.size());
            for (final o o : b) {
                if (o.e() != null) {
                    set.add((Object)o.e());
                }
            }
            return (Set<i>)set;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(this.a);
            sb.append("}");
            return sb.toString();
        }
    }
}
