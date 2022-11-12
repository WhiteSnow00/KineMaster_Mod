// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.images;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zal;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public final class zae extends zag
{
    private final WeakReference b;
    
    @Override
    protected final void a(final Drawable drawable, final boolean b, final boolean b2, final boolean b3) {
        final ImageView imageView = (ImageView)this.b.get();
        if (imageView != null) {
            if (!b2 && !b3 && imageView instanceof zal) {
                final zal zal = (zal)imageView;
                throw null;
            }
            int n2;
            final int n = n2 = 0;
            if (!b2) {
                if (b) {
                    n2 = n;
                }
                else {
                    n2 = 1;
                }
            }
            Object imageDrawable = drawable;
            if (n2 != 0) {
                final Drawable drawable2 = imageView.getDrawable();
                Drawable zaa;
                if (drawable2 != null) {
                    zaa = drawable2;
                    if (drawable2 instanceof zak) {
                        zaa = ((zak)drawable2).zaa();
                    }
                }
                else {
                    zaa = null;
                }
                imageDrawable = new zak(zaa, drawable);
            }
            imageView.setImageDrawable((Drawable)imageDrawable);
            if (imageView instanceof zal) {
                final zal zal2 = (zal)imageView;
                throw null;
            }
            if (imageDrawable != null && n2 != 0) {
                ((zak)imageDrawable).zab(250);
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zae)) {
            return false;
        }
        final zae zae = (zae)o;
        final ImageView imageView = (ImageView)this.b.get();
        final ImageView imageView2 = (ImageView)zae.b.get();
        return imageView2 != null && imageView != null && Objects.b(imageView2, imageView);
    }
    
    @Override
    public final int hashCode() {
        return 0;
    }
}
