// 
// Decompiled by Procyon v0.6.0
// 

package s2;

import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.widget.ImageView;

public class g
{
    public <Z> j<ImageView, Z> a(final ImageView imageView, final Class<Z> clazz) {
        if (Bitmap.class.equals(clazz)) {
            return (j<ImageView, Z>)new b(imageView);
        }
        if (Drawable.class.isAssignableFrom(clazz)) {
            return (j<ImageView, Z>)new e(imageView);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unhandled class: ");
        sb.append(clazz);
        sb.append(", try .as*(Class).transcode(ResourceTranscoder)");
        throw new IllegalArgumentException(sb.toString());
    }
}
