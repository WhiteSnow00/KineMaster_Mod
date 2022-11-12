// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import javax.annotation.concurrent.GuardedBy;
import com.google.android.gms.ads.internal.client.zzdk;

public final class VideoController
{
    private final Object a;
    @GuardedBy
    private zzdk b;
    @GuardedBy
    private VideoLifecycleCallbacks c;
    
    public VideoController() {
        this.a = new Object();
    }
    
    @KeepForSdk
    public int a() {
        synchronized (this.a) {
            final zzdk b = this.b;
            if (b == null) {
                return 0;
            }
            try {
                return b.zzh();
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to call getPlaybackState on video controller.", (Throwable)ex);
                return 0;
            }
        }
    }
    
    public void b() {
        synchronized (this.a) {
            final zzdk b = this.b;
            if (b != null) {
                try {
                    b.zzl();
                }
                catch (final RemoteException ex) {
                    zzcfi.zzh("Unable to call play on video controller.", (Throwable)ex);
                }
            }
        }
    }
    
    public void c(final VideoLifecycleCallbacks c) {
        synchronized (this.a) {
            this.c = c;
            final zzdk b = this.b;
            if (b != null) {
                Label_0039: {
                    if (c == null) {
                        final zzdn zzdn = null;
                        break Label_0039;
                    }
                    try {
                        final zzdn zzdn = new zzff(c);
                        b.zzm(zzdn);
                    }
                    catch (final RemoteException ex) {
                        zzcfi.zzh("Unable to call setVideoLifecycleCallbacks on video controller.", (Throwable)ex);
                    }
                }
            }
        }
    }
    
    public final zzdk d() {
        synchronized (this.a) {
            return this.b;
        }
    }
    
    public final void e(final zzdk b) {
        synchronized (this.a) {
            this.b = b;
            final VideoLifecycleCallbacks c = this.c;
            if (c != null) {
                this.c(c);
            }
        }
    }
    
    public abstract static class VideoLifecycleCallbacks
    {
        public void onVideoEnd() {
        }
        
        public void onVideoMute(final boolean b) {
        }
        
        public void onVideoPause() {
        }
        
        public void onVideoPlay() {
        }
        
        public void onVideoStart() {
        }
    }
}
