// 
// Decompiled by Procyon v0.6.0
// 

package m1;

import android.database.Cursor;
import java.util.ArrayList;
import android.os.CancellationSignal;
import v0.j;
import t0.c;
import androidx.room.t0;
import java.util.List;
import v0.k;
import androidx.room.r;
import androidx.room.RoomDatabase;

public final class u implements t
{
    private final RoomDatabase a;
    private final r<s> b;
    
    public u(final RoomDatabase a) {
        this.a = a;
        this.b = new r<s>(this, a) {
            final u a;
            
            public void a(final k k, final s s) {
                final String a = s.a;
                if (a == null) {
                    k.m1(1);
                }
                else {
                    k.E0(1, a);
                }
                final String b = s.b;
                if (b == null) {
                    k.m1(2);
                }
                else {
                    k.E0(2, b);
                }
            }
            
            public /* bridge */ void bind(final k k, final Object o) {
                this.a(k, (s)o);
            }
            
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }
        };
    }
    
    @Override
    public void a(final s s) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(s);
            this.a.setTransactionSuccessful();
        }
        finally {
            this.a.endTransaction();
        }
    }
    
    @Override
    public List<String> b(String c) {
        final t0 e = t0.e("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (c == null) {
            e.m1(1);
        }
        else {
            e.E0(1, c);
        }
        this.a.assertNotSuspendingTransaction();
        c = (String)c.c(this.a, e, false, null);
        try {
            final ArrayList list = new ArrayList(((Cursor)c).getCount());
            while (((Cursor)c).moveToNext()) {
                list.add(((Cursor)c).getString(0));
            }
            return list;
        }
        finally {
            ((Cursor)c).close();
            e.l();
        }
    }
}
