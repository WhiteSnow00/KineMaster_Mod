// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.VideoController;

public final class zzff extends zzdm
{
    private final VideoController.VideoLifecycleCallbacks a;
    
    public zzff(final VideoController.VideoLifecycleCallbacks a) {
        this.a = a;
    }
    
    public final void c(final boolean b) {
        this.a.onVideoMute(b);
    }
    
    public final void zze() {
        this.a.onVideoEnd();
    }
    
    public final void zzg() {
        this.a.onVideoPause();
    }
    
    public final void zzh() {
        this.a.onVideoPlay();
    }
    
    public final void zzi() {
        this.a.onVideoStart();
    }
}
