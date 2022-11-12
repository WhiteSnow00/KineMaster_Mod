// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl;

import m1.u;
import m1.r;
import m1.l;
import m1.i;
import m1.f;
import java.util.Arrays;
import java.util.HashSet;
import t0.c;
import androidx.room.s0;
import androidx.room.o;
import java.util.Map;
import androidx.room.RoomDatabase;
import java.util.Set;
import java.util.HashMap;
import androidx.room.w;
import v0.g;
import java.util.List;
import m1.e;
import m1.n;
import m1.k;
import m1.h;
import m1.t;
import m1.b;
import m1.q;

public final class WorkDatabase_Impl extends WorkDatabase
{
    private volatile q b;
    private volatile m1.b c;
    private volatile t d;
    private volatile h e;
    private volatile k f;
    private volatile n g;
    private volatile m1.e h;
    
    static List n(final WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }
    
    static List o(final WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }
    
    static List p(final WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }
    
    static List q(final WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }
    
    static List r(final WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }
    
    static List s(final WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }
    
    static List t(final WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }
    
    static g u(final WorkDatabase_Impl workDatabase_Impl, final g mDatabase) {
        return workDatabase_Impl.mDatabase = mDatabase;
    }
    
    static void v(final WorkDatabase_Impl workDatabase_Impl, final g g) {
        workDatabase_Impl.internalInitInvalidationTracker(g);
    }
    
    static List w(final WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }
    
    static List x(final WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.mCallbacks;
    }
    
    @Override
    public void clearAllTables() {
        super.assertNotMainThread();
        final g writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.z("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.z("DELETE FROM `Dependency`");
            writableDatabase.z("DELETE FROM `WorkSpec`");
            writableDatabase.z("DELETE FROM `WorkTag`");
            writableDatabase.z("DELETE FROM `SystemIdInfo`");
            writableDatabase.z("DELETE FROM `WorkName`");
            writableDatabase.z("DELETE FROM `WorkProgress`");
            writableDatabase.z("DELETE FROM `Preference`");
            super.setTransactionSuccessful();
        }
        finally {
            super.endTransaction();
            writableDatabase.Z0("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.q1()) {
                writableDatabase.z("VACUUM");
            }
        }
    }
    
    @Override
    protected w createInvalidationTracker() {
        return new w(this, new HashMap<String, String>(0), new HashMap<String, Set<String>>(0), new String[] { "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference" });
    }
    
