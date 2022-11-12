// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import java.util.Date;
import com.google.ads.mediation.admob.AdMobAdapter;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public class AdRequest
{
    protected final zzdr a;
    
    protected AdRequest(final Builder builder) {
        this.a = new zzdr(builder.a, null);
    }
    
    public zzdr a() {
        return this.a;
    }
    
    @VisibleForTesting
    public static class Builder
    {
        protected final zzdq a;
        
        public Builder() {
            (this.a = new zzdq()).y("B3EEABB8EE11C2BE770B684D95219ECB");
        }
        
        public Builder a(final String s) {
            this.a.w(s);
            return this;
        }
        
        public Builder b(final Class<? extends MediationExtrasReceiver> clazz, final Bundle bundle) {
            this.a.x(clazz, bundle);
            if (clazz.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.a.z("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }
        
        public AdRequest c() {
            return new AdRequest(this);
        }
        
        public Builder d(final int n) {
            this.a.c(n);
            return this;
        }
        
        @Deprecated
        public final Builder e(final String s) {
            this.a.y(s);
            return this;
        }
        
        @Deprecated
        public final Builder f(final Date date) {
            this.a.a(date);
            return this;
        }
        
        @Deprecated
        public final Builder g(final int n) {
            this.a.b(n);
            return this;
        }
        
        @Deprecated
        public final Builder h(final boolean b) {
            this.a.d(b);
            return this;
        }
        
        @Deprecated
        public final Builder i(final boolean b) {
            this.a.e(b);
            return this;
        }
    }
}
