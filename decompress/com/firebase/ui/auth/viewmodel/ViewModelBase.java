// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel;

import android.app.Application;
import java.util.concurrent.atomic.AtomicBoolean;
import androidx.lifecycle.b;

public abstract class ViewModelBase<T> extends b
{
    private T mArguments;
    private final AtomicBoolean mIsInitialized;
    
    protected ViewModelBase(final Application application) {
        super(application);
        this.mIsInitialized = new AtomicBoolean();
    }
    
    protected T getArguments() {
        return this.mArguments;
    }
    
    public void init(final T mArguments) {
        if (this.mIsInitialized.compareAndSet(false, true)) {
            this.mArguments = mArguments;
            this.onCreate();
        }
    }
    
    @Override
    protected void onCleared() {
        this.mIsInitialized.set(false);
    }
    
    protected void onCreate() {
    }
    
    protected void setArguments(final T mArguments) {
        this.mArguments = mArguments;
    }
}
