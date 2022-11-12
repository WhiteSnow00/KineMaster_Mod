// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

public final class NotificationUtil
{
    private NotificationUtil() {
    }
    
    public static void a(final Context context, final String s, final int n, final int n2, final int n3) {
        if (Util.a >= 26) {
            final NotificationManager notificationManager = Assertions.e(context.getSystemService("notification"));
            final NotificationChannel notificationChannel = new NotificationChannel(s, (CharSequence)context.getString(n), n3);
            if (n2 != 0) {
                notificationChannel.setDescription(context.getString(n2));
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Importance {
    }
}
