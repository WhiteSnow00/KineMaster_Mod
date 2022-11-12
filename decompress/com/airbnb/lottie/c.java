// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie;

import w1.b;
import java.io.File;
import android.content.Context;
import androidx.core.os.l;
import w1.f;
import w1.g;
import w1.d;
import w1.e;

public class c
{
    public static boolean a = false;
    private static boolean b = false;
    private static String[] c;
    private static long[] d;
    private static int e;
    private static int f;
    private static e g;
    private static d h;
    private static volatile g i;
    private static volatile f j;
    
    public static void a(final String s) {
        if (!com.airbnb.lottie.c.b) {
            return;
        }
        final int e = com.airbnb.lottie.c.e;
        if (e == 20) {
            ++com.airbnb.lottie.c.f;
            return;
        }
        com.airbnb.lottie.c.c[e] = s;
        com.airbnb.lottie.c.d[e] = System.nanoTime();
        l.a(s);
        ++com.airbnb.lottie.c.e;
    }
    
    public static float b(final String s) {
        final int f = com.airbnb.lottie.c.f;
        if (f > 0) {
            com.airbnb.lottie.c.f = f - 1;
            return 0.0f;
        }
        if (!com.airbnb.lottie.c.b) {
            return 0.0f;
        }
        final int e = com.airbnb.lottie.c.e - 1;
        if ((com.airbnb.lottie.c.e = e) == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (s.equals(com.airbnb.lottie.c.c[e])) {
            l.b();
            return (System.nanoTime() - com.airbnb.lottie.c.d[com.airbnb.lottie.c.e]) / 1000000.0f;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unbalanced trace call ");
        sb.append(s);
        sb.append(". Expected ");
        sb.append(com.airbnb.lottie.c.c[com.airbnb.lottie.c.e]);
        sb.append(".");
        throw new IllegalStateException(sb.toString());
    }
    
    public static f c(final Context context) {
        f j;
        if ((j = com.airbnb.lottie.c.j) == null) {
            synchronized (f.class) {
                if ((j = com.airbnb.lottie.c.j) == null) {
                    j = new(w1.f.class)();
                    final d h = com.airbnb.lottie.c.h;
                    d d;
                    if (h != null) {
                        d = h;
                    }
                    else {
                        d = new d(context) {
                            final Context a;
                            
                            @Override
                            public File a() {
                                return new File(this.a.getCacheDir(), "lottie_network_cache");
                            }
                        };
                    }
                    new f(d);
                    com.airbnb.lottie.c.j = j;
                }
            }
        }
        return j;
    }
    
    public static g d(final Context context) {
        g i;
        if ((i = com.airbnb.lottie.c.i) == null) {
            synchronized (g.class) {
                if ((i = com.airbnb.lottie.c.i) == null) {
                    i = new(w1.g.class)();
                    final f c = c(context);
                    e g = com.airbnb.lottie.c.g;
                    if (g == null) {
                        g = new b();
                    }
                    new g(c, g);
                    com.airbnb.lottie.c.i = i;
                }
            }
        }
        return i;
    }
}
