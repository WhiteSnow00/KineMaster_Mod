// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

public class a implements h
{
    private transient k mCallbacks;
    
    @Override
    public void addOnPropertyChangedCallback(final h.a a) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new k();
            }
            monitorexit(this);
            ((c<h.a, T, A>)this.mCallbacks).b(a);
        }
    }
    
    public void notifyChange() {
        synchronized (this) {
            final k mCallbacks = this.mCallbacks;
            if (mCallbacks == null) {
                return;
            }
            monitorexit(this);
            ((c<C, a, Void>)mCallbacks).e(this, 0, null);
        }
    }
    
    public void notifyPropertyChanged(final int n) {
        synchronized (this) {
            final k mCallbacks = this.mCallbacks;
            if (mCallbacks == null) {
                return;
            }
            monitorexit(this);
            ((c<C, a, Void>)mCallbacks).e(this, n, null);
        }
    }
    
    public void removeOnPropertyChangedCallback(final h.a a) {
        synchronized (this) {
            final k mCallbacks = this.mCallbacks;
            if (mCallbacks == null) {
                return;
            }
            monitorexit(this);
            ((c<h.a, T, A>)mCallbacks).j(a);
        }
    }
}
