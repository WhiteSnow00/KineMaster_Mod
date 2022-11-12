// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import v2.i;
import v2.d;
import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import e2.b;
import android.graphics.Bitmap;
import java.io.InputStream;
import c2.f;

public class x implements f<InputStream, Bitmap>
{
    private final l a;
    private final b b;
    
    public x(final l a, final b b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((InputStream)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.d((InputStream)o, e);
    }
    
    public s<Bitmap> c(InputStream inputStream, final int n, final int n2, final e e) throws IOException {
        boolean b;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            inputStream = inputStream;
            b = false;
        }
        else {
            inputStream = new RecyclableBufferedInputStream(inputStream, this.b);
            b = true;
        }
        final d c = d.c(inputStream);
        final i i = new i(c);
        final a a = new a((RecyclableBufferedInputStream)inputStream, c);
        try {
            return this.a.f(i, n, n2, e, (l.b)a);
        }
        finally {
            c.d();
            if (b) {
                ((RecyclableBufferedInputStream)inputStream).d();
            }
        }
    }
    
    public boolean d(final InputStream inputStream, final e e) {
        return this.a.p(inputStream);
    }
    
    static class a implements b
    {
        private final RecyclableBufferedInputStream a;
        private final d b;
        
        a(final RecyclableBufferedInputStream a, final d b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void a(final e2.d d, final Bitmap bitmap) throws IOException {
            final IOException a = this.b.a();
            if (a != null) {
                if (bitmap != null) {
                    d.c(bitmap);
                }
                throw a;
            }
        }
        
        @Override
        public void b() {
            this.a.c();
        }
    }
}
