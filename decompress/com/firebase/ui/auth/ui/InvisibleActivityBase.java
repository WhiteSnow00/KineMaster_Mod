// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui;

import android.widget.ProgressBar;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.content.Context;
import android.view.ContextThemeWrapper;
import com.firebase.ui.auth.R;
import android.os.Bundle;
import android.content.Intent;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import android.os.Handler;

public class InvisibleActivityBase extends HelperActivityBase
{
    private static final long MIN_SPINNER_MS = 750L;
    private Handler mHandler;
    private long mLastShownTime;
    private MaterialProgressBar mProgressBar;
    
    public InvisibleActivityBase() {
        this.mHandler = new Handler();
        this.mLastShownTime = 0L;
    }
    
    static long access$002(final InvisibleActivityBase invisibleActivityBase, final long mLastShownTime) {
        return invisibleActivityBase.mLastShownTime = mLastShownTime;
    }
    
    static MaterialProgressBar access$100(final InvisibleActivityBase invisibleActivityBase) {
        return invisibleActivityBase.mProgressBar;
    }
    
    private void doAfterTimeout(final Runnable runnable) {
        this.mHandler.postDelayed(runnable, Math.max(750L - (System.currentTimeMillis() - this.mLastShownTime), 0L));
    }
    
    @Override
    public void finish(final int n, final Intent intent) {
        this.setResult(n, intent);
        this.doAfterTimeout(new Runnable(this) {
            final InvisibleActivityBase this$0;
            
            @Override
            public void run() {
                this.this$0.finish();
            }
        });
    }
    
    @Override
    public void hideProgress() {
        this.doAfterTimeout(new Runnable(this) {
            final InvisibleActivityBase this$0;
            
            @Override
            public void run() {
                InvisibleActivityBase.access$002(this.this$0, 0L);
                ((ProgressBar)InvisibleActivityBase.access$100(this.this$0)).setVisibility(8);
            }
        });
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.fui_activity_invisible);
        (this.mProgressBar = new MaterialProgressBar((Context)new ContextThemeWrapper((Context)this, this.getFlowParams().themeId))).setIndeterminate(true);
        ((ProgressBar)this.mProgressBar).setVisibility(8);
        final FrameLayout$LayoutParams frameLayout$LayoutParams = new FrameLayout$LayoutParams(-2, -2);
        frameLayout$LayoutParams.gravity = 17;
        this.findViewById(R.id.invisible_frame).addView((View)this.mProgressBar, (ViewGroup$LayoutParams)frameLayout$LayoutParams);
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
