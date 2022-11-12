// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui;

import android.widget.ProgressBar;
import android.view.ViewGroup$LayoutParams;
import com.firebase.ui.auth.R;
import android.widget.FrameLayout$LayoutParams;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.os.Bundle;
import android.view.View;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import android.os.Handler;
import android.widget.FrameLayout;

public class InvisibleFragmentBase extends FragmentBase
{
    private static final long MIN_SPINNER_MS = 750L;
    protected FrameLayout mFrameLayout;
    private Handler mHandler;
    private long mLastShownTime;
    private MaterialProgressBar mProgressBar;
    protected View mTopLevelView;
    
    public InvisibleFragmentBase() {
        this.mHandler = new Handler();
        this.mLastShownTime = 0L;
    }
    
    static long access$002(final InvisibleFragmentBase invisibleFragmentBase, final long mLastShownTime) {
        return invisibleFragmentBase.mLastShownTime = mLastShownTime;
    }
    
    static MaterialProgressBar access$100(final InvisibleFragmentBase invisibleFragmentBase) {
        return invisibleFragmentBase.mProgressBar;
    }
    
    protected void doAfterTimeout(final Runnable runnable) {
        this.mHandler.postDelayed(runnable, Math.max(750L - (System.currentTimeMillis() - this.mLastShownTime), 0L));
    }
    
    @Override
    public void hideProgress() {
        this.doAfterTimeout(new Runnable(this) {
            final InvisibleFragmentBase this$0;
            
            @Override
            public void run() {
                InvisibleFragmentBase.access$002(this.this$0, 0L);
                ((ProgressBar)InvisibleFragmentBase.access$100(this.this$0)).setVisibility(8);
                this.this$0.mFrameLayout.setVisibility(8);
            }
        });
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        (this.mProgressBar = new MaterialProgressBar((Context)new ContextThemeWrapper(this.getContext(), this.getFlowParams().themeId))).setIndeterminate(true);
        ((ProgressBar)this.mProgressBar).setVisibility(8);
        final FrameLayout$LayoutParams frameLayout$LayoutParams = new FrameLayout$LayoutParams(-2, -2);
        frameLayout$LayoutParams.gravity = 17;
        (this.mFrameLayout = (FrameLayout)view.findViewById(R.id.invisible_frame)).addView((View)this.mProgressBar, (ViewGroup$LayoutParams)frameLayout$LayoutParams);
    }
    
    @Override
    public void showProgress(final int n) {
        if (((ProgressBar)this.mProgressBar).getVisibility() == 0) {
            this.mHandler.removeCallbacksAndMessages((Object)null);
            return;
        }
        this.mLastShownTime = System.currentTimeMillis();
        ((ProgressBar)this.mProgressBar).setVisibility(0);
    }
}
