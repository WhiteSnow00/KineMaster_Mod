// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import android.os.Bundle;
import android.content.res.Configuration;
import android.view.MenuInflater;
import android.content.Context;
import androidx.appcompat.widget.Toolbar;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import java.util.Iterator;
import android.app.Dialog;
import android.app.Activity;
import androidx.appcompat.widget.v0;
import java.lang.ref.WeakReference;
import androidx.collection.b;

public abstract class f
{
    private static int a = -100;
    private static final b<WeakReference<f>> b;
    private static final Object c;
    
    static {
        b = new b<WeakReference<f>>();
        c = new Object();
    }
    
    f() {
    }
    
    public static void B(final boolean b) {
        v0.c(b);
    }
    
    static void c(final f f) {
        synchronized (f.c) {
            z(f);
            f.b.add(new WeakReference<f>(f));
        }
    }
    
    public static f g(final Activity activity, final e e) {
        return new AppCompatDelegateImpl(activity, e);
    }
    
    public static f h(final Dialog dialog, final e e) {
        return new AppCompatDelegateImpl(dialog, e);
    }
    
    public static int j() {
        return f.a;
    }
    
    static void y(final f f) {
        synchronized (f.c) {
            z(f);
        }
    }
    
    private static void z(final f f) {
        synchronized (f.c) {
            final Iterator<WeakReference<f>> iterator = f.b.iterator();
            while (iterator.hasNext()) {
                final f f2 = iterator.next().get();
                if (f2 == f || f2 == null) {
                    iterator.remove();
                }
            }
        }
    }
    
    public abstract boolean A(final int p0);
    
    public abstract void C(final int p0);
    
    public abstract void D(final View p0);
    
    public abstract void E(final View p0, final ViewGroup$LayoutParams p1);
    
    public abstract void F(final Toolbar p0);
    
    public void G(final int n) {
    }
    
    public abstract void H(final CharSequence p0);
    
    public abstract androidx.appcompat.view.b I(final androidx.appcompat.view.b.a p0);
    
    public abstract void d(final View p0, final ViewGroup$LayoutParams p1);
    
    @Deprecated
    public void e(final Context context) {
    }
    
    public Context f(final Context context) {
        this.e(context);
        return context;
    }
    
    public abstract <T extends View> T i(final int p0);
    
    public abstract androidx.appcompat.app.b k();
    
    public int l() {
        return -100;
    }
    
    public abstract MenuInflater m();
    
    public abstract a n();
    
    public abstract void o();
    
    public abstract void p();
    
    public abstract void q(final Configuration p0);
    
    public abstract void r(final Bundle p0);
    
    public abstract void s();
    
    public abstract void t(final Bundle p0);
    
    public abstract void u();
    
    public abstract void v(final Bundle p0);
    
    public abstract void w();
    
    public abstract void x();
}
