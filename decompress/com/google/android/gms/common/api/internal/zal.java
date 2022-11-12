// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.ConnectionResult;
import java.util.Set;
import com.google.android.gms.tasks.TaskCompletionSource;
import androidx.collection.a;

public final class zal
{
    private final a a;
    private final a b;
    private final TaskCompletionSource c;
    private int d;
    private boolean e;
    
    public final Set a() {
        return this.a.keySet();
    }
    
    public final void b(final ApiKey apiKey, final ConnectionResult connectionResult, final String s) {
        this.a.put(apiKey, connectionResult);
        this.b.put(apiKey, s);
        --this.d;
        if (!connectionResult.O1()) {
            this.e = true;
        }
        if (this.d == 0) {
            if (this.e) {
                this.c.b((Exception)new AvailabilityException(this.a));
                return;
            }
            this.c.c((Object)this.b);
        }
    }
}
