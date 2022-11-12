// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import n1.j;
import android.content.Context;
import e1.h;
import androidx.lifecycle.v;

public class SystemAlarmService extends v implements c
{
    private static final String d;
    private e b;
    private boolean c;
    
    static {
        d = h.f("SystemAlarmService");
    }
    
    private void e() {
        (this.b = new e((Context)this)).m((e.c)this);
    }
    
    @Override
    public void b() {
        this.c = true;
        e1.h.c().a(SystemAlarmService.d, "All commands completed in dispatcher", new Throwable[0]);
        n1.j.a();
        this.stopSelf();
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        this.e();
        this.c = false;
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.c = true;
        this.b.j();
    }
    
    @Override
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        super.onStartCommand(intent, n, n2);
        if (this.c) {
            e1.h.c().d(SystemAlarmService.d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.b.j();
            this.e();
            this.c = false;
        }
        if (intent != null) {
            this.b.a(intent, n2);
        }
        return 3;
    }
}
