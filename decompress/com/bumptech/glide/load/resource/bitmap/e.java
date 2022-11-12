// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import v2.l;
import v2.k;
import e2.d;
import com.bumptech.glide.load.engine.o;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.s;

public class e implements s<Bitmap>, o
{
    private final Bitmap a;
    private final d b;
    
    public e(final Bitmap bitmap, final d d) {
        this.a = k.e(bitmap, "Bitmap must not be null");
        this.b = k.e(d, "BitmapPool must not be null");
    }
    
    public static e e(final Bitmap bitmap, final d d) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, d);
    }
    
    @Override
    public int a() {
        return l.h(this.a);
    }
    
    @Override
    public void b() {
        this.b.c(this.a);
    }
    
    @Override
    public Class<Bitmap> c() {
        return Bitmap.class;
    }
    
    public Bitmap d() {
        return this.a;
    }
    
    @Override
    public /* bridge */ Object get() {
        return this.d();
    }
    
    @Override
    public void initialize() {
        this.a.prepareToDraw();
    }
}
