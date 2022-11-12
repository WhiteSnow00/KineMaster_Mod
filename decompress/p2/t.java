// 
// Decompiled by Procyon v0.6.0
// 

package p2;

import android.util.Log;
import java.util.Iterator;
import java.util.Collections;
import com.bumptech.glide.c;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import java.util.HashSet;
import com.bumptech.glide.i;
import java.util.Set;
import androidx.fragment.app.Fragment;

public class t extends Fragment
{
    private final p2.a a;
    private final q b;
    private final Set<t> c;
    private t d;
    private i e;
    private Fragment f;
    
    public t() {
        this(new p2.a());
    }
    
    public t(final p2.a a) {
        this.b = new a();
        this.c = new HashSet<t>();
        this.a = a;
    }
    
    private void g4(final t t) {
        this.c.add(t);
    }
    
    private Fragment j4() {
        Fragment fragment = this.getParentFragment();
        if (fragment == null) {
            fragment = this.f;
        }
        return fragment;
    }
    
    private static FragmentManager m4(Fragment parentFragment) {
        while (parentFragment.getParentFragment() != null) {
            parentFragment = parentFragment.getParentFragment();
        }
        return parentFragment.getFragmentManager();
    }
    
    private boolean n4(Fragment parentFragment) {
        final Fragment j4 = this.j4();
        while (true) {
            final Fragment parentFragment2 = parentFragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(j4)) {
                return true;
            }
            parentFragment = parentFragment.getParentFragment();
        }
    }
    
    private void o4(final Context context, final FragmentManager fragmentManager) {
        this.s4();
        final t l = com.bumptech.glide.c.c(context).k().l(fragmentManager);
        this.d = l;
        if (!this.equals(l)) {
            this.d.g4(this);
        }
    }
    
    private void p4(final t t) {
        this.c.remove(t);
    }
    
    private void s4() {
        final t d = this.d;
        if (d != null) {
            d.p4(this);
            this.d = null;
        }
    }
    
    Set<t> h4() {
        final t d = this.d;
        if (d == null) {
            return Collections.emptySet();
        }
        if (this.equals(d)) {
            return Collections.unmodifiableSet((Set<? extends t>)this.c);
        }
        final HashSet set = new HashSet();
        for (final t t : this.d.h4()) {
            if (this.n4(t.j4())) {
                set.add(t);
            }
        }
        return (Set<t>)Collections.unmodifiableSet((Set<?>)set);
    }
    
    p2.a i4() {
        return this.a;
    }
    
    public i k4() {
        return this.e;
    }
    
    public q l4() {
        return this.b;
    }
    
    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        final FragmentManager m4 = m4(this);
        if (m4 == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
            return;
        }
        try {
            this.o4(this.getContext(), m4);
        }
        catch (final IllegalStateException ex) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", (Throwable)ex);
            }
        }
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        this.s4();
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        this.f = null;
        this.s4();
    }
    
    @Override
    public void onStart() {
        super.onStart();
        this.a.d();
    }
    
    @Override
    public void onStop() {
        super.onStop();
        this.a.e();
    }
    
    void q4(final Fragment f) {
        this.f = f;
        if (f != null) {
            if (f.getContext() != null) {
                final FragmentManager m4 = m4(f);
                if (m4 == null) {
                    return;
                }
                this.o4(f.getContext(), m4);
            }
        }
    }
    
    public void r4(final i e) {
        this.e = e;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        sb.append(this.j4());
        sb.append("}");
        return sb.toString();
    }
    
    private class a implements q
    {
        final t a;
        
        a(final t a) {
            this.a = a;
        }
        
        @Override
        public Set<i> a() {
            final Set<t> h4 = this.a.h4();
            final HashSet set = new HashSet(h4.size());
            for (final t t : h4) {
                if (t.k4() != null) {
                    set.add((Object)t.k4());
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
