// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.util.Log;

public final class zzc extends ClassLoader
{
    @Override
    protected final Class<?> loadClass(final String s, final boolean b) throws ClassNotFoundException {
        if ("com.google.android.gms.iid.MessengerCompat".equals(s)) {
            if (Log.isLoggable("CloudMessengerCompat", 3)) {
                Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
            }
            return zzd.class;
        }
        return super.loadClass(s, b);
    }
}
