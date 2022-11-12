// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class u implements d
{
    public final SQLiteDatabase a;
    
    public u(final SQLiteDatabase a) {
        this.a = a;
    }
    
    @Override
    public final Object a() {
        return SQLiteEventStore.l(this.a);
    }
}
