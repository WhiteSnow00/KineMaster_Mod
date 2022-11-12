// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.View$OnTouchListener;
import android.util.AttributeSet;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.l;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.appcompat.view.menu.ActionMenuItemView;
import android.content.res.Resources;
import android.view.View$MeasureSpec;
import android.view.ViewParent;
import java.util.ArrayList;
import android.view.ViewGroup$LayoutParams;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.r;
import android.os.Parcelable;
import androidx.appcompat.view.a;
import android.content.res.Configuration;
import androidx.appcompat.view.menu.n;
import android.view.ViewGroup;
import android.view.View;
import android.view.MenuItem;
import d.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import androidx.appcompat.view.menu.b;

class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements androidx.core.view.b.a
{
    private int A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private final SparseBooleanArray I;
    e J;
    a K;
    c L;
    private b M;
    final f N;
    int O;
    d p;
    private Drawable w;
    private boolean x;
    private boolean y;
    private boolean z;
    
    public ActionMenuPresenter(final Context context) {
        super(context, d.g.c, d.g.b);
        this.I = new SparseBooleanArray();
        this.N = new f();
    }
    
    private View B(final MenuItem menuItem) {
        final ViewGroup viewGroup = (ViewGroup)super.i;
        if (viewGroup == null) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = viewGroup.getChildAt(i);
            if (child instanceof n.a && ((n.a)child).getItemData() == menuItem) {
                return child;
            }
        }
        return null;
    }
    
    static androidx.appcompat.view.menu.g t(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.c;
    }
    
    static androidx.appcompat.view.menu.g u(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.c;
    }
    
    static n v(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.i;
    }
    
    static androidx.appcompat.view.menu.g w(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.c;
    }
    
    static androidx.appcompat.view.menu.g x(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.c;
    }
    
    static androidx.appcompat.view.menu.g y(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.c;
    }
    
    static n z(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.i;
    }
    
    public boolean A() {
        return this.D() | this.E();
    }
    
    public Drawable C() {
        final d p = this.p;
        if (p != null) {
            return p.getDrawable();
        }
        if (this.x) {
            return this.w;
        }
        return null;
    }
    
    public boolean D() {
        final c l = this.L;
        if (l != null) {
            final n i = super.i;
            if (i != null) {
                ((View)i).removeCallbacks((Runnable)l);
                this.L = null;
                return true;
            }
        }
        final e j = this.J;
        if (j != null) {
            j.b();
            return true;
        }
        return false;
    }
    
    public boolean E() {
        final a k = this.K;
        if (k != null) {
            k.b();
            return true;
        }
        return false;
    }
    
    public boolean F() {
        return this.L != null || this.G();
    }
    
    public boolean G() {
        final e j = this.J;
        return j != null && j.d();
    }
    
    public void H(final Configuration configuration) {
        if (!this.D) {
            this.C = androidx.appcompat.view.a.b(super.b).d();
        }
        final androidx.appcompat.view.menu.g c = super.c;
        if (c != null) {
            c.M(true);
        }
    }
    
    public void I(final boolean g) {
        this.G = g;
    }
    
    public void J(final ActionMenuView i) {
        ((ActionMenuView)(super.i = i)).a(super.c);
    }
    
    public void K(final Drawable drawable) {
        final d p = this.p;
        if (p != null) {
            p.setImageDrawable(drawable);
        }
        else {
            this.x = true;
            this.w = drawable;
        }
    }
    
    public void L(final boolean y) {
        this.y = y;
        this.z = true;
    }
    
    public boolean M() {
        if (this.y && !this.G()) {
            final androidx.appcompat.view.menu.g c = super.c;
            if (c != null && super.i != null && this.L == null && !c.B().isEmpty()) {
                final c l = new c(new e(super.b, super.c, (View)this.p, true));
                this.L = l;
                ((View)super.i).post((Runnable)l);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void b(final androidx.appcompat.view.menu.g g, final boolean b) {
        this.A();
        super.b(g, b);
    }
    
    @Override
    public void e(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            return;
        }
        final int a = ((SavedState)parcelable).a;
        if (a > 0) {
            final MenuItem item = super.c.findItem(a);
            if (item != null) {
                this.f((r)item.getSubMenu());
            }
        }
    }
    
    @Override
    public boolean f(final r r) {
        final boolean hasVisibleItems = r.hasVisibleItems();
        final boolean b = false;
        if (!hasVisibleItems) {
            return false;
        }
        r r2;
        for (r2 = r; r2.i0() != super.c; r2 = (r)r2.i0()) {}
        final View b2 = this.B(r2.getItem());
        if (b2 == null) {
            return false;
        }
        this.O = r.getItem().getItemId();
        final int size = r.size();
        int n = 0;
        boolean b3;
        while (true) {
            b3 = b;
            if (n >= size) {
                break;
            }
            final MenuItem item = r.getItem(n);
            if (item.isVisible() && item.getIcon() != null) {
                b3 = true;
                break;
            }
            ++n;
        }
        (this.K = new a(super.b, r, b2)).g(b3);
        this.K.k();
        super.f(r);
        return true;
    }
    
    @Override
    public Parcelable g() {
        final SavedState savedState = new SavedState();
        savedState.a = this.O;
        return (Parcelable)savedState;
    }
    
    @Override
    public void h(final boolean b) {
        super.h(b);
        ((View)super.i).requestLayout();
        final androidx.appcompat.view.menu.g c = super.c;
        final boolean b2 = false;
        if (c != null) {
            final ArrayList<i> u = c.u();
            for (int size = u.size(), i = 0; i < size; ++i) {
                final androidx.core.view.b a = u.get(i).a();
                if (a != null) {
                    a.i((androidx.core.view.b.a)this);
                }
            }
        }
        final androidx.appcompat.view.menu.g c2 = super.c;
        ArrayList<i> b3;
        if (c2 != null) {
            b3 = c2.B();
        }
        else {
            b3 = null;
        }
        int n = b2 ? 1 : 0;
        if (this.y) {
            n = (b2 ? 1 : 0);
            if (b3 != null) {
                final int size2 = b3.size();
                if (size2 == 1) {
                    n = ((b3.get(0).isActionViewExpanded() ^ true) ? 1 : 0);
                }
                else {
                    n = (b2 ? 1 : 0);
                    if (size2 > 0) {
                        n = 1;
                    }
                }
            }
        }
        if (n != 0) {
            if (this.p == null) {
                this.p = new d(super.a);
            }
            final ViewGroup viewGroup = (ViewGroup)this.p.getParent();
            if (viewGroup != super.i) {
                if (viewGroup != null) {
                    viewGroup.removeView((View)this.p);
                }
                final ActionMenuView actionMenuView = (ActionMenuView)super.i;
                actionMenuView.addView((View)this.p, (ViewGroup$LayoutParams)actionMenuView.F());
            }
        }
        else {
            final d p = this.p;
            if (p != null) {
                final ViewParent parent = p.getParent();
                final n j = super.i;
                if (parent == j) {
                    ((ViewGroup)j).removeView((View)this.p);
                }
            }
        }
        ((ActionMenuView)super.i).setOverflowReserved(this.y);
    }
    
    @Override
    public boolean i() {
        final androidx.appcompat.view.menu.g c = super.c;
        final int n = 0;
        ArrayList<i> g;
        int size;
        if (c != null) {
            g = c.G();
            size = g.size();
        }
        else {
            g = null;
            size = 0;
        }
        final int c2 = this.C;
        final int b = this.B;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        final ViewGroup viewGroup = (ViewGroup)super.i;
        int i = 0;
        int n2 = 0;
        int n4;
        int n3 = n4 = n2;
        int n5 = c2;
        while (i < size) {
            final i j = g.get(i);
            if (j.o()) {
                ++n4;
            }
            else if (j.n()) {
                ++n3;
            }
            else {
                n2 = 1;
            }
            int n6 = n5;
            if (this.G) {
                n6 = n5;
                if (j.isActionViewExpanded()) {
                    n6 = 0;
                }
            }
            ++i;
            n5 = n6;
        }
        int n7 = n5;
        if (this.y && (n2 != 0 || n3 + n4 > (n7 = n5))) {
            n7 = n5 - 1;
        }
        int n8 = n7 - n4;
        final SparseBooleanArray k = this.I;
        k.clear();
        int n9;
        int n10;
        if (this.E) {
            final int h = this.H;
            n9 = b / h;
            n10 = h + b % h / n9;
        }
        else {
            n10 = 0;
            n9 = 0;
        }
        int l = 0;
        int n11 = 0;
        int n12 = b;
        final int n13 = size;
        int n14 = n;
        while (l < n13) {
            final i m = g.get(l);
            int n15;
            int n16;
            if (m.o()) {
                final View p = this.p(m, null, viewGroup);
                if (this.E) {
                    n9 -= ActionMenuView.L(p, n10, n9, measureSpec, n14);
                }
                else {
                    p.measure(measureSpec, measureSpec);
                }
                final int measuredWidth = p.getMeasuredWidth();
                n12 -= measuredWidth;
                n15 = n11;
                if (n11 == 0) {
                    n15 = measuredWidth;
                }
                final int groupId = m.getGroupId();
                if (groupId != 0) {
                    k.put(groupId, true);
                }
                m.u(true);
                n16 = n14;
            }
            else if (m.n()) {
                final int groupId2 = m.getGroupId();
                final boolean value = k.get(groupId2);
                boolean b4;
                boolean b3;
                final boolean b2 = b3 = (b4 = ((n8 > 0 || value) && n12 > 0 && (!this.E || n9 > 0)));
                int n17 = n12;
                int n18 = n9;
                int n19 = n11;
                if (b2) {
                    final View p2 = this.p(m, null, viewGroup);
                    if (this.E) {
                        final int l2 = ActionMenuView.L(p2, n10, n9, measureSpec, 0);
                        final int n20 = n9 -= l2;
                        if (l2 == 0) {
                            b4 = false;
                            n9 = n20;
                        }
                    }
                    else {
                        p2.measure(measureSpec, measureSpec);
                    }
                    final int measuredWidth2 = p2.getMeasuredWidth();
                    n17 = n12 - measuredWidth2;
                    if ((n19 = n11) == 0) {
                        n19 = measuredWidth2;
                    }
                    b3 = (b4 & (this.E ? (n17 >= 0) : (n17 + n19 > 0)));
                    n18 = n9;
                }
                int n21;
                if (b3 && groupId2 != 0) {
                    k.put(groupId2, true);
                    n21 = n8;
                }
                else {
                    n21 = n8;
                    if (value) {
                        k.put(groupId2, false);
                        int n22 = 0;
                        while (true) {
                            n21 = n8;
                            if (n22 >= l) {
                                break;
                            }
                            final i i2 = g.get(n22);
                            int n23 = n8;
                            if (i2.getGroupId() == groupId2) {
                                n23 = n8;
                                if (i2.l()) {
                                    n23 = n8 + 1;
                                }
                                i2.u(false);
                            }
                            ++n22;
                            n8 = n23;
                        }
                    }
                }
                int n24 = n21;
                if (b3) {
                    n24 = n21 - 1;
                }
                m.u(b3);
                n16 = 0;
                n8 = n24;
                n12 = n17;
                n9 = n18;
                n15 = n19;
            }
            else {
                m.u((boolean)(n14 != 0));
                n15 = n11;
                n16 = n14;
            }
            ++l;
            n14 = n16;
            n11 = n15;
        }
        return true;
    }
    
    @Override
    public void k(final Context context, final androidx.appcompat.view.menu.g g) {
        super.k(context, g);
        final Resources resources = context.getResources();
        final androidx.appcompat.view.a b = androidx.appcompat.view.a.b(context);
        if (!this.z) {
            this.y = b.h();
        }
        if (!this.F) {
            this.A = b.c();
        }
        if (!this.D) {
            this.C = b.d();
        }
        int a = this.A;
        if (this.y) {
            if (this.p == null) {
                final d p2 = new d(super.a);
                this.p = p2;
                if (this.x) {
                    p2.setImageDrawable(this.w);
                    this.w = null;
                    this.x = false;
                }
                final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
                this.p.measure(measureSpec, measureSpec);
            }
            a -= this.p.getMeasuredWidth();
        }
        else {
            this.p = null;
        }
        this.B = a;
        this.H = (int)(resources.getDisplayMetrics().density * 56.0f);
    }
    
    @Override
    public void l(final i i, final n.a a) {
        a.c(i, 0);
        final ActionMenuView itemInvoker = (ActionMenuView)super.i;
        final ActionMenuItemView actionMenuItemView = (ActionMenuItemView)a;
        actionMenuItemView.setItemInvoker(itemInvoker);
        if (this.M == null) {
            this.M = new b();
        }
        actionMenuItemView.setPopupCallback((ActionMenuItemView.b)this.M);
    }
    
    public boolean n(final ViewGroup viewGroup, final int n) {
        return viewGroup.getChildAt(n) != this.p && super.n(viewGroup, n);
    }
    
    @Override
    public View p(final i i, final View view, final ViewGroup viewGroup) {
        View view2 = i.getActionView();
        if (view2 == null || i.j()) {
            view2 = super.p(i, view, viewGroup);
        }
        int visibility;
        if (i.isActionViewExpanded()) {
            visibility = 8;
        }
        else {
            visibility = 0;
        }
        view2.setVisibility(visibility);
        final ActionMenuView actionMenuView = (ActionMenuView)viewGroup;
        final ViewGroup$LayoutParams layoutParams = view2.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            view2.setLayoutParams((ViewGroup$LayoutParams)actionMenuView.E(layoutParams));
        }
        return view2;
    }
    
    @Override
    public n q(final ViewGroup viewGroup) {
        final n i = super.i;
        final n q = super.q(viewGroup);
        if (i != q) {
            ((ActionMenuView)q).setPresenter(this);
        }
        return q;
    }
    
    @Override
    public boolean s(final int n, final i i) {
        return i.l();
    }
    
    private static class SavedState implements Parcelable
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        public int a;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel);
                }
                
                public SavedState[] b(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        SavedState() {
        }
        
        SavedState(final Parcel parcel) {
            this.a = parcel.readInt();
        }
        
        public int describeContents() {
            return 0;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeInt(this.a);
        }
    }
    
    private class a extends l
    {
        final ActionMenuPresenter m;
        
        public a(final ActionMenuPresenter m, final Context context, final r r, final View view) {
            this.m = m;
            super(context, r, view, false, d.a.l);
            if (!((i)r.getItem()).l()) {
                Object p4;
                if ((p4 = m.p) == null) {
                    p4 = ActionMenuPresenter.v(m);
                }
                this.f((View)p4);
            }
            this.j(m.N);
        }
        
        @Override
        protected void e() {
            final ActionMenuPresenter m = this.m;
            m.K = null;
            m.O = 0;
            super.e();
        }
    }
    
    private class b extends ActionMenuItemView.b
    {
        final ActionMenuPresenter a;
        
        b(final ActionMenuPresenter a) {
            this.a = a;
        }
        
        @Override
        public p a() {
            final ActionMenuPresenter.a k = this.a.K;
            k c;
            if (k != null) {
                c = k.c();
            }
            else {
                c = null;
            }
            return c;
        }
    }
    
    private class c implements Runnable
    {
        private e a;
        final ActionMenuPresenter b;
        
        public c(final ActionMenuPresenter b, final e a) {
            this.b = b;
            this.a = a;
        }
        
        @Override
        public void run() {
            if (ActionMenuPresenter.x(this.b) != null) {
                ActionMenuPresenter.y(this.b).d();
            }
            final View view = (View)ActionMenuPresenter.z(this.b);
            if (view != null && view.getWindowToken() != null && this.a.m()) {
                this.b.J = this.a;
            }
            this.b.L = null;
        }
    }
    
    private class d extends AppCompatImageView implements ActionMenuView.a
    {
        final ActionMenuPresenter d;
        
        public d(final ActionMenuPresenter d, final Context context) {
            this.d = d;
            super(context, null, d.a.k);
            this.setClickable(true);
            this.setFocusable(true);
            this.setVisibility(0);
            this.setEnabled(true);
            u0.a((View)this, this.getContentDescription());
            this.setOnTouchListener((View$OnTouchListener)new d0(this, this, d) {
                final ActionMenuPresenter j;
                final d p;
                
                @Override
                public p b() {
                    final ActionMenuPresenter.e j = this.p.d.J;
                    if (j == null) {
                        return null;
                    }
                    return j.c();
                }
                
                public boolean c() {
                    this.p.d.M();
                    return true;
                }
                
                public boolean d() {
                    final ActionMenuPresenter d = this.p.d;
                    if (d.L != null) {
                        return false;
                    }
                    d.D();
                    return true;
                }
            });
        }
        
        @Override
        public boolean a() {
            return false;
        }
        
        @Override
        public boolean b() {
            return false;
        }
        
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            this.playSoundEffect(0);
            this.d.M();
            return true;
        }
        
        protected boolean setFrame(int n, int paddingTop, int height, int paddingBottom) {
            final boolean setFrame = super.setFrame(n, paddingTop, height, paddingBottom);
            final Drawable drawable = this.getDrawable();
            final Drawable background = this.getBackground();
            if (drawable != null && background != null) {
                final int width = this.getWidth();
                height = this.getHeight();
                n = Math.max(width, height) / 2;
                final int paddingLeft = this.getPaddingLeft();
                final int paddingRight = this.getPaddingRight();
                paddingTop = this.getPaddingTop();
                paddingBottom = this.getPaddingBottom();
                final int n2 = (width + (paddingLeft - paddingRight)) / 2;
                paddingTop = (height + (paddingTop - paddingBottom)) / 2;
                androidx.core.graphics.drawable.a.f(background, n2 - n, paddingTop - n, n2 + n, paddingTop + n);
            }
            return setFrame;
        }
    }
    
    private class e extends l
    {
        final ActionMenuPresenter m;
        
        public e(final ActionMenuPresenter m, final Context context, final androidx.appcompat.view.menu.g g, final View view, final boolean b) {
            this.m = m;
            super(context, g, view, b, d.a.l);
            this.h(8388613);
            this.j(m.N);
        }
        
        @Override
        protected void e() {
            if (ActionMenuPresenter.t(this.m) != null) {
                ActionMenuPresenter.u(this.m).close();
            }
            this.m.J = null;
            super.e();
        }
    }
    
    private class f implements m.a
    {
        final ActionMenuPresenter a;
        
        f(final ActionMenuPresenter a) {
            this.a = a;
        }
        
        @Override
        public void b(final androidx.appcompat.view.menu.g g, final boolean b) {
            if (g instanceof r) {
                g.F().e(false);
            }
            final m.a o = this.a.o();
            if (o != null) {
                o.b(g, b);
            }
        }
        
        @Override
        public boolean c(final androidx.appcompat.view.menu.g g) {
            final androidx.appcompat.view.menu.g w = ActionMenuPresenter.w(this.a);
            boolean c = false;
            if (g == w) {
                return false;
            }
            this.a.O = ((r)g).getItem().getItemId();
            final m.a o = this.a.o();
            if (o != null) {
                c = o.c(g);
            }
            return c;
        }
    }
}
