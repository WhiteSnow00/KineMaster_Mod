// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel;

import android.util.Log;
import com.firebase.ui.auth.util.ui.FlowUtils;
import com.firebase.ui.auth.data.model.State;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.ui.ProgressView;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;

public abstract class ResourceObserver<T> implements a0<Resource<T>>
{
    private final HelperActivityBase mActivity;
    private final FragmentBase mFragment;
    private final int mLoadingMessage;
    private final ProgressView mProgressView;
    
    protected ResourceObserver(final FragmentBase fragmentBase) {
        this(null, fragmentBase, fragmentBase, R.string.fui_progress_dialog_loading);
    }
    
    protected ResourceObserver(final FragmentBase fragmentBase, final int n) {
        this(null, fragmentBase, fragmentBase, n);
    }
    
    protected ResourceObserver(final HelperActivityBase helperActivityBase) {
        this(helperActivityBase, null, helperActivityBase, R.string.fui_progress_dialog_loading);
    }
    
    protected ResourceObserver(final HelperActivityBase helperActivityBase, final int n) {
        this(helperActivityBase, null, helperActivityBase, n);
    }
    
    private ResourceObserver(final HelperActivityBase mActivity, final FragmentBase mFragment, final ProgressView mProgressView, final int mLoadingMessage) {
        this.mActivity = mActivity;
        this.mFragment = mFragment;
        if (mActivity == null && mFragment == null) {
            throw new IllegalStateException("ResourceObserver must be attached to an Activity or a Fragment");
        }
        this.mProgressView = mProgressView;
        this.mLoadingMessage = mLoadingMessage;
    }
    
    @Override
    public final void onChanged(final Resource<T> resource) {
        if (resource.getState() == State.LOADING) {
            this.mProgressView.showProgress(this.mLoadingMessage);
            return;
        }
        this.mProgressView.hideProgress();
        if (resource.isUsed()) {
            return;
        }
        if (resource.getState() == State.SUCCESS) {
            this.onSuccess((T)resource.getValue());
        }
        else if (resource.getState() == State.FAILURE) {
            final Exception exception = resource.getException();
            final FragmentBase mFragment = this.mFragment;
            boolean b;
            if (mFragment == null) {
                b = FlowUtils.unhandled(this.mActivity, exception);
            }
            else {
                b = FlowUtils.unhandled(mFragment, exception);
            }
            if (b) {
                Log.e("AuthUI", "A sign-in error occurred.", (Throwable)exception);
                this.onFailure(exception);
            }
        }
    }
    
    @Override
    public /* bridge */ void onChanged(final Object o) {
        this.onChanged((Resource<T>)o);
    }
    
    protected abstract void onFailure(final Exception p0);
    
    protected abstract void onSuccess(final T p0);
}
