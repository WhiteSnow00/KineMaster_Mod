// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.content.Context;
import androidx.annotation.Keep;
import android.widget.RelativeLayout;

@Keep
public abstract class AdNativeComponentView extends RelativeLayout implements AdComponentView
{
    protected AdComponentViewApi mAdComponentViewApi;
    private final AdComponentViewParentApi mAdComponentViewParentApi;
    
    public AdNativeComponentView(final Context context) {
        super(context);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() {
            final AdNativeComponentView a;
            
            @Override
            public void addView(final View view) {
                AdNativeComponentView.access$901(this.a, view);
            }
            
            @Override
            public void addView(final View view, final int n) {
                AdNativeComponentView.access$1001(this.a, view, n);
            }
            
            @Override
            public void addView(final View view, final int n, final int n2) {
                AdNativeComponentView.access$1201(this.a, view, n, n2);
            }
            
            @Override
            public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$801(this.a, view, n, viewGroup$LayoutParams);
            }
            
            @Override
            public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$1101(this.a, view, viewGroup$LayoutParams);
            }
            
            @Override
            public void bringChildToFront(final View view) {
                AdNativeComponentView.access$501(this.a, view);
            }
            
            @Override
            public void onAttachedToWindow() {
                AdNativeComponentView.access$301(this.a);
            }
            
            @Override
            public void onDetachedFromWindow() {
                AdNativeComponentView.access$401(this.a);
            }
            
            @Override
            public void onMeasure(final int n, final int n2) {
                AdNativeComponentView.access$101(this.a, n, n2);
            }
            
            @Override
            public void onVisibilityChanged(final View view, final int n) {
                AdNativeComponentView.access$701(this.a, view, n);
            }
            
            @Override
            public void onWindowFocusChanged(final boolean b) {
                AdNativeComponentView.access$601(this.a, b);
            }
            
