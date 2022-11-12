// 
// Decompiled by Procyon v0.6.0
// 

package androidx.coordinatorlayout.widget;

import android.view.ViewParent;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import android.view.View$BaseSavedState;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import androidx.customview.view.AbsSavedState;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable$Callback;
import android.util.SparseArray;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.graphics.Region$Op;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewTreeObserver$OnPreDrawListener;
import java.util.Collection;
import android.os.SystemClock;
import android.view.MotionEvent;
import java.util.HashMap;
import android.text.TextUtils;
import java.util.Collections;
import android.util.Log;
import androidx.core.view.f;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.core.view.b0;
import android.os.Build$VERSION;
import u.b;
import u.c;
import java.util.ArrayList;
import androidx.core.util.g;
import android.util.AttributeSet;
import android.content.Context;
import androidx.core.view.n0;
import android.graphics.Paint;
import java.util.List;
import androidx.core.view.u;
import androidx.core.view.v;
import android.view.ViewGroup$OnHierarchyChangeListener;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;
import androidx.core.util.e;
import android.view.View;
import java.util.Comparator;
import java.lang.reflect.Constructor;
import java.util.Map;
import androidx.core.view.t;
import androidx.core.view.s;
import android.view.ViewGroup;

public class CoordinatorLayout extends ViewGroup implements s, t
{
    static final String F;
    static final Class<?>[] G;
    static final ThreadLocal<Map<String, Constructor<c>>> H;
    static final Comparator<View> I;
    private static final androidx.core.util.e<Rect> J;
    private boolean A;
    private Drawable B;
    ViewGroup$OnHierarchyChangeListener C;
    private v D;
    private final u E;
    private final List<View> a;
    private final a<View> b;
    private final List<View> c;
    private final List<View> d;
    private Paint e;
    private final int[] f;
    private final int[] g;
    private boolean h;
    private boolean i;
    private int[] j;
    private View p;
    private View w;
    private g x;
    private boolean y;
    private n0 z;
    
    static {
        final Package package1 = CoordinatorLayout.class.getPackage();
        String name;
        if (package1 != null) {
            name = package1.getName();
        }
        else {
            name = null;
        }
        F = name;
        I = new h();
        G = new Class[] { Context.class, AttributeSet.class };
        H = new ThreadLocal<Map<String, Constructor<c>>>();
        J = new androidx.core.util.g<Rect>(12);
    }
    
    public CoordinatorLayout(final Context context, final AttributeSet set) {
        this(context, set, u.a.a);
    }
    
    public CoordinatorLayout(final Context context, final AttributeSet set, int i) {
        super(context, set, i);
        this.a = new ArrayList<View>();
        this.b = new a<View>();
        this.c = new ArrayList<View>();
        this.d = new ArrayList<View>();
        this.f = new int[2];
        this.g = new int[2];
        this.E = new u(this);
        final int n = 0;
        TypedArray typedArray;
        if (i == 0) {
            typedArray = context.obtainStyledAttributes(set, u.c.b, 0, u.b.a);
        }
        else {
            typedArray = context.obtainStyledAttributes(set, u.c.b, i, 0);
        }
        if (Build$VERSION.SDK_INT >= 29) {
            if (i == 0) {
                this.saveAttributeDataForStyleable(context, u.c.b, set, typedArray, 0, u.b.a);
            }
            else {
                this.saveAttributeDataForStyleable(context, u.c.b, set, typedArray, i, 0);
            }
        }
        i = typedArray.getResourceId(u.c.c, 0);
        if (i != 0) {
            final Resources resources = context.getResources();
            this.j = resources.getIntArray(i);
            final float density = resources.getDisplayMetrics().density;
            int length;
            int[] j;
            for (length = this.j.length, i = n; i < length; ++i) {
                j = this.j;
                j[i] *= (int)density;
            }
        }
        this.B = typedArray.getDrawable(u.c.d);
        typedArray.recycle();
        this.c0();
        super.setOnHierarchyChangeListener((ViewGroup$OnHierarchyChangeListener)new e());
        if (b0.z((View)this) == 0) {
            b0.A0((View)this, 1);
        }
    }
    
    private void A(final View view, int n, final Rect rect, final Rect rect2, final f f, final int n2, final int n3) {
        final int b = f.b(W(f.c), n);
        n = f.b(X(f.d), n);
        final int n4 = b & 0x7;
        final int n5 = b & 0x70;
        final int n6 = n & 0x7;
        final int n7 = n & 0x70;
        if (n6 != 1) {
            if (n6 != 5) {
                n = rect.left;
            }
            else {
                n = rect.right;
            }
        }
        else {
            n = rect.left + rect.width() / 2;
        }
        int n8;
        if (n7 != 16) {
            if (n7 != 80) {
                n8 = rect.top;
            }
            else {
                n8 = rect.bottom;
            }
        }
        else {
            n8 = rect.top + rect.height() / 2;
        }
        int n9;
        if (n4 != 1) {
            n9 = n;
            if (n4 != 5) {
                n9 = n - n2;
            }
        }
        else {
            n9 = n - n2 / 2;
        }
        if (n5 != 16) {
            n = n8;
            if (n5 != 80) {
                n = n8 - n3;
            }
        }
        else {
            n = n8 - n3 / 2;
        }
        rect2.set(n9, n, n2 + n9, n3 + n);
    }
    
