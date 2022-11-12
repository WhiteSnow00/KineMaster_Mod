// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.admanager;

import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.ads.AdRequest;

@VisibleForTesting
public final class AdManagerAdRequest extends AdRequest
{
    AdManagerAdRequest(final Builder builder, final zza zza) {
        super((AdRequest.Builder)builder);
    }
    
    @Override
    public final zzdr a() {
        return super.a;
    }
    
    @VisibleForTesting
    public static final class Builder extends AdRequest.Builder
    {
        @Override
        public final /* bridge */ AdRequest c() {
            return this.j();
        }
        
        public AdManagerAdRequest j() {
            return new AdManagerAdRequest(this, null);
        }
    }
}
