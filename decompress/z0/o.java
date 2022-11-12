// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import java.util.Collection;
import java.util.Iterator;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import androidx.core.view.b0;
import java.util.ArrayList;
import android.view.ViewGroup;
import androidx.collection.a;
import java.lang.ref.WeakReference;

public class o
{
    private static m a;
    private static ThreadLocal<WeakReference<androidx.collection.a<ViewGroup, ArrayList<m>>>> b;
    static ArrayList<ViewGroup> c;
    
    static {
        o.a = new b();
        o.b = new ThreadLocal<WeakReference<androidx.collection.a<ViewGroup, ArrayList<m>>>>();
        o.c = new ArrayList<ViewGroup>();
    }
    
    public static void a(final ViewGroup viewGroup, m n) {
        if (!o.c.contains(viewGroup) && b0.T((View)viewGroup)) {
            o.c.add(viewGroup);
            m a;
            if ((a = n) == null) {
                a = o.a;
            }
            n = a.n();
            d(viewGroup, n);
            l.c(viewGroup, null);
            c(viewGroup, n);
        }
    }
    
    static androidx.collection.a<ViewGroup, ArrayList<m>> b() {
        final WeakReference weakReference = o.b.get();
        if (weakReference != null) {
            final androidx.collection.a a = (androidx.collection.a)weakReference.get();
            if (a != null) {
                return a;
            }
        }
        final androidx.collection.a<ViewGroup, ArrayList<m>> a2 = new androidx.collection.a<ViewGroup, ArrayList<m>>();
        o.b.set(new WeakReference<androidx.collection.a<ViewGroup, ArrayList<m>>>(a2));
        return a2;
    }
    
    private static void c(final ViewGroup viewGroup, final m m) {
        if (m != null && viewGroup != null) {
            final a a = new a(m, viewGroup);
            viewGroup.addOnAttachStateChangeListener((View$OnAttachStateChangeListener)a);
            viewGroup.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)a);
        }
    }
    
    private static void d(final ViewGroup viewGroup, final m m) {
        final ArrayList list = b().get(viewGroup);
        if (list != null && list.size() > 0) {
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((m)iterator.next()).R((View)viewGroup);
            }
        }
        if (m != null) {
            m.l(viewGroup, true);
        }
        final l b = l.b(viewGroup);
        if (b != null) {
            b.a();
        }
    }
    
    private static class a implements ViewTreeObserver$OnPreDrawListener, View$OnAttachStateChangeListener
    {
        m a;
        ViewGroup b;
        
        a(final m a, final ViewGroup b) {
            this.a = a;
            this.b = b;
        }
        
        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
            this.b.removeOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
        }
        
        public boolean onPreDraw() {
            this.a();
            if (!o.c.remove(this.b)) {
                return true;
            }
            final androidx.collection.a<ViewGroup, ArrayList<m>> b = o.b();
            final ArrayList list = b.get(this.b);
            ArrayList list2 = null;
            ArrayList list3;
            if (list == null) {
                list3 = new ArrayList();
                b.put(this.b, list3);
            }
            else {
                list3 = list;
                if (list.size() > 0) {
                    list2 = new ArrayList(list);
                    list3 = list;
                }
            }
            list3.add(this.a);
            this.a.b((m.f)new n(this, b) {
                final androidx.collection.a a;
                final a b;
                
                @Override
                public void c(final m m) {
                    ((ArrayList)this.a.get(this.b.b)).remove(m);
                    m.T((m.f)this);
                }
            });
            this.a.l(this.b, false);
            if (list2 != null) {
                final Iterator iterator = list2.iterator();
                while (iterator.hasNext()) {
                    ((m)iterator.next()).V((View)this.b);
                }
            }
            this.a.S(this.b);
            return true;
        }
        
        public void onViewAttachedToWindow(final View view) {
        }
        
        public void onViewDetachedFromWindow(final View view) {
            this.a();
            o.c.remove(this.b);
            final ArrayList list = o.b().get(this.b);
            if (list != null && list.size() > 0) {
                final Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    ((m)iterator.next()).V((View)this.b);
                }
            }
            this.a.m(true);
        }
    }
}
