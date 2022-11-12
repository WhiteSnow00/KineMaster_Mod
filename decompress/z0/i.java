// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.animation.TypeConverter;
import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class i
{
    static PropertyValuesHolder a(final Property<?, PointF> property, final Path path) {
        return PropertyValuesHolder.ofObject((Property)property, (TypeConverter)null, path);
    }
}
