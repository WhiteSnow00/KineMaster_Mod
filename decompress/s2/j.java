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
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.e;
import v2.k;
import com.bumptech.glide.g;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;

@Deprecated
public abstract class j<T extends View, Z> extends s2.a<Z>
{
    private static boolean f;
    private static int g;
    protected final T a;
    private final a b;
    private View$OnAttachStateChangeListener c;
    private boolean d;
    private boolean e;
    
    static {
        j.g = com.bumptech.glide.g.a;
    }
    
    public j(final T t) {
        this.a = k.d(t);
        this.b = new a(t);
    }
    
    private Object c() {
        return this.a.getTag(j.g);
    }
    
    private void d() {
        final View$OnAttachStateChangeListener c = this.c;
        if (c != null) {
            if (!this.e) {
                this.a.addOnAttachStateChangeListener(c);
                this.e = true;
            }
        }
    }
    
    private void e() {
        final View$OnAttachStateChangeListener c = this.c;
        if (c != null) {
            if (this.e) {
                this.a.removeOnAttachStateChangeListener(c);
                this.e = false;
            }
        }
    }
    
    private void f(final Object o) {
        j.f = true;
        this.a.setTag(j.g, o);
    }
    
    @Override
    public e getRequest() {
        final Object c = this.c();
        e e;
        if (c != null) {
            if (!(c instanceof e)) {
                throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
            }
            e = (e)c;
        }
        else {
            e = null;
        }
        return e;
    }
    
    @Override
    public void getSize(final h h) {
        this.b.d(h);
    }
    
    @Override
    public void onLoadCleared(final Drawable drawable) {
        super.onLoadCleared(drawable);
        this.b.b();
        if (!this.d) {
            this.e();
        }
    }
    
    @Override
    public void onLoadStarted(final Drawable drawable) {
        super.onLoadStarted(drawable);
        this.d();
    }
    
    @Override
    public void removeCallback(final h h) {
        this.b.k(h);
    }
    
    @Override
    public void setRequest(final e e) {
        this.f(e);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Target for: ");
        sb.append(this.a);
        return sb.toString();
    }
    
    static final class a
    {
        static Integer e;
        private final View a;
        private final List<h> b;
        boolean c;
        private j.a.a d;
        
        a(final View a) {
            this.b = new ArrayList<h>();
            this.a = a;
        }
        
        private static int c(final Context context) {
            if (j.a.e == null) {
                final Display defaultDisplay = k.d(context.getSystemService("window")).getDefaultDisplay();
                final Point point = new Point();
                defaultDisplay.getSize(point);
                j.a.e = Math.max(point.x, point.y);
            }
            return j.a.e;
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
                if (Log.isLoggable("ViewTarget", 4)) {
                    Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
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
                this.a.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)(this.d = new j.a.a(this)));
            }
        }
        
        void k(final h h) {
            this.b.remove(h);
        }
        
        private static final class a implements ViewTreeObserver$OnPreDrawListener
        {
            private final WeakReference<j.a> a;
            
            a(final j.a a) {
                this.a = new WeakReference<j.a>(a);
            }
            
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                    Log.v("ViewTarget", sb.toString());
                }
                final j.a a = this.a.get();
                if (a != null) {
                    a.a();
                }
                return true;
            }
        }
    }
}
