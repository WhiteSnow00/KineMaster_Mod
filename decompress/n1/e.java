// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import m1.d;
import android.content.SharedPreferences;
import v0.g;
import android.content.Context;
import androidx.work.impl.WorkDatabase;

public class e
{
    private final WorkDatabase a;
    
    public e(final WorkDatabase a) {
        this.a = a;
    }
    
    public static void b(final Context context, final g g) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (!sharedPreferences.contains("reschedule_needed") && !sharedPreferences.contains("last_cancel_all_time_ms")) {
            return;
        }
        long n = 0L;
        final long long1 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
        if (sharedPreferences.getBoolean("reschedule_needed", false)) {
            n = 1L;
        }
        g.m();
        try {
            g.T("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[] { "last_cancel_all_time_ms", long1 });
            g.T("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[] { "reschedule_needed", n });
            sharedPreferences.edit().clear().apply();
            g.p();
        }
        finally {
            g.q();
        }
    }
    
    public boolean a() {
        final Long b = this.a.h().b("reschedule_needed");
        return b != null && b == 1L;
    }
    
    public void c(final boolean b) {
        this.a.h().a(new d("reschedule_needed", b));
    }
}
