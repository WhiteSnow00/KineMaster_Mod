// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import android.graphics.Shader;
import android.graphics.BitmapShader;
import android.graphics.Shader$TileMode;
import v2.k;
import android.graphics.Bitmap$Config;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import e2.d;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Bitmap;
import android.graphics.Xfermode;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff$Mode;
import java.util.concurrent.locks.ReentrantLock;
import android.os.Build;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.Set;
import android.graphics.Paint;

public final class y
{
    private static final Paint a;
    private static final Paint b;
    private static final Paint c;
    private static final Set<String> d;
    private static final Lock e;
    
    static {
        a = new Paint(6);
        b = new Paint(7);
        Lock e2;
        if ((d = new HashSet<String>(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"))).contains(Build.MODEL)) {
            e2 = new ReentrantLock();
        }
        else {
            e2 = new c();
        }
        e = e2;
        (c = new Paint(7)).setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff$Mode.SRC_IN));
    }
    
    private static void a(final Bitmap bitmap, final Bitmap bitmap2, final Matrix matrix) {
        final Lock e = y.e;
        e.lock();
        try {
            final Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, y.a);
            e(canvas);
            e.unlock();
        }
        finally {
            y.e.unlock();
        }
    }
    
    public static Bitmap b(final d d, final Bitmap bitmap, final int n, final int n2) {
        if (bitmap.getWidth() == n && bitmap.getHeight() == n2) {
            return bitmap;
        }
        final Matrix matrix = new Matrix();
        final int width = bitmap.getWidth();
        final int height = bitmap.getHeight();
        float n3 = 0.0f;
        float n4;
        float n5;
        if (width * n2 > height * n) {
            n4 = n2 / (float)bitmap.getHeight();
            n3 = (n - bitmap.getWidth() * n4) * 0.5f;
            n5 = 0.0f;
        }
        else {
            n4 = n / (float)bitmap.getWidth();
            n5 = (n2 - bitmap.getHeight() * n4) * 0.5f;
        }
        matrix.setScale(n4, n4);
        matrix.postTranslate((float)(int)(n3 + 0.5f), (float)(int)(n5 + 0.5f));
        final Bitmap d2 = d.d(n, n2, k(bitmap));
        q(bitmap, d2);
        a(bitmap, d2, matrix);
        return d2;
    }
    
    public static Bitmap c(final d d, final Bitmap bitmap, final int n, final int n2) {
        if (bitmap.getWidth() <= n && bitmap.getHeight() <= n2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
            }
            return bitmap;
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
        }
        return f(d, bitmap, n, n2);
    }
    
    public static Bitmap d(final d d, final Bitmap bitmap, int width, int height) {
        final int min = Math.min(width, height);
        final float n = (float)min;
        final float n2 = n / 2.0f;
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        final float n3 = (float)width;
        final float n4 = n / n3;
        final float n5 = (float)height;
        final float max = Math.max(n4, n / n5);
        final float n6 = n3 * max;
        final float n7 = max * n5;
        final float n8 = (n - n6) / 2.0f;
        final float n9 = (n - n7) / 2.0f;
        final RectF rectF = new RectF(n8, n9, n6 + n8, n7 + n9);
        final Bitmap g = g(d, bitmap);
        final Bitmap d2 = d.d(min, min, h(bitmap));
        d2.setHasAlpha(true);
        final Lock e = y.e;
        e.lock();
        try {
            final Canvas canvas = new Canvas(d2);
            canvas.drawCircle(n2, n2, n2, y.b);
            canvas.drawBitmap(g, (Rect)null, rectF, y.c);
            e(canvas);
            e.unlock();
            if (!g.equals(bitmap)) {
                d.c(g);
            }
            return d2;
        }
        finally {
            y.e.unlock();
        }
    }
    
    private static void e(final Canvas canvas) {
        canvas.setBitmap((Bitmap)null);
    }
    
    public static Bitmap f(final d d, final Bitmap bitmap, final int n, final int n2) {
        if (bitmap.getWidth() == n && bitmap.getHeight() == n2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        final float min = Math.min(n / (float)bitmap.getWidth(), n2 / (float)bitmap.getHeight());
        final int round = Math.round(bitmap.getWidth() * min);
        final int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        final Bitmap d2 = d.d((int)(bitmap.getWidth() * min), (int)(bitmap.getHeight() * min), k(bitmap));
        q(bitmap, d2);
        if (Log.isLoggable("TransformationUtils", 2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("request: ");
            sb.append(n);
            sb.append("x");
            sb.append(n2);
            Log.v("TransformationUtils", sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("toFit:   ");
            sb2.append(bitmap.getWidth());
            sb2.append("x");
            sb2.append(bitmap.getHeight());
            Log.v("TransformationUtils", sb2.toString());
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("toReuse: ");
            sb3.append(d2.getWidth());
            sb3.append("x");
            sb3.append(d2.getHeight());
            Log.v("TransformationUtils", sb3.toString());
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("minPct:   ");
            sb4.append(min);
            Log.v("TransformationUtils", sb4.toString());
        }
        final Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, d2, matrix);
        return d2;
    }
    
    private static Bitmap g(final d d, final Bitmap bitmap) {
        final Bitmap$Config h = h(bitmap);
        if (h.equals((Object)bitmap.getConfig())) {
            return bitmap;
        }
        final Bitmap d2 = d.d(bitmap.getWidth(), bitmap.getHeight(), h);
        new Canvas(d2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint)null);
        return d2;
    }
    
    private static Bitmap$Config h(final Bitmap bitmap) {
        if (Bitmap$Config.RGBA_F16.equals((Object)bitmap.getConfig())) {
            return Bitmap$Config.RGBA_F16;
        }
        return Bitmap$Config.ARGB_8888;
    }
    
    public static Lock i() {
        return y.e;
    }
    
    public static int j(int n) {
        switch (n) {
            default: {
                n = 0;
                break;
            }
            case 7:
            case 8: {
                n = 270;
                break;
            }
            case 5:
            case 6: {
                n = 90;
                break;
            }
            case 3:
            case 4: {
                n = 180;
                break;
            }
        }
        return n;
    }
    
    private static Bitmap$Config k(final Bitmap bitmap) {
        Bitmap$Config bitmap$Config;
        if (bitmap.getConfig() != null) {
            bitmap$Config = bitmap.getConfig();
        }
        else {
            bitmap$Config = Bitmap$Config.ARGB_8888;
        }
        return bitmap$Config;
    }
    
    static void l(final int n, final Matrix matrix) {
        switch (n) {
            case 8: {
                matrix.setRotate(-90.0f);
                break;
            }
            case 7: {
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            }
            case 6: {
                matrix.setRotate(90.0f);
                break;
            }
            case 5: {
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            }
            case 4: {
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            }
            case 3: {
                matrix.setRotate(180.0f);
                break;
            }
            case 2: {
                matrix.setScale(-1.0f, 1.0f);
                break;
            }
        }
    }
    
    public static boolean m(final int n) {
        switch (n) {
            default: {
                return false;
            }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: {
                return true;
            }
        }
    }
    
    public static Bitmap n(final d d, final Bitmap bitmap, final int n) {
        if (!m(n)) {
            return bitmap;
        }
        final Matrix matrix = new Matrix();
        l(n, matrix);
        final RectF rectF = new RectF(0.0f, 0.0f, (float)bitmap.getWidth(), (float)bitmap.getHeight());
        matrix.mapRect(rectF);
        final Bitmap d2 = d.d(Math.round(rectF.width()), Math.round(rectF.height()), k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        d2.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, d2, matrix);
        return d2;
    }
    
    public static Bitmap o(final d d, final Bitmap bitmap, final int n) {
        k.a(n > 0, "roundingRadius must be greater than 0.");
        return p(d, bitmap, (b)new b(n) {
            final int a;
            
            @Override
            public void a(final Canvas canvas, final Paint paint, final RectF rectF) {
                final int a = this.a;
                canvas.drawRoundRect(rectF, (float)a, (float)a, paint);
            }
        });
    }
    
    private static Bitmap p(final d d, final Bitmap bitmap, final b b) {
        final Bitmap$Config h = h(bitmap);
        final Bitmap g = g(d, bitmap);
        final Bitmap d2 = d.d(g.getWidth(), g.getHeight(), h);
        d2.setHasAlpha(true);
        final Shader$TileMode clamp = Shader$TileMode.CLAMP;
        final BitmapShader shader = new BitmapShader(g, clamp, clamp);
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader((Shader)shader);
        final RectF rectF = new RectF(0.0f, 0.0f, (float)d2.getWidth(), (float)d2.getHeight());
        final Lock e = y.e;
        e.lock();
        try {
            final Canvas canvas = new Canvas(d2);
            canvas.drawColor(0, PorterDuff$Mode.CLEAR);
            b.a(canvas, paint, rectF);
            e(canvas);
            e.unlock();
            if (!g.equals(bitmap)) {
                d.c(g);
            }
            return d2;
        }
        finally {
            y.e.unlock();
        }
    }
    
    public static void q(final Bitmap bitmap, final Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
    
    private interface b
    {
        void a(final Canvas p0, final Paint p1, final RectF p2);
    }
    
    private static final class c implements Lock
    {
        c() {
        }
        
        @Override
        public void lock() {
        }
        
        @Override
        public void lockInterruptibly() throws InterruptedException {
        }
        
        @Override
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
        
        @Override
        public boolean tryLock() {
            return true;
        }
        
        @Override
        public boolean tryLock(final long n, final TimeUnit timeUnit) throws InterruptedException {
            return true;
        }
        
        @Override
        public void unlock() {
        }
    }
}
