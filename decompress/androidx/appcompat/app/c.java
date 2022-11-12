// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.content.DialogInterface$OnKeyListener;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.content.DialogInterface$OnClickListener;
import android.widget.ListAdapter;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.os.Bundle;
import android.widget.ListView;
import d.a;
import android.util.TypedValue;
import android.content.Context;

public class c extends h
{
    final AlertController e;
    
    protected c(final Context context, final int n) {
        super(context, j(context, n));
        this.e = new AlertController(this.getContext(), this, this.getWindow());
    }
    
    static int j(final Context context, final int n) {
        if ((n >>> 24 & 0xFF) >= 1) {
            return n;
        }
        final TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(d.a.o, typedValue, true);
        return typedValue.resourceId;
    }
    
    public ListView i() {
        return this.e.d();
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.e.e();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return this.e.f(n, keyEvent) || super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        return this.e.g(n, keyEvent) || super.onKeyUp(n, keyEvent);
    }
    
    @Override
    public void setTitle(final CharSequence title) {
        super.setTitle(title);
        this.e.p(title);
    }
    
    public static class a
    {
        private final AlertController.b a;
        private final int b;
        
        public a(final Context context) {
            this(context, c.j(context, 0));
        }
        
        public a(final Context context, final int b) {
            this.a = new AlertController.b((Context)new ContextThemeWrapper(context, c.j(context, b)));
            this.b = b;
        }
        
        public a a(final ListAdapter w, final DialogInterface$OnClickListener x) {
            final AlertController.b a = this.a;
            a.w = w;
            a.x = x;
            return this;
        }
        
        public a b(final View g) {
            this.a.g = g;
            return this;
        }
        
        public a c(final Drawable d) {
            this.a.d = d;
            return this;
        }
        
        public c create() {
            final c c = new c(this.a.a, this.b);
            this.a.a(c.e);
            c.setCancelable(this.a.r);
            if (this.a.r) {
                c.setCanceledOnTouchOutside(true);
            }
            c.setOnCancelListener(this.a.s);
            c.setOnDismissListener(this.a.t);
            final DialogInterface$OnKeyListener u = this.a.u;
            if (u != null) {
                c.setOnKeyListener(u);
            }
            return c;
        }
        
        public a d(final CharSequence h) {
            this.a.h = h;
            return this;
        }
        
        public a e(final CharSequence[] v, final boolean[] f, final DialogInterface$OnMultiChoiceClickListener j) {
            final AlertController.b a = this.a;
            a.v = v;
            a.J = j;
            a.F = f;
            a.G = true;
            return this;
        }
        
        public a f(final CharSequence l, final DialogInterface$OnClickListener n) {
            final AlertController.b a = this.a;
            a.l = l;
            a.n = n;
            return this;
        }
        
        public a g(final DialogInterface$OnDismissListener t) {
            this.a.t = t;
            return this;
        }
        
        public Context getContext() {
            return this.a.a;
        }
        
        public a h(final DialogInterface$OnKeyListener u) {
            this.a.u = u;
            return this;
        }
        
        public a i(final CharSequence i, final DialogInterface$OnClickListener k) {
            final AlertController.b a = this.a;
            a.i = i;
            a.k = k;
            return this;
        }
        
        public a j(final ListAdapter w, final int i, final DialogInterface$OnClickListener x) {
            final AlertController.b a = this.a;
            a.w = w;
            a.x = x;
            a.I = i;
            a.H = true;
            return this;
        }
        
        public a k(final CharSequence[] v, final int i, final DialogInterface$OnClickListener x) {
            final AlertController.b a = this.a;
            a.v = v;
            a.x = x;
            a.I = i;
            a.H = true;
            return this;
        }
        
        public a l(final int n) {
            final AlertController.b a = this.a;
            a.f = a.a.getText(n);
            return this;
        }
        
        public c m() {
            final c create = this.create();
            create.show();
            return create;
        }
        
        public a setNegativeButton(final int n, final DialogInterface$OnClickListener n2) {
            final AlertController.b a = this.a;
            a.l = a.a.getText(n);
            this.a.n = n2;
            return this;
        }
        
        public a setPositiveButton(final int n, final DialogInterface$OnClickListener k) {
            final AlertController.b a = this.a;
            a.i = a.a.getText(n);
            this.a.k = k;
            return this;
        }
        
        public a setTitle(final CharSequence f) {
            this.a.f = f;
            return this;
        }
        
        public a setView(final View z) {
            final AlertController.b a = this.a;
            a.z = z;
            a.y = 0;
            a.E = false;
            return this;
        }
    }
}
