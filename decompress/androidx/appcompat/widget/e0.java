// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.widget.AbsListView;
import android.view.View$OnTouchListener;
import androidx.core.widget.m;
import android.widget.ListView;
import android.widget.PopupWindow$OnDismissListener;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.AbsListView$OnScrollListener;
import android.widget.AdapterView;
import android.view.ViewParent;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import d.j;
import android.util.AttributeSet;
import d.a;
import android.util.Log;
import android.os.Build$VERSION;
import android.widget.ListAdapter;
import android.content.Context;
import android.widget.PopupWindow;
import android.graphics.Rect;
import android.os.Handler;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView$OnItemClickListener;
import android.graphics.drawable.Drawable;
import android.database.DataSetObserver;
import android.view.View;
import java.lang.reflect.Method;
import androidx.appcompat.view.menu.p;

public class e0 implements p
{
    private static Method R;
    private static Method S;
    private View A;
    private int B;
    private DataSetObserver C;
    private View D;
    private Drawable E;
    private AdapterView$OnItemClickListener F;
    private AdapterView$OnItemSelectedListener G;
    final i H;
    private final h I;
    private final g J;
    private final e K;
    private Runnable L;
    final Handler M;
    private final Rect N;
    private Rect O;
    private boolean P;
    PopupWindow Q;
    private Context a;
    private ListAdapter b;
    b0 c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean p;
    private int w;
    private boolean x;
    private boolean y;
    int z;
    
    static {
        if (Build$VERSION.SDK_INT <= 28) {
            try {
                e0.R = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            }
            catch (final NoSuchMethodException ex) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                e0.S = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            }
            catch (final NoSuchMethodException ex2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }
    
    public e0(final Context context) {
        this(context, null, d.a.F);
    }
    
    public e0(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public e0(final Context a, final AttributeSet set, final int n, final int n2) {
        this.d = -2;
        this.e = -2;
        this.h = 1002;
        this.w = 0;
        this.x = false;
        this.y = false;
        this.z = Integer.MAX_VALUE;
        this.B = 0;
        this.H = new i();
        this.I = new h();
        this.J = new g();
        this.K = new e();
        this.N = new Rect();
        this.a = a;
        this.M = new Handler(a.getMainLooper());
        final TypedArray obtainStyledAttributes = a.obtainStyledAttributes(set, d.j.l1, n, n2);
        this.f = obtainStyledAttributes.getDimensionPixelOffset(d.j.m1, 0);
        final int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(d.j.n1, 0);
        this.g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.i = true;
        }
        obtainStyledAttributes.recycle();
        (this.Q = new o(a, set, n, n2)).setInputMethodMode(1);
    }
    
    private void B() {
        final View a = this.A;
        if (a != null) {
            final ViewParent parent = a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(this.A);
            }
        }
    }
    
