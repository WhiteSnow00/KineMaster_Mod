// 
// Decompiled by Procyon v0.6.0
// 

package f1;

import androidx.work.WorkerParameters;
import java.util.Arrays;
import java.util.UUID;
import androidx.work.impl.utils.ForceStopRunnable;
import o1.b;
import java.util.concurrent.Executor;
import e1.k;
import e1.h;
import android.content.BroadcastReceiver$PendingResult;
import java.util.List;
import androidx.work.impl.WorkDatabase;
import androidx.work.a;
import android.content.Context;
import e1.n;

public class i extends n
{
    private static final String j;
    private static i k;
    private static i l;
    private static final Object m;
    private Context a;
    private a b;
    private WorkDatabase c;
    private o1.a d;
    private List<e> e;
    private d f;
    private n1.e g;
    private boolean h;
    private BroadcastReceiver$PendingResult i;
    
    static {
        j = h.f("WorkManagerImpl");
        i.k = null;
        i.l = null;
        m = new Object();
    }
    
    public i(final Context context, final a a, final o1.a a2) {
        this(context, a, a2, context.getResources().getBoolean(e1.k.a));
    }
    
    public i(final Context context, final a a, final o1.a a2, final WorkDatabase workDatabase) {
        final Context applicationContext = context.getApplicationContext();
        e1.h.e(new h.a(a.j()));
        final List<e> g = this.g(applicationContext, a, a2);
        this.q(context, a, a2, workDatabase, g, new d(context, a, a2, workDatabase, g));
    }
    
    public i(final Context context, final a a, final o1.a a2, final boolean b) {
        this(context, a, a2, WorkDatabase.c(context.getApplicationContext(), a2.c(), b));
    }
    
    public static void e(Context applicationContext, final a a) {
        synchronized (i.m) {
            final i k = i.k;
            if (k != null && i.l != null) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
            }
            if (k == null) {
                applicationContext = applicationContext.getApplicationContext();
                if (i.l == null) {
                    i.l = new i(applicationContext, a, new b(a.l()));
                }
                i.k = i.l;
            }
        }
    }
    
    @Deprecated
    public static i j() {
        synchronized (i.m) {
            final i k = i.k;
            if (k != null) {
                return k;
            }
            return i.l;
        }
    }
    
    public static i k(Context applicationContext) {
        synchronized (i.m) {
            i i;
            if ((i = j()) == null) {
                applicationContext = applicationContext.getApplicationContext();
                if (!(applicationContext instanceof a.c)) {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
                e(applicationContext, ((a.c)applicationContext).a());
                i = k(applicationContext);
            }
            return i;
        }
    }
    
    private void q(Context applicationContext, final a b, final o1.a d, final WorkDatabase c, final List<e> e, final d f) {
        applicationContext = applicationContext.getApplicationContext();
        this.a = applicationContext;
        this.b = b;
        this.d = d;
        this.c = c;
        this.e = e;
        this.f = f;
        this.g = new n1.e(c);
        this.h = false;
        if (!applicationContext.isDeviceProtectedStorage()) {
            this.d.b(new ForceStopRunnable(applicationContext, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }
    
    @Override
    public e1.i a(final String s) {
        final n1.a d = n1.a.d(s, this);
        this.d.b(d);
        return d.e();
    }
    
    @Override
    public e1.i c(final List<? extends androidx.work.d> list) {
        if (!list.isEmpty()) {
            return new g(this, list).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }
    
    public e1.i f(final UUID uuid) {
        final n1.a b = n1.a.b(uuid, this);
        this.d.b(b);
        return b.e();
    }
    
    public List<e> g(final Context context, final a a, final o1.a a2) {
        return Arrays.asList(f1.f.a(context, this), new g1.b(context, a, a2, this));
    }
    
    public Context h() {
        return this.a;
    }
    
    public a i() {
        return this.b;
    }
    
    public n1.e l() {
        return this.g;
    }
    
    public d m() {
        return this.f;
    }
    
    public List<e> n() {
        return this.e;
    }
    
    public WorkDatabase o() {
        return this.c;
    }
    
    public o1.a p() {
        return this.d;
    }
    
    public void r() {
        synchronized (f1.i.m) {
            this.h = true;
            final BroadcastReceiver$PendingResult i = this.i;
            if (i != null) {
                i.finish();
                this.i = null;
            }
        }
    }
    
    public void s() {
        h1.b.b(this.h());
        this.o().l().k();
        f1.f.b(this.i(), this.o(), this.n());
    }
    
    public void t(final BroadcastReceiver$PendingResult i) {
        synchronized (i.m) {
            this.i = i;
            if (this.h) {
                i.finish();
                this.i = null;
            }
        }
    }
    
    public void u(final String s) {
        this.v(s, null);
    }
    
    public void v(final String s, final WorkerParameters.a a) {
        this.d.b(new n1.h(this, s, a));
    }
    
    public void w(final String s) {
        this.d.b(new n1.i(this, s, true));
    }
    
    public void x(final String s) {
        this.d.b(new n1.i(this, s, false));
    }
}
