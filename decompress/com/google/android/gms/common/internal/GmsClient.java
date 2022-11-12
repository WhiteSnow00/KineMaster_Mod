// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import java.util.Collections;
import com.google.android.gms.common.Feature;
import java.util.Iterator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import android.os.Looper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GoogleApiAvailability;
import android.os.Handler;
import android.content.Context;
import android.accounts.Account;
import java.util.Set;
import java.util.concurrent.Executor;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import android.os.IInterface;

@KeepForSdk
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Client, zaj
{
    private static volatile Executor zaa;
    private final ClientSettings zab;
    private final Set zac;
    private final Account zad;
    
    @KeepForSdk
    @VisibleForTesting
    protected GmsClient(final Context context, final Handler handler, final int n, final ClientSettings clientSettings) {
        super(context, handler, GmsClientSupervisor.c(context), GoogleApiAvailability.q(), n, null, null);
        this.zab = Preconditions.k(clientSettings);
        this.zad = clientSettings.a();
        this.zac = this.zaa(clientSettings.d());
    }
    
    @KeepForSdk
    protected GmsClient(final Context context, final Looper looper, final int n, final ClientSettings clientSettings) {
        this(context, looper, GmsClientSupervisor.c(context), GoogleApiAvailability.q(), n, clientSettings, null, null);
    }
    
    @Deprecated
    @KeepForSdk
    protected GmsClient(final Context context, final Looper looper, final int n, final ClientSettings clientSettings, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, n, clientSettings, connectionCallbacks, (OnConnectionFailedListener)onConnectionFailedListener);
    }
    
    @KeepForSdk
    protected GmsClient(final Context context, final Looper looper, final int n, final ClientSettings clientSettings, final ConnectionCallbacks connectionCallbacks, final OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.c(context), GoogleApiAvailability.q(), n, clientSettings, Preconditions.k(connectionCallbacks), Preconditions.k(onConnectionFailedListener));
    }
    
    @VisibleForTesting
    protected GmsClient(final Context context, final Looper looper, final GmsClientSupervisor gmsClientSupervisor, final GoogleApiAvailability googleApiAvailability, final int n, final ClientSettings zab, final ConnectionCallbacks connectionCallbacks, final OnConnectionFailedListener onConnectionFailedListener) {
        Object o;
        if (connectionCallbacks == null) {
            o = null;
        }
        else {
            o = new c(connectionCallbacks);
        }
        Object o2;
        if (onConnectionFailedListener == null) {
            o2 = null;
        }
        else {
            o2 = new d(onConnectionFailedListener);
        }
        super(context, looper, gmsClientSupervisor, googleApiAvailability, n, (BaseConnectionCallbacks)o, (BaseOnConnectionFailedListener)o2, zab.j());
        this.zab = zab;
        this.zad = zab.a();
        this.zac = this.zaa(zab.d());
    }
    
    private final Set zaa(final Set set) {
        final Set<Scope> validateScopes = this.validateScopes(set);
        final Iterator<Scope> iterator = validateScopes.iterator();
        while (iterator.hasNext()) {
            if (set.contains(iterator.next())) {
                continue;
            }
            throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
        }
        return validateScopes;
    }
    
    @Override
    public final Account getAccount() {
        return this.zad;
    }
    
    @Override
    protected final Executor getBindServiceExecutor() {
        return null;
    }
    
    @KeepForSdk
    protected final ClientSettings getClientSettings() {
        return this.zab;
    }
    
    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }
    
    @KeepForSdk
    @Override
    protected final Set<Scope> getScopes() {
        return this.zac;
    }
    
    @KeepForSdk
    @Override
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        Set<Object> set;
        if (this.requiresSignIn()) {
            set = this.zac;
        }
        else {
            set = Collections.emptySet();
        }
        return (Set<Scope>)set;
    }
    
    @KeepForSdk
    protected Set<Scope> validateScopes(final Set<Scope> set) {
        return set;
    }
}
