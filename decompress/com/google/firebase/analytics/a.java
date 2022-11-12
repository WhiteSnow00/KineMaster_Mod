// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics;

import java.util.Map;
import java.util.List;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.measurement.internal.zzik;

final class a implements zzik
{
    final zzee a;
    
    a(final zzee a) {
        this.a = a;
    }
    
    public final void a(final String s, final String s2, final Bundle bundle) {
        this.a.zzy(s, s2, bundle);
    }
    
    public final List b(final String s, final String s2) {
        return this.a.zzp(s, s2);
    }
    
    public final Map c(final String s, final String s2, final boolean b) {
        return this.a.zzq(s, s2, b);
    }
    
    public final void d(final Bundle bundle) {
        this.a.zzD(bundle);
    }
    
    public final void e(final String s, final String s2, final Bundle bundle) {
        this.a.zzv(s, s2, bundle);
    }
    
    public final int zza(final String s) {
        return this.a.zza(s);
    }
    
    public final long zzb() {
        return this.a.zzb();
    }
    
    public final String zzh() {
        return this.a.zzl();
    }
    
    public final String zzi() {
        return this.a.zzm();
    }
    
    public final String zzj() {
        return this.a.zzn();
    }
    
    public final String zzk() {
        return this.a.zzo();
    }
    
    public final void zzp(final String s) {
        this.a.zzu(s);
    }
    
    public final void zzr(final String s) {
        this.a.zzw(s);
    }
}
