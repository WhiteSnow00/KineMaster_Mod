// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.NotificationUtil;
import android.os.IBinder;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import android.content.Intent;
import android.content.Context;
import java.util.List;
import java.util.HashMap;
import android.app.Service;

public abstract class DownloadService extends Service
{
    private static final HashMap<Class<? extends DownloadService>, b> j;
    private final String a;
    private final int b;
    private final int c;
    private b d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    
    static {
        j = new HashMap<Class<? extends DownloadService>, b>();
    }
    
    static void a(final DownloadService downloadService, final List list) {
        downloadService.g(list);
    }
    
    static boolean b(final DownloadService downloadService) {
        return downloadService.f();
    }
    
    static Intent c(final Context context, final Class clazz, final String s) {
        return e(context, clazz, s);
    }
    
    private static Intent e(final Context context, final Class<? extends DownloadService> clazz, final String action) {
        return new Intent(context, (Class)clazz).setAction(action);
    }
    
    private boolean f() {
        return this.h;
    }
    
    private void g(final List<Download> list) {
    }
    
    private void h() {
        if (!Assertions.e(this.d).l()) {
            return;
        }
        if (Util.a < 28 && this.g) {
            this.stopSelf();
            this.h = true;
        }
        else {
            this.h |= this.stopSelfResult(this.e);
        }
    }
    
    protected abstract DownloadManager d();
    
    public final IBinder onBind(final Intent intent) {
        throw new UnsupportedOperationException();
    }
    
    public void onCreate() {
        final String a = this.a;
        if (a != null) {
            NotificationUtil.a((Context)this, a, this.b, this.c, 2);
        }
        final Class<? extends DownloadService> class1 = this.getClass();
        final HashMap<Class<? extends DownloadService>, b> j = DownloadService.j;
        b d;
        if ((d = j.get(class1)) == null) {
            final int a2 = Util.a;
            final DownloadManager d2 = this.d();
            d2.n();
            d = new b(this.getApplicationContext(), d2, false, null, class1, null);
            j.put(class1, d);
        }
        (this.d = d).e(this);
    }
    
    public void onDestroy() {
        this.i = true;
        Assertions.e(this.d).g(this);
    }
    
