// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.content.ActivityNotFoundException;
import android.util.Log;
import android.os.Build;
import android.content.DialogInterface;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import android.content.Intent;
import android.app.Activity;
import android.content.DialogInterface$OnClickListener;

public abstract class zag implements DialogInterface$OnClickListener
{
    public static zag b(final Activity activity, final Intent intent, final int n) {
        return new a(intent, activity, n);
    }
    
    public static zag c(final LifecycleFragment lifecycleFragment, final Intent intent, final int n) {
        return new b(intent, lifecycleFragment, 2);
    }
    
    protected abstract void a();
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        try {
            try {
                this.a();
                dialogInterface.dismiss();
                return;
            }
            finally {}
        }
        catch (final ActivityNotFoundException ex) {
            String s = "Failed to start resolution intent.";
            if (Build.FINGERPRINT.contains("generic")) {
                s = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
            }
            Log.e("DialogRedirect", s, (Throwable)ex);
            dialogInterface.dismiss();
            return;
        }
        dialogInterface.dismiss();
    }
}
