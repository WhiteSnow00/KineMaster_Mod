// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.nio.ByteBuffer;
import java.io.InputStream;
import android.os.ParcelFileDescriptor;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace$Named;
import android.os.Build$VERSION;
import v2.g;
import com.bumptech.glide.load.engine.s;
import c2.e;
import android.graphics.Bitmap$Config;
import java.io.IOException;
import android.util.Log;
import v2.k;
import java.util.EnumSet;
import android.graphics.Bitmap;
import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import e2.b;
import android.util.DisplayMetrics;
import android.graphics.BitmapFactory$Options;
import java.util.Queue;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.Set;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.DecodeFormat;
import c2.d;

public final class l
{
    public static final d<DecodeFormat> f;
    public static final d<PreferredColorSpace> g;
    @Deprecated
    public static final d<DownsampleStrategy> h;
    public static final d<Boolean> i;
    public static final d<Boolean> j;
    private static final Set<String> k;
    private static final b l;
    private static final Set<ImageHeaderParser.ImageType> m;
    private static final Queue<BitmapFactory$Options> n;
    private final e2.d a;
    private final DisplayMetrics b;
    private final e2.b c;
    private final List<ImageHeaderParser> d;
    private final q e;
    
    static {
        f = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
        g = d.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
        h = DownsampleStrategy.h;
        final Boolean false = Boolean.FALSE;
        i = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
        j = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
        k = Collections.unmodifiableSet((Set<? extends String>)new HashSet<String>(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        l = (b)new b() {
            @Override
            public void a(final e2.d d, final Bitmap bitmap) {
            }
            
            @Override
            public void b() {
            }
        };
        m = Collections.unmodifiableSet((Set<? extends ImageHeaderParser.ImageType>)EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        n = v2.l.f(0);
    }
    
    public l(final List<ImageHeaderParser> d, final DisplayMetrics displayMetrics, final e2.d d2, final e2.b b) {
        this.e = q.b();
        this.d = d;
        this.b = v2.k.d(displayMetrics);
        this.a = v2.k.d(d2);
        this.c = v2.k.d(b);
    }
    
    private static int a(final double n) {
        final int l = l(n);
        final int x = x(l * n);
        return x(n / (x / (float)l) * x);
    }
    
    private void b(final r r, final DecodeFormat decodeFormat, final boolean b, boolean b2, final BitmapFactory$Options bitmapFactory$Options, final int n, final int n2) {
        if (this.e.i(n, n2, bitmapFactory$Options, b, b2)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
            b2 = false;
            boolean hasAlpha;
            try {
                hasAlpha = r.d().hasAlpha();
            }
            catch (final IOException ex) {
                hasAlpha = b2;
                if (Log.isLoggable("Downsampler", 3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Cannot determine whether the image has alpha or not from header, format ");
                    sb.append(decodeFormat);
                    Log.d("Downsampler", sb.toString(), (Throwable)ex);
                    hasAlpha = b2;
                }
            }
            Bitmap$Config inPreferredConfig;
            if (hasAlpha) {
                inPreferredConfig = Bitmap$Config.ARGB_8888;
            }
            else {
                inPreferredConfig = Bitmap$Config.RGB_565;
            }
            bitmapFactory$Options.inPreferredConfig = inPreferredConfig;
            if (inPreferredConfig == Bitmap$Config.RGB_565) {
                bitmapFactory$Options.inDither = true;
            }
            return;
        }
        bitmapFactory$Options.inPreferredConfig = Bitmap$Config.ARGB_8888;
    }
    
    private static void c(final ImageHeaderParser.ImageType imageType, final r r, final b b, final e2.d d, final DownsampleStrategy downsampleStrategy, final int n, final int n2, final int n3, final int n4, final int n5, final BitmapFactory$Options bitmapFactory$Options) throws IOException {
        if (n2 <= 0 || n3 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to determine dimensions for: ");
                sb.append(imageType);
                sb.append(" with target [");
                sb.append(n4);
                sb.append("x");
                sb.append(n5);
                sb.append("]");
                Log.d("Downsampler", sb.toString());
            }
            return;
        }
        int n6;
        int n7;
        if (r(n)) {
            n6 = n2;
            n7 = n3;
        }
        else {
            n7 = n2;
            n6 = n3;
        }
        final float b2 = downsampleStrategy.b(n7, n6, n4, n5);
        if (b2 <= 0.0f) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot scale with factor: ");
            sb2.append(b2);
            sb2.append(" from: ");
            sb2.append(downsampleStrategy);
            sb2.append(", source: [");
            sb2.append(n2);
            sb2.append("x");
            sb2.append(n3);
            sb2.append("], target: [");
            sb2.append(n4);
            sb2.append("x");
            sb2.append(n5);
            sb2.append("]");
            throw new IllegalArgumentException(sb2.toString());
        }
        final DownsampleStrategy.SampleSizeRounding a = downsampleStrategy.a(n7, n6, n4, n5);
        if (a != null) {
            final float n8 = (float)n7;
            final int x = x(b2 * n8);
            final float n9 = (float)n6;
            final int x2 = x(b2 * n9);
            final int n10 = n7 / x;
            final int n11 = n6 / x2;
            final DownsampleStrategy.SampleSizeRounding memory = DownsampleStrategy.SampleSizeRounding.MEMORY;
            int n12;
            if (a == memory) {
                n12 = Math.max(n10, n11);
            }
            else {
                n12 = Math.min(n10, n11);
            }
            int max;
            final int n13 = max = Math.max(1, Integer.highestOneBit(n12));
            if (a == memory) {
                max = n13;
                if (n13 < 1.0f / b2) {
                    max = n13 << 1;
                }
            }
            bitmapFactory$Options.inSampleSize = max;
            int round;
            int round2;
            if (imageType == ImageHeaderParser.ImageType.JPEG) {
                final float n14 = (float)Math.min(max, 8);
                final int n15 = (int)Math.ceil(n8 / n14);
                final int n16 = (int)Math.ceil(n9 / n14);
                final int n17 = max / 8;
                round = n16;
                round2 = n15;
                if (n17 > 0) {
                    round2 = n15 / n17;
                    round = n16 / n17;
                }
            }
            else if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                if (imageType.isWebp()) {
                    final float n18 = (float)max;
                    round2 = Math.round(n8 / n18);
                    round = Math.round(n9 / n18);
                }
                else if (n7 % max == 0 && n6 % max == 0) {
                    round2 = n7 / max;
                    round = n6 / max;
                }
                else {
                    final int[] m = m(r, bitmapFactory$Options, b, d);
                    round2 = m[0];
                    round = m[1];
                }
            }
            else {
                final float n19 = (float)max;
                round2 = (int)Math.floor(n8 / n19);
                round = (int)Math.floor(n9 / n19);
            }
            final double n20 = downsampleStrategy.b(round2, round, n4, n5);
            bitmapFactory$Options.inTargetDensity = a(n20);
            bitmapFactory$Options.inDensity = l(n20);
            if (s(bitmapFactory$Options)) {
                bitmapFactory$Options.inScaled = true;
            }
            else {
                bitmapFactory$Options.inTargetDensity = 0;
                bitmapFactory$Options.inDensity = 0;
            }
            if (Log.isLoggable("Downsampler", 2)) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Calculate scaling, source: [");
                sb3.append(n2);
                sb3.append("x");
                sb3.append(n3);
                sb3.append("], degreesToRotate: ");
                sb3.append(n);
                sb3.append(", target: [");
                sb3.append(n4);
                sb3.append("x");
                sb3.append(n5);
                sb3.append("], power of two scaled: [");
                sb3.append(round2);
                sb3.append("x");
                sb3.append(round);
                sb3.append("], exact scale factor: ");
                sb3.append(b2);
                sb3.append(", power of 2 sample size: ");
                sb3.append(max);
                sb3.append(", adjusted scale factor: ");
                sb3.append(n20);
                sb3.append(", target density: ");
                sb3.append(bitmapFactory$Options.inTargetDensity);
                sb3.append(", density: ");
                sb3.append(bitmapFactory$Options.inDensity);
                Log.v("Downsampler", sb3.toString());
            }
            return;
        }
        throw new IllegalArgumentException("Cannot round with null rounding");
    }
    
    private s<Bitmap> e(final r r, final int n, final int n2, final e e, final b b) throws IOException {
        final byte[] inTempStorage = this.c.c(65536, byte[].class);
        final BitmapFactory$Options k = k();
        k.inTempStorage = inTempStorage;
        final DecodeFormat decodeFormat = e.c(com.bumptech.glide.load.resource.bitmap.l.f);
        final PreferredColorSpace preferredColorSpace = e.c(com.bumptech.glide.load.resource.bitmap.l.g);
        final DownsampleStrategy downsampleStrategy = e.c(DownsampleStrategy.h);
        final boolean booleanValue = e.c(com.bumptech.glide.load.resource.bitmap.l.i);
        final d<Boolean> j = com.bumptech.glide.load.resource.bitmap.l.j;
        boolean b2;
        if (e.c((d<Object>)j) != null && e.c(j)) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        try {
            return e.e(this.h(r, k, downsampleStrategy, decodeFormat, preferredColorSpace, b2, n, n2, booleanValue, b), this.a);
        }
        finally {
            v(k);
            this.c.put(inTempStorage);
        }
    }
    
    private Bitmap h(final r r, final BitmapFactory$Options bitmapFactory$Options, final DownsampleStrategy downsampleStrategy, final DecodeFormat decodeFormat, final PreferredColorSpace preferredColorSpace, boolean b, final int n, final int n2, final boolean b2, final b b3) throws IOException {
        final long b4 = v2.g.b();
        final int[] m = m(r, bitmapFactory$Options, b3, this.a);
        final boolean b5 = false;
        final int n3 = m[0];
        final int n4 = m[1];
        final String outMimeType = bitmapFactory$Options.outMimeType;
        if (n3 == -1 || n4 == -1) {
            b = false;
        }
        final int c = r.c();
        final int j = y.j(c);
        final boolean i = y.m(c);
        int n5;
        if (n == Integer.MIN_VALUE) {
            if (r(j)) {
                n5 = n4;
            }
            else {
                n5 = n3;
            }
        }
        else {
            n5 = n;
        }
        int n6;
        if (n2 == Integer.MIN_VALUE) {
            if (r(j)) {
                n6 = n3;
            }
            else {
                n6 = n4;
            }
        }
        else {
            n6 = n2;
        }
        final ImageHeaderParser.ImageType d = r.d();
        c(d, r, b3, this.a, downsampleStrategy, j, n3, n4, n5, n6, bitmapFactory$Options);
        this.b(r, decodeFormat, b, i, bitmapFactory$Options, n5, n6);
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int inSampleSize = bitmapFactory$Options.inSampleSize;
        if (this.z(d)) {
            if (n3 < 0 || n4 < 0 || !b2) {
                float n7;
                if (s(bitmapFactory$Options)) {
                    n7 = bitmapFactory$Options.inTargetDensity / (float)bitmapFactory$Options.inDensity;
                }
                else {
                    n7 = 1.0f;
                }
                final int inSampleSize2 = bitmapFactory$Options.inSampleSize;
                final float n8 = (float)n3;
                final float n9 = (float)inSampleSize2;
                final int n10 = (int)Math.ceil(n8 / n9);
                final int n11 = (int)Math.ceil(n4 / n9);
                final int round = Math.round(n10 * n7);
                final int round2 = Math.round(n11 * n7);
                n5 = round;
                n6 = round2;
                if (Log.isLoggable("Downsampler", 2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Calculated target [");
                    sb.append(round);
                    sb.append("x");
                    sb.append(round2);
                    sb.append("] for source [");
                    sb.append(n3);
                    sb.append("x");
                    sb.append(n4);
                    sb.append("], sampleSize: ");
                    sb.append(inSampleSize2);
                    sb.append(", targetDensity: ");
                    sb.append(bitmapFactory$Options.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(bitmapFactory$Options.inDensity);
                    sb.append(", density multiplier: ");
                    sb.append(n7);
                    Log.v("Downsampler", sb.toString());
                    n6 = round2;
                    n5 = round;
                }
            }
            if (n5 > 0 && n6 > 0) {
                y(bitmapFactory$Options, this.a, n5, n6);
            }
        }
        if (preferredColorSpace != null) {
            if (sdk_INT >= 28) {
                int n12 = b5 ? 1 : 0;
                if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3) {
                    final ColorSpace outColorSpace = bitmapFactory$Options.outColorSpace;
                    n12 = (b5 ? 1 : 0);
                    if (outColorSpace != null) {
                        n12 = (b5 ? 1 : 0);
                        if (outColorSpace.isWideGamut()) {
                            n12 = 1;
                        }
                    }
                }
                ColorSpace$Named colorSpace$Named;
                if (n12 != 0) {
                    colorSpace$Named = ColorSpace$Named.DISPLAY_P3;
                }
                else {
                    colorSpace$Named = ColorSpace$Named.SRGB;
                }
                bitmapFactory$Options.inPreferredColorSpace = ColorSpace.get(colorSpace$Named);
            }
            else {
                bitmapFactory$Options.inPreferredColorSpace = ColorSpace.get(ColorSpace$Named.SRGB);
            }
        }
        final Bitmap k = i(r, bitmapFactory$Options, b3, this.a);
        b3.a(this.a, k);
        if (Log.isLoggable("Downsampler", 2)) {
            t(n3, n4, outMimeType, bitmapFactory$Options, k, n, n2, b4);
        }
        Bitmap n13 = null;
        if (k != null) {
            k.setDensity(this.b.densityDpi);
            final Bitmap bitmap = n13 = y.n(this.a, k, c);
            if (!k.equals(bitmap)) {
                this.a.c(k);
                n13 = bitmap;
            }
        }
        return n13;
    }
    
    private static Bitmap i(final r r, final BitmapFactory$Options bitmapFactory$Options, final b b, final e2.d d) throws IOException {
        if (!bitmapFactory$Options.inJustDecodeBounds) {
            b.b();
            r.b();
        }
        final int outWidth = bitmapFactory$Options.outWidth;
        final int outHeight = bitmapFactory$Options.outHeight;
        final String outMimeType = bitmapFactory$Options.outMimeType;
        y.i().lock();
        try {
            try {
                final Bitmap a = r.a(bitmapFactory$Options);
                y.i().unlock();
                return a;
            }
            finally {}
        }
        catch (final IllegalArgumentException ex) {
            final IOException u = u(ex, outWidth, outHeight, outMimeType, bitmapFactory$Options);
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", (Throwable)u);
            }
            final Bitmap inBitmap = bitmapFactory$Options.inBitmap;
            if (inBitmap != null) {
                try {
                    d.c(inBitmap);
                    bitmapFactory$Options.inBitmap = null;
                    final Bitmap i = i(r, bitmapFactory$Options, b, d);
                    y.i().unlock();
                    return i;
                }
                catch (final IOException ex2) {
                    throw u;
                }
            }
            throw u;
        }
        y.i().unlock();
    }
    
    private static String j(final Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(" (");
        sb.append(bitmap.getAllocationByteCount());
        sb.append(")");
        final String string = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(bitmap.getWidth());
        sb2.append("x");
        sb2.append(bitmap.getHeight());
        sb2.append("] ");
        sb2.append(bitmap.getConfig());
        sb2.append(string);
        return sb2.toString();
    }
    
    private static BitmapFactory$Options k() {
        synchronized (l.class) {
            Object n = com.bumptech.glide.load.resource.bitmap.l.n;
            synchronized (n) {
                final BitmapFactory$Options bitmapFactory$Options = ((Queue<BitmapFactory$Options>)n).poll();
                monitorexit(n);
                n = bitmapFactory$Options;
                if (bitmapFactory$Options == null) {
                    n = new BitmapFactory$Options();
                    w((BitmapFactory$Options)n);
                }
                return (BitmapFactory$Options)n;
            }
        }
    }
    
    private static int l(double n) {
        if (n > 1.0) {
            n = 1.0 / n;
        }
        return (int)Math.round(n * 2.147483647E9);
    }
    
    private static int[] m(final r r, final BitmapFactory$Options bitmapFactory$Options, final b b, final e2.d d) throws IOException {
        bitmapFactory$Options.inJustDecodeBounds = true;
        i(r, bitmapFactory$Options, b, d);
        bitmapFactory$Options.inJustDecodeBounds = false;
        return new int[] { bitmapFactory$Options.outWidth, bitmapFactory$Options.outHeight };
    }
    
    private static String n(final BitmapFactory$Options bitmapFactory$Options) {
        return j(bitmapFactory$Options.inBitmap);
    }
    
    private static boolean r(final int n) {
        return n == 90 || n == 270;
    }
    
    private static boolean s(final BitmapFactory$Options bitmapFactory$Options) {
        final int inTargetDensity = bitmapFactory$Options.inTargetDensity;
        if (inTargetDensity > 0) {
            final int inDensity = bitmapFactory$Options.inDensity;
            if (inDensity > 0 && inTargetDensity != inDensity) {
                return true;
            }
        }
        return false;
    }
    
    private static void t(final int n, final int n2, final String s, final BitmapFactory$Options bitmapFactory$Options, final Bitmap bitmap, final int n3, final int n4, final long n5) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Decoded ");
        sb.append(j(bitmap));
        sb.append(" from [");
        sb.append(n);
        sb.append("x");
        sb.append(n2);
        sb.append("] ");
        sb.append(s);
        sb.append(" with inBitmap ");
        sb.append(n(bitmapFactory$Options));
        sb.append(" for [");
        sb.append(n3);
        sb.append("x");
        sb.append(n4);
        sb.append("], sample size: ");
        sb.append(bitmapFactory$Options.inSampleSize);
        sb.append(", density: ");
        sb.append(bitmapFactory$Options.inDensity);
        sb.append(", target density: ");
        sb.append(bitmapFactory$Options.inTargetDensity);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.append(", duration: ");
        sb.append(v2.g.a(n5));
        Log.v("Downsampler", sb.toString());
    }
    
    private static IOException u(final IllegalArgumentException ex, final int n, final int n2, final String s, final BitmapFactory$Options bitmapFactory$Options) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Exception decoding bitmap, outWidth: ");
        sb.append(n);
        sb.append(", outHeight: ");
        sb.append(n2);
        sb.append(", outMimeType: ");
        sb.append(s);
        sb.append(", inBitmap: ");
        sb.append(n(bitmapFactory$Options));
        return new IOException(sb.toString(), ex);
    }
    
