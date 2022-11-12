// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.net.Uri;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.view.View;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.ImageButton;

public class l extends ImageButton
{
    private final d a;
    private final m b;
    private boolean c;
    
    public l(final Context context) {
        this(context, null);
    }
    
    public l(final Context context, final AttributeSet set) {
        this(context, set, d.a.D);
    }
    
    public l(final Context context, final AttributeSet set, final int n) {
        super(o0.b(context), set, n);
        this.c = false;
        m0.a((View)this, this.getContext());
        (this.a = new d((View)this)).e(set, n);
        (this.b = new m((ImageView)this)).g(set, n);
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final d a = this.a;
        if (a != null) {
            a.b();
        }
        final m b = this.b;
        if (b != null) {
            b.c();
        }
    }
    
    public ColorStateList getSupportBackgroundTintList() {
        final d a = this.a;
        ColorStateList c;
        if (a != null) {
            c = a.c();
        }
        else {
            c = null;
        }
        return c;
    }
    
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        final d a = this.a;
        PorterDuff$Mode d;
        if (a != null) {
            d = a.d();
        }
        else {
            d = null;
        }
        return d;
    }
    
    public ColorStateList getSupportImageTintList() {
        final m b = this.b;
        ColorStateList d;
        if (b != null) {
            d = b.d();
        }
        else {
            d = null;
        }
        return d;
    }
    
    public PorterDuff$Mode getSupportImageTintMode() {
        final m b = this.b;
        PorterDuff$Mode e;
        if (b != null) {
            e = b.e();
        }
        else {
            e = null;
        }
        return e;
    }
    
    public boolean hasOverlappingRendering() {
        return this.b.f() && super.hasOverlappingRendering();
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        final d a = this.a;
        if (a != null) {
            a.f(backgroundDrawable);
        }
    }
    
    public void setBackgroundResource(final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        final d a = this.a;
        if (a != null) {
            a.g(backgroundResource);
        }
    }
    
    public void setImageBitmap(final Bitmap imageBitmap) {
        super.setImageBitmap(imageBitmap);
        final m b = this.b;
        if (b != null) {
            b.c();
        }
    }
    
    public void setImageDrawable(final Drawable imageDrawable) {
        final m b = this.b;
        if (b != null && imageDrawable != null && !this.c) {
            b.h(imageDrawable);
        }
        super.setImageDrawable(imageDrawable);
        final m b2 = this.b;
        if (b2 != null) {
            b2.c();
            if (!this.c) {
                this.b.b();
            }
        }
    }
    
    public void setImageLevel(final int imageLevel) {
        super.setImageLevel(imageLevel);
        this.c = true;
    }
    
    public void setImageResource(final int n) {
        this.b.i(n);
    }
    
    public void setImageURI(final Uri imageURI) {
        super.setImageURI(imageURI);
        final m b = this.b;
        if (b != null) {
            b.c();
        }
    }
    
    public void setSupportBackgroundTintList(final ColorStateList list) {
        final d a = this.a;
        if (a != null) {
            a.i(list);
        }
    }
    
    public void setSupportBackgroundTintMode(final PorterDuff$Mode porterDuff$Mode) {
        final d a = this.a;
        if (a != null) {
            a.j(porterDuff$Mode);
        }
    }
    
    public void setSupportImageTintList(final ColorStateList list) {
        final m b = this.b;
        if (b != null) {
            b.j(list);
        }
    }
    
    public void setSupportImageTintMode(final PorterDuff$Mode porterDuff$Mode) {
        final m b = this.b;
        if (b != null) {
            b.k(porterDuff$Mode);
        }
    }
}
