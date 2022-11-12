// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import android.content.Intent;
import com.google.firebase.crashlytics.internal.Logger;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.Context;

class b
{
    private final Float a;
    private final boolean b;
    
    private b(final Float a, final boolean b) {
        this.b = b;
        this.a = a;
    }
    
    public static b a(final Context context) {
        final Float n = null;
        final boolean b = false;
        boolean e;
        final boolean b2 = e = false;
        Float d;
        try {
            e = b2;
            final IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            e = b2;
            final Intent registerReceiver = context.registerReceiver((BroadcastReceiver)null, intentFilter);
            d = n;
            e = b;
            if (registerReceiver != null) {
                e = b2;
                e = e(registerReceiver);
                d = d(registerReceiver);
                e = e;
            }
        }
        catch (final IllegalStateException ex) {
            Logger.f().e("An error occurred getting battery state.", ex);
            d = n;
        }
        return new b(d, e);
    }
    
    private static Float d(final Intent intent) {
        final int intExtra = intent.getIntExtra("level", -1);
        final int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra != -1 && intExtra2 != -1) {
            return intExtra / (float)intExtra2;
        }
        return null;
    }
    
    private static boolean e(final Intent intent) {
        final int intExtra = intent.getIntExtra("status", -1);
        boolean b = false;
        if (intExtra == -1) {
            return false;
        }
        if (intExtra == 2 || intExtra == 5) {
            b = true;
        }
        return b;
    }
    
    public Float b() {
        return this.a;
    }
    
    public int c() {
        if (this.b) {
            final Float a = this.a;
            if (a != null) {
                if (a < 0.99) {
                    return 2;
                }
                return 3;
            }
        }
        return 1;
    }
}
