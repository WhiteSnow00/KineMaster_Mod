// 
// Decompiled by Procyon v0.6.0
// 

package e2;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;

public class e implements d
{
    @Override
    public void a(final int n) {
    }
    
    @Override
    public void b() {
    }
    
    @Override
    public void c(final Bitmap bitmap) {
        bitmap.recycle();
    }
    
    @Override
    public Bitmap d(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return Bitmap.createBitmap(n, n2, bitmap$Config);
    }
    
    @Override
    public Bitmap e(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return this.d(n, n2, bitmap$Config);
    }
}
