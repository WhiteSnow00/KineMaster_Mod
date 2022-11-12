// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.ViewParent;
import android.os.SystemClock;
import androidx.appcompat.view.menu.p;
import android.widget.ListView;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnTouchListener;

public abstract class d0 implements View$OnTouchListener, View$OnAttachStateChangeListener
{
    private final float a;
    private final int b;
    private final int c;
    final View d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i;
    
    public d0(final View d) {
        this.i = new int[2];
        (this.d = d).setLongClickable(true);
        d.addOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
        this.a = (float)ViewConfiguration.get(d.getContext()).getScaledTouchSlop();
        final int tapTimeout = ViewConfiguration.getTapTimeout();
        this.b = tapTimeout;
        this.c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }
    
    private void a() {
        final Runnable f = this.f;
        if (f != null) {
            this.d.removeCallbacks(f);
        }
        final Runnable e = this.e;
        if (e != null) {
            this.d.removeCallbacks(e);
        }
    }
    
    private boolean f(final MotionEvent motionEvent) {
        final View d = this.d;
        final p b = this.b();
        boolean b3;
        final boolean b2 = b3 = false;
        if (b != null) {
            if (!b.a()) {
                b3 = b2;
            }
            else {
                final ListView listView = b.o();
                b3 = b2;
                if (listView != null) {
                    if (!listView.isShown()) {
                        b3 = b2;
                    }
                    else {
                        final MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                        this.i(d, obtainNoHistory);
                        this.j((View)listView, obtainNoHistory);
                        final boolean e = ((b0)listView).e(obtainNoHistory, this.h);
                        obtainNoHistory.recycle();
                        final int actionMasked = motionEvent.getActionMasked();
                        final boolean b4 = actionMasked != 1 && actionMasked != 3;
                        b3 = b2;
                        if (e) {
                            b3 = b2;
                            if (b4) {
                                b3 = true;
                            }
                        }
                    }
                }
            }
        }
        return b3;
    }
    
    private boolean g(final MotionEvent motionEvent) {
        final View d = this.d;
        if (!d.isEnabled()) {
            return false;
        }
        final int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                }
                else {
                    final int pointerIndex = motionEvent.findPointerIndex(this.h);
                    if (pointerIndex >= 0 && !h(d, motionEvent.getX(pointerIndex), motionEvent.getY(pointerIndex), this.a)) {
                        this.a();
                        d.getParent().requestDisallowInterceptTouchEvent(true);
                        return true;
                    }
                    return false;
                }
            }
            this.a();
        }
        else {
            this.h = motionEvent.getPointerId(0);
            if (this.e == null) {
                this.e = new a();
            }
            d.postDelayed(this.e, (long)this.b);
            if (this.f == null) {
                this.f = new b();
            }
            d.postDelayed(this.f, (long)this.c);
        }
        return false;
    }
    
    private static boolean h(final View view, final float n, final float n2, final float n3) {
        final float n4 = -n3;
        return n >= n4 && n2 >= n4 && n < view.getRight() - view.getLeft() + n3 && n2 < view.getBottom() - view.getTop() + n3;
    }
    
    private boolean i(final View view, final MotionEvent motionEvent) {
        final int[] i = this.i;
        view.getLocationOnScreen(i);
        motionEvent.offsetLocation((float)i[0], (float)i[1]);
        return true;
    }
    
    private boolean j(final View view, final MotionEvent motionEvent) {
        final int[] i = this.i;
        view.getLocationOnScreen(i);
        motionEvent.offsetLocation((float)(-i[0]), (float)(-i[1]));
        return true;
    }
    
    public abstract p b();
    
    protected abstract boolean c();
    
    protected boolean d() {
        final p b = this.b();
        if (b != null && b.a()) {
            b.dismiss();
        }
        return true;
    }
    
    void e() {
        this.a();
        final View d = this.d;
        if (d.isEnabled()) {
            if (!d.isLongClickable()) {
                if (!this.c()) {
                    return;
                }
                d.getParent().requestDisallowInterceptTouchEvent(true);
                final long uptimeMillis = SystemClock.uptimeMillis();
                final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                d.onTouchEvent(obtain);
                obtain.recycle();
                this.g = true;
            }
        }
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final boolean g = this.g;
        final boolean b = true;
        boolean g2;
        if (g) {
            g2 = (this.f(motionEvent) || !this.d());
        }
        else {
            final boolean b2 = g2 = (this.g(motionEvent) && this.c());
            if (b2) {
                final long uptimeMillis = SystemClock.uptimeMillis();
                final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.d.onTouchEvent(obtain);
                obtain.recycle();
                g2 = b2;
            }
        }
        this.g = g2;
        boolean b3 = b;
        if (!g2) {
            b3 = (g && b);
        }
        return b3;
    }
    
    public void onViewAttachedToWindow(final View view) {
    }
    
    public void onViewDetachedFromWindow(final View view) {
        this.g = false;
        this.h = -1;
        final Runnable e = this.e;
        if (e != null) {
            this.d.removeCallbacks(e);
        }
    }
    
    private class a implements Runnable
    {
        final d0 a;
        
        a(final d0 a) {
            this.a = a;
        }
        
        @Override
        public void run() {
            final ViewParent parent = this.a.d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }
    
    private class b implements Runnable
    {
        final d0 a;
        
        b(final d0 a) {
            this.a = a;
        }
        
        @Override
        public void run() {
            this.a.e();
        }
    }
}
