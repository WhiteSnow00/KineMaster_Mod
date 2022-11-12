// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzfg;

public final class VideoOptions
{
    private final boolean a;
    private final boolean b;
    private final boolean c;
    
    VideoOptions(final Builder builder, final zzf zzf) {
        this.a = Builder.f(builder);
        this.b = Builder.e(builder);
        this.c = Builder.d(builder);
    }
    
    public VideoOptions(final zzfg zzfg) {
        this.a = zzfg.a;
        this.b = zzfg.b;
        this.c = zzfg.c;
    }
    
    public boolean a() {
        return this.c;
    }
    
    public boolean b() {
        return this.b;
    }
    
    public boolean c() {
        return this.a;
    }
    
    public static final class Builder
    {
        private boolean a;
        private boolean b;
        private boolean c;
        
        public Builder() {
            this.a = true;
            this.b = false;
            this.c = false;
        }
        
        static /* bridge */ boolean d(final Builder builder) {
            return builder.c;
        }
        
        static /* bridge */ boolean e(final Builder builder) {
            return builder.b;
        }
        
        static /* bridge */ boolean f(final Builder builder) {
            return builder.a;
        }
        
        public VideoOptions a() {
            return new VideoOptions(this, null);
        }
        
        public Builder b(final boolean b) {
            this.b = b;
            return this;
        }
        
        public Builder c(final boolean a) {
            this.a = a;
            return this;
        }
    }
}
