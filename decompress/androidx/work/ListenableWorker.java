// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work;

import e1.o;
import android.net.Uri;
import java.util.List;
import o1.a;
import java.util.Set;
import android.net.Network;
import java.util.UUID;
import androidx.work.impl.utils.futures.b;
import e1.c;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import androidx.annotation.Keep;
import android.content.Context;

public abstract class ListenableWorker
{
    private Context a;
    private WorkerParameters b;
    private volatile boolean c;
    private boolean d;
    private boolean e;
    
    @Keep
    public ListenableWorker(final Context a, final WorkerParameters b) {
        if (a == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (b != null) {
            this.a = a;
            this.b = b;
            return;
        }
        throw new IllegalArgumentException("WorkerParameters is null");
    }
    
    public final Context getApplicationContext() {
        return this.a;
    }
    
    public Executor getBackgroundExecutor() {
        return this.b.a();
    }
    
    public ListenableFuture<c> getForegroundInfoAsync() {
        final b<Object> t = androidx.work.impl.utils.futures.b.t();
        t.q(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return (ListenableFuture<c>)t;
    }
    
    public final UUID getId() {
        return this.b.c();
    }
    
    public final androidx.work.b getInputData() {
        return this.b.d();
    }
    
    public final Network getNetwork() {
        return this.b.e();
    }
    
    public final int getRunAttemptCount() {
        return this.b.g();
    }
    
    public final Set<String> getTags() {
        return this.b.h();
    }
    
    public o1.a getTaskExecutor() {
        return this.b.i();
    }
    
    public final List<String> getTriggeredContentAuthorities() {
        return this.b.j();
    }
    
    public final List<Uri> getTriggeredContentUris() {
        return this.b.k();
    }
    
    public o getWorkerFactory() {
        return this.b.l();
    }
    
    public boolean isRunInForeground() {
        return this.e;
    }
    
    public final boolean isStopped() {
        return this.c;
    }
    
    public final boolean isUsed() {
        return this.d;
    }
    
    public void onStopped() {
    }
    
    public final ListenableFuture<Void> setForegroundAsync(final c c) {
        this.e = true;
        return this.b.b().a(this.getApplicationContext(), this.getId(), c);
    }
    
    public ListenableFuture<Void> setProgressAsync(final androidx.work.b b) {
        return this.b.f().a(this.getApplicationContext(), this.getId(), b);
    }
    
    public void setRunInForeground(final boolean e) {
        this.e = e;
    }
    
    public final void setUsed() {
        this.d = true;
    }
    
    public abstract ListenableFuture<a> startWork();
    
    public final void stop() {
        this.c = true;
        this.onStopped();
    }
    
    public abstract static class a
    {
        a() {
        }
        
        public static ListenableWorker.a a() {
            return new ListenableWorker.a.a();
        }
        
        public static ListenableWorker.a b() {
            return new b();
        }
        
        public static ListenableWorker.a c() {
            return new c();
        }
        
        public static ListenableWorker.a d(final androidx.work.b b) {
            return new c(b);
        }
        
        public static final class a extends ListenableWorker.a
        {
            private final androidx.work.b a;
            
            public a() {
                this(androidx.work.b.c);
            }
            
            public a(final androidx.work.b a) {
                this.a = a;
            }
            
            public androidx.work.b e() {
                return this.a;
            }
            
            @Override
            public boolean equals(final Object o) {
                return this == o || (o != null && a.class == o.getClass() && this.a.equals(((a)o).a));
            }
            
            @Override
            public int hashCode() {
                return a.class.getName().hashCode() * 31 + this.a.hashCode();
            }
            
            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failure {mOutputData=");
                sb.append(this.a);
                sb.append('}');
                return sb.toString();
            }
        }
        
        public static final class b extends ListenableWorker.a
        {
            @Override
            public boolean equals(final Object o) {
                boolean b = true;
                if (this == o) {
                    return true;
                }
                if (o == null || b.class != o.getClass()) {
                    b = false;
                }
                return b;
            }
            
            @Override
            public int hashCode() {
                return b.class.getName().hashCode();
            }
            
            @Override
            public String toString() {
                return "Retry";
            }
        }
        
        public static final class c extends ListenableWorker.a
        {
            private final androidx.work.b a;
            
            public c() {
                this(androidx.work.b.c);
            }
            
            public c(final androidx.work.b a) {
                this.a = a;
            }
            
            public androidx.work.b e() {
                return this.a;
            }
            
            @Override
            public boolean equals(final Object o) {
                return this == o || (o != null && c.class == o.getClass() && this.a.equals(((c)o).a));
            }
            
            @Override
            public int hashCode() {
                return c.class.getName().hashCode() * 31 + this.a.hashCode();
            }
            
            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder();
                sb.append("Success {mOutputData=");
                sb.append(this.a);
                sb.append('}');
                return sb.toString();
            }
        }
    }
}
