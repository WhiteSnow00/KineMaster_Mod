// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.provider;

import android.net.Uri;
import java.util.concurrent.Executor;
import android.os.Handler;
import android.content.pm.PackageManager$NameNotFoundException;
import androidx.core.graphics.h;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.content.Context;

public class g
{
    public static Typeface a(final Context context, final CancellationSignal cancellationSignal, final b[] array) {
        return h.b(context, cancellationSignal, array, 0);
    }
    
    public static a b(final Context context, final CancellationSignal cancellationSignal, final e e) throws PackageManager$NameNotFoundException {
        return d.e(context, e, cancellationSignal);
    }
    
    public static Typeface c(final Context context, final e e, final int n, final boolean b, final int n2, final Handler handler, final c c) {
        final androidx.core.provider.a a = new androidx.core.provider.a(c, handler);
        if (b) {
            return f.e(context, e, a, n, n2);
        }
        return f.d(context, e, n, null, a);
    }
    
    public static class a
    {
        private final int a;
        private final b[] b;
        
        @Deprecated
        public a(final int a, final b[] b) {
            this.a = a;
            this.b = b;
        }
        
        static a a(final int n, final b[] array) {
            return new a(n, array);
        }
        
        public b[] b() {
            return this.b;
        }
        
        public int c() {
            return this.a;
        }
    }
    
    public static class b
    {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;
        
        @Deprecated
        public b(final Uri uri, final int b, final int c, final boolean d, final int e) {
            this.a = androidx.core.util.h.g(uri);
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
        
        static b a(final Uri uri, final int n, final int n2, final boolean b, final int n3) {
            return new b(uri, n, n2, b, n3);
        }
        
        public int b() {
            return this.e;
        }
        
        public int c() {
            return this.b;
        }
        
        public Uri d() {
            return this.a;
        }
        
        public int e() {
            return this.c;
        }
        
        public boolean f() {
            return this.d;
        }
    }
    
    public static class c
    {
        public void a(final int n) {
            throw null;
        }
        
        public void b(final Typeface typeface) {
            throw null;
        }
    }
}
