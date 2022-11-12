// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.settings;

public class Settings
{
    public final SessionData a;
    public final FeatureFlagData b;
    public final long c;
    public final int d;
    public final int e;
    public final double f;
    public final double g;
    public final int h;
    
    public Settings(final long c, final SessionData a, final FeatureFlagData b, final int d, final int e, final double f, final double g, final int h) {
        this.c = c;
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public boolean a(final long n) {
        return this.c < n;
    }
    
    public static class FeatureFlagData
    {
        public final boolean a;
        public final boolean b;
        
        public FeatureFlagData(final boolean a, final boolean b) {
            this.a = a;
            this.b = b;
        }
    }
    
    public static class SessionData
    {
        public final int a;
        public final int b;
        
        public SessionData(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
    }
}
