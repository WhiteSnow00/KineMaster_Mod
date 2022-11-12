// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.animation.LayoutTransition;
import java.util.Iterator;
import android.graphics.Canvas;
import androidx.core.view.b0;
import androidx.core.view.n0;
import android.view.WindowInsets;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.os.Bundle;
import android.content.res.TypedArray;
import f0.c;
import kotlin.jvm.internal.i;
import android.util.AttributeSet;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import android.content.Context;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.View;
import java.util.List;
import kotlin.Metadata;
import android.widget.FrameLayout;

@Metadata(bv = {}, d1 = { "\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0011\b\u0016\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;B%\b\u0017\u0012\u0006\u00109\u001a\u000208\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010>\u001a\u00020\u001d¢\u0006\u0004\b:\u0010?B!\b\u0010\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\b:\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0017J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0017J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0016H\u0001J\"\u0010!\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001dH\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\u0019\u0010,\u001a\u00028\u0000\"\n\b\u0000\u0010+*\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010/R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00105\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006C" }, d2 = { "Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "v", "Lka/r;", "a", "Landroid/animation/LayoutTransition;", "transition", "setLayoutTransition", "Landroid/view/View$OnApplyWindowInsetsListener;", "listener", "setOnApplyWindowInsetsListener", "Landroid/view/WindowInsets;", "insets", "onApplyWindowInsets", "dispatchApplyWindowInsets", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "child", "", "drawingTime", "", "drawChild", "view", "startViewTransition", "endViewTransition", "drawDisappearingViewsFirst", "setDrawDisappearingViewsLast", "", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "removeViewAt", "removeViewInLayout", "removeView", "start", "count", "removeViews", "removeViewsInLayout", "removeAllViewsInLayout", "Landroidx/fragment/app/Fragment;", "F", "getFragment", "()Landroidx/fragment/app/Fragment;", "", "Ljava/util/List;", "disappearingFragmentChildren", "b", "transitioningFragmentViews", "c", "Landroid/view/View$OnApplyWindowInsetsListener;", "applyWindowInsetsListener", "d", "Z", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/fragment/app/FragmentManager;", "fm", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroidx/fragment/app/FragmentManager;)V", "fragment_release" }, k = 1, mv = { 1, 6, 0 })
public final class FragmentContainerView extends FrameLayout
{
    private final List<View> a;
    private final List<View> b;
    private View$OnApplyWindowInsetsListener c;
    private boolean d;
    
    public FragmentContainerView(final Context context) {
        o.g((Object)context, "context");
        super(context);
        this.a = new ArrayList<View>();
        this.b = new ArrayList<View>();
        this.d = true;
    }
    
    public FragmentContainerView(final Context context, final AttributeSet set) {
        o.g((Object)context, "context");
        this(context, set, 0, 4, null);
    }
    
    public FragmentContainerView(final Context context, final AttributeSet set, final int n) {
        o.g((Object)context, "context");
        super(context, set, n);
        this.a = new ArrayList<View>();
        this.b = new ArrayList<View>();
        this.d = true;
        if (set != null) {
            final String classAttribute = set.getClassAttribute();
            final int[] e = f0.c.e;
            o.f((Object)e, "FragmentContainerView");
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, e, 0, 0);
            String string;
            String s;
            if (classAttribute == null) {
                string = obtainStyledAttributes.getString(f0.c.f);
                s = "android:name";
            }
            else {
                s = "class";
                string = classAttribute;
            }
            obtainStyledAttributes.recycle();
            if (string != null) {
                if (!this.isInEditMode()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("FragmentContainerView must be within a FragmentActivity to use ");
                    sb.append(s);
                    sb.append("=\"");
                    sb.append(string);
                    sb.append('\"');
                    throw new UnsupportedOperationException(sb.toString());
                }
            }
        }
    }
    
    public FragmentContainerView(final Context context, final AttributeSet set, int n, final int n2, final i i) {
        if ((n2 & 0x4) != 0x0) {
            n = 0;
        }
        this(context, set, n);
    }
    
    public FragmentContainerView(final Context context, final AttributeSet set, final FragmentManager fragmentManager) {
        o.g((Object)context, "context");
        o.g((Object)set, "attrs");
        o.g((Object)fragmentManager, "fm");
        super(context, set);
        this.a = new ArrayList<View>();
        this.b = new ArrayList<View>();
        this.d = true;
        final String classAttribute = set.getClassAttribute();
        final int[] e = f0.c.e;
        o.f((Object)e, "FragmentContainerView");
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, e, 0, 0);
        String string = classAttribute;
        if (classAttribute == null) {
            string = obtainStyledAttributes.getString(f0.c.f);
        }
        final String string2 = obtainStyledAttributes.getString(f0.c.g);
        obtainStyledAttributes.recycle();
        final int id = this.getId();
        final Fragment j0 = fragmentManager.j0(id);
        if (string != null && j0 == null) {
            if (id == -1) {
                String string3;
                if (string2 != null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(" with tag ");
                    sb.append(string2);
                    string3 = sb.toString();
                }
                else {
                    string3 = "";
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("FragmentContainerView must have an android:id to add Fragment ");
                sb2.append(string);
                sb2.append(string3);
                throw new IllegalStateException(sb2.toString());
            }
            final Fragment a = fragmentManager.x0().a(context.getClassLoader(), string);
            o.f((Object)a, "fm.fragmentFactory.insta\u2026ontext.classLoader, name)");
            a.onInflate(context, set, null);
            fragmentManager.q().w(true).d((ViewGroup)this, a, string2).l();
        }
        fragmentManager.e1(this);
    }
    
    private final void a(final View view) {
        if (this.b.contains(view)) {
            this.a.add(view);
        }
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        o.g((Object)view, "child");
        if (FragmentManager.H0(view) != null) {
            super.addView(view, n, viewGroup$LayoutParams);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
        sb.append(view);
        sb.append(" is not associated with a Fragment.");
        throw new IllegalStateException(sb.toString().toString());
    }
    
    public WindowInsets dispatchApplyWindowInsets(final WindowInsets windowInsets) {
        o.g((Object)windowInsets, "insets");
        final n0 v = n0.v(windowInsets);
        o.f((Object)v, "toWindowInsetsCompat(insets)");
        final View$OnApplyWindowInsetsListener c = this.c;
        n0 n0;
        if (c != null) {
            final a a = FragmentContainerView.a.a;
            o.d((Object)c);
            n0 = androidx.core.view.n0.v(a.a(c, (View)this, windowInsets));
        }
        else {
            n0 = b0.b0((View)this, v);
        }
        o.f((Object)n0, "if (applyWindowInsetsLis\u2026, insetsCompat)\n        }");
        if (!n0.o()) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                b0.g(this.getChildAt(i), n0);
            }
        }
        return windowInsets;
    }
    
    protected void dispatchDraw(final Canvas canvas) {
        o.g((Object)canvas, "canvas");
        if (this.d) {
            final Iterator<Object> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                super.drawChild(canvas, (View)iterator.next(), this.getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        o.g((Object)canvas, "canvas");
        o.g((Object)view, "child");
        return (!this.d || !(this.a.isEmpty() ^ true) || !this.a.contains(view)) && super.drawChild(canvas, view, n);
    }
    
    public void endViewTransition(final View view) {
        o.g((Object)view, "view");
        this.b.remove(view);
        if (this.a.remove(view)) {
            this.d = true;
        }
        super.endViewTransition(view);
    }
    
    public final <F extends Fragment> F getFragment() {
        return (F)FragmentManager.m0((View)this).j0(this.getId());
    }
    
    public WindowInsets onApplyWindowInsets(final WindowInsets windowInsets) {
        o.g((Object)windowInsets, "insets");
        return windowInsets;
    }
    
    public void removeAllViewsInLayout() {
        for (int n = this.getChildCount() - 1; -1 < n; --n) {
            final View child = this.getChildAt(n);
            o.f((Object)child, "view");
            this.a(child);
        }
        super.removeAllViewsInLayout();
    }
    
    public void removeView(final View view) {
        o.g((Object)view, "view");
        this.a(view);
        super.removeView(view);
    }
    
    public void removeViewAt(final int n) {
        final View child = this.getChildAt(n);
        o.f((Object)child, "view");
        this.a(child);
        super.removeViewAt(n);
    }
    
    public void removeViewInLayout(final View view) {
        o.g((Object)view, "view");
        this.a(view);
        super.removeViewInLayout(view);
    }
    
    public void removeViews(final int n, final int n2) {
        for (int i = n; i < n + n2; ++i) {
            final View child = this.getChildAt(i);
            o.f((Object)child, "view");
            this.a(child);
        }
        super.removeViews(n, n2);
    }
    
    public void removeViewsInLayout(final int n, final int n2) {
        for (int i = n; i < n + n2; ++i) {
            final View child = this.getChildAt(i);
            o.f((Object)child, "view");
            this.a(child);
        }
        super.removeViewsInLayout(n, n2);
    }
    
    public final void setDrawDisappearingViewsLast(final boolean d) {
        this.d = d;
    }
    
    public void setLayoutTransition(final LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }
    
    public void setOnApplyWindowInsetsListener(final View$OnApplyWindowInsetsListener c) {
        o.g((Object)c, "listener");
        this.c = c;
    }
    
    public void startViewTransition(final View view) {
        o.g((Object)view, "view");
        if (view.getParent() == this) {
            this.b.add(view);
        }
        super.startViewTransition(view);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c1\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u000b" }, d2 = { "Landroidx/fragment/app/FragmentContainerView$a;", "", "Landroid/view/View$OnApplyWindowInsetsListener;", "onApplyWindowInsetsListener", "Landroid/view/View;", "v", "Landroid/view/WindowInsets;", "insets", "a", "<init>", "()V", "fragment_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        public static final a a;
        
        static {
            a = new a();
        }
        
        private a() {
        }
        
        public final WindowInsets a(final View$OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener, final View view, final WindowInsets windowInsets) {
            o.g((Object)view$OnApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            o.g((Object)view, "v");
            o.g((Object)windowInsets, "insets");
            final WindowInsets onApplyWindowInsets = view$OnApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            o.f((Object)onApplyWindowInsets, "onApplyWindowInsetsListe\u2026lyWindowInsets(v, insets)");
            return onApplyWindowInsets;
        }
    }
}
