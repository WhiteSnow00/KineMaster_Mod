// 
// Decompiled by Procyon v0.6.0
// 

package n2;

import v2.l;
import java.util.Queue;
import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import android.util.Log;
import android.graphics.Bitmap;
import c2.h;
import android.graphics.Bitmap$Config;
import com.bumptech.glide.load.DecodeFormat;
import v2.g;
import c2.e;
import e2.d;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.List;
import android.content.Context;
import java.nio.ByteBuffer;
import c2.f;

public class a implements f<ByteBuffer, c>
{
    private static final a f;
    private static final b g;
    private final Context a;
    private final List<ImageHeaderParser> b;
    private final b c;
    private final a d;
    private final n2.b e;
    
    static {
        f = new a();
        g = new b();
    }
    
    public a(final Context context, final List<ImageHeaderParser> list, final d d, final e2.b b) {
        this(context, list, d, b, n2.a.g, n2.a.f);
    }
    
    a(final Context context, final List<ImageHeaderParser> b, final d d, final e2.b b2, final b c, final a d2) {
        this.a = context.getApplicationContext();
        this.b = b;
        this.d = d2;
        this.e = new n2.b(d, b2);
        this.c = c;
    }
    
    private n2.e c(final ByteBuffer byteBuffer, final int n, final int n2, final b2.d d, final e e) {
        final long b = v2.g.b();
        try {
            final b2.c d2 = d.d();
            if (d2.b() <= 0 || d2.c() != 0) {
                return null;
            }
            Bitmap$Config bitmap$Config;
            if (e.c(i.a) == DecodeFormat.PREFER_RGB_565) {
                bitmap$Config = Bitmap$Config.RGB_565;
            }
            else {
                bitmap$Config = Bitmap$Config.ARGB_8888;
            }
            final a a = this.d.a(this.e, d2, byteBuffer, e(d2, n, n2));
            a.e(bitmap$Config);
            a.c();
            final Bitmap b2 = a.b();
            if (b2 == null) {
                return null;
            }
            return new n2.e(new c(this.a, a, (h<Bitmap>)j2.c.c(), n, n2, b2));
        }
        finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Decoded GIF from stream in ");
                sb.append(v2.g.a(b));
                Log.v("BufferGifDecoder", sb.toString());
            }
        }
    }
    
    private static int e(final b2.c c, final int n, final int n2) {
        final int min = Math.min(c.a() / n2, c.d() / n);
        int highestOneBit;
        if (min == 0) {
            highestOneBit = 0;
        }
        else {
            highestOneBit = Integer.highestOneBit(min);
        }
        final int max = Math.max(1, highestOneBit);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Downsampling GIF, sampleSize: ");
            sb.append(max);
            sb.append(", target dimens: [");
            sb.append(n);
            sb.append("x");
            sb.append(n2);
            sb.append("], actual dimens: [");
            sb.append(c.d());
            sb.append("x");
            sb.append(c.a());
            sb.append("]");
            Log.v("BufferGifDecoder", sb.toString());
        }
        return max;
    }
    
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.d((ByteBuffer)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.f((ByteBuffer)o, e);
    }
    
    public n2.e d(final ByteBuffer byteBuffer, final int n, final int n2, final e e) {
        final b2.d a = this.c.a(byteBuffer);
        try {
            return this.c(byteBuffer, n, n2, a, e);
        }
        finally {
            this.c.b(a);
        }
    }
    
    public boolean f(final ByteBuffer byteBuffer, final e e) throws IOException {
        return !e.c(i.b) && com.bumptech.glide.load.a.g(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }
    
    static class a
    {
        b2.a a(final b2.a.a a, final b2.c c, final ByteBuffer byteBuffer, final int n) {
            return new b2.e(a, c, byteBuffer, n);
        }
    }
    
    static class b
    {
        private final Queue<b2.d> a;
        
        b() {
            this.a = l.f(0);
        }
        
        b2.d a(final ByteBuffer byteBuffer) {
            synchronized (this) {
                b2.d d;
                if ((d = this.a.poll()) == null) {
                    d = new b2.d();
                }
                return d.q(byteBuffer);
            }
        }
        
        void b(final b2.d d) {
            synchronized (this) {
                d.a();
                this.a.offer(d);
            }
        }
    }
}
