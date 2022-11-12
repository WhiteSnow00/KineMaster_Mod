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
import t0.f;
import androidx.work.WorkInfo;
import e1.a;
import androidx.work.b;
import v0.k;
import androidx.room.x0;
import androidx.room.RoomDatabase;

public final class r implements q
{
    private final RoomDatabase a;
    private final androidx.room.r<p> b;
    private final x0 c;
    private final x0 d;
    private final x0 e;
    private final x0 f;
    private final x0 g;
    private final x0 h;
    private final x0 i;
    private final x0 j;
    
    public r(final RoomDatabase a) {
        this.a = a;
        this.b = new androidx.room.r<p>(this, a) {
            final r a;
            
            public void a(final k k, final p p2) {
                final String a = p2.a;
                if (a == null) {
                    k.m1(1);
                }
                else {
                    k.E0(1, a);
                }
                k.U0(2, v.j(p2.b));
                final String c = p2.c;
                if (c == null) {
                    k.m1(3);
                }
                else {
                    k.E0(3, c);
                }
                final String d = p2.d;
                if (d == null) {
                    k.m1(4);
                }
                else {
                    k.E0(4, d);
                }
                final byte[] i = androidx.work.b.k(p2.e);
                if (i == null) {
                    k.m1(5);
                }
                else {
                    k.V0(5, i);
                }
                final byte[] j = androidx.work.b.k(p2.f);
                if (j == null) {
                    k.m1(6);
                }
                else {
                    k.V0(6, j);
                }
                k.U0(7, p2.g);
                k.U0(8, p2.h);
                k.U0(9, p2.i);
                k.U0(10, p2.k);
                k.U0(11, v.a(p2.l));
                k.U0(12, p2.m);
                k.U0(13, p2.n);
                k.U0(14, p2.o);
                k.U0(15, p2.p);
                k.U0(16, p2.q ? 1 : 0);
                k.U0(17, v.i(p2.r));
                final a l = p2.j;
                if (l != null) {
                    k.U0(18, v.h(l.b()));
                    k.U0(19, l.g() ? 1 : 0);
                    k.U0(20, l.h() ? 1 : 0);
                    k.U0(21, l.f() ? 1 : 0);
                    k.U0(22, l.i() ? 1 : 0);
                    k.U0(23, l.c());
                    k.U0(24, l.d());
                    final byte[] c2 = v.c(l.a());
                    if (c2 == null) {
                        k.m1(25);
                    }
                    else {
                        k.V0(25, c2);
                    }
                }
                else {
                    k.m1(18);
                    k.m1(19);
                    k.m1(20);
                    k.m1(21);
                    k.m1(22);
                    k.m1(23);
                    k.m1(24);
                    k.m1(25);
                }
            }
            
            public /* bridge */ void bind(final k k, final Object o) {
                this.a(k, (p)o);
            }
            
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.c = new x0(this, a) {
            final r a;
            
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.d = new x0(this, a) {
            final r a;
            
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.e = new x0(this, a) {
            final r a;
            
            public String createQuery() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.f = new x0(this, a) {
            final r a;
            
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.g = new x0(this, a) {
            final r a;
            
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.h = new x0(this, a) {
            final r a;
            
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.i = new x0(this, a) {
            final r a;
            
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.j = new x0(this, a) {
            final r a;
            
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
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
    public int b(final WorkInfo.State state, final String... array) {
        this.a.assertNotSuspendingTransaction();
        final StringBuilder b = t0.f.b();
        b.append("UPDATE workspec SET state=");
        b.append("?");
        b.append(" WHERE id IN (");
        t0.f.a(b, array.length);
        b.append(")");
        final k compileStatement = this.a.compileStatement(b.toString());
        compileStatement.U0(1, v.j(state));
        final int length = array.length;
        int n = 2;
        for (final String s : array) {
            if (s == null) {
                compileStatement.m1(n);
            }
            else {
                compileStatement.E0(n, s);
            }
            ++n;
        }
        this.a.beginTransaction();
        try {
            final int c = compileStatement.C();
            this.a.setTransactionSuccessful();
            return c;
        }
        finally {
            this.a.endTransaction();
        }
    }
    
    @Override
    public List<p> c(final long n) {
        final t0 e = t0.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        e.U0(1, n);
        this.a.assertNotSuspendingTransaction();
        final Cursor c = t0.c.c(this.a, e, false, null);
        try {
            final int d = t0.b.d(c, "required_network_type");
            final int d2 = t0.b.d(c, "requires_charging");
            final int d3 = t0.b.d(c, "requires_device_idle");
            final int d4 = t0.b.d(c, "requires_battery_not_low");
            final int d5 = t0.b.d(c, "requires_storage_not_low");
            final int d6 = t0.b.d(c, "trigger_content_update_delay");
            final int d7 = t0.b.d(c, "trigger_max_content_delay");
            final int d8 = t0.b.d(c, "content_uri_triggers");
            final int d9 = t0.b.d(c, "id");
            final int d10 = t0.b.d(c, "state");
            final int d11 = t0.b.d(c, "worker_class_name");
            final int d12 = t0.b.d(c, "input_merger_class_name");
            final int d13 = t0.b.d(c, "input");
            final int d14 = t0.b.d(c, "output");
            try {
                final int d15 = t0.b.d(c, "initial_delay");
                final int d16 = t0.b.d(c, "interval_duration");
                final int d17 = t0.b.d(c, "flex_duration");
                final int d18 = t0.b.d(c, "run_attempt_count");
                final int d19 = t0.b.d(c, "backoff_policy");
                final int d20 = t0.b.d(c, "backoff_delay_duration");
                final int d21 = t0.b.d(c, "period_start_time");
                final int d22 = t0.b.d(c, "minimum_retention_duration");
                final int d23 = t0.b.d(c, "schedule_requested_at");
                final int d24 = t0.b.d(c, "run_in_foreground");
                final int d25 = t0.b.d(c, "out_of_quota_policy");
                final ArrayList list = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    final String string = c.getString(d9);
                    final String string2 = c.getString(d11);
                    final a j = new a();
                    j.k(v.e(c.getInt(d)));
                    j.m(c.getInt(d2) != 0);
                    j.n(c.getInt(d3) != 0);
                    j.l(c.getInt(d4) != 0);
                    j.o(c.getInt(d5) != 0);
                    j.p(c.getLong(d6));
                    j.q(c.getLong(d7));
                    j.j(v.b(c.getBlob(d8)));
                    final p p = new p(string, string2);
                    p.b = v.g(c.getInt(d10));
                    p.d = c.getString(d12);
                    p.e = androidx.work.b.g(c.getBlob(d13));
                    p.f = androidx.work.b.g(c.getBlob(d14));
                    p.g = c.getLong(d15);
                    p.h = c.getLong(d16);
                    p.i = c.getLong(d17);
                    p.k = c.getInt(d18);
                    p.l = v.d(c.getInt(d19));
                    p.m = c.getLong(d20);
                    p.n = c.getLong(d21);
                    p.o = c.getLong(d22);
                    p.p = c.getLong(d23);
                    p.q = (c.getInt(d24) != 0);
                    p.r = v.f(c.getInt(d25));
                    p.j = j;
                    list.add((Object)p);
                }
                c.close();
                e.l();
                return (List<p>)list;
            }
            finally {}
        }
        finally {}
        c.close();
        e.l();
    }
    
    @Override
    public List<p> d() {
        final t0 e = t0.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.assertNotSuspendingTransaction();
        final Cursor c = t0.c.c(this.a, e, false, null);
        try {
            final int d = t0.b.d(c, "required_network_type");
            final int d2 = t0.b.d(c, "requires_charging");
            final int d3 = t0.b.d(c, "requires_device_idle");
            final int d4 = t0.b.d(c, "requires_battery_not_low");
            final int d5 = t0.b.d(c, "requires_storage_not_low");
            final int d6 = t0.b.d(c, "trigger_content_update_delay");
            final int d7 = t0.b.d(c, "trigger_max_content_delay");
            final int d8 = t0.b.d(c, "content_uri_triggers");
            final int d9 = t0.b.d(c, "id");
            final int d10 = t0.b.d(c, "state");
            final int d11 = t0.b.d(c, "worker_class_name");
            final int d12 = t0.b.d(c, "input_merger_class_name");
            final int d13 = t0.b.d(c, "input");
            final int d14 = t0.b.d(c, "output");
            try {
                final int d15 = t0.b.d(c, "initial_delay");
                final int d16 = t0.b.d(c, "interval_duration");
                final int d17 = t0.b.d(c, "flex_duration");
                final int d18 = t0.b.d(c, "run_attempt_count");
                final int d19 = t0.b.d(c, "backoff_policy");
                final int d20 = t0.b.d(c, "backoff_delay_duration");
                final int d21 = t0.b.d(c, "period_start_time");
                final int d22 = t0.b.d(c, "minimum_retention_duration");
                final int d23 = t0.b.d(c, "schedule_requested_at");
                final int d24 = t0.b.d(c, "run_in_foreground");
                final int d25 = t0.b.d(c, "out_of_quota_policy");
                final ArrayList list = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    final String string = c.getString(d9);
                    final String string2 = c.getString(d11);
                    final a j = new a();
                    j.k(v.e(c.getInt(d)));
                    j.m(c.getInt(d2) != 0);
                    j.n(c.getInt(d3) != 0);
                    j.l(c.getInt(d4) != 0);
                    j.o(c.getInt(d5) != 0);
                    j.p(c.getLong(d6));
                    j.q(c.getLong(d7));
                    j.j(v.b(c.getBlob(d8)));
                    final p p = new p(string, string2);
                    p.b = v.g(c.getInt(d10));
                    p.d = c.getString(d12);
                    p.e = androidx.work.b.g(c.getBlob(d13));
                    p.f = androidx.work.b.g(c.getBlob(d14));
                    p.g = c.getLong(d15);
                    p.h = c.getLong(d16);
                    p.i = c.getLong(d17);
                    p.k = c.getInt(d18);
                    p.l = v.d(c.getInt(d19));
                    p.m = c.getLong(d20);
                    p.n = c.getLong(d21);
                    p.o = c.getLong(d22);
                    p.p = c.getLong(d23);
                    p.q = (c.getInt(d24) != 0);
                    p.r = v.f(c.getInt(d25));
                    p.j = j;
                    list.add((Object)p);
                }
                c.close();
                e.l();
                return (List<p>)list;
            }
            finally {}
        }
        finally {}
        c.close();
        e.l();
    }
    
    @Override
    public List<String> e(String c) {
        final t0 e = t0.e("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
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
    public WorkInfo.State f(final String s) {
        final t0 e = t0.e("SELECT state FROM workspec WHERE id=?", 1);
        if (s == null) {
            e.m1(1);
        }
        else {
            e.E0(1, s);
        }
        this.a.assertNotSuspendingTransaction();
        final RoomDatabase a = this.a;
        WorkInfo.State g = null;
        final Cursor c = t0.c.c(a, e, false, null);
        try {
            if (c.moveToFirst()) {
                g = v.g(c.getInt(0));
            }
            return g;
        }
        finally {
            c.close();
            e.l();
        }
    }
    
    @Override
    public p g(final String s) {
        final t0 e = t0.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (s == null) {
            e.m1(1);
        }
        else {
            e.E0(1, s);
        }
        this.a.assertNotSuspendingTransaction();
        final Cursor c = t0.c.c(this.a, e, false, null);
        try {
            final int d = t0.b.d(c, "required_network_type");
            final int d2 = t0.b.d(c, "requires_charging");
            final int d3 = t0.b.d(c, "requires_device_idle");
            final int d4 = t0.b.d(c, "requires_battery_not_low");
            final int d5 = t0.b.d(c, "requires_storage_not_low");
            final int d6 = t0.b.d(c, "trigger_content_update_delay");
            final int d7 = t0.b.d(c, "trigger_max_content_delay");
            final int d8 = t0.b.d(c, "content_uri_triggers");
            final int d9 = t0.b.d(c, "id");
            final int d10 = t0.b.d(c, "state");
            final int d11 = t0.b.d(c, "worker_class_name");
            final int d12 = t0.b.d(c, "input_merger_class_name");
            final int d13 = t0.b.d(c, "input");
            final int d14 = t0.b.d(c, "output");
            try {
                final int d15 = t0.b.d(c, "initial_delay");
                final int d16 = t0.b.d(c, "interval_duration");
                final int d17 = t0.b.d(c, "flex_duration");
                final int d18 = t0.b.d(c, "run_attempt_count");
                final int d19 = t0.b.d(c, "backoff_policy");
                final int d20 = t0.b.d(c, "backoff_delay_duration");
                final int d21 = t0.b.d(c, "period_start_time");
                final int d22 = t0.b.d(c, "minimum_retention_duration");
                final int d23 = t0.b.d(c, "schedule_requested_at");
                final int d24 = t0.b.d(c, "run_in_foreground");
                final int d25 = t0.b.d(c, "out_of_quota_policy");
                p p;
                if (c.moveToFirst()) {
                    final String string = c.getString(d9);
                    final String string2 = c.getString(d11);
                    final a j = new a();
                    j.k(v.e(c.getInt(d)));
                    j.m(c.getInt(d2) != 0);
                    j.n(c.getInt(d3) != 0);
                    j.l(c.getInt(d4) != 0);
                    j.o(c.getInt(d5) != 0);
                    j.p(c.getLong(d6));
                    j.q(c.getLong(d7));
                    j.j(v.b(c.getBlob(d8)));
                    p = new p(string, string2);
                    p.b = v.g(c.getInt(d10));
                    p.d = c.getString(d12);
                    p.e = androidx.work.b.g(c.getBlob(d13));
                    p.f = androidx.work.b.g(c.getBlob(d14));
                    p.g = c.getLong(d15);
                    p.h = c.getLong(d16);
                    p.i = c.getLong(d17);
                    p.k = c.getInt(d18);
                    p.l = v.d(c.getInt(d19));
                    p.m = c.getLong(d20);
                    p.n = c.getLong(d21);
                    p.o = c.getLong(d22);
                    p.p = c.getLong(d23);
                    p.q = (c.getInt(d24) != 0);
                    p.r = v.f(c.getInt(d25));
                    p.j = j;
                }
                else {
                    p = null;
                }
                c.close();
                e.l();
                return p;
            }
            finally {}
        }
        finally {}
        c.close();
        e.l();
    }
    
    @Override
    public List<String> h(String c) {
        final t0 e = t0.e("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
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
    public List<b> i(String c) {
        final t0 e = t0.e("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
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
                list.add(androidx.work.b.g(((Cursor)c).getBlob(0)));
            }
            return list;
        }
        finally {
            ((Cursor)c).close();
            e.l();
        }
    }
    
    @Override
    public List<p> j(int d) {
        final t0 e = t0.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        e.U0(1, d);
        this.a.assertNotSuspendingTransaction();
        final Cursor c = t0.c.c(this.a, e, false, null);
        try {
            final int d2 = t0.b.d(c, "required_network_type");
            final int d3 = t0.b.d(c, "requires_charging");
            final int d4 = t0.b.d(c, "requires_device_idle");
            final int d5 = t0.b.d(c, "requires_battery_not_low");
            final int d6 = t0.b.d(c, "requires_storage_not_low");
            final int d7 = t0.b.d(c, "trigger_content_update_delay");
            final int d8 = t0.b.d(c, "trigger_max_content_delay");
            final int d9 = t0.b.d(c, "content_uri_triggers");
            final int d10 = t0.b.d(c, "id");
            final int d11 = t0.b.d(c, "state");
            final int d12 = t0.b.d(c, "worker_class_name");
            final int d13 = t0.b.d(c, "input_merger_class_name");
            final int d14 = t0.b.d(c, "input");
            final int d15 = t0.b.d(c, "output");
            try {
                final int d16 = t0.b.d(c, "initial_delay");
                final int d17 = t0.b.d(c, "interval_duration");
                final int d18 = t0.b.d(c, "flex_duration");
                final int d19 = t0.b.d(c, "run_attempt_count");
                d = t0.b.d(c, "backoff_policy");
                final int d20 = t0.b.d(c, "backoff_delay_duration");
                final int d21 = t0.b.d(c, "period_start_time");
                final int d22 = t0.b.d(c, "minimum_retention_duration");
                final int d23 = t0.b.d(c, "schedule_requested_at");
                final int d24 = t0.b.d(c, "run_in_foreground");
                final int d25 = t0.b.d(c, "out_of_quota_policy");
                final ArrayList list = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    final String string = c.getString(d10);
                    final String string2 = c.getString(d12);
                    final a j = new a();
                    j.k(v.e(c.getInt(d2)));
                    j.m(c.getInt(d3) != 0);
                    j.n(c.getInt(d4) != 0);
                    j.l(c.getInt(d5) != 0);
                    j.o(c.getInt(d6) != 0);
                    j.p(c.getLong(d7));
                    j.q(c.getLong(d8));
                    j.j(v.b(c.getBlob(d9)));
                    final p p = new p(string, string2);
                    p.b = v.g(c.getInt(d11));
                    p.d = c.getString(d13);
                    p.e = androidx.work.b.g(c.getBlob(d14));
                    p.f = androidx.work.b.g(c.getBlob(d15));
                    p.g = c.getLong(d16);
                    p.h = c.getLong(d17);
                    p.i = c.getLong(d18);
                    p.k = c.getInt(d19);
                    p.l = v.d(c.getInt(d));
                    p.m = c.getLong(d20);
                    p.n = c.getLong(d21);
                    p.o = c.getLong(d22);
                    p.p = c.getLong(d23);
                    p.q = (c.getInt(d24) != 0);
                    p.r = v.f(c.getInt(d25));
                    p.j = j;
                    list.add((Object)p);
                }
                c.close();
                e.l();
                return (List<p>)list;
            }
            finally {}
        }
        finally {}
        c.close();
        e.l();
    }
    
    @Override
    public int k() {
        this.a.assertNotSuspendingTransaction();
        final k acquire = this.i.acquire();
        this.a.beginTransaction();
        try {
            final int c = acquire.C();
            this.a.setTransactionSuccessful();
            return c;
        }
        finally {
            this.a.endTransaction();
            this.i.release(acquire);
        }
    }
    
    @Override
    public int l(final String s, final long n) {
        this.a.assertNotSuspendingTransaction();
        final k acquire = this.h.acquire();
        acquire.U0(1, n);
        if (s == null) {
            acquire.m1(2);
        }
        else {
            acquire.E0(2, s);
        }
        this.a.beginTransaction();
        try {
            final int c = acquire.C();
            this.a.setTransactionSuccessful();
            return c;
        }
        finally {
            this.a.endTransaction();
            this.h.release(acquire);
        }
    }
    
    @Override
    public void m(final p p) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(p);
            this.a.setTransactionSuccessful();
        }
        finally {
            this.a.endTransaction();
        }
    }
    
    @Override
    public List<p.b> n(String c) {
        final t0 e = t0.e("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (c == null) {
            e.m1(1);
        }
        else {
            e.E0(1, c);
        }
        this.a.assertNotSuspendingTransaction();
        c = (String)c.c(this.a, e, false, null);
        try {
            final int d = t0.b.d((Cursor)c, "id");
            final int d2 = t0.b.d((Cursor)c, "state");
            final ArrayList list = new ArrayList(((Cursor)c).getCount());
            while (((Cursor)c).moveToNext()) {
                final p.b b = new p.b();
                b.a = ((Cursor)c).getString(d);
                b.b = v.g(((Cursor)c).getInt(d2));
                list.add(b);
            }
            return list;
        }
        finally {
            ((Cursor)c).close();
            e.l();
        }
    }
    
    @Override
    public List<p> o(int d) {
        final t0 e = t0.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        e.U0(1, d);
        this.a.assertNotSuspendingTransaction();
        final Cursor c = t0.c.c(this.a, e, false, null);
        try {
            final int d2 = t0.b.d(c, "required_network_type");
            final int d3 = t0.b.d(c, "requires_charging");
            final int d4 = t0.b.d(c, "requires_device_idle");
            final int d5 = t0.b.d(c, "requires_battery_not_low");
            final int d6 = t0.b.d(c, "requires_storage_not_low");
            final int d7 = t0.b.d(c, "trigger_content_update_delay");
            final int d8 = t0.b.d(c, "trigger_max_content_delay");
            final int d9 = t0.b.d(c, "content_uri_triggers");
            final int d10 = t0.b.d(c, "id");
            final int d11 = t0.b.d(c, "state");
            final int d12 = t0.b.d(c, "worker_class_name");
            final int d13 = t0.b.d(c, "input_merger_class_name");
            final int d14 = t0.b.d(c, "input");
            final int d15 = t0.b.d(c, "output");
            try {
                final int d16 = t0.b.d(c, "initial_delay");
                final int d17 = t0.b.d(c, "interval_duration");
                final int d18 = t0.b.d(c, "flex_duration");
                final int d19 = t0.b.d(c, "run_attempt_count");
                final int d20 = t0.b.d(c, "backoff_policy");
                final int d21 = t0.b.d(c, "backoff_delay_duration");
                final int d22 = t0.b.d(c, "period_start_time");
                final int d23 = t0.b.d(c, "minimum_retention_duration");
                final int d24 = t0.b.d(c, "schedule_requested_at");
                d = t0.b.d(c, "run_in_foreground");
                final int d25 = t0.b.d(c, "out_of_quota_policy");
                final ArrayList list = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    final String string = c.getString(d10);
                    final String string2 = c.getString(d12);
                    final a j = new a();
                    j.k(v.e(c.getInt(d2)));
                    j.m(c.getInt(d3) != 0);
                    j.n(c.getInt(d4) != 0);
                    j.l(c.getInt(d5) != 0);
                    j.o(c.getInt(d6) != 0);
                    j.p(c.getLong(d7));
                    j.q(c.getLong(d8));
                    j.j(v.b(c.getBlob(d9)));
                    final p p = new p(string, string2);
                    p.b = v.g(c.getInt(d11));
                    p.d = c.getString(d13);
                    p.e = androidx.work.b.g(c.getBlob(d14));
                    p.f = androidx.work.b.g(c.getBlob(d15));
                    p.g = c.getLong(d16);
                    p.h = c.getLong(d17);
                    p.i = c.getLong(d18);
                    p.k = c.getInt(d19);
                    p.l = v.d(c.getInt(d20));
                    p.m = c.getLong(d21);
                    p.n = c.getLong(d22);
                    p.o = c.getLong(d23);
                    p.p = c.getLong(d24);
                    p.q = (c.getInt(d) != 0);
                    p.r = v.f(c.getInt(d25));
                    p.j = j;
                    list.add((Object)p);
                }
                c.close();
                e.l();
                return (List<p>)list;
            }
            finally {}
        }
        finally {}
        c.close();
        e.l();
    }
    
    @Override
    public void p(final String s, final b b) {
        this.a.assertNotSuspendingTransaction();
        final k acquire = this.d.acquire();
        final byte[] k = b.k(b);
        if (k == null) {
            acquire.m1(1);
        }
        else {
            acquire.V0(1, k);
        }
        if (s == null) {
            acquire.m1(2);
        }
        else {
            acquire.E0(2, s);
        }
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
    
    @Override
    public List<p> q() {
        final t0 e = t0.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.a.assertNotSuspendingTransaction();
        final Cursor c = t0.c.c(this.a, e, false, null);
        try {
            final int d = t0.b.d(c, "required_network_type");
            final int d2 = t0.b.d(c, "requires_charging");
            final int d3 = t0.b.d(c, "requires_device_idle");
            final int d4 = t0.b.d(c, "requires_battery_not_low");
            final int d5 = t0.b.d(c, "requires_storage_not_low");
            final int d6 = t0.b.d(c, "trigger_content_update_delay");
            final int d7 = t0.b.d(c, "trigger_max_content_delay");
            final int d8 = t0.b.d(c, "content_uri_triggers");
            final int d9 = t0.b.d(c, "id");
            final int d10 = t0.b.d(c, "state");
            final int d11 = t0.b.d(c, "worker_class_name");
            final int d12 = t0.b.d(c, "input_merger_class_name");
            final int d13 = t0.b.d(c, "input");
            final int d14 = t0.b.d(c, "output");
            try {
                final int d15 = t0.b.d(c, "initial_delay");
                final int d16 = t0.b.d(c, "interval_duration");
                final int d17 = t0.b.d(c, "flex_duration");
                final int d18 = t0.b.d(c, "run_attempt_count");
                final int d19 = t0.b.d(c, "backoff_policy");
                final int d20 = t0.b.d(c, "backoff_delay_duration");
                final int d21 = t0.b.d(c, "period_start_time");
                final int d22 = t0.b.d(c, "minimum_retention_duration");
                final int d23 = t0.b.d(c, "schedule_requested_at");
                final int d24 = t0.b.d(c, "run_in_foreground");
                final int d25 = t0.b.d(c, "out_of_quota_policy");
                final ArrayList list = new ArrayList(c.getCount());
                while (c.moveToNext()) {
                    final String string = c.getString(d9);
                    final String string2 = c.getString(d11);
                    final a j = new a();
                    j.k(v.e(c.getInt(d)));
                    j.m(c.getInt(d2) != 0);
                    j.n(c.getInt(d3) != 0);
                    j.l(c.getInt(d4) != 0);
                    j.o(c.getInt(d5) != 0);
                    j.p(c.getLong(d6));
                    j.q(c.getLong(d7));
                    j.j(v.b(c.getBlob(d8)));
                    final p p = new p(string, string2);
                    p.b = v.g(c.getInt(d10));
                    p.d = c.getString(d12);
                    p.e = androidx.work.b.g(c.getBlob(d13));
                    p.f = androidx.work.b.g(c.getBlob(d14));
                    p.g = c.getLong(d15);
                    p.h = c.getLong(d16);
                    p.i = c.getLong(d17);
                    p.k = c.getInt(d18);
                    p.l = v.d(c.getInt(d19));
                    p.m = c.getLong(d20);
                    p.n = c.getLong(d21);
                    p.o = c.getLong(d22);
                    p.p = c.getLong(d23);
                    p.q = (c.getInt(d24) != 0);
                    p.r = v.f(c.getInt(d25));
                    p.j = j;
                    list.add((Object)p);
                }
                c.close();
                e.l();
                return (List<p>)list;
            }
            finally {}
        }
        finally {}
        c.close();
        e.l();
    }
    
    @Override
    public boolean r() {
        final boolean b = false;
        final t0 e = t0.e("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.a.assertNotSuspendingTransaction();
        final Cursor c = t0.c.c(this.a, e, false, null);
        boolean b2 = b;
        try {
            if (c.moveToFirst()) {
                final int int1 = c.getInt(0);
                b2 = b;
                if (int1 != 0) {
                    b2 = true;
                }
            }
            return b2;
        }
        finally {
            c.close();
            e.l();
        }
    }
    
    @Override
    public int s(final String s) {
        this.a.assertNotSuspendingTransaction();
        final k acquire = this.g.acquire();
        if (s == null) {
            acquire.m1(1);
        }
        else {
            acquire.E0(1, s);
        }
        this.a.beginTransaction();
        try {
            final int c = acquire.C();
            this.a.setTransactionSuccessful();
            return c;
        }
        finally {
            this.a.endTransaction();
            this.g.release(acquire);
        }
    }
    
    @Override
    public int t(final String s) {
        this.a.assertNotSuspendingTransaction();
        final k acquire = this.f.acquire();
        if (s == null) {
            acquire.m1(1);
        }
        else {
            acquire.E0(1, s);
        }
        this.a.beginTransaction();
        try {
            final int c = acquire.C();
            this.a.setTransactionSuccessful();
            return c;
        }
        finally {
            this.a.endTransaction();
            this.f.release(acquire);
        }
    }
    
    @Override
    public void u(final String s, final long n) {
        this.a.assertNotSuspendingTransaction();
        final k acquire = this.e.acquire();
        acquire.U0(1, n);
        if (s == null) {
            acquire.m1(2);
        }
        else {
            acquire.E0(2, s);
        }
        this.a.beginTransaction();
        try {
            acquire.C();
            this.a.setTransactionSuccessful();
        }
        finally {
            this.a.endTransaction();
            this.e.release(acquire);
        }
    }
}
