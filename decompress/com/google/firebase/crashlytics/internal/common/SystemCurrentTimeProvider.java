// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

public class SystemCurrentTimeProvider implements CurrentTimeProvider
{
    @Override
    public long a() {
        return System.currentTimeMillis();
    }
}
