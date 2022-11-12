// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.images;

import com.google.android.gms.common.internal.Objects;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public final class zaf extends zag
{
    private final WeakReference b;
    
    @Override
    protected final void a(final Drawable drawable, final boolean b, final boolean b2, final boolean b3) {
        if (!b2 && this.b.get() != null) {
            throw null;
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zaf)) {
            return false;
        }
        final zaf zaf = (zaf)o;
        final ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener)this.b.get();
        final ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener)zaf.b.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && Objects.b(onImageLoadedListener2, onImageLoadedListener) && Objects.b(null, null);
    }
    
    @Override
    public final int hashCode() {
        return Objects.c(null);
    }
}
