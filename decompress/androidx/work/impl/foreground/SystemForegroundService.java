// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.foreground;

import android.content.Intent;
import android.os.Build$VERSION;
import android.app.Notification;
import android.os.Looper;
import e1.h;
import android.app.NotificationManager;
import android.os.Handler;
import androidx.lifecycle.v;

public class SystemForegroundService extends v implements b
{
    private static final String f;
    private static SystemForegroundService g;
    private Handler b;
    private boolean c;
    a d;
    NotificationManager e;
    
    static {
        f = h.f("SystemFgService");
        SystemForegroundService.g = null;
    }
    
    private void e() {
        this.b = new Handler(Looper.getMainLooper());
        this.e = (NotificationManager)this.getApplicationContext().getSystemService("notification");
        (this.d = new a(this.getApplicationContext())).m((a.b)this);
    }
    
    @Override
    public void a(final int n, final Notification notification) {
        this.b.post((Runnable)new Runnable(this, n, notification) {
            final int a;
            final Notification b;
            final SystemForegroundService c;
            
            @Override
            public void run() {
                this.c.e.notify(this.a, this.b);
            }
        });
    }
    
    @Override
    public void c(final int n, final int n2, final Notification notification) {
        this.b.post((Runnable)new Runnable(this, n, notification, n2) {
            final int a;
            final Notification b;
            final int c;
            final SystemForegroundService d;
            
            @Override
            public void run() {
                if (Build$VERSION.SDK_INT >= 29) {
                    this.d.startForeground(this.a, this.b, this.c);
                }
                else {
                    this.d.startForeground(this.a, this.b);
                }
            }
        });
    }
    
    @Override
    public void d(final int n) {
        this.b.post((Runnable)new Runnable(this, n) {
            final int a;
            final SystemForegroundService b;
            
            @Override
            public void run() {
                this.b.e.cancel(this.a);
            }
        });
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        (SystemForegroundService.g = this).e();
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.d.k();
    }
    
    @Override
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        super.onStartCommand(intent, n, n2);
        if (this.c) {
            e1.h.c().d(SystemForegroundService.f, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.d.k();
            this.e();
            this.c = false;
        }
        if (intent != null) {
            this.d.l(intent);
        }
        return 3;
    }
    
    @Override
    public void stop() {
        this.c = true;
        e1.h.c().a(SystemForegroundService.f, "All commands completed.", new Throwable[0]);
        this.stopForeground(true);
        SystemForegroundService.g = null;
        this.stopSelf();
    }
}
