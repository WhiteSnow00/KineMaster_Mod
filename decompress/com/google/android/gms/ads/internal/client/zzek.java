// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.ads.zzbkx;
import com.google.android.gms.ads.MediaContent;

public final class zzek implements MediaContent
{
    private final zzbkx a;
    private final VideoController b;
    
    public zzek(final zzbkx a) {
        this.b = new VideoController();
        this.a = a;
    }
    
    public final zzbkx a() {
        return this.a;
    }
    
    @Override
    public final float getAspectRatio() {
        try {
            return this.a.zze();
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("", (Throwable)ex);
            return 0.0f;
        }
    }
    
    @Override
    public final VideoController getVideoController() {
        try {
            if (this.a.zzh() != null) {
                this.b.e(this.a.zzh());
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("Exception occurred while getting video controller", (Throwable)ex);
        }
        return this.b;
    }
}
