// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Api;
import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import android.util.SparseIntArray;

public final class zal
{
    private final SparseIntArray a;
    private GoogleApiAvailabilityLight b;
    
    public zal() {
        this(GoogleApiAvailability.q());
    }
    
    public zal(final GoogleApiAvailabilityLight b) {
        this.a = new SparseIntArray();
        Preconditions.k(b);
        this.b = b;
    }
    
    public final int a(final Context context, final int n) {
        return this.a.get(n, -1);
    }
    
    public final int b(final Context context, final Api.Client client) {
        Preconditions.k(context);
        Preconditions.k(client);
        final boolean requiresGooglePlayServices = client.requiresGooglePlayServices();
        final int n = 0;
        if (!requiresGooglePlayServices) {
            return 0;
        }
        final int minApkVersion = client.getMinApkVersion();
        int n2 = this.a(context, minApkVersion);
        if (n2 == -1) {
            while (true) {
                for (int i = 0; i < this.a.size(); ++i) {
                    final int key = this.a.keyAt(i);
                    if (key > minApkVersion && this.a.get(key) == 0) {
                        n2 = n;
                        if (n2 == -1) {
                            n2 = this.b.j(context, minApkVersion);
                        }
                        this.a.put(minApkVersion, n2);
                        return n2;
                    }
                }
                n2 = -1;
                continue;
            }
        }
        return n2;
    }
    
    public final void c() {
        this.a.clear();
    }
}
