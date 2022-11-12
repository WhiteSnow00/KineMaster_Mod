// 
// Decompiled by Procyon v0.6.0
// 

package l2;

import v2.l;
import android.graphics.Bitmap$Config;
import java.io.IOException;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.engine.s;
import c2.e;
import android.graphics.ImageDecoder$Source;
import java.io.InputStream;
import android.graphics.drawable.Drawable;
import java.nio.ByteBuffer;
import c2.f;
import e2.b;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.List;

public final class a
{
    private final List<ImageHeaderParser> a;
    private final e2.b b;
    
    private a(final List<ImageHeaderParser> a, final e2.b b) {
        this.a = a;
        this.b = b;
    }
    
    public static f<ByteBuffer, Drawable> a(final List<ImageHeaderParser> list, final e2.b b) {
        return new b(new a(list, b));
    }
    
    private boolean e(final ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP;
    }
    
    public static f<InputStream, Drawable> f(final List<ImageHeaderParser> list, final e2.b b) {
        return new c(new a(list, b));
    }
    
    s<Drawable> b(final ImageDecoder$Source imageDecoder$Source, final int n, final int n2, final e e) throws IOException {
        final Drawable decodeDrawable = ImageDecoder.decodeDrawable(imageDecoder$Source, (ImageDecoder$OnHeaderDecodedListener)new a(n, n2, e));
        if (decodeDrawable instanceof AnimatedImageDrawable) {
            return new a((AnimatedImageDrawable)decodeDrawable);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Received unexpected drawable type for animated webp, failing: ");
        sb.append(decodeDrawable);
        throw new IOException(sb.toString());
    }
    
    boolean c(final InputStream inputStream) throws IOException {
        return this.e(com.bumptech.glide.load.a.f(this.a, inputStream, this.b));
    }
    
    boolean d(final ByteBuffer byteBuffer) throws IOException {
        return this.e(com.bumptech.glide.load.a.g(this.a, byteBuffer));
    }
    
    private static final class a implements s<Drawable>
    {
        private final AnimatedImageDrawable a;
        
        a(final AnimatedImageDrawable a) {
            this.a = a;
        }
        
        @Override
        public int a() {
            return this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight() * l.i(Bitmap$Config.ARGB_8888) * 2;
        }
        
        @Override
        public void b() {
            this.a.stop();
            this.a.clearAnimationCallbacks();
        }
        
        @Override
        public Class<Drawable> c() {
            return Drawable.class;
        }
        
        public AnimatedImageDrawable d() {
            return this.a;
        }
        
        @Override
        public /* bridge */ Object get() {
            return this.d();
        }
    }
    
    private static final class b implements f<ByteBuffer, Drawable>
    {
        private final a a;
        
        b(final a a) {
            this.a = a;
        }
        
        @Override
        public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
            return this.c((ByteBuffer)o, n, n2, e);
        }
        
        @Override
        public /* bridge */ boolean b(final Object o, final e e) throws IOException {
            return this.d((ByteBuffer)o, e);
        }
        
        public s<Drawable> c(final ByteBuffer byteBuffer, final int n, final int n2, final e e) throws IOException {
            return this.a.b(ImageDecoder.createSource(byteBuffer), n, n2, e);
        }
        
        public boolean d(final ByteBuffer byteBuffer, final e e) throws IOException {
            return this.a.d(byteBuffer);
        }
    }
    
    private static final class c implements f<InputStream, Drawable>
    {
        private final a a;
        
        c(final a a) {
            this.a = a;
        }
        
        @Override
        public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
            return this.c((InputStream)o, n, n2, e);
        }
        
        @Override
        public /* bridge */ boolean b(final Object o, final e e) throws IOException {
            return this.d((InputStream)o, e);
        }
        
        public s<Drawable> c(final InputStream inputStream, final int n, final int n2, final e e) throws IOException {
            return this.a.b(ImageDecoder.createSource(v2.a.b(inputStream)), n, n2, e);
        }
        
        public boolean d(final InputStream inputStream, final e e) throws IOException {
            return this.a.c(inputStream);
        }
    }
}
