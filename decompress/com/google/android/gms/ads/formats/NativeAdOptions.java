// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;

@Deprecated
public final class NativeAdOptions
{
    private final boolean a;
    private final int b;
    private final int c;
    private final boolean d;
    private final int e;
    private final VideoOptions f;
    private final boolean g;
    
    NativeAdOptions(final Builder builder, final zzd zzd) {
        this.a = Builder.n(builder);
        this.b = Builder.j(builder);
        this.c = Builder.k(builder);
        this.d = Builder.m(builder);
        this.e = Builder.i(builder);
        this.f = Builder.l(builder);
        this.g = Builder.o(builder);
    }
    
    public int a() {
        return this.e;
    }
    
    @Deprecated
    public int b() {
        return this.b;
    }
    
    public int c() {
        return this.c;
    }
    
    public VideoOptions d() {
        return this.f;
    }
    
    public boolean e() {
        return this.d;
    }
    
    public boolean f() {
        return this.a;
    }
    
    public final boolean g() {
        return this.g;
    }
    
    public @interface AdChoicesPlacement {
    }
    
    public static final class Builder
    {
        private boolean a;
        private int b;
        private int c;
        private boolean d;
        private VideoOptions e;
        private int f;
        private boolean g;
        
        public Builder() {
            this.a = false;
            this.b = -1;
            this.c = 0;
            this.d = false;
            this.f = 1;
            this.g = false;
        }
        
        static /* bridge */ int i(final Builder builder) {
            return builder.f;
        }
        
        static /* bridge */ int j(final Builder builder) {
            return builder.b;
        }
        
        static /* bridge */ int k(final Builder builder) {
            return builder.c;
        }
        
        static /* bridge */ VideoOptions l(final Builder builder) {
            return builder.e;
        }
        
        static /* bridge */ boolean m(final Builder builder) {
            return builder.d;
        }
        
        static /* bridge */ boolean n(final Builder builder) {
            return builder.a;
        }
        
        static /* bridge */ boolean o(final Builder builder) {
            return builder.g;
        }
        
        public NativeAdOptions a() {
            return new NativeAdOptions(this, null);
        }
        
        public Builder b(@AdChoicesPlacement final int f) {
            this.f = f;
            return this;
        }
        
        @Deprecated
        public Builder c(final int b) {
            this.b = b;
            return this;
        }
        
        public Builder d(@NativeMediaAspectRatio final int c) {
            this.c = c;
            return this;
        }
        
        public Builder e(final boolean g) {
            this.g = g;
            return this;
        }
        
        public Builder f(final boolean d) {
            this.d = d;
            return this;
        }
        
        public Builder g(final boolean a) {
            this.a = a;
            return this;
        }
        
        public Builder h(final VideoOptions e) {
            this.e = e;
            return this;
        }
    }
    
    public @interface NativeMediaAspectRatio {
    }
}