    private int B(final int n) {
        final int[] j = this.j;
        if (j == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(n);
            Log.e("CoordinatorLayout", sb.toString());
            return 0;
        }
        if (n >= 0 && n < j.length) {
            return j[n];
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Keyline index ");
        sb2.append(n);
        sb2.append(" out of range for ");
        sb2.append(this);
        Log.e("CoordinatorLayout", sb2.toString());
        return 0;
    }
    
    private void E(final List<View> list) {
        list.clear();
        final boolean childrenDrawingOrderEnabled = this.isChildrenDrawingOrderEnabled();
        final int childCount = this.getChildCount();
        for (int i = childCount - 1; i >= 0; --i) {
            int childDrawingOrder;
            if (childrenDrawingOrderEnabled) {
                childDrawingOrder = this.getChildDrawingOrder(childCount, i);
            }
            else {
                childDrawingOrder = i;
            }
            list.add(this.getChildAt(childDrawingOrder));
        }
        final Comparator<View> j = CoordinatorLayout.I;
        if (j != null) {
            Collections.sort((List<Object>)list, (Comparator<? super Object>)j);
        }
    }
    
    private boolean F(final View view) {
        return this.b.j(view);
    }
    
    private void H(final View view, final int n) {
        final f f = (f)view.getLayoutParams();
        final Rect e = e();
        e.set(this.getPaddingLeft() + f.leftMargin, this.getPaddingTop() + f.topMargin, this.getWidth() - this.getPaddingRight() - f.rightMargin, this.getHeight() - this.getPaddingBottom() - f.bottomMargin);
        if (this.z != null && b0.y((View)this) && !b0.y(view)) {
            e.left += this.z.j();
            e.top += this.z.l();
            e.right -= this.z.k();
            e.bottom -= this.z.i();
        }
        final Rect e2 = e();
        androidx.core.view.f.a(X(f.c), view.getMeasuredWidth(), view.getMeasuredHeight(), e, e2, n);
        view.layout(e2.left, e2.top, e2.right, e2.bottom);
        T(e);
        T(e2);
    }
    
    private void I(final View view, final View view2, final int n) {
        final Rect e = e();
        final Rect e2 = e();
        try {
            this.y(view2, e);
            this.z(view, n, e, e2);
            view.layout(e2.left, e2.top, e2.right, e2.bottom);
        }
        finally {
            T(e);
            T(e2);
        }
    }
    
    private void J(final View view, int max, int max2) {
        final f f = (f)view.getLayoutParams();
        final int b = androidx.core.view.f.b(Y(f.c), max2);
        final int n = b & 0x7;
        final int n2 = b & 0x70;
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        int n3 = max;
        if (max2 == 1) {
            n3 = width - max;
        }
        max = this.B(n3) - measuredWidth;
        max2 = 0;
        if (n != 1) {
            if (n == 5) {
                max += measuredWidth;
            }
        }
        else {
            max += measuredWidth / 2;
        }
        if (n2 != 16) {
            if (n2 == 80) {
                max2 = measuredHeight + 0;
            }
        }
        else {
            max2 = 0 + measuredHeight / 2;
        }
        max = Math.max(this.getPaddingLeft() + f.leftMargin, Math.min(max, width - this.getPaddingRight() - measuredWidth - f.rightMargin));
        max2 = Math.max(this.getPaddingTop() + f.topMargin, Math.min(max2, height - this.getPaddingBottom() - measuredHeight - f.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }
    
    private void K(final View view, final Rect rect, int left) {
        if (!b0.T(view)) {
            return;
        }
        if (view.getWidth() > 0) {
            if (view.getHeight() > 0) {
                final f f = (f)view.getLayoutParams();
                final c f2 = f.f();
                final Rect e = e();
                final Rect e2 = e();
                e2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                if (f2 != null && f2.b(this, view, e)) {
                    if (!e2.contains(e)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Rect should be within the child's bounds. Rect:");
                        sb.append(e.toShortString());
                        sb.append(" | Bounds:");
                        sb.append(e2.toShortString());
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                else {
                    e.set(e2);
                }
                T(e2);
                if (e.isEmpty()) {
                    T(e);
                    return;
                }
                final int b = androidx.core.view.f.b(f.h, left);
                final int n = 1;
                Label_0254: {
                    if ((b & 0x30) == 0x30) {
                        left = e.top - f.topMargin - f.j;
                        final int top = rect.top;
                        if (left < top) {
                            this.a0(view, top - left);
                            left = 1;
                            break Label_0254;
                        }
                    }
                    left = 0;
                }
                int n2 = left;
                if ((b & 0x50) == 0x50) {
                    final int n3 = this.getHeight() - e.bottom - f.bottomMargin + f.j;
                    final int bottom = rect.bottom;
                    n2 = left;
                    if (n3 < bottom) {
                        this.a0(view, n3 - bottom);
                        n2 = 1;
                    }
                }
                if (n2 == 0) {
                    this.a0(view, 0);
                }
                Label_0385: {
                    if ((b & 0x3) == 0x3) {
                        final int n4 = e.left - f.leftMargin - f.i;
                        left = rect.left;
                        if (n4 < left) {
                            this.Z(view, left - n4);
                            left = 1;
                            break Label_0385;
                        }
                    }
                    left = 0;
                }
                if ((b & 0x5) == 0x5) {
                    final int n5 = this.getWidth() - e.right - f.rightMargin + f.i;
                    final int right = rect.right;
                    if (n5 < right) {
                        this.Z(view, n5 - right);
                        left = n;
                    }
                }
                if (left == 0) {
                    this.Z(view, 0);
                }
                T(e);
            }
        }
    }
    
    static c P(final Context context, final AttributeSet set, final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        String s2;
        if (s.startsWith(".")) {
            final StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(s);
            s2 = sb.toString();
        }
        else if (s.indexOf(46) >= 0) {
            s2 = s;
        }
        else {
            final String f = CoordinatorLayout.F;
            s2 = s;
            if (!TextUtils.isEmpty((CharSequence)f)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(f);
                sb2.append('.');
                sb2.append(s);
                s2 = sb2.toString();
            }
        }
        try {
            final ThreadLocal<Map<String, Constructor<c>>> h = CoordinatorLayout.H;
            Map map;
            if ((map = h.get()) == null) {
                map = new HashMap();
                h.set(map);
            }
            Constructor<?> constructor;
            if ((constructor = (Constructor)map.get(s2)) == null) {
                constructor = Class.forName(s2, false, context.getClassLoader()).getConstructor(CoordinatorLayout.G);
                constructor.setAccessible(true);
                map.put(s2, constructor);
            }
            return (c)constructor.newInstance(context, set);
        }
        catch (final Exception ex) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Could not inflate Behavior subclass ");
            sb3.append(s2);
            throw new RuntimeException(sb3.toString(), ex);
        }
    }
    
    private boolean Q(final MotionEvent motionEvent, final int n) {
        final int actionMasked = motionEvent.getActionMasked();
        final List<View> c = this.c;
        this.E(c);
        final int size = c.size();
        MotionEvent motionEvent2 = null;
        int n2 = 0;
        int n4;
        int n3 = n4 = 0;
        boolean b;
        while (true) {
            b = (n3 != 0);
            if (n2 >= size) {
                break;
            }
            final View p2 = c.get(n2);
            final f f = (f)p2.getLayoutParams();
            final c f2 = f.f();
            MotionEvent obtain;
            boolean b2;
            int n5;
            if ((n3 || n4 != 0) && actionMasked != 0) {
                obtain = motionEvent2;
                b2 = (n3 != 0);
                n5 = n4;
                if (f2 != null) {
                    if ((obtain = motionEvent2) == null) {
                        final long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (n != 0) {
                        if (n != 1) {
                            b2 = (n3 != 0);
                            n5 = n4;
                        }
                        else {
                            f2.D(this, p2, obtain);
                            b2 = (n3 != 0);
                            n5 = n4;
                        }
                    }
                    else {
                        f2.k(this, p2, obtain);
                        b2 = (n3 != 0);
                        n5 = n4;
                    }
                }
            }
            else {
                boolean b3 = n3 != 0;
                if (n3 == 0) {
                    b3 = (n3 != 0);
                    if (f2 != null) {
                        if (n != 0) {
                            if (n == 1) {
                                n3 = (f2.D(this, p2, motionEvent) ? 1 : 0);
                            }
                        }
                        else {
                            n3 = (f2.k(this, p2, motionEvent) ? 1 : 0);
                        }
                        b3 = (n3 != 0);
                        if (n3 != 0) {
                            this.p = p2;
                            b3 = (n3 != 0);
                        }
                    }
                }
                final boolean c2 = f.c();
                final boolean i = f.i(this, p2);
                final boolean b4 = i && !c2;
                obtain = motionEvent2;
                b2 = b3;
                n5 = (b4 ? 1 : 0);
                if (i) {
                    obtain = motionEvent2;
                    b2 = b3;
                    if ((n5 = (b4 ? 1 : 0)) == 0) {
                        b = b3;
                        break;
                    }
                }
            }
            ++n2;
            motionEvent2 = obtain;
            n3 = (b2 ? 1 : 0);
            n4 = n5;
        }
        c.clear();
        return b;
    }
    
    private void R() {
        this.a.clear();
        this.b.c();
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final f d = this.D(child);
            d.d(this, child);
            this.b.b(child);
            for (int j = 0; j < childCount; ++j) {
                if (j != i) {
                    final View child2 = this.getChildAt(j);
                    if (d.b(this, child, child2)) {
                        if (!this.b.d(child2)) {
                            this.b.b(child2);
                        }
                        this.b.a(child2, child);
                    }
                }
            }
        }
        this.a.addAll(this.b.i());
        Collections.reverse(this.a);
    }
    
    private static void T(final Rect rect) {
        rect.setEmpty();
        CoordinatorLayout.J.b(rect);
    }
    
    private void V(final boolean b) {
        final int childCount = this.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final c f = ((f)child.getLayoutParams()).f();
            if (f != null) {
                final long uptimeMillis = SystemClock.uptimeMillis();
                final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (b) {
                    f.k(this, child, obtain);
                }
                else {
                    f.D(this, child, obtain);
                }
                obtain.recycle();
            }
        }
        for (int j = 0; j < childCount; ++j) {
            ((f)this.getChildAt(j).getLayoutParams()).m();
        }
        this.p = null;
        this.h = false;
    }
    
    private static int W(final int n) {
        int n2 = n;
        if (n == 0) {
            n2 = 17;
        }
        return n2;
    }
    
    private static int X(int n) {
        int n2 = n;
        if ((n & 0x7) == 0x0) {
            n2 = (n | 0x800003);
        }
        n = n2;
        if ((n2 & 0x70) == 0x0) {
            n = (n2 | 0x30);
        }
        return n;
    }
    
    private static int Y(final int n) {
        int n2 = n;
        if (n == 0) {
            n2 = 8388661;
        }
        return n2;
    }
    
    private void Z(final View view, final int i) {
        final f f = (f)view.getLayoutParams();
        final int j = f.i;
        if (j != i) {
            b0.Z(view, i - j);
            f.i = i;
        }
    }
    
    private void a0(final View view, final int j) {
        final f f = (f)view.getLayoutParams();
        final int i = f.j;
        if (i != j) {
            b0.a0(view, j - i);
            f.j = j;
        }
    }
    
    private void c0() {
        if (b0.y((View)this)) {
            if (this.D == null) {
                this.D = new v(this) {
                    final CoordinatorLayout a;
                    
                    @Override
                    public n0 a(final View view, final n0 n0) {
                        return this.a.b0(n0);
                    }
                };
            }
            b0.D0((View)this, this.D);
            this.setSystemUiVisibility(1280);
        }
        else {
            b0.D0((View)this, null);
        }
    }
    
    private static Rect e() {
        Rect rect;
        if ((rect = CoordinatorLayout.J.a()) == null) {
            rect = new Rect();
        }
        return rect;
    }
    
    private static int g(final int n, final int n2, final int n3) {
        if (n < n2) {
            return n2;
        }
        if (n > n3) {
            return n3;
        }
        return n;
    }
    
    private void h(final f f, final Rect rect, final int n, final int n2) {
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int max = Math.max(this.getPaddingLeft() + f.leftMargin, Math.min(rect.left, width - this.getPaddingRight() - n - f.rightMargin));
        final int max2 = Math.max(this.getPaddingTop() + f.topMargin, Math.min(rect.top, height - this.getPaddingBottom() - n2 - f.bottomMargin));
        rect.set(max, max2, n + max, n2 + max2);
    }
    
    private n0 l(n0 n0) {
        if (n0.o()) {
            return n0;
        }
        int n2 = 0;
        final int childCount = this.getChildCount();
        n0 n3;
        while (true) {
            n3 = n0;
            if (n2 >= childCount) {
                break;
            }
            final View child = this.getChildAt(n2);
            n0 f = n0;
            if (b0.y(child)) {
                final c f2 = ((f)child.getLayoutParams()).f();
                f = n0;
                if (f2 != null) {
                    n0 = (f = f2.f(this, child, n0));
                    if (n0.o()) {
                        n3 = n0;
                        break;
                    }
                }
            }
            ++n2;
            n0 = f;
        }
        return n3;
    }
    
    void C(final View view, final Rect rect) {
        rect.set(((f)view.getLayoutParams()).h());
    }
    
    f D(View o) {
        final f f = (f)((View)o).getLayoutParams();
        if (!f.b) {
            if (o instanceof b) {
                final c behavior = ((b)o).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                f.o(behavior);
                f.b = true;
            }
            else {
                Class<?> clazz = o.getClass();
                o = null;
                while (clazz != null) {
                    final d d = clazz.getAnnotation(d.class);
                    if ((o = d) != null) {
                        break;
                    }
                    clazz = clazz.getSuperclass();
                    o = d;
                }
                if (o != null) {
                    try {
                        f.o((c)((d)o).value().getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]));
                    }
                    catch (final Exception ex) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Default behavior class ");
                        sb.append(((d)o).value().getName());
                        sb.append(" could not be instantiated. Did you forget a default constructor?");
                        Log.e("CoordinatorLayout", sb.toString(), (Throwable)ex);
                    }
                }
                f.b = true;
            }
        }
        return f;
    }
    
