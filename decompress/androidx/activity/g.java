// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class g
{
    private CopyOnWriteArrayList<a> mCancellables;
    private boolean mEnabled;
    
    public g(final boolean mEnabled) {
        this.mCancellables = new CopyOnWriteArrayList<a>();
        this.mEnabled = mEnabled;
    }
    
    void addCancellable(final a a) {
        this.mCancellables.add(a);
    }
    
    public abstract void handleOnBackPressed();
    
    public final boolean isEnabled() {
        return this.mEnabled;
    }
    
    public final void remove() {
        final Iterator<a> iterator = this.mCancellables.iterator();
        while (iterator.hasNext()) {
            iterator.next().cancel();
        }
    }
    
    void removeCancellable(final a a) {
        this.mCancellables.remove(a);
    }
    
    public final void setEnabled(final boolean mEnabled) {
        this.mEnabled = mEnabled;
    }
}
