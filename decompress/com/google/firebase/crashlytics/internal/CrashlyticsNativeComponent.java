// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

public interface CrashlyticsNativeComponent
{
    NativeSessionFileProvider a(final String p0);
    
    boolean b();
    
    void c(final String p0, final String p1, final long p2, final StaticSessionData p3);
    
    boolean d(final String p0);
}
