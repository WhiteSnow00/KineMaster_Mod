// 
// Decompiled by Procyon v0.6.0
// 

package f2;

import android.util.Log;
import c2.b;
import java.io.IOException;
import java.io.File;

public class e implements a
{
    private final j a;
    private final File b;
    private final long c;
    private final c d;
    private a2.a e;
    
    @Deprecated
    protected e(final File b, final long c) {
        this.d = new c();
        this.b = b;
        this.c = c;
        this.a = new j();
    }
    
    public static a c(final File file, final long n) {
        return new e(file, n);
    }
    
    private a2.a d() throws IOException {
        synchronized (this) {
            if (this.e == null) {
                this.e = a2.a.V(this.b, 1, 1, this.c);
            }
            return this.e;
        }
    }
    
    @Override
    public File a(final c2.b b) {
        final String b2 = this.a.b(b);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Get: Obtained: ");
            sb.append(b2);
            sb.append(" for for Key: ");
            sb.append(b);
            Log.v("DiskLruCacheWrapper", sb.toString());
        }
        final File file = null;
        File a;
        try {
            final a2.a.e m = this.d().M(b2);
            a = file;
            if (m != null) {
                a = m.a(0);
            }
        }
        catch (final IOException ex) {
            a = file;
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", (Throwable)ex);
                a = file;
            }
        }
        return a;
    }
    
    @Override
    public void b(c2.b e, final b b) {
        final String b2 = this.a.b(e);
        this.d.a(b2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Put: Obtained: ");
                sb.append(b2);
                sb.append(" for for Key: ");
                sb.append(e);
                Log.v("DiskLruCacheWrapper", sb.toString());
            }
            try {
                final a2.a d = this.d();
                if (d.M(b2) != null) {
                    return;
                }
                e = (c2.b)d.E(b2);
                if (e != null) {
                    try {
                        if (b.a(((a2.a.c)e).f(0))) {
                            ((a2.a.c)e).e();
                        }
                        return;
                    }
                    finally {
                        ((a2.a.c)e).b();
                    }
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Had two simultaneous puts for: ");
                sb2.append(b2);
                throw new IllegalStateException(sb2.toString());
            }
            catch (final IOException ex) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", (Throwable)ex);
                }
            }
        }
        finally {
            this.d.b(b2);
        }
    }
}
