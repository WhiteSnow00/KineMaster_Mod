// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import android.content.Intent;
import java.util.Set;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.Feature;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import android.accounts.Account;
import java.util.Collections;
import java.util.List;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

public final class Api<O extends ApiOptions>
{
    private final AbstractClientBuilder a;
    private final ClientKey b;
    private final String c;
    
    @KeepForSdk
    public <C extends Client> Api(final String c, final AbstractClientBuilder<C, O> a, final ClientKey<C> b) {
        Preconditions.l(a, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.l(b, "Cannot construct an Api with a null ClientKey");
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public final AbstractClientBuilder a() {
        return this.a;
    }
    
    public final AnyClientKey b() {
        return (AnyClientKey)this.b;
    }
    
    public final BaseClientBuilder c() {
        return (BaseClientBuilder)this.a;
    }
    
    public final String d() {
        return this.c;
    }
    
    @KeepForSdk
    @VisibleForTesting
    public abstract static class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O>
    {
        @Deprecated
        @KeepForSdk
        public T c(final Context context, final Looper looper, final ClientSettings clientSettings, final O o, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return this.d(context, looper, clientSettings, o, connectionCallbacks, onConnectionFailedListener);
        }
        
        @KeepForSdk
        public T d(final Context context, final Looper looper, final ClientSettings clientSettings, final O o, final ConnectionCallbacks connectionCallbacks, final OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }
    
    @KeepForSdk
    @VisibleForTesting
    public abstract static class BaseClientBuilder<T extends AnyClient, O>
    {
        @KeepForSdk
        public List<Scope> a(final O o) {
            return Collections.emptyList();
        }
        
        @KeepForSdk
        public int b() {
            return Integer.MAX_VALUE;
        }
    }
    
    @KeepForSdk
    public interface AnyClient
    {
    }
    
    @KeepForSdk
    public static class AnyClientKey<C extends AnyClient>
    {
    }
    
    public interface ApiOptions
    {
        public static final NoOptions o = new NoOptions(null);
        
        public interface HasAccountOptions extends HasOptions, NotRequiredOptions
        {
            Account k1();
        }
        
        public interface HasOptions extends ApiOptions
        {
        }
        
        public interface NotRequiredOptions extends ApiOptions
        {
        }
        
        public interface HasGoogleSignInAccountOptions extends HasOptions
        {
            GoogleSignInAccount a1();
        }
        
        public static final class NoOptions implements NotRequiredOptions
        {
            private NoOptions() {
            }
            
            NoOptions(final zaa zaa) {
            }
        }
        
        public interface Optional extends HasOptions, NotRequiredOptions
        {
        }
    }
    
    @KeepForSdk
    public interface Client extends AnyClient
    {
        @KeepForSdk
        void connect(final BaseGmsClient.ConnectionProgressReportCallbacks p0);
        
        @KeepForSdk
        void disconnect();
        
        @KeepForSdk
        void disconnect(final String p0);
        
        @KeepForSdk
        void dump(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3);
        
        @KeepForSdk
        Feature[] getAvailableFeatures();
        
        @KeepForSdk
        String getEndpointPackageName();
        
        @KeepForSdk
        String getLastDisconnectMessage();
        
        @KeepForSdk
        int getMinApkVersion();
        
        @KeepForSdk
        void getRemoteService(final IAccountAccessor p0, final Set<Scope> p1);
        
        @KeepForSdk
        Set<Scope> getScopesForConnectionlessNonSignIn();
        
        @KeepForSdk
        Intent getSignInIntent();
        
        @KeepForSdk
        boolean isConnected();
        
        @KeepForSdk
        boolean isConnecting();
        
        @KeepForSdk
        void onUserSignOut(final BaseGmsClient.SignOutCallbacks p0);
        
        @KeepForSdk
        boolean providesSignIn();
        
        @KeepForSdk
        boolean requiresGooglePlayServices();
        
        @KeepForSdk
        boolean requiresSignIn();
    }
    
    @KeepForSdk
    @VisibleForTesting
    public static final class ClientKey<C extends Client> extends AnyClientKey<C>
    {
    }
}
