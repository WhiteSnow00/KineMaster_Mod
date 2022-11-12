// 
// Decompiled by Procyon v0.6.0
// 

package m1;

import java.util.ArrayList;
import java.util.List;
import android.database.Cursor;
import t0.b;
import android.os.CancellationSignal;
import v0.j;
import t0.c;
import androidx.room.t0;
import v0.k;
import androidx.room.x0;
import androidx.room.r;
import androidx.room.RoomDatabase;

public final class i implements h
{
    private final RoomDatabase a;
    private final r<g> b;
    private final x0 c;
    
    public i(final RoomDatabase a) {
        this.a = a;
        this.b = new r<g>(this, a) {
            final i a;
            
            public void a(final k k, final g g) {
                final String a = g.a;
                if (a == null) {
                    k.m1(1);
                }
                else {
                    k.E0(1, a);
                }
                k.U0(2, g.b);
            }
            
            public /* bridge */ void bind(final k k, final Object o) {
                this.a(k, (g)o);
            }
            
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
            }
        };
        this.c = new x0(this, a) {
            final i a;
            
            public String createQuery() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }
    
    @Override
    public g a(final String s) {
        final t0 e = t0.e("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (s == null) {
            e.m1(1);
        }
        else {
            e.E0(1, s);
        }
        this.a.assertNotSuspendingTransaction();
        final RoomDatabase a = this.a;
        g g = null;
        final Cursor c = t0.c.c(a, e, false, null);
        try {
            final int d = t0.b.d(c, "work_spec_id");
            final int d2 = t0.b.d(c, "system_id");
            if (c.moveToFirst()) {
                g = new g(c.getString(d), c.getInt(d2));
            }
            return g;
        }
        finally {
            c.close();
            e.l();
        }
    }
    
    @Override
    public List<String> b() {
        final t0 e = t0.e("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.a.assertNotSuspendingTransaction();
        final Cursor c = t0.c.c(this.a, e, false, null);
        try {
            final ArrayList list = new ArrayList(c.getCount());
            while (c.moveToNext()) {
                list.add((Object)c.getString(0));
            }
            return (List<String>)list;
        }
        finally {
            c.close();
            e.l();
        }
    }
    
    @Override
    public void c(final String s) {
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
    public void d(final g g) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(g);
            this.a.setTransactionSuccessful();
        }
        finally {
            this.a.endTransaction();
        }
    }
}
