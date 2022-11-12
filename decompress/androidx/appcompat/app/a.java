// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import d.j;
import android.util.AttributeSet;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.appcompat.view.b;
import android.view.KeyEvent;
import android.content.res.Configuration;
import android.content.Context;

public abstract class a
{
    public boolean f() {
        return false;
    }
    
    public abstract boolean g();
    
    public abstract void h(final boolean p0);
    
    public abstract int i();
    
    public abstract Context j();
    
    public boolean k() {
        return false;
    }
    
    public void l(final Configuration configuration) {
    }
    
    void m() {
    }
    
    public abstract boolean n(final int p0, final KeyEvent p1);
    
    public boolean o(final KeyEvent keyEvent) {
        return false;
    }
    
    public boolean p() {
        return false;
    }
    
    public abstract void q(final boolean p0);
    
    public abstract void r(final boolean p0);
    
    public abstract void s(final boolean p0);
    
    public abstract void t(final CharSequence p0);
    
    public androidx.appcompat.view.b u(final androidx.appcompat.view.b.a a) {
        return null;
    }
    
    public static class a extends ViewGroup$MarginLayoutParams
    {
        public int a;
        
        public a(final int n, final int n2) {
            super(n, n2);
            this.a = 8388627;
        }
        
        public a(final Context context, final AttributeSet set) {
            super(context, set);
            this.a = 0;
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, j.t);
            this.a = obtainStyledAttributes.getInt(j.u, 0);
            obtainStyledAttributes.recycle();
        }
        
        public a(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.a = 0;
        }
        
        public a(final a a) {
            super((ViewGroup$MarginLayoutParams)a);
            this.a = 0;
            this.a = a.a;
        }
    }
    
    public interface b
    {
        void a(final boolean p0);
    }
    
    @Deprecated
    public abstract static class c
    {
        public abstract CharSequence a();
        
        public abstract View b();
        
        public abstract Drawable c();
        
        public abstract CharSequence d();
        
        public abstract void e();
    }
}
