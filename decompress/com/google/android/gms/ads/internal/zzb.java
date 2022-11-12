// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import java.util.Iterator;
import com.google.android.gms.ads.internal.util.zzs;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import com.google.android.gms.internal.ads.zzbzi;
import com.google.android.gms.internal.ads.zzccj;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzb
{
    private final Context a;
    private boolean b;
    private final zzccj c;
    private final zzbzi d;
    
    public zzb(final Context a, final zzccj c, final zzbzi zzbzi) {
        this.a = a;
        this.c = c;
        this.d = new zzbzi(false, (List)Collections.emptyList());
    }
    
    private final boolean d() {
        final zzccj c = this.c;
        return (c != null && c.zza().zzf) || this.d.zza;
    }
    
    public final void a() {
        this.b = true;
    }
    
    public final void b(final String s) {
        if (!this.d()) {
            return;
        }
        String s2;
        if ((s2 = s) == null) {
            s2 = "";
        }
        final zzccj c = this.c;
        if (c != null) {
            c.zzd(s2, (Map)null, 3);
            return;
        }
        final zzbzi d = this.d;
        if (d.zza) {
            final List zzb = d.zzb;
            if (zzb != null) {
                for (final String s3 : zzb) {
                    if (!TextUtils.isEmpty((CharSequence)s3)) {
                        final String replace = s3.replace("{NAVIGATION_URL}", Uri.encode(s2));
                        zzt.q();
                        zzs.g(this.a, "", replace);
                    }
                }
            }
        }
    }
    
    public final boolean c() {
        return !this.d() || this.b;
    }
}
