// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import android.graphics.Rect;
import android.graphics.BitmapFactory;
import v2.a;
import java.io.InputStream;
import e2.b;
import java.util.List;
import java.nio.ByteBuffer;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory$Options;

interface r
{
    Bitmap a(final BitmapFactory$Options p0) throws IOException;
    
    void b();
    
    int c() throws IOException;
    
    ImageHeaderParser.ImageType d() throws IOException;
    
    public static final class a implements r
    {
        private final ByteBuffer a;
        private final List<ImageHeaderParser> b;
        private final e2.b c;
        
        a(final ByteBuffer a, final List<ImageHeaderParser> b, final e2.b c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        private InputStream e() {
            return v2.a.g(v2.a.d(this.a));
        }
        
        @Override
        public Bitmap a(final BitmapFactory$Options bitmapFactory$Options) {
            return BitmapFactory.decodeStream(this.e(), (Rect)null, bitmapFactory$Options);
        }
        
        @Override
        public void b() {
        }
        
        @Override
        public int c() throws IOException {
            return com.bumptech.glide.load.a.c(this.b, v2.a.d(this.a), this.c);
        }
        
        @Override
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.g(this.b, v2.a.d(this.a));
        }
    }
    
    public static final class b implements r
    {
        private final k a;
        private final e2.b b;
        private final List<ImageHeaderParser> c;
        
        b(final InputStream inputStream, final List<ImageHeaderParser> list, final e2.b b) {
            this.b = v2.k.d(b);
            this.c = v2.k.d(list);
            this.a = new k(inputStream, b);
        }
        
        @Override
        public Bitmap a(final BitmapFactory$Options bitmapFactory$Options) throws IOException {
            return BitmapFactory.decodeStream(this.a.d(), (Rect)null, bitmapFactory$Options);
        }
        
        @Override
        public void b() {
            this.a.c();
        }
        
        @Override
        public int c() throws IOException {
            return com.bumptech.glide.load.a.b(this.c, this.a.d(), this.b);
        }
        
        @Override
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.f(this.c, this.a.d(), this.b);
        }
    }
    
    public static final class c implements r
    {
        private final e2.b a;
        private final List<ImageHeaderParser> b;
        private final ParcelFileDescriptorRewinder c;
        
        c(final ParcelFileDescriptor parcelFileDescriptor, final List<ImageHeaderParser> list, final e2.b b) {
            this.a = v2.k.d(b);
            this.b = v2.k.d(list);
            this.c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
        
        @Override
        public Bitmap a(final BitmapFactory$Options bitmapFactory$Options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.c.d().getFileDescriptor(), (Rect)null, bitmapFactory$Options);
        }
        
        @Override
        public void b() {
        }
        
        @Override
        public int c() throws IOException {
            return com.bumptech.glide.load.a.a(this.b, this.c, this.a);
        }
        
        @Override
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.e(this.b, this.c, this.a);
        }
    }
}
