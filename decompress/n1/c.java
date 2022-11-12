// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import m1.d;
import android.content.SharedPreferences;
import v0.g;
import android.content.Context;
import androidx.work.impl.WorkDatabase;

public class c
{
    private final WorkDatabase a;
    
    public c(final WorkDatabase a) {
        this.a = a;
    }
    
    public static void a(final Context context, final g g) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (!sharedPreferences.contains("next_job_scheduler_id") && !sharedPreferences.contains("next_job_scheduler_id")) {
            return;
        }
        final int int1 = sharedPreferences.getInt("next_job_scheduler_id", 0);
        final int int2 = sharedPreferences.getInt("next_alarm_manager_id", 0);
        g.m();
        try {
            g.T("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[] { "next_job_scheduler_id", int1 });
            g.T("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[] { "next_alarm_manager_id", int2 });
            sharedPreferences.edit().clear().apply();
            g.p();
        }
        finally {
            g.q();
        }
    }
    
    private int c(final String s) {
        this.a.beginTransaction();
        try {
            final Long b = this.a.h().b(s);
            int n = 0;
            int intValue;
            if (b != null) {
                intValue = b.intValue();
            }
            else {
                intValue = 0;
            }
            if (intValue != Integer.MAX_VALUE) {
                n = intValue + 1;
            }
            this.e(s, n);
            this.a.setTransactionSuccessful();
            return intValue;
        }
        finally {
            this.a.endTransaction();
        }
    }
    
    private void e(final String s, final int n) {
        this.a.h().a(new d(s, n));
    }
    
    public int b() {
        synchronized (c.class) {
            return this.c("next_alarm_manager_id");
        }
    }
    
    public int d(int n, final int n2) {
        synchronized (c.class) {
            final int c = this.c("next_job_scheduler_id");
            if (c >= n && c <= n2) {
                n = c;
            }
            else {
                this.e("next_job_scheduler_id", n + 1);
            }
            return n;
        }
    }
}