            @Override
            public void setLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$001(this.a, viewGroup$LayoutParams);
            }
            
            @Override
            public void setMeasuredDimension(final int n, final int n2) {
                AdNativeComponentView.access$201(this.a, n, n2);
            }
        };
    }
    
    public AdNativeComponentView(final Context context, final AttributeSet set) {
        super(context, set);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() {
            final AdNativeComponentView a;
            
            @Override
            public void addView(final View view) {
                AdNativeComponentView.access$901(this.a, view);
            }
            
            @Override
            public void addView(final View view, final int n) {
                AdNativeComponentView.access$1001(this.a, view, n);
            }
            
            @Override
            public void addView(final View view, final int n, final int n2) {
                AdNativeComponentView.access$1201(this.a, view, n, n2);
            }
            
            @Override
            public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$801(this.a, view, n, viewGroup$LayoutParams);
            }
            
            @Override
            public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$1101(this.a, view, viewGroup$LayoutParams);
            }
            
            @Override
            public void bringChildToFront(final View view) {
                AdNativeComponentView.access$501(this.a, view);
            }
            
            @Override
            public void onAttachedToWindow() {
                AdNativeComponentView.access$301(this.a);
            }
            
            @Override
            public void onDetachedFromWindow() {
                AdNativeComponentView.access$401(this.a);
            }
            
            @Override
            public void onMeasure(final int n, final int n2) {
                AdNativeComponentView.access$101(this.a, n, n2);
            }
            
            @Override
            public void onVisibilityChanged(final View view, final int n) {
                AdNativeComponentView.access$701(this.a, view, n);
            }
            
            @Override
            public void onWindowFocusChanged(final boolean b) {
                AdNativeComponentView.access$601(this.a, b);
            }
            
            @Override
            public void setLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$001(this.a, viewGroup$LayoutParams);
            }
            
            @Override
            public void setMeasuredDimension(final int n, final int n2) {
                AdNativeComponentView.access$201(this.a, n, n2);
            }
        };
    }
    
    public AdNativeComponentView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() {
            final AdNativeComponentView a;
            
            @Override
            public void addView(final View view) {
                AdNativeComponentView.access$901(this.a, view);
            }
            
            @Override
            public void addView(final View view, final int n) {
                AdNativeComponentView.access$1001(this.a, view, n);
            }
            
            @Override
            public void addView(final View view, final int n, final int n2) {
                AdNativeComponentView.access$1201(this.a, view, n, n2);
            }
            
            @Override
            public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$801(this.a, view, n, viewGroup$LayoutParams);
            }
            
            @Override
            public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$1101(this.a, view, viewGroup$LayoutParams);
            }
            
            @Override
            public void bringChildToFront(final View view) {
                AdNativeComponentView.access$501(this.a, view);
            }
            
            @Override
            public void onAttachedToWindow() {
                AdNativeComponentView.access$301(this.a);
            }
            
            @Override
            public void onDetachedFromWindow() {
                AdNativeComponentView.access$401(this.a);
            }
            
            @Override
            public void onMeasure(final int n, final int n2) {
                AdNativeComponentView.access$101(this.a, n, n2);
            }
            
            @Override
            public void onVisibilityChanged(final View view, final int n) {
                AdNativeComponentView.access$701(this.a, view, n);
            }
            
            @Override
            public void onWindowFocusChanged(final boolean b) {
                AdNativeComponentView.access$601(this.a, b);
            }
            
            @Override
            public void setLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$001(this.a, viewGroup$LayoutParams);
            }
            
            @Override
            public void setMeasuredDimension(final int n, final int n2) {
                AdNativeComponentView.access$201(this.a, n, n2);
            }
        };
    }
    
    public AdNativeComponentView(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() {
            final AdNativeComponentView a;
            
            @Override
            public void addView(final View view) {
                AdNativeComponentView.access$901(this.a, view);
            }
            
            @Override
            public void addView(final View view, final int n) {
                AdNativeComponentView.access$1001(this.a, view, n);
            }
            
            @Override
            public void addView(final View view, final int n, final int n2) {
                AdNativeComponentView.access$1201(this.a, view, n, n2);
            }
            
            @Override
            public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$801(this.a, view, n, viewGroup$LayoutParams);
            }
            
            @Override
            public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$1101(this.a, view, viewGroup$LayoutParams);
            }
            
            @Override
            public void bringChildToFront(final View view) {
                AdNativeComponentView.access$501(this.a, view);
            }
            
            @Override
            public void onAttachedToWindow() {
                AdNativeComponentView.access$301(this.a);
            }
            
            @Override
            public void onDetachedFromWindow() {
                AdNativeComponentView.access$401(this.a);
            }
            
            @Override
            public void onMeasure(final int n, final int n2) {
                AdNativeComponentView.access$101(this.a, n, n2);
            }
            
            @Override
            public void onVisibilityChanged(final View view, final int n) {
                AdNativeComponentView.access$701(this.a, view, n);
            }
            
            @Override
            public void onWindowFocusChanged(final boolean b) {
                AdNativeComponentView.access$601(this.a, b);
            }
            
            @Override
            public void setLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                AdNativeComponentView.access$001(this.a, viewGroup$LayoutParams);
            }
            
            @Override
            public void setMeasuredDimension(final int n, final int n2) {
                AdNativeComponentView.access$201(this.a, n, n2);
            }
        };
    }
    
    static void access$001(final AdNativeComponentView adNativeComponentView, final ViewGroup$LayoutParams layoutParams) {
        adNativeComponentView.setLayoutParams(layoutParams);
    }
    
    static void access$1001(final AdNativeComponentView adNativeComponentView, final View view, final int n) {
        adNativeComponentView.addView(view, n);
    }
    
    static void access$101(final AdNativeComponentView adNativeComponentView, final int n, final int n2) {
        adNativeComponentView.onMeasure(n, n2);
    }
    
    static void access$1101(final AdNativeComponentView adNativeComponentView, final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        adNativeComponentView.addView(view, viewGroup$LayoutParams);
    }
    
    static void access$1201(final AdNativeComponentView adNativeComponentView, final View view, final int n, final int n2) {
        adNativeComponentView.addView(view, n, n2);
    }
    
    static void access$201(final AdNativeComponentView adNativeComponentView, final int n, final int n2) {
        adNativeComponentView.setMeasuredDimension(n, n2);
    }
    
    static void access$301(final AdNativeComponentView adNativeComponentView) {
        adNativeComponentView.onAttachedToWindow();
    }
    
    static void access$401(final AdNativeComponentView adNativeComponentView) {
        adNativeComponentView.onDetachedFromWindow();
    }
    
    static void access$501(final AdNativeComponentView adNativeComponentView, final View view) {
        adNativeComponentView.bringChildToFront(view);
    }
    
    static void access$601(final AdNativeComponentView adNativeComponentView, final boolean b) {
        adNativeComponentView.onWindowFocusChanged(b);
    }
    
    static void access$701(final AdNativeComponentView adNativeComponentView, final View view, final int n) {
        adNativeComponentView.onVisibilityChanged(view, n);
    }
    
    static void access$801(final AdNativeComponentView adNativeComponentView, final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        adNativeComponentView.addView(view, n, viewGroup$LayoutParams);
    }
    
    static void access$901(final AdNativeComponentView adNativeComponentView, final View view) {
        adNativeComponentView.addView(view);
    }
    
    public void addView(final View view) {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.addView(view);
        }
        else {
            super.addView(view);
        }
    }
    
    public void addView(final View view, final int n) {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.addView(view, n);
        }
        else {
            super.addView(view, n);
        }
    }
    
    public void addView(final View view, final int n, final int n2) {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.addView(view, n, n2);
        }
        else {
            super.addView(view, n, n2);
        }
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.addView(view, n, viewGroup$LayoutParams);
        }
        else {
            super.addView(view, n, viewGroup$LayoutParams);
        }
    }
    
    public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.addView(view, viewGroup$LayoutParams);
        }
        else {
            super.addView(view, viewGroup$LayoutParams);
        }
    }
    
    protected void attachAdComponentViewApi(final AdComponentViewApiProvider adComponentViewApiProvider) {
        if (DynamicLoaderFactory.isFallbackMode()) {
            return;
        }
        if (this.mAdComponentViewApi == null) {
            adComponentViewApiProvider.getAdComponentViewApi().onAttachedToView(this, this.mAdComponentViewParentApi);
            this.mAdComponentViewApi = adComponentViewApiProvider.getAdComponentViewApi();
            return;
        }
        throw new IllegalStateException("AdComponentViewApi can't be attached more then once.");
    }
    
    public void bringChildToFront(final View view) {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.bringChildToFront(view);
        }
        else {
            super.bringChildToFront(view);
        }
    }
    
    public abstract View getAdContentsView();
    
    protected void onAttachedToWindow() {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.onAttachedToWindow();
        }
        else {
            super.onAttachedToWindow();
        }
    }
    
    protected void onDetachedFromWindow() {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.onDetachedFromWindow();
        }
        else {
            super.onDetachedFromWindow();
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.onMeasure(n, n2);
        }
        else {
            super.onMeasure(n, n2);
        }
    }
    
    protected void onVisibilityChanged(final View view, final int n) {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.onVisibilityChanged(view, n);
        }
        else {
            super.onVisibilityChanged(view, n);
        }
    }
    
    public void onWindowFocusChanged(final boolean b) {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.onWindowFocusChanged(b);
        }
        else {
            super.onWindowFocusChanged(b);
        }
    }
    
    public void setLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        final AdComponentViewApi mAdComponentViewApi = this.mAdComponentViewApi;
        if (mAdComponentViewApi != null) {
            mAdComponentViewApi.setLayoutParams(viewGroup$LayoutParams);
        }
        else {
            super.setLayoutParams(viewGroup$LayoutParams);
        }
    }
}
