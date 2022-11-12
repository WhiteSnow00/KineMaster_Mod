// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.os.IInterface;
import android.os.IBinder;
import java.util.Iterator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.auth_api.zbbb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.GmsClient;

public final class zbe extends GmsClient
{
    private final GoogleSignInOptions a;
    
    public zbe(final Context context, final Looper looper, final ClientSettings clientSettings, final GoogleSignInOptions googleSignInOptions, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, clientSettings, connectionCallbacks, onConnectionFailedListener);
        GoogleSignInOptions.Builder builder;
        if (googleSignInOptions != null) {
            builder = new GoogleSignInOptions.Builder(googleSignInOptions);
        }
        else {
            builder = new GoogleSignInOptions.Builder();
        }
        builder.h(zbbb.zba());
        if (!clientSettings.d().isEmpty()) {
            final Iterator<Scope> iterator = clientSettings.d().iterator();
            while (iterator.hasNext()) {
                builder.f(iterator.next(), new Scope[0]);
            }
        }
        this.a = builder.a();
    }
    
    @Override
    protected final IInterface createServiceInterface(final IBinder binder) {
        Object o;
        if (binder == null) {
            o = null;
        }
        else {
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            if (queryLocalInterface instanceof zbs) {
                o = queryLocalInterface;
            }
            else {
                o = new zbs(binder);
            }
        }
        return (IInterface)o;
    }
    
    public final GoogleSignInOptions e() {
        return this.a;
    }
    
    @Override
    public final int getMinApkVersion() {
        return 12451000;
    }
    
    @Override
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
    
    @Override
    public final Intent getSignInIntent() {
        return zbm.c(this.getContext(), this.a);
    }
    
    @Override
    protected final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }
    
    @Override
    public final boolean providesSignIn() {
        return true;
    }
}
