// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzt;
import android.telephony.TelephonyManager;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.content.Context;

public class zzv extends zzu
{
    @Override
    public final void f(final Context context) {
        final NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", (CharSequence)"AdMob Offline Notifications", 2);
        notificationChannel.setShowBadge(false);
        ((NotificationManager)context.getSystemService((Class)NotificationManager.class)).createNotificationChannel(notificationChannel);
    }
    
    @Override
    public final int g(final Context context, final TelephonyManager telephonyManager) {
        com.google.android.gms.ads.internal.zzt.q();
        if (zzs.T(context, "android.permission.ACCESS_NETWORK_STATE") && telephonyManager.isDataEnabled()) {
            return 2;
        }
        return 1;
    }
}
