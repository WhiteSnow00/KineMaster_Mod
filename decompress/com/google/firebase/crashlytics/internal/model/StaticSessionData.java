// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class StaticSessionData
{
    public static StaticSessionData b(final AppData appData, final OsData osData, final DeviceData deviceData) {
        return new v(appData, osData, deviceData);
    }
    
    public abstract AppData a();
    
    public abstract DeviceData c();
    
    public abstract OsData d();
    
    @AutoValue
    public abstract static class AppData
    {
        public static AppData b(final String s, final String s2, final String s3, final String s4, final int n, final DevelopmentPlatformProvider developmentPlatformProvider) {
            return (AppData)new w(s, s2, s3, s4, n, developmentPlatformProvider);
        }
        
        public abstract String a();
        
        public abstract int c();
        
        public abstract DevelopmentPlatformProvider d();
        
        public abstract String e();
        
        public abstract String f();
        
        public abstract String g();
    }
    
    @AutoValue
    public abstract static class DeviceData
    {
        public static DeviceData c(final int n, final String s, final int n2, final long n3, final long n4, final boolean b, final int n5, final String s2, final String s3) {
            return (DeviceData)new x(n, s, n2, n3, n4, b, n5, s2, s3);
        }
        
        public abstract int a();
        
        public abstract int b();
        
        public abstract long d();
        
        public abstract boolean e();
        
        public abstract String f();
        
        public abstract String g();
        
        public abstract String h();
        
        public abstract int i();
        
        public abstract long j();
    }
    
    @AutoValue
    public abstract static class OsData
    {
        public static OsData a(final String s, final String s2, final boolean b) {
            return (OsData)new y(s, s2, b);
        }
        
        public abstract boolean b();
        
        public abstract String c();
        
        public abstract String d();
    }
}
