// 
// Decompiled by Procyon v0.6.0
// 

package o2;

import k2.b;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import com.bumptech.glide.load.engine.s;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.Bitmap;

public class a implements e<Bitmap, byte[]>
{
    private final Bitmap$CompressFormat a;
    private final int b;
    
    public a() {
        this(Bitmap$CompressFormat.JPEG, 100);
    }
    
    public a(final Bitmap$CompressFormat a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public s<byte[]> a(final s<Bitmap> s, final c2.e e) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        s.get().compress(this.a, this.b, (OutputStream)byteArrayOutputStream);
        s.b();
        return new b(byteArrayOutputStream.toByteArray());
    }
}
