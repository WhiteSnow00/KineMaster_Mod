// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import v0.g;
import java.util.concurrent.Executor;
import v0.h;

final class i0 implements h, p
{
    private final h a;
    private final RoomDatabase.e b;
    private final Executor c;
    
    i0(final h a, final RoomDatabase.e b, final Executor c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void close() {
        this.a.close();
    }
    
    @Override
    public String getDatabaseName() {
        return this.a.getDatabaseName();
    }
    
    @Override
    public h getDelegate() {
        return this.a;
    }
    
    @Override
    public g getWritableDatabase() {
        return new h0(this.a.getWritableDatabase(), this.b, this.c);
    }
    
    @Override
    public void setWriteAheadLoggingEnabled(final boolean writeAheadLoggingEnabled) {
        this.a.setWriteAheadLoggingEnabled(writeAheadLoggingEnabled);
    }
}
