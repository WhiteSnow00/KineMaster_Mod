// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import java.util.Objects;
import android.view.ViewTreeObserver;
import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewTreeObserver$OnPreDrawListener;

public final class y implements ViewTreeObserver$OnPreDrawListener, View$OnAttachStateChangeListener
{
    private final View a;
    private ViewTreeObserver b;
    private final Runnable c;
    
    private y(final View a, final Runnable c) {
        this.a = a;
        this.b = a.getViewTreeObserver();
        this.c = c;
    }
    
    public static y a(final View view, final Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        final y y = new y(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)y);
        view.addOnAttachStateChangeListener((View$OnAttachStateChangeListener)y);
        return y;
    }
    
    public void b() {
        if (this.b.isAlive()) {
            this.b.removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
        }
        else {
            this.a.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
        }
        this.a.removeOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
    }
    
    public boolean onPreDraw() {
        this.b();
        this.c.run();
        return true;
    }
    
    public void onViewAttachedToWindow(final View view) {
        this.b = view.getViewTreeObserver();
    }
    
    public void onViewDetachedFromWindow(final View view) {
        this.b();
    }
}
