// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.SuccessContinuation;
import java.io.IOException;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.OnCompleteListener;
import java.util.concurrent.ScheduledFuture;
import android.os.RemoteException;
import java.util.regex.Matcher;
import android.os.Parcelable;
import android.util.Log;
import android.content.Intent;
import android.os.Message;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import java.util.concurrent.ScheduledExecutorService;
import android.content.Context;
import javax.annotation.concurrent.GuardedBy;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import androidx.collection.g;
import java.util.regex.Pattern;
import java.util.concurrent.Executor;
import android.app.PendingIntent;

public class Rpc
{
    private static int h;
    private static PendingIntent i;
    private static final Executor j;
    private static final Pattern k;
    @GuardedBy
    private final g<String, TaskCompletionSource<Bundle>> a;
    private final Context b;
    private final zzt c;
    private final ScheduledExecutorService d;
    private Messenger e;
    private Messenger f;
    private zzd g;
    
    static {
        j = zzz.a;
        k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    }
    
    public Rpc(final Context b) {
        this.a = new g<String, TaskCompletionSource<Bundle>>();
        this.b = b;
        this.c = new zzt(b);
        this.e = new Messenger((Handler)new a(this, Looper.getMainLooper()));
        final ScheduledThreadPoolExecutor d = new ScheduledThreadPoolExecutor(1);
        d.setKeepAliveTime(60L, TimeUnit.SECONDS);
        d.allowCoreThreadTimeOut(true);
        this.d = d;
    }
    
    static Task b(final Bundle bundle) throws Exception {
        if (j(bundle)) {
            return Tasks.e((Object)null);
        }
        return Tasks.e((Object)bundle);
    }
    
