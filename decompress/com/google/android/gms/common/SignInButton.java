// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.RemoteCreator;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.zaaa;
import android.util.Log;
import com.google.android.gms.common.internal.zaz;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.FrameLayout;

public final class SignInButton extends FrameLayout implements View$OnClickListener
{
    private int a;
    private int b;
    private View c;
    private View$OnClickListener d;
    
    private final void b(final Context context) {
        final View c = this.c;
        if (c != null) {
            this.removeView(c);
        }
        try {
            this.c = zaz.a(context, this.a, this.b);
        }
        catch (final RemoteCreator.RemoteCreatorException ex) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            final int a = this.a;
            final int b = this.b;
            final zaaa c2 = new zaaa(context, null);
            c2.a(context.getResources(), a, b);
            this.c = (View)c2;
        }
        this.addView(this.c);
        this.c.setEnabled(this.isEnabled());
        this.c.setOnClickListener((View$OnClickListener)this);
    }
    
    public void a(final int a, final int b) {
        this.a = a;
        this.b = b;
        this.b(this.getContext());
    }
    
    public void onClick(final View view) {
        final View$OnClickListener d = this.d;
        if (d != null && view == this.c) {
            d.onClick((View)this);
        }
    }
    
    public void setColorScheme(final int n) {
        this.a(this.a, n);
    }
    
    public void setEnabled(final boolean b) {
        super.setEnabled(b);
        this.c.setEnabled(b);
    }
    
    public void setOnClickListener(final View$OnClickListener d) {
        this.d = d;
        final View c = this.c;
        if (c != null) {
            c.setOnClickListener((View$OnClickListener)this);
        }
    }
    
    @Deprecated
    public void setScopes(final Scope[] array) {
        this.a(this.a, this.b);
    }
    
    public void setSize(final int n) {
        this.a(n, this.b);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }
}
