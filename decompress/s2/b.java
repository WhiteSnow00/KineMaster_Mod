// 
// Decompiled by Procyon v0.6.0
// 

package s2;

import android.widget.ImageView;
import android.graphics.Bitmap;

public class b extends f<Bitmap>
{
    public b(final ImageView imageView) {
        super(imageView);
    }
    
    @Override
    protected /* bridge */ void h(final Object o) {
        this.j((Bitmap)o);
    }
    
    protected void j(final Bitmap imageBitmap) {
        ((ImageView)super.a).setImageBitmap(imageBitmap);
    }
}
