// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import androidx.core.os.l;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import androidx.lifecycle.q;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import android.content.Context;
import java.util.Collections;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.List;
import x0.a;

public class EmojiCompatInitializer implements x0.a<Boolean>
{
    @Override
    public List<Class<? extends x0.a<?>>> a() {
        return (List<Class<? extends x0.a<?>>>)Collections.singletonList(ProcessLifecycleInitializer.class);
    }
    
    @Override
    public /* bridge */ Object b(final Context context) {
        return this.c(context);
    }
    
    public Boolean c(final Context context) {
        e.g((e.c)new a(context));
        this.d(context);
        return Boolean.TRUE;
    }
    
    void d(final Context context) {
        final Lifecycle lifecycle = androidx.startup.a.e(context).f((Class<? extends x0.a<r>>)ProcessLifecycleInitializer.class).getLifecycle();
        lifecycle.a(new androidx.lifecycle.e(this, lifecycle) {
            final Lifecycle a;
            final EmojiCompatInitializer b;
            
            @Override
            public void i(final r r) {
                this.b.e();
                this.a.c(this);
            }
        });
    }
    
    void e() {
        androidx.emoji2.text.b.d().postDelayed((Runnable)new c(), 500L);
    }
    
    static class a extends e.c
    {
        protected a(final Context context) {
            super(new EmojiCompatInitializer.b(context));
            ((e.c)this).b(1);
        }
    }
    
    static class b implements g
    {
        private final Context a;
        
        b(final Context context) {
            this.a = context.getApplicationContext();
        }
        
        public static void b(final b b, final h h, final ThreadPoolExecutor threadPoolExecutor) {
            b.d(h, threadPoolExecutor);
        }
        
        private void d(final h h, final ThreadPoolExecutor threadPoolExecutor) {
            this.c(h, threadPoolExecutor);
        }
        
        @Override
        public void a(final h h) {
            final ThreadPoolExecutor b = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            b.execute(new androidx.emoji2.text.f(this, h, b));
        }
        
        void c(final h h, final ThreadPoolExecutor threadPoolExecutor) {
            try {
                final j a = c.a(this.a);
                if (a == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                a.c(threadPoolExecutor);
                ((e.c)a).a().a(new h(this, h, threadPoolExecutor) {
                    final h a;
                    final ThreadPoolExecutor b;
                    final EmojiCompatInitializer.b c;
                    
                    @Override
                    public void a(final Throwable t) {
                        try {
                            this.a.a(t);
                        }
                        finally {
                            this.b.shutdown();
                        }
                    }
                    
                    @Override
                    public void b(final m m) {
                        try {
                            this.a.b(m);
                        }
                        finally {
                            this.b.shutdown();
                        }
                    }
                });
            }
            finally {
                final Throwable t;
                h.a(t);
                threadPoolExecutor.shutdown();
            }
        }
    }
    
    static class c implements Runnable
    {
        @Override
        public void run() {
            try {
                l.a("EmojiCompat.EmojiCompatInitializer.run");
                if (e.h()) {
                    e.b().k();
                }
            }
            finally {
                l.b();
            }
        }
    }
}
