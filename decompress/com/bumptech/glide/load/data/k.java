// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import java.io.IOException;
import e2.b;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

public final class k implements e<InputStream>
{
    private final RecyclableBufferedInputStream a;
    
    public k(final InputStream inputStream, final b b) {
        (this.a = new RecyclableBufferedInputStream(inputStream, b)).mark(5242880);
    }
    
    @Override
    public /* bridge */ Object a() throws IOException {
        return this.d();
    }
    
    @Override
    public void b() {
        this.a.d();
    }
    
    public void c() {
        this.a.c();
    }
    
    public InputStream d() throws IOException {
        this.a.reset();
        return this.a;
    }
    
    public static final class a implements e.a<InputStream>
    {
        private final b a;
        
        public a(final b a) {
            this.a = a;
        }
        
        @Override
        public Class<InputStream> a() {
            return InputStream.class;
        }
        
        @Override
        public /* bridge */ e b(final Object o) {
            return this.c((InputStream)o);
        }
        
        public e<InputStream> c(final InputStream inputStream) {
            return new k(inputStream, this.a);
        }
    }
}
