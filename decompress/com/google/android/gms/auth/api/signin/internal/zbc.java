// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import java.util.Iterator;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.api.GoogleApiClient;
import android.content.Context;
import java.util.Set;
import java.util.concurrent.Semaphore;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import androidx.loader.content.a;

public final class zbc extends a implements SignInConnectionListener
{
    private final Semaphore p;
    private final Set q;
    
    public zbc(final Context context, final Set q) {
        super(context);
        this.p = new Semaphore(0);
        this.q = q;
    }
    
    @Override
    public final /* bridge */ Object A() {
        final Iterator iterator = this.q.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            if (((GoogleApiClient)iterator.next()).n(this)) {
                ++n;
            }
        }
        try {
            this.p.tryAcquire(n, 5L, TimeUnit.SECONDS);
        }
        catch (final InterruptedException ex) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", (Throwable)ex);
            Thread.currentThread().interrupt();
        }
        return null;
    }
    
    @Override
    protected final void o() {
        this.p.drainPermits();
        this.h();
    }
    
    @Override
    public final void onComplete() {
        this.p.release();
    }
}
