// 
// Decompiled by Procyon v0.6.0
// 

package s2;

import java.lang.ref.WeakReference;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver$OnPreDrawListener;
import java.util.Iterator;
import java.util.Collection;
import android.view.ViewGroup$LayoutParams;
import android.util.Log;
import android.view.Display;
import android.graphics.Point;
import android.view.WindowManager;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import com.bumptech.glide.request.e;
import android.graphics.drawable.Drawable;
import v2.k;
import com.bumptech.glide.g;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;

public abstract class d<T extends View, Z> implements i<Z>
{
    private static final int f;
    private final a a;
    protected final T b;
    private View$OnAttachStateChangeListener c;
    private boolean d;
    private boolean e;
    
    static {
        f = g.a;
    }
    
    public d(final T t) {
        this.b = k.d(t);
        this.a = new a(t);
    }
    
    private Object a() {
        return this.b.getTag(s2.d.f);
    }
    
    private void b() {
        final View$OnAttachStateChangeListener c = this.c;
        if (c != null) {
            if (!this.e) {
                this.b.addOnAttachStateChangeListener(c);
                this.e = true;
            }
        }
    }
    
    private void c() {
        final View$OnAttachStateChangeListener c = this.c;
        if (c != null) {
            if (this.e) {
                this.b.removeOnAttachStateChangeListener(c);
                this.e = false;
            }
        }
    }
    
    private void f(final Object o) {
        this.b.setTag(s2.d.f, o);
    }
    
    protected abstract void d(final Drawable p0);
    
    protected void e(final Drawable drawable) {
    }
    
    @Override
    public final e getRequest() {
        final Object a = this.a();
        if (a == null) {
            return null;
        }
        if (a instanceof e) {
            return (e)a;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }
    
    @Override
    public final void getSize(final h h) {
        this.a.d(h);
    }
    
    @Override
    public void onDestroy() {
    }
    
    @Override
    public final void onLoadCleared(final Drawable drawable) {
        this.a.b();
        this.d(drawable);
        if (!this.d) {
            this.c();
        }
    }
    
    @Override
    public final void onLoadStarted(final Drawable drawable) {
        this.b();
        this.e(drawable);
    }
    
    @Override
    public void onStart() {
    }
    
    @Override
    public void onStop() {
    }
    
    @Override
    public final void removeCallback(final h h) {
        this.a.k(h);
    }
    
    @Override
    public final void setRequest(final e e) {
        this.f(e);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Target for: ");
        sb.append(this.b);
        return sb.toString();
    }
    
    static final class a
    {
        static Integer e;
        private final View a;
        private final List<h> b;
        boolean c;
        private d.a.a d;
        
        a(final View a) {
            this.b = new ArrayList<h>();
            this.a = a;
        }
        
        private static int c(final Context context) {
            if (d.a.e == null) {
                final Display defaultDisplay = k.d(context.getSystemService("window")).getDefaultDisplay();
                final Point point = new Point();
                defaultDisplay.getSize(point);
                d.a.e = Math.max(point.x, point.y);
            }
            return d.a.e;
        }
        
        private int e(int n, final int n2, final int n3) {
            final int n4 = n2 - n3;
            if (n4 > 0) {
                return n4;
            }
            if (this.c && this.a.isLayoutRequested()) {
                return 0;
            }
            n -= n3;
            if (n > 0) {
                return n;
            }
            if (!this.a.isLayoutRequested() && n2 == -2) {
                if (Log.isLoggable("CustomViewTarget", 4)) {
                    Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
                }
                return c(this.a.getContext());
            }
            return 0;
        }
        
        private int f() {
            final int paddingTop = this.a.getPaddingTop();
            final int paddingBottom = this.a.getPaddingBottom();
            final ViewGroup$LayoutParams layoutParams = this.a.getLayoutParams();
            int height;
            if (layoutParams != null) {
                height = layoutParams.height;
            }
            else {
                height = 0;
            }
            return this.e(this.a.getHeight(), height, paddingTop + paddingBottom);
        }
        
        private int g() {
            final int paddingLeft = this.a.getPaddingLeft();
            final int paddingRight = this.a.getPaddingRight();
            final ViewGroup$LayoutParams layoutParams = this.a.getLayoutParams();
            int width;
            if (layoutParams != null) {
                width = layoutParams.width;
            }
            else {
                width = 0;
            }
            return this.e(this.a.getWidth(), width, paddingLeft + paddingRight);
        }
        
        private boolean h(final int n) {
            return n > 0 || n == Integer.MIN_VALUE;
        }
        
        private boolean i(final int n, final int n2) {
            return this.h(n) && this.h(n2);
        }
        
        private void j(final int n, final int n2) {
            final Iterator iterator = new ArrayList(this.b).iterator();
            while (iterator.hasNext()) {
                ((h)iterator.next()).d(n, n2);
            }
        }
        
        void a() {
            if (this.b.isEmpty()) {
                return;
            }
            final int g = this.g();
            final int f = this.f();
            if (!this.i(g, f)) {
                return;
            }
            this.j(g, f);
            this.b();
        }
        
        void b() {
            final ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this.d);
            }
            this.d = null;
            this.b.clear();
        }
        
        void d(final h h) {
            final int g = this.g();
            final int f = this.f();
            if (this.i(g, f)) {
                h.d(g, f);
                return;
            }
            if (!this.b.contains(h)) {
                this.b.add(h);
            }
            if (this.d == null) {
                this.a.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)(this.d = new d.a.a(this)));
            }
        }
        
        void k(final h h) {
            this.b.remove(h);
        }
        
        private static final class a implements ViewTreeObserver$OnPreDrawListener
        {
            private final WeakReference<d.a> a;
            
            a(final d.a a) {
                this.a = new WeakReference<d.a>(a);
            }
            
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                    Log.v("CustomViewTarget", sb.toString());
                }
                final d.a a = this.a.get();
                if (a != null) {
                    a.a();
                }
                return true;
            }
        }
    }
}
