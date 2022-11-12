// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk$OnEventListener;

final class a implements AppMeasurementSdk$OnEventListener
{
    final zze a;
    
    public a(final zze a) {
        this.a = a;
    }
    
    public final void a(final String s, final String s2, final Bundle bundle, final long n) {
        if (!this.a.a.contains(s2)) {
            return;
        }
        final Bundle bundle2 = new Bundle();
        bundle2.putString("events", zzc.c(s2));
        zze.b(this.a).a(2, bundle2);
    }
}
