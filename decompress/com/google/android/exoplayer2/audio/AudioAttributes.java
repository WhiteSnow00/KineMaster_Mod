// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import android.media.AudioAttributes$Builder;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

public final class AudioAttributes implements Bundleable
{
    public static final AudioAttributes g;
    public static final Creator<AudioAttributes> h;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    private AudioAttributesV21 f;
    
    static {
        g = new Builder().a();
        h = a.a;
    }
    
    private AudioAttributes(final int a, final int b, final int c, final int d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    AudioAttributes(final int n, final int n2, final int n3, final int n4, final int n5, final AudioAttributes$a object) {
        this(n, n2, n3, n4, n5);
    }
    
    public static AudioAttributes a(final Bundle bundle) {
        return d(bundle);
    }
    
    private static String c(final int n) {
        return Integer.toString(n, 36);
    }
    
    private static AudioAttributes d(final Bundle bundle) {
        final Builder builder = new Builder();
        if (bundle.containsKey(c(0))) {
            builder.c(bundle.getInt(c(0)));
        }
        if (bundle.containsKey(c(1))) {
            builder.d(bundle.getInt(c(1)));
        }
        if (bundle.containsKey(c(2))) {
            builder.f(bundle.getInt(c(2)));
        }
        if (bundle.containsKey(c(3))) {
            builder.b(bundle.getInt(c(3)));
        }
        if (bundle.containsKey(c(4))) {
            builder.e(bundle.getInt(c(4)));
        }
        return builder.a();
    }
    
    public AudioAttributesV21 b() {
        if (this.f == null) {
            this.f = new AudioAttributesV21(this, null);
        }
        return this.f;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && AudioAttributes.class == o.getClass()) {
            final AudioAttributes audioAttributes = (AudioAttributes)o;
            if (this.a != audioAttributes.a || this.b != audioAttributes.b || this.c != audioAttributes.c || this.d != audioAttributes.d || this.e != audioAttributes.e) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((((527 + this.a) * 31 + this.b) * 31 + this.c) * 31 + this.d) * 31 + this.e;
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putInt(c(0), this.a);
        bundle.putInt(c(1), this.b);
        bundle.putInt(c(2), this.c);
        bundle.putInt(c(3), this.d);
        bundle.putInt(c(4), this.e);
        return bundle;
    }
    
    public static final class AudioAttributesV21
    {
        public final android.media.AudioAttributes a;
        
        private AudioAttributesV21(final AudioAttributes audioAttributes) {
            final AudioAttributes$Builder setUsage = new AudioAttributes$Builder().setContentType(audioAttributes.a).setFlags(audioAttributes.b).setUsage(audioAttributes.c);
            final int a = Util.a;
            if (a >= 29) {
                b.a(setUsage, audioAttributes.d);
            }
            if (a >= 32) {
                c.a(setUsage, audioAttributes.e);
            }
            this.a = setUsage.build();
        }
        
        AudioAttributesV21(final AudioAttributes audioAttributes, final AudioAttributes$a object) {
            this(audioAttributes);
        }
    }
    
    public static final class Builder
    {
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        
        public Builder() {
            this.a = 0;
            this.b = 0;
            this.c = 1;
            this.d = 1;
            this.e = 0;
        }
        
        public AudioAttributes a() {
            return new AudioAttributes(this.a, this.b, this.c, this.d, this.e, null);
        }
        
        public Builder b(final int d) {
            this.d = d;
            return this;
        }
        
        public Builder c(final int a) {
            this.a = a;
            return this;
        }
        
        public Builder d(final int b) {
            this.b = b;
            return this;
        }
        
        public Builder e(final int e) {
            this.e = e;
            return this;
        }
        
        public Builder f(final int c) {
            this.c = c;
            return this;
        }
    }
    
    private static final class b
    {
        public static void a(final AudioAttributes$Builder audioAttributes$Builder, final int allowedCapturePolicy) {
            audioAttributes$Builder.setAllowedCapturePolicy(allowedCapturePolicy);
        }
    }
    
    private static final class c
    {
        public static void a(final AudioAttributes$Builder audioAttributes$Builder, final int spatializationBehavior) {
            audioAttributes$Builder.setSpatializationBehavior(spatializationBehavior);
        }
    }
}