    @Override
    protected v0.h createOpenHelper(final o o) {
        return o.a.a(v0.h.b.a(o.b).c(o.c).b(new s0(o, (s0.a)new s0.a(this, 12) {
            final WorkDatabase_Impl a;
            
            public void createAllTables(final g g) {
                g.z("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                g.z("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                g.z("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                g.z("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
                g.z("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                g.z("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
                g.z("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                g.z("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                g.z("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                g.z("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                g.z("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                g.z("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                g.z("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                g.z("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                g.z("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
            }
            
            public void dropAllTables(final g g) {
                g.z("DROP TABLE IF EXISTS `Dependency`");
                g.z("DROP TABLE IF EXISTS `WorkSpec`");
                g.z("DROP TABLE IF EXISTS `WorkTag`");
                g.z("DROP TABLE IF EXISTS `SystemIdInfo`");
                g.z("DROP TABLE IF EXISTS `WorkName`");
                g.z("DROP TABLE IF EXISTS `WorkProgress`");
                g.z("DROP TABLE IF EXISTS `Preference`");
                if (WorkDatabase_Impl.n(this.a) != null) {
                    for (int i = 0; i < WorkDatabase_Impl.o(this.a).size(); ++i) {
                        ((RoomDatabase.b)WorkDatabase_Impl.q(this.a).get(i)).b(g);
                    }
                }
            }
            
            @Override
            protected void onCreate(final g g) {
                if (WorkDatabase_Impl.r(this.a) != null) {
                    for (int i = 0; i < WorkDatabase_Impl.s(this.a).size(); ++i) {
                        ((RoomDatabase.b)WorkDatabase_Impl.t(this.a).get(i)).a(g);
                    }
                }
            }
            
            public void onOpen(final g g) {
                WorkDatabase_Impl.u(this.a, g);
                g.z("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.v(this.a, g);
                if (WorkDatabase_Impl.w(this.a) != null) {
                    for (int i = 0; i < WorkDatabase_Impl.x(this.a).size(); ++i) {
                        ((RoomDatabase.b)WorkDatabase_Impl.p(this.a).get(i)).c(g);
                    }
                }
            }
            
            public void onPostMigrate(final g g) {
            }
            
            public void onPreMigrate(final g g) {
                c.b(g);
            }
            
            @Override
            protected s0.b onValidateSchema(final g g) {
                final HashMap hashMap = new HashMap(2);
                hashMap.put("work_spec_id", new t0.g.a("work_spec_id", "TEXT", true, 1, null, 1));
                hashMap.put("prerequisite_id", new t0.g.a("prerequisite_id", "TEXT", true, 2, null, 1));
                final HashSet set = new HashSet(2);
                set.add(new t0.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                set.add(new t0.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
                final HashSet set2 = new HashSet(2);
                set2.add(new t0.g.d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
                set2.add(new t0.g.d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
                final t0.g g2 = new t0.g("Dependency", hashMap, set, set2);
                final t0.g a = t0.g.a(g, "Dependency");
                if (!g2.equals(a)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Dependency(androidx.work.impl.model.Dependency).\n Expected:\n");
                    sb.append(g2);
                    sb.append("\n Found:\n");
                    sb.append(a);
                    return new s0.b(false, sb.toString());
                }
                final HashMap hashMap2 = new HashMap(25);
                hashMap2.put("id", new t0.g.a("id", "TEXT", true, 1, null, 1));
                hashMap2.put("state", new t0.g.a("state", "INTEGER", true, 0, null, 1));
                hashMap2.put("worker_class_name", new t0.g.a("worker_class_name", "TEXT", true, 0, null, 1));
                hashMap2.put("input_merger_class_name", new t0.g.a("input_merger_class_name", "TEXT", false, 0, null, 1));
                hashMap2.put("input", new t0.g.a("input", "BLOB", true, 0, null, 1));
                hashMap2.put("output", new t0.g.a("output", "BLOB", true, 0, null, 1));
                hashMap2.put("initial_delay", new t0.g.a("initial_delay", "INTEGER", true, 0, null, 1));
                hashMap2.put("interval_duration", new t0.g.a("interval_duration", "INTEGER", true, 0, null, 1));
                hashMap2.put("flex_duration", new t0.g.a("flex_duration", "INTEGER", true, 0, null, 1));
                hashMap2.put("run_attempt_count", new t0.g.a("run_attempt_count", "INTEGER", true, 0, null, 1));
                hashMap2.put("backoff_policy", new t0.g.a("backoff_policy", "INTEGER", true, 0, null, 1));
                hashMap2.put("backoff_delay_duration", new t0.g.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
                hashMap2.put("period_start_time", new t0.g.a("period_start_time", "INTEGER", true, 0, null, 1));
                hashMap2.put("minimum_retention_duration", new t0.g.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
                hashMap2.put("schedule_requested_at", new t0.g.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
                hashMap2.put("run_in_foreground", new t0.g.a("run_in_foreground", "INTEGER", true, 0, null, 1));
                hashMap2.put("out_of_quota_policy", new t0.g.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
                hashMap2.put("required_network_type", new t0.g.a("required_network_type", "INTEGER", false, 0, null, 1));
                hashMap2.put("requires_charging", new t0.g.a("requires_charging", "INTEGER", true, 0, null, 1));
                hashMap2.put("requires_device_idle", new t0.g.a("requires_device_idle", "INTEGER", true, 0, null, 1));
                hashMap2.put("requires_battery_not_low", new t0.g.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
                hashMap2.put("requires_storage_not_low", new t0.g.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
                hashMap2.put("trigger_content_update_delay", new t0.g.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
                hashMap2.put("trigger_max_content_delay", new t0.g.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
                hashMap2.put("content_uri_triggers", new t0.g.a("content_uri_triggers", "BLOB", false, 0, null, 1));
                final HashSet set3 = new HashSet(0);
                final HashSet set4 = new HashSet(2);
                set4.add(new t0.g.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
                set4.add(new t0.g.d("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
                final t0.g g3 = new t0.g("WorkSpec", hashMap2, set3, set4);
                final t0.g a2 = t0.g.a(g, "WorkSpec");
                if (!g3.equals(a2)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n");
                    sb2.append(g3);
                    sb2.append("\n Found:\n");
                    sb2.append(a2);
                    return new s0.b(false, sb2.toString());
                }
                final HashMap hashMap3 = new HashMap(2);
                hashMap3.put("tag", new t0.g.a("tag", "TEXT", true, 1, null, 1));
                hashMap3.put("work_spec_id", new t0.g.a("work_spec_id", "TEXT", true, 2, null, 1));
                final HashSet set5 = new HashSet(1);
                set5.add(new t0.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                final HashSet set6 = new HashSet(1);
                set6.add(new t0.g.d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
                final t0.g g4 = new t0.g("WorkTag", hashMap3, set5, set6);
                final t0.g a3 = t0.g.a(g, "WorkTag");
                if (!g4.equals(a3)) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n");
                    sb3.append(g4);
                    sb3.append("\n Found:\n");
                    sb3.append(a3);
                    return new s0.b(false, sb3.toString());
                }
                final HashMap hashMap4 = new HashMap(2);
                hashMap4.put("work_spec_id", new t0.g.a("work_spec_id", "TEXT", true, 1, null, 1));
                hashMap4.put("system_id", new t0.g.a("system_id", "INTEGER", true, 0, null, 1));
                final HashSet set7 = new HashSet(1);
                set7.add(new t0.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                final t0.g g5 = new t0.g("SystemIdInfo", hashMap4, set7, new HashSet<t0.g.d>(0));
                final t0.g a4 = t0.g.a(g, "SystemIdInfo");
                if (!g5.equals(a4)) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n");
                    sb4.append(g5);
                    sb4.append("\n Found:\n");
                    sb4.append(a4);
                    return new s0.b(false, sb4.toString());
                }
                final HashMap hashMap5 = new HashMap(2);
                hashMap5.put("name", new t0.g.a("name", "TEXT", true, 1, null, 1));
                hashMap5.put("work_spec_id", new t0.g.a("work_spec_id", "TEXT", true, 2, null, 1));
                final HashSet set8 = new HashSet(1);
                set8.add(new t0.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                final HashSet set9 = new HashSet(1);
                set9.add(new t0.g.d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
                final t0.g g6 = new t0.g("WorkName", hashMap5, set8, set9);
                final t0.g a5 = t0.g.a(g, "WorkName");
                if (!g6.equals(a5)) {
                    final StringBuilder sb5 = new StringBuilder();
                    sb5.append("WorkName(androidx.work.impl.model.WorkName).\n Expected:\n");
                    sb5.append(g6);
                    sb5.append("\n Found:\n");
                    sb5.append(a5);
                    return new s0.b(false, sb5.toString());
                }
                final HashMap hashMap6 = new HashMap(2);
                hashMap6.put("work_spec_id", new t0.g.a("work_spec_id", "TEXT", true, 1, null, 1));
                hashMap6.put("progress", new t0.g.a("progress", "BLOB", true, 0, null, 1));
                final HashSet set10 = new HashSet(1);
                set10.add(new t0.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                final t0.g g7 = new t0.g("WorkProgress", hashMap6, set10, new HashSet<t0.g.d>(0));
                final t0.g a6 = t0.g.a(g, "WorkProgress");
                if (!g7.equals(a6)) {
                    final StringBuilder sb6 = new StringBuilder();
                    sb6.append("WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n");
                    sb6.append(g7);
                    sb6.append("\n Found:\n");
                    sb6.append(a6);
                    return new s0.b(false, sb6.toString());
                }
                final HashMap hashMap7 = new HashMap(2);
                hashMap7.put("key", new t0.g.a("key", "TEXT", true, 1, null, 1));
                hashMap7.put("long_value", new t0.g.a("long_value", "INTEGER", false, 0, null, 1));
                final t0.g g8 = new t0.g("Preference", hashMap7, new HashSet<t0.g.b>(0), new HashSet<t0.g.d>(0));
                final t0.g a7 = t0.g.a(g, "Preference");
                if (!g8.equals(a7)) {
                    final StringBuilder sb7 = new StringBuilder();
                    sb7.append("Preference(androidx.work.impl.model.Preference).\n Expected:\n");
                    sb7.append(g8);
                    sb7.append("\n Found:\n");
                    sb7.append(a7);
                    return new s0.b(false, sb7.toString());
                }
                return new s0.b(true, null);
            }
        }, "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).a());
    }
    
    @Override
    public m1.b d() {
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new m1.c(this);
            }
            return this.c;
        }
    }
    
    @Override
    public m1.e h() {
        if (this.h != null) {
            return this.h;
        }
        synchronized (this) {
            if (this.h == null) {
                this.h = new f(this);
            }
            return this.h;
        }
    }
    
    @Override
    public h i() {
        if (this.e != null) {
            return this.e;
        }
        synchronized (this) {
            if (this.e == null) {
                this.e = new i(this);
            }
            return this.e;
        }
    }
    
    @Override
    public k j() {
        if (this.f != null) {
            return this.f;
        }
        synchronized (this) {
            if (this.f == null) {
                this.f = new l(this);
            }
            return this.f;
        }
    }
    
    @Override
    public n k() {
        if (this.g != null) {
            return this.g;
        }
        synchronized (this) {
            if (this.g == null) {
                this.g = new m1.o(this);
            }
            return this.g;
        }
    }
    
    @Override
    public q l() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = new r(this);
            }
            return this.b;
        }
    }
    
    @Override
    public t m() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new u(this);
            }
            return this.d;
        }
    }
}
