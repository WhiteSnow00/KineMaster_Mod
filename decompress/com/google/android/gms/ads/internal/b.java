// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.internal.ads.zzfcx;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class b extends WebViewClient
{
    final zzs a;
    
    b(final zzs a) {
        this.a = a;
    }
    
    public final void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        final zzs a = this.a;
        if (zzs.s1(a) != null) {
            try {
                zzs.s1(a).zzf(zzfcx.zzd(1, (String)null, (zze)null));
            }
            catch (final RemoteException ex) {
                zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            }
        }
        final zzs a2 = this.a;
        if (zzs.s1(a2) != null) {
            try {
                zzs.s1(a2).zze(0);
            }
            catch (final RemoteException ex2) {
                zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex2);
            }
        }
    }
    
    public final boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
        if (s.startsWith(this.a.zzq())) {
            return false;
        }
        if (s.startsWith("gmsg://noAdLoaded")) {
            final zzs a = this.a;
            if (zzs.s1(a) != null) {
                try {
                    zzs.s1(a).zzf(zzfcx.zzd(3, (String)null, (zze)null));
                }
                catch (final RemoteException ex) {
                    zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
                }
            }
            final zzs a2 = this.a;
            if (zzs.s1(a2) != null) {
                try {
                    zzs.s1(a2).zze(3);
                }
                catch (final RemoteException ex2) {
                    zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex2);
                }
            }
            this.a.M0(0);
            return true;
        }
        if (s.startsWith("gmsg://scriptLoadFailed")) {
            final zzs a3 = this.a;
            if (zzs.s1(a3) != null) {
                try {
                    zzs.s1(a3).zzf(zzfcx.zzd(1, (String)null, (zze)null));
                }
                catch (final RemoteException ex3) {
                    zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex3);
                }
            }
            final zzs a4 = this.a;
            if (zzs.s1(a4) != null) {
                try {
                    zzs.s1(a4).zze(0);
                }
                catch (final RemoteException ex4) {
                    zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex4);
                }
            }
            this.a.M0(0);
            return true;
        }
        if (s.startsWith("gmsg://adResized")) {
            final zzs a5 = this.a;
            if (zzs.s1(a5) != null) {
                try {
                    zzs.s1(a5).zzi();
                }
                catch (final RemoteException ex5) {
                    zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex5);
                }
            }
            this.a.M0(this.a.zzb(s));
            return true;
        }
        if (s.startsWith("gmsg://")) {
            return true;
        }
        final zzs a6 = this.a;
        if (zzs.s1(a6) != null) {
            try {
                zzs.s1(a6).zzc();
                zzs.s1(this.a).zzh();
            }
            catch (final RemoteException ex6) {
                zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex6);
            }
        }
        zzs.x1(this.a, zzs.u1(this.a, s));
        return true;
    }
}
