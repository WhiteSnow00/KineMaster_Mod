// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel;

import androidx.lifecycle.LiveData;
import android.app.Application;
import androidx.lifecycle.z;

public abstract class OperableViewModel<I, O> extends ViewModelBase<I>
{
    private z<O> mOperation;
    
    protected OperableViewModel(final Application application) {
        super(application);
        this.mOperation = new z<O>();
    }
    
    public LiveData<O> getOperation() {
        return this.mOperation;
    }
    
    protected void setResult(final O value) {
        this.mOperation.setValue(value);
    }
}
