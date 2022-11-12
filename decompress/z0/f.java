// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.animation.TypeConverter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class f
{
    static <T> ObjectAnimator a(final T t, final Property<T, PointF> property, final Path path) {
        return ObjectAnimator.ofObject((Object)t, (Property)property, (TypeConverter)null, path);
    }
}
