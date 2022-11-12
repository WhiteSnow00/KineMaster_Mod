// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.model;

public final class Resource<T>
{
    private final Exception mException;
    private boolean mIsUsed;
    private final State mState;
    private final T mValue;
    
    private Resource(final State mState, final T mValue, final Exception mException) {
        this.mState = mState;
        this.mValue = mValue;
        this.mException = mException;
    }
    
    public static <T> Resource<T> forFailure(final Exception ex) {
        return new Resource<T>(State.FAILURE, null, ex);
    }
    
    public static <T> Resource<T> forLoading() {
        return new Resource<T>(State.LOADING, null, null);
    }
    
    public static <T> Resource<T> forSuccess(final T t) {
        return new Resource<T>(State.SUCCESS, t, null);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && Resource.class == o.getClass()) {
            final Resource resource = (Resource)o;
            if (this.mState == resource.mState) {
                final T mValue = this.mValue;
                if (mValue == null) {
                    if (resource.mValue != null) {
                        return false;
                    }
                }
                else if (!mValue.equals(resource.mValue)) {
                    return false;
                }
                final Exception mException = this.mException;
                final Exception mException2 = resource.mException;
                if (mException == null) {
                    if (mException2 == null) {
                        return b;
                    }
                }
                else if (mException.equals(mException2)) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    public final Exception getException() {
        this.mIsUsed = true;
        return this.mException;
    }
    
    public State getState() {
        return this.mState;
    }
    
    public T getValue() {
        this.mIsUsed = true;
        return this.mValue;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.mState.hashCode();
        final T mValue = this.mValue;
        int hashCode2 = 0;
        int hashCode3;
        if (mValue == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = mValue.hashCode();
        }
        final Exception mException = this.mException;
        if (mException != null) {
            hashCode2 = mException.hashCode();
        }
        return (hashCode * 31 + hashCode3) * 31 + hashCode2;
    }
    
    public boolean isUsed() {
        return this.mIsUsed;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Resource{mState=");
        sb.append(this.mState);
        sb.append(", mValue=");
        sb.append(this.mValue);
        sb.append(", mException=");
        sb.append(this.mException);
        sb.append('}');
        return sb.toString();
    }
}
