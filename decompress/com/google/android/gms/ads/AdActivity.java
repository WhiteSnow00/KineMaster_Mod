// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import android.view.ViewGroup$LayoutParams;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzaw;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.content.res.Configuration;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzbxu;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.app.Activity;

@KeepForSdk
public final class AdActivity extends Activity
{
    private zzbxu a;
    
    private final void a() {
        final zzbxu a = this.a;
        if (a != null) {
            try {
                a.zzv();
            }
            catch (final RemoteException ex) {
                zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            }
        }
    }
    
    protected final void onActivityResult(final int n, final int n2, final Intent intent) {
        try {
            final zzbxu a = this.a;
            if (a != null) {
                a.zzg(n, n2, intent);
            }
        }
        catch (final Exception ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
        super.onActivityResult(n, n2, intent);
    }
    
    public final void onBackPressed() {
        try {
            final zzbxu a = this.a;
            if (a != null) {
                if (!a.zzE()) {
                    return;
                }
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
        super.onBackPressed();
        try {
            final zzbxu a2 = this.a;
            if (a2 != null) {
                a2.zzh();
            }
        }
        catch (final RemoteException ex2) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex2);
        }
    }
    
    public final void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            final zzbxu a = this.a;
            if (a != null) {
                a.zzj(ObjectWrapper.q1(configuration));
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
    }
    
    protected final void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final zzbxu l = zzaw.a().l(this);
        this.a = l;
        if (l != null) {
            try {
                l.zzk(bundle);
                return;
            }
            catch (final RemoteException ex) {
                zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
                this.finish();
                return;
            }
        }
        zzcfi.zzl("#007 Could not call remote method.", (Throwable)null);
        this.finish();
    }
    
    protected final void onDestroy() {
        try {
            final zzbxu a = this.a;
            if (a != null) {
                a.zzl();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
        super.onDestroy();
    }
    
    protected final void onPause() {
        try {
            final zzbxu a = this.a;
            if (a != null) {
                a.zzn();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            this.finish();
        }
        super.onPause();
    }
    
    protected final void onRestart() {
        super.onRestart();
        try {
            final zzbxu a = this.a;
            if (a != null) {
                a.zzo();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            this.finish();
        }
    }
    
    protected final void onResume() {
        super.onResume();
        try {
            final zzbxu a = this.a;
            if (a != null) {
                a.zzp();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            this.finish();
        }
    }
    
    protected final void onSaveInstanceState(final Bundle bundle) {
        try {
            final zzbxu a = this.a;
            if (a != null) {
                a.zzq(bundle);
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            this.finish();
        }
        super.onSaveInstanceState(bundle);
    }
    
    protected final void onStart() {
        super.onStart();
        try {
            final zzbxu a = this.a;
            if (a != null) {
                a.zzr();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            this.finish();
        }
    }
    
    protected final void onStop() {
        try {
            final zzbxu a = this.a;
            if (a != null) {
                a.zzs();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            this.finish();
        }
        super.onStop();
    }
    
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            final zzbxu a = this.a;
            if (a != null) {
                a.zzt();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
    }
    
    public final void setContentView(final int contentView) {
        super.setContentView(contentView);
        this.a();
    }
    
    public final void setContentView(final View contentView) {
        super.setContentView(contentView);
        this.a();
    }
    
    public final void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super.setContentView(view, viewGroup$LayoutParams);
        this.a();
    }
}
