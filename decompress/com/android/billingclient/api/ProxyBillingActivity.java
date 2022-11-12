// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import android.os.Parcelable;
import android.content.IntentSender$SendIntentException;
import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import android.content.Intent;
import android.os.ResultReceiver;
import com.google.android.apps.common.proguard.UsedByReflection;
import android.app.Activity;

@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivity extends Activity
{
    private ResultReceiver a;
    private ResultReceiver b;
    private boolean c;
    
    private Intent a(final String s) {
        final Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(this.getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", s);
        return intent;
    }
    
    private Intent b() {
        final Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(this.getApplicationContext().getPackageName());
        return intent;
    }
    
    protected void onActivityResult(int zza, final int n, Intent intent) {
        super.onActivityResult(zza, n, intent);
        final Bundle bundle = null;
        final Bundle bundle2 = null;
        if (zza == 100) {
            final int b = zzb.zzi(intent, "ProxyBillingActivity").b();
            Label_0105: {
                if ((zza = n) == -1) {
                    if (b == 0) {
                        zza = 0;
                        break Label_0105;
                    }
                    zza = -1;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Activity finished with resultCode ");
                sb.append(zza);
                sb.append(" and billing's responseCode: ");
                sb.append(b);
                zzb.zzo("ProxyBillingActivity", sb.toString());
                zza = b;
            }
            final ResultReceiver a = this.a;
            if (a != null) {
                Bundle extras;
                if (intent == null) {
                    extras = bundle2;
                }
                else {
                    extras = intent.getExtras();
                }
                a.send(zza, extras);
            }
            else {
                if (intent != null) {
                    if (intent.getExtras() != null) {
                        final String string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                        if (string != null) {
                            intent = this.a(string);
                        }
                        else {
                            final Intent b2 = this.b();
                            b2.putExtras(intent.getExtras());
                            intent = b2;
                        }
                    }
                    else {
                        intent = this.b();
                        zzb.zzo("ProxyBillingActivity", "Got null bundle!");
                        intent.putExtra("RESPONSE_CODE", 6);
                        intent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    }
                }
                else {
                    intent = this.b();
                }
                this.sendBroadcast(intent);
            }
        }
        else if (zza == 101) {
            zza = zzb.zza(intent, "ProxyBillingActivity");
            final ResultReceiver b3 = this.b;
            if (b3 != null) {
                Bundle extras2;
                if (intent == null) {
                    extras2 = bundle;
                }
                else {
                    extras2 = intent.getExtras();
                }
                b3.send(zza, extras2);
            }
        }
        else {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Got onActivityResult with wrong requestCode: ");
            sb2.append(zza);
            sb2.append("; skipping...");
            zzb.zzo("ProxyBillingActivity", sb2.toString());
        }
        this.c = false;
        this.finish();
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            zzb.zzn("ProxyBillingActivity", "Launching Play Store billing flow");
            final boolean hasExtra = this.getIntent().hasExtra("BUY_INTENT");
            int n = 100;
            PendingIntent pendingIntent;
            if (hasExtra) {
                pendingIntent = (PendingIntent)this.getIntent().getParcelableExtra("BUY_INTENT");
            }
            else if (this.getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent = (PendingIntent)this.getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.a = (ResultReceiver)this.getIntent().getParcelableExtra("result_receiver");
            }
            else if (this.getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent = (PendingIntent)this.getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.b = (ResultReceiver)this.getIntent().getParcelableExtra("in_app_message_result_receiver");
                n = 101;
            }
            else {
                pendingIntent = null;
            }
            try {
                this.c = true;
                this.startIntentSenderForResult(pendingIntent.getIntentSender(), n, new Intent(), 0, 0, 0);
                return;
            }
            catch (final IntentSender$SendIntentException ex) {
                zzb.zzp("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", (Throwable)ex);
                final ResultReceiver a = this.a;
                if (a != null) {
                    a.send(6, (Bundle)null);
                }
                else {
                    final ResultReceiver b = this.b;
                    if (b != null) {
                        b.send(0, (Bundle)null);
                    }
                    else {
                        final Intent b2 = this.b();
                        b2.putExtra("RESPONSE_CODE", 6);
                        b2.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                        this.sendBroadcast(b2);
                    }
                }
                this.c = false;
                this.finish();
                return;
            }
        }
        zzb.zzn("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
        this.c = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
        if (bundle.containsKey("result_receiver")) {
            this.a = (ResultReceiver)bundle.getParcelable("result_receiver");
            return;
        }
        if (bundle.containsKey("in_app_message_result_receiver")) {
            this.b = (ResultReceiver)bundle.getParcelable("in_app_message_result_receiver");
        }
    }
    
    protected void onDestroy() {
        super.onDestroy();
        if (!this.isFinishing()) {
            return;
        }
        if (!this.c) {
            return;
        }
        final Intent b = this.b();
        b.putExtra("RESPONSE_CODE", 1);
        b.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
        this.sendBroadcast(b);
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        final ResultReceiver a = this.a;
        if (a != null) {
            bundle.putParcelable("result_receiver", (Parcelable)a);
        }
        final ResultReceiver b = this.b;
        if (b != null) {
            bundle.putParcelable("in_app_message_result_receiver", (Parcelable)b);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.c);
    }
}
