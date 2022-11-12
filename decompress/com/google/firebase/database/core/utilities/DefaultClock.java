// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

public class DefaultClock implements Clock
{
    @Override
    public long a() {
        return System.currentTimeMillis();
    }
}
