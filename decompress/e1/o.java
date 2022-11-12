// 
// Decompiled by Procyon v0.6.0
// 

package e1;

import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import android.content.Context;

public abstract class o
{
    private static final String a;
    
    static {
        a = h.f("WorkerFactory");
    }
    
    public static o c() {
        return new o() {
            @Override
            public ListenableWorker a(final Context context, final String s, final WorkerParameters workerParameters) {
                return null;
            }
        };
    }
    
    public abstract ListenableWorker a(final Context p0, final String p1, final WorkerParameters p2);
    
    public final ListenableWorker b(final Context context, final String s, final WorkerParameters workerParameters) {
        ListenableWorker a;
        final ListenableWorker listenableWorker = a = this.a(context, s, workerParameters);
        if (listenableWorker == null) {
            Class<? extends ListenableWorker> subclass = null;
            try {
                subclass = Class.forName(s).asSubclass(ListenableWorker.class);
            }
            finally {
                final h c = h.c();
                final String a2 = o.a;
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid class: ");
                sb.append(s);
                final Throwable t;
                c.b(a2, sb.toString(), t);
            }
            a = listenableWorker;
            if (subclass != null) {
                try {
                    final ListenableWorker listenableWorker2 = (ListenableWorker)subclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                }
                finally {
                    final h c2 = h.c();
                    final String a3 = o.a;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Could not instantiate ");
                    sb2.append(s);
                    final Throwable t2;
                    c2.b(a3, sb2.toString(), t2);
                    a = listenableWorker;
                }
            }
        }
        if (a != null && a.isUsed()) {
            throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", this.getClass().getName(), s));
        }
        return a;
    }
}
