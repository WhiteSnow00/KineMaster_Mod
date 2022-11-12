// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.KeyEvent;
import android.os.Parcelable;
import android.widget.TextView;
import android.widget.FrameLayout;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.graphics.Rect;
import androidx.core.view.b0;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.HeaderViewListAdapter;
import android.widget.AdapterView$OnItemClickListener;
import android.util.AttributeSet;
import androidx.appcompat.widget.g0;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MenuItem;
import java.util.Iterator;
import java.util.ArrayList;
import androidx.appcompat.widget.f0;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import java.util.List;
import android.os.Handler;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.view.View;
import android.widget.PopupWindow$OnDismissListener;
import android.view.View$OnKeyListener;

final class d extends k implements View$OnKeyListener, PopupWindow$OnDismissListener
{
    private static final int M;
    View A;
    private int B;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private boolean G;
    private boolean H;
    private a I;
    ViewTreeObserver J;
    private PopupWindow$OnDismissListener K;
    boolean L;
    private final Context b;
    private final int c;
    private final int d;
    private final int e;
    private final boolean f;
    final Handler g;
    private final List<g> h;
    final List<d> i;
    final ViewTreeObserver$OnGlobalLayoutListener j;
    private final View$OnAttachStateChangeListener p;
    private final f0 w;
    private int x;
    private int y;
    private View z;
    
    static {
        M = d.g.e;
    }
    
