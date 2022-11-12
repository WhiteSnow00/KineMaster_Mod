// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzajy;
import com.google.android.gms.internal.ads.zzajh;
import com.google.android.gms.internal.ads.zzaix;
import com.google.android.gms.internal.ads.zzajf;
import java.util.Map;
import com.google.android.gms.internal.ads.zzcfh;
import com.google.android.gms.internal.ads.zzcga;
import com.google.android.gms.internal.ads.zzajb;

public final class zzbn extends zzajb
{
    private final zzcga a;
    private final zzcfh b;
    
    public zzbn(final String s, final Map map, final zzcga a) {
        super(0, s, (zzajf)new i(a));
        this.a = a;
        (this.b = new zzcfh((String)null)).zzd(s, "GET", (Map)null, (byte[])null);
    }
    
    protected final zzajh zzh(final zzaix zzaix) {
        return zzajh.zzb((Object)zzaix, zzajy.zzb(zzaix));
    }
    
    protected final /* bridge */ void zzo(final Object o) {
        final zzaix zzaix = (zzaix)o;
        this.b.zzf(zzaix.zzc, zzaix.zza);
        final zzcfh b = this.b;
        final byte[] zzb = zzaix.zzb;
        if (zzcfh.zzl()) {
            if (zzb != null) {
                b.zzh(zzb);
            }
        }
        this.a.zzd((Object)zzaix);
    }
}
