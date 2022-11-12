// 
// Decompiled by Procyon v0.6.0
// 

package y1;

import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import java.net.UnknownServiceException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import java.net.ProtocolException;
import java.io.InterruptedIOException;
import java.nio.channels.ClosedChannelException;
import java.net.SocketException;
import android.graphics.Matrix;
import android.provider.Settings$Global;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import java.io.Closeable;
import q1.s;
import com.airbnb.lottie.c;
import android.graphics.Path;
import android.graphics.PathMeasure;

public final class h
{
    private static final ThreadLocal<PathMeasure> a;
    private static final ThreadLocal<Path> b;
    private static final ThreadLocal<Path> c;
    private static final ThreadLocal<float[]> d;
    private static final float e;
    private static float f;
    
    static {
        a = new ThreadLocal<PathMeasure>() {
            protected PathMeasure a() {
                return new PathMeasure();
            }
            
            @Override
            protected /* bridge */ Object initialValue() {
                return this.a();
            }
        };
        b = new ThreadLocal<Path>() {
            protected Path a() {
                return new Path();
            }
            
            @Override
            protected /* bridge */ Object initialValue() {
                return this.a();
            }
        };
        c = new ThreadLocal<Path>() {
            protected Path a() {
                return new Path();
            }
            
            @Override
            protected /* bridge */ Object initialValue() {
                return this.a();
            }
        };
        d = new ThreadLocal<float[]>() {
            protected float[] a() {
                return new float[4];
            }
            
            @Override
            protected /* bridge */ Object initialValue() {
                return this.a();
            }
        };
        e = (float)(Math.sqrt(2.0) / 2.0);
        h.f = -1.0f;
    }
    
    public static void a(final Path path, float min, float n, float n2) {
        com.airbnb.lottie.c.a("applyTrimPathIfNeeded");
        final PathMeasure pathMeasure = h.a.get();
        final Path path2 = h.b.get();
        final Path path3 = h.c.get();
        pathMeasure.setPath(path, false);
        final float length = pathMeasure.getLength();
        if (min == 1.0f && n == 0.0f) {
            com.airbnb.lottie.c.b("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs(n - min - 1.0f) < 0.01) {
            com.airbnb.lottie.c.b("applyTrimPathIfNeeded");
            return;
        }
        final float n3 = min * length;
        n *= length;
        min = Math.min(n3, n);
        final float max = Math.max(n3, n);
        n2 *= length;
        n = min + n2;
        final float n4 = max + n2;
        n2 = n;
        min = n4;
        if (n >= length) {
            n2 = n;
            min = n4;
            if (n4 >= length) {
                n2 = (float)g.g(n, length);
                min = (float)g.g(n4, length);
            }
        }
        n = n2;
        if (n2 < 0.0f) {
            n = (float)g.g(n2, length);
        }
        n2 = min;
        if (min < 0.0f) {
            n2 = (float)g.g(min, length);
        }
        final float n5 = fcmpl(n, n2);
        if (n5 == 0) {
            path.reset();
            com.airbnb.lottie.c.b("applyTrimPathIfNeeded");
            return;
        }
        min = n;
        if (n5 >= 0) {
            min = n - length;
        }
        path2.reset();
        pathMeasure.getSegment(min, n2, path2, true);
        if (n2 > length) {
            path3.reset();
            pathMeasure.getSegment(0.0f, n2 % length, path3, true);
            path2.addPath(path3);
        }
        else if (min < 0.0f) {
            path3.reset();
            pathMeasure.getSegment(min + length, length, path3, true);
            path2.addPath(path3);
        }
        path.set(path2);
        com.airbnb.lottie.c.b("applyTrimPathIfNeeded");
    }
    
    public static void b(final Path path, final s s) {
        if (s != null) {
            if (!s.j()) {
                a(path, ((r1.c)s.h()).p() / 100.0f, ((r1.c)s.d()).p() / 100.0f, ((r1.c)s.f()).p() / 360.0f);
            }
        }
    }
    
    public static void c(final Closeable closeable) {
        if (closeable == null) {
            goto Label_0016;
        }
        try {
            closeable.close();
            goto Label_0016;
        }
        catch (final RuntimeException ex) {
            throw ex;
        }
        catch (final Exception ex2) {
            goto Label_0016;
        }
    }
    
    public static Path d(final PointF pointF, final PointF pointF2, final PointF pointF3, final PointF pointF4) {
        final Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            final float x = pointF.x;
            final float x2 = pointF3.x;
            final float y = pointF.y;
            final float y2 = pointF3.y;
            final float x3 = pointF2.x;
            final float x4 = pointF4.x;
            final float y3 = pointF2.y;
            path.cubicTo(x2 + x, y + y2, x3 + x4, y3 + pointF4.y, x3, y3);
        }
        else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }
    
    public static float e() {
        if (h.f == -1.0f) {
            h.f = Resources.getSystem().getDisplayMetrics().density;
        }
        return h.f;
    }
    
    public static float f(final Context context) {
        return Settings$Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }
    
    public static float g(final Matrix matrix) {
        final float[] array = h.d.get();
        array[1] = (array[0] = 0.0f);
        array[3] = (array[2] = h.e);
        matrix.mapPoints(array);
        return (float)Math.hypot(array[2] - array[0], array[3] - array[1]);
    }
    
    public static boolean h(final Matrix matrix) {
        final float[] array = h.d.get();
        array[1] = (array[0] = 0.0f);
        array[2] = 37394.73f;
        array[3] = 39575.234f;
        matrix.mapPoints(array);
        return array[0] == array[2] || array[1] == array[3];
    }
    
    public static int i(final float n, final float n2, final float n3, final float n4) {
        int n5;
        if (n != 0.0f) {
            n5 = (int)(527 * n);
        }
        else {
            n5 = 17;
        }
        int n6 = n5;
        if (n2 != 0.0f) {
            n6 = (int)(n5 * 31 * n2);
        }
        int n7 = n6;
        if (n3 != 0.0f) {
            n7 = (int)(n6 * 31 * n3);
        }
        int n8 = n7;
        if (n4 != 0.0f) {
            n8 = (int)(n7 * 31 * n4);
        }
        return n8;
    }
    
    public static boolean j(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        boolean b = false;
        if (n < n4) {
            return false;
        }
        if (n > n4) {
            return true;
        }
        if (n2 < n5) {
            return false;
        }
        if (n2 > n5) {
            return true;
        }
        if (n3 >= n6) {
            b = true;
        }
        return b;
    }
    
    public static boolean k(final Throwable t) {
        return t instanceof SocketException || t instanceof ClosedChannelException || t instanceof InterruptedIOException || t instanceof ProtocolException || t instanceof SSLException || t instanceof UnknownHostException || t instanceof UnknownServiceException;
    }
    
    public static Bitmap l(final Bitmap bitmap, final int n, final int n2) {
        if (bitmap.getWidth() == n && bitmap.getHeight() == n2) {
            return bitmap;
        }
        final Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, n, n2, true);
        bitmap.recycle();
        return scaledBitmap;
    }
    
    public static void m(final Canvas canvas, final RectF rectF, final Paint paint) {
        n(canvas, rectF, paint, 31);
    }
    
    public static void n(final Canvas canvas, final RectF rectF, final Paint paint, final int n) {
        com.airbnb.lottie.c.a("Utils#saveLayer");
        canvas.saveLayer(rectF, paint);
        com.airbnb.lottie.c.b("Utils#saveLayer");
    }
}