    public d(final Context b, final View z, final int d, final int e, final boolean f) {
        this.h = new ArrayList<g>();
        this.i = new ArrayList<d>();
        this.j = (ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener() {
            final d a;
            
            public void onGlobalLayout() {
                if (this.a.a() && this.a.i.size() > 0 && !((d)this.a.i.get(0)).a.A()) {
                    final View a = this.a.A;
                    if (a != null && a.isShown()) {
                        final Iterator<d> iterator = this.a.i.iterator();
                        while (iterator.hasNext()) {
                            ((d)iterator.next()).a.show();
                        }
                    }
                    else {
                        this.a.dismiss();
                    }
                }
            }
        };
        this.p = (View$OnAttachStateChangeListener)new View$OnAttachStateChangeListener() {
            final d a;
            
            public void onViewAttachedToWindow(final View view) {
            }
            
            public void onViewDetachedFromWindow(final View view) {
                final ViewTreeObserver j = this.a.J;
                if (j != null) {
                    if (!j.isAlive()) {
                        this.a.J = view.getViewTreeObserver();
                    }
                    final d a = this.a;
                    a.J.removeGlobalOnLayoutListener(a.j);
                }
                view.removeOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
            }
        };
        this.w = new f0() {
            final d a;
            
            @Override
            public void d(final g g, final MenuItem menuItem) {
                final Handler g2 = this.a.g;
                d d = null;
                g2.removeCallbacksAndMessages((Object)null);
                final int size = this.a.i.size();
                int i = 0;
                while (true) {
                    while (i < size) {
                        if (g == ((d)this.a.i.get(i)).b) {
                            if (i == -1) {
                                return;
                            }
                            if (++i < this.a.i.size()) {
                                d = (d)this.a.i.get(i);
                            }
                            this.a.g.postAtTime((Runnable)new Runnable(this, d, menuItem, g) {
                                final d a;
                                final MenuItem b;
                                final g c;
                                final d$c d;
                                
                                @Override
                                public void run() {
                                    final d a = this.a;
                                    if (a != null) {
                                        this.d.a.L = true;
                                        a.b.e(false);
                                        this.d.a.L = false;
                                    }
                                    if (this.b.isEnabled() && this.b.hasSubMenu()) {
                                        this.c.N(this.b, 4);
                                    }
                                }
                            }, (Object)g, SystemClock.uptimeMillis() + 200L);
                            return;
                        }
                        else {
                            ++i;
                        }
                    }
                    i = -1;
                    continue;
                }
            }
            
            @Override
            public void n(final g g, final MenuItem menuItem) {
                this.a.g.removeCallbacksAndMessages((Object)g);
            }
        };
        this.x = 0;
        this.y = 0;
        this.b = b;
        this.z = z;
        this.d = d;
        this.e = e;
        this.f = f;
        this.G = false;
        this.B = this.E();
        final Resources resources = b.getResources();
        this.c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.d.d));
        this.g = new Handler();
    }
    
    private g0 A() {
        final g0 g0 = new g0(this.b, null, this.d, this.e);
        g0.S(this.w);
        g0.K((AdapterView$OnItemClickListener)this);
        g0.J((PopupWindow$OnDismissListener)this);
        g0.C(this.z);
        g0.F(this.y);
        g0.I(true);
        g0.H(2);
        return g0;
    }
    
    private int B(final g g) {
        for (int size = this.i.size(), i = 0; i < size; ++i) {
            if (g == this.i.get(i).b) {
                return i;
            }
        }
        return -1;
    }
    
    private MenuItem C(final g g, final g g2) {
        for (int size = g.size(), i = 0; i < size; ++i) {
            final MenuItem item = g.getItem(i);
            if (item.hasSubMenu() && g2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }
    
    private View D(final d d, final g g) {
        final MenuItem c = this.C(d.b, g);
        if (c == null) {
            return null;
        }
        final ListView a = d.a();
        final ListAdapter adapter = a.getAdapter();
        final boolean b = adapter instanceof HeaderViewListAdapter;
        int i = 0;
        int headersCount;
        f f;
        if (b) {
            final HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter)adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            f = (f)headerViewListAdapter.getWrappedAdapter();
        }
        else {
            f = (f)adapter;
            headersCount = 0;
        }
        while (true) {
            while (i < f.getCount()) {
                if (c == f.c(i)) {
                    if (i == -1) {
                        return null;
                    }
                    final int n = i + headersCount - a.getFirstVisiblePosition();
                    if (n >= 0 && n < a.getChildCount()) {
                        return a.getChildAt(n);
                    }
                    return null;
                }
                else {
                    ++i;
                }
            }
            i = -1;
            continue;
        }
    }
    
    private int E() {
        final int b = b0.B(this.z);
        int n = 1;
        if (b == 1) {
            n = 0;
        }
        return n;
    }
    
    private int F(final int n) {
        final List<d> i = this.i;
        final ListView a = i.get(i.size() - 1).a();
        final int[] array = new int[2];
        a.getLocationOnScreen(array);
        final Rect rect = new Rect();
        this.A.getWindowVisibleDisplayFrame(rect);
        if (this.B == 1) {
            if (array[0] + a.getWidth() + n > rect.right) {
                return 0;
            }
            return 1;
        }
        else {
            if (array[0] - n < 0) {
                return 1;
            }
            return 0;
        }
    }
    
    private void G(final g g) {
        final LayoutInflater from = LayoutInflater.from(this.b);
        final f f = new f(g, from, this.f, androidx.appcompat.view.menu.d.M);
        if (!this.a() && this.G) {
            f.d(true);
        }
        else if (this.a()) {
            f.d(k.y(g));
        }
        int n = k.p((ListAdapter)f, null, this.b, this.c);
        final g0 a = this.A();
        a.m((ListAdapter)f);
        a.E(n);
        a.F(this.y);
        d d;
        View d2;
        if (this.i.size() > 0) {
            final List<d> i = this.i;
            d = i.get(i.size() - 1);
            d2 = this.D(d, g);
        }
        else {
            d = null;
            d2 = null;
        }
        if (d2 != null) {
            a.T(false);
            a.Q(null);
            final int f2 = this.F(n);
            final boolean b = f2 == 1;
            this.B = f2;
            a.C(d2);
            Label_0263: {
                Label_0259: {
                    if ((this.y & 0x5) == 0x5) {
                        if (!b) {
                            n = d2.getWidth();
                            break Label_0259;
                        }
                    }
                    else {
                        if (!b) {
                            break Label_0259;
                        }
                        n = d2.getWidth();
                    }
                    n += 0;
                    break Label_0263;
                }
                n = 0 - n;
            }
            a.e(n);
            a.L(true);
            a.i(0);
        }
        else {
            if (this.C) {
                a.e(this.E);
            }
            if (this.D) {
                a.i(this.F);
            }
            a.G(this.n());
        }
        this.i.add(new d(a, g, this.B));
        a.show();
        final ListView o = a.o();
        o.setOnKeyListener((View$OnKeyListener)this);
        if (d == null && this.H && g.z() != null) {
            final FrameLayout frameLayout = (FrameLayout)from.inflate(d.g.l, (ViewGroup)o, false);
            final TextView textView = (TextView)frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(g.z());
            o.addHeaderView((View)frameLayout, (Object)null, false);
            a.show();
        }
    }
    
    public boolean a() {
        final int size = this.i.size();
        boolean b = false;
        if (size > 0) {
            b = b;
            if (this.i.get(0).a.a()) {
                b = true;
            }
        }
        return b;
    }
    
    public void b(final g g, final boolean b) {
        final int b2 = this.B(g);
        if (b2 < 0) {
            return;
        }
        final int n = b2 + 1;
        if (n < this.i.size()) {
            this.i.get(n).b.e(false);
        }
        final d d = this.i.remove(b2);
        d.b.Q(this);
        if (this.L) {
            d.a.R(null);
            d.a.D(0);
        }
        d.a.dismiss();
        final int size = this.i.size();
        if (size > 0) {
            this.B = this.i.get(size - 1).c;
        }
        else {
            this.B = this.E();
        }
        if (size == 0) {
            this.dismiss();
            final a i = this.I;
            if (i != null) {
                i.b(g, true);
            }
            final ViewTreeObserver j = this.J;
            if (j != null) {
                if (j.isAlive()) {
                    this.J.removeGlobalOnLayoutListener(this.j);
                }
                this.J = null;
            }
            this.A.removeOnAttachStateChangeListener(this.p);
            this.K.onDismiss();
        }
        else if (b) {
            this.i.get(0).b.e(false);
        }
    }
    
    public void d(final a i) {
        this.I = i;
    }
    
    public void dismiss() {
        int i = this.i.size();
        if (i > 0) {
            final d[] array = this.i.toArray(new d[i]);
            --i;
            while (i >= 0) {
                final d d = array[i];
                if (d.a.a()) {
                    d.a.dismiss();
                }
                --i;
            }
        }
    }
    
    public void e(final Parcelable parcelable) {
    }
    
    public boolean f(final r r) {
        for (final d d : this.i) {
            if (r == d.b) {
                d.a().requestFocus();
                return true;
            }
        }
        if (r.hasVisibleItems()) {
            this.l(r);
            final a i = this.I;
            if (i != null) {
                i.c(r);
            }
            return true;
        }
        return false;
    }
    
    public Parcelable g() {
        return null;
    }
    
    public void h(final boolean b) {
        final Iterator<d> iterator = this.i.iterator();
        while (iterator.hasNext()) {
            k.z(iterator.next().a().getAdapter()).notifyDataSetChanged();
        }
    }
    
    public boolean i() {
        return false;
    }
    
    @Override
    public void l(final g g) {
        g.c(this, this.b);
        if (this.a()) {
            this.G(g);
        }
        else {
            this.h.add(g);
        }
    }
    
    @Override
    protected boolean m() {
        return false;
    }
    
    public ListView o() {
        ListView a;
        if (this.i.isEmpty()) {
            a = null;
        }
        else {
            final List<d> i = this.i;
            a = ((d)i.get(i.size() - 1)).a();
        }
        return a;
    }
    
    public void onDismiss() {
        while (true) {
            for (int size = this.i.size(), i = 0; i < size; ++i) {
                final d d = this.i.get(i);
                if (!d.a.a()) {
                    if (d != null) {
                        d.b.e(false);
                    }
                    return;
                }
            }
            final d d = null;
            continue;
        }
    }
    
    public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && n == 82) {
            this.dismiss();
            return true;
        }
        return false;
    }
    
    @Override
    public void q(final View z) {
        if (this.z != z) {
            this.z = z;
            this.y = androidx.core.view.f.b(this.x, b0.B(z));
        }
    }
    
    @Override
    public void s(final boolean g) {
        this.G = g;
    }
    
    public void show() {
        if (this.a()) {
            return;
        }
        final Iterator<g> iterator = this.h.iterator();
        while (iterator.hasNext()) {
            this.G(iterator.next());
        }
        this.h.clear();
        final View z = this.z;
        if ((this.A = z) != null) {
            final boolean b = this.J == null;
            final ViewTreeObserver viewTreeObserver = z.getViewTreeObserver();
            this.J = viewTreeObserver;
            if (b) {
                viewTreeObserver.addOnGlobalLayoutListener(this.j);
            }
            this.A.addOnAttachStateChangeListener(this.p);
        }
    }
    
    @Override
    public void t(final int x) {
        if (this.x != x) {
            this.x = x;
            this.y = androidx.core.view.f.b(x, b0.B(this.z));
        }
    }
    
    @Override
    public void u(final int e) {
        this.C = true;
        this.E = e;
    }
    
    @Override
    public void v(final PopupWindow$OnDismissListener k) {
        this.K = k;
    }
    
    @Override
    public void w(final boolean h) {
        this.H = h;
    }
    
    @Override
    public void x(final int f) {
        this.D = true;
        this.F = f;
    }
    
    private static class d
    {
        public final g0 a;
        public final g b;
        public final int c;
        
        public d(final g0 a, final g b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public ListView a() {
            return this.a.o();
        }
    }
}
