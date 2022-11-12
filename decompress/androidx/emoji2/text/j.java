// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import java.nio.ByteBuffer;
import androidx.core.graphics.n;
import androidx.core.os.l;
import androidx.core.util.h;
import java.util.concurrent.ThreadPoolExecutor;
import android.os.Handler;
import android.database.ContentObserver;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.CancellationSignal;
import android.graphics.Typeface;
import androidx.core.provider.g;
import java.util.concurrent.Executor;
import android.content.Context;

public class j extends c
{
    private static final a j;
    
    static {
        j = new a();
    }
    
    public j(final Context context, final androidx.core.provider.e e) {
        super(new b(context, e, androidx.emoji2.text.j.j));
    }
    
    public j c(final Executor executor) {
        ((b)((c)this).a()).f(executor);
        return this;
    }
    
    public static class a
    {
        public Typeface a(final Context context, final androidx.core.provider.g.b b) throws PackageManager$NameNotFoundException {
            return androidx.core.provider.g.a(context, null, new androidx.core.provider.g.b[] { b });
        }
        
        public androidx.core.provider.g.a b(final Context context, final androidx.core.provider.e e) throws PackageManager$NameNotFoundException {
            return androidx.core.provider.g.b(context, null, e);
        }
        
        public void c(final Context context, final ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }
    
    private static class b implements g
    {
        private final Context a;
        private final androidx.core.provider.e b;
        private final j.a c;
        private final Object d;
        private Handler e;
        private Executor f;
        private ThreadPoolExecutor g;
        h h;
        private ContentObserver i;
        private Runnable j;
        
        b(final Context context, final androidx.core.provider.e b, final j.a c) {
            this.d = new Object();
            androidx.core.util.h.h(context, "Context cannot be null");
            androidx.core.util.h.h(b, "FontRequest cannot be null");
            this.a = context.getApplicationContext();
            this.b = b;
            this.c = c;
        }
        
        private void b() {
            synchronized (this.d) {
                this.h = null;
                final ContentObserver i = this.i;
                if (i != null) {
                    this.c.c(this.a, i);
                    this.i = null;
                }
                final Handler e = this.e;
                if (e != null) {
                    e.removeCallbacks(this.j);
                }
                this.e = null;
                final ThreadPoolExecutor g = this.g;
                if (g != null) {
                    g.shutdown();
                }
                this.f = null;
                this.g = null;
            }
        }
        
        private androidx.core.provider.g.b e() {
            try {
                final androidx.core.provider.g.a b = this.c.b(this.a, this.b);
                if (b.c() != 0) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("fetchFonts failed (");
                    sb.append(b.c());
                    sb.append(")");
                    throw new RuntimeException(sb.toString());
                }
                final androidx.core.provider.g.b[] b2 = b.b();
                if (b2 != null && b2.length != 0) {
                    return b2[0];
                }
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            catch (final PackageManager$NameNotFoundException ex) {
                throw new RuntimeException("provider not found", (Throwable)ex);
            }
        }
        
        @Override
        public void a(final h h) {
            h.h(h, "LoaderCallback cannot be null");
            synchronized (this.d) {
                this.h = h;
                monitorexit(this.d);
                this.d();
            }
        }
        
        void c() {
            final Object d = this.d;
            synchronized (d) {
                if (this.h == null) {
                    return;
                }
                monitorexit(d);
                try {
                    final androidx.core.provider.g.b e = this.e();
                    final int b = e.b();
                    Label_0054: {
                        if (b == 2) {
                            final Object d2 = this.d;
                            monitorenter(d2);
                            while (true) {
                                try {
                                    monitorexit(d2);
                                    break Label_0054;
                                    monitorexit(d2);
                                    throw e;
                                }
                                finally {
                                    continue;
                                }
                                break;
                            }
                        }
                    }
                    if (b == 0) {
                        try {
                            androidx.core.os.l.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            final Typeface a = this.c.a(this.a, e);
                            final ByteBuffer e2 = androidx.core.graphics.n.e(this.a, null, e.d());
                            if (e2 != null && a != null) {
                                final m b2 = androidx.emoji2.text.m.b(a, e2);
                                androidx.core.os.l.b();
                                synchronized (this.d) {
                                    final h h = this.h;
                                    if (h != null) {
                                        h.b(b2);
                                    }
                                    monitorexit(this.d);
                                    this.b();
                                    return;
                                }
                            }
                            throw new RuntimeException("Unable to open file.");
                        }
                        finally {
                            androidx.core.os.l.b();
                        }
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("fetchFonts result is not OK. (");
                    sb.append(b);
                    sb.append(")");
                    throw new RuntimeException(sb.toString());
                }
                finally {
                    synchronized (this.d) {
                        final h h2 = this.h;
                        if (h2 != null) {
                            h2.a((Throwable)d);
                        }
                        monitorexit(this.d);
                        this.b();
                    }
                }
            }
        }
        
        void d() {
            synchronized (this.d) {
                if (this.h == null) {
                    return;
                }
                if (this.f == null) {
                    final ThreadPoolExecutor b = androidx.emoji2.text.b.b("emojiCompat");
                    this.g = b;
                    this.f = b;
                }
                this.f.execute(new k(this));
            }
        }
        
        public void f(final Executor f) {
            synchronized (this.d) {
                this.f = f;
            }
        }
    }
}
