// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import d.c;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.Shader$TileMode;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.graphics.d;
import d.a;
import android.content.res.ColorStateList;
import android.content.Context;
import d.e;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;

public final class h
{
    private static final PorterDuff$Mode b;
    private static h c;
    private h0 a;
    
    static {
        b = PorterDuff$Mode.SRC_IN;
    }
    
    static PorterDuff$Mode a() {
        return h.b;
    }
    
    public static h b() {
        synchronized (h.class) {
            if (h.c == null) {
                h();
            }
            return h.c;
        }
    }
    
    public static PorterDuffColorFilter e(final int n, final PorterDuff$Mode porterDuff$Mode) {
        synchronized (h.class) {
            return h0.k(n, porterDuff$Mode);
        }
    }
    
    public static void h() {
        synchronized (h.class) {
            if (h.c == null) {
                (h.c = new h()).a = h0.g();
                h.c.a.t((h0.c)new h0.c() {
                    private final int[] a = { d.e.R, d.e.P, d.e.a };
                    private final int[] b = { d.e.o, d.e.B, d.e.t, d.e.p, d.e.q, d.e.s, d.e.r };
                    private final int[] c = { d.e.O, d.e.Q, d.e.k, d.e.K, d.e.L, d.e.M, d.e.N };
                    private final int[] d = { d.e.w, d.e.i, d.e.v };
                    private final int[] e = { d.e.J, d.e.S };
                    private final int[] f = { d.e.c, d.e.g, d.e.d, d.e.h };
                    
                    private boolean f(final int[] array, final int n) {
                        for (int length = array.length, i = 0; i < length; ++i) {
                            if (array[i] == n) {
                                return true;
                            }
                        }
                        return false;
                    }
                    
                    private ColorStateList g(final Context context) {
                        return this.h(context, 0);
                    }
                    
                    private ColorStateList h(final Context context, final int n) {
                        final int c = m0.c(context, d.a.w);
                        return new ColorStateList(new int[][] { m0.b, m0.e, m0.c, m0.i }, new int[] { m0.b(context, d.a.u), androidx.core.graphics.d.f(c, n), androidx.core.graphics.d.f(c, n), n });
                    }
                    
                    private ColorStateList i(final Context context) {
                        return this.h(context, m0.c(context, d.a.t));
                    }
                    
                    private ColorStateList j(final Context context) {
                        return this.h(context, m0.c(context, d.a.u));
                    }
                    
                    private ColorStateList k(final Context context) {
                        final int[][] array = new int[3][];
                        final int[] array2 = new int[3];
                        final int z = d.a.z;
                        final ColorStateList e = m0.e(context, z);
                        if (e != null && e.isStateful()) {
                            array[0] = m0.b;
                            array2[0] = e.getColorForState(array[0], 0);
                            array[1] = m0.f;
                            array2[1] = m0.c(context, d.a.v);
                            array[2] = m0.i;
                            array2[2] = e.getDefaultColor();
                        }
                        else {
                            array[0] = m0.b;
                            array2[0] = m0.b(context, z);
                            array[1] = m0.f;
                            array2[1] = m0.c(context, d.a.v);
                            array[2] = m0.i;
                            array2[2] = m0.c(context, z);
                        }
                        return new ColorStateList(array, array2);
                    }
                    
                    private LayerDrawable l(final h0 h0, final Context context, int dimensionPixelSize) {
                        dimensionPixelSize = context.getResources().getDimensionPixelSize(dimensionPixelSize);
                        final Drawable i = h0.i(context, d.e.F);
                        final Drawable j = h0.i(context, d.e.G);
                        BitmapDrawable bitmapDrawable;
                        BitmapDrawable bitmapDrawable2;
                        if (i instanceof BitmapDrawable && i.getIntrinsicWidth() == dimensionPixelSize && i.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable = (BitmapDrawable)i;
                            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
                        }
                        else {
                            final Bitmap bitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap$Config.ARGB_8888);
                            final Canvas canvas = new Canvas(bitmap);
                            i.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            i.draw(canvas);
                            bitmapDrawable = new BitmapDrawable(bitmap);
                            bitmapDrawable2 = new BitmapDrawable(bitmap);
                        }
                        bitmapDrawable2.setTileModeX(Shader$TileMode.REPEAT);
                        BitmapDrawable bitmapDrawable3;
                        if (j instanceof BitmapDrawable && j.getIntrinsicWidth() == dimensionPixelSize && j.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable3 = (BitmapDrawable)j;
                        }
                        else {
                            final Bitmap bitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap$Config.ARGB_8888);
                            final Canvas canvas2 = new Canvas(bitmap2);
                            j.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            j.draw(canvas2);
                            bitmapDrawable3 = new BitmapDrawable(bitmap2);
                        }
                        final LayerDrawable layerDrawable = new LayerDrawable(new Drawable[] { (Drawable)bitmapDrawable, (Drawable)bitmapDrawable3, (Drawable)bitmapDrawable2 });
                        layerDrawable.setId(0, 16908288);
                        layerDrawable.setId(1, 16908303);
                        layerDrawable.setId(2, 16908301);
                        return layerDrawable;
                    }
                    
                    private void m(final Drawable drawable, final int n, final PorterDuff$Mode porterDuff$Mode) {
                        Drawable mutate = drawable;
                        if (a0.a(drawable)) {
                            mutate = drawable.mutate();
                        }
                        PorterDuff$Mode a;
                        if ((a = porterDuff$Mode) == null) {
                            a = h.a();
                        }
                        mutate.setColorFilter((ColorFilter)h.e(n, a));
                    }
                    
                    @Override
                    public Drawable a(final h0 h0, final Context context, final int n) {
                        if (n == d.e.j) {
                            return (Drawable)new LayerDrawable(new Drawable[] { h0.i(context, d.e.i), h0.i(context, d.e.k) });
                        }
                        if (n == d.e.y) {
                            return (Drawable)this.l(h0, context, d.d.i);
                        }
                        if (n == d.e.x) {
                            return (Drawable)this.l(h0, context, d.d.j);
                        }
                        if (n == d.e.z) {
                            return (Drawable)this.l(h0, context, d.d.k);
                        }
                        return null;
                    }
                    
                    @Override
                    public ColorStateList b(final Context context, final int n) {
                        if (n == d.e.m) {
                            return e.a.a(context, d.c.e);
                        }
                        if (n == d.e.I) {
                            return e.a.a(context, d.c.h);
                        }
                        if (n == d.e.H) {
                            return this.k(context);
                        }
                        if (n == d.e.f) {
                            return this.j(context);
                        }
                        if (n == d.e.b) {
                            return this.g(context);
                        }
                        if (n == d.e.e) {
                            return this.i(context);
                        }
                        if (n == d.e.D || n == d.e.E) {
                            return e.a.a(context, d.c.g);
                        }
                        if (this.f(this.b, n)) {
                            return m0.e(context, d.a.x);
                        }
                        if (this.f(this.e, n)) {
                            return e.a.a(context, d.c.d);
                        }
                        if (this.f(this.f, n)) {
                            return e.a.a(context, d.c.c);
                        }
                        if (n == d.e.A) {
                            return e.a.a(context, d.c.f);
                        }
                        return null;
                    }
                    
                    @Override
                    public boolean c(final Context context, int n, final Drawable drawable) {
                        PorterDuff$Mode porterDuff$Mode = h.a();
                        final boolean f = this.f(this.a, n);
                        final int n2 = 16842801;
                        int round = 0;
                        boolean b = false;
                        Label_0124: {
                            Label_0033: {
                                if (f) {
                                    n = d.a.x;
                                }
                                else if (this.f(this.c, n)) {
                                    n = d.a.v;
                                }
                                else if (this.f(this.d, n)) {
                                    porterDuff$Mode = PorterDuff$Mode.MULTIPLY;
                                    n = n2;
                                }
                                else {
                                    if (n == d.e.u) {
                                        n = 16842800;
                                        round = Math.round(40.8f);
                                        break Label_0033;
                                    }
                                    if (n != d.e.l) {
                                        round = -1;
                                        b = false;
                                        n = 0;
                                        break Label_0124;
                                    }
                                    n = n2;
                                }
                                round = -1;
                            }
                            b = true;
                        }
                        if (b) {
                            Drawable mutate = drawable;
                            if (a0.a(drawable)) {
                                mutate = drawable.mutate();
                            }
                            mutate.setColorFilter((ColorFilter)h.e(m0.c(context, n), porterDuff$Mode));
                            if (round != -1) {
                                mutate.setAlpha(round);
                            }
                            return true;
                        }
                        return false;
                    }
                    
                    @Override
                    public PorterDuff$Mode d(final int n) {
                        PorterDuff$Mode multiply;
                        if (n == d.e.H) {
                            multiply = PorterDuff$Mode.MULTIPLY;
                        }
                        else {
                            multiply = null;
                        }
                        return multiply;
                    }
                    
                    @Override
                    public boolean e(final Context context, int n, Drawable drawableByLayerId) {
                        if (n == d.e.C) {
                            final LayerDrawable layerDrawable = (LayerDrawable)drawableByLayerId;
                            final Drawable drawableByLayerId2 = layerDrawable.findDrawableByLayerId(16908288);
                            n = d.a.x;
                            this.m(drawableByLayerId2, m0.c(context, n), h.a());
                            this.m(layerDrawable.findDrawableByLayerId(16908303), m0.c(context, n), h.a());
                            this.m(layerDrawable.findDrawableByLayerId(16908301), m0.c(context, d.a.v), h.a());
                            return true;
                        }
                        if (n != d.e.y && n != d.e.x && n != d.e.z) {
                            return false;
                        }
                        final LayerDrawable layerDrawable2 = (LayerDrawable)drawableByLayerId;
                        this.m(layerDrawable2.findDrawableByLayerId(16908288), m0.b(context, d.a.x), h.a());
                        drawableByLayerId = layerDrawable2.findDrawableByLayerId(16908303);
                        n = d.a.v;
                        this.m(drawableByLayerId, m0.c(context, n), h.a());
                        this.m(layerDrawable2.findDrawableByLayerId(16908301), m0.c(context, n), h.a());
                        return true;
                    }
                });
            }
        }
    }
    
    static void i(final Drawable drawable, final p0 p3, final int[] array) {
        h0.v(drawable, p3, array);
    }
    
    public Drawable c(final Context context, final int n) {
        synchronized (this) {
            return this.a.i(context, n);
        }
    }
    
    Drawable d(final Context context, final int n, final boolean b) {
        synchronized (this) {
            return this.a.j(context, n, b);
        }
    }
    
    ColorStateList f(final Context context, final int n) {
        synchronized (this) {
            return this.a.l(context, n);
        }
    }
    
    public void g(final Context context) {
        synchronized (this) {
            this.a.r(context);
        }
    }
}
