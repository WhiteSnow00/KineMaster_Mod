// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.Parcelable;
import android.content.BroadcastReceiver$PendingResult;
import java.util.concurrent.Executor;
import android.app.PendingIntent$CanceledException;
import android.app.PendingIntent;
import com.google.android.gms.tasks.Task;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import android.os.Bundle;
import com.google.android.gms.tasks.Tasks;
import android.text.TextUtils;
import android.content.Intent;
import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.internal.cloudmessaging.zze;
import java.util.concurrent.ExecutorService;
import android.content.BroadcastReceiver;

public abstract class CloudMessagingReceiver extends BroadcastReceiver
{
    private final ExecutorService a;
    
    public CloudMessagingReceiver() {
        zze.zza();
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new NamedThreadFactory("firebase-iid-executor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.a = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
    
    private final int e(final Context ex, final Intent intent) {
        if (intent.getExtras() == null) {
            return 500;
        }
        final String stringExtra = intent.getStringExtra("google.message_id");
        Task task;
        if (TextUtils.isEmpty((CharSequence)stringExtra)) {
            task = Tasks.e((Object)null);
        }
        else {
            final Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            task = zzs.b((Context)ex).c(2, bundle);
        }
        final int b = this.b((Context)ex, new CloudMessage(intent));
        try {
            Tasks.b(task, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
            return b;
        }
        catch (final TimeoutException ex) {}
        catch (final InterruptedException ex) {}
        catch (final ExecutionException ex2) {}
        final String value = String.valueOf(ex);
        final StringBuilder sb = new StringBuilder(value.length() + 20);
        sb.append("Message ack failed: ");
        sb.append(value);
        Log.w("CloudMessagingReceiver", sb.toString());
        return b;
    }
    
    private final int f(final Context context, final Intent intent) {
        final PendingIntent pendingIntent = (PendingIntent)intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            }
            catch (final PendingIntent$CanceledException ex) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        }
        else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            this.c(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }
    
    protected Executor a() {
        return this.a;
    }
    
    protected abstract int b(final Context p0, final CloudMessage p1);
    
    protected void c(final Context context, final Bundle bundle) {
    }
    
    public final void d(final Intent intent, final Context context, final boolean b, final BroadcastReceiver$PendingResult broadcastReceiver$PendingResult) {
        try {
            final Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2;
            if (parcelableExtra instanceof Intent) {
                intent2 = (Intent)parcelableExtra;
            }
            else {
                intent2 = null;
            }
            int resultCode;
            if (intent2 != null) {
                resultCode = this.f(context, intent2);
            }
            else {
                resultCode = this.e(context, intent);
            }
            if (b) {
                broadcastReceiver$PendingResult.setResultCode(resultCode);
            }
        }
        finally {
            broadcastReceiver$PendingResult.finish();
        }
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        this.a().execute(new com.google.android.gms.cloudmessaging.zze(this, intent, context, this.isOrderedBroadcast(), this.goAsync()));
    }
    
    public static final class IntentActionKeys
    {
        private IntentActionKeys() {
        }
    }
    
    public static final class IntentKeys
    {
        private IntentKeys() {
        }
    }
}
