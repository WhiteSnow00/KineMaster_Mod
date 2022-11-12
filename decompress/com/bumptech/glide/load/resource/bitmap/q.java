// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap$Config;
import android.graphics.BitmapFactory$Options;
import java.util.Iterator;
import android.os.Build;
import java.util.Arrays;
import android.util.Log;
import android.os.Build$VERSION;
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.File;

public final class q
{
    public static final boolean g;
    public static final boolean h;
    private static final File i;
    private static volatile q j;
    private static volatile int k;
    private final boolean a;
    private final int b;
    private final int c;
    private int d;
    private boolean e;
    private final AtomicBoolean f;
    
    static {
        g = (Build$VERSION.SDK_INT < 29);
        h = true;
        i = new File("/proc/self/fd");
        q.k = -1;
    }
    
    q() {
        this.e = true;
        this.f = new AtomicBoolean(false);
        this.a = f();
        if (Build$VERSION.SDK_INT >= 28) {
            this.b = 20000;
            this.c = 0;
        }
        else {
            this.b = 700;
            this.c = 128;
        }
    }
    
    private boolean a() {
        return q.g && !this.f.get();
    }
    
    public static q b() {
        if (q.j == null) {
            synchronized (q.class) {
                if (q.j == null) {
                    q.j = new q();
                }
            }
        }
        return q.j;
    }
    
    private int c() {
        int n;
        if (q.k != -1) {
            n = q.k;
        }
        else {
            n = this.b;
        }
        return n;
    }
    
    private boolean d() {
        synchronized (this) {
            int d = this.d;
            boolean e = true;
            ++d;
            this.d = d;
            if (d >= 50) {
                this.d = 0;
                final int length = q.i.list().length;
                final long n = this.c();
                if (length >= n) {
                    e = false;
                }
                this.e = e;
                if (!e && Log.isLoggable("Downsampler", 5)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                    sb.append(length);
                    sb.append(", limit ");
                    sb.append(n);
                    Log.w("Downsampler", sb.toString());
                }
            }
            return this.e;
        }
    }
    
    private static boolean f() {
        return !g() && !h();
    }
    
    private static boolean g() {
        if (Build$VERSION.SDK_INT != 26) {
            return false;
        }
        final Iterator<String> iterator = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
        while (iterator.hasNext()) {
            if (Build.MODEL.startsWith(iterator.next())) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean h() {
        return Build$VERSION.SDK_INT == 27 && Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
    }
    
    public boolean e(final int n, final int n2, final boolean b, final boolean b2) {
        if (!b) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!this.a) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        }
        if (!q.h) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (this.a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (b2) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        final int c = this.c;
        if (n < c) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
            }
            return false;
        }
        if (n2 < c) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
            }
            return false;
        }
        if (!this.d()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
            }
            return false;
        }
        return true;
    }
    
    boolean i(final int n, final int n2, final BitmapFactory$Options bitmapFactory$Options, final boolean b, final boolean b2) {
        final boolean e = this.e(n, n2, b, b2);
        if (e) {
            bitmapFactory$Options.inPreferredConfig = Bitmap$Config.HARDWARE;
            bitmapFactory$Options.inMutable = false;
        }
        return e;
    }
}