    private static void v(final BitmapFactory$Options bitmapFactory$Options) {
        w(bitmapFactory$Options);
        final Queue<BitmapFactory$Options> n = com.bumptech.glide.load.resource.bitmap.l.n;
        synchronized (n) {
            n.offer(bitmapFactory$Options);
        }
    }
    
    private static void w(final BitmapFactory$Options bitmapFactory$Options) {
        bitmapFactory$Options.inTempStorage = null;
        bitmapFactory$Options.inDither = false;
        bitmapFactory$Options.inScaled = false;
        bitmapFactory$Options.inSampleSize = 1;
        bitmapFactory$Options.inPreferredConfig = null;
        bitmapFactory$Options.inJustDecodeBounds = false;
        bitmapFactory$Options.inDensity = 0;
        bitmapFactory$Options.inTargetDensity = 0;
        bitmapFactory$Options.inPreferredColorSpace = null;
        bitmapFactory$Options.outColorSpace = null;
        bitmapFactory$Options.outConfig = null;
        bitmapFactory$Options.outWidth = 0;
        bitmapFactory$Options.outHeight = 0;
        bitmapFactory$Options.outMimeType = null;
        bitmapFactory$Options.inBitmap = null;
        bitmapFactory$Options.inMutable = true;
    }
    
    private static int x(final double n) {
        return (int)(n + 0.5);
    }
    
