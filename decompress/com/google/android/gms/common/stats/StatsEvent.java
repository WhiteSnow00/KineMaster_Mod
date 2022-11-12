// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
@KeepForSdk
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable
{
    public abstract int K1();
    
    @Override
    public final String toString() {
        final long zzc = this.zzc();
        final int k1 = this.K1();
        final long zzb = this.zzb();
        final String zzd = this.zzd();
        final StringBuilder sb = new StringBuilder();
        sb.append(zzc);
        sb.append("\t");
        sb.append(k1);
        sb.append("\t");
        sb.append(zzb);
        sb.append(zzd);
        return sb.toString();
    }
    
    public abstract long zzb();
    
    public abstract long zzc();
    
    public abstract String zzd();
    
    @KeepForSdk
    public interface Types
    {
    }
}
