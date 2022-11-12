// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.appset;

import com.google.android.gms.internal.appset.zzr;
import android.content.Context;

public final class AppSet
{
    private AppSet() {
    }
    
    public static AppSetIdClient a(final Context context) {
        return (AppSetIdClient)new zzr(context);
    }
}