    public int onStartCommand(final Intent intent, int n, final int e) {
        this.e = e;
        this.g = false;
        String action = null;
        String stringExtra;
        if (intent != null) {
            action = intent.getAction();
            stringExtra = intent.getStringExtra("content_id");
            final boolean f = this.f;
            if (!intent.getBooleanExtra("foreground", false) && !"com.google.android.exoplayer.downloadService.action.RESTART".equals(action)) {
                n = 0;
            }
            else {
                n = 1;
            }
            this.f = (((f ? 1 : 0) | n) != 0x0);
        }
        else {
            stringExtra = null;
        }
        String s = action;
        if (action == null) {
            s = "com.google.android.exoplayer.downloadService.action.INIT";
        }
        final DownloadManager d = DownloadService.b.d(Assertions.e(this.d));
        n = -1;
        switch (s) {
            case "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD": {
                n = 8;
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.INIT": {
                n = 7;
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON": {
                n = 6;
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS": {
                n = 5;
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS": {
                n = 4;
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS": {
                n = 3;
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.RESTART": {
                n = 2;
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS": {
                n = 1;
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD": {
                n = 0;
                break;
            }
            default:
                break;
        }
        while (true) {
            switch (n) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Ignored unrecognized action: ");
                    sb.append(s);
                    Log.c("DownloadService", sb.toString());
                    break Label_0626;
                }
                case 8: {
                    if (stringExtra == null) {
                        Log.c("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                        break Label_0626;
                    }
                    d.m(stringExtra);
                    break Label_0626;
                }
                case 6: {
                    if (!Assertions.e(intent).hasExtra("stop_reason")) {
                        Log.c("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                        break Label_0626;
                    }
                    d.q(stringExtra, intent.getIntExtra("stop_reason", 0));
                    break Label_0626;
                }
                case 4: {
                    final Requirements requirements = (Requirements)Assertions.e(intent).getParcelableExtra("requirements");
                    if (requirements == null) {
                        Log.c("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                        break Label_0626;
                    }
                    d.p(requirements);
                    break Label_0626;
                }
                case 0: {
                    final DownloadRequest downloadRequest = (DownloadRequest)Assertions.e(intent).getParcelableExtra("download_request");
                    if (downloadRequest == null) {
                        Log.c("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                        break Label_0626;
                    }
                    d.a(downloadRequest, intent.getIntExtra("stop_reason", 0));
                    break Label_0626;
                }
                case 2:
                case 7: {
                    if (Util.a >= 26) {
                        final boolean f2 = this.f;
                    }
                    this.h = false;
                    if (d.f()) {
                        this.h();
                    }
                    return 1;
                }
                case 5: {
                    d.k();
                    continue;
                }
                case 3: {
                    d.l();
                    continue;
                }
                case 1: {
                    d.n();
                    continue;
                }
            }
            break;
        }
    }
    
    public void onTaskRemoved(final Intent intent) {
        this.g = true;
    }
    
    private static final class b implements Listener
    {
        private final Context a;
        private final DownloadManager b;
        private final boolean c;
        private final Scheduler d;
        private final Class<? extends DownloadService> e;
        private DownloadService f;
        private Requirements g;
        
        private b(final Context a, final DownloadManager b, final boolean c, final Scheduler d, final Class<? extends DownloadService> e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            b.b((DownloadManager.Listener)this);
            this.l();
        }
        
        b(final Context context, final DownloadManager downloadManager, final boolean b, final Scheduler scheduler, final Class clazz, final DownloadService$a object) {
            this(context, downloadManager, b, scheduler, clazz);
        }
        
        public static void c(final b b, final DownloadService downloadService) {
            b.h(downloadService);
        }
        
        static DownloadManager d(final b b) {
            return b.b;
        }
        
        private void f() {
            final Requirements g = new Requirements(0);
            if (this.j(g)) {
                this.d.cancel();
                this.g = g;
            }
        }
        
        private void h(final DownloadService downloadService) {
            DownloadService.a(downloadService, this.b.c());
        }
        
        private void i() {
            if (this.c) {
                try {
                    Util.W0(this.a, DownloadService.c(this.a, this.e, "com.google.android.exoplayer.downloadService.action.RESTART"));
                }
                catch (final IllegalStateException ex) {
                    Log.i("DownloadService", "Failed to restart (foreground launch restriction)");
                }
            }
            else {
                try {
                    this.a.startService(DownloadService.c(this.a, this.e, "com.google.android.exoplayer.downloadService.action.INIT"));
                }
                catch (final IllegalStateException ex2) {
                    Log.i("DownloadService", "Failed to restart (process is idle)");
                }
            }
        }
        
        private boolean j(final Requirements requirements) {
            return Util.c(this.g, requirements) ^ true;
        }
        
        private boolean k() {
            final DownloadService f = this.f;
            return f == null || DownloadService.b(f);
        }
        
        @Override
        public void a(final DownloadManager downloadManager, final boolean b) {
            if (!b && !downloadManager.d() && this.k()) {
                final List<Download> c = downloadManager.c();
                for (int i = 0; i < c.size(); ++i) {
                    if (((Download)c.get(i)).a == 0) {
                        this.i();
                        return;
                    }
                }
            }
        }
        
        @Override
        public void b(final DownloadManager downloadManager, final Requirements requirements, final int n) {
            this.l();
        }
        
        public void e(final DownloadService f) {
            Assertions.g(this.f == null);
            this.f = f;
            if (this.b.g()) {
                Util.y().postAtFrontOfQueue((Runnable)new a(this, f));
            }
        }
        
        public void g(final DownloadService downloadService) {
            Assertions.g(this.f == downloadService);
            this.f = null;
        }
        
        public boolean l() {
            final boolean h = this.b.h();
            if (this.d == null) {
                return h ^ true;
            }
            if (!h) {
                this.f();
                return true;
            }
            final Requirements e = this.b.e();
            if (!this.d.b(e).equals(e)) {
                this.f();
                return false;
            }
            if (!this.j(e)) {
                return true;
            }
            if (this.d.a(e, this.a.getPackageName(), "com.google.android.exoplayer.downloadService.action.RESTART")) {
                this.g = e;
                return true;
            }
            Log.i("DownloadService", "Failed to schedule restart");
            this.f();
            return false;
        }
    }
}
