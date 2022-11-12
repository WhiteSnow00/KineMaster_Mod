// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nativead;

import com.google.android.gms.ads.VideoOptions;

public final class NativeAdOptions
{
    private final boolean a;
    private final int b;
    private final boolean c;
    private final int d;
    private final VideoOptions e;
    private final boolean f;
    
    NativeAdOptions(final Builder builder, final zza zza) {
        this.a = Builder.l(builder);
        this.b = Builder.i(builder);
        this.c = Builder.k(builder);
        this.d = Builder.h(builder);
        this.e = Builder.j(builder);
        this.f = Builder.m(builder);
    }
    
    public int a() {
        return this.d;
    }
    
    public int b() {
        return this.b;
    }
    
    public VideoOptions c() {
        return this.e;
    }
    
    public boolean d() {
        return this.c;
    }
    
    public boolean e() {
        return this.a;
    }
    
    public final boolean f() {
        return this.f;
    }
    
    public @interface AdChoicesPlacement {
    }
    
    public static final class Builder
    {
        private boolean a;
        private int b;
        private boolean c;
        private VideoOptions d;
        private int e;
        private boolean f;
        
        public Builder() {
            this.a = false;
            this.b = 0;
            this.c = false;
            this.e = 1;
            this.f = false;
        }
        
        static /* bridge */ int h(final Builder builder) {
            return builder.e;
        }
        
        static /* bridge */ int i(final Builder builder) {
            return builder.b;
        }
        
        static /* bridge */ VideoOptions j(final Builder builder) {
            return builder.d;
        }
        
        static /* bridge */ boolean k(final Builder builder) {
            return builder.c;
        }
        
        static /* bridge */ boolean l(final Builder builder) {
            return builder.a;
        }
        
        static /* bridge */ boolean m(final Builder builder) {
            return builder.f;
        }
        
        public NativeAdOptions a() {
            return new NativeAdOptions(this, null);
        }
        
        public Builder b(@AdChoicesPlacement final int e) {
            this.e = e;
            return this;
        }
        
        public Builder c(@NativeMediaAspectRatio final int b) {
            this.b = b;
            return this;
        }
        
        public Builder d(final boolean f) {
            this.f = f;
            return this;
        }
        
        public Builder e(final boolean c) {
            this.c = c;
            return this;
        }
        
        public Builder f(final boolean a) {
            this.a = a;
            return this;
        }
        
        public Builder g(final VideoOptions d) {
            this.d = d;
            return this;
        }
    }
    
    public @interface NativeMediaAspectRatio {
    }
}