    private static void y(final BitmapFactory$Options bitmapFactory$Options, final e2.d d, final int n, final int n2) {
        final Bitmap$Config inPreferredConfig = bitmapFactory$Options.inPreferredConfig;
        if (inPreferredConfig == Bitmap$Config.HARDWARE) {
            return;
        }
        Bitmap$Config outConfig = bitmapFactory$Options.outConfig;
        if (outConfig == null) {
            outConfig = inPreferredConfig;
        }
        bitmapFactory$Options.inBitmap = d.e(n, n2, outConfig);
    }
    
    private boolean z(final ImageHeaderParser.ImageType imageType) {
        return true;
    }
    
    public s<Bitmap> d(final ParcelFileDescriptor parcelFileDescriptor, final int n, final int n2, final e e) throws IOException {
        return this.e(new r.c(parcelFileDescriptor, this.d, this.c), n, n2, e, com.bumptech.glide.load.resource.bitmap.l.l);
    }
    
    public s<Bitmap> f(final InputStream inputStream, final int n, final int n2, final e e, final b b) throws IOException {
        return this.e(new r.b(inputStream, this.d, this.c), n, n2, e, b);
    }
    
    public s<Bitmap> g(final ByteBuffer byteBuffer, final int n, final int n2, final e e) throws IOException {
        return this.e(new r.a(byteBuffer, this.d, this.c), n, n2, e, com.bumptech.glide.load.resource.bitmap.l.l);
    }
    
    public boolean o(final ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }
    
    public boolean p(final InputStream inputStream) {
        return true;
    }
    
    public boolean q(final ByteBuffer byteBuffer) {
        return true;
    }
    
    public interface b
    {
        void a(final e2.d p0, final Bitmap p1) throws IOException;
        
        void b();
    }
}
