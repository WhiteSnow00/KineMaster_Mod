// 
// Decompiled by Procyon v0.6.0
// 

package o2;

import com.bumptech.glide.load.resource.bitmap.t;
import com.bumptech.glide.load.engine.s;
import v2.k;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Bitmap;

public class b implements e<Bitmap, BitmapDrawable>
{
    private final Resources a;
    
    public b(final Resources resources) {
        this.a = k.d(resources);
    }
    
    @Override
    public s<BitmapDrawable> a(final s<Bitmap> s, final c2.e e) {
        return t.e(this.a, s);
    }
}
