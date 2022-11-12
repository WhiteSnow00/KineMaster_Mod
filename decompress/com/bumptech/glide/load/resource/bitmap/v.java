// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.Drawable;
import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import e2.d;
import android.graphics.Bitmap;
import android.net.Uri;
import c2.f;

public class v implements f<Uri, Bitmap>
{
    private final l2.f a;
    private final d b;
    
    public v(final l2.f a, final d b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((Uri)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.d((Uri)o, e);
    }
    
    public s<Bitmap> c(final Uri uri, final int n, final int n2, final e e) {
        final s<Drawable> c = this.a.c(uri, n, n2, e);
        if (c == null) {
            return null;
        }
        return m.a(this.b, c.get(), n, n2);
    }
    
    public boolean d(final Uri uri, final e e) {
        return "android.resource".equals(uri.getScheme());
    }
}
