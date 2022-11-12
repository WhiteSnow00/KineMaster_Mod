// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore>
{
    private final Provider<Clock> a;
    private final Provider<Clock> b;
    private final Provider<c> c;
    private final Provider<SchemaManager> d;
    private final Provider<String> e;
    
    public SQLiteEventStore_Factory(final Provider<Clock> a, final Provider<Clock> b, final Provider<c> c, final Provider<SchemaManager> d, final Provider<String> e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public static SQLiteEventStore_Factory a(final Provider<Clock> provider, final Provider<Clock> provider2, final Provider<c> provider3, final Provider<SchemaManager> provider4, final Provider<String> provider5) {
        return new SQLiteEventStore_Factory(provider, provider2, provider3, provider4, provider5);
    }
    
    public static SQLiteEventStore c(final Clock clock, final Clock clock2, final Object o, final Object o2, final Lazy<String> lazy) {
        return new SQLiteEventStore(clock, clock2, (c)o, (SchemaManager)o2, lazy);
    }
    
    public SQLiteEventStore b() {
        return c((Clock)this.a.get(), (Clock)this.b.get(), this.c.get(), this.d.get(), DoubleCheck.a(this.e));
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
}
