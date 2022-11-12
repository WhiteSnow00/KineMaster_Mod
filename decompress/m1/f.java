// 
// Decompiled by Procyon v0.6.0
// 

package m1;

import android.database.Cursor;
import android.os.CancellationSignal;
import v0.j;
import t0.c;
import androidx.room.t0;
import v0.k;
import androidx.room.r;
import androidx.room.RoomDatabase;

public final class f implements e
{
    private final RoomDatabase a;
    private final r<d> b;
    
    public f(final RoomDatabase a) {
        this.a = a;
        this.b = new r<d>(this, a) {
            final f a;
            
            public void a(final k k, final d d) {
                final String a = d.a;
                if (a == null) {
                    k.m1(1);
                }
                else {
                    k.E0(1, a);
                }
                final Long b = d.b;
                if (b == null) {
                    k.m1(2);
                }
                else {
                    k.U0(2, b);
                }
            }
            
            public /* bridge */ void bind(final k k, final Object o) {
                this.a(k, (d)o);
            }
            
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }
        };
    }
    
    @Override
    public void a(final d d) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(d);
            this.a.setTransactionSuccessful();
        }
        finally {
            this.a.endTransaction();
        }
    }
    
    @Override
    public Long b(final String s) {
        final t0 e = t0.e("SELECT long_value FROM Preference where `key`=?", 1);
        if (s == null) {
            e.m1(1);
        }
        else {
            e.E0(1, s);
        }
        this.a.assertNotSuspendingTransaction();
        final RoomDatabase a = this.a;
        final Long n = null;
        final Cursor c = t0.c.c(a, e, false, null);
        Long value = n;
        try {
            if (c.moveToFirst()) {
                if (c.isNull(0)) {
                    value = n;
                }
                else {
                    value = c.getLong(0);
                }
            }
            return value;
        }
        finally {
            c.close();
            e.l();
        }
    }
}