    public boolean G(final View view, final int n, final int n2) {
        final Rect e = e();
        this.y(view, e);
        try {
            return e.contains(n, n2);
        }
        finally {
            T(e);
        }
    }
    
    void L(final View view, int n) {
        final f f = (f)view.getLayoutParams();
        if (f.k != null) {
            final Rect e = e();
            final Rect e2 = e();
            final Rect e3 = e();
            this.y(f.k, e);
            final int n2 = 0;
            this.v(view, false, e2);
            final int measuredWidth = view.getMeasuredWidth();
            final int measuredHeight = view.getMeasuredHeight();
            this.A(view, n, e, e3, f, measuredWidth, measuredHeight);
            Label_0111: {
                if (e3.left == e2.left) {
                    n = n2;
                    if (e3.top == e2.top) {
                        break Label_0111;
                    }
                }
                n = 1;
            }
            this.h(f, e3, measuredWidth, measuredHeight);
            final int n3 = e3.left - e2.left;
            final int n4 = e3.top - e2.top;
            if (n3 != 0) {
                b0.Z(view, n3);
            }
            if (n4 != 0) {
                b0.a0(view, n4);
            }
            if (n != 0) {
                final c f2 = f.f();
                if (f2 != null) {
                    f2.h(this, view, f.k);
                }
            }
            T(e);
            T(e2);
            T(e3);
        }
    }
    
