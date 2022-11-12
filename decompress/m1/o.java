// 
// Decompiled by Procyon v0.6.0
// 

package m1;

import androidx.work.b;
import v0.k;
import androidx.room.x0;
import androidx.room.r;
import androidx.room.RoomDatabase;

public final class o implements n
{
    private final RoomDatabase a;
    private final r<m> b;
    private final x0 c;
    private final x0 d;
    
    public o(final RoomDatabase a) {
        this.a = a;
        this.b = new r<m>(this, a) {
            final o a;
            
            public void a(final k k, final m m) {
                final String a = m.a;
                if (a == null) {
                    k.m1(1);
                }
                else {
                    k.E0(1, a);
                }
                final byte[] i = androidx.work.b.k(m.b);
                if (i == null) {
                    k.m1(2);
                }
                else {
                    k.V0(2, i);
                }
            }
            
            public /* bridge */ void bind(final k k, final Object o) {
                this.a(k, (m)o);
            }
            
            public String createQuery() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }
        };
        this.c = new x0(this, a) {
            final o a;
            
            public String createQuery() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.d = new x0(this, a) {
            final o a;
            
            public String createQuery() {
                return "DELETE FROM WorkProgress";
            }
        };
    }
    
    @Override
    public void a(final String s) {
        this.a.assertNotSuspendingTransaction();
        final k acquire = this.c.acquire();
        if (s == null) {
            acquire.m1(1);
        }
        else {
            acquire.E0(1, s);
        }
        this.a.beginTransaction();
        try {
            acquire.C();
            this.a.setTransactionSuccessful();
        }
        finally {
            this.a.endTransaction();
            this.c.release(acquire);
        }
    }
    
    @Override
    public void b(final m m) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(m);
            this.a.setTransactionSuccessful();
        }
        finally {
            this.a.endTransaction();
        }
    }
    
    @Override
    public void deleteAll() {
        this.a.assertNotSuspendingTransaction();
        final k acquire = this.d.acquire();
        this.a.beginTransaction();
        try {
            acquire.C();
            this.a.setTransactionSuccessful();
        }
        finally {
            this.a.endTransaction();
            this.d.release(acquire);
        }
    }
}
