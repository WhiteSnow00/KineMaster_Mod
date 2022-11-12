// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl;

import n1.c;
import n1.e;
import android.content.Context;
import v0.g;
import s0.b;

public class a
{
    public static b a;
    public static b b;
    public static b c;
    public static b d;
    public static b e;
    public static b f;
    public static b g;
    
    static {
        androidx.work.impl.a.a = new b(2) {
            @Override
            public void a(final g g) {
                g.z("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                g.z("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
                g.z("DROP TABLE IF EXISTS alarmInfo");
                g.z("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
            }
        };
        androidx.work.impl.a.b = new b(4) {
            @Override
            public void a(final g g) {
                g.z("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        };
        androidx.work.impl.a.c = new b(5) {
            @Override
            public void a(final g g) {
                g.z("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
                g.z("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
            }
        };
        androidx.work.impl.a.d = new b(7) {
            @Override
            public void a(final g g) {
                g.z("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            }
        };
        androidx.work.impl.a.e = new b(8) {
            @Override
            public void a(final g g) {
                g.z("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
            }
        };
        androidx.work.impl.a.f = new b(9) {
            @Override
            public void a(final g g) {
                g.z("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
            }
        };
        androidx.work.impl.a.g = new b(12) {
            @Override
            public void a(final g g) {
                g.z("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
            }
        };
    }
    
    public static class h extends b
    {
        final Context c;
        
        public h(final Context c, final int n, final int n2) {
            super(n, n2);
            this.c = c;
        }
        
        @Override
        public void a(final g g) {
            if (super.b >= 10) {
                g.T("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[] { "reschedule_needed", 1 });
            }
            else {
                this.c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
            }
        }
    }
    
    public static class i extends b
    {
        final Context c;
        
        public i(final Context c) {
            super(9, 10);
            this.c = c;
        }
        
        @Override
        public void a(final g g) {
            g.z("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            n1.e.b(this.c, g);
            n1.c.a(this.c, g);
        }
    }
}