    private void M(final boolean b) {
        if (Build$VERSION.SDK_INT <= 28) {
            final Method r = e0.R;
            if (r != null) {
                try {
                    r.invoke(this.Q, b);
                }
                catch (final Exception ex) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        }
        else {
            e0.d.b(this.Q, b);
        }
    }
    
    private int p() {
        final b0 c = this.c;
        boolean b = true;
        int n2;
        if (c == null) {
            final Context a = this.a;
            this.L = new Runnable(this) {
                final e0 a;
                
                @Override
                public void run() {
                    final View s = this.a.s();
                    if (s != null && s.getWindowToken() != null) {
                        this.a.show();
                    }
                }
            };
            final b0 r = this.r(a, this.P ^ true);
            this.c = r;
            final Drawable e = this.E;
            if (e != null) {
                r.setSelector(e);
            }
            this.c.setAdapter(this.b);
            this.c.setOnItemClickListener(this.F);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new AdapterView$OnItemSelectedListener(this) {
                final e0 a;
                
                public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                    if (n != -1) {
                        final b0 c = this.a.c;
                        if (c != null) {
                            c.setListSelectionHidden(false);
                        }
                    }
                }
                
                public void onNothingSelected(final AdapterView<?> adapterView) {
                }
            });
            this.c.setOnScrollListener((AbsListView$OnScrollListener)this.J);
            final AdapterView$OnItemSelectedListener g = this.G;
            if (g != null) {
                this.c.setOnItemSelectedListener(g);
            }
            final b0 c2 = this.c;
            final View a2 = this.A;
            Object contentView;
            if (a2 != null) {
                contentView = new LinearLayout(a);
                ((LinearLayout)contentView).setOrientation(1);
                final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, 0, 1.0f);
                final int b2 = this.B;
                if (b2 != 0) {
                    if (b2 != 1) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Invalid hint position ");
                        sb.append(this.B);
                        Log.e("ListPopupWindow", sb.toString());
                    }
                    else {
                        ((LinearLayout)contentView).addView((View)c2, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                        ((LinearLayout)contentView).addView(a2);
                    }
                }
                else {
                    ((LinearLayout)contentView).addView(a2);
                    ((LinearLayout)contentView).addView((View)c2, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                }
                int e2 = this.e;
                int n;
                if (e2 >= 0) {
                    n = Integer.MIN_VALUE;
                }
                else {
                    e2 = 0;
                    n = 0;
                }
                a2.measure(View$MeasureSpec.makeMeasureSpec(e2, n), 0);
                final LinearLayout$LayoutParams linearLayout$LayoutParams2 = (LinearLayout$LayoutParams)a2.getLayoutParams();
                n2 = a2.getMeasuredHeight() + linearLayout$LayoutParams2.topMargin + linearLayout$LayoutParams2.bottomMargin;
            }
            else {
                n2 = 0;
                contentView = c2;
            }
            this.Q.setContentView((View)contentView);
        }
        else {
            final ViewGroup viewGroup = (ViewGroup)this.Q.getContentView();
            final View a3 = this.A;
            if (a3 != null) {
                final LinearLayout$LayoutParams linearLayout$LayoutParams3 = (LinearLayout$LayoutParams)a3.getLayoutParams();
                n2 = a3.getMeasuredHeight() + linearLayout$LayoutParams3.topMargin + linearLayout$LayoutParams3.bottomMargin;
            }
            else {
                n2 = 0;
            }
        }
        final Drawable background = this.Q.getBackground();
        int n5;
        if (background != null) {
            background.getPadding(this.N);
            final Rect n3 = this.N;
            final int top = n3.top;
            final int n4 = n5 = n3.bottom + top;
            if (!this.i) {
                this.g = -top;
                n5 = n4;
            }
        }
        else {
            this.N.setEmpty();
            n5 = 0;
        }
        if (this.Q.getInputMethodMode() != 2) {
            b = false;
        }
        final int t = this.t(this.s(), this.g, b);
        if (!this.x && this.d != -1) {
            final int e3 = this.e;
            int n6;
            if (e3 != -2) {
                if (e3 != -1) {
                    n6 = View$MeasureSpec.makeMeasureSpec(e3, 1073741824);
                }
                else {
                    final int widthPixels = this.a.getResources().getDisplayMetrics().widthPixels;
                    final Rect n7 = this.N;
                    n6 = View$MeasureSpec.makeMeasureSpec(widthPixels - (n7.left + n7.right), 1073741824);
                }
            }
            else {
                final int widthPixels2 = this.a.getResources().getDisplayMetrics().widthPixels;
                final Rect n8 = this.N;
                n6 = View$MeasureSpec.makeMeasureSpec(widthPixels2 - (n8.left + n8.right), Integer.MIN_VALUE);
            }
            final int d = this.c.d(n6, 0, -1, t - n2, -1);
            int n9 = n2;
            if (d > 0) {
                n9 = n2 + (n5 + (this.c.getPaddingTop() + this.c.getPaddingBottom()));
            }
            return d + n9;
        }
        return t + n5;
    }
    
    private int t(final View view, final int n, final boolean b) {
        return e0.c.a(this.Q, view, n, b);
    }
    
    public boolean A() {
        return this.P;
    }
    
    public void C(final View d) {
        this.D = d;
    }
    
    public void D(final int animationStyle) {
        this.Q.setAnimationStyle(animationStyle);
    }
    
    public void E(final int n) {
        final Drawable background = this.Q.getBackground();
        if (background != null) {
            background.getPadding(this.N);
            final Rect n2 = this.N;
            this.e = n2.left + n2.right + n;
        }
        else {
            this.P(n);
        }
    }
    
    public void F(final int w) {
        this.w = w;
    }
    
    public void G(Rect o) {
        if (o != null) {
            o = new Rect(o);
        }
        else {
            o = null;
        }
        this.O = o;
    }
    
    public void H(final int inputMethodMode) {
        this.Q.setInputMethodMode(inputMethodMode);
    }
    
    public void I(final boolean b) {
        this.P = b;
        this.Q.setFocusable(b);
    }
    
    public void J(final PopupWindow$OnDismissListener onDismissListener) {
        this.Q.setOnDismissListener(onDismissListener);
    }
    
    public void K(final AdapterView$OnItemClickListener f) {
        this.F = f;
    }
    
    public void L(final boolean j) {
        this.p = true;
        this.j = j;
    }
    
    public void N(final int b) {
        this.B = b;
    }
    
    public void O(final int selection) {
        final b0 c = this.c;
        if (this.a() && c != null) {
            c.setListSelectionHidden(false);
            c.setSelection(selection);
            if (c.getChoiceMode() != 0) {
                c.setItemChecked(selection, true);
            }
        }
    }
    
    public void P(final int e) {
        this.e = e;
    }
    
    @Override
    public boolean a() {
        return this.Q.isShowing();
    }
    
    public void b(final Drawable backgroundDrawable) {
        this.Q.setBackgroundDrawable(backgroundDrawable);
    }
    
    public int c() {
        return this.f;
    }
    
    @Override
    public void dismiss() {
        this.Q.dismiss();
        this.B();
        this.Q.setContentView((View)null);
        this.c = null;
        this.M.removeCallbacks((Runnable)this.H);
    }
    
    public void e(final int f) {
        this.f = f;
    }
    
    public Drawable g() {
        return this.Q.getBackground();
    }
    
    public void i(final int g) {
        this.g = g;
        this.i = true;
    }
    
    public int l() {
        if (!this.i) {
            return 0;
        }
        return this.g;
    }
    
    public void m(final ListAdapter b) {
        final DataSetObserver c = this.C;
        if (c == null) {
            this.C = new f();
        }
        else {
            final ListAdapter b2 = this.b;
            if (b2 != null) {
                b2.unregisterDataSetObserver(c);
            }
        }
        if ((this.b = b) != null) {
            b.registerDataSetObserver(this.C);
        }
        final b0 c2 = this.c;
        if (c2 != null) {
            c2.setAdapter(this.b);
        }
    }
    
    @Override
    public ListView o() {
        return this.c;
    }
    
    public void q() {
        final b0 c = this.c;
        if (c != null) {
            c.setListSelectionHidden(true);
            c.requestLayout();
        }
    }
    
    b0 r(final Context context, final boolean b) {
        return new b0(context, b);
    }
    
    public View s() {
        return this.D;
    }
    
    @Override
    public void show() {
        int p = this.p();
        final boolean z = this.z();
        m.b(this.Q, this.h);
        final boolean showing = this.Q.isShowing();
        boolean outsideTouchable = true;
        if (showing) {
            if (!androidx.core.view.b0.S(this.s())) {
                return;
            }
            final int e = this.e;
            int width;
            if (e == -1) {
                width = -1;
            }
            else if ((width = e) == -2) {
                width = this.s().getWidth();
            }
            final int d = this.d;
            if (d == -1) {
                if (!z) {
                    p = -1;
                }
                if (z) {
                    final PopupWindow q = this.Q;
                    int width2;
                    if (this.e == -1) {
                        width2 = -1;
                    }
                    else {
                        width2 = 0;
                    }
                    q.setWidth(width2);
                    this.Q.setHeight(0);
                }
                else {
                    final PopupWindow q2 = this.Q;
                    int width3;
                    if (this.e == -1) {
                        width3 = -1;
                    }
                    else {
                        width3 = 0;
                    }
                    q2.setWidth(width3);
                    this.Q.setHeight(-1);
                }
            }
            else if (d != -2) {
                p = d;
            }
            final PopupWindow q3 = this.Q;
            if (this.y || this.x) {
                outsideTouchable = false;
            }
            q3.setOutsideTouchable(outsideTouchable);
            final PopupWindow q4 = this.Q;
            final View s = this.s();
            final int f = this.f;
            final int g = this.g;
            if (width < 0) {
                width = -1;
            }
            if (p < 0) {
                p = -1;
            }
            q4.update(s, f, g, width, p);
        }
        else {
            final int e2 = this.e;
            int width4;
            if (e2 == -1) {
                width4 = -1;
            }
            else if ((width4 = e2) == -2) {
                width4 = this.s().getWidth();
            }
            final int d2 = this.d;
            if (d2 == -1) {
                p = -1;
            }
            else if (d2 != -2) {
                p = d2;
            }
            this.Q.setWidth(width4);
            this.Q.setHeight(p);
            this.M(true);
            this.Q.setOutsideTouchable(!this.y && !this.x);
            this.Q.setTouchInterceptor((View$OnTouchListener)this.I);
            if (this.p) {
                m.a(this.Q, this.j);
            }
            if (Build$VERSION.SDK_INT <= 28) {
                final Method s2 = e0.S;
                if (s2 != null) {
                    try {
                        s2.invoke(this.Q, this.O);
                    }
                    catch (final Exception ex) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", (Throwable)ex);
                    }
                }
            }
            else {
                e0.d.a(this.Q, this.O);
            }
            m.c(this.Q, this.s(), this.f, this.g, this.w);
            this.c.setSelection(-1);
            if (!this.P || this.c.isInTouchMode()) {
                this.q();
            }
            if (!this.P) {
                this.M.post((Runnable)this.K);
            }
        }
    }
    
    public Object u() {
        if (!this.a()) {
            return null;
        }
        return this.c.getSelectedItem();
    }
    
    public long v() {
        if (!this.a()) {
            return Long.MIN_VALUE;
        }
        return this.c.getSelectedItemId();
    }
    
    public int w() {
        if (!this.a()) {
            return -1;
        }
        return this.c.getSelectedItemPosition();
    }
    
    public View x() {
        if (!this.a()) {
            return null;
        }
        return this.c.getSelectedView();
    }
    
    public int y() {
        return this.e;
    }
    
    public boolean z() {
        return this.Q.getInputMethodMode() == 2;
    }
    
    static class c
    {
        static int a(final PopupWindow popupWindow, final View view, final int n, final boolean b) {
            return popupWindow.getMaxAvailableHeight(view, n, b);
        }
    }
    
    static class d
    {
        static void a(final PopupWindow popupWindow, final Rect epicenterBounds) {
            popupWindow.setEpicenterBounds(epicenterBounds);
        }
        
        static void b(final PopupWindow popupWindow, final boolean isClippedToScreen) {
            popupWindow.setIsClippedToScreen(isClippedToScreen);
        }
    }
    
    private class e implements Runnable
    {
        final e0 a;
        
        e(final e0 a) {
            this.a = a;
        }
        
        @Override
        public void run() {
            this.a.q();
        }
    }
    
    private class f extends DataSetObserver
    {
        final e0 a;
        
        f(final e0 a) {
            this.a = a;
        }
        
        public void onChanged() {
            if (this.a.a()) {
                this.a.show();
            }
        }
        
        public void onInvalidated() {
            this.a.dismiss();
        }
    }
    
    private class g implements AbsListView$OnScrollListener
    {
        final e0 a;
        
        g(final e0 a) {
            this.a = a;
        }
        
        public void onScroll(final AbsListView absListView, final int n, final int n2, final int n3) {
        }
        
        public void onScrollStateChanged(final AbsListView absListView, final int n) {
            if (n == 1 && !this.a.z() && this.a.Q.getContentView() != null) {
                final e0 a = this.a;
                a.M.removeCallbacks((Runnable)a.H);
                this.a.H.run();
            }
        }
    }
    
    private class h implements View$OnTouchListener
    {
        final e0 a;
        
        h(final e0 a) {
            this.a = a;
        }
        
        public boolean onTouch(final View view, final MotionEvent motionEvent) {
            final int action = motionEvent.getAction();
            final int n = (int)motionEvent.getX();
            final int n2 = (int)motionEvent.getY();
            if (action == 0) {
                final PopupWindow q = this.a.Q;
                if (q != null && q.isShowing() && n >= 0 && n < this.a.Q.getWidth() && n2 >= 0 && n2 < this.a.Q.getHeight()) {
                    final e0 a = this.a;
                    a.M.postDelayed((Runnable)a.H, 250L);
                    return false;
                }
            }
            if (action == 1) {
                final e0 a2 = this.a;
                a2.M.removeCallbacks((Runnable)a2.H);
            }
            return false;
        }
    }
    
    private class i implements Runnable
    {
        final e0 a;
        
        i(final e0 a) {
            this.a = a;
        }
        
        @Override
        public void run() {
            final b0 c = this.a.c;
            if (c != null && androidx.core.view.b0.S((View)c) && this.a.c.getCount() > this.a.c.getChildCount()) {
                final int childCount = this.a.c.getChildCount();
                final e0 a = this.a;
                if (childCount <= a.z) {
                    a.Q.setInputMethodMode(2);
                    this.a.show();
                }
            }
        }
    }
}
