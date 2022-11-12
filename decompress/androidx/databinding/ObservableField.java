// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import java.io.Serializable;

public class ObservableField<T> extends b implements Serializable
{
    static final long serialVersionUID = 1L;
    private T mValue;
    
    public ObservableField() {
    }
    
    public ObservableField(final T mValue) {
        this.mValue = mValue;
    }
    
    public ObservableField(final h... array) {
        super(array);
    }
    
    public T get() {
        return this.mValue;
    }
    
    public void set(final T mValue) {
        if (mValue != this.mValue) {
            this.mValue = mValue;
            this.notifyChange();
        }
    }
}