    static /* bridge */ void d(final Rpc rpc, Message a) {
        if (a != null) {
            final Object obj = a.obj;
            if (obj instanceof Intent) {
                final Intent intent = (Intent)obj;
                intent.setExtrasClassLoader((ClassLoader)new zzc());
                if (intent.hasExtra("google.messenger")) {
                    final Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        rpc.g = (zzd)parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        rpc.f = (Messenger)parcelableExtra;
                    }
                }
                final Intent intent2 = (Intent)a.obj;
                final String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("Rpc", 3)) {
                        final String value = String.valueOf(action);
                        String concat;
                        if (value.length() != 0) {
                            concat = "Unexpected response action: ".concat(value);
                        }
                        else {
                            concat = new String("Unexpected response action: ");
                        }
                        Log.d("Rpc", concat);
                    }
                }
                else {
                    String s;
                    if ((s = intent2.getStringExtra("registration_id")) == null) {
                        s = intent2.getStringExtra("unregistered");
                    }
                    if (s == null) {
                        final String stringExtra = intent2.getStringExtra("error");
                        if (stringExtra == null) {
                            final String value2 = String.valueOf(intent2.getExtras());
                            final StringBuilder sb = new StringBuilder(value2.length() + 49);
                            sb.append("Unexpected response, no error or registration id ");
                            sb.append(value2);
                            Log.w("Rpc", sb.toString());
                            return;
                        }
                        if (Log.isLoggable("Rpc", 3)) {
                            String concat2;
                            if (stringExtra.length() != 0) {
                                concat2 = "Received InstanceID error ".concat(stringExtra);
                            }
                            else {
                                concat2 = new String("Received InstanceID error ");
                            }
                            Log.d("Rpc", concat2);
                        }
                        if (stringExtra.startsWith("|")) {
                            final String[] split = stringExtra.split("\\|");
                            if (split.length > 2 && "ID".equals(split[1])) {
                                final String s2 = split[2];
                                String substring;
                                final String s3 = substring = split[3];
                                if (s3.startsWith(":")) {
                                    substring = s3.substring(1);
                                }
                                rpc.i(s2, intent2.putExtra("error", substring).getExtras());
                                return;
                            }
                            String concat3;
                            if (stringExtra.length() != 0) {
                                concat3 = "Unexpected structured response ".concat(stringExtra);
                            }
                            else {
                                concat3 = new String("Unexpected structured response ");
                            }
                            Log.w("Rpc", concat3);
                            return;
                        }
                        else {
                            a = (Message)rpc.a;
                            monitorenter(a);
                            int i = 0;
                            try {
                                while (i < rpc.a.size()) {
                                    rpc.i(rpc.a.i(i), intent2.getExtras());
                                    ++i;
                                }
                                return;
                            }
                            finally {
                                monitorexit(a);
                            }
                        }
                    }
                    final Matcher matcher = Rpc.k.matcher(s);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("Rpc", 3)) {
                            String concat4;
                            if (s.length() != 0) {
                                concat4 = "Unexpected response string: ".concat(s);
                            }
                            else {
                                concat4 = new String("Unexpected response string: ");
                            }
                            Log.d("Rpc", concat4);
                        }
                    }
                    else {
                        final String group = matcher.group(1);
                        final String group2 = matcher.group(2);
                        if (group != null) {
                            final Bundle extras = intent2.getExtras();
                            extras.putString("registration_id", group2);
                            rpc.i(group, extras);
                        }
                    }
                }
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }
    
    private final Task<Bundle> f(final Bundle bundle) {
        final String g = g();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Object a = this.a;
        synchronized (a) {
            this.a.put(g, (TaskCompletionSource<Bundle>)taskCompletionSource);
            monitorexit(a);
            a = new Intent();
            ((Intent)a).setPackage("com.google.android.gms");
            if (this.c.b() == 2) {
                ((Intent)a).setAction("com.google.iid.TOKEN_REQUEST");
            }
            else {
                ((Intent)a).setAction("com.google.android.c2dm.intent.REGISTER");
            }
            ((Intent)a).putExtras(bundle);
            h(this.b, (Intent)a);
            final StringBuilder sb = new StringBuilder(String.valueOf(g).length() + 5);
            sb.append("|ID|");
            sb.append(g);
            sb.append("|");
            ((Intent)a).putExtra("kid", sb.toString());
            if (Log.isLoggable("Rpc", 3)) {
                final String value = String.valueOf(((Intent)a).getExtras());
                final StringBuilder sb2 = new StringBuilder(value.length() + 8);
                sb2.append("Sending ");
                sb2.append(value);
                Log.d("Rpc", sb2.toString());
            }
            ((Intent)a).putExtra("google.messenger", (Parcelable)this.e);
            Label_0332: {
                if (this.f != null || this.g != null) {
                    final Message obtain = Message.obtain();
                    obtain.obj = a;
                    try {
                        final Messenger f = this.f;
                        if (f != null) {
                            f.send(obtain);
                            break Label_0332;
                        }
                        this.g.b(obtain);
                        break Label_0332;
                    }
                    catch (final RemoteException ex) {
                        if (Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", "Messenger failed, fallback to startService");
                        }
                    }
                }
                if (this.c.b() == 2) {
                    this.b.sendBroadcast((Intent)a);
                }
                else {
                    this.b.startService((Intent)a);
                }
            }
            taskCompletionSource.a().d(Rpc.j, (OnCompleteListener)new zzw(this, g, this.d.schedule(new zzy(taskCompletionSource), 30L, TimeUnit.SECONDS)));
            return (Task<Bundle>)taskCompletionSource.a();
        }
    }
    
    private static String g() {
        synchronized (Rpc.class) {
            final int h = Rpc.h;
            Rpc.h = h + 1;
            return Integer.toString(h);
        }
    }
    
    private static void h(final Context context, final Intent intent) {
        synchronized (Rpc.class) {
            if (Rpc.i == null) {
                final Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                Rpc.i = zza.zza(context, 0, intent2, zza.zza);
            }
            intent.putExtra("app", (Parcelable)Rpc.i);
        }
    }
    
    private final void i(String s, final Bundle bundle) {
        synchronized (this.a) {
            final TaskCompletionSource taskCompletionSource = this.a.remove(s);
            if (taskCompletionSource == null) {
                s = String.valueOf(s);
                if (s.length() != 0) {
                    s = "Missing callback for ".concat(s);
                }
                else {
                    s = new String("Missing callback for ");
                }
                Log.w("Rpc", s);
                return;
            }
            taskCompletionSource.c((Object)bundle);
        }
    }
    
    private static boolean j(final Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }
    
    public Task<Bundle> a(final Bundle bundle) {
        if (this.c.a() < 12000000) {
            Task task;
            if (this.c.b() != 0) {
                task = this.f(bundle).n(Rpc.j, (Continuation)new zzu(this, bundle));
            }
            else {
                task = Tasks.d((Exception)new IOException("MISSING_INSTANCEID_SERVICE"));
            }
            return (Task<Bundle>)task;
        }
        return (Task<Bundle>)zzs.b(this.b).d(1, bundle).l(Rpc.j, (Continuation)zzv.a);
    }
    
    public final Task c(final Bundle bundle, final Task task) throws Exception {
        if (!task.t()) {
            return task;
        }
        if (!j((Bundle)task.p())) {
            return task;
        }
        return this.f(bundle).v(Rpc.j, (SuccessContinuation)zzx.a);
    }
    
    public final void e(final String s, final ScheduledFuture scheduledFuture, final Task task) {
        synchronized (this.a) {
            this.a.remove(s);
            monitorexit(this.a);
            scheduledFuture.cancel(false);
        }
    }
}
