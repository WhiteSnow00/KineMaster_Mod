// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.WindowInsetsController$OnControllableInsetsChangedListener;
import androidx.collection.g;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import android.os.Build$VERSION;
import android.view.View;
import android.view.Window;

public final class o0
{
    private final e a;
    
    public o0(final Window window, final View view) {
        if (Build$VERSION.SDK_INT >= 30) {
            this.a = (e)new d(window, this);
        }
        else {
            this.a = (e)new c(window, view);
        }
    }
    
    public void a(final int n) {
        this.a.a(n);
    }
    
    public void b(final boolean b) {
        this.a.b(b);
    }
    
    public void c(final boolean b) {
        this.a.c(b);
    }
    
    public void d(final int n) {
        this.a.d(n);
    }
    
    private static class a extends e
    {
        protected final Window a;
        private final View b;
        
        a(final Window a, final View b) {
            this.a = a;
            this.b = b;
        }
        
        private void e(final int n) {
            if (n == 1) {
                this.f(4);
                return;
            }
            if (n != 2) {
                if (n == 8) {
                    ((InputMethodManager)this.a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.getDecorView().getWindowToken(), 0);
                }
                return;
            }
            this.f(2);
        }
        
        @Override
        void a(final int n) {
            for (int i = 1; i <= 256; i <<= 1) {
                if ((n & i) != 0x0) {
                    this.e(i);
                }
            }
        }
        
        @Override
        void d(final int n) {
            if (n != 0) {
                if (n != 1) {
                    if (n == 2) {
                        this.h(2048);
                        this.f(4096);
                    }
                }
                else {
                    this.h(4096);
                    this.f(2048);
                }
            }
            else {
                this.h(6144);
            }
        }
        
        protected void f(final int n) {
            final View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility(n | decorView.getSystemUiVisibility());
        }
        
        protected void g(final int n) {
            this.a.addFlags(n);
        }
        
        protected void h(final int n) {
            final View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility(~n & decorView.getSystemUiVisibility());
        }
        
        protected void i(final int n) {
            this.a.clearFlags(n);
        }
    }
    
    private static class e
    {
        e() {
        }
        
        void a(final int n) {
            throw null;
        }
        
        public void b(final boolean b) {
            throw null;
        }
        
        public void c(final boolean b) {
            throw null;
        }
        
        void d(final int n) {
            throw null;
        }
    }
    
    private static class b extends a
    {
        b(final Window window, final View view) {
            super(window, view);
        }
        
        @Override
        public void c(final boolean b) {
            if (b) {
                ((a)this).i(67108864);
                ((a)this).g(Integer.MIN_VALUE);
                ((a)this).f(8192);
            }
            else {
                ((a)this).h(8192);
            }
        }
    }
    
    private static class c extends b
    {
        c(final Window window, final View view) {
            super(window, view);
        }
        
        @Override
        public void b(final boolean b) {
            if (b) {
                ((a)this).i(134217728);
                ((a)this).g(Integer.MIN_VALUE);
                ((a)this).f(16);
            }
            else {
                ((a)this).h(16);
            }
        }
    }
    
    private static class d extends e
    {
        final o0 a;
        final WindowInsetsController b;
        private final g<Object, WindowInsetsController$OnControllableInsetsChangedListener> c;
        protected Window d;
        
        d(final Window d, final o0 o0) {
            this(d.getInsetsController(), o0);
            this.d = d;
        }
        
        d(final WindowInsetsController b, final o0 a) {
            this.c = new g<Object, WindowInsetsController$OnControllableInsetsChangedListener>();
            this.b = b;
            this.a = a;
        }
        
        @Override
        void a(final int n) {
            this.b.hide(n);
        }
        
        @Override
        public void b(final boolean b) {
            if (b) {
                if (this.d != null) {
                    this.e(16);
                }
                this.b.setSystemBarsAppearance(16, 16);
            }
            else {
                if (this.d != null) {
                    this.f(16);
                }
                this.b.setSystemBarsAppearance(0, 16);
            }
        }
        
        @Override
        public void c(final boolean b) {
            if (b) {
                if (this.d != null) {
                    this.e(8192);
                }
                this.b.setSystemBarsAppearance(8, 8);
            }
            else {
                if (this.d != null) {
                    this.f(8192);
                }
                this.b.setSystemBarsAppearance(0, 8);
            }
        }
        
        @Override
        void d(final int systemBarsBehavior) {
            this.b.setSystemBarsBehavior(systemBarsBehavior);
        }
        
        protected void e(final int n) {
            final View decorView = this.d.getDecorView();
            decorView.setSystemUiVisibility(n | decorView.getSystemUiVisibility());
        }
        
        protected void f(final int n) {
            final View decorView = this.d.getDecorView();
            decorView.setSystemUiVisibility(~n & decorView.getSystemUiVisibility());
        }
    }
}
