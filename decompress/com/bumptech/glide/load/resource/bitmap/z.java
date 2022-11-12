// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import v2.l;
import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import android.graphics.Bitmap;
import c2.f;

public final class z implements f<Bitmap, Bitmap>
{
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((Bitmap)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.d((Bitmap)o, e);
    }
    
    public s<Bitmap> c(final Bitmap bitmap, final int n, final int n2, final e e) {
        return new a(bitmap);
    }
    
    public boolean d(final Bitmap bitmap, final e e) {
        return true;
    }
    
    private static final class a implements s<Bitmap>
    {
        private final Bitmap a;
        
        a(final Bitmap a) {
            this.a = a;
        }
        
        @Override
        public int a() {
            return l.h(this.a);
        }
        
        @Override
        public void b() {
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
    }
}
