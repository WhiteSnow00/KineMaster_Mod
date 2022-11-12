// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.ads.internal.zzt;
import android.view.Window;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.app.Activity;
import android.view.View;

public final class zzci
{
    private final View a;
    private Activity b;
    private boolean c;
    private boolean d;
    private boolean e;
    private final ViewTreeObserver$OnGlobalLayoutListener f;
    
    public zzci(final Activity b, final View a, final ViewTreeObserver$OnGlobalLayoutListener f, final ViewTreeObserver$OnScrollChangedListener viewTreeObserver$OnScrollChangedListener) {
        this.b = b;
        this.a = a;
        this.f = f;
    }
    
    private static ViewTreeObserver f(final Activity activity) {
        final Window window = activity.getWindow();
        if (window == null) {
            return null;
        }
        final View decorView = window.getDecorView();
        if (decorView == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }
    
    private final void g() {
        if (!this.c) {
            final Activity b = this.b;
            if (b != null) {
                final ViewTreeObserver$OnGlobalLayoutListener f = this.f;
                final ViewTreeObserver f2 = f(b);
                if (f2 != null) {
                    f2.addOnGlobalLayoutListener(f);
                }
            }
            zzt.y();
            zzcgi.zza(this.a, this.f);
            this.c = true;
        }
    }
    
    private final void h() {
        final Activity b = this.b;
        if (b == null) {
            return;
        }
        if (this.c) {
            final ViewTreeObserver$OnGlobalLayoutListener f = this.f;
            final ViewTreeObserver f2 = f(b);
            if (f2 != null) {
                f2.removeOnGlobalLayoutListener(f);
            }
            this.c = false;
        }
    }
    
    public final void a() {
        this.e = false;
        this.h();
    }
    
    public final void b() {
        this.e = true;
        if (this.d) {
            this.g();
        }
    }
    
    public final void c() {
        this.d = true;
        if (this.e) {
            this.g();
        }
    }
    
    public final void d() {
        this.d = false;
        this.h();
    }
    
    public final void e(final Activity b) {
        this.b = b;
    }
}
