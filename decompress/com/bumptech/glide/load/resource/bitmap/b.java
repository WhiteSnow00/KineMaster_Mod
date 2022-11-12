// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.s;
import java.io.File;
import com.bumptech.glide.load.EncodeStrategy;
import c2.e;
import android.graphics.Bitmap;
import e2.d;
import android.graphics.drawable.BitmapDrawable;
import c2.g;

public class b implements g<BitmapDrawable>
{
    private final d a;
    private final g<Bitmap> b;
    
    public b(final d a, final g<Bitmap> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public EncodeStrategy a(final e e) {
        return this.b.a(e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final File file, final e e) {
        return this.c((s<BitmapDrawable>)o, file, e);
    }
    
    public boolean c(final s<BitmapDrawable> s, final File file, final e e) {
        return this.b.b(new com.bumptech.glide.load.resource.bitmap.e(s.get().getBitmap(), this.a), file, e);
    }
}
