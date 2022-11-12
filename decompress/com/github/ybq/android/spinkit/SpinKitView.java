// 
// Decompiled by Procyon v0.6.0
// 

package com.github.ybq.android.spinkit;

import android.graphics.drawable.Drawable;
import c3.d;
import android.content.res.TypedArray;
import c3.c;
import c3.b;
import c3.a;
import android.util.AttributeSet;
import android.content.Context;
import f3.f;
import android.widget.ProgressBar;

public class SpinKitView extends ProgressBar
{
    private Style a;
    private int b;
    private f c;
    
    public SpinKitView(final Context context, final AttributeSet set) {
        this(context, set, c3.a.a);
    }
    
    public SpinKitView(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, c3.b.a);
    }
    
    public SpinKitView(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, c3.c.a, n, n2);
        this.a = Style.values()[obtainStyledAttributes.getInt(c3.c.c, 0)];
        this.b = obtainStyledAttributes.getColor(c3.c.b, -1);
        obtainStyledAttributes.recycle();
        this.a();
        this.setIndeterminate(true);
    }
    
    private void a() {
        final f a = d.a(this.a);
        a.u(this.b);
        this.setIndeterminateDrawable(a);
    }
    
    public /* bridge */ Drawable getIndeterminateDrawable() {
        return this.getIndeterminateDrawable();
    }
    
    public f getIndeterminateDrawable() {
        return this.c;
    }
    
    public void onScreenStateChanged(final int n) {
        super.onScreenStateChanged(n);
        if (n == 0) {
            final f c = this.c;
            if (c != null) {
                c.stop();
            }
        }
    }
    
    public void onWindowFocusChanged(final boolean b) {
        super.onWindowFocusChanged(b);
        if (b && this.c != null && this.getVisibility() == 0) {
            this.c.start();
        }
    }
    
    public void setColor(final int b) {
        this.b = b;
        final f c = this.c;
        if (c != null) {
            c.u(b);
        }
        this.invalidate();
    }
    
    public void setIndeterminateDrawable(final Drawable drawable) {
        if (drawable instanceof f) {
            this.setIndeterminateDrawable((f)drawable);
            return;
        }
        throw new IllegalArgumentException("this d must be instanceof Sprite");
    }
    
    public void setIndeterminateDrawable(final f f) {
        super.setIndeterminateDrawable((Drawable)f);
        this.c = f;
        if (f.c() == 0) {
            this.c.u(this.b);
        }
        this.onSizeChanged(this.getWidth(), this.getHeight(), this.getWidth(), this.getHeight());
        if (this.getVisibility() == 0) {
            this.c.start();
        }
    }
    
    public void unscheduleDrawable(final Drawable drawable) {
        super.unscheduleDrawable(drawable);
        if (drawable instanceof f) {
            ((f)drawable).stop();
        }
    }
}
