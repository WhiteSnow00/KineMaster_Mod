// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl;

import m1.t;
import m1.q;
import m1.n;
import m1.k;
import m1.e;
import v0.g;
import s0.b;
import w0.c;
import f1.h;
import androidx.room.o0;
import java.util.concurrent.Executor;
import android.content.Context;
import java.util.concurrent.TimeUnit;
import androidx.room.RoomDatabase;

public abstract class WorkDatabase extends RoomDatabase
{
    private static final long a;
    
    static {
        a = TimeUnit.DAYS.toMillis(1L);
    }
    
    public static WorkDatabase c(final Context context, final Executor executor, final boolean b) {
        Object o;
        if (b) {
            o = o0.c(context, WorkDatabase.class).c();
        }
        else {
            o = o0.a(context, WorkDatabase.class, h.d());
            ((a)o).g(new v0.h.c(context) {
                final Context a;
                
                @Override
                public h a(final h.b b) {
                    final h.b.a a = h.b.a(this.a);
                    a.c(b.b).b(b.c).d(true);
                    return new c().a(a.a());
                }
            });
        }
        return (WorkDatabase)((a)o).h(executor).a(e()).b(androidx.work.impl.a.a).b(new androidx.work.impl.a.h(context, 2, 3)).b(androidx.work.impl.a.b).b(androidx.work.impl.a.c).b(new androidx.work.impl.a.h(context, 5, 6)).b(androidx.work.impl.a.d).b(androidx.work.impl.a.e).b(androidx.work.impl.a.f).b(new androidx.work.impl.a.i(context)).b(new androidx.work.impl.a.h(context, 10, 11)).b(androidx.work.impl.a.g).e().d();
    }
    
    static b e() {
        return new b() {
            @Override
            public void c(final g g) {
                super.c(g);
                g.m();
                try {
                    g.z(WorkDatabase.g());
                    g.p();
                }
                finally {
                    g.q();
                }
            }
        };
    }
    
    static long f() {
        return System.currentTimeMillis() - WorkDatabase.a;
    }
    
    static String g() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ");
        sb.append(f());
        sb.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
        return sb.toString();
    }
    
    public abstract m1.b d();
    
    public abstract m1.e h();
    
    public abstract m1.h i();
    
    public abstract k j();
    
    public abstract n k();
    
    public abstract q l();
    
    public abstract t m();
}
