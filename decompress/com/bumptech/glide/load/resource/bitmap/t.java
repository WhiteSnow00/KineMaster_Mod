// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import v2.k;
import android.graphics.Bitmap;
import android.content.res.Resources;
import com.bumptech.glide.load.engine.o;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.s;

public final class t implements s<BitmapDrawable>, o
{
    private final Resources a;
    private final s<Bitmap> b;
    
    private t(final Resources resources, final s<Bitmap> s) {
        this.a = k.d(resources);
        this.b = k.d(s);
    }
    
    public static s<BitmapDrawable> e(final Resources resources, final s<Bitmap> s) {
        if (s == null) {
            return null;
        }
        return new t(resources, s);
    }
    
    @Override
    public int a() {
        return this.b.a();
    }
    
    @Override
    public void b() {
        this.b.b();
    }
    
    @Override
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }
    
    public BitmapDrawable d() {
        return new BitmapDrawable(this.a, (Bitmap)this.b.get());
    }
    
    @Override
    public /* bridge */ Object get() {
        return this.d();
    }
    
    @Override
    public void initialize() {
        final s<Bitmap> b = this.b;
        if (b instanceof o) {
            ((o)b).initialize();
        }
    }
}
