// 
// Decompiled by Procyon v0.6.0
// 

package m1;

import android.database.Cursor;
import java.util.ArrayList;
import android.os.CancellationSignal;
import t0.c;
import androidx.room.t0;
import java.util.List;
import androidx.room.r;
import androidx.room.RoomDatabase;

public final class l implements k
{
    private final RoomDatabase a;
    private final r<j> b;
    
    public l(final RoomDatabase a) {
        this.a = a;
        this.b = new r<j>(this, a) {
            final l a;
            
            public void a(final v0.k k, final j j) {
                final String a = j.a;
                if (a == null) {
                    k.m1(1);
                }
                else {
                    k.E0(1, a);
                }
                final String b = j.b;
                if (b == null) {
                    k.m1(2);
                }
                else {
                    k.E0(2, b);
                }
            }
            
            public /* bridge */ void bind(final v0.k k, final Object o) {
                this.a(k, (j)o);
            }
            
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }
        };
    }
    
    @Override
    public void a(final j j) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(j);
            this.a.setTransactionSuccessful();
        }
        finally {
            this.a.endTransaction();
        }
    }
    
    @Override
    public List<String> b(String c) {
        final t0 e = t0.e("SELECT name FROM workname WHERE work_spec_id=?", 1);
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
