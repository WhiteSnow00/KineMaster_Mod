// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

public final class v implements d
{
    public final SchemaManager a;
    
    public v(final SchemaManager a) {
        this.a = a;
    }
    
    @Override
    public final Object a() {
        return this.a.getWritableDatabase();
    }
}
