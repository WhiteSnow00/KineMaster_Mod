// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar
{
    long a;
    boolean b;
    boolean c;
    boolean d;
    private final Runnable e;
    private final Runnable f;
    
    public ContentLoadingProgressBar(final Context context, final AttributeSet set) {
        super(context, set, 0);
        this.a = -1L;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = new e(this);
        this.f = new g(this);
    }
    
    public static void a(final ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.g();
    }
    
    public static void b(final ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.f();
    }
    
    public static void c(final ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.h();
    }
    
    public static void d(final ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.k();
    }
    
    private void f() {
        this.d = true;
        this.removeCallbacks(this.f);
        this.c = false;
        final long currentTimeMillis = System.currentTimeMillis();
        final long a = this.a;
        final long n = currentTimeMillis - a;
        if (n < 500L && a != -1L) {
            if (!this.b) {
                this.postDelayed(this.e, 500L - n);
                this.b = true;
            }
        }
        else {
            this.setVisibility(8);
        }
    }
    
    private void g() {
        this.b = false;
        this.a = -1L;
        this.setVisibility(8);
    }
    
    private void h() {
        this.c = false;
        if (!this.d) {
            this.a = System.currentTimeMillis();
            this.setVisibility(0);
        }
    }
    
    private void i() {
        this.removeCallbacks(this.e);
        this.removeCallbacks(this.f);
    }
    
    private void k() {
        this.a = -1L;
        this.d = false;
        this.removeCallbacks(this.e);
        this.b = false;
        if (!this.c) {
            this.postDelayed(this.f, 500L);
            this.c = true;
        }
    }
    
    public void e() {
        this.post((Runnable)new f(this));
    }
    
    public void j() {
        this.post((Runnable)new h(this));
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i();
    }
}
