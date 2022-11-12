// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk$OnEventListener;

final class b implements AppMeasurementSdk$OnEventListener
{
    final zzg a;
    
    public b(final zzg a) {
        this.a = a;
    }
    
    public final void a(final String s, final String s2, final Bundle bundle, final long n) {
        if (s != null && !s.equals("crash") && zzc.k(s2)) {
            final Bundle bundle2 = new Bundle();
            bundle2.putString("name", s2);
            bundle2.putLong("timestampInMillis", n);
            bundle2.putBundle("params", bundle);
            zzg.b(this.a).a(3, bundle2);
        }
    }
}
