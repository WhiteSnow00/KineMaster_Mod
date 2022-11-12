// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import androidx.appcompat.view.b;
import android.app.Dialog;
import android.view.Window$Callback;
import android.view.KeyEvent;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import d.a;
import android.util.TypedValue;
import android.os.Bundle;
import android.content.Context;
import androidx.core.view.g;
import androidx.activity.f;

public class h extends f implements e
{
    private androidx.appcompat.app.f c;
    private final g.a d;
    
    public h(final Context context, final int n) {
        super(context, f(context, n));
        this.d = new androidx.appcompat.app.g(this);
        final androidx.appcompat.app.f e = this.e();
        e.G(f(context, n));
        e.r(null);
    }
    
    private static int f(final Context context, final int n) {
        int resourceId = n;
        if (n == 0) {
            final TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(a.A, typedValue, true);
            resourceId = typedValue.resourceId;
        }
        return resourceId;
    }
    
    @Override
    public void addContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.e().d(view, viewGroup$LayoutParams);
    }
    
    public void dismiss() {
        super.dismiss();
        this.e().s();
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return g.e(this.d, this.getWindow().getDecorView(), (Window$Callback)this, keyEvent);
    }
    
    public androidx.appcompat.app.f e() {
        if (this.c == null) {
            this.c = androidx.appcompat.app.f.h(this, this);
        }
        return this.c;
    }
    
    public <T extends View> T findViewById(final int n) {
        return this.e().i(n);
    }
    
    boolean g(final KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
    
    public boolean h(final int n) {
        return this.e().A(n);
    }
    
    public void invalidateOptionsMenu() {
        this.e().p();
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        this.e().o();
        super.onCreate(bundle);
        this.e().r(bundle);
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        this.e().x();
    }
    
    @Override
    public void onSupportActionModeFinished(final b b) {
    }
    
    @Override
    public void onSupportActionModeStarted(final b b) {
    }
    
    @Override
    public b onWindowStartingSupportActionMode(final b.a a) {
        return null;
    }
    
    @Override
    public void setContentView(final int n) {
        this.e().C(n);
    }
    
    @Override
    public void setContentView(final View view) {
        this.e().D(view);
    }
    
    @Override
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.e().E(view, viewGroup$LayoutParams);
    }
    
    public void setTitle(final int title) {
        super.setTitle(title);
        this.e().H(this.getContext().getString(title));
    }
    
    public void setTitle(final CharSequence title) {
        super.setTitle(title);
        this.e().H(title);
    }
}
