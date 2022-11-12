// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzee;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import android.content.Context;

public class MobileAds
{
    private MobileAds() {
    }
    
    public static void a(final Context context, final OnInitializationCompleteListener onInitializationCompleteListener) {
        zzee.f().k(context, null, onInitializationCompleteListener);
    }
}
