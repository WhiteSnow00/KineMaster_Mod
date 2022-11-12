// 
// Decompiled by Procyon v0.6.0
// 

package f2;

import android.util.DisplayMetrics;
import android.text.format.Formatter;
import android.app.ActivityManager;
import android.util.Log;
import android.content.Context;

public final class i
{
    private final int a;
    private final int b;
    private final Context c;
    private final int d;
    
    i(final a a) {
        this.c = a.a;
        int h;
        if (e(a.b)) {
            h = a.h / 2;
        }
        else {
            h = a.h;
        }
        this.d = h;
        final int c = c(a.b, a.f, a.g);
        final float n = (float)(a.c.b() * a.c.a() * 4);
        final int round = Math.round(a.e * n);
        final int round2 = Math.round(n * a.d);
        final int n2 = c - h;
        final int n3 = round2 + round;
        if (n3 <= n2) {
            this.b = round2;
            this.a = round;
        }
        else {
            final float n4 = (float)n2;
            final float e = a.e;
            final float d = a.d;
            final float n5 = n4 / (e + d);
            this.b = Math.round(d * n5);
            this.a = Math.round(n5 * a.e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(this.f(this.b));
            sb.append(", pool size: ");
            sb.append(this.f(this.a));
            sb.append(", byte array size: ");
            sb.append(this.f(h));
            sb.append(", memory class limited? ");
            sb.append(n3 > c);
            sb.append(", max size: ");
            sb.append(this.f(c));
            sb.append(", memoryClass: ");
            sb.append(a.b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(a.b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }
    
    private static int c(final ActivityManager activityManager, float n, final float n2) {
        final int memoryClass = activityManager.getMemoryClass();
        final boolean e = e(activityManager);
        final float n3 = (float)(memoryClass * 1024 * 1024);
        if (e) {
            n = n2;
        }
        return Math.round(n3 * n);
    }
    
    static boolean e(final ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
    
    private String f(final int n) {
        return Formatter.formatFileSize(this.c, (long)n);
    }
    
    public int a() {
        return this.d;
    }
    
    public int b() {
        return this.a;
    }
    
    public int d() {
        return this.b;
    }
    
    public static final class a
    {
        static final int i;
        final Context a;
        ActivityManager b;
        c c;
        float d;
        float e;
        float f;
        float g;
        int h;
        
        static {
            i = 1;
        }
        
        public a(final Context a) {
            this.d = 2.0f;
            this.e = (float)a.i;
            this.f = 0.4f;
            this.g = 0.33f;
            this.h = 4194304;
            this.a = a;
            this.b = (ActivityManager)a.getSystemService("activity");
            this.c = new b(a.getResources().getDisplayMetrics());
            if (f2.i.e(this.b)) {
                this.e = 0.0f;
            }
        }
        
        public i a() {
            return new i(this);
        }
    }
    
    private static final class b implements c
    {
        private final DisplayMetrics a;
        
        b(final DisplayMetrics a) {
            this.a = a;
        }
        
        @Override
        public int a() {
            return this.a.heightPixels;
        }
        
        @Override
        public int b() {
            return this.a.widthPixels;
        }
    }
    
    interface c
    {
        int a();
        
        int b();
    }
}
