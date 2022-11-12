// 
// Decompiled by Procyon v0.6.0
// 

package m1;

import android.database.Cursor;
import java.util.ArrayList;
import android.os.CancellationSignal;
import v0.j;
import androidx.room.t0;
import java.util.List;
import v0.k;
import androidx.room.r;
import androidx.room.RoomDatabase;

public final class c implements b
{
    private final RoomDatabase a;
    private final r<a> b;
    
    public c(final RoomDatabase a) {
        this.a = a;
        this.b = new r<a>(this, a) {
            final c a;
            
            public void a(final k k, final a a) {
                final String a2 = a.a;
                if (a2 == null) {
                    k.m1(1);
                }
                else {
                    k.E0(1, a2);
                }
                final String b = a.b;
                if (b == null) {
                    k.m1(2);
                }
                else {
                    k.E0(2, b);
                }
            }
            
            public /* bridge */ void bind(final k k, final Object o) {
                this.a(k, (a)o);
            }
            
            public String createQuery() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }
        };
    }
    
    @Override
    public List<String> a(String c) {
        final t0 e = t0.e("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
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
    
    @Override
    public boolean b(final String s) {
        final boolean b = true;
        final t0 e = t0.e("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (s == null) {
            e.m1(1);
        }
        else {
            e.E0(1, s);
        }
        this.a.assertNotSuspendingTransaction();
        final RoomDatabase a = this.a;
        boolean b2 = false;
        final Cursor c = t0.c.c(a, e, false, null);
        try {
            if (c.moveToFirst()) {
                b2 = (c.getInt(0) != 0 && b);
            }
            return b2;
        }
        finally {
            c.close();
            e.l();
        }
    }
    
    @Override
    public void c(final a a) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(a);
            this.a.setTransactionSuccessful();
        }
        finally {
            this.a.endTransaction();
        }
    }
    
    @Override
    public boolean d(String c) {
        final boolean b = true;
        final t0 e = t0.e("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (c == null) {
            e.m1(1);
        }
        else {
            e.E0(1, c);
        }
        this.a.assertNotSuspendingTransaction();
        final RoomDatabase a = this.a;
        boolean b2 = false;
        c = (String)c.c(a, e, false, null);
        try {
            if (((Cursor)c).moveToFirst()) {
                b2 = (((Cursor)c).getInt(0) != 0 && b);
            }
            return b2;
        }
        finally {
            ((Cursor)c).close();
            e.l();
        }
    }
}