    final void M(final int n) {
        final int b = b0.B((View)this);
        final int size = this.a.size();
        final Rect e = e();
        final Rect e2 = e();
        final Rect e3 = e();
        for (int i = 0; i < size; ++i) {
            final View view = this.a.get(i);
            final f f = (f)view.getLayoutParams();
            if (n != 0 || view.getVisibility() != 8) {
                for (int j = 0; j < i; ++j) {
                    if (f.l == this.a.get(j)) {
                        this.L(view, b);
                    }
                }
                this.v(view, true, e2);
                if (f.g != 0 && !e2.isEmpty()) {
                    final int b2 = androidx.core.view.f.b(f.g, b);
                    final int n2 = b2 & 0x70;
                    if (n2 != 48) {
                        if (n2 == 80) {
                            e.bottom = Math.max(e.bottom, this.getHeight() - e2.top);
                        }
                    }
                    else {
                        e.top = Math.max(e.top, e2.bottom);
                    }
                    final int n3 = b2 & 0x7;
                    if (n3 != 3) {
                        if (n3 == 5) {
                            e.right = Math.max(e.right, this.getWidth() - e2.left);
                        }
                    }
                    else {
                        e.left = Math.max(e.left, e2.right);
                    }
                }
                if (f.h != 0 && view.getVisibility() == 0) {
                    this.K(view, e, b);
                }
                if (n != 2) {
                    this.C(view, e3);
                    if (e3.equals((Object)e2)) {
                        continue;
                    }
                    this.S(view, e2);
                }
                for (int k = i + 1; k < size; ++k) {
                    final View view2 = this.a.get(k);
                    final f f2 = (f)view2.getLayoutParams();
                    final c f3 = f2.f();
                    if (f3 != null && f3.e(this, view2, view)) {
                        if (n == 0 && f2.g()) {
                            f2.k();
                        }
                        else {
                            boolean h;
                            if (n != 2) {
                                h = f3.h(this, view2, view);
                            }
                            else {
                                f3.i(this, view2, view);
                                h = true;
                            }
                            if (n == 1) {
                                f2.p(h);
                            }
                        }
                    }
                }
            }
        }
        T(e);
        T(e2);
        T(e3);
    }
    
    public void N(final View view, final int n) {
        final f f = (f)view.getLayoutParams();
        if (!f.a()) {
            final View k = f.k;
            if (k != null) {
                this.I(view, k, n);
            }
            else {
                final int e = f.e;
                if (e >= 0) {
                    this.J(view, e, n);
                }
                else {
                    this.H(view, n);
                }
            }
            return;
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }
    
    public void O(final View view, final int n, final int n2, final int n3, final int n4) {
        this.measureChildWithMargins(view, n, n2, n3, n4);
    }
    
    void S(final View view, final Rect rect) {
        ((f)view.getLayoutParams()).q(rect);
    }
    
    void U() {
        if (this.i && this.x != null) {
            this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this.x);
        }
        this.y = false;
    }
    
