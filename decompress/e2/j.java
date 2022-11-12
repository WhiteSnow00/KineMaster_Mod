// 
// Decompiled by Procyon v0.6.0
// 

package e2;

import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import android.util.Log;
import android.graphics.Bitmap;
import java.util.Set;
import android.graphics.Bitmap$Config;

public class j implements d
{
    private static final Bitmap$Config k;
    private final k a;
    private final Set<Bitmap$Config> b;
    private final long c;
    private final a d;
    private long e;
    private long f;
    private int g;
    private int h;
    private int i;
    private int j;
    
    static {
        k = Bitmap$Config.ARGB_8888;
    }
    
    public j(final long n) {
        this(n, l(), k());
    }
    
    j(final long n, final k a, final Set<Bitmap$Config> b) {
        this.c = n;
        this.e = n;
        this.a = a;
        this.b = b;
        this.d = (a)new b();
    }
    
    private static void f(final Bitmap$Config bitmap$Config) {
        if (bitmap$Config != Bitmap$Config.HARDWARE) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot create a mutable Bitmap with config: ");
        sb.append(bitmap$Config);
        sb.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        throw new IllegalArgumentException(sb.toString());
    }
    
    private static Bitmap g(final int n, final int n2, Bitmap$Config k) {
        if (k == null) {
            k = j.k;
        }
        return Bitmap.createBitmap(n, n2, k);
    }
    
    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            this.i();
        }
    }
    
    private void i() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Hits=");
        sb.append(this.g);
        sb.append(", misses=");
        sb.append(this.h);
        sb.append(", puts=");
        sb.append(this.i);
        sb.append(", evictions=");
        sb.append(this.j);
        sb.append(", currentSize=");
        sb.append(this.f);
        sb.append(", maxSize=");
        sb.append(this.e);
        sb.append("\nStrategy=");
        sb.append(this.a);
        Log.v("LruBitmapPool", sb.toString());
    }
    
    private void j() {
        this.q(this.e);
    }
    
    private static Set<Bitmap$Config> k() {
        final HashSet set = new HashSet((Collection<? extends E>)Arrays.asList(Bitmap$Config.values()));
        set.add(null);
        set.remove(Bitmap$Config.HARDWARE);
        return (Set<Bitmap$Config>)Collections.unmodifiableSet((Set<?>)set);
    }
    
    private static k l() {
        return new m();
    }
    
    private Bitmap m(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        synchronized (this) {
            f(bitmap$Config);
            final k a = this.a;
            Bitmap$Config k;
            if (bitmap$Config != null) {
                k = bitmap$Config;
            }
            else {
                k = e2.j.k;
            }
            final Bitmap d = a.d(n, n2, k);
            if (d == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Missing bitmap=");
                    sb.append(this.a.b(n, n2, bitmap$Config));
                    Log.d("LruBitmapPool", sb.toString());
                }
                ++this.h;
            }
            else {
                ++this.g;
                this.f -= this.a.e(d);
                this.d.a(d);
                p(d);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Get bitmap=");
                sb2.append(this.a.b(n, n2, bitmap$Config));
                Log.v("LruBitmapPool", sb2.toString());
            }
            this.h();
            return d;
        }
    }
    
    private static void o(final Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }
    
    private static void p(final Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }
    
    private void q(final long n) {
        synchronized (this) {
            while (this.f > n) {
                final Bitmap removeLast = this.a.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        this.i();
                    }
                    this.f = 0L;
                    return;
                }
                this.d.a(removeLast);
                this.f -= this.a.e(removeLast);
                ++this.j;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    sb.append(this.a.a(removeLast));
                    Log.d("LruBitmapPool", sb.toString());
                }
                this.h();
                removeLast.recycle();
            }
        }
    }
    
    @Override
    public void a(final int n) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(n);
            Log.d("LruBitmapPool", sb.toString());
        }
        if (n < 40 && n < 20) {
            if (n >= 20 || n == 15) {
                this.q(this.n() / 2L);
            }
        }
        else {
            this.b();
        }
    }
    
    @Override
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        this.q(0L);
    }
    
    @Override
    public void c(final Bitmap bitmap) {
        monitorenter(this);
        if (bitmap != null) {
            Label_0301: {
                try {
                    if (bitmap.isRecycled()) {
                        throw new IllegalStateException("Cannot pool recycled bitmap");
                    }
                    if (bitmap.isMutable() && this.a.e(bitmap) <= this.e && this.b.contains(bitmap.getConfig())) {
                        final int e = this.a.e(bitmap);
                        this.a.c(bitmap);
                        this.d.b(bitmap);
                        ++this.i;
                        this.f += e;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Put bitmap in pool=");
                            sb.append(this.a.a(bitmap));
                            Log.v("LruBitmapPool", sb.toString());
                        }
                        this.h();
                        this.j();
                        monitorexit(this);
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Reject bitmap from pool, bitmap: ");
                        sb2.append(this.a.a(bitmap));
                        sb2.append(", is mutable: ");
                        sb2.append(bitmap.isMutable());
                        sb2.append(", is allowed config: ");
                        sb2.append(this.b.contains(bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb2.toString());
                    }
                    bitmap.recycle();
                    monitorexit(this);
                    return;
                }
                finally {
                    break Label_0301;
                }
                throw new NullPointerException("Bitmap must not be null");
            }
            monitorexit(this);
        }
        throw new NullPointerException("Bitmap must not be null");
    }
    
    @Override
    public Bitmap d(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        final Bitmap m = this.m(n, n2, bitmap$Config);
        Bitmap g;
        if (m != null) {
            m.eraseColor(0);
            g = m;
        }
        else {
            g = g(n, n2, bitmap$Config);
        }
        return g;
    }
    
    @Override
    public Bitmap e(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        Bitmap bitmap;
        if ((bitmap = this.m(n, n2, bitmap$Config)) == null) {
            bitmap = g(n, n2, bitmap$Config);
        }
        return bitmap;
    }
    
    public long n() {
        return this.e;
    }
    
    private interface a
    {
        void a(final Bitmap p0);
        
        void b(final Bitmap p0);
    }
    
    private static final class b implements a
    {
        b() {
        }
        
        @Override
        public void a(final Bitmap bitmap) {
        }
        
        @Override
        public void b(final Bitmap bitmap) {
        }
    }
}
