// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.Collections;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.Feature;
import android.os.Bundle;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import android.content.Intent;
import com.google.android.gms.common.internal.BaseGmsClient;
import android.os.IBinder;
import android.os.Handler;
import android.content.Context;
import android.content.ComponentName;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.content.ServiceConnection;
import com.google.android.gms.common.api.Api;

@KeepForSdk
public final class NonGmsServiceBrokerClient implements Client, ServiceConnection
{
    private static final String w;
    private final String a;
    private final String b;
    private final ComponentName c;
    private final Context d;
    private final ConnectionCallbacks e;
    private final Handler f;
    private final OnConnectionFailedListener g;
    private IBinder h;
    private boolean i;
    private String j;
    private String p;
    
    static {
        w = NonGmsServiceBrokerClient.class.getSimpleName();
    }
    
    private final void g() {
        if (Thread.currentThread() == this.f.getLooper().getThread()) {
            return;
        }
        throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
    }
    
    final void b() {
        this.i = false;
        this.h = null;
        this.e.onConnectionSuspended(1);
    }
    
    @Override
    public final void connect(final BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.g();
        String.valueOf(this.h);
        while (true) {
            if (!this.isConnected()) {
                break Label_0025;
            }
            try {
                this.disconnect("connect() called when already connected");
                try {
                    final Intent intent = new Intent();
                    final ComponentName c = this.c;
                    if (c != null) {
                        intent.setComponent(c);
                    }
                    else {
                        intent.setPackage(this.a).setAction(this.b);
                    }
                    if (!(this.i = this.d.bindService(intent, (ServiceConnection)this, GmsClientSupervisor.b()))) {
                        this.h = null;
                        this.g.onConnectionFailed(new ConnectionResult(16));
                    }
                    String.valueOf(this.h);
                }
                catch (final SecurityException ex) {
                    this.i = false;
                    this.h = null;
                    throw ex;
                }
            }
            catch (final Exception ex2) {
                continue;
            }
            break;
        }
    }
    
    @Override
    public final void disconnect() {
        this.g();
        String.valueOf(this.h);
        while (true) {
            try {
                this.d.unbindService((ServiceConnection)this);
                this.i = false;
                this.h = null;
            }
            catch (final IllegalArgumentException ex) {
                continue;
            }
            break;
        }
    }
    
    @Override
    public final void disconnect(final String j) {
        this.g();
        this.j = j;
        this.disconnect();
    }
    
    @Override
    public final void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
    }
    
    final void e(final IBinder h) {
        this.i = false;
        String.valueOf(this.h = h);
        this.e.onConnected(new Bundle());
    }
    
    public final void f(final String p) {
        this.p = p;
    }
    
    @Override
    public final Feature[] getAvailableFeatures() {
        return new Feature[0];
    }
    
    @Override
    public final String getEndpointPackageName() {
        final String a = this.a;
        if (a != null) {
            return a;
        }
        Preconditions.k(this.c);
        return this.c.getPackageName();
    }
    
    @Override
    public final String getLastDisconnectMessage() {
        return this.j;
    }
    
    @Override
    public final int getMinApkVersion() {
        return 0;
    }
    
    @Override
    public final void getRemoteService(final IAccountAccessor accountAccessor, final Set<Scope> set) {
    }
    
    @Override
    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }
    
    @Override
    public final Intent getSignInIntent() {
        return new Intent();
    }
    
    @Override
    public final boolean isConnected() {
        this.g();
        return this.h != null;
    }
    
    @Override
    public final boolean isConnecting() {
        this.g();
        return this.i;
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.f.post((Runnable)new zacg(this, binder));
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
        this.f.post((Runnable)new zacf(this));
    }
    
    @Override
    public final void onUserSignOut(final BaseGmsClient.SignOutCallbacks signOutCallbacks) {
    }
    
    @Override
    public final boolean providesSignIn() {
        return false;
    }
    
    @Override
    public final boolean requiresGooglePlayServices() {
        return false;
    }
    
    @Override
    public final boolean requiresSignIn() {
        return false;
    }
}