    final n0 b0(final n0 z) {
        n0 l = z;
        if (!androidx.core.util.c.a(this.z, z)) {
            this.z = z;
            final boolean b = true;
            final boolean a = z != null && z.l() > 0;
            this.A = a;
            this.setWillNotDraw(!a && this.getBackground() == null && b);
            l = this.l(z);
            this.requestLayout();
        }
        return l;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof f && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        final f f = (f)view.getLayoutParams();
        final c a = f.a;
        if (a != null) {
            final float d = a.d(this, view);
            if (d > 0.0f) {
                if (this.e == null) {
                    this.e = new Paint();
                }
                this.e.setColor(f.a.c(this, view));
                this.e.setAlpha(g(Math.round(d * 255.0f), 0, 255));
                final int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float)view.getLeft(), (float)view.getTop(), (float)view.getRight(), (float)view.getBottom(), Region$Op.DIFFERENCE);
                }
                canvas.drawRect((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.getWidth() - this.getPaddingRight()), (float)(this.getHeight() - this.getPaddingBottom()), this.e);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, n);
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final int[] drawableState = this.getDrawableState();
        final Drawable b = this.B;
        int n = 0;
        if (b != null) {
            n = n;
            if (b.isStateful()) {
                n = ((false | b.setState(drawableState)) ? 1 : 0);
            }
        }
        if (n != 0) {
            this.invalidate();
        }
    }
    
    void f() {
        if (this.i) {
            if (this.x == null) {
                this.x = new g();
            }
            this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this.x);
        }
        this.y = true;
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.s();
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.t(set);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)this.u(viewGroup$LayoutParams);
    }
    
    final List<View> getDependencySortedChildren() {
        this.R();
        return Collections.unmodifiableList((List<? extends View>)this.a);
    }
    
    public final n0 getLastWindowInsets() {
        return this.z;
    }
    
    public int getNestedScrollAxes() {
        return this.E.a();
    }
    
    public Drawable getStatusBarBackground() {
        return this.B;
    }
    
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), this.getPaddingTop() + this.getPaddingBottom());
    }
    
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), this.getPaddingLeft() + this.getPaddingRight());
    }
    
    public void i(final View view, final View w, final int n, final int n2) {
        this.E.c(view, w, n, n2);
        this.w = w;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final f f = (f)child.getLayoutParams();
            if (f.j(n2)) {
                final c f2 = f.f();
                if (f2 != null) {
                    f2.v(this, child, view, w, n, n2);
                }
            }
        }
    }
    
    public void j(final View view, final int n) {
        this.E.e(view, n);
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final f f = (f)child.getLayoutParams();
            if (f.j(n)) {
                final c f2 = f.f();
                if (f2 != null) {
                    f2.C(this, child, view, n);
                }
                f.l(n);
                f.k();
            }
        }
        this.w = null;
    }
    
    public void k(final View view, final int n, final int n2, final int[] array, final int n3) {
        final int childCount = this.getChildCount();
        boolean b = false;
        int i = 0;
        int n5;
        int n4 = n5 = i;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            int n6;
            int n7;
            if (child.getVisibility() == 8) {
                n6 = n5;
                n7 = n4;
            }
            else {
                final f f = (f)child.getLayoutParams();
                if (!f.j(n3)) {
                    n6 = n5;
                    n7 = n4;
                }
                else {
                    final c f2 = f.f();
                    n6 = n5;
                    n7 = n4;
                    if (f2 != null) {
                        final int[] f3 = this.f;
                        f3[1] = (f3[0] = 0);
                        f2.q(this, child, view, n, n2, f3, n3);
                        final int[] f4 = this.f;
                        int n8;
                        if (n > 0) {
                            n8 = Math.max(n5, f4[0]);
                        }
                        else {
                            n8 = Math.min(n5, f4[0]);
                        }
                        n6 = n8;
                        final int[] f5 = this.f;
                        if (n2 > 0) {
                            n7 = Math.max(n4, f5[1]);
                        }
                        else {
                            n7 = Math.min(n4, f5[1]);
                        }
                        b = true;
                    }
                }
            }
            ++i;
            n5 = n6;
            n4 = n7;
        }
        array[0] = n5;
        array[1] = n4;
        if (b) {
            this.M(1);
        }
    }
    
    public void m(final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int[] array) {
        final int childCount = this.getChildCount();
        boolean b = false;
        int i = 0;
        int n7;
        int n6 = n7 = i;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            int n8;
            int n9;
            if (child.getVisibility() == 8) {
                n8 = n7;
                n9 = n6;
            }
            else {
                final f f = (f)child.getLayoutParams();
                if (!f.j(n5)) {
                    n8 = n7;
                    n9 = n6;
                }
                else {
                    final c f2 = f.f();
                    n8 = n7;
                    n9 = n6;
                    if (f2 != null) {
                        final int[] f3 = this.f;
                        f3[1] = (f3[0] = 0);
                        f2.t(this, child, view, n, n2, n3, n4, n5, f3);
                        final int[] f4 = this.f;
                        int n10;
                        if (n3 > 0) {
                            n10 = Math.max(n7, f4[0]);
                        }
                        else {
                            n10 = Math.min(n7, f4[0]);
                        }
                        n8 = n10;
                        if (n4 > 0) {
                            n9 = Math.max(n6, this.f[1]);
                        }
                        else {
                            n9 = Math.min(n6, this.f[1]);
                        }
                        b = true;
                    }
                }
            }
            ++i;
            n7 = n8;
            n6 = n9;
        }
        array[0] += n7;
        array[1] += n6;
        if (b) {
            this.M(1);
        }
    }
    
    public void n(final View view, final int n, final int n2, final int n3, final int n4, final int n5) {
        this.m(view, n, n2, n3, n4, 0, this.g);
    }
    
    public boolean o(final View view, final View view2, final int n, final int n2) {
        final int childCount = this.getChildCount();
        int i = 0;
        boolean b = false;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final f f = (f)child.getLayoutParams();
                final c f2 = f.f();
                if (f2 != null) {
                    final boolean a = f2.A(this, child, view, view2, n, n2);
                    b |= a;
                    f.r(n2, a);
                }
                else {
                    f.r(n2, false);
                }
            }
            ++i;
        }
        return b;
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V(false);
        if (this.y) {
            if (this.x == null) {
                this.x = new g();
            }
            this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this.x);
        }
        if (this.z == null && b0.y((View)this)) {
            b0.m0((View)this);
        }
        this.i = true;
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.V(false);
        if (this.y && this.x != null) {
            this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this.x);
        }
        final View w = this.w;
        if (w != null) {
            this.onStopNestedScroll(w);
        }
        this.i = false;
    }
    
    public void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (this.A && this.B != null) {
            final n0 z = this.z;
            int l;
            if (z != null) {
                l = z.l();
            }
            else {
                l = 0;
            }
            if (l > 0) {
                this.B.setBounds(0, 0, this.getWidth(), l);
                this.B.draw(canvas);
            }
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.V(true);
        }
        final boolean q = this.Q(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            this.V(true);
        }
        return q;
    }
    
    protected void onLayout(final boolean b, int i, int size, int b2, final int n) {
        b2 = b0.B((View)this);
        View view;
        c f;
        for (size = this.a.size(), i = 0; i < size; ++i) {
            view = this.a.get(i);
            if (view.getVisibility() != 8) {
                f = ((f)view.getLayoutParams()).f();
                if (f == null || !f.l(this, view, b2)) {
                    this.N(view, b2);
                }
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.R();
        this.r();
        final int paddingLeft = this.getPaddingLeft();
        final int paddingTop = this.getPaddingTop();
        final int paddingRight = this.getPaddingRight();
        final int paddingBottom = this.getPaddingBottom();
        final int b = b0.B((View)this);
        final boolean b2 = b == 1;
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        final int size2 = View$MeasureSpec.getSize(n2);
        int n3 = this.getSuggestedMinimumWidth();
        int n4 = this.getSuggestedMinimumHeight();
        final boolean b3 = this.z != null && b0.y((View)this);
        final int size3 = this.a.size();
        int combineMeasuredStates = 0;
        int n5 = 0;
        int n6 = paddingLeft;
        while (true) {
            final int n7 = n6;
            if (n5 >= size3) {
                break;
            }
            final View view = this.a.get(n5);
            if (view.getVisibility() != 8) {
                final f f = (f)view.getLayoutParams();
                final int e = f.e;
                int n9 = 0;
                Label_0293: {
                    if (e >= 0 && mode != 0) {
                        final int b4 = this.B(e);
                        final int n8 = androidx.core.view.f.b(Y(f.c), b) & 0x7;
                        if ((n8 == 3 && !b2) || (n8 == 5 && b2)) {
                            n9 = Math.max(0, size - paddingRight - b4);
                            break Label_0293;
                        }
                        if ((n8 == 5 && !b2) || (n8 == 3 && b2)) {
                            n9 = Math.max(0, b4 - n7);
                            break Label_0293;
                        }
                    }
                    n9 = 0;
                }
                int measureSpec;
                int measureSpec2;
                if (b3 && !b0.y(view)) {
                    final int j = this.z.j();
                    final int k = this.z.k();
                    final int l = this.z.l();
                    final int i = this.z.i();
                    measureSpec = View$MeasureSpec.makeMeasureSpec(size - (j + k), mode);
                    measureSpec2 = View$MeasureSpec.makeMeasureSpec(size2 - (l + i), mode2);
                }
                else {
                    measureSpec = n;
                    measureSpec2 = n2;
                }
                final c f2 = f.f();
                if (f2 == null || !f2.m(this, view, measureSpec, n9, measureSpec2, 0)) {
                    this.O(view, measureSpec, n9, measureSpec2, 0);
                }
                n3 = Math.max(n3, paddingLeft + paddingRight + view.getMeasuredWidth() + f.leftMargin + f.rightMargin);
                n4 = Math.max(n4, paddingTop + paddingBottom + view.getMeasuredHeight() + f.topMargin + f.bottomMargin);
                combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view.getMeasuredState());
            }
            ++n5;
            n6 = n7;
        }
        this.setMeasuredDimension(View.resolveSizeAndState(n3, n, 0xFF000000 & combineMeasuredStates), View.resolveSizeAndState(n4, n2, combineMeasuredStates << 16));
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        final int childCount = this.getChildCount();
        int i = 0;
        int n3 = 0;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            boolean b2;
            if (child.getVisibility() == 8) {
                b2 = (n3 != 0);
            }
            else {
                final f f = (f)child.getLayoutParams();
                if (!f.j(0)) {
                    b2 = (n3 != 0);
                }
                else {
                    final c f2 = f.f();
                    b2 = (n3 != 0);
                    if (f2 != null) {
                        b2 = ((n3 | (f2.n(this, child, view, n, n2, b) ? 1 : 0)) != 0x0);
                    }
                }
            }
            ++i;
            n3 = (b2 ? 1 : 0);
        }
        if (n3 != 0) {
            this.M(1);
        }
        return n3 != 0;
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        final int childCount = this.getChildCount();
        int i = 0;
        int n3 = 0;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            boolean b;
            if (child.getVisibility() == 8) {
                b = (n3 != 0);
            }
            else {
                final f f = (f)child.getLayoutParams();
                if (!f.j(0)) {
                    b = (n3 != 0);
                }
                else {
                    final c f2 = f.f();
                    b = (n3 != 0);
                    if (f2 != null) {
                        b = ((n3 | (f2.o(this, child, view, n, n2) ? 1 : 0)) != 0x0);
                    }
                }
            }
            ++i;
            n3 = (b ? 1 : 0);
        }
        return n3 != 0;
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
        this.k(view, n, n2, array, 0);
    }
    
    public void onNestedScroll(final View view, final int n, final int n2, final int n3, final int n4) {
        this.n(view, n, n2, n3, n4, 0);
    }
    
    public void onNestedScrollAccepted(final View view, final View view2, final int n) {
        this.i(view, view2, n, 0);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.a());
        final SparseArray<Parcelable> c = savedState.c;
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            final int id = child.getId();
            final c f = this.D(child).f();
            if (id != -1 && f != null) {
                final Parcelable parcelable2 = (Parcelable)c.get(id);
                if (parcelable2 != null) {
                    f.x(this, child, parcelable2);
                }
            }
        }
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        final SparseArray c = new SparseArray();
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final int id = child.getId();
            final c f = ((f)child.getLayoutParams()).f();
            if (id != -1 && f != null) {
                final Parcelable y = f.y(this, child);
                if (y != null) {
                    c.append(id, (Object)y);
                }
            }
        }
        savedState.c = (SparseArray<Parcelable>)c;
        return (Parcelable)savedState;
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        return this.o(view, view2, n, 0);
    }
    
    public void onStopNestedScroll(final View view) {
        this.j(view, 0);
    }
    
    public boolean onTouchEvent(MotionEvent obtain) {
        final int actionMasked = obtain.getActionMasked();
        int n = 0;
        int n2 = 0;
        Label_0086: {
            Label_0083: {
                int q;
                if (this.p == null) {
                    q = (this.Q(obtain, 1) ? 1 : 0);
                    if ((n = q) == 0) {
                        break Label_0083;
                    }
                }
                else {
                    q = 0;
                }
                final c f = ((f)this.p.getLayoutParams()).f();
                n = q;
                if (f != null) {
                    final boolean d = f.D(this, this.p, obtain);
                    n = q;
                    n2 = (d ? 1 : 0);
                    break Label_0086;
                }
            }
            n2 = 0;
        }
        final View p = this.p;
        final MotionEvent motionEvent = null;
        boolean b;
        if (p == null) {
            b = ((n2 | (super.onTouchEvent(obtain) ? 1 : 0)) != 0x0);
            obtain = motionEvent;
        }
        else {
            b = (n2 != 0);
            obtain = motionEvent;
            if (n != 0) {
                final long uptimeMillis = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(obtain);
                b = (n2 != 0);
            }
        }
        if (obtain != null) {
            obtain.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.V(false);
        }
        return b;
    }
    
    public void p(final View view) {
        final List g = this.b.g(view);
        if (g != null && !g.isEmpty()) {
            for (int i = 0; i < g.size(); ++i) {
                final View view2 = g.get(i);
                final c f = ((f)view2.getLayoutParams()).f();
                if (f != null) {
                    f.h(this, view2, view);
                }
            }
        }
    }
    
    public boolean q(View e, final View view) {
        final int visibility = e.getVisibility();
        final boolean b = false;
        if (visibility == 0 && view.getVisibility() == 0) {
            final Rect e2 = e();
            this.v(e, e.getParent() != this, e2);
            e = (View)e();
            this.v(view, view.getParent() != this, (Rect)e);
            boolean b2 = b;
            try {
                if (e2.left <= ((Rect)e).right) {
                    b2 = b;
                    if (e2.top <= ((Rect)e).bottom) {
                        b2 = b;
                        if (e2.right >= ((Rect)e).left) {
                            final int bottom = e2.bottom;
                            final int top = ((Rect)e).top;
                            b2 = b;
                            if (bottom >= top) {
                                b2 = true;
                            }
                        }
                    }
                }
                return b2;
            }
            finally {
                T(e2);
                T((Rect)e);
            }
        }
        return false;
    }
    
    void r() {
        final int childCount = this.getChildCount();
        final boolean b = false;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= childCount) {
                break;
            }
            if (this.F(this.getChildAt(n))) {
                b2 = true;
                break;
            }
            ++n;
        }
        if (b2 != this.y) {
            if (b2) {
                this.f();
            }
            else {
                this.U();
            }
        }
    }
    
    public boolean requestChildRectangleOnScreen(final View view, final Rect rect, final boolean b) {
        final c f = ((f)view.getLayoutParams()).f();
        return (f != null && f.w(this, view, rect, b)) || super.requestChildRectangleOnScreen(view, rect, b);
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        super.requestDisallowInterceptTouchEvent(b);
        if (b && !this.h) {
            this.V(false);
            this.h = true;
        }
    }
    
    protected f s() {
        return new f(-2, -2);
    }
    
    public void setFitsSystemWindows(final boolean fitsSystemWindows) {
        super.setFitsSystemWindows(fitsSystemWindows);
        this.c0();
    }
    
    public void setOnHierarchyChangeListener(final ViewGroup$OnHierarchyChangeListener c) {
        this.C = c;
    }
    
    public void setStatusBarBackground(Drawable b) {
        final Drawable b2 = this.B;
        if (b2 != b) {
            Drawable mutate = null;
            if (b2 != null) {
                b2.setCallback((Drawable$Callback)null);
            }
            if (b != null) {
                mutate = b.mutate();
            }
            if ((this.B = mutate) != null) {
                if (mutate.isStateful()) {
                    this.B.setState(this.getDrawableState());
                }
                androidx.core.graphics.drawable.a.g(this.B, b0.B((View)this));
                b = this.B;
                b.setVisible(this.getVisibility() == 0, false);
                this.B.setCallback((Drawable$Callback)this);
            }
            b0.g0((View)this);
        }
    }
    
    public void setStatusBarBackgroundColor(final int n) {
        this.setStatusBarBackground((Drawable)new ColorDrawable(n));
    }
    
    public void setStatusBarBackgroundResource(final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = androidx.core.content.a.getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        this.setStatusBarBackground(drawable);
    }
    
    public void setVisibility(final int visibility) {
        super.setVisibility(visibility);
        final boolean b = visibility == 0;
        final Drawable b2 = this.B;
        if (b2 != null && b2.isVisible() != b) {
            this.B.setVisible(b, false);
        }
    }
    
    public f t(final AttributeSet set) {
        return new f(this.getContext(), set);
    }
    
    protected f u(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof f) {
            return new f((f)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return new f((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return new f(viewGroup$LayoutParams);
    }
    
    void v(final View view, final boolean b, final Rect rect) {
        if (!view.isLayoutRequested() && view.getVisibility() != 8) {
            if (b) {
                this.y(view, rect);
            }
            else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            return;
        }
        rect.setEmpty();
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.B;
    }
    
    public List<View> w(final View view) {
        final List<View> h = this.b.h(view);
        this.d.clear();
        if (h != null) {
            this.d.addAll(h);
        }
        return this.d;
    }
    
    public List<View> x(final View view) {
        final List g = this.b.g(view);
        this.d.clear();
        if (g != null) {
            this.d.addAll(g);
        }
        return this.d;
    }
    
    void y(final View view, final Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }
    
    void z(final View view, final int n, final Rect rect, final Rect rect2) {
        final f f = (f)view.getLayoutParams();
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        this.A(view, n, rect, rect2, f, measuredWidth, measuredHeight);
        this.h(f, rect2, measuredWidth, measuredHeight);
    }
    
    protected static class SavedState extends AbsSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        SparseArray<Parcelable> c;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$ClassLoaderCreator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel, null);
                }
                
                public SavedState b(final Parcel parcel, final ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }
                
                public SavedState[] c(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                    return this.b(parcel, classLoader);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.c(n);
                }
            };
        }
        
        public SavedState(final Parcel parcel, final ClassLoader classLoader) {
            super(parcel, classLoader);
            final int int1 = parcel.readInt();
            final int[] array = new int[int1];
            parcel.readIntArray(array);
            final Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.c = (SparseArray<Parcelable>)new SparseArray(int1);
            for (int i = 0; i < int1; ++i) {
                this.c.append(array[i], (Object)parcelableArray[i]);
            }
        }
        
        public SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        @Override
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            final SparseArray<Parcelable> c = this.c;
            int i = 0;
            int size;
            if (c != null) {
                size = c.size();
            }
            else {
                size = 0;
            }
            parcel.writeInt(size);
            final int[] array = new int[size];
            final Parcelable[] array2 = new Parcelable[size];
            while (i < size) {
                array[i] = this.c.keyAt(i);
                array2[i] = (Parcelable)this.c.valueAt(i);
                ++i;
            }
            parcel.writeIntArray(array);
            parcel.writeParcelableArray(array2, n);
        }
    }
    
    public interface b
    {
        c getBehavior();
    }
    
    public abstract static class c<V extends View>
    {
        public c() {
        }
        
        public c(final Context context, final AttributeSet set) {
        }
        
        public boolean A(final CoordinatorLayout coordinatorLayout, final V v, final View view, final View view2, final int n, final int n2) {
            return n2 == 0 && this.z(coordinatorLayout, v, view, view2, n);
        }
        
        @Deprecated
        public void B(final CoordinatorLayout coordinatorLayout, final V v, final View view) {
        }
        
        public void C(final CoordinatorLayout coordinatorLayout, final V v, final View view, final int n) {
            if (n == 0) {
                this.B(coordinatorLayout, v, view);
            }
        }
        
        public boolean D(final CoordinatorLayout coordinatorLayout, final V v, final MotionEvent motionEvent) {
            return false;
        }
        
        public boolean a(final CoordinatorLayout coordinatorLayout, final V v) {
            return this.d(coordinatorLayout, v) > 0.0f;
        }
        
        public boolean b(final CoordinatorLayout coordinatorLayout, final V v, final Rect rect) {
            return false;
        }
        
        public int c(final CoordinatorLayout coordinatorLayout, final V v) {
            return -16777216;
        }
        
        public float d(final CoordinatorLayout coordinatorLayout, final V v) {
            return 0.0f;
        }
        
        public boolean e(final CoordinatorLayout coordinatorLayout, final V v, final View view) {
            return false;
        }
        
        public n0 f(final CoordinatorLayout coordinatorLayout, final V v, final n0 n0) {
            return n0;
        }
        
        public void g(final f f) {
        }
        
        public boolean h(final CoordinatorLayout coordinatorLayout, final V v, final View view) {
            return false;
        }
        
        public void i(final CoordinatorLayout coordinatorLayout, final V v, final View view) {
        }
        
        public void j() {
        }
        
        public boolean k(final CoordinatorLayout coordinatorLayout, final V v, final MotionEvent motionEvent) {
            return false;
        }
        
        public boolean l(final CoordinatorLayout coordinatorLayout, final V v, final int n) {
            return false;
        }
        
        public boolean m(final CoordinatorLayout coordinatorLayout, final V v, final int n, final int n2, final int n3, final int n4) {
            return false;
        }
        
        public boolean n(final CoordinatorLayout coordinatorLayout, final V v, final View view, final float n, final float n2, final boolean b) {
            return false;
        }
        
        public boolean o(final CoordinatorLayout coordinatorLayout, final V v, final View view, final float n, final float n2) {
            return false;
        }
        
        @Deprecated
        public void p(final CoordinatorLayout coordinatorLayout, final V v, final View view, final int n, final int n2, final int[] array) {
        }
        
        public void q(final CoordinatorLayout coordinatorLayout, final V v, final View view, final int n, final int n2, final int[] array, final int n3) {
            if (n3 == 0) {
                this.p(coordinatorLayout, v, view, n, n2, array);
            }
        }
        
        @Deprecated
        public void r(final CoordinatorLayout coordinatorLayout, final V v, final View view, final int n, final int n2, final int n3, final int n4) {
        }
        
        @Deprecated
        public void s(final CoordinatorLayout coordinatorLayout, final V v, final View view, final int n, final int n2, final int n3, final int n4, final int n5) {
            if (n5 == 0) {
                this.r(coordinatorLayout, v, view, n, n2, n3, n4);
            }
        }
        
        public void t(final CoordinatorLayout coordinatorLayout, final V v, final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int[] array) {
            array[0] += n3;
            array[1] += n4;
            this.s(coordinatorLayout, v, view, n, n2, n3, n4, n5);
        }
        
        @Deprecated
        public void u(final CoordinatorLayout coordinatorLayout, final V v, final View view, final View view2, final int n) {
        }
        
        public void v(final CoordinatorLayout coordinatorLayout, final V v, final View view, final View view2, final int n, final int n2) {
            if (n2 == 0) {
                this.u(coordinatorLayout, v, view, view2, n);
            }
        }
        
        public boolean w(final CoordinatorLayout coordinatorLayout, final V v, final Rect rect, final boolean b) {
            return false;
        }
        
        public void x(final CoordinatorLayout coordinatorLayout, final V v, final Parcelable parcelable) {
        }
        
        public Parcelable y(final CoordinatorLayout coordinatorLayout, final V v) {
            return (Parcelable)View$BaseSavedState.EMPTY_STATE;
        }
        
        @Deprecated
        public boolean z(final CoordinatorLayout coordinatorLayout, final V v, final View view, final View view2, final int n) {
            return false;
        }
    }
    
    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        Class<? extends c> value();
    }
    
    private class e implements ViewGroup$OnHierarchyChangeListener
    {
        final CoordinatorLayout a;
        
        e(final CoordinatorLayout a) {
            this.a = a;
        }
        
        public void onChildViewAdded(final View view, final View view2) {
            final ViewGroup$OnHierarchyChangeListener c = this.a.C;
            if (c != null) {
                c.onChildViewAdded(view, view2);
            }
        }
        
        public void onChildViewRemoved(final View view, final View view2) {
            this.a.M(2);
            final ViewGroup$OnHierarchyChangeListener c = this.a.C;
            if (c != null) {
                c.onChildViewRemoved(view, view2);
            }
        }
    }
    
    public static class f extends ViewGroup$MarginLayoutParams
    {
        c a;
        boolean b;
        public int c;
        public int d;
        public int e;
        int f;
        public int g;
        public int h;
        int i;
        int j;
        View k;
        View l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q;
        Object r;
        
        public f(final int n, final int n2) {
            super(n, n2);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }
        
        f(final Context context, final AttributeSet set) {
            super(context, set);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, u.c.e);
            this.c = obtainStyledAttributes.getInteger(u.c.f, 0);
            this.f = obtainStyledAttributes.getResourceId(u.c.g, -1);
            this.d = obtainStyledAttributes.getInteger(u.c.h, 0);
            this.e = obtainStyledAttributes.getInteger(u.c.l, -1);
            this.g = obtainStyledAttributes.getInt(u.c.k, 0);
            this.h = obtainStyledAttributes.getInt(u.c.j, 0);
            final int i = u.c.i;
            final boolean hasValue = obtainStyledAttributes.hasValue(i);
            this.b = hasValue;
            if (hasValue) {
                this.a = CoordinatorLayout.P(context, set, obtainStyledAttributes.getString(i));
            }
            obtainStyledAttributes.recycle();
            final c a = this.a;
            if (a != null) {
                a.g(this);
            }
        }
        
        public f(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }
        
        public f(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(viewGroup$MarginLayoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }
        
        public f(final f f) {
            super((ViewGroup$MarginLayoutParams)f);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }
        
        private void n(final View view, final CoordinatorLayout coordinatorLayout) {
            View viewById = coordinatorLayout.findViewById(this.f);
            this.k = viewById;
            if (viewById != null) {
                if (viewById != coordinatorLayout) {
                    ViewParent viewParent = viewById.getParent();
                    while (viewParent != coordinatorLayout && viewParent != null) {
                        if (viewParent == view) {
                            if (coordinatorLayout.isInEditMode()) {
                                this.l = null;
                                this.k = null;
                                return;
                            }
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                        else {
                            if (viewParent instanceof View) {
                                viewById = (View)viewParent;
                            }
                            viewParent = viewParent.getParent();
                        }
                    }
                    this.l = viewById;
                    return;
                }
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
            else {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Could not find CoordinatorLayout descendant view with id ");
                sb.append(coordinatorLayout.getResources().getResourceName(this.f));
                sb.append(" to anchor view ");
                sb.append(view);
                throw new IllegalStateException(sb.toString());
            }
        }
        
        private boolean s(final View view, final int n) {
            final int b = androidx.core.view.f.b(((f)view.getLayoutParams()).g, n);
            return b != 0 && (androidx.core.view.f.b(this.h, n) & b) == b;
        }
        
        private boolean t(final View view, final CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View k = this.k;
            for (ViewParent viewParent = k.getParent(); viewParent != coordinatorLayout; viewParent = viewParent.getParent()) {
                if (viewParent == null || viewParent == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (viewParent instanceof View) {
                    k = (View)viewParent;
                }
            }
            this.l = k;
            return true;
        }
        
        boolean a() {
            return this.k == null && this.f != -1;
        }
        
        boolean b(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
            if (view2 != this.l && !this.s(view2, b0.B((View)coordinatorLayout))) {
                final c a = this.a;
                if (a == null || !a.e(coordinatorLayout, view, view2)) {
                    return false;
                }
            }
            return true;
        }
        
        boolean c() {
            if (this.a == null) {
                this.m = false;
            }
            return this.m;
        }
        
        View d(final CoordinatorLayout coordinatorLayout, final View view) {
            if (this.f == -1) {
                this.l = null;
                return this.k = null;
            }
            if (this.k == null || !this.t(view, coordinatorLayout)) {
                this.n(view, coordinatorLayout);
            }
            return this.k;
        }
        
        public int e() {
            return this.f;
        }
        
        public c f() {
            return this.a;
        }
        
        boolean g() {
            return this.p;
        }
        
        Rect h() {
            return this.q;
        }
        
        boolean i(final CoordinatorLayout coordinatorLayout, final View view) {
            final boolean m = this.m;
            if (m) {
                return true;
            }
            final c a = this.a;
            return this.m = ((a != null && a.a(coordinatorLayout, view)) | m);
        }
        
        boolean j(final int n) {
            if (n != 0) {
                return n == 1 && this.o;
            }
            return this.n;
        }
        
        void k() {
            this.p = false;
        }
        
        void l(final int n) {
            this.r(n, false);
        }
        
        void m() {
            this.m = false;
        }
        
        public void o(final c a) {
            final c a2 = this.a;
            if (a2 != a) {
                if (a2 != null) {
                    a2.j();
                }
                this.a = a;
                this.r = null;
                this.b = true;
                if (a != null) {
                    a.g(this);
                }
            }
        }
        
        void p(final boolean p) {
            this.p = p;
        }
        
        void q(final Rect rect) {
            this.q.set(rect);
        }
        
        void r(final int n, final boolean b) {
            if (n != 0) {
                if (n == 1) {
                    this.o = b;
                }
            }
            else {
                this.n = b;
            }
        }
    }
    
    class g implements ViewTreeObserver$OnPreDrawListener
    {
        final CoordinatorLayout a;
        
        g(final CoordinatorLayout a) {
            this.a = a;
        }
        
        public boolean onPreDraw() {
            this.a.M(0);
            return true;
        }
    }
    
    static class h implements Comparator<View>
    {
        public int a(final View view, final View view2) {
            final float m = b0.M(view);
            final float i = b0.M(view2);
            if (m > i) {
                return -1;
            }
            if (m < i) {
                return 1;
            }
            return 0;
        }
        
        @Override
        public /* bridge */ int compare(final Object o, final Object o2) {
            return this.a((View)o, (View)o2);
        }
    }
}
