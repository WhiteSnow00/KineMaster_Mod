// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.content.res.Resources;
import android.content.Context;

public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight
{
    @Deprecated
    public static final int f;
    
    static {
        f = GooglePlayServicesUtilLight.a;
    }
    
    private GooglePlayServicesUtil() {
    }
    
    public static Resources f(final Context context) {
        return GooglePlayServicesUtilLight.f(context);
    }
}
