// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import f1.f;
import f1.e;
import m1.b;
import m1.q;
import java.util.Collection;
import androidx.work.WorkInfo;
import java.util.LinkedList;
import java.util.Iterator;
import androidx.work.impl.WorkDatabase;
import f1.i;
import java.util.UUID;
import f1.c;

public abstract class a implements Runnable
{
    private final c a;
    
    public a() {
        this.a = new c();
    }
    
    public static a b(final UUID uuid, final i i) {
        return new a(i, uuid) {
            final i b;
            final UUID c;
            
            @Override
            void h() {
                final WorkDatabase o = this.b.o();
                o.beginTransaction();
                try {
                    this.a(this.b, this.c.toString());
                    o.setTransactionSuccessful();
                    o.endTransaction();
                    this.g(this.b);
                }
                finally {
                    o.endTransaction();
                }
            }
        };
    }
    
    public static a c(final String s, final i i, final boolean b) {
        return new a(i, s, b) {
            final i b;
            final String c;
            final boolean d;
            
            @Override
            void h() {
                final WorkDatabase o = this.b.o();
                o.beginTransaction();
                try {
                    final Iterator<String> iterator = o.l().e(this.c).iterator();
                    while (iterator.hasNext()) {
                        this.a(this.b, iterator.next());
                    }
                    o.setTransactionSuccessful();
                    o.endTransaction();
                    if (this.d) {
                        this.g(this.b);
                    }
                }
                finally {
                    o.endTransaction();
                }
            }
        };
    }
    
    public static a d(final String s, final i i) {
        return new a(i, s) {
            final i b;
            final String c;
            
            @Override
            void h() {
                final WorkDatabase o = this.b.o();
                o.beginTransaction();
                try {
                    final Iterator<String> iterator = o.l().h(this.c).iterator();
                    while (iterator.hasNext()) {
                        this.a(this.b, iterator.next());
                    }
                    o.setTransactionSuccessful();
                    o.endTransaction();
                    this.g(this.b);
                }
                finally {
                    o.endTransaction();
                }
            }
        };
    }
    
    private void f(final WorkDatabase workDatabase, final String s) {
        final q l = workDatabase.l();
        final b d = workDatabase.d();
        final LinkedList list = new LinkedList();
        list.add(s);
        while (!list.isEmpty()) {
            final String s2 = list.remove();
            final WorkInfo.State f = l.f(s2);
            if (f != WorkInfo.State.SUCCEEDED && f != WorkInfo.State.FAILED) {
                l.b(WorkInfo.State.CANCELLED, s2);
            }
            list.addAll(d.a(s2));
        }
    }
    
    void a(final i i, final String s) {
        this.f(i.o(), s);
        i.m().l(s);
        final Iterator<e> iterator = i.n().iterator();
        while (iterator.hasNext()) {
            iterator.next().a(s);
        }
    }
    
    public e1.i e() {
        return this.a;
    }
    
    void g(final i i) {
        f.b(i.i(), i.o(), i.n());
    }
    
    abstract void h();
    
    @Override
    public void run() {
        try {
            this.h();
            this.a.a((e1.i.b)e1.i.a);
        }
        finally {
            final Throwable t;
            this.a.a((e1.i.b)new e1.i.b.a(t));
        }
    }
}
