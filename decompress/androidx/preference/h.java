// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.text.TextUtils;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import androidx.core.view.b0;
import e.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.ArrayList;
import android.os.Looper;
import android.os.Handler;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class h extends Adapter<androidx.preference.l> implements b
{
    private final PreferenceGroup a;
    private List<Preference> b;
    private List<Preference> c;
    private final List<c> d;
    private final Handler e;
    private final Runnable f;
    
    public h(final PreferenceGroup a) {
        this.f = new Runnable() {
            final h a;
            
            @Override
            public void run() {
                this.a.t();
            }
        };
        this.a = a;
        this.e = new Handler(Looper.getMainLooper());
        a.G0((Preference.b)this);
        this.b = new ArrayList<Preference>();
        this.c = new ArrayList<Preference>();
        this.d = new ArrayList<c>();
        if (a instanceof PreferenceScreen) {
            ((RecyclerView.Adapter)this).setHasStableIds(((PreferenceScreen)a).j1());
        }
        else {
            ((RecyclerView.Adapter)this).setHasStableIds(true);
        }
        this.t();
    }
    
    private androidx.preference.b l(final PreferenceGroup preferenceGroup, final List<Preference> list) {
        final androidx.preference.b b = new androidx.preference.b(preferenceGroup.l(), list, preferenceGroup.p());
        b.I0((Preference.d)new d(this, preferenceGroup) {
            final PreferenceGroup a;
            final h b;
            
            @Override
            public boolean a(final Preference preference) {
                this.a.g1(Integer.MAX_VALUE);
                this.b.k(preference);
                final PreferenceGroup.b z0 = this.a.Z0();
                if (z0 != null) {
                    z0.a();
                }
                return true;
            }
        });
        return b;
    }
    
    private List<Preference> m(final PreferenceGroup preferenceGroup) {
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final int b1 = preferenceGroup.b1();
        int i = 0;
        int n = 0;
        while (i < b1) {
            final Preference a1 = preferenceGroup.a1(i);
            if (a1.Q()) {
                if (this.p(preferenceGroup) && n >= preferenceGroup.Y0()) {
                    list2.add(a1);
                }
                else {
                    list.add(a1);
                }
                if (!(a1 instanceof PreferenceGroup)) {
                    ++n;
                }
                else {
                    final PreferenceGroup preferenceGroup2 = (PreferenceGroup)a1;
                    if (preferenceGroup2.c1()) {
                        if (this.p(preferenceGroup) && this.p(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        final Iterator<Preference> iterator = this.m(preferenceGroup2).iterator();
                        int n2 = n;
                        while (true) {
                            n = n2;
                            if (!iterator.hasNext()) {
                                break;
                            }
                            final Preference preference = iterator.next();
                            if (this.p(preferenceGroup) && n2 >= preferenceGroup.Y0()) {
                                list2.add(preference);
                            }
                            else {
                                list.add(preference);
                            }
                            ++n2;
                        }
                    }
                }
            }
            ++i;
        }
        if (this.p(preferenceGroup) && n > preferenceGroup.Y0()) {
            list.add(this.l(preferenceGroup, list2));
        }
        return list;
    }
    
    private void n(final List<Preference> list, final PreferenceGroup preferenceGroup) {
        preferenceGroup.i1();
        for (int b1 = preferenceGroup.b1(), i = 0; i < b1; ++i) {
            final Preference a1 = preferenceGroup.a1(i);
            list.add(a1);
            final c c = new c(a1);
            if (!this.d.contains(c)) {
                this.d.add(c);
            }
            if (a1 instanceof PreferenceGroup) {
                final PreferenceGroup preferenceGroup2 = (PreferenceGroup)a1;
                if (preferenceGroup2.c1()) {
                    this.n(list, preferenceGroup2);
                }
            }
            a1.G0((Preference.b)this);
        }
    }
    
    private boolean p(final PreferenceGroup preferenceGroup) {
        return preferenceGroup.Y0() != Integer.MAX_VALUE;
    }
    
    @Override
    public void g(final Preference preference) {
        this.k(preference);
    }
    
    @Override
    public int getItemCount() {
        return this.c.size();
    }
    
    @Override
    public long getItemId(final int n) {
        if (!((RecyclerView.Adapter)this).hasStableIds()) {
            return -1L;
        }
        return this.o(n).p();
    }
    
    @Override
    public int getItemViewType(int n) {
        final c c = new c(this.o(n));
        n = this.d.indexOf(c);
        if (n != -1) {
            return n;
        }
        n = this.d.size();
        this.d.add(c);
        return n;
    }
    
    @Override
    public void h(final Preference preference) {
        final int index = this.c.indexOf(preference);
        if (index != -1) {
            ((RecyclerView.Adapter)this).notifyItemChanged(index, preference);
        }
    }
    
    @Override
    public void k(final Preference preference) {
        this.e.removeCallbacks(this.f);
        this.e.post(this.f);
    }
    
    public Preference o(final int n) {
        if (n >= 0 && n < this.getItemCount()) {
            return this.c.get(n);
        }
        return null;
    }
    
    @Override
    public /* bridge */ void onBindViewHolder(final c0 c0, final int n) {
        this.r((androidx.preference.l)c0, n);
    }
    
    @Override
    public /* bridge */ c0 onCreateViewHolder(final ViewGroup viewGroup, final int n) {
        return this.s(viewGroup, n);
    }
    
    public void r(final androidx.preference.l l, final int n) {
        final Preference o = this.o(n);
        l.d();
        o.Y(l);
    }
    
    public androidx.preference.l s(final ViewGroup viewGroup, int b) {
        final c c = this.d.get(b);
        final LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        final TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet)null, androidx.preference.s.a);
        Drawable drawable;
        if ((drawable = obtainStyledAttributes.getDrawable(androidx.preference.s.b)) == null) {
            drawable = e.a.b(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        final View inflate = from.inflate(c.a, viewGroup, false);
        if (inflate.getBackground() == null) {
            androidx.core.view.b0.t0(inflate, drawable);
        }
        final ViewGroup viewGroup2 = (ViewGroup)inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            b = c.b;
            if (b != 0) {
                from.inflate(b, viewGroup2);
            }
            else {
                viewGroup2.setVisibility(8);
            }
        }
        return new androidx.preference.l(inflate);
    }
    
    void t() {
        final Iterator<Preference> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            iterator.next().G0(null);
        }
        this.n(this.b = new ArrayList<Preference>(this.b.size()), this.a);
        this.c = this.m(this.a);
        final androidx.preference.j c = this.a.C();
        if (c != null) {
            c.i();
        }
        ((RecyclerView.Adapter)this).notifyDataSetChanged();
        final Iterator<Preference> iterator2 = this.b.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().d();
        }
    }
    
    private static class c
    {
        int a;
        int b;
        String c;
        
        c(final Preference preference) {
            this.c = preference.getClass().getName();
            this.a = preference.s();
            this.b = preference.J();
        }
        
        @Override
        public boolean equals(final Object o) {
            final boolean b = o instanceof c;
            final boolean b2 = false;
            if (!b) {
                return false;
            }
            final c c = (c)o;
            boolean b3 = b2;
            if (this.a == c.a) {
                b3 = b2;
                if (this.b == c.b) {
                    b3 = b2;
                    if (TextUtils.equals((CharSequence)this.c, (CharSequence)c.c)) {
                        b3 = true;
                    }
                }
            }
            return b3;
        }
        
        @Override
        public int hashCode() {
            return ((527 + this.a) * 31 + this.b) * 31 + this.c.hashCode();
        }
    }
}
