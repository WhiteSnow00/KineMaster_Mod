// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import v0.k;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class x0
{
    private final RoomDatabase mDatabase;
    private final AtomicBoolean mLock;
    private volatile k mStmt;
    
    public x0(final RoomDatabase mDatabase) {
        this.mLock = new AtomicBoolean(false);
        this.mDatabase = mDatabase;
    }
    
    private k createNewStatement() {
        return this.mDatabase.compileStatement(this.createQuery());
    }
    
    private k getStmt(final boolean b) {
        k k;
        if (b) {
            if (this.mStmt == null) {
                this.mStmt = this.createNewStatement();
            }
            k = this.mStmt;
        }
        else {
            k = this.createNewStatement();
        }
        return k;
    }
    
    public k acquire() {
        this.assertNotMainThread();
        return this.getStmt(this.mLock.compareAndSet(false, true));
    }
    
    protected void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }
    
    protected abstract String createQuery();
    
    public void release(final k k) {
        if (k == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
