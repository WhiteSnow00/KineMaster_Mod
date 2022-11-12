// 
// Decompiled by Procyon v0.6.0
// 

package n2;

import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import e2.d;
import android.graphics.Bitmap;
import b2.a;
import c2.f;

public final class h implements f<a, Bitmap>
{
    private final d a;
    
    public h(final d a) {
        this.a = a;
    }
    
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((a)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.d((a)o, e);
    }
    
    public s<Bitmap> c(final a a, final int n, final int n2, final e e) {
        return com.bumptech.glide.load.resource.bitmap.e.e(a.b(), this.a);
    }
    
    public boolean d(final a a, final e e) {
        return true;
    }
}
